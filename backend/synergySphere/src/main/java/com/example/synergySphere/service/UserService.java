package com.example.synergySphere.service;

import com.example.synergySphere.model.User;
import com.example.synergySphere.repository.UserRepository;
import com.example.synergySphere.dto.UserRequestDTO;
import com.example.synergySphere.dto.UserResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import org.springframework.http.HttpStatus;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserResponseDTO createUser(UserRequestDTO request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email already exists!");
        }

        // hash password before saving
        User user = new User(
                request.getName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword())
        );
        User saved = userRepository.save(user);

        return new UserResponseDTO(
                saved.getUserId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCreatedAt()
        );
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
