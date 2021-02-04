package com.story.backend.product.controller;

import com.story.backend.common.dto.CommonResponse;
import com.story.backend.product.exception.NotFoundProductException;
import com.story.backend.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<CommonResponse> getProductById(@PathVariable UUID productId) throws NotFoundProductException {
        return new ResponseEntity<>(CommonResponse.of(HttpStatus.OK.value(), null, productService.getProductById(productId)), HttpStatus.OK);
    }

    @GetMapping("/{productId}/product-skus")
    public ResponseEntity<CommonResponse> getRelatedProductSkusByProductId(@PathVariable UUID productId) throws NotFoundProductException {
        return new ResponseEntity<>(
                CommonResponse.of(HttpStatus.OK.value(), null, productService.getRelatedProductSkusByProductId(productId)),
                HttpStatus.OK);
    }

}
