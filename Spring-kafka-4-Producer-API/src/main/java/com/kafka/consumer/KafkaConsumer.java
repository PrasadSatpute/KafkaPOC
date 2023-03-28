package com.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.producer.KafkaProducer;

@Service
public class KafkaConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener(topics = "MyTopic", groupId = "myGroup")
	public void consume(String message)
	{
		LOGGER.info(String.format("Message recived -> %s", message));
	}
	
}
