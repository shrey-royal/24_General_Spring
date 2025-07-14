package com.company.core.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.company.core.dto.UserRequestDTO;
import com.company.core.dto.UserResponseDTO;
import com.company.core.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository repository;
	private final Cloudinary cloudinary;
	
	@Override
	public UserResponseDTO createUser(UserRequestDTO dto, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<UserResponseDTO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserResponseDTO getUserById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public UserResponseDTO updateUser(Long id, UserRequestDTO dto, MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		
	}
}
