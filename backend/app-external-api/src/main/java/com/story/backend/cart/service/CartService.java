package com.story.backend.cart.service;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.repository.CartRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Optional;

@Validated
@Service
public class CartService {

    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public boolean addProductToCart(@Valid AddProductToCartRequest addProductToCartRequest) {
        Optional<Cart> cart = cartRepository.findByCartId(addProductToCartRequest.getCartId());

        if (cart.isPresent()) {
            System.out.println(cart.get());
            System.out.println("got cart");
        } else {
            System.out.println(cart);
        }

        System.out.println(addProductToCartRequest);

        return true;
    }

}
