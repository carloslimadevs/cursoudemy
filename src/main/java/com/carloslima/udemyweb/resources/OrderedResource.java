package com.carloslima.udemyweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloslima.udemyweb.domain.Ordered;
import com.carloslima.udemyweb.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderedResource {

	@Autowired
	private OrderService orderedService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Ordered> list() {

				return orderedService.listOrdereds();//customerService.; // return "list categories rest service is work";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Ordered customerObj = orderedService.find(id);
		return ResponseEntity.ok(customerObj);

	}

}
