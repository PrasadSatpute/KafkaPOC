package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("producer")
public class HelloController {
	@Autowired
    KafkaTemplate<String,String> template;
    String TOPIC_NAME = "producer-topic";

    @GetMapping("/say/{msg}")
    public String postMessage(@PathVariable("msg") String msg){
        template.send(TOPIC_NAME,msg);
        return "Message published successfully";
    }
}
