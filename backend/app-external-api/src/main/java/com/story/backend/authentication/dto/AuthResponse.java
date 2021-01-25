package com.story.backend.authentication.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AuthResponse implements Serializable {

    private String token;

    public static AuthResponse of(String token) {
        AuthResponse authResponse = new AuthResponse();
        authResponse.token = token;
        return authResponse;
    }

}
