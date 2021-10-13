package com.example.apachekafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	@Autowired
	private  Producer producer;
	
	@GetMapping("/greetings")
	public String greetings() {
		return "Hey";
	}
	
	@PostMapping("/publish")
	public void messageToTopic(@RequestParam("message") String message) {
		producer.sendMessage(message);
	}
	
	

}
