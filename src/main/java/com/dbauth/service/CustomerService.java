package com.dbauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbauth.entity.Customer;
import com.dbauth.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer getCustomerById(int id) {
		return this.customerRepo.findById(id).orElseThrow();
	}
	
}
