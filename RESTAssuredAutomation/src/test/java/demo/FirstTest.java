package demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class FirstTest {

	@Test
	public void test_1() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println("Response code : " + response.getStatusCode());
		System.out.println("Response time : " +response.getTime());
		System.out.println("Response body : " +response.getBody().asString());
		System.out.println("Response status line : " +response.getStatusLine());
		System.out.println("Response headers : " +response.getHeader("content-type"));

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);

	}
	@Test
	public void test_2() {
		baseURI = "https://reqres.in/api";
		given().get("/users/23").then().statusCode(404);		
	}

	@Test
	public void test_3() {
		given().get("https://reqres.in/api/users").then().statusCode(200);

	}
	

	@Test
	public void test_4() {

		baseURI = "https://reqres.in/api";
		given().get("users?page=2").then().statusCode(200).body("data[1].id",  equalTo(8)).log().body();	
	}
}
