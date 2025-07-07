package com.royal.jpa.service;

import java.util.List;
import java.util.Optional;

import com.royal.jpa.entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Optional<Customer> getCustomerById(Long id);
	Customer saveCustomer(Customer customer);
	void deleteCustomer(Long id);
}
