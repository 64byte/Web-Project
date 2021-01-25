package com.story.backend.user.controller;

import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.entity.User;
import com.story.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<Long> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        try {
            userService.registerUser(userRegistrationRequest);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (Exception ex) {
            return new ResponseEntity<Long>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/carts/{cartId}")
    public ResponseEntity<Long> addToUserCart(@PathVariable UUID cartId, @AuthenticationPrincipal UserPrincipal userPrincipal) {

        System.out.println("cartId " + cartId + " userPrin: " + (userPrincipal));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
