package com.carloslima.udemyweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carloslima.udemyweb.domain.Address;
import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.domain.City;
import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.domain.Product;
import com.carloslima.udemyweb.domain.Province;
import com.carloslima.udemyweb.domain.enums.CustomerType;
import com.carloslima.udemyweb.repositories.AddressRepository;
import com.carloslima.udemyweb.repositories.CategoryRepository;
import com.carloslima.udemyweb.repositories.CityRepository;
import com.carloslima.udemyweb.repositories.CustomerRepository;
import com.carloslima.udemyweb.repositories.ProductRepository;
import com.carloslima.udemyweb.repositories.ProvinceRepository;

@SpringBootApplication
public class UdemywebApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository ;
	@Autowired
	private ProvinceRepository provinceRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(UdemywebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		int i = 0;
		
		for( i = 0; i < 0; i++) {
			
		
				
		Category categoryOne = new Category(null, "office description", "Office");
		Category categoryTwo = new Category(null,"Tecnology description", "Tecnology");
		
		Product productOne = new Product(null, "Computer", 2000.00);
		Product productTwo = new Product (null,"Printer",400.00);
		Product productThree = new Product(null,"chair",40.00);
		
		categoryOne.getProducts().addAll(Arrays.asList(productOne,productTwo,productThree));
		categoryTwo.getProducts().add(productTwo);
		
		productOne.getCategories().add(categoryOne);
		productTwo.getCategories().addAll(Arrays.asList(categoryOne,categoryTwo));
		productThree.getCategories().add(categoryOne);
		
		categoryRepository.saveAll(Arrays.asList(categoryOne,categoryTwo));
		productRepository.saveAll(Arrays.asList(productOne,productTwo,productThree));
		
		
		Province provinceOne = new Province(null,"Porto");
		Province provinceTwo = new Province(null,"Aveiro");

		City cityOne = new City(null, "Paranhos", provinceOne);
		City cityTwo = new City(null, "Maia", provinceOne);
		City cityThree = new City(null, "Cedofeita", provinceOne);
		City cityFour = new City(null, "Ilhavo", provinceTwo);
		City cityFive = new City(null, "Gafanha", provinceTwo);
		
		provinceOne.getCities().addAll(Arrays.asList(cityOne,cityTwo,cityThree));
		provinceTwo.getCities().addAll(Arrays.asList(cityFour,cityFive));
		
		
		provinceRepository.saveAll(Arrays.asList(provinceOne,provinceTwo));
		cityRepository.saveAll(Arrays.asList(cityOne,cityTwo,cityThree,cityFour,cityFive));
		
		
		Customer customerOne = new Customer(null, "customer_one", "customerOne@mail.com", "01010101010", CustomerType.COMMONCOSTUMER);
		Customer customerTwo = new Customer(null, "customer_Two", "customerTwo@mail.com", "10101010101", CustomerType.LEGALCOSTUMER);
		
		customerOne.getContacts().addAll(Arrays.asList("123456","212221212"));
		
		Address addressOne = new Address(null, "Street customer One", "1", "apt 202", "4250281", customerOne, cityOne);
		Address addressTwo = new Address(null, "Street customer One", "12", "apt 2021", "4250281", customerOne, cityOne);
		Address addressThree = new Address(null, "Street customer Two", "3", "apt 2022", "4250281", customerTwo, cityTwo);
		Address addressFour= new Address(null, "Street customer Two", "12", "apt 2021", "4250281", customerTwo, cityTwo);
		
		customerOne.getAddresses().addAll(Arrays.asList(addressOne,addressTwo));
		customerTwo.getAddresses().addAll(Arrays.asList(addressThree,addressFour));
		
		customerRepository.saveAll(Arrays.asList(customerOne,customerTwo));
		addressRepository.saveAll(Arrays.asList(addressOne,addressTwo,addressThree,addressFour));

		}
	}
}
