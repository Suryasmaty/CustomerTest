package com.test.sba5;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class CustomerApplication {
	public static Logger logger = LoggerFactory.getLogger(CustomerApplication.class);

	@PostConstruct
	public void init()
	{
		logger.info("application started");
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
