package com.carloslima.udemyweb.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.carloslima.udemyweb.services.DBService;

@Configuration
@Profile("dev")

public class AppDevConfig {
	@Autowired
	private DBService  dbservice;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instatiateDatabase() throws ParseException {
		
		if (!strategy.equalsIgnoreCase("create")) {
			return false;
		}
		dbservice.instatiateTestDataBase();
		return true;
	}
}
