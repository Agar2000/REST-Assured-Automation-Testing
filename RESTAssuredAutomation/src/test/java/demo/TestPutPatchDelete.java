package demo;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;

public class TestPutPatchDelete {

	@Test
	public void testPut() {


		JSONObject request = new JSONObject(); 
		request.put("name", "Pallav");
		request.put("job", "Software Developer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given().headers("Content-Type","applicatio/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.put("/users/2").then().statusCode(200).log().all();

	}
	@Test
	public void testPatch() {


		JSONObject request = new JSONObject(); 
		request.put("name", "Pallav");
		request.put("job", "Software Developer");
		System.out.println(request.toJSONString());
		baseURI = "https://reqres.in/api";
		given().headers("Content-Type","applicatio/json").contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.patch("/users/2").then().statusCode(200).log().all();

	}

	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in";
		when().delete("/api/users/2").
		then().
		statusCode(204).
		log().all();
	}

}
