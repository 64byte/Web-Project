package com.story.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AppExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppExternalApiApplication.class, args);
    }
}