package com.carloslima.udemyweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.carloslima.udemyweb.domain.enums.AccessProfileType;
import com.carloslima.udemyweb.domain.enums.CustomerType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CustomerSeq" )
	@SequenceGenerator(allocationSize = 1, initialValue = 1,name = "CustomerSeq", sequenceName = "CustomerSeq")
	private Integer id;
	private String name;
	private String email;
	private String document;
	private Integer customerType;

	@JsonIgnore
	private String senha;
	
	@OneToMany(mappedBy = "customer")
	private List<Address> addresses = new ArrayList<Address>();
	
	@ElementCollection
	@CollectionTable(name = "CONTACTS")
	private Set<String> contacts = new HashSet<String>();

	@JsonBackReference
	@OneToMany(mappedBy = "customer")
	private List<Ordered> ordereds = new ArrayList<Ordered>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "PROFILES")
	private Set<Integer> profiles = new HashSet<Integer>();
	public Customer() {
		super();
		addProfile(AccessProfileType.PUBLIC);
		// TODO Auto-generated constructor stub
	}

	public Customer(Integer id, String name, String email, String document, CustomerType customerType) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.document = document;
		this.customerType = customerType.getIdentifier();
		addProfile(AccessProfileType.PUBLIC);

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

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public CustomerType getCustomerType() {
		return CustomerType.toEnum(customerType);
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType.getIdentifier();
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Set<String> getContacts() {
		return contacts;
	}

	public void setContacts(Set<String> contacts) {
		this.contacts = contacts;
	}

	public List<Ordered> getOrdereds() {
		return ordereds;
	}

	public void setOrdereds(List<Ordered> ordereds) {
		this.ordereds = ordereds;
	}

	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<AccessProfileType> getProfiles(){
		
		return profiles.stream().map(x -> AccessProfileType.toEnum(x)).collect(Collectors.toSet());
		
	}
	
	public void addProfile(AccessProfileType profile){
		
		this.profiles.add(profile.getIdentifier());
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
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", document=" + document
				+ ", customerType=" + customerType + ", addresses=" + addresses + ", contacts=" + contacts + "]";
	}
	
	
}
