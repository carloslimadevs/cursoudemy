package com.carloslima.udemyweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Ordered;
import com.carloslima.udemyweb.repositories.OrderedRepository;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderedRepository orderedRepository;

	public Ordered find(Integer id) {
		Optional<Ordered> customerObj = orderedRepository.findById(id);
		System.out.println(customerObj);
		// categoryObj.orElse(null);
		return customerObj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not found! Id: " + id + ", Type: " + Ordered.class.getName()));

	}

	public List<Ordered> listOrdereds() {
		return orderedRepository.findAll();
	}

}
