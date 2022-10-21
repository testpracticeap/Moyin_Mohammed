package SerializationRestassured;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class serialDeserialTest 
{
	
	//"https://gorest.co.in/my-account/access-tokens": access tokens 
	
    private static final ObjectMapper MAPPER = new ObjectMapper();
    
    @Test
    public void serTest() throws JsonProcessingException
    {
       dataPojo dp = new dataPojo();
        
        dp.setId(15666);
        dp.setName("Test");
        dp.setEmail("API1@hotmail.com");
        dp.setGender("Female");
        dp.setStatus("active");
    
        String url = "https://gorest.co.in/public/v1/users/";
        String json = MAPPER.writeValueAsString(dp);
    
        Response response = RestAssured.given()
        		.header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed").
        		contentType("application/json").
        		log().all().
        		body(dp).
        		when().
        		post(url).andReturn();
        	
        		
//        int statusCode = response.getStatusCode();
//        assertEquals(201, statusCode);
    
        Response response2 = RestAssured.given().
        		header("Authorization","Bearer 24f4362e9a1a17afa8ad5da989bae75c6fe09f271913f5a71c27b88726157fed")
        		.queryParam("email", "API1@hotmail.com"). when().get("https://gorest.co.in/public/v1/users");
        System.out.println(response2.asString());
        io.restassured.path.json.JsonPath jsonpath= response2.jsonPath();
                
        String ID = jsonpath.getString("data[0].id"); 
        
//        JsonPath js=new JsonPath(response2.toString());
//       System.out.println("****************************"+response2.toString());
//       
//        String ID=js.getString("data[0].id");
        
    
        System.out.println("****************************");
        System.out.println(ID);
        System.out.println("****************************");
       
        Response response3 = RestAssured.get("https://gorest.co.in/public/v1/users/"+ID);
        System.out.println(response3.asString());
        
//        Response response4 = RestAssured.get("https://gorest.co.in/public/v1/users/?"+ID);
//        System.out.println(response4.asString());
        
    }
}