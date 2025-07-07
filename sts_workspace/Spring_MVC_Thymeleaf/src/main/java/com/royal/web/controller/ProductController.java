package com.royal.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royal.web.entity.Product;
import com.royal.web.service.ProductService;

import jakarta.validation.Valid;

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
	
	@GetMapping("/add")
	public String showForm(Model model) {
		model.addAttribute("product", new Product());
		return "product/form";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "product/form";
		}
		service.save(product);
		return "redirect:/products";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id, Model model) {
		Product product = service.getById(id);
		if (product == null) {
			return "error/404";
		}
		model.addAttribute("product", product);
		return "product/form";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/products";
	}
	
	@GetMapping("/{id}")
	public String view(@PathVariable int id, Model model) {
		Product product = service.getById(id);
		if (product == null) {
			return "error/404";
		}
		model.addAttribute("product", product);
		return "product/details";
	}
}
