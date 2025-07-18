package com.royal.web.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.royal.web.entity.Product;
import com.royal.web.repository.ProductRepository;

@Service
public class ProductService {
	
	private final ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public List<Product> getAll() {
		return repo.findAll();
	}
	
	public Product getById(int id) {
		return repo.findById(id);
	}
	
	public void save(Product product) {
		repo.save(product);
	}
	
	public void delete(int id) {
		repo.delete(id);
	}
	
}
