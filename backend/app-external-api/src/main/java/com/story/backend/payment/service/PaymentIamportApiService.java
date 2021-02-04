package com.story.backend.payment.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentIamportApiService {

    public boolean verifyPaymentByMerchantId() {
        return true;
    }

    public boolean cancelPaymentByMerchantId() {
        return true;
    }

}
