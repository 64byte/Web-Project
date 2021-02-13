package com.story.backend.payment.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IamportApiService {

    private final RestTemplate restTemplate;

    public IamportApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean verifyPaymentByMerchantId() {
        return true;
    }

    public boolean cancelPaymentByMerchantId() {
        return true;
    }

}
