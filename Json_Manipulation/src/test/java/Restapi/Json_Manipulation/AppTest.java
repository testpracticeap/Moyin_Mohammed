package Restapi.Json_Manipulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AppTest {
	Response response;
	List<String> JP;

	@Before
	public void setup()

	{
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		
		response = RestAssured.given().contentType(ContentType.JSON).when().get("").then().assertThat().statusCode(200)
				.extract().response();
	}

	@Test
	public void A_Get_Books() {
		// <------------- Get All books -------------->
		JP = JsonPath.read(response.asString(), "$.books");
		System.out.println(JP);

	}

	@Test
	public void B_Get_books_isbn() {
		// <------------- Get All books isbn -------------->
		// JP = JsonPath.read(response.asString(), "$.books[:"+len+"].isbn");
		JP = JsonPath.read(response.asString(), "$.books[*].isbn");
		System.out.println(JP);

		// <----------- Validating ISBN ------------------>
		Assert.assertTrue(JP.contains("9781449325862"));

	}

	@Test
	public void C_Get_books_title() {
		// <------------- Get All books -------------->
		JP = JsonPath.read(response.asString(), "$.books[*].title");
		System.out.println(JP);

		// <----------- Validating ISBN ------------------>
		Assert.assertTrue(JP.contains("Learning JavaScript Design Patterns"));
	}

	@Test
	public void D_Get_books_subtitle() {
		// <------------- Get All books -------------->
		JP = JsonPath.read(response.asString(), "$.books[*].subTitle");
		System.out.println(JP);

		// <----------- Validating ISBN ------------------>
		Assert.assertTrue(JP.contains("The Definitive Guide for JavaScript Developers"));
	}

	@Test
	public void E_Get_books_pages() {
		JP = JsonPath.read(response.asString(), "$.books[?(@.pages<=300)].pages");
		System.out.println(JP);

	}

	@Test
	public void F_Get_books_pages_title() {
		JP = JsonPath.read(response.asString(), "$.books[?(@.pages<=250)].title");
		System.out.println(JP.get(0));

	}

}
