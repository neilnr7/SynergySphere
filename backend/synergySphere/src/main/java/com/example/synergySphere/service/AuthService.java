package com.example.synergySphere.service;

import com.example.synergySphere.model.User;
import com.example.synergySphere.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String signup(String name, String email, String password) {
        if (userRepository.existsByEmail(email)) {
            return "Email already exists!";
        }
        User user = new User(name, email, passwordEncoder.encode(password));
        userRepository.save(user);
        return "Signup successful!";
    }

    public String login(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return "Login successful!";
        }
        return "Invalid credentials!";
    }
}
