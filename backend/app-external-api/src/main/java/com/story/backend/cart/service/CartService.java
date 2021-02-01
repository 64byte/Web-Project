package com.story.backend.cart.service;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.dto.CartInfoResponse;
import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.repository.CartRepository;
import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.service.ProductSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Validated
@Slf4j
@Service
public class CartService {

    private final CartRepository cartRepository;

    private final CartItemService cartItemService;

    private final ProductSkuService productSkuService;

    public CartService(CartRepository cartRepository, CartItemService cartItemService, ProductSkuService productSkuService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productSkuService = productSkuService;
    }

    public CartInfoResponse getCartInfoById(@Valid @NotNull UUID cartId) {
        Cart cart = cartRepository.findByCartId(cartId)
                .orElseThrow();

        return CartInfoResponse.of(cart);
    }

    @Transactional
    public UUID addProductToCart(@Valid AddProductToCartRequest addProductToCartRequest, UserDetails userDetails) {
        Cart cart = cartRepository.findByCartId(addProductToCartRequest.getCartId())
                .orElseGet(() -> Cart.builder().build());

        ProductSku productSku = productSkuService.getProductSkuBySkuId(addProductToCartRequest.getSkuId())
                 .orElseThrow(RuntimeException::new);

        if (productSku.isExceedQuantity(addProductToCartRequest.getQuantity())) {
            throw new RuntimeException();
        }

        if (!cartItemService.updateCartItem(cart, productSku, addProductToCartRequest.getQuantity())) {
            log.error("cart Id {" + cart.getCartId() + "} is failed to add product sku {" + productSku.getSkuId() + "}.");
            throw new RuntimeException();
        }

        return cart.getCartId();
    }

}
