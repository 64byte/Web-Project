package com.story.backend.payment.service;

import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.service.CartService;
import com.story.backend.order.service.OrderService;
import com.story.backend.payment.dto.PaymentResultRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Service
public class PaymentService {

    private final CartService cartService;

    private final OrderService orderService;

    private final PaymentIamportApiService paymentIamportApiService;

    public PaymentService(CartService cartService, OrderService orderService, PaymentIamportApiService paymentIamportApiService) {
        this.cartService = cartService;
        this.orderService = orderService;
        this.paymentIamportApiService = paymentIamportApiService;
    }

    @Transactional
    public UUID verifyAndGenerateOrder(@Valid PaymentResultRequest paymentResultRequest) {
        // 예외 반환 시에 변조된 주문
        if (!paymentIamportApiService.verifyPaymentByMerchantId()) {
            throw new RuntimeException();
        }

        UUID cartId = paymentResultRequest.parseCartIdFromMerchantId();
        Cart cart = cartService.getCartByCartId(cartId)
                .orElseThrow();

        return null;
    }

}
