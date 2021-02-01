package com.story.backend.cart.dto;

import com.story.backend.cart.entity.CartItem;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItemResponse implements Serializable {

    private static final long serialVersionUID = -384740049476858877L;

    private UUID skuId;

    private long quantity;


    public static CartItemResponse of(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();

        cartItemResponse.skuId = cartItem.getProductSku().getSkuId();
        cartItemResponse.quantity = cartItem.getQuantity();

        return cartItemResponse;
    }

}
