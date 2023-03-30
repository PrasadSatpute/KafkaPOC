package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("topicName")
public class TopicController {
	
	public NewTopic topic(String topic) {
		return TopicBuilder.name(topic).build();
	}
	
	@PostMapping(value = "/topic",consumes = {"application/json"},produces = {"application/json"})
    public void createTopic(@RequestBody Topic topic){
        topic(topic.getTopicName());
    }
	
}
