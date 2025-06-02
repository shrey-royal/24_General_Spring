package com.royal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String formdata(@RequestParam("name") String name1, @RequestParam String email) {
		System.out.println("Name: " + name1);
		System.out.println("Email: " + email);
		return "home";
	}
}
