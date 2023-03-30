package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class Kafka1TopicCreateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Kafka1TopicCreateApplication.class, args);
	}
	
	@Bean
	public NewTopic topic() {
//		TopicBuilder.name("MyTopic").partitions(10).replicas(1).build();
		System.out.println("-----------------Topic Created-----------------");
		return TopicBuilder.name("MyTopic").build();
	}

}
