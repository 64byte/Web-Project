package com.story.backend.payment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
public class IamportAuthTokenRequest {

    private static String imp_key;

    private static String imp_secret;

    @Value("${app.payment.iamport.api-key}")
    public static void setImp_key(String value) {
        imp_key = value;
    }

    @Value("${app.payment.iamport.api-secret}")
    public static void setImp_secret(String value) {
        imp_secret = value;
    }
}
