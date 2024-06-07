package com.apj.platform.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apj.platform.auth.controllers.vo.LoginRequest;
import com.apj.platform.auth.controllers.vo.LoginRequest.EmailLoginRequest;
import com.apj.platform.auth.controllers.vo.LoginRequest.EmailOTPLoginRequest;
import com.apj.platform.auth.controllers.vo.LoginRequest.MobileOTPLoginRequest;
import com.apj.platform.auth.controllers.vo.LoginRequest.UsernameLoginRequest;
import com.apj.platform.auth.services.AuthService;
import com.apj.platform.auth.vo.SystemException;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/auth/login")
public class AuthLoginController {

    private final AuthService authService;

    public AuthLoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public String authenticate(@Valid @RequestBody LoginRequest loginRequest) throws SystemException {
        if (loginRequest instanceof LoginRequest.UsernameLoginRequest) {
            LoginRequest.UsernameLoginRequest request = (UsernameLoginRequest) loginRequest;
            return authService.loginByUsernamePassword(request.getUsername(), request.getPassword());
        } else if (loginRequest instanceof LoginRequest.EmailLoginRequest) {
            LoginRequest.EmailLoginRequest request = (EmailLoginRequest) loginRequest;
            return authService.loginByEmailPassword(request.getUsername(), request.getPassword());
        } else if (loginRequest instanceof LoginRequest.EmailOTPLoginRequest) {
            LoginRequest.EmailOTPLoginRequest request = (EmailOTPLoginRequest) loginRequest;
            authService.loginByEmailOTP(request.getEmail());
        } else if (loginRequest instanceof LoginRequest.MobileOTPLoginRequest) {
            LoginRequest.MobileOTPLoginRequest request = (MobileOTPLoginRequest) loginRequest;
            authService.loginByMobileOTP(request.getMobileno());
        }
        return "token";
    }
}
