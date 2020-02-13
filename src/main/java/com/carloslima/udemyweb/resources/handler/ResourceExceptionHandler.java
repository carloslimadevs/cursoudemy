package com.carloslima.udemyweb.resources.handler;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carloslima.udemyweb.services.exception.DataIntegrityException;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	ZoneId zoneId = ZoneId.systemDefault();
	//ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound (ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError error =  new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), dateFormatter() );
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<StandardError> dataIntegrityError (DataIntegrityException e, HttpServletRequest request){
		
		StandardError error =  new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), dateFormatter() );
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	public String dateFormatter() {
		Instant instant = Instant.ofEpochMilli( System.currentTimeMillis());
		ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
		return  zdt.format(formatter);

	}
}
