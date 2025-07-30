package com.royal.auth.service;

import com.royal.auth.dto.UserDTO;

public interface UserService {
    String authenticate(UserDTO userDTO);
}
