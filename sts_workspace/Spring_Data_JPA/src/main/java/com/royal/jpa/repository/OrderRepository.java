package com.royal.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.royal.jpa.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	//
}
