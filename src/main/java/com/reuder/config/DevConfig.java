package com.reuder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.reuder.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbservice;

	@Bean
	public boolean instantiatesDataBase() throws java.text.ParseException {

		dbservice.instantiateTestDataBase();

		return true;
	}

	
}
