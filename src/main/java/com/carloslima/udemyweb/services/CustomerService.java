package com.carloslima.udemyweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.carloslima.udemyweb.domain.Address;
import com.carloslima.udemyweb.domain.City;
import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.domain.enums.CustomerType;
import com.carloslima.udemyweb.dto.CustomerDTO;
import com.carloslima.udemyweb.dto.CustomerDataDTO;
import com.carloslima.udemyweb.repositories.AddressRepository;
import com.carloslima.udemyweb.repositories.CityRepository;
import com.carloslima.udemyweb.repositories.CustomerRepository;
import com.carloslima.udemyweb.resources.utils.URLUtils;
import com.carloslima.udemyweb.services.exception.DataIntegrityException;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository ;
	
	@Autowired
	private CityRepository cityRepository ;
	
	@Autowired
	private AddressRepository addressRepository ;
	
	
	public Customer find(Integer id) {
		Optional<Customer> customerObj = customerRepository.findById(id);
		System.out.println(customerObj);
		// customerObj.orElse(null);
		return customerObj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not found! Id: " + id + ", Type: " + Customer.class.getName()));
						
	}
	
	public List<Customer> listCustomers() {
		return customerRepository.findAll();				
	}
	
	public List<Customer> findAll() {
		//List<Customer>categories = customerRepository.findAll();
		//Optional<Customer> customerObj = customerRepository.findAll()();
		//System.out.println(customerObj);
		// customerObj.orElse(null);
		return customerRepository.findAll();//categories;
//		return categories.orElseThrow(() -> new ObjectNotFoundException(
//				"Object Not found! Id: " + id + ", Type: " + Customer.class.getName()));
//						
	}

	@Transactional
	public Customer insert(Customer obj) {
		obj.setId(null);
		// TODO Auto-generated method stub
		addressRepository.saveAll(obj.getAddresses());
		return customerRepository.save(obj);
		
	}

	public Customer update(Customer obj) {
		// TODO Auto-generated method stub
		find(obj.getId());
		return customerRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			customerRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir com entidades associados");
		}
	}
	
	public Page<Customer> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return customerRepository.findAll(pageRequest);
	}
	
	
public Customer fromDTO(CustomerDataDTO customerDataDTO) {
		
		Customer customer = new Customer();
		//customer.setId(customerDataDTO.getId());
		customer.setEmail(customerDataDTO.getEmail());
		customer.setName(customerDataDTO.getName());
		customer.setCustomerType(CustomerType.toEnum(customerDataDTO.getCustomerType()));
		customer.setContacts(customerDataDTO.phonesToCustomerContacts());
		customer.setDocument(customerDataDTO.getDocument());
		
		//fetch city by id
		//Optional<City> city = cityRepository.findById(customerDataDTO.getCityId());
		
		City city = new City(customerDataDTO.getCityId(), null, null);
		
		Address address = new Address(null, customerDataDTO.getStreet(), customerDataDTO.getNumber(), customerDataDTO.getOptionalInformation(),customerDataDTO.getZipcode(), customer, city);
		//return new Customer(customerDTO.getId(),customerDTO.getId());
		//throw new UnsupportedOperationException("method not implement yet");
		customer.getAddresses().add(address);
		
		return customer;
	}

}
