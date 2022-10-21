package Assessment.RestAssuredAPI;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

	private static ObjectMapper mapper = new ObjectMapper();
	String url = "https://reqres.in/api/users";
	String Id;
	
	// Post the data to API
	@Test
	public void A_POST() {

		String url = "https://reqres.in/api/users";

		File data = new File(
				"C:\\Users\\7000032445\\eclipse-workspace\\RestAssuredAPI\\src\\main\\resoures\\Json\\data.json");

		Response response = RestAssured
				.given().contentType(ContentType.JSON).body(data)
				.when().post(url)
				.then().assertThat().statusCode(201).extract().response();

		// Fetching the id from the posted data
		io.restassured.path.json.JsonPath jsonpath = response.jsonPath();
		// io.restassured.jsonpath.JsonPath jsonpath = new JsonPath(json);
		Id = jsonpath.getString("id");
		String data2 = response.asString();
		System.out.println("Post Data: "+data2);
		System.out.println(Id);
		
	}
	
	// Get the data with ID
	
	@Test
	public void B_Get_ID() {
		
		Response response_get = RestAssured
				.given().contentType(ContentType.JSON)
				.when().get(url + "/" + Id).andReturn()
				.then().extract().response();
		System.out.println("Get Id: "+response_get.asString());
		
	}
	
	// Delete the data with ID
	
	@Test
	public void C_Del_ID() {
		
		Response response_del = RestAssured
				.given().contentType(ContentType.JSON)
				.when().delete(url + "/" + Id)
				.then().extract().response();
		System.out.println("Delete id: "+response_del.asString());
	}

	// Check the data of deleted ID
	
	@Test
	public void D_Check_ID() {
	
		Response response_get_after_del = RestAssured
				.given().contentType(ContentType.JSON)
				.when().get(url + "/" + Id).andReturn()
				.then().extract().response();
		System.out.println("Check Id: "+response_get_after_del.asString());

	}

}