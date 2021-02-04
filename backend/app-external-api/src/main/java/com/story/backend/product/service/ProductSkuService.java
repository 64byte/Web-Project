package com.story.backend.product.service;

import com.story.backend.product.dto.ProductSkuResponse;
import com.story.backend.product.entity.ProductSku;
import com.story.backend.product.exception.NotFoundProductSkuException;
import com.story.backend.product.repository.ProductSkuRepository;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductSkuService {

    private ProductSkuRepository productSkuRepository;

    public ProductSkuService(ProductSkuRepository productSkuRepository) {
        this.productSkuRepository = productSkuRepository;
    }

    /**
     * product sku id를 이용해 정보를 반환합니다.
     * @param productSkuId
     * @return
     */
    public ProductSkuResponse getProductSkuInfoById(@Valid @NotNull UUID productSkuId) {
        ProductSku productSku = productSkuRepository.findBySkuId(productSkuId)
                .orElseThrow(NotFoundProductSkuException::new);

        return ProductSkuResponse.of(productSku);
    }

    /**
     * skuId를 이용해 Optional<Productsku>를 반환합니다.
     * 해당 메소드는 프로그램 내부 로직에서만 호출합니다.
     * @param productSkuId
     * @return
     */
    public Optional<ProductSku> getProductSkuBySkuId(@Valid @NotNull UUID productSkuId) {
        return productSkuRepository.findBySkuId(productSkuId);
    }
}
