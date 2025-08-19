package com.ecom.userservice.service;

import com.ecom.userservice.entity.User;
import com.ecom.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;

    @Override
    public User createUser(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public void deleteUserById(Long id) {
        repo.deleteById(id);
    }
}
