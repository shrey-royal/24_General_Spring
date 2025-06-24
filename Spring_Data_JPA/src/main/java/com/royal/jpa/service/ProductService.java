package com.royal.jpa.service;

import java.util.List;
import java.util.Optional;

import com.royal.jpa.entity.Product;


public interface ProductService {
	List<Product> getAllProducts();
	Optional<Product> getProductById(Long id);
	Product saveProduct(Product product);
	void deleteProduct(Long id);
}
