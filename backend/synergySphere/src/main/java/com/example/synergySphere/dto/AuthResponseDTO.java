package com.example.synergySphere.dto;

public class AuthResponseDTO {
    private String message;

    public AuthResponseDTO(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
