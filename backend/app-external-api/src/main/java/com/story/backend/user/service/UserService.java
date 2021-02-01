package com.story.backend.user.service;

import com.story.backend.address.entity.Address;
import com.story.backend.user.dto.UserAddressResponse;
import com.story.backend.user.dto.UserInfoResponse;
import com.story.backend.user.dto.UserUpdatePasswordRequest;
import com.story.backend.user.entity.AuthUserDetails;
import com.story.backend.user.entity.User;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.nio.file.attribute.UserPrincipal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 인증된 정보를 이용하여 해당 유저의 정보를 가져옵니다.
     * (email, fullName, phoneNum)
     * @param userDetails
     * @return
     */
    public UserInfoResponse getUserInfoByPrincipal(@Valid @NotNull UserDetails userDetails) {
        AuthUserDetails authUserDetails = (AuthUserDetails) userDetails;
        return UserInfoResponse.of(authUserDetails.getUser());
    }

    /**
     * 신규 유저를 등록합니다.
     * (email, password, fullName, phoneNum)
     * @param userRegistrationRequest
     * @return
     */
    public UUID registerUser(@Valid UserRegistrationRequest userRegistrationRequest) {

        if (isAlreadyRegisteredUser(userRegistrationRequest.getEmail())) {
            throw new AlreadyRegisteredUserException("");
        }

        userRegistrationRequest.encodePassword(passwordEncoder);
        return userRepository.save(userRegistrationRequest.toEntity()).getUserId();
    }

    /**
     * 유저의 비밀번호를 변경합니다.
     * 기존 비밀번호와 새로운 비밀번호를 받습니다.
     * 기존 비밀번호가 틀릴 경우, 예외를 던집니다.
     * @param userUpdatePasswordRequest
     * @param userDetails
     * @return
     */
    public boolean updateUserPassword(@Valid UserUpdatePasswordRequest userUpdatePasswordRequest, @Valid @NotNull UserDetails userDetails) {
        AuthUserDetails authUserDetails = (AuthUserDetails) userDetails;
        User user = authUserDetails.getUser();

        userUpdatePasswordRequest.encodePasswordInfo(passwordEncoder);

        if (!user.isSamePasswordWith(userUpdatePasswordRequest.getPassword())) {
            throw new RuntimeException();
        }

        user.setPassword(userUpdatePasswordRequest.getNewPassword());

        userRepository.save(user);
        return true;
    }

    /**
     * 인증된 정보를 이용하여 해당 유저의 등록된 주소 정보를 가져옵니다.
     * @param userDetails
     * @return
     */
    public List<UserAddressResponse> getAddressListOfUser(@Valid @NotNull UserDetails userDetails) {
        AuthUserDetails authUserDetails = (AuthUserDetails)userDetails;

        return authUserDetails.getAddresses().stream().map(UserAddressResponse::of).collect(Collectors.toList());
    }

    /**
     * email을 이용해 이미 등록된 유저인지 판별합니다.
     * @param email
     * @return
     */
    private boolean isAlreadyRegisteredUser(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
