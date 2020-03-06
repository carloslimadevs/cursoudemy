package com.carloslima.udemyweb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/page",method = RequestMethod.GET) public
	ResponseEntity<Page<Ordered>> findPage(

			@RequestParam (value="page",defaultValue = "0") Integer page,

			@RequestParam (value="linesPerPage",defaultValue = "24") Integer
			linesPerPage,

			@RequestParam (value="orderBy",defaultValue = "orderemTime")String orderBy,

			@RequestParam (value="direction",defaultValue = "DESC")String direction) {

		Page<Ordered> orders = orderedService.findPage(page, linesPerPage,
				orderBy, direction);

//		Page<CustomerDTO> categoriesDTO = categories .map(category -> new
//				CustomerDTO(category));

		return ResponseEntity.ok().body(orders); }


}
