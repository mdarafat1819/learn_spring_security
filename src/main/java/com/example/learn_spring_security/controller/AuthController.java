package com.example.learn_spring_security.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn_spring_security.dto.RegisterRequest;
import com.example.learn_spring_security.service.UserService;

@RestController
public class AuthController {
    private final UserService userService;
    
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        userService.register(request.getUsername(), request.getPassword());
        return "User registered successfully";
    }
}
