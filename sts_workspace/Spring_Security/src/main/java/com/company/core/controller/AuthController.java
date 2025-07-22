package com.company.core.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.core.config.JwtUtil;
import com.company.core.dto.AuthRequest;
import com.company.core.dto.AuthResponse;
import com.company.core.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
	
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
}
