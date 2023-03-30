package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;

@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class SpingBootKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpingBootKafkaConsumerApplication.class, args);
	}

}
