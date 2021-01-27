package com.story.backend.cart.controller;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.service.CartService;
import com.story.backend.user.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipal;
import java.util.UUID;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/add")
    public ResponseEntity<Long> addToCart(@RequestBody AddProductToCartRequest addProductToCartRequest, @AuthenticationPrincipal UserPrincipal userPrincipal) {
//        User user = (User)userPrincipal;

        cartService.addProductToCart(addProductToCartRequest, userPrincipal);

        return new ResponseEntity<>(HttpStatus.CREATED);

    }

}
