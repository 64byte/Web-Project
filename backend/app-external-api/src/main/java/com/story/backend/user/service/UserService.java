package com.story.backend.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

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
        userRegistrationRequest.encodePassword(passwordEncoder.encode(userRegistrationRequest.getPassword()));
        return userRepository.save(userRegistrationRequest.toEntity()).getUserId();
    }

}
