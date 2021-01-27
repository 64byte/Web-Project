package com.story.backend.user.service;

import com.story.backend.user.exception.AlreadyRegisteredUserException;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UUID registerUser(@Valid UserRegistrationRequest userRegistrationRequest) {

        if (isAlreadyRegisteredUser(userRegistrationRequest.getEmail())) {
            throw new AlreadyRegisteredUserException("is already user");
        }

        userRegistrationRequest.encodePassword(passwordEncoder);
        return userRepository.save(userRegistrationRequest.toEntity()).getUserId();
    }

    private boolean isAlreadyRegisteredUser(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
