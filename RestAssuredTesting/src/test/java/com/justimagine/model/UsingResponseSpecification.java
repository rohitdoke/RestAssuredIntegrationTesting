package com.justimagine.model;

import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class UsingResponseSpecification {
	
static ResponseSpecification responseSpecification;
	
	@BeforeClass
	public static  void setupResponseSpecification()
	{
	
		
		
		responseSpecification = RestAssured.expect();
		
		responseSpecification.contentType(ContentType.JSON);
		
		responseSpecification.statusCode(200);
		responseSpecification.statusLine("HTTP/1.1 200 OK");
		responseSpecification.time(Matchers.lessThan(5000L));
		
		
	}
	
	
	@Test
	public void getAllBookings()
	{
		// Given
		RestAssured
		  .given()
			 .baseUri("https://restful-booker.herokuapp.com")
		// When
		   .when()
			  .get("/booking")
		// Then
		   .then()
		   // Just pass ResponseSpecification as below
		   .spec(responseSpecification)
		// To verify booking count
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
			  .get("/booking?firstname=jim")
		// Then
		   .then()
		   .spec(responseSpecification)
		// To verify booking count
		   .body("size()", Matchers.equalTo(0));
			
	}
}
