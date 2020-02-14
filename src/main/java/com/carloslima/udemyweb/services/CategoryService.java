package com.carloslima.udemyweb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.dto.CategoryDTO;
import com.carloslima.udemyweb.repositories.CategoryRepository;
import com.carloslima.udemyweb.services.exception.DataIntegrityException;
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

	public List<Category> findAll() {
		//List<Category>categories = categoryRepository.findAll();
		//Optional<Category> categoryObj = categoryRepository.findAll()();
		//System.out.println(categoryObj);
		// categoryObj.orElse(null);
		return categoryRepository.findAll();//categories;
//		return categories.orElseThrow(() -> new ObjectNotFoundException(
//				"Object Not found! Id: " + id + ", Type: " + Category.class.getName()));
//						
	}

	public Category insert(Category obj) {
		obj.setId(null);
		// TODO Auto-generated method stub
		return categoryRepository.save(obj);
		
	}

	public Category update(Category obj) {
		// TODO Auto-generated method stub
		find(obj.getId());
		return categoryRepository.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			categoryRepository.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir categorias com produtos associados");
		}
	}
	
	public Page<Category> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction), orderBy);
		return categoryRepository.findAll(pageRequest);
	}
	
	public Category fromDTO(CategoryDTO categoryDTO) {
		
		return new Category(categoryDTO.getId(),categoryDTO.getDescription(),categoryDTO.getName());
		
	}
}
