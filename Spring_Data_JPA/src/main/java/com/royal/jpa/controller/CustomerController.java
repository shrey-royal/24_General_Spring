package com.royal.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royal.jpa.entity.Customer;
import com.royal.jpa.service.CustomerService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	@GetMapping
	public String listCustomers(Model model) {
		model.addAttribute("customers", customerService.getAllCustomers());
		return "customers/list";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customers/form";
	}
	
	@PostMapping("/create")
	public String createCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer/form";
		}
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/edit/{id}")
	public String editCustomer(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerService.getCustomerById(id));
		return "customers/form";
	}
	
	@PostMapping("/edit/{id}")
	public String updateCustomer(@PathVariable Long id, @Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer/form";
		}
		customer.setId(id);
		customerService.saveCustomer(customer);
		return "redirect:/customers";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerService.deleteCustomer(id);
		return "redirect:/customers";
	}
	
}
