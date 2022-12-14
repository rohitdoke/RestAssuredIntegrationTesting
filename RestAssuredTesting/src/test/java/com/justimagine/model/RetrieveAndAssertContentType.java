package com.justimagine.model;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RetrieveAndAssertContentType {
	
	//How To Retrieve And Assert Content-Type Of Response In Rest Assured
	
	@Test
	public void retrieveAndAssertContentType()
	{
		Response response = RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}")
		.post("https://restful-booker.herokuapp.com/booking");
		
		// Direct method to fetch Content-Type
		String contentType = response.getContentType();
		System.out.println("Content-Type of response is : "+contentType);
		
		// Since Content-Type is an header
		String contentType1 = response.getHeader("Content-Type");
		System.out.println("Content-Type of response is : "+contentType1);
	}
	
	
//	In the above section, we can assert extracted Content-Type using TestNG methods or String methods. 
//	But there is a direct way to assert it directly instead of extract and then assert. 
//	We can use method content-Type() of ValidatableResponseOptions interface. 
//	We need to use then() on Response to use ValidatableResponseOptions methods.
	@Test
	public void retrieveAndAssertContentType2()
	{
		RestAssured
		.given()
		.contentType(ContentType.JSON)
		.body("{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}")
		.post("https://restful-booker.herokuapp.com/booking")
		.then()
		.contentType(ContentType.JSON);
	}
 

}
