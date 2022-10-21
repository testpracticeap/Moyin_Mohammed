package com.spring.main;

import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MessageController {

	@Autowired
	private SampleResponse response;

	@RequestMapping("/sample")
	public SampleResponse Sample(@RequestParam(value = "name", defaultValue = "Robot") String name) {
		// SampleResponse response = new SampleResponse();
		response.setId(2);
		response.setMessage("Your name is " + name);
		return response;

	}

}
