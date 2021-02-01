package com.story.backend.payment.controller;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.payment.dto.PaymentResultRequest;
import com.story.backend.payment.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private PaymentService paymentService;

    @PostMapping("/return")
    public ResponseEntity<CommonResponse> successPayment(@RequestBody PaymentResultRequest paymentResultRequest) {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
