package com.story.backend.product.controller;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.product.service.ProductSkuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/product-skus")
public class ProductSkuController {

    private ProductSkuService productSkuService;

    public ProductSkuController(ProductSkuService productSkuService) {
        this.productSkuService = productSkuService;
    }

    @GetMapping("/{productSkuId}")
    public ResponseEntity<CommonResponse> getProductSkuInfoById(@PathVariable UUID productSkuId) {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.OK.value(), null, productSkuService.getProductSkuInfoById(productSkuId)), HttpStatus.OK);
    }

}
