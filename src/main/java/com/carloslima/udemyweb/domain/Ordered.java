package com.carloslima.udemyweb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ordered implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date orderemTime;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ordered")
	private Payment payment;
	
	
	@ManyToOne
	@JoinColumn(name = "adress_id")
	private Address address;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Ordered() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ordered(Integer id, Date orderemTime, Payment payment, Address address) {
		super();
		this.id = id;
		this.orderemTime = orderemTime;
		this.payment = payment;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderemTime() {
		return orderemTime;
	}

	public void setOrderemTime(Date orderemTime) {
		this.orderemTime = orderemTime;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((orderemTime == null) ? 0 : orderemTime.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
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
		Ordered other = (Ordered) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderemTime == null) {
			if (other.orderemTime != null)
				return false;
		} else if (!orderemTime.equals(other.orderemTime))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		return true;
	}
	
	
	

}
