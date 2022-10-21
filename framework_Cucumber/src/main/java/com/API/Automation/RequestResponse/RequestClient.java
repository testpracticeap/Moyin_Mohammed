package com.API.Automation.RequestResponse;

import io.restassured.http.Method;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

@Component
public class RequestClient {

	public static String WebserviceRequest(String URL, String fileType) {

		Response response = RestAssured.given().contentType(fileType).log().all().when().get(URL).andReturn();
		return response.asString();

	}

}
