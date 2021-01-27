package com.story.backend.authentication.service;

import com.story.backend.authentication.dto.AuthRequest;
import com.story.backend.authentication.dto.AuthResponse;
import com.story.backend.authentication.entity.AuthToken;
import com.story.backend.authentication.provider.JwtProvider;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class AuthTokenService {

    private final JwtProvider jwtProvider;

    private final AuthenticationManager authenticationManager;

    public AuthTokenService(JwtProvider jwtProvider, AuthenticationManager authenticationManager) {
        this.jwtProvider = jwtProvider;
        this.authenticationManager = authenticationManager;
    }

    /**
     * controller에서 인증이 완료된 유저에게 토큰을 발행한다.
     * 이미 발행되었다면 기존 토큰을 반환하고, 없다면 새롭게 생성하여 반환한다.
     * // 임시로 새로운 토큰만 발행
     * @param authRequest
     * @return
     */
    public AuthResponse authAndIssueToken(@Valid AuthRequest authRequest) {
        String email = authRequest.getEmail();
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, authRequest.getPassword()));
        return AuthResponse.of(jwtProvider.generateToken(email));
    }
}
