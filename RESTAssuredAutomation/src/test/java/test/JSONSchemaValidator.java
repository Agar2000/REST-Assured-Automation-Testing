package test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


import org.testng.annotations.Test;

public class JSONSchemaValidator {

	
	@Test
	public void testGet() {

		baseURI = "http://localhost:3000";
		
		given().get("/users").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).statusCode(200);
		

		/*given().get("users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")).
		body("data.first_name",hasItems("George","Michael","Rachel"));*/ // fetch the first name details from the response json

	}
}
