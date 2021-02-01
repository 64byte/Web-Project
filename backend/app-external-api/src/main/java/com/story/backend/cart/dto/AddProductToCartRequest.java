package com.story.backend.cart.dto;

import com.sun.istack.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
public class AddProductToCartRequest {
  
    @Nullable
    private UUID cartId;

    @NotNull
    private UUID skuId;

    @Min(1)
    private long quantity;

    @Builder
    public AddProductToCartRequest(UUID cartId, UUID skuId, long quantity) {
        this.cartId = cartId;
        this.skuId = skuId;
        this.quantity = quantity;
    }
}
