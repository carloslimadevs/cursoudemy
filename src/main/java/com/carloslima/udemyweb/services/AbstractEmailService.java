package com.carloslima.udemyweb.services;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.carloslima.udemyweb.domain.Ordered;

@Service
public abstract class AbstractEmailService implements EmailService{

	@Value("${default.sender}")
	private String sender;

	@Autowired
	private TemplateEngine templateEngine;

	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfirmationEmail(Ordered obj) {

		SimpleMailMessage smm = prepareSimpleMailMessageTest();
		sendEmail(smm);

	}

	@Override
	public void sendOrderConfirmationHtmlEmail(Ordered obj) {
		try {
			MimeMessage mm = prepareEmailMimeMessageTest();
			sendHtmlEmail(mm);
		} catch (MessagingException e) {

			sendOrderConfirmationEmail(obj);
		}

	}

	/*
	 * Metodo para preparar o email a ser enviado
	 * Injeção da Dependencia JavaMailSender para instanciar o MimeMessage
	 */
	private MimeMessage prepareEmailMimeMessageTest() throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage,true);
		mimeMessageHelper.setTo("carloscmbl20@gmail.com");
		mimeMessageHelper.setFrom(sender);
		mimeMessageHelper.setSubject("Teste");
		mimeMessageHelper.setSentDate(new Date(System.currentTimeMillis()));
		mimeMessageHelper.setText(htmlFromTemplate(null));
		// TODO Auto-generated method stub
		return mimeMessage;
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


	/*
	 * Metodo para enviar email baseado no template
	 * context do spring thymeleaf
	 * setvariable para povoar o template em resources/templates/email
	 * processar o template usando TemplateEngine(injeção de dependência)
	 */
	protected String htmlFromTemplate(Ordered obj) {
		Context context = new Context();

		context.setVariable("ordered", obj);

		//Retorna o HTML em forma de String
		return templateEngine.process("email/confirmationMail", context);

	}
}
