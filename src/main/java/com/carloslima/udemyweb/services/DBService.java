package com.carloslima.udemyweb.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Address;
import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.domain.City;
import com.carloslima.udemyweb.domain.Customer;
import com.carloslima.udemyweb.domain.Ordered;
import com.carloslima.udemyweb.domain.Payment;
import com.carloslima.udemyweb.domain.PaymentBillet;
import com.carloslima.udemyweb.domain.PaymentCard;
import com.carloslima.udemyweb.domain.Product;
import com.carloslima.udemyweb.domain.ProductOrdered;
import com.carloslima.udemyweb.domain.Province;
import com.carloslima.udemyweb.domain.enums.AccessProfileType;
import com.carloslima.udemyweb.domain.enums.CustomerType;
import com.carloslima.udemyweb.domain.enums.PaymentStatus;
import com.carloslima.udemyweb.repositories.AddressRepository;
import com.carloslima.udemyweb.repositories.CategoryRepository;
import com.carloslima.udemyweb.repositories.CityRepository;
import com.carloslima.udemyweb.repositories.CustomerRepository;
import com.carloslima.udemyweb.repositories.OrderedRepository;
import com.carloslima.udemyweb.repositories.PaymentRepository;
import com.carloslima.udemyweb.repositories.ProductOrderedRepository;
import com.carloslima.udemyweb.repositories.ProductRepository;
import com.carloslima.udemyweb.repositories.ProvinceRepository;

@Service
public class DBService {

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
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private OrderedRepository orderedRepository;
	@Autowired
	private ProductOrderedRepository productOrderedRepository;
	
	@Autowired
	private EmailService emailservice;
	
	
	@Autowired
	private BCryptPasswordEncoder bCrypt;
	
	
	public void instatiateTestDataBase() throws ParseException {

		int x = 1;

		for(int i = 0; i < x; i++) {



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

			customerOne.setSenha(bCrypt.encode("123"));
			customerTwo.setSenha(bCrypt.encode("321"));

			customerTwo.addProfile(AccessProfileType.ADMIN);
			
			customerOne.getContacts().addAll(Arrays.asList("123456","212221212"));

			Address addressOne = new Address(null, "Street customer One", "1", "apt 202", "4250281", customerOne, cityOne);
			Address addressTwo = new Address(null, "Street customer One", "12", "apt 2021", "4250281", customerOne, cityOne);
			Address addressThree = new Address(null, "Street customer Two", "3", "apt 2022", "4250281", customerTwo, cityTwo);
			Address addressFour= new Address(null, "Street customer Two", "12", "apt 2021", "4250281", customerTwo, cityTwo);

			customerOne.getAddresses().addAll(Arrays.asList(addressOne,addressTwo));
			customerTwo.getAddresses().addAll(Arrays.asList(addressThree,addressFour));

			customerRepository.saveAll(Arrays.asList(customerOne,customerTwo));
			addressRepository.saveAll(Arrays.asList(addressOne,addressTwo,addressThree,addressFour));

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			Ordered order1 = new Ordered(null,sdf.parse("30/09/2017 10:32"),addressTwo, customerOne);
			Ordered order2 = new Ordered(null,sdf.parse("30/08/2017 10:32"),addressOne, customerOne);
			Ordered order3 = new Ordered(null,sdf.parse("30/10/2017 10:32"),addressThree, customerTwo);
			Ordered order4 = new Ordered(null,sdf.parse("30/09/2017 10:32"),addressFour, customerTwo);

			Payment paymentCard = new PaymentCard(null, PaymentStatus.PAYED, order1,6);
			order1.setPayment(paymentCard);

			Payment paymentBillet = new PaymentBillet(null, PaymentStatus.INPROCESS, order2, sdf.parse("30/09/2017 10:32"),null);
			order2.setPayment(paymentBillet);

			customerOne.getOrdereds().addAll(Arrays.asList(order1,order3));
			customerTwo.getOrdereds().addAll(Arrays.asList(order2,order4));

			orderedRepository.saveAll(Arrays.asList(order1,order2,order3,order4));
			paymentRepository.saveAll(Arrays.asList(paymentBillet,paymentCard));

			ProductOrdered pd1 = new ProductOrdered(productOne, order1, 0.00, 1, 2000.00);
			ProductOrdered pd2 = new ProductOrdered(productThree, order1, 0.00, 1, 80.00);
			ProductOrdered pd3 = new ProductOrdered(productTwo, order2, 100.00, 1, 800.00);

			order1.getProducts().addAll(Arrays.asList(pd1,pd2));
			order2.getProducts().addAll(Arrays.asList(pd3));

			productOne.getProducts().addAll(Arrays.asList(pd1));
			productTwo.getProducts().addAll(Arrays.asList(pd3));
			productThree.getProducts().addAll(Arrays.asList(pd2));

			productOrderedRepository.saveAll(Arrays.asList(pd1,pd2,pd3));
			

		}

		//emailservice.sendOrderConfirmationHtmlEmail(new Ordered());
	}


}
