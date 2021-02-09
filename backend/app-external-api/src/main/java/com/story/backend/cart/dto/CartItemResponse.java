package com.story.backend.cart.dto;

import com.story.backend.cart.entity.CartItem;
import com.story.backend.product.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CartItemResponse implements Serializable {

    private static final long serialVersionUID = -384740049476858877L;

    private String name;

    private String styleCode;

    private long price;

    private String currency;

    private UUID skuId;

    private long quantity;

    public static CartItemResponse of(CartItem cartItem) {
        CartItemResponse cartItemResponse = new CartItemResponse();

        Product productOfSku = cartItem.getProductSku().getProduct();

        cartItemResponse.name = productOfSku.getName();
        cartItemResponse.styleCode = productOfSku.getStyleCode();
        cartItemResponse.price = productOfSku.getPrice();
        cartItemResponse.currency = productOfSku.getCurrency();
        cartItemResponse.skuId = cartItem.getProductSku().getSkuId();
        cartItemResponse.quantity = cartItem.getQuantity();

        return cartItemResponse;
    }

}
