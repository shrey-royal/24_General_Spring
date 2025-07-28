package com.company.basic_auth.controller;

import com.company.basic_auth.dto.UserRequestDTO;
import com.company.basic_auth.dto.UserResponseDTO;
import com.company.basic_auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO user) {
        return ResponseEntity.ok(service.saveUser(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        return ResponseEntity.ok(service.getAllUsers());
    }
}
