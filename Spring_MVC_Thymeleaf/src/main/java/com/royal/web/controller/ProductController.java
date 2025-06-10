package com.royal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royal.web.service.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	private final ProductService service;
	
	public ProductController(ProductService service) {
		this.service = service;
	}
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("products", service.getAll());
		return "product/list";
	}
}
