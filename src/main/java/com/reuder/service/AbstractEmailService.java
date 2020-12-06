package com.reuder.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.reuder.domain.Agenda;
import com.reuder.domain.Paciente;

public abstract class AbstractEmailService implements EmailService{
	
	@Value("${default.sender}")
	private String sender;
	
	@Autowired
	private TemplateEngine templateEngine;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Override
	public void sendOrderConfirmationEmail(Agenda obj) {
		SimpleMailMessage sm = prepareSimpleMailMessageFromAgenda(obj);
		sendEmail(sm);
		
	}

	protected SimpleMailMessage prepareSimpleMailMessageFromAgenda(Agenda obj) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(obj.getPaciente().getEmail());
		sm.setFrom(sender);
		sm.setSubject("Agendamento Confirmando: " + obj.getId());
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText(obj.toString());
		return sm;
	}
	
	protected String htmlFromTemplateAgenda(Agenda obj) {
		Context context = new Context();
		context.setVariable("agenda", obj);
		return templateEngine.process("email/confirmationAgenda", context);
	 
	}
	public void sendOrderConfirmationHtmlEmail(Agenda obj) {
		try {
		MimeMessage mm = prepareMimeMessageFromAgenda(obj);
		sendHtmlEmail(mm);
		}
		catch(MessagingException e){
			sendOrderConfirmationEmail(obj);
		}
	}
	
	protected MimeMessage prepareMimeMessageFromAgenda(Agenda obj) throws MessagingException{
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
		mmh.setTo(obj.getPaciente().getEmail());
		mmh.setFrom(sender);
		mmh.setSubject("Agendamento Realizado! Codigo: " + obj.getId());
		mmh.setSentDate(new Date(System.currentTimeMillis()));
		mmh.setText(htmlFromTemplateAgenda(obj),true);
		return mimeMessage;
	}
	
	@Override
	public void sendNewPasswordEmail(Paciente paciente, String newPass) {
		SimpleMailMessage sm = prepareNewPasswordEmail(paciente, newPass);
		sendEmail(sm);
	}
	
	protected SimpleMailMessage prepareNewPasswordEmail(Paciente paciente, String newPass) {
		SimpleMailMessage sm = new SimpleMailMessage();
		sm.setTo(paciente.getEmail());
		sm.setFrom(sender);
		sm.setSubject("Solicitação de nova senha");
		sm.setSentDate(new Date(System.currentTimeMillis()));
		sm.setText("Nova Senha: "+paciente.getSenha()+"- " +newPass);
		return sm;
	}
}
