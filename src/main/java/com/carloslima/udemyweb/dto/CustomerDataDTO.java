package com.carloslima.udemyweb.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class CustomerDataDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	
	
	private String document;
	private Integer customerType;

	//Adress data
	private String street;
	private String number;
	private String optionalInformation;
	private String zipcode;
	
	private String phones;

	private Integer cityId;
	
	private String senha;
	
	public CustomerDataDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public Integer getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Integer customerType) {
		this.customerType = customerType;
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

	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}


	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public  Set<String> phonesToCustomerContacts(){
		
		return new HashSet<String>(Arrays.asList(this.phones.split(",")));
	}

}
