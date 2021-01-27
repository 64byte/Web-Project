package com.story.backend.product.service;

import com.story.backend.product.dto.ProductItemResponse;
import com.story.backend.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductItemResponse getProductById(@Valid @NotNull UUID productId) {
        return ProductItemResponse.of(productRepository.findByProductId(productId).orElseThrow());
    }

}
