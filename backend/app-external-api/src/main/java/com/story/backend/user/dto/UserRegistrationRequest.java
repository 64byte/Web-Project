package com.story.backend.user.dto;

import lombok.Getter;
import com.story.backend.user.entity.User;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Validated
public class UserRegistrationRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    public void encodePassword(String password) {
        this.password = password;
    }

    public User toEntity() {
        return new User(email, password);
    }

}
