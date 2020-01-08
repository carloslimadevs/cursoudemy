package com.carloslima.udemyweb;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.repositories.CategoryRepository;

@SpringBootApplication
public class UdemywebApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(UdemywebApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category categoryOne = new Category(null, "office description", "Office");
		Category categoryTwo = new Category(null,"Tecnology description", "Tecnology");
		
		categoryRepository.saveAll(Arrays.asList(categoryOne,categoryTwo));
		
	}

}
