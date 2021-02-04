package com.story.backend.cart.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.story.backend.address.entity.Address;
import com.story.backend.user.entity.User;
import lombok.*;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "cart_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID cartId = java.util.UUID.randomUUID();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Formula("(select sum(ci.quantity) from cart_item ci where ci.cart_id = id)")
    private long totalQuantity;
//
//    private long totalPrice;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonManagedReference
    @OneToMany(mappedBy = "cart", fetch = FetchType.EAGER)
    private final Set<CartItem> cartItems = new HashSet<>();

    @Builder
    public Cart() {

    }

}
