package com.example.demo.service;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.item.Item;

@Service
public class KafkaConsumerService {
	@KafkaListener(topics = "consumer-topic", groupId = "sample-group",containerFactory = "kafkaListener")
    public void consume(Item item){
        System.out.println("Consumed Message :"+item);
    }
}
