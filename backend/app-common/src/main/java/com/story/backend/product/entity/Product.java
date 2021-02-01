package com.story.backend.product.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "product_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID productId = java.util.UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "style_code", nullable = false)
    private String styleCode;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private long price;

    @Column(name = "currency", nullable = false)
    private String currency;

    @JsonManagedReference
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER, orphanRemoval = true)
    private final Set<ProductSku> productSkus = new HashSet<>();

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Product(String name, String styleCode, String description, long price, String currency) {
        this.name = name;
        this.styleCode = styleCode;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }

    public void addProductSku(ProductSku productSku) {
        productSkus.add(productSku);
        productSku.setProduct(this);
    }
}
