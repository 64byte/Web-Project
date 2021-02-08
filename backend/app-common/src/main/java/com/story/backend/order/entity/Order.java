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

    @Column(name = "imp_uid", nullable = false, updatable = false, unique = true)
    private String impUid;

    @Column(name = "merchant_uid", nullable = false, updatable = false, unique = true)
    private String merchantUid;

    @Column(name = "pay_method", nullable = false, updatable = false)
    private String payMethod;

    @Column(name = "status", nullable = false, updatable = false)
    private String status;

    @Column(name = "paid_amount", nullable = false)
    private long paidAmount;

    @Column(name = "apply_num", nullable = false)
    private String applyNum;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Order(String impUid, String merchantUid, String payMethod, String status, long paidAmount, String applyNum) {
        this.impUid = impUid;
        this.merchantUid = merchantUid;
        this.payMethod = payMethod;
        this.status = status;
        this.paidAmount = paidAmount;
        this.applyNum = applyNum;
    }

}
