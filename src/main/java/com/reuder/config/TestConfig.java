package com.reuder.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.expression.ParseException;

import com.reuder.service.DbService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DbService dbsevice;

	@Bean
	public boolean instantiateDataBase() throws ParseException{

		dbsevice.instantiateTestDataBase();

		return true;
	}

	
}
