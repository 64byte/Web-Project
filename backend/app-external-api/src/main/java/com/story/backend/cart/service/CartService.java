package com.story.backend.cart.service;

import com.story.backend.cart.dto.AddProductToCartRequest;
import com.story.backend.cart.dto.CartInfoResponse;
import com.story.backend.cart.entity.Cart;
import com.story.backend.cart.exception.FailedAddToCartException;
import com.story.backend.cart.exception.NotFoundCartException;
import com.story.backend.cart.exception.OutOfStockException;
import com.story.backend.cart.repository.CartRepository;
import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.exception.NotFoundProductSkuException;
import com.story.backend.product.service.ProductSkuService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
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

    /**
     * CartId를 이용해서 카트 정보를 가져온다.
     * @param cartId
     * @return
     */
    public CartInfoResponse getCartInfoById(@Valid @NotNull UUID cartId) throws NotFoundCartException {
        Cart cart = cartRepository.findByCartId(cartId)
                .orElseThrow(NotFoundCartException::new);

        return CartInfoResponse.of(cart);
    }

    /**
     * cart에 아이템을 담는다.
     * cartId가 없는 경우에는 cart를 만들고 그 안에 아이템을 담은 후(cartItemService를 통해)에 cartId를 반환한다.
     * cartId가 있는 경우에는 해당 카트에 아이템을 담는다.
     * 요청된 skuId가 없거나, 재고가 부족한 경우 예외를 던진다
     * @param addProductToCartRequest ( (option)cartId, skuId, quantity )
     * @param userDetails
     * @return
     */
    @Transactional
    public UUID addProductToCart(@Valid AddProductToCartRequest addProductToCartRequest, UserDetails userDetails) {
        Cart cart = cartRepository.findByCartId(addProductToCartRequest.getCartId())
                .orElseGet(() -> Cart.builder().build());

        ProductSku productSku = productSkuService.getProductSkuBySkuId(addProductToCartRequest.getSkuId())
                 .orElseThrow(NotFoundProductSkuException::new);

        if (productSku.isExceedRequestAddQuantity(addProductToCartRequest.getQuantity())) {
            throw new OutOfStockException();
        }

        cartRepository.save(cart);

        if (!cartItemService.updateCartItem(cart, productSku, addProductToCartRequest.getQuantity())) {
            log.error("cart Id {" + cart.getCartId() + "} is failed to add product sku {" + productSku.getSkuId() + "}.");
            throw new FailedAddToCartException();
        }

        return cart.getCartId();
    }

    /**
     * (내부 로직용) cartId를 이용해서 Cart를 얻어온다.
     * @param cartId
     * @return
     */
    public Optional<Cart> getCartByCartId(@Valid @NotNull UUID cartId) {
        return cartRepository.findByCartId(cartId);
    }

    @Transactional
    public void emptyCartItems(@Valid @NotNull UUID cartId) {
        Cart cart = cartRepository.findByCartId(cartId)
                .orElseThrow();

        cart.getCartItems().clear();

        cartRepository.save(cart);
    }
}
