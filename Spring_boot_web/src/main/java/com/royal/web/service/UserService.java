package com.royal.web.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.royal.web.entity.User;
import com.royal.web.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(User user) {
		userRepository.update(user);
	}
	
	public void deleteUser(int id) {
		userRepository.delete(id);
	}
}
