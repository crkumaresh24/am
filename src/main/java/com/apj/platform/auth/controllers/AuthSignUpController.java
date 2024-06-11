package com.apj.platform.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apj.platform.auth.controllers.vo.UserResigter;
import com.apj.platform.auth.services.AuthService;
import com.apj.platform.commons.vo.SystemException;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/auth/signup")
public class AuthSignUpController {

    private final AuthService authService;

    public AuthSignUpController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public String signup(@Valid @RequestBody UserResigter userResigter) throws SystemException {
        String username = this.authService.signup(userResigter);
        return "user " + username + " successfully onboarded";
    }

    @GetMapping("/exists/username")
    public boolean isUsernameExists(@RequestParam("username") String username) {
        return this.authService.isUsernameExists(username);
    }

    @GetMapping("/exists/email")
    public boolean isEmailExists(@RequestParam("email") String email) {
        return this.authService.isEmailExists(email);
    }

    @GetMapping("/exists/mobileno")
    public boolean isMobileNoExists(@RequestParam("mobileno") String mobileno) {
        return this.authService.isMobileExists(mobileno);
    }
}
