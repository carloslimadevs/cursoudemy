package com.carloslima.udemyweb.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carloslima.udemyweb.services.DBService;
import com.carloslima.udemyweb.services.EmailService;
import com.carloslima.udemyweb.services.MockEmailService;

@Configuration
@Profile("test")
public class AppTestConfig {
	@Autowired
	private DBService  dbservice;
	
	@Bean
	public boolean instatiateDatabase() throws ParseException {
		
		dbservice.instatiateTestDataBase();
		return true;
	}
	
	@Bean
	public EmailService emailService()  {
		
		return new MockEmailService();
	}
}
