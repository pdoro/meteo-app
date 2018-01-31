package com.pdomingo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages = "com.pdomingo.persistence")
public class RemoteMeteoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RemoteMeteoApplication.class);
	}
}
