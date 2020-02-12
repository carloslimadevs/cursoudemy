package com.carloslima.udemyweb.resources.handler;

import java.io.Serializable;

public class StandardError implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer status;
	private String message;
	private String timeStamp;
	
	public StandardError(Integer status, String message, String string) {
		super();
		this.status = status;
		this.message = message;
		this.timeStamp = string;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTimeStamp() {
		return timeStamp;
	}
	
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}
	
}
