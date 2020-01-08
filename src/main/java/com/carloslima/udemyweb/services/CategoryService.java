package com.carloslima.udemyweb.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Category find(Integer id) {
		Optional<Category> categoryObj = categoryRepository.findById(id);
		System.out.println(categoryObj);
		return categoryObj.orElse(null);
	}

}
