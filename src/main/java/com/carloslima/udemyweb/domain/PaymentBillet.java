package com.carloslima.udemyweb.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.carloslima.udemyweb.domain.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PaymentBillet extends Payment{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date limitDateOfPayment;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dateOfPayment;
	
	public PaymentBillet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentBillet(Integer id, PaymentStatus status, Ordered ordered,
			Date limitDateOfPayment, Date dateOfPayment) {
		super(id, status, ordered);
		this.dateOfPayment = dateOfPayment;
		this.limitDateOfPayment = limitDateOfPayment;
		// TODO Auto-generated constructor stub
	}

	public Date getLimitDateOfPayment() {
		return limitDateOfPayment;
	}

	public void setLimitDateOfPayment(Date limitDateOfPayment) {
		this.limitDateOfPayment = limitDateOfPayment;
	}

	public Date getDateOfPayment() {
		return dateOfPayment;
	}

	public void setDateOfPayment(Date dateOfPayment) {
		this.dateOfPayment = dateOfPayment;
	}
	
	
}
