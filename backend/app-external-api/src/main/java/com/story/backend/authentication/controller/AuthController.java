package com.story.backend.authentication.controller;

import com.story.backend.authentication.dto.AuthRequest;
import com.story.backend.authentication.dto.AuthResponse;
import com.story.backend.authentication.service.AuthTokenService;
import com.story.backend.common.dto.CommonResponse;
import com.story.backend.user.controller.UserController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthTokenService authTokenService;

    public AuthController(AuthTokenService authTokenService) {
        this.authTokenService = authTokenService;
    }

    @PostMapping
    public ResponseEntity<CommonResponse> authUserAndGetToken(@RequestBody AuthRequest authRequest) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.CREATED.value(), null, authTokenService.authAndIssueToken(authRequest)), HttpStatus.CREATED);
    }

}
