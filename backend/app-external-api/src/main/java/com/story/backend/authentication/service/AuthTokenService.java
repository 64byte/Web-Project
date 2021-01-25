package com.story.backend.authentication.service;

import com.story.backend.authentication.entity.AuthToken;
import com.story.backend.authentication.provider.JwtProvider;
import org.springframework.stereotype.Service;

@Service
public class AuthTokenService {

    private final JwtProvider jwtProvider;

    public AuthTokenService(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    /**
     * controller에서 인증이 완료된 유저에게 토큰을 발행한다.
     * 이미 발행되었다면 기존 토큰을 반환하고, 없다면 새롭게 생성하여 반환한다.
     * // 임시로 새로운 토큰만 발행
     * @param email
     * @return
     */
    public String issueToken(String email) {
        return jwtProvider.generateToken(email);
    }
}
