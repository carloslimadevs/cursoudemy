package com.carloslima.udemyweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.repositories.CategoryRepository;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category find(Integer id) {
		Optional<Category> categoryObj = categoryRepository.findById(id);
		System.out.println(categoryObj);
		// categoryObj.orElse(null);
		return categoryObj.orElseThrow(() -> new ObjectNotFoundException(
				"Object Not found! Id: " + id + ", Type: " + Category.class.getName()));
						
	}

}
