package com.company.core.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.config.JwtUtil;
import com.company.core.dto.AuthRequest;
import com.company.core.dto.AuthResponse;
import com.company.core.entity.Role;
import com.company.core.entity.User;
import com.company.core.repository.UserRepository;
import com.company.core.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
	private final AuthenticationManager authManager;
	private final JwtUtil jwtUtil;
	private final CustomUserDetailsService userDetailsService;
	
	@PostMapping("/login")
	public AuthResponse login(@RequestBody AuthRequest request) {
		Authentication authentication = authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		
		UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());
		String token = jwtUtil.generateToken(user);
		return new AuthResponse(token);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody User user) {
		if (userRepository.findByUsername(user.getUsername()).isPresent()) {
			return ResponseEntity.badRequest().body("Username already exists");
		}
		
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(passwordEncoder.encode(user.getPassword()));
		newUser.setRole(user.getRole());	// USER, ADMIN
		userRepository.save(newUser);
		return ResponseEntity.ok("User registered successfully");
	}
}
