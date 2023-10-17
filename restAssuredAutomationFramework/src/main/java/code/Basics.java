package code;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// given -- all inputs
		// when -- submission
		// then -- validation

		HashMap<String,String> myHeaders = new HashMap<String,String>();
		HashMap<String,String> queryParams = new HashMap<String,String>();
		myHeaders.put("String1","head1");
		myHeaders.put("String2","head2");
		myHeaders.put("String3","head3");
		queryParams.put("param1","val1");
		queryParams.put("param2","val2");
		queryParams.put("param3","val3");
		
		
		RestAssured.baseURI = "https://setBaseURI.neet";
		given().log().all()
		.queryParam("key", "qaclick123")
		.queryParams(queryParams)
		.header("content-type","app/json")
		.headers(myHeaders)
		.body("blah blah blah")
		.when().post("/path/to/resource")
		.then().log().all().assertThat().statusCode(200);

	}

}
