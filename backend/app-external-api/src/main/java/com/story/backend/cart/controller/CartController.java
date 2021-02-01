package com.story.backend.cart.controller;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.service.CartService;
import com.story.backend.common.dto.CommonResponse;
import com.story.backend.user.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/{cartId}")
    public ResponseEntity<CommonResponse> getCartInfoById(@PathVariable UUID cartId) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.OK.value(), "null", cartService.getCartInfoById(cartId)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CommonResponse> addToCart(@RequestBody AddProductToCartRequest addProductToCartRequest, @AuthenticationPrincipal UserDetails userDetails) {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.CREATED.value(), "null", cartService.addProductToCart(addProductToCartRequest, userDetails)),
                HttpStatus.CREATED);
    }



}
