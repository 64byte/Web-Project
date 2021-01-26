package com.story.backend.product.entity;

import com.story.backend.cart.entity.CartItem;
import com.story.backend.product.entity.Product;
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
@Table(name = "product_sku")
public class ProductSku {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "sku_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID skuId = java.util.UUID.randomUUID();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "size", nullable = false)
    private String size;

    @Column(name = "quantity", nullable = false)
    private long quantity;

/*    @OneToMany(mappedBy = "product_sku")
    private final Set<CartItem> cartItems = new HashSet<>(); */

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public ProductSku(Product product, String size, long quantity) {
        this.product = product;
        this.size = size;
        this.quantity = quantity;
    }
}
