package com.example.synergySphere.service;

import com.example.synergySphere.dto.AuthRequestDTO;
import com.example.synergySphere.dto.AuthResponseDTO;
import com.example.synergySphere.model.User;
import com.example.synergySphere.repository.UserRepository;
import com.example.synergySphere.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public AuthResponseDTO signup(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            return new AuthResponseDTO("Email already exists!", null);
        }

        User user = new User(name, email, passwordEncoder.encode(password));
        userRepository.save(user);

        String token = JwtUtil.generateToken(user.getEmail());
        return new AuthResponseDTO("User registered successfully!", token);
    }

    public AuthResponseDTO login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isEmpty() || !passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return new AuthResponseDTO("Invalid email or password!", null);
        }

        String token = JwtUtil.generateToken(email);
        return new AuthResponseDTO("Login successful!", token);
    }
}
