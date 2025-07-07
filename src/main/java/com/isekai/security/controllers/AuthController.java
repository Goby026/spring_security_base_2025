package com.isekai.security.controllers;

import com.isekai.security.model.LoginRequest;
import com.isekai.security.model.LoginResponse;
import com.isekai.security.security.JWTissuer;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final JWTissuer jwTissuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest request){
        var token = jwTissuer.issue(1L, request.getEmail(), List.of("USER"));
        System.out.println("EMAIL: " + request.getEmail());
        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
