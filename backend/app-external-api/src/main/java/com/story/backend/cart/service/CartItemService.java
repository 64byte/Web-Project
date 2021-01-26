package com.story.backend.cart.service;

import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.entity.CartItem;
import com.story.backend.cart.repository.CartItemRepository;
import com.story.backend.product.entity.ProductSku;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Transactional
    public boolean updateCartItem(Cart cart, ProductSku productsku, long quantity) {

        CartItem cartItem = cartItemRepository.findByCartIdAndProductSkuId(cart.getId(), productsku.getId())
                .orElseGet(() -> new CartItem(cart, productsku, 0));

        cartItem.addQuantity(quantity);

        cartItemRepository.save(cartItem);
        return true;
    }

}
