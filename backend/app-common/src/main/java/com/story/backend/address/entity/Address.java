package com.story.backend.address.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.story.backend.user.entity.User;
import lombok.*;
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

    @Column(name = "receiver_email", nullable = false)
    private String receiverEmail;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "address1", nullable = false)
    private String address1;

    @Column(name = "address2", nullable = false)
    private String address2;

    @Setter
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Address(String receiverName, String receiverPhoneNum, String receiverEmail, String postalCode, String address1, String address2, User user) {
        this.receiverName = receiverName;
        this.receiverPhoneNum = receiverPhoneNum;
        this.receiverEmail = receiverEmail;
        this.postalCode = postalCode;
        this.address1 = address1;
        this.address2 = address2;
        this.user = user;
    }
}
