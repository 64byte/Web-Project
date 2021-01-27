package com.story.backend.user.service;

import com.story.backend.address.entity.Address;
import com.story.backend.user.dto.UserAddressResponse;
import com.story.backend.user.entity.AuthUserDetails;
import com.story.backend.user.entity.User;
import com.story.backend.user.exception.AlreadyRegisteredUserException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
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
     *
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
     *
     * @param userId
     * @param userDetails
     * @return
     */
    public List<UserAddressResponse> getAddressListOfUser(@Valid @NotNull UUID userId, @Valid @NotNull UserDetails userDetails) {
        AuthUserDetails authUserDetails = (AuthUserDetails)userDetails;

        if (!authUserDetails.isEqualOfUserId(userId)) {
            throw new BadCredentialsException("");
        }

        return authUserDetails.getAddresses().stream().map(UserAddressResponse::of).collect(Collectors.toList());
    }

    /**
     *
     * @param email
     * @return
     */
    private boolean isAlreadyRegisteredUser(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
