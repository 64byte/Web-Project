package com.story.backend.order.entity;

import com.story.backend.address.entity.Address;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "[order]")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "order_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID orderId = java.util.UUID.randomUUID();

    @Column(name = "order_number", nullable = false, updatable = false, unique = true)
    private String orderNumber;

    @Column(name = "paid_amount", nullable = false)
    private long paidAmount;

    @Column(name = "apply_num", nullable = false)
    private String applyNum;

    private Address address;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
