package com.carloslima.udemyweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.repositories.CustomerRepository;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	public Customer find(Integer id) {
		Optional<Customer> customerObj = customerRepository.findById(id);
		System.out.println(customerObj);
		// categoryObj.orElse(null);
		return customerObj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not found! Id: " + id + ", Type: " + Customer.class.getName()));
						
	}
	
	public List<Customer> listCustomers() {
		return customerRepository.findAll();				
	}

}
