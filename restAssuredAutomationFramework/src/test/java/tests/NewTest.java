package tests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class NewTest {
	
	@BeforeSuite
	public void setup() {
		RestAssured.baseURI = "https://dummy.restapiexample.com";
	}
	
	@Test
	public void f() {
		HashMap<String, String> myHeaders = new HashMap<String, String>();
		HashMap<String, String> queryParams = new HashMap<String, String>();
		myHeaders.put("String1", "head1");
		myHeaders.put("String2", "head2");
		myHeaders.put("String3", "head3");
		queryParams.put("param1", "val1");
		queryParams.put("param2", "val2");
		queryParams.put("param3", "val3");

		given().queryParam("key", "qaclick123").queryParams(queryParams).header("content-type", "application/json")
				.headers(myHeaders)
				//.body("")
				.log().all()
				.when()
				.get("/api/v1/employees")
				.then().log().all()
				.assertThat().statusCode(200);
	}
}
