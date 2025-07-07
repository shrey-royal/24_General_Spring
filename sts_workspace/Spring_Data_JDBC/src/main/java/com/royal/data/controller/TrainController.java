package com.royal.data.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.royal.data.entity.Train;
import com.royal.data.service.TrainService;

@Controller
@RequestMapping("/trains")
public class TrainController {
	private final TrainService service;
	
	public TrainController(TrainService service) {
		this.service = service;
	}
	
	@GetMapping
	public String list(Model model) {
		model.addAttribute("trains", service.listAll());
		return "trains";
	}
	
	@GetMapping("/new")
	public String createForm(Model model) {
		model.addAttribute("train", new Train());
		return "train_form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Train train) {
		service.save(train);
		return "redirect:/trains";
	}
	
	@GetMapping("/edit/{id}")
	public String editForm(@PathVariable int id, Model model) {
		model.addAttribute("train", service.get(id));
		return "train_form";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Train train) {
		service.update(train);
		return "redirect:/trains";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		service.deleteById(id);
		return "redirect:/trains";
	}
}
