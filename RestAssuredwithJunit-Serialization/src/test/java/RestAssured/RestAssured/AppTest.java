package RestAssured.RestAssured;

import static org.junit.Assert.assertTrue;

import java.io.File;


import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;


/**
 * Unit test for simple App.
 */
public class AppTest {

	//@Test
//	public void GetBooksDetails() {
//		
//
//		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//		RequestSpecification httpreq = RestAssured.given();
//		Response response = httpreq.request(Method.GET, "");
//		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
//		System.out.println(response.getStatusLine());
//		System.out.println(response.asString());
//		 response = httpreq.get("");
//		 //Postive case
//		 int statusCode=response.getStatusCode();
//		 Assert.assertEquals("The status Code", statusCode, 200);
//		System.out.println(statusCode);
//		
//
//	}
//	
//	@Test
//	public void GetBooksDetailsNegative() {
//		
//
//		RestAssured.baseURI = "https://demoqa.com/Account/v1/User/";
//		RequestSpecification httpreq = RestAssured.given();
//		Response response = httpreq.request(Method.GET, "");
//		
//		 response = httpreq.get("$%%%%");
//		 //Postive case
//		 int statusCode=response.getStatusCode();
//		 Assert.assertEquals("The status Code", statusCode, 401);
//		System.out.println(statusCode);
//		
//
//	}
//	
//	@Test
//	public void GetBooksDetailsHeaderResponse() {
//		
//
//		RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//		RequestSpecification httpreq = RestAssured.given();
//		Response response = httpreq.request(Method.GET, "");
//		
//		 response = httpreq.get("");
//		 
//		 Headers header=response.headers();
//		 
//		 
//		 for(Header headersec:header)
//		 {
//			 
//			System.out.println("value "+headersec.getName() +" "+":"+headersec.getValue() ); 
//		 }
//	}
//		 @Test
//			public void GetBooksDetailsHeaderResponseoneAtaTime() {
//				
//
//				RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//				RequestSpecification httpreq = RestAssured.given();
//				Response response = httpreq.request(Method.GET, "");
//				
//				 response = httpreq.get("");
//				 
//				 String header=response.header("Server");
//				 System.out.println(header ); 
//				 String header1=response.header("Content-Type");
//				 System.out.println(header1 );
//				
//				
//				
//
//	}
//		 
//		 
//		 
//		@Test
//			public void GetBooksDetailsResponseBody() {
//				
//
//				RestAssured.baseURI = "https://r.com/BookStore/v1/Books";
//				RequestSpecification httpreq = RestAssured.given();
//				Response response = httpreq.request(Method.GET, "");
//				
//				 response = httpreq.get("");
//				 
//				 ResponseBody resbody=response.getBody();
//				 
//				 System.out.println(resbody.asString());
//				 
//				
//				
//
//	}
//		 
//		 @Test
//			public void GetBooksDetailsResponseBodyvalidation() {
//				
//
//				RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//				RequestSpecification httpreq = RestAssured.given();
//				Response response = httpreq.request(Method.GET, "");
//				
//				 response = httpreq.get("");
//				 
//				 ResponseBody resbody=response.getBody();
//				 
//			 String response1=resbody.asString();
//			 Assert.assertEquals(response1.toLowerCase().contains("9781449325862"), true);
//				 
//				
//				
//
//	}
//		 
//		 @Test
//			public void GetBooksDetailsJsonPath() {
//				
//
//				RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
//				RequestSpecification httpreq = RestAssured.given();
//				Response response = httpreq.request(Method.GET, "");
//
//				response = httpreq.get("");
//
//				ResponseBody resbody = response.getBody();
//
//				String response1 = resbody.asString();
//				Assert.assertEquals(response1.toLowerCase().contains("9781449325862"), true);
//				
//				
//
//	}
//		 
		@Test
		 
			public void GetBooksJsonPath() {
				

				RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employee/1";
				RequestSpecification httpreq = RestAssured.given();
				Response response = httpreq.request(Method.GET, "");
				
				 response = httpreq.get("");
				JsonPath   jsonpath=response.jsonPath();
				
				String isbn=jsonpath.get("message");
				 System.out.println(isbn);
				
				
				

	}
//		 
//		 @Test
//		public void GetBooksDetailsqueryparam() {
//				
//
//				RestAssured.baseURI = "https://demoqa.com/BookStore/v1";
//				RequestSpecification httpreq = RestAssured.given();
//				Response response = httpreq.queryParam("ISBN", "9781593277574").get("/Book");
//				ResponseBody body = response.body();
//				ResponseBody resbody = response.getBody();
//				String response1 = resbody.asString();
//				JsonPath jpath = new JsonPath(response1);
//				String title = jpath.getString("title");
//				System.out.println(title);
//				
//				
//
//		 
//		 
//		 
//		 
//	 } 
//		 
		 
		 @Test
		public void PostRequest() {
				

				RestAssured.baseURI = "https://reqres.in/api/";
				RequestSpecification httpreq = RestAssured.given();
				JSONObject request=new JSONObject();
				request.put("name" ,"Test");
			request.put("job" ,"IT");
			httpreq.body(request.toJSONString());
				
				Response response=httpreq.post("users");
				ResponseBody body=response.getBody();
				System.out.println(body.asString());
				
				
				
				
				
				
				
				
				
				

		 
		 
		 
		 
	 } 
//		 
//		 
//		 
//		 
		 
		 
		 @Test
		    public void BasicAuth() {
		       RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password"); 
		       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
		       ResponseBody body = res.body();
		       //Converting the response body to string
		       String rbdy = body.asString();
		       System.out.println("Data from the GET API- "+rbdy);
		    }
		 
		 
		 
		    @Test
		    public void Preemptive() {
	        //Using the preemptive directive of basic auth to send credentials to the server
		        RequestSpecification httpRequest = RestAssured.given().auth().preemptive().basic("postman", "password");
		        Response res = httpRequest.get("https://postman-echo.com/basic-auth");
		        ResponseBody body = res.body();
		        //Converting the response body to string
	          String rbdy = body.asString();
		        System.out.println("Data from the GET API- "+rbdy);
		    }
//		    
		    
		   //Digest Authentication  
		    
		  //  RestAssured.given().auth().digest("postman", "password");
		    
		    
//		    
//		   
//		    
//		    
//		    
//		    //Form API
//		 //   given() .auth().form("your username", "your password").post("your end point URL")
//		    
//		    
		    
		 // Oauth
//			   // given().auth().oauth2("Access token").get("your end point URL") 
		    
		    
//		    //OAUTH  2.0
//		    //given().auth().oauth2("Access token").get("your end point URL")
//		    
//		    
//
//		
//		 oAUTH 1.0
		    
		    
		//    consumer key,
		//    secret acces token
		   // given().auth().oauth(consumer key,Consumer Secret,accesstoken, tokensecret).get("your end point URL")  ;
		    
		     
//
		 
		 
		 
		
	
	
	
	
	
}
