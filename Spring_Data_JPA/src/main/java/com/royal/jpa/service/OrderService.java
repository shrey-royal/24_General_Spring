package com.royal.jpa.service;

import java.util.List;
import java.util.Optional;

import com.royal.jpa.entity.Order;

public interface OrderService {
	List<Order> getAllOrders();
	Optional<Order> getOrderById(Long id);
	Order saveOrder(Order order);
	void deleteOrder(Long id);
}
