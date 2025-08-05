package com.royal.auth.service;

import com.royal.auth.dto.UserDTO;
import com.royal.auth.entity.User;
import com.royal.auth.repository.UserRepository;
import com.royal.auth.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String register(UserDTO userDTO) {
        userRepository.save(User.builder()
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .build()
        );
        return "User registered successfully!";
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                        .stream()
                        .map(this::mapToDTO)
                        .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    private UserDTO mapToDTO(User user) {
        return UserDTO.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
    }
}
