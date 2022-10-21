package Rest.mavenapi;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
//import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import com.jayway.jsonpath.JsonPath;

public class AppTest {

	// <-------------Correct URL and Correct Response Status Code------------>

	//@Test
	public void GetBooks_Correct_URL_Correct_Response() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		response = httpreq.get("");

		// <------------------------------------------------->
		int Res_exp = 200;
		int Res_act = response.getStatusCode();
		System.out.println(
				"Expected Status Code: " + Res_exp +
				" Actual Status Code: " + response.getStatusCode()
				);
		Assert.assertEquals(Res_exp, Res_act);

	}

	// <-------------Incorrect URL and Correct Response Status Code------------>

	//@Test
	public void GetBooks_Incorrect_URL_Correct_Response() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <----------------------------------------------->
		response = httpreq.get("ABA$");
		int Response_exp = 200;
		int Response_act = response.getStatusCode();
		System.out.println(
				"Expected Status Code: " + Response_exp +
				" Actual Status Code: " + response.getStatusCode()
				);
		Assert.assertEquals(Response_exp, Response_act);

	}

	// <-------------Correct URL and Incorrect Response Status Code------------>

	//@Test
	public void GetBooks_Correct_URL_Incorrect_Response() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <---------------------------------------------->
		response = httpreq.get("");
		int Response_exp = 401;
		int Response_act = response.getStatusCode();
		System.out.println(
				"Expected Status Code: " + Response_exp +
				" Actual Status Code: " + response.getStatusCode()
				);
		Assert.assertEquals(Response_exp, Response_act);

	}

	// <-------------Incorrect URL and Incorrect Response Status Code------------>

	//@Test
	public void GetBooks_Incorrect_URL_Incorrect_Response() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <------------------------------------------------>
		response = httpreq.get("$$$$");
		int Response_exp = 401;
		int Response_act = response.getStatusCode();
		System.out.println(
				"Expected Status Code: " + Response_exp +
				" Actual Status Code: " + response.getStatusCode()
				);
		Assert.assertEquals(Response_exp, Response_act);

	}
	
	//<------------------ Validating Headers --------------->

	//@Test
	public void GetBooks_Headers() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <------------------------------------------------>
		response = httpreq.get("");
		Headers headers =response.getHeaders();
		
		for(Header headersec:headers)
		 {
			 
			System.out.println("Key: "+headersec.getName() +" | "+"Value: "+headersec.getValue() ); 
		 }
		
	}
	
	@Test
	public void GetBooks_JsonPath() {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <------------------------------------------------>
		response = httpreq.get("");
		
		// <------------- RestAssured JsonPath -------------->
//		io.restassured.path.json.JsonPath JP = response.jsonPath();
//		System.out.println(JP.getString("books[0]"));
		
		// <------------- Jayway JsonPath ------------------>
		Object subject = JsonPath.read(response.asString(),"$.books[0]");
		System.out.println(subject.toString());
        
        
//        Object JW = JsonPath.read(response.asString(), "$.books[0]");
//		System.out.println(JW);  
		
		
	}
}
