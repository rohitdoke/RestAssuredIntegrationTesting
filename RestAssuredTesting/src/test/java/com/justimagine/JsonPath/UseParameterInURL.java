package com.justimagine.JsonPath;

import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;

public class UseParameterInURL {
	/*
	pathParam() method takes two string parameters. 
	The first parameter is the parameter name and another parameter is the parameter value. An example is shown below:
	*/
	@Test
	@Ignore
	public void UsePathParamInUrl()
	{
		
		
		RestAssured.given()
		.log()
		.all()
		.baseUri("https://restful-booker.herokuapp.com/")
		.basePath("{resourcePath}")
		.pathParam("resourcePath", "booking")
		.when()
		.get()
		.then()
		.log()
		.all();
	}

	/*
	We can also pass the complete parameterized URL in HTTP method call (get(), post() etc) 
	instead of using baseURI and basePath.
	*/
	@Ignore
	@Test
	public void pathVariable2()
	{
		RestAssured
			.given()
				.log()
				.all()
			    .pathParam("resourcePath", "booking")
			.when()
				.get("https://restful-booker.herokuapp.com/{resourcePath}")
			.then()
				.log()
				.all();
	}
	
	
	//Using inline path parameter
	@Test
	public void pathVariable3()
	{
		RestAssured
			.given()
				.log()
				.all()
			.when()
				.get("https://restful-booker.herokuapp.com/{resourcePath}", "booking")
			.then()
				.log()
				.all();
	}
	
}
