package com.carloslima.udemyweb.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Category obj){
		obj = categoryService.insert(obj);
		//Create a uri that references to the new created resource
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

}
