package com.story.backend.cart.entity;

import com.story.backend.user.entity.User;
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
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "cart_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID cartId = java.util.UUID.randomUUID();

    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private long totalQuantity;

    private long totalPrice;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "cart")
    private final Set<CartItem> cartItems = new HashSet<>();

    @Builder
    public Cart(User user) {
        this.user = user;
    }


}
