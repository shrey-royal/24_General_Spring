package com.ecom.userservice.controller;

import com.ecom.userservice.entity.User;
import com.ecom.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(service.createUser(user));
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        try {
            return ResponseEntity.ok(service.updateUser(user));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}