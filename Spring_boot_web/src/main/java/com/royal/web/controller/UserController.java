package com.royal.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royal.web.entity.User;
import com.royal.web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String listUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/add")
	public String addUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user_form";
	}
	
	@PostMapping("/save")
	public String saveUser(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable int id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user_form";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
