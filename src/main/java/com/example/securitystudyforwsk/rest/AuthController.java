package com.example.securitystudyforwsk.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "success";
    }

    @GetMapping("/login?error")
    public String errorPage() {
        return "error";
    }
}