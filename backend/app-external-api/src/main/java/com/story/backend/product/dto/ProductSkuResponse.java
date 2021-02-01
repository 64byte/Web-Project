package com.story.backend.product.dto;

import com.story.backend.product.entity.ProductSku;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductSkuResponse implements Serializable {

    private static final long serialVersionUID = -2166975866185689895L;

    private UUID skuId;

    private long quantity;

    public static ProductSkuResponse of(ProductSku productSku) {
        ProductSkuResponse productSkuResponse = new ProductSkuResponse();
        productSkuResponse.skuId = productSku.getSkuId();
        productSkuResponse.quantity = productSku.getQuantity();
        return productSkuResponse;
    }

}
