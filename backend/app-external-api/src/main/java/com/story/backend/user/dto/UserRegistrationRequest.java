package com.story.backend.user.dto;

import lombok.Getter;
import com.story.backend.user.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Validated
public class UserRegistrationRequest {

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @NotBlank
    private String phoneNum;

    public void encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
    }

    public User toEntity() {
        return new User(email, password, fullName, phoneNum);
    }

}
