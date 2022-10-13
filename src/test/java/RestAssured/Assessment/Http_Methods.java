package RestAssured.Assessment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Http_Methods {

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

	@Test
	public void B_POST() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/RestAssured.json"));
		String Post_data = new String(b);

		Response response = given().contentType(ContentType.JSON).body(Post_data)

				.when().post("/users")

				.then().log().all().assertThat().statusCode(201).extract().response();

	}

	@Test
	public void C_PUT() throws IOException {

		byte[] b = Files.readAllBytes(Paths.get("src/main/resources/Json/RestAssured.json"));
		String bdy = new String(b);

		Response response = given().header("Content-Type", "application/json").and().body(bdy)

				.when().put("/users/2")

				.then().log().all().assertThat().statusCode(200).extract().response();

	}

	@Test
	public void D_DELETE() {

		RestAssured.given().contentType(ContentType.JSON)

				.when().delete("/users/2")

				.then().log().all().assertThat().statusCode(204).extract().response().asString();

	}

}
