package com.royal.auth.service;

import com.royal.auth.dto.UserDTO;
import com.royal.auth.entity.User;
import com.royal.auth.repository.UserRepository;
import com.royal.auth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private JwtUtil jwtUtil;

    @Override
    public String authenticate(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        if (!user.getPassword().equals(userDTO.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(user.getUsername());
    }
}
