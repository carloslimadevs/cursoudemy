package com.carloslima.udemyweb.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Ordered;

@Service
public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Override
	public void sendOrderConfirmationEmail(Ordered obj) {
		
		SimpleMailMessage smm = prepareSimpleMailMessageTest();
		sendEmail(smm);
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromOrder(Ordered obj) {
		SimpleMailMessage smm = new SimpleMailMessage();
		
		smm.setTo(obj.getCustomer().getEmail());
		smm.setFrom(sender);
		smm.setSubject("Teste");
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText("teste");
		return null;
	}

	protected SimpleMailMessage prepareSimpleMailMessageTest() {
		SimpleMailMessage smm = new SimpleMailMessage();
		
		smm.setTo("carloscmbl20@gmail.com");
		smm.setFrom(sender);
		smm.setSubject("Teste");
		smm.setSentDate(new Date(System.currentTimeMillis()));
		smm.setText("teste");
		return smm;
	}
}
