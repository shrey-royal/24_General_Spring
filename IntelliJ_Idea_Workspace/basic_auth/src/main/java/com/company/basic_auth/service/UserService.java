package com.company.basic_auth.service;

import com.company.basic_auth.dto.UserRequestDTO;
import com.company.basic_auth.dto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO saveUser(UserRequestDTO user);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO getUserByUsername(String username);
    UserResponseDTO getUserByEmail(String email);
    void deleteUserById(Long id);
}
