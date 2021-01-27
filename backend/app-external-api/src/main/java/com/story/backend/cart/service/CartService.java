package com.story.backend.cart.service;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.entity.CartItem;
import com.story.backend.cart.repository.CartItemRepository;
import com.story.backend.cart.repository.CartRepository;
import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.service.ProductSkuService;
import com.story.backend.user.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.nio.file.attribute.UserPrincipal;
import java.util.Optional;

@Validated
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


    @Transactional
    public boolean addProductToCart(@Valid AddProductToCartRequest addProductToCartRequest, UserPrincipal userPrincipal) {
        Cart cart = cartRepository.findByCartId(addProductToCartRequest.getCartId())
                .orElseGet(() -> Cart.builder().build());

        ProductSku productSku = productSkuService.getProductSkuBySkuId(addProductToCartRequest.getSkuId())
                 .orElseThrow(RuntimeException::new);

        if (productSku.getQuantity() < addProductToCartRequest.getQuantity()) {
            throw new RuntimeException();
        }

        return cartItemService.updateCartItem(cart, productSku, addProductToCartRequest.getQuantity());
    }

}
