package com.company.basic_auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotNull(message = "Username is mandatory")
    private String username;
    @Email
    private String email;
    @Size(min = 8, message = "password length > 8")
    private String password;
}
