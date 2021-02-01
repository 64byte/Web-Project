package com.story.backend.payment.service;

import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.service.CartService;
import com.story.backend.payment.dto.PaymentResultRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.UUID;

@Service
public class PaymentService {

    private final CartService cartService;

    public PaymentService(CartService cartService) {
        this.cartService = cartService;
    }

    @Transactional
    public UUID verifyAndGenerateOrder(@Valid PaymentResultRequest paymentResultRequest) {
        UUID cartId = paymentResultRequest.parseCartIdFromMerchantId();

        // 예외 반환 시에 변조된 주문
        Cart cart = cartService.getCartByCartId(cartId)
                .orElseThrow();

        return null;
    }

}
