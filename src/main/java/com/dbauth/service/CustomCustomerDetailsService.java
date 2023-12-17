package com.dbauth.service;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dbauth.entity.Customer;
import com.dbauth.repository.CustomerRepository;

@Service
public class CustomCustomerDetailsService implements UserDetailsService{
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
		Customer customer = this.customerRepo.findByEmail(email);
		
		Set<GrantedAuthority> authorities = customer.getRoles()
				.stream()
				.map((role)-> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());
		if(customer == null)
			throw new UsernameNotFoundException("Invalid email or password");
		else
			return new User(email,customer.getPassword(),authorities);
	}

}
