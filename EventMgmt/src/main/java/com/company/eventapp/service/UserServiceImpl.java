package com.company.eventapp.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.eventapp.entity.User;
import com.company.eventapp.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository repository;

	@Override
	public Optional<User> findByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public User save(User user) {
		return repository.save(user);
	}

	@Override
	public boolean existsByUsername(String username) {
		return repository.existsByusername(username);
	}

	@Override
	public boolean existsByEmail(String email) {
		return repository.existsByEmail(email);
	}
}
