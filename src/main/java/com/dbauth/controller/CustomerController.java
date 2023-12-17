package com.dbauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbauth.entity.Customer;
import com.dbauth.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PreAuthorize("hasAuthority('Guest')")
	@GetMapping("/getStr")
	public String getStr() {
		return "<h1>Hello</h1>";
	}
	
	@PreAuthorize("hasAuthority('Admin')")
	@GetMapping("/getuser/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return this.customerService.getCustomerById(id);
	}

}
