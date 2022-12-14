package com.justimagine.model;

import static org.hamcrest.CoreMatchers.both;
import static org.mockito.ArgumentMatchers.booleanThat;

import java.io.File;

import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class VerifyJsonSchema {
	
	
	
	
	@Test
	public void verifyJsonSchema() {
		
		String jsonStringPayload = "{\"username\" : \"admin\",\"password\" : \"password123\"}";
 
		// GIVEN
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonStringPayload)
		// WHEN
			.when()
				.post()
		// THEN
			.then()
				.assertThat()
				.statusCode(200)
				.body("token", Matchers.notNullValue())
				//.both(JsonSchemaValidator.matchesJsonSchemaInClasspath(File outputjsonfile=new File("\\src\\main\\resources\\Payload\\Bookjsonpayload.json"));
		.body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Rohit\\OneDrive\\Desktop\\Resume\\jsonSchema.json")));
	

}
}