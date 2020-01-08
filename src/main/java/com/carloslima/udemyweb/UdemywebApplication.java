package com.carloslima.udemyweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.domain.Product;
import com.carloslima.udemyweb.repositories.CategoryRepository;
import com.carloslima.udemyweb.repositories.ProductRepository;

@SpringBootApplication
public class UdemywebApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(UdemywebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
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
	}

}
