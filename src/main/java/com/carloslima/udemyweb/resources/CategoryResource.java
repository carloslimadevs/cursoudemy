package com.carloslima.udemyweb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.carloslima.udemyweb.domain.Category;
import com.carloslima.udemyweb.dto.CategoryDTO;
import com.carloslima.udemyweb.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CategoryDTO>> list() {

		List<Category> categories  = categoryService.findAll();
		
		List<CategoryDTO> categoriesDTO = categories.stream()
				.map(category -> new CategoryDTO(category))
				.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(categoriesDTO); // return "list categories rest service is work";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Category categoryObj = categoryService.find(id);
		return ResponseEntity.ok(categoryObj);

	}
	
	@RequestMapping(value="/page",method = RequestMethod.GET)
	public ResponseEntity<Page<CategoryDTO>> findPage(
			@RequestParam (value="page",defaultValue = "0") Integer page, 
			@RequestParam (value="linesPerPage",defaultValue = "24") Integer linesPerPage, 
			@RequestParam (value="orderBy",defaultValue = "name")String orderBy, 
			@RequestParam (value="direction",defaultValue = "ASC")String direction) {

		Page<Category> categories  = categoryService.findPage(page, linesPerPage, orderBy, direction);
		
		Page<CategoryDTO> categoriesDTO = categories
				.map(category -> new CategoryDTO(category));
		
		return ResponseEntity.ok().body(categoriesDTO); 
	}

	
	/*
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Void>
	 * insert(@RequestBody Category obj){ obj = categoryService.insert(obj);
	 * //Create a uri that references to the new created resource URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri(); return ResponseEntity.created(uri).build(); }
	 */
	
	//New method to insert using DTO and validation
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody CategoryDTO categoryDTO){
		
		Category obj = categoryService.fromDTO(categoryDTO);
		obj = categoryService.insert(obj);
		//Create a uri that references to the new created resource
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody CategoryDTO categoryDTO, @PathVariable Integer id){
		Category obj = categoryService.fromDTO(categoryDTO);
		obj.setId(id);
		obj = categoryService.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		//obj.setId(id);
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
