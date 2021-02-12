package com.story.backend.cart.entity;

import com.story.backend.product.entity.ProductSku;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart_item")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sku_id")
    private ProductSku productSku;

    @Column(name = "quantity")
    private long quantity;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public CartItem(Cart cart, ProductSku productSku, long quantity) {
        this.cart = cart;
        this.productSku = productSku;
        this.quantity = quantity;
    }

    public void addQuantity(long quantity) {
        this.quantity += quantity;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

}
