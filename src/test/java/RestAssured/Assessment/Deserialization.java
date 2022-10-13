package RestAssured.Assessment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Deserialization {
	static HashMap<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();

	@Before
	public void GetUsers_JsonPath() throws IOException {
		// <--------------Setup API---------------------->
		RestAssured.baseURI = "https://reqres.in/api/users?page=1";
		RequestSpecification httpreq = RestAssured.given();
		Response response = httpreq.request(Method.GET, "");
		// <------------------------------------------------>
		response = httpreq.get("");

		// <------------- Jayway JsonPath ------------------>

		Object subject = JsonPath.read(response.asString(), "$.data.length()");
		int length = subject.hashCode();

		for (int i = 0; i < length; i++) {
			Object res = JsonPath.read(response.asString(), "$.data[" + i + "]");
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(res);

			TypeReference<HashMap<String, Object>> typeref = new TypeReference<HashMap<String, Object>>() {

			};

			HashMap<String, Object> entry = mapper.readValue(json, typeref);

			for (Entry<String, Object> user : entry.entrySet()) {

				ArrayList tempList = null;
				if (hashMap.containsKey(user.getKey())) {
					tempList = hashMap.get(user.getKey());
					if (tempList == null)
						tempList = new ArrayList();
					tempList.add(user.getValue());
				} else {
					tempList = new ArrayList();
					tempList.add(user.getValue());
				}
				hashMap.put(user.getKey(), tempList);

//				System.out.println(user.getKey() + " : "+ user.getValue());
			}

		}

	}

	@Test
	public void validate1() {

		// <------------- Validations id -------------->

		Assert.assertTrue("Test has Passed", (hashMap.get("id").contains(1)));
		System.out.println("Test Passed : id");

	}

	@Test
	public void validate2() {

		// <------------- Validations Last Name -------------->

		Assert.assertTrue("Test has Passed", (hashMap.get("last_name").contains("Wong")));
		System.out.println("Test Passed : last_name");

	}

	@Test
	public void validate3() {

		// <---------- Validating first_name --------------->

		Assert.assertTrue("Test has Passed", hashMap.get("first_name").contains("Emma"));
		System.out.println("Test Passed : first_name");

	}

	@Test
	public void validate4() {

		// <---------- Validating email --------------->

		Assert.assertTrue("Test has Passed", (hashMap.get("email").contains("emma.wong@reqrest.in")));
		System.out.println("Test Passed : email");

	}

	@Test
	public void validate5() {

		// <---------- Validating avatar --------------->

		Assert.assertTrue("Test has Passed",
				(hashMap.get("avatar").contains("https://reqres.in/img/faces/1-image.jpg")));
		System.out.println("Test Passed : avatar");

	}

}
