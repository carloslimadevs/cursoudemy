package com.carloslima.udemyweb.services;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.carloslima.udemyweb.domain.Ordered;

@Service
public interface EmailService {

	void sendOrderConfirmationEmail(Ordered obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Ordered obj);

	void sendHtmlEmail(MimeMessage msg);


}
