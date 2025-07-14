package com.company.eventapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.eventapp.entity.Role;
import com.company.eventapp.entity.User;
import com.company.eventapp.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	private final UserService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerUser(@Valid @RequestBody User user) {
		if(service.existsByUsername(user.getUsername())) {
			return ResponseEntity.badRequest().body("Username is already taken.");
		}
		if(service.existsByEmail(user.getEmail())) {
			return ResponseEntity.badRequest().body("Email is already in use.");
		}
		if (user.getRole() == null) user.setRole(Role.USER);	//default role
		service.save(user);
		return ResponseEntity.ok("User registered successfully.");
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		return ResponseEntity.ok(service.getAllUsers());
	}
}
