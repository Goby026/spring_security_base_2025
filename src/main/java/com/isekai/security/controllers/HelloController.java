package com.isekai.security.controllers;

import com.isekai.security.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {

    @GetMapping("/")
    public String greeting(){
        return "Hello Java 2025 - 😊";
    }

    @GetMapping("/secured")
    public String secured(){
        return "Si ves esto estas bien logeado!!";
    }

    @GetMapping("/admin")
    public String admin(@AuthenticationPrincipal UserPrincipal principal){
        return "Si ves esto eres un administrador. User ID: "+ principal.getUserId();
    }
}
