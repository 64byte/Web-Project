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

    /**
     * Iamport 결제 완료시 호출되는 endpoint
     * frontend -> IAMPORT -> PG -> IAMPORT -> /api/payments/results
     * @param paymentResultRequest
     * @return
     */
    @PostMapping("/results")
    public ResponseEntity<CommonResponse> returnPayment(@RequestBody PaymentResultRequest paymentResultRequest) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.CREATED.value(), null, paymentService.verifyPaymentAndGenerateOrder(paymentResultRequest)), HttpStatus.CREATED);
    }
}
