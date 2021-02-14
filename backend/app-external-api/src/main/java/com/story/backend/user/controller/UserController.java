package com.story.backend.user.controller;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.user.dto.UserRegistrationRequest;
import com.story.backend.user.dto.UserUpdatePasswordRequest;
import com.story.backend.user.entity.AuthUserDetails;
import com.story.backend.user.entity.User;
import com.story.backend.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @GetMapping
    public ResponseEntity<CommonResponse> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.OK.value(), null, userService.getUserInfoByPrincipal(userDetails)), HttpStatus.OK);
    }

    @PutMapping("/password")
    public ResponseEntity<CommonResponse> updateUserPassword(UserUpdatePasswordRequest userUpdatePasswordRequest, @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.OK.value(), null, userService.updateUserPassword(userUpdatePasswordRequest, userDetails)), HttpStatus.OK);
    }

    @GetMapping("/addresses")
    public ResponseEntity<CommonResponse> getAddressListOfUser(@AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.OK.value(), null, userService.getAddressListOfUser(userDetails)), HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<CommonResponse> getOrderListOfUser(@AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(CommonResponse.builder().build(), HttpStatus.BAD_REQUEST);
    }
}
