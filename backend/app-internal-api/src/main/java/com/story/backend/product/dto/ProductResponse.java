package com.story.backend.product.dto;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.product.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ProductResponse {

    private long id;

    private UUID productId;

    private String name;

    public static ProductResponse of(long id, UUID productId, String name) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.id = id;
        productResponse.productId = productId;
        productResponse.name = name;
        return productResponse;
    }

    public static ProductResponse of(Product product) {
        ProductResponse productResponse = new ProductResponse();
        productResponse.id = product.getId();
        productResponse.productId = product.getProductId();
        productResponse.name = product.getName();
        return productResponse;
    }
}
