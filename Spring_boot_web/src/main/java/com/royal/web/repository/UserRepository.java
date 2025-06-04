package com.royal.web.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.royal.web.entity.User;

@Repository
public class UserRepository {
	private final Map<Integer, User> userDb = new HashMap<>();	//fake db
	private int currentId = 1;
	
	public List<User> findAll() {
		return new ArrayList<>(userDb.values());
	}
	
	public User findById(int id) {
		return userDb.get(id);
	}
	
	public void save(User user) {
		if (user.getId() == 0) {
			user.setId(currentId);
		}
		userDb.put(user.getId(), user);
	}
	
	public void delete(int id) {
		userDb.remove(id);
	}
}
