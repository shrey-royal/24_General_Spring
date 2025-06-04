package com.royal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.royal.web.entity.User;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String homePage() {
		return "home";
	}
	
	@GetMapping("/showform")
	public String showForm() {
		return "showform";
	}
	
	@PostMapping("/send")
	public String formdata(@ModelAttribute User user, Model model) {
		model.addAttribute("name", user.getName());
		model.addAttribute("email", user.getEmail());
		System.out.println(user);
		
		return "showUser";
	}
}
