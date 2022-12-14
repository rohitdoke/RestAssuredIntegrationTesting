package com.justimagine.JsonPath;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ParseJsonArrayResponseToList {
	
	@Test
	public void test()
	{
		
		List<Map<String,Object>> responseBody = null;
		
		responseBody = 
		RestAssured
			.given()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking")
			.when()
				.get()
			.then()
				.extract()
				.body()
				// Extract response as List<Map<String,Object>>
				// Since the response in a List of Map format.
				.as(new TypeRef<List<Map<String,Object>>>() {});
		
		System.out.println("Total bookings : "+ responseBody.size());
		
		System.out.println("All booking ids are: ");
		
		for(Map<String,Object> booking : responseBody)
		{
			System.out.println(booking.get("bookingid"));
		}
	}

}
