package com.story.backend.cart.dto;

import com.story.backend.cart.entity.Cart;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
public class CartInfoResponse implements Serializable {

    private static final long serialVersionUID = 1696876646473871720L;

    private UUID cartId;

    private long totalQuantity;

    private List<CartItemResponse> items;

    public static CartInfoResponse of(Cart cart) {
        CartInfoResponse cartInfoResponse = new CartInfoResponse();

        cartInfoResponse.cartId = cart.getCartId();
        cartInfoResponse.totalQuantity = cart.getTotalQuantity();
        cartInfoResponse.items = cart.getCartItems().stream().map(CartItemResponse::of).collect(Collectors.toList());

        return cartInfoResponse;
    }

}
