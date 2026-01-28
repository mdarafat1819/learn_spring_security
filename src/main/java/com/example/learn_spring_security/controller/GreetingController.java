package com.example.learn_spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }
    @GetMapping("/hello") 
    public String hello() {
        return "Hello World";
    }
}
