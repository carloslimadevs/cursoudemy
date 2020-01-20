package com.carloslima.udemyweb.domain;

import javax.persistence.Entity;

import com.carloslima.udemyweb.domain.enums.PaymentStatus;

@Entity
public class PaymentCard extends Payment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer parcelTime;

	public PaymentCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentCard(Integer id, PaymentStatus status, Ordered ordered, Integer parcelTime) {
		super(id, status, ordered);
		this.setParcelTime(parcelTime);
		// TODO Auto-generated constructor stub
	}

	public Integer getParcelTime() {
		return parcelTime;
	}

	public void setParcelTime(Integer parcelTime) {
		this.parcelTime = parcelTime;
	}
	
	
}
