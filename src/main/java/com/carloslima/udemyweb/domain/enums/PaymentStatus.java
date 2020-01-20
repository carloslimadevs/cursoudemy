package com.carloslima.udemyweb.domain.enums;

public enum PaymentStatus {
	
	PAYED(1, "Payed"),
	INPROCESS(2, "In process..."),
	CANCELLED(3 , "Cancelled");
	
	private int identifier;
	private String description;
	
	private PaymentStatus() {
		
	}
	
	private PaymentStatus(int identifier, String description) {
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
	
	public static PaymentStatus toEnum(Integer identifier) {
		if (identifier == null) {
			return null;
		}
		for (PaymentStatus paymentStatus : PaymentStatus.values()) {
			if(identifier.equals(paymentStatus.getIdentifier())){
				return paymentStatus;
			}
		}
		
		throw new IllegalArgumentException("Invalid Payment Status identifier: " + identifier);
	}
}
