package com.story.backend.authentication.dto;

import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AuthRequest {

    @Email
    private String email;

    @NotBlank
    private String password;

    @Builder
    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
