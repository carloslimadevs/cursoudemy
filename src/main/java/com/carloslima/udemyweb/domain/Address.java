package com.carloslima.udemyweb.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Address implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "AddressSeq" )
	@SequenceGenerator(allocationSize = 1, initialValue = 1,name = "AddressSeq", sequenceName = "AddressSeq")
	private Integer id;
	private String street;
	private String number;
	private String optionalInformation;
	private String zipcode;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(Integer id, String street, String number, String optionalInformation, String zipcode,
			Customer customer, City city) {
		super();
		this.id = id;
		this.street = street;
		this.number = number;
		this.optionalInformation = optionalInformation;
		this.zipcode = zipcode;
		this.customer = customer;
		this.city = city;
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOptionalInformation() {
		return optionalInformation;
	}

	public void setOptionalInformation(String optionalInformation) {
		this.optionalInformation = optionalInformation;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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
		Address other = (Address) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + "]";//", street=" + street + ", number=" + number + ", optionalInformation="
				//+ optionalInformation + ", zipcode=" + zipcode + ", customer=" + customer + ", city=" + city + "]";
	}
	
	
}
