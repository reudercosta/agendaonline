package com.reuder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.reuder.service.DbService;
import com.reuder.service.EmailService;
import com.reuder.service.SmtpEmailService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbsevice;
	
	@Value("$(spring.jpa.hibernate.ddl-auto)")
	private String strategy;

	@Bean
	public boolean instantiateDataBase() throws ParseException{
		
		if ("create".equals(strategy)) {
			return false;
		}


		dbsevice.instantiateTestDataBase();

		return true;
	}
	
	@Bean	
	public EmailService emailService() {
		return new SmtpEmailService();
	}
	
}
