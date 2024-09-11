package test;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import io.restassured.http.ContentType;

public class TestOnLocal {
	@Test
	public void getData() {

		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200);

	}
	@Test
	public void postData() {
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		request.put("firstName","Pallav");
		request.put("lastName", "Tunnu");
		request.put("subjectId", "9716");
		given().headers("Content-Type","applicatio/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when().post("/users").then().statusCode(201);
		
		
	}

}
