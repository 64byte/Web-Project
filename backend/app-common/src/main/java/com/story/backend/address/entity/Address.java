package com.story.backend.address.entity;

import lombok.AccessLevel;
import lombok.Builder;
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
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "address_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID addressId = java.util.UUID.randomUUID();

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Column(name = "receiver_phone_num", nullable = false)
    private String receiverPhoneNum;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Address(String receiverName, String receiverPhoneNum, String postalCode, String address1, String address2) {
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
        this.postalCode = postalCode;
        this.address1 = address1;
        this.address2 = address2;
    }
}
