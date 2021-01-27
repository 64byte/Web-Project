package com.story.backend.authentication.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 4059073452181191584L;

    private String token;

    public static AuthResponse of(String token) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.token = token;
        return authResponse;
    }

}
