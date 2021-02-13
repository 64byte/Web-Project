package com.story.backend.cart.service;

import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.entity.CartItem;
import com.story.backend.cart.repository.CartItemRepository;
import com.story.backend.product.entity.ProductSku;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    /**
     * (내부 로직용) cart를 이용해 cart Item List를 가져온다
     * @param cart
     * @return
     */
    public List<CartItem> getCartItemById(@Valid @NotNull Cart cart) {
        return cartItemRepository.findCartItemsByCartId(cart.getId());
    }

    /**
     * 카트에 아이템을 추가합니다. (카트 아이템 튜플을 하나 추가)
     * (cart, productSku)를 추가합니다, 이미 존재할 경우 수량을 1개 증가시킵니다.
     *
     * @param cart
     * @param productsku
     * @param quantity
     * @return
     */
    public boolean updateCartItem(@Valid @NotNull Cart cart, @Valid @NotNull ProductSku productsku, @Valid @Min(1) long quantity) {

        CartItem cartItem = cartItemRepository.findByCartIdAndProductSkuId(cart.getId(), productsku.getId())
                .orElseGet(() -> new CartItem(cart, productsku, 0));

        cartItem.addQuantity(quantity);

        cartItemRepository.save(cartItem);
        return true;
    }

    /**
     * cartId와 일치하는 cartItem을 제거합니다. (카트 아이템을 비우는 것)
     *
     * @param cart
     */
    @Transactional
    public void remoteCartItemByCart(@Valid @NotNull Cart cart) {
        List<CartItem> cartItems = cartItemRepository.findCartItemsByCartId(cart.getId());

        cartItemRepository.deleteInBatch(cartItems);
    }

    /**
     * (cartId, productSkuId)와 일치하는 cartItem을 제거합니다. (수량 증감이 아닌 담겨있는 아이템을 제거)
     *
     * @param cart
     * @param productSku
     */
    public void removeCartItemByCartAndProductSku(@Valid @NotNull Cart cart, @Valid @NotNull ProductSku productSku) {
        CartItem cartItem = cartItemRepository.findByCartIdAndProductSkuId(cart.getId(), productSku.getId())
                .orElseThrow();

        cartItemRepository.delete(cartItem);
    }

}
