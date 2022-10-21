package com.API.Automation.Utility;

import org.springframework.boot.test.autoconfigure.webservices.client.WebServiceClientTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.API.Automation.RequestResponse.RequestClient;

@Service
public class Appconfig {

	public static ConfigurableEnvironment properties() throws InterruptedException {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(PropertySourcesApp.class);
		context.refresh();

		return context.getEnvironment();

	}

}
