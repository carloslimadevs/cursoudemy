package com.carloslima.udemyweb.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carloslima.udemyweb.domain.Category;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Category> list() {
	
	Category cat1 = new Category(1, null,"tecnology");
	Category cat2 = new Category(2, null,"tecnology");
	
	List<Category> categories = new ArrayList<>();
	categories.add(cat1);
	categories.add(cat2);
	return categories;
		//return "list categories rest service is work";
	}

}
