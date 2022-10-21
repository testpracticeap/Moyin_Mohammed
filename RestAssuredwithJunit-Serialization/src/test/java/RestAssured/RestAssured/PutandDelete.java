package RestAssured.RestAssured;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.*;
import org.junit.Before;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PutandDelete {

	// https://jsonplaceholder.typicode.com

	@Before
	public void setup()

	{

		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

	}

	
//	{
//		  "title" : "foo1",
//		  "body" : "baz1",
//		  "userId" : "1",
//		  "id" : "102"
//		}
//	@Test
	public void putRequest() throws IOException

	{

		byte[] b = Files.readAllBytes(Paths.get("src/test/resources/json/Test.json"));

		String bdy = new String(b);

		Response response = given().

				header("Content-Type", "application/json").
				and()
				.body(bdy)
				.when()
				.put("/posts/1")
				.then()
				.log().all().extract().response();

		Assert.assertEquals(200, response.statusCode());
		Assert.assertEquals("foo1", response.jsonPath().getString("title"));
		Assert.assertEquals("baz1", response.jsonPath().getString("body"));
		Assert.assertEquals("1", response.jsonPath().getString("userId"));
		Assert.assertEquals("1", response.jsonPath().getString("id"));

	}
	
	@Test
	public  void delete() throws IOException
	{
	byte[] b = Files.readAllBytes(Paths.get("src/test/resources/json/Test.json"));

	String bdy = new String(b);

	Response response = given().

			header("Content-Type", "application/json").
			and()
			.body(bdy)
			.when()
			.delete("/posts/1")
			.then()
			.log().all().extract().response();
	
	}
}
