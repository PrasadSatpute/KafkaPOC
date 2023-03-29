package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class , JmxAutoConfiguration.class})
public class SpingBootEmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootEmployeeCrudApplication.class, args);
	}

}
