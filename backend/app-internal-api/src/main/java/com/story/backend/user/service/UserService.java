package com.story.backend.user.service;

import com.story.backend.user.entity.User;
import com.story.backend.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUserList() {
        return userRepository.findAll();
    }

    public Optional<User> getUserEntityById(long id) {
        return userRepository.findById(id);
    }

}
