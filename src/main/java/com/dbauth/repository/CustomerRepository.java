package com.dbauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbauth.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>{
 Customer findByEmail(String email);
}
