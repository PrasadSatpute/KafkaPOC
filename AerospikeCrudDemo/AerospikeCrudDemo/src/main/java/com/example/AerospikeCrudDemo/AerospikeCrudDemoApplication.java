package com.example.AerospikeCrudDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AerospikeCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AerospikeCrudDemoApplication.class, args);
	}

}
