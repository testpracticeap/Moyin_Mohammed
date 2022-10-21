package Rest.apimaven;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import com.jayway.jsonpath.JsonPath;

import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Static_File_Post {
	
	@Test
	public void A_Get_before_Post() {
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		
		.when()
		.get("")
		
		.then()
		.assertThat()
		.statusCode(200)
		.extract()
		.response()
		.asString()
		;
		
		
	}
	
	
	//@Test
	public void B_Post() {
		
		File Post_data = new File("C:\\Users\\7000032445\\eclipse-workspace\\apimaven\\src\\main\\resources\\Json\\Post.json");
		
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		.auth().preemptive().basic(null, null)
		.contentType(ContentType.JSON)
		.body(Post_data)
		
		.when()
		.post("/create")
		
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(201)
		.toString();
					
	}
	
	//@Test
	public void C_Get_after_Post() {
		RestAssured
		.given()
		.baseUri("https://reqres.in/api/users")
		.contentType(ContentType.JSON)
		
		.when()
		.get("")
		
		.then()
		.log()
		.all()
		.assertThat()
		.statusCode(200)
		.toString();
		
		
	}
	
	
	

}





