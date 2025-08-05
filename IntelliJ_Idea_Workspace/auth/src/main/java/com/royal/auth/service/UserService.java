package com.royal.auth.service;

import com.royal.auth.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    String authenticate(UserDTO userDTO);
    String register(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    void deleteUserById(Long id);
}
