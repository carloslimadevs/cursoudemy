package com.carloslima.udemyweb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.carloslima.udemyweb.domain.Customer;

public class CustomerDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Mandatory")
	@Length(min = 5, max = 80, message = "name length must be between 5 - 80 characters")
	private String name;
	
	@NotEmpty(message = "Mandatory")
	@Email(message = "invalid email")
	private String email;

	
	/*
	 * @OneToMany(mappedBy = "customer") private List<Address> addresses = new
	 * ArrayList<Address>();
	 * 
	 * @ElementCollection
	 * 
	 * @CollectionTable(name = "CONTACTS") private Set<String> contacts = new
	 * HashSet<String>();
	 * 
	 * @JsonBackReference
	 * 
	 * @OneToMany(mappedBy = "customer") private List<Ordered> ordereds = new
	 * ArrayList<Ordered>();
	 */
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerDTO(Customer customer) {
		super();
		this.id = customer.getId();
		this.name = customer.getName();
		this.email = customer.getEmail();
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/*
	 * public String getDocument() { return document; }
	 * 
	 * public void setDocument(String document) { this.document = document; }
	 * 
	 * public CustomerType getCustomerType() { return
	 * CustomerType.toEnum(customerType); }
	 * 
	 * public void setCustomerType(CustomerType customerType) { this.customerType =
	 * customerType.getIdentifier(); }
	 * 
	 * public List<Address> getAddresses() { return addresses; }
	 * 
	 * public void setAddresses(List<Address> addresses) { this.addresses =
	 * addresses; }
	 * 
	 * public Set<String> getContacts() { return contacts; }
	 * 
	 * public void setContacts(Set<String> contacts) { this.contacts = contacts; }
	 * 
	 * public List<Ordered> getOrdereds() { return ordereds; }
	 * 
	 * public void setOrdereds(List<Ordered> ordereds) { this.ordereds = ordereds; }
	 */
}
