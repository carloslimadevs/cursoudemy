package com.carloslima.udemyweb.domain.enums;

public enum CustomerType {
	
	COMMONCOSTUMER(1, "Common Costumer"),
	LEGALCOSTUMER(2, "Legal Costumer");
	
	private int identifier;
	private String description;
	
	private CustomerType() {
		
	}
	
	private CustomerType(int identifier, String description) {
		this.identifier = identifier;
		this.description = description;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static CustomerType toEnum(Integer identifier) {
		if (identifier == null) {
			return null;
		}
		for (CustomerType customerType : CustomerType.values()) {
			if(identifier.equals(customerType.getIdentifier())){
				return customerType;
			}
		}
		
		throw new IllegalArgumentException("Invalid Customer Type identifier: " + identifier);
	}
}
