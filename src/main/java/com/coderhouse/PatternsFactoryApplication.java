package com.coderhouse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
//@EnableAutoConfiguration(exclude={MongoAutoConfiguration.class})
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@SpringBootApplication
public class PatternsFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatternsFactoryApplication.class, args);
	}

}
