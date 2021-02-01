package com.story.backend.product.service;

import com.story.backend.product.dto.ProductItemResponse;
import com.story.backend.product.dto.ProductSkuResponse;
import com.story.backend.product.entity.Product;
import com.story.backend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * product Id를 이용하여 product의 기본 정보를 반환합니다.
     * (productId, name, styleCode, description)
     * @param productId
     * @return
     */
    public ProductItemResponse getProductById(@Valid @NotNull UUID productId) {
        return ProductItemResponse.of(productRepository.findByProductId(productId).orElseThrow());
    }

    /**
     * productId에 연결되는 product Sku 정보를 가져옵니다.
     * product sku의 경우에는 (sku Id, quantity)
     * @param productId
     * @return
     */
    public List<ProductSkuResponse> getRelatedProductSkusByProductId(@Valid @NotNull UUID productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow();

        return product.getProductSkus().stream().map(ProductSkuResponse::of).collect(Collectors.toList());
    }

}
