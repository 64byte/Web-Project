package com.story.backend.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Value("${app.payment.iamport.api-endpoint}")
    private String iamportApiEndPoint;

    private final RestTemplateBuilder restTemplateBuilder;

    public RestTemplateConfig(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Bean
    public RestTemplate iamportTemplate() {
        return restTemplateBuilder.rootUri(iamportApiEndPoint)
                .build();
    }
}
