package Json.RestAPI;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;


import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {

	@Before
	public void setup()

	{
		RestAssured.baseURI = "https://reqres.in/api";
	}

	@Test
	public void A_GET() {

		RestAssured.given().contentType(ContentType.JSON)

				.when().get("/users")

				.then().log().all().assertThat().statusCode(200).extract().response().asString();

	}
   
}
