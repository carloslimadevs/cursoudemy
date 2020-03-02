package com.carloslima.udemyweb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;


public class MockEmailService extends AbstractEmailService{

	private static final Logger logger = LoggerFactory.getLogger(MockEmailService.class);
	@Override
	public void sendEmail(SimpleMailMessage msg) {

		logger.info("simulando envio de email");
		logger.info(msg.toString());
		logger.info("email enviado");
	}

}
