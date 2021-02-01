package com.story.backend.user.dto;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Validated
public class UserUpdatePasswordRequest {

    @Min(1)
    private String password;

    @Min(1)
    private String newPassword;

    public void encodePasswordInfo(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(password);
        this.newPassword = passwordEncoder.encode(newPassword);
    }
}
