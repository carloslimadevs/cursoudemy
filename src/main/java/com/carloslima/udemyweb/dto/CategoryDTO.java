package com.carloslima.udemyweb.dto;

import java.io.Serializable;

import com.carloslima.udemyweb.domain.Category;

public class CategoryDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String  name;
	private String description;
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
