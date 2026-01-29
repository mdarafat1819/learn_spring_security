package com.example.learn_spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.learn_spring_security.service.UserService;


@Controller
public class AuthController {
    private final UserService userService;
    
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }
    @PostMapping("/register")
    public String register(@RequestParam String username,
         @RequestParam String password,
         Model model
        ) {
            boolean success = userService.register(username, password);

            if(!success) {
                model.addAttribute("error", true);
                return "register";
            }
            model.addAttribute("success", true);

            return "register";
    }
     @GetMapping("/login")
    public String login() {
        return "login.html";
    }
}
