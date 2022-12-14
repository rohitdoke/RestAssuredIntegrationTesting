package com.justimagine.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;

public class AssertFullResponseBody {
	@Test
	@Ignore
	public void test()
	{
		
		RestAssured
		// Construct request
		.given()
			.log()
			.all()
			.baseUri("https://gorest.co.in/public-api/")
			.basePath("users/{id}")
			.pathParam("id", "178")
		// Hit API
		.when()
			.get()
		.then()
		// Assert response
			.log()
			.all()
			.assertThat()
			// Pass full expected response body with Hamcrest matchers
			.body(Matchers.equalTo("{\"code\":200,\"meta\":null,\"data\":{\"id\":178,\"name\":\"Shashi Desai Jr.\",\"email\":\"desai_jr_shashi@leuschke.co\",\"gender\":\"male\",\"status\":\"active\"}}"));
	
	}
	
	
	@Test
	public void AssertFullResponseBodyFromExternalFile() throws IOException
	{
		RestAssured
		// Construct request
		.given()
			.log()
			.all()
			.baseUri("https://gorest.co.in/public-api/")
			.basePath("users/{id}")
			.pathParam("id", "178")
		// Hit API
		.when()
			.get()
		.then()
		// Assert response
			.log()
			.all()
			.assertThat()
			// Pass full expected response body with Hamcrest matchers
			.body(Matchers.equalTo(new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"\\src\\main\\resources\\jsonFiles\\UserDetails178.json")))));
	}


		
	

}
