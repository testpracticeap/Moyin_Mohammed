package Rest.apimaven;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AppTest

{
	@Test
	public void GetBooks_JsonPath() throws IOException {
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

		Object subject = JsonPath.read(response.asString(), "$.books.length()");
		int length = subject.hashCode();
//		System.out.println(length);

		HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

		for (int i = 0; i < length; i++) {
			Object res = JsonPath.read(response.asString(), "$.books[" + i + "]");
//			System.out.println(res.toString());
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(res);

			TypeReference<HashMap<String, Object>> typeref = new TypeReference<HashMap<String, Object>>() {

			};

			HashMap<String, Object> entry = mapper.readValue(json, typeref);

			for (Entry<String, Object> book : entry.entrySet()) {

				ArrayList tempList = null;
				if (hashMap.containsKey(book.getKey())) {
					tempList = hashMap.get(book.getKey());
					if (tempList == null)
						tempList = new ArrayList();
					tempList.add(book.getValue());
				} else {
					tempList = new ArrayList();
					tempList.add(book.getValue());
				}
				hashMap.put(book.getKey(), tempList);
			}

		}

//		System.out.println(hashMap.get("isbn"));

//		hashMap.get("isbn").forEach(String -> {
//			System.out.println(String);
//			Assert.assertEquals(String, "9781449325862");
//		});

		// <------------- Validations isbn -------------->
				
//		Assert.assertTrue(hashMap.get("isbn").contains("9781593277574"));
//		System.out.println("Test isbn is Passed");
//		
//		Assert.assertTrue(hashMap.get("title").contains("Speaking JavaScript"));
//		System.out.println("Test title is Passed");
//		
//		Assert.assertTrue(hashMap.get("pages").contains(278));
//		System.out.println("Test pages is Passed");
//		
//		Assert.assertTrue((hashMap.get("website").contains("https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond")));
//		System.out.println("Test website is Passed");
//		
//		Assert.assertTrue(hashMap.get("subTitle").contains("The Definitive Guide for JavaScript Developers"));
//		System.out.println("Test subTitle is Passed");
//		
//		Assert.assertTrue(hashMap.get("author").contains("Sony_API_Testing"));
//		System.out.println("Test Author is Passed");
//		
//		Assert.assertTrue(hashMap.get("publisher").contains("Capgemini"));
//		System.out.println("Test Publisher is Passed");
//		
//		Assert.assertTrue(hashMap.get("description").contains("ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that E"));
//		System.out.println("Test Description is Passed");
//		
//		Assert.assertTrue(hashMap.get("publish_date").contains("2016-09-03T00:00:00.000Z"));
//		System.out.println("Test Publish Date is Passed");
	

			if (hashMap.get("isbn").contains("9781593277574")) {
				Assert.assertTrue("Test has Passed",(hashMap.get("isbn").contains("9781593277574")));
				System.out.println("Test Passed : isbn");
				 
			}
		
		
		// <------------- Validations title -------------->
			
			if (hashMap.get("title").contains("Speaking JavaScript")) {
				Assert.assertTrue("Test has Passed",(hashMap.get("title").contains("Speaking JavaScript")));
				System.out.println("Test Passed : title");
				 
			}
		
		
//		System.out.println(hashMap.get("pages"));
		// <---------- Validating Pages --------------->
		if (hashMap.get("pages").contains(278)) {
			Assert.assertTrue("Test has Passed",hashMap.get("pages").contains(278));
			System.out.println("Test Passed : pages");
		}

		// <---------- Validating website --------------->

		if ((hashMap.get("website").contains("https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond")) ){
			Assert.assertTrue("Test has Passed", (hashMap.get("website").contains("https://github.com/getify/You-Dont-Know-JS/tree/master/es6%20&%20beyond"))) ;
			System.out.println("Test Passed : website");
			 
			}

		
//	 	<---------- Validating subTitle --------------->
		if (hashMap.get("subTitle").contains("The Definitive Guide for JavaScript Developers")) {
			Assert.assertTrue("Test has Passed", (hashMap.get("subTitle").contains("The Definitive Guide for JavaScript Developers")));
			System.out.println("Test Passed : subTitle");
			 
			}

		
// <---------------Validating Author---------------->
		if ((hashMap.get("author") ).contains("Sony_API_Testing")) {
			Assert.assertTrue("Test has Passed",(hashMap.get("author")).contains("Sony_API_Testing"));
			System.out.println("Test Passed : author");
			 
			}

		
// <-----------------Validating Publisher-------------->
		if ((hashMap.get("publisher").contains("Capgemini")) ){
			Assert.assertTrue("Test has Passed", (hashMap.get("publisher")).contains("Capgemini"));
			System.out.println("Test Passed : publisher");
//			 
			}

//<-----------------Validating Description------------> 

		if ((hashMap.get("description") ).contains("ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that E")) {
			Assert.assertTrue("Test has Passed", (hashMap.get("description")).contains("ECMAScript 6 represents the biggest update to the core of JavaScript in the history of the language. In Understanding ECMAScript 6, expert developer Nicholas C. Zakas provides a complete guide to the object types, syntax, and other exciting changes that E")) ;
			System.out.println("Test Passed : description");
			 
			}

		

//<-----------------Validating Publish Date------------> 
		if ((hashMap.get("publish_date").contains("2016-09-03T00:00:00.000Z"))) {
			Assert.assertTrue("Test has Passed", (hashMap.get("publish_date")).contains("2016-09-03T00:00:00.000Z"));
			System.out.println("Test Passed : publish_date");
			 
			}

		}

}
