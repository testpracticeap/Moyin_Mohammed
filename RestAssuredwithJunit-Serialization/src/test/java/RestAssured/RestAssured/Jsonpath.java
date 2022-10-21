package RestAssured.RestAssured;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import io.restassured.RestAssured;
public class Jsonpath {
		
	@Test
		 public  void getJsonFile() throws URISyntaxException, IOException {

RestAssured.baseURI="https://demoqa.com/BookStore/v1/Books";
        
        //Request object
        RequestSpecification httpRequest=RestAssured.given(); 
        //Response Object
        Response response=httpRequest.request(Method.GET,"");
        
        String responseBody= response.getBody().asString();
        System.out.println(responseBody);
        
        //Print Response in console window
      
    // io.com.jayway.jsonpath jsonpath= response.jsonPath();
       io.restassured.path.json.JsonPath jsonpath= response.jsonPath();
        String number = jsonpath.getString("books[0].isbn");
        System.out.println(number); //2
        Object isbn= com.jayway.jsonpath.JsonPath.read(response.asString(),"$.books[0]");
    	System.out.println(isbn.toString());
    	
    	
        
	 }
	
	//@Test
	public void passFileAsPayload()
	{
	// Creating a File instance 
	File jsonDataInFile = new File("C:/Users/7000032427/eclipse-workspace/RestAssured/src/test/resources/json/widget.json");
	
	 RestAssured
	    .given()
			.baseUri("https:reqres.in/api/users")
			.contentType(ContentType.JSON)
			.body(jsonDataInFile)
	 //WHEN
		.when().
		post()
			.then().extract().response().asString();
	 //JsonPath jsonPath = new JsonPath(response().asString());
	 
		
}
	//@Test
	public   void readJSONfile() throws IOException {

	      //read data from local JSON file then store in byte array
	      byte[] b = Files.readAllBytes(Paths.get("src/test/resources/json/widget.json"));

	      //convert byte array to string
	      String bdy = new String(b);

	      //base URL
	      RestAssured.given()
	      
			.baseUri("https://jsonplaceholder.typicode.com").contentType(ContentType.JSON).body(bdy)

	      //adding post method
	      .when().post("/posts").then().log().all()

	      //verify status code as 201
	      .assertThat().statusCode(201);
	      
	      
	   }
	}
	
