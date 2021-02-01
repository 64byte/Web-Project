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

    public ProductItemResponse getProductById(@Valid @NotNull UUID productId) {
        return ProductItemResponse.of(productRepository.findByProductId(productId).orElseThrow());
    }

    public List<ProductSkuResponse> getRelatedProductSkusByProductId(@Valid @NotNull UUID productId) {
        Product product = productRepository.findByProductId(productId).orElseThrow();

        return product.getProductSkus().stream().map(ProductSkuResponse::of).collect(Collectors.toList());
    }

}
