package com.company.core.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.core.dto.UserRequestDTO;
import com.company.core.dto.UserResponseDTO;
import com.company.core.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	
	@PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<UserResponseDTO> createUser(
			@Valid @RequestPart("user") UserRequestDTO user,
			@RequestPart(value = "image", required = false) MultipartFile image
			) throws IOException {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.createUser(user, image));
	}
	
	@GetMapping
	public List<UserResponseDTO> getAll() {
		return service.getAllUsers();
	}
	
	//getUserbyId
	//updateUser
	//deleteUser
}
