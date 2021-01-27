package com.story.backend.product.service;

import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.repository.ProductSkuRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductSkuService {

    private ProductSkuRepository productSkuRepository;

    public ProductSkuService(ProductSkuRepository productSkuRepository) {
        this.productSkuRepository = productSkuRepository;
    }

    public Optional<ProductSku> getProductSkuBySkuId(UUID skuId) {
        return productSkuRepository.findBySkuId(skuId);
    }

}
