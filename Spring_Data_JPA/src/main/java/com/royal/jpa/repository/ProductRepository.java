package com.royal.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.jpa.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	//
}
