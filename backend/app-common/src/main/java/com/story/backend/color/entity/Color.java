package com.story.backend.color.entity;

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
@Table(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "color_id", length = 36, nullable = false, updatable = false, unique = true)
    private final UUID colorId = java.util.UUID.randomUUID();

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "hex", nullable = false)
    private byte[] hex;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @CreatedDate
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Builder
    public Color(String name, byte[] hex) {
        this.name = name;
        this.hex = hex;
    }
}
