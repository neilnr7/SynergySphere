package com.example.synergySphere.controller;

import com.example.synergySphere.dto.AuthRequestDTO;
import com.example.synergySphere.dto.AuthResponseDTO;

import com.example.synergySphere.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public AuthResponseDTO signup(@RequestBody AuthRequestDTO request) {
        String message = authService.signup(request.getName(), request.getEmail(), request.getPassword());
        return new AuthResponseDTO(message);
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody AuthRequestDTO request) {
        String message = authService.login(request.getEmail(), request.getPassword());
        return new AuthResponseDTO(message);
    }
}
