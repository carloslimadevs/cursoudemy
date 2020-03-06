package com.carloslima.udemyweb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.dto.CustomerDTO;
import com.carloslima.udemyweb.dto.CustomerDataDTO;
import com.carloslima.udemyweb.services.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerResource {

	@Autowired
	private CustomerService customerService;
	
	/*
	 * @RequestMapping(method = RequestMethod.GET) public List<Customer> listAll() {
	 * 
	 * return customerService.listCustomers();//customerService.; // return
	 * "list categories rest service is work"; }
	 */
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDTO>> list() {

		List<Customer> categories  = customerService.findAll();
		
		List<CustomerDTO> categoriesDTO = categories.stream()
				.map(category -> new CustomerDTO(category))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(categoriesDTO); // return "list categories rest service is work";
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Customer customerObj = customerService.find(id);
		return ResponseEntity.ok(customerObj);

	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page",method = RequestMethod.GET) public
	ResponseEntity<Page<CustomerDTO>> findPage(

			@RequestParam (value="page",defaultValue = "0") Integer page,

			@RequestParam (value="linesPerPage",defaultValue = "24") Integer
			linesPerPage,

			@RequestParam (value="orderBy",defaultValue = "name")String orderBy,

			@RequestParam (value="direction",defaultValue = "ASC")String direction) {

		Page<Customer> categories = customerService.findPage(page, linesPerPage,
				orderBy, direction);

		Page<CustomerDTO> categoriesDTO = categories .map(category -> new
				CustomerDTO(category));

		return ResponseEntity.ok().body(categoriesDTO); }

	
	//New method to insert using DTO and validation
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CustomerDataDTO customerDataDTO){
		
		Customer obj = customerService.fromDTO(customerDataDTO);
		obj = customerService.insert(obj);
		//Create a uri that references to the new created resource
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CustomerDataDTO customerDataDTO, @PathVariable Integer id){
		Customer obj = customerService.fromDTO(customerDataDTO);
		obj.setId(id);
		obj = customerService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		//obj.setId(id);
		customerService.delete(id);
		return ResponseEntity.noContent().build();
	}


}
