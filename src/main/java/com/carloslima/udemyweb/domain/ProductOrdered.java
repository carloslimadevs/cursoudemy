package com.carloslima.udemyweb.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ProductOrdered  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductOrderedPK id = new ProductOrderedPK();

	private Double discount;
	private Integer number;
	private Double price;

	
	public ProductOrdered() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductOrdered(Product product, Ordered ordered, Double discount, Integer number, Double price) {
		super();
		id.setOrdered(ordered);
		id.setProduct(product);
		this.discount = discount;
		this.number = number;
		this.price = price;
	}

	public ProductOrderedPK getId() {
		return id;
	}

	public void setId(ProductOrderedPK id) {
		this.id = id;
	}

	public Double getDiscount() {
		return discount;
	}

	public void setDiscount(Double discount) {
		this.discount = discount;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Ordered getOrdered() {
		return id.getOrdered();
	}

	public Product getProduct() {
		return id.getProduct();
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
		ProductOrdered other = (ProductOrdered) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
