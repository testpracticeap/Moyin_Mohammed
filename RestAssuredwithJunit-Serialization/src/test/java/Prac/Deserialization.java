package Prac;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Deserialization {
	
	@Test
	public void GET() throws IOException {
		
		String url = "https://demoqa.com/BookStore/v1/Books";
		
//		Response response = RestAssured.given().baseUri(url)
//				.when().get("")
//				.then().log().all();
//		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/RestAssured.json"));
//		String data = new String(b);
		
		Response response = RestAssured
				.given().baseUri(url)
        		.when().get("")
        		.then().log().all().extract().response();
		
		Object jsonpath = JsonPath.read(response.asString(), "$.books[0]");
		//Json Object
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(jsonpath);
		
		//Java Object
		
		TypeReference<HashMap<String, Object>> typeref = new TypeReference<HashMap<String, Object>>(){
			
		};
		HashMap<String, Object> entry = mapper.readValue(json, typeref);
		for(Entry <String, Object> book: entry.entrySet()) {
			System.out.println(book.getKey() + ": "+book.getValue());
		}
	}
}
