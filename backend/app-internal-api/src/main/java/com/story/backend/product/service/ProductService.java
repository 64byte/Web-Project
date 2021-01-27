package com.story.backend.product.service;

import com.story.backend.product.dto.ProductResponse;
import com.story.backend.product.entity.Product;
import com.story.backend.product.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProductItems(Pageable pageable) {
        return productRepository
                .findAll(pageable);
    }

}
