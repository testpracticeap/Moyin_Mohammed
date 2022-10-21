package RestAssured.RestAssured;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.Configuration.ConfigurationBuilder;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.NameAndValue;
import io.restassured.internal.mapping.GsonMapper;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Deserialization {

	@Test
	public void getJsonFile() throws URISyntaxException, IOException {

		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();
		// Response Object
		Response response = httpRequest.request(Method.GET, "");

		String responseBody = response.getBody().asString();
		System.out.println(responseBody);

		// Print Response in console window

		// io.com.jayway.jsonpath jsonpath= response.jsonPath();
		io.restassured.path.json.JsonPath jsonpath = response.jsonPath();
		String number = jsonpath.getString("books[0].isbn");
		System.out.println(number); // 2
		Object isbn = com.jayway.jsonpath.JsonPath.read(response.asString(), "$.books[0]");
		System.out.println(isbn.toString());
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(isbn);
		
		TypeReference<HashMap<String, Object>> typeref = new TypeReference<HashMap<String, Object>>() {

		};

		HashMap<String, Object> entry = mapper.readValue(json, typeref);

		for (Entry<String, Object> book : entry.entrySet()) {

			System.out.println(" " + book.getKey() + " :" + book.getValue());
			

		}
		

	}

}
