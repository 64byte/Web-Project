package com.story.backend.authentication.entity;

import lombok.*;
import javax.persistence.Id;

@Getter
public class AuthToken {
    @Id
    private String id;

    private String email;

    private String token;

    @Builder
    public AuthToken(String email, String token) {
        this.email = email;
        this.token = token;
    }

}
