package com.story.backend.cart.dto;

import com.sun.istack.Nullable;
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
@Setter
@ToString
public class AddProductToCartRequest {

    @NotNull
    UUID skuId;
    
    @Nullable
    UUID cartId;

    @Min(1)
    long quantity;

    public boolean isEmptyCartId() {
        return cartId == null;
    }

}
