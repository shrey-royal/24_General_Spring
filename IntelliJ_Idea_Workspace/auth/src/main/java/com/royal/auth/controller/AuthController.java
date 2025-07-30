package com.royal.auth.controller;

import com.royal.auth.dto.UserDTO;
import com.royal.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {
    private UserService service;

    @PostMapping
    public String authenticate(@RequestBody UserDTO userDTO) {
        return service.authenticate(userDTO);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Authenticated User!";
    }
}
