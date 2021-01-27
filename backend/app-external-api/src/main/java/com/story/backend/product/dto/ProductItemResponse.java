package com.story.backend.product.dto;

import com.story.backend.product.entity.Product;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductItemResponse implements Serializable {

    private static final long serialVersionUID = -1332662125224900021L;

    private UUID productId;

    private String name;

    private String styleCode;

    private String description;

    public static ProductItemResponse of(Product product) {
        ProductItemResponse productItemResponse = new ProductItemResponse();
        productItemResponse.productId = product.getProductId();
        productItemResponse.name = product.getName();
        productItemResponse.styleCode = product.getStyleCode();
        productItemResponse.description = product.getDescription();

        return productItemResponse;
    }

}
