package com.jexpression.taskup.controller;

import com.jexpression.taskup.dto.UserRegistrationDTO;
import com.jexpression.taskup.model.User;
import com.jexpression.taskup.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/auth/register")
    public ResponseEntity<User> registerUser(@RequestBody @Valid UserRegistrationDTO registrationDTO) {
        // Register user and return the created user
        User user = userService.registerUser(registrationDTO);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
