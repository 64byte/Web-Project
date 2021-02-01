package com.story.backend.user.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.story.backend.address.entity.Address;
import com.story.backend.cart.entity.Cart;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Indexed;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "[user]")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "user_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID userId = java.util.UUID.randomUUID();

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "full_name", length = 255, nullable = false)
    private String fullName;

    @Column(name = "phone_num", length = 15, nullable = false)
    private String phoneNum;

    @OneToOne(mappedBy = "user")
    private Cart cart;

    @JsonManagedReference
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private final Set<Address> addresses = new HashSet<>();

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public User(String email, String password, String fullName, String phoneNum) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.phoneNum = phoneNum;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isSamePasswordWith(String password) {
        return this.password.equals(password);
    }
}
