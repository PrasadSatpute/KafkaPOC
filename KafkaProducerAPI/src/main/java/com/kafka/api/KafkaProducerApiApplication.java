package com.kafka.api;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class KafkaProducerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaProducerApiApplication.class, args);
	}
	
	@Bean
	public NewTopic topic() {
//		TopicBuilder.name("MyTopic").partitions(10).replicas(1).build();
		return TopicBuilder.name("Topic1").build();
	}

}
