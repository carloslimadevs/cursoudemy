package com.carloslima.udemyweb.resources.handler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError(Integer status, String message, String string) {
		super(status, message, string);
		// TODO Auto-generated constructor stub
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void setErrors(List<FieldMessage> errorsList) {
		this.errors = errorsList;
	}
	
	public void addError(FieldMessage fieldMessage) {
		errors.add(fieldMessage);
	}
	
	public void addError(String fieldName, String message) {
		errors.add(new FieldMessage(fieldName, message));
	}
}
