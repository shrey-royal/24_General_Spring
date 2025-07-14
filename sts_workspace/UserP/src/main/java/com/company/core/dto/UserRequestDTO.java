package com.company.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {
	@NotBlank
	private String name;
	
	@Email
	@NotBlank
	private String email;
	
	@Size(min = 8)
	private String password;
}
