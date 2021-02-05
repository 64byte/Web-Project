package com.story.backend.payment.service;

import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.service.CartService;
import com.story.backend.order.dto.GenerateOrderRequest;
import com.story.backend.order.service.OrderService;
import com.story.backend.payment.dto.PaymentResultRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class PaymentService {

    private final CartService cartService;

    private final OrderService orderService;

    private final IamportApiService paymentIamportApiService;

    public PaymentService(CartService cartService, OrderService orderService, IamportApiService paymentIamportApiService) {
        this.cartService = cartService;
        this.orderService = orderService;
        this.paymentIamportApiService = paymentIamportApiService;
    }

    /**
     * Iamport에서 결제되고 반환된 rsp (imp uid, merchant uid, ...)를 해당 서비스로 넘어온다.
     * 이를 이용해서 변조된 결제인지 확인하고 오더를 생성한다.
     * @param paymentResultRequest
     * @return
     */
    @Transactional
    public UUID verifyPaymentAndGenerateOrder(@Valid PaymentResultRequest paymentResultRequest) {
        // 예외 반환 시에 변조된 주문
        if (!paymentIamportApiService.verifyPaymentByMerchantId()) {
            throw new RuntimeException();
        }

        // 재고 감소 처리, 재고 부족시 에외


        // 카트 처리
        UUID cartId = paymentResultRequest.parseCartIdFromMerchantId();
        cartService.emptyCartItems(cartId);

        // 오더 생성
        return orderService.generateOrder(new GenerateOrderRequest("impUid", "merchantUid", "card", "결제 완료", 100, "10101"));
    }

}
