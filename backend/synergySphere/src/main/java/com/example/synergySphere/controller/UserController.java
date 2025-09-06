package com.example.synergySphere.controller;

import com.example.synergySphere.dto.UserRequestDTO;
import com.example.synergySphere.dto.UserResponseDTO;
import com.example.synergySphere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create new user (directly, without JWT auth)
    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO request) {
        return userService.createUser(request);
    }

    // Get user by id
    @GetMapping("/{id}")
    public UserResponseDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(user -> new UserResponseDTO(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt()
                ))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    // Get user by email
    @GetMapping("/email/{email}")
    public UserResponseDTO getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(user -> new UserResponseDTO(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail(),
                        user.getCreatedAt()
                ))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
