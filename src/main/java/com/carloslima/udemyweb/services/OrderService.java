package com.carloslima.udemyweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Ordered;
import com.carloslima.udemyweb.repositories.OrderedRepository;
import com.carloslima.udemyweb.security.UserSpringSecurity;
import com.carloslima.udemyweb.services.exception.AuthorizationException;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderedRepository orderedRepository;
	
	@Autowired
	private CustomerService customerService;

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

	public Page<Ordered> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		UserSpringSecurity user = UserService.authenticated();
		
		if(user == null ) {
			throw new AuthorizationException("Denied Access");
		}
	
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		
		return orderedRepository.findByCustomer(customerService.find(user.getId()), pageRequest);
	}
}
