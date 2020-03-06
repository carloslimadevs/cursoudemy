package com.carloslima.udemyweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.repositories.CustomerRepository;
import com.carloslima.udemyweb.security.UserSpringSecurity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Customer customer = repo.findByEmail(email);
		
		if (customer == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSpringSecurity(customer.getId(),customer.getEmail(),customer.getSenha(), customer.getProfiles());
	}

}
