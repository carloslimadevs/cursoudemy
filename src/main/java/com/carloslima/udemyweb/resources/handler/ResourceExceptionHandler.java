package com.carloslima.udemyweb.resources.handler;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.carloslima.udemyweb.services.exception.AuthorizationException;
import com.carloslima.udemyweb.services.exception.DataIntegrityException;
import com.carloslima.udemyweb.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	ZoneId zoneId = ZoneId.systemDefault();
	
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError>  methodArgumentNotValid (MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError error =  new ValidationError(HttpStatus.BAD_REQUEST.value(),"Validation Errors", dateFormatter() );

		for (FieldError fieldError : e.getBindingResult().getFieldErrors()) {
			error.addError(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

	}
	
	@ExceptionHandler(AuthorizationException.class)
	public ResponseEntity<StandardError> unauthorizedException (AuthorizationException e, HttpServletRequest request){
		
		StandardError error =  new StandardError(HttpStatus.FORBIDDEN.value(), e.getMessage(), dateFormatter() );
		
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(error);
	}

	
	public String dateFormatter() {
		//Instant instant = Instant.ofEpochMilli( System.currentTimeMillis());
		//ZonedDateTime zdt = ZonedDateTime.ofInstant( instant , zoneId );
		return  ZonedDateTime.ofInstant( Instant.ofEpochMilli( System.currentTimeMillis()), zoneId ).format(formatter);

	}
}
