package com.carloslima.udemyweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ProductSeq")
	@SequenceGenerator(name = "ProductSeq", sequenceName = "ProductSeq", allocationSize = 1)
	private Integer id;
	private String name;
	private Double price;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "PRODUCT_CATEGORY",
			  joinColumns = @JoinColumn(name = "product_id"),
			  inverseJoinColumns = @JoinColumn (name = "category_id")
			)
	private List<Category> categories = new ArrayList<Category>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.product")
	private Set<ProductOrdered> products = new HashSet<>();

	public Product() {
		
	}

	public Product(Integer id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	@JsonIgnore
	public List<Ordered> getOrders(){
		List<Ordered> listOrders = new ArrayList<>();
		for(ProductOrdered x: products) {
			listOrders.add(x.getOrdered());
		}
		return listOrders;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Set<ProductOrdered> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductOrdered> products) {
		this.products = products;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
