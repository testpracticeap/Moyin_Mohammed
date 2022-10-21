package com.APIAutomation.Stepdefinition;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.API.Automation.RequestResponse.PropertCollection;
import com.API.Automation.RequestResponse.RequestClient;
import com.API.Automation.Utility.Appconfig;
import com.API.Automation.Utility.PropertySourcesApp;

import io.cucumber.java.en.Given;
import static io.restassured.RestAssured.*;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public  class RestAssuredTests {

@Autowired
 RequestClient requestclient;

@Autowired
 Appconfig appconfig;



@Given("^Initiate  a Request client To API$")
public 	void GetRequest() throws InterruptedException {
		
	requestclient.WebserviceRequest(appconfig.properties().getProperty("URL"), appconfig.properties().getProperty("filetype"));
    	
		
		
		
		
	}

}
