package com.example.synergySphere.dto;



import java.time.LocalDate;

public class UserResponseDTO {
    private Long userId;
    private String name;
    private String email;
    private LocalDate createdAt;

    public UserResponseDTO(Long userId, String name, String email, LocalDate createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.createdAt = createdAt;
    }

    // Getters only (no setters to keep response immutable)
    public Long getUserId() { return userId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public LocalDate getCreatedAt() { return createdAt; }
}
