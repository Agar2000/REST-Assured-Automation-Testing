package demo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.path.json.mapping.JsonObjectDeserializer;
import io.restassured.response.Response;
import io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TestGetAndPost {

	@Test
	public void testGet() {

		baseURI = "https://reqres.in/api";

		given().get("users?page=2").then().statusCode(200).body("data[4].first_name", equalTo("George")).
		body("data.first_name",hasItems("George","Michael","Rachel")); // fetch the first name details from the response json

	}
	@Test
	public void testPost() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		/*map.put("name", "shruti");
		map.put("job", "qa"); // add the values in the map
		System.out.println("map = "+ map);*/
		
			
			JSONObject request = new JSONObject(map); // use to convert map values into json 
			request.put("name", "Pallav");
			request.put("job", "Developer");
			System.out.println(request.toJSONString()); // json get print and also validate
			
			// Create json and validate with status code of json creation
			baseURI = "https://reqres.in/api";
			given().headers("Content-Type","applicatio/json").contentType(ContentType.JSON).accept(ContentType.JSON)
			.body(request.toJSONString()).when()
			.post("/users").then().statusCode(201).log().all();
	}
}
