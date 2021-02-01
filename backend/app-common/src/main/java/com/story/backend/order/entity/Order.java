package com.story.backend.order.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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




}
