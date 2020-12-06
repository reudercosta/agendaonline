package com.reuder.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.reuder.domain.Agenda;
import com.reuder.domain.Paciente;


public interface EmailService {

	void sendOrderConfirmationEmail(Agenda obj);

	void sendEmail(SimpleMailMessage msg);

	void sendOrderConfirmationHtmlEmail(Agenda obj);

	void sendHtmlEmail(MimeMessage msg);
	
	void sendNewPasswordEmail(Paciente paciente, String newPass);

}
