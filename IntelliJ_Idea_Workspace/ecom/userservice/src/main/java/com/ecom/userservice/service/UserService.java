package com.ecom.userservice.service;

import com.ecom.userservice.entity.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getAll();
    User getUserById(Long id);
    void deleteUserById(Long id);
}
