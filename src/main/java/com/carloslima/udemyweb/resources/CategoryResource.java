package com.carloslima.udemyweb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {

		Category cat1 = new Category(1, null, "tecnology");
		Category cat2 = new Category(2, null, "tecnology");

		List<Category> categories = new ArrayList<>();
		categories.add(cat1);
		categories.add(cat2);
		//Category categoryObj = categoryService.;
		//categories.add(categoryObj);
		categories = categoryService.findAll();
		return categories; // return "list categories rest service is work";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Category categoryObj = categoryService.find(id);
		return ResponseEntity.ok(categoryObj);

	}

}
