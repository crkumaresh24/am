package com.apj.platform.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/v1/auth/validate")
public class AuthValidateController {

    @GetMapping("/token")
    public void validateBearerToken() {
    }

}
