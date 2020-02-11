package com.carloslima.udemyweb.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Embeddable
public class ProductOrderedPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="ordered_id")
	private  Ordered ordered;
	
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product product;
	
	
	
	public Ordered getOrdered() {
		return ordered;
	}
	public void setOrdered(Ordered ordered) {
		this.ordered = ordered;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ordered == null) ? 0 : ordered.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		ProductOrderedPK other = (ProductOrderedPK) obj;
		if (ordered == null) {
			if (other.ordered != null)
				return false;
		} else if (!ordered.equals(other.ordered))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}
	
	
	
}
