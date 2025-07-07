package com.isekai.security.controllers;

import lombok.RequiredArgsConstructor;
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
}
