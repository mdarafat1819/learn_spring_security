package com.example.learn_spring_security.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.learn_spring_security.dto.LoginRequest;
import com.example.learn_spring_security.dto.LoginResponse;
import com.example.learn_spring_security.dto.RegisterRequest;
import com.example.learn_spring_security.security.JwtUtil;
import com.example.learn_spring_security.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class JwtAuthController {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public JwtAuthController(AuthenticationManager authenticationManager,
                             JwtUtil jwtUtil, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return new LoginResponse(token);
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
        boolean success = userService.register(request.getUsername(), request.getPassword());
        if(success) return "Registration Successfull";
        return "Registration Failed";
    }
}
