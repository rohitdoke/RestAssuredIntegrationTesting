package com.justimagine.model;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class RetrievingResponseHeaders {
	
	
	@Test
	public void testRetrievingResonseHeaders()
	{
		
		
		Response response = RestAssured.given()
		
		
		.get("https://restful-booker.herokuapp.com/booking/1")
		.then()
		.extract()
		.response();
		
		
		Headers headers = response.getHeaders();
		
		
		
		System.out.println("Retrieving All Headers");
		
		List<Header> list = headers.asList();
		
		
		
		list.stream().forEach(h1->System.out.println("Header Name"+h1.getName()+"Header Value"+h1.getValue()));
		
		System.out.println("Value of Header Content-Type : "+response.getHeader("Content-Type"));
		
		
		// Suppose Content-Type is a multivalue header
		List<Header> allValue = response.getHeaders().getList("Content-Type");
		for(Header header : allValue)
		{
			System.out.print(header.getName() +" : ");
			System.out.println(header.getValue());
		}
				
		List<String> allValue1 = response.getHeaders().getValues("Content-Type");
		for(String value : allValue1)
		{
			System.out.println(value);
		}
		
		
//		But there is a direct method already available named hasHeaderWithName(String headerName). 
//		It returns true if the header is present otherwise false.
		
		
		boolean hasHeaderWithName = response.getHeaders().hasHeaderWithName("Content Type");
		
		System.out.println(hasHeaderWithName);
	}
	

}
