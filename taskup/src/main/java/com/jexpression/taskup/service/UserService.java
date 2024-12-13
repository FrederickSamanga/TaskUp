package com.jexpression.taskup.service;

import com.jexpression.taskup.dto.UserRegistrationDTO;
import com.jexpression.taskup.model.User;
import com.jexpression.taskup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.jexpression.taskup.model.Role.ROLE_USER;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(UserRegistrationDTO registrationDTO) {
        // Create a new User entity from the DTO
        User user = new User();
        user.setUsername(registrationDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registrationDTO.getPassword())); // Encrypt password
        user.setFirstName(registrationDTO.getFirstName());
        user.setLastName(registrationDTO.getLastName());
        user.setEmail(registrationDTO.getEmail());
        user.setRole(ROLE_USER); // Default role

        // Save the user to the database
        return userRepository.save(user);
    }
}
