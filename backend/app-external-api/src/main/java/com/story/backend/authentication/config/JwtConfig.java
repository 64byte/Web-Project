package com.story.backend.authentication.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class JwtConfig {

    private static String secret;

    private static long termOfExpiration;

    @Value("${app.security.jwt.secret}")
    public void setSecret(String value) {
        secret = value;
    }

    @Value("${app.security.jwt.term-of-expiration}")
    public void setTermOfExpiration(long value) {
        termOfExpiration = value;
    }

    public static String getSecret() {
        return secret;
    }

    public static long getTermOfExpiration() {
        return termOfExpiration;
    }

}
