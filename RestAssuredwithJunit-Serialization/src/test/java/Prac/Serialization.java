package Prac;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import RestAssured.RestAssured.Jsonpath;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Serialization {
	
	static ObjectMapper mapper = new ObjectMapper();
	
	@Test
	public void Serial() throws JsonProcessingException {
		
		//Java Object
		dataPojo dP = new dataPojo();
		dP.setId(10);
		dP.setName("Mohammed");
		dP.setEmail("Moyin@Sony.com");
		dP.setGender("Male");
		dP.setStatus("active");
		
		String url ="https://gorest.co.in/public/v1/users/";
		
		//Json Object
		String json = mapper.writeValueAsString(dP);
		//POST
		Response response_post = RestAssured
				.given()
				.header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
        		.contentType(ContentType.JSON)
        		.body(dP)
				.when().post(url).andReturn();
//				.then().log().all().extract().response();
		System.out.println(response_post.asString());
		//GET
		Response response_get = RestAssured
				.given()
				.header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
        		.when().get(url).andReturn();
		//		.then().log().all().extract().response();
		
		JsonPath jsonpath = response_get.jsonPath();
		String ID = jsonpath.getString("data[0].id");
		System.out.println(ID);
		
		//GET
		Response response_get_ID = RestAssured
				.given()
				.header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
        		.when().get(url+ID).andReturn();
		//		.then().assertThat().statusCode(200).log().all().extract().response();
		System.out.println(response_get_ID.asString());
	}

}
