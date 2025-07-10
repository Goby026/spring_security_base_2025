package com.isekai.security.service;

import com.isekai.security.model.LoginResponse;
import com.isekai.security.security.JWTissuer;
import com.isekai.security.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);

    private final JWTissuer jwTissuer;

    private final AuthenticationManager authenticationManager;

    public LoginResponse attemptingLoggin(String email, String password) {
        var authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        var principal = (UserPrincipal) authentication.getPrincipal();

        var roles = principal.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        var token = jwTissuer.issue(principal.getUserId(), principal.getEmail(), roles);
        //var token = jwTissuer.issue(1L, request.getEmail(), List.of("USER"));

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
