package com.story.backend.user.controller;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.entity.AuthUserDetails;
import com.story.backend.user.entity.User;
import com.story.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<CommonResponse> registerUser(@RequestBody UserRegistrationRequest userRegistrationRequest) {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.CREATED.value(), null, userService.registerUser(userRegistrationRequest)), HttpStatus.CREATED);
    }

    @GetMapping("/{userId}/addresses")
    public ResponseEntity<CommonResponse> getAddressListOfUser(@PathVariable UUID userId, @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.OK.value(), null, userService.getAddressListOfUser(userId, userDetails)), HttpStatus.OK);
    }

    @GetMapping("/{userId}/cartItems")
    public ResponseEntity<CommonResponse> getCartItemListOfUser(@PathVariable UUID userId, @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{userId}/orders")
    public ResponseEntity<CommonResponse> getOrderListOfUser(@PathVariable UUID userId, @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }

}
