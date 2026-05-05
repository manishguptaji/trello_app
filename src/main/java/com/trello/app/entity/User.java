package com.trello.app.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    // --- Constructors ---
    public User() {}

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // --- Lifecycle Hooks ---
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // --- Controlled setters ---
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }
}
