package com.carloslima.udemyweb.domain.enums;

public enum AccessProfileType {
	
	ADMIN(1, "ROLE_ADMIN"),
	PUBLIC(2, "ROLE_PUBLIC");
	
	private int identifier;
	private String description;
	
	private AccessProfileType() {
		
	}
	
	private AccessProfileType(int identifier, String description) {
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
	
	public static AccessProfileType toEnum(Integer identifier) {
		if (identifier == null) {
			return null;
		}
		for (AccessProfileType customerType : AccessProfileType.values()) {
			if(identifier.equals(customerType.getIdentifier())){
				return customerType;
			}
		}
		
		throw new IllegalArgumentException("Invalid Access Type: " + identifier);
	}
}
