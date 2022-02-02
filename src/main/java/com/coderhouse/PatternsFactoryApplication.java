package com.coderhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@SpringBootApplication
public class PatternsFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsFactoryApplication.class, args);
	}

}
