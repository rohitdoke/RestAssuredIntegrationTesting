package com.justimagine.model;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class WithoutUsingResponseSpecification {
	
	
	@Test
	public void testGetAllBook()
	{
		
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com")
		.when()
		.get("/booking")
		.then()
		.contentType(ContentType.JSON)
		.time(Matchers.lessThan(5000l))
		.statusLine("HTTP/1.1 200 OK")
		.body("size()", Matchers.greaterThan(5));
	}
	
	@Test
	public void getBookingDetailsWithInvalidFirstName()
	{
		// Given
		RestAssured
		  .given()
			 .baseUri("https://restful-booker.herokuapp.com")
		// When
		   .when()
			  .get("/booking?firstname=Rahul")
		// Then
		   .then()
		// Repetitive validation as first test above
		   .contentType(ContentType.JSON)
		   .time(Matchers.lessThan(5000L))
		   .statusLine("HTTP/1.1 200 OK")
		// To verify booking count
		   .body("size()", Matchers.equalTo(0));
			
	}
	
	

}
