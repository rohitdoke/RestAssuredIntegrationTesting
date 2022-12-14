package com.justimagine.JsonPath;

import org.junit.Test;
import org.springframework.boot.context.properties.bind.BindContext;
import org.testng.ITestContext;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ShareDataUsingITestContext {

	
	
	@org.testng.annotations.Test
	public void createBooking(ITestContext context)
	{
		int bookingId = RestAssured
		.given()
			.log()
			.all()
			.baseUri("https://restful-booker.herokuapp.com/")
			.basePath("booking")
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
		.when()
			.post()
		.then()
		.log()
		.all()
		.extract()
		.jsonPath()
		.getInt("bookingid");
		
		context.setAttribute("bookingid", bookingId);
	}
	
	@org.testng.annotations.Test
	public void updateBooking(ITestContext context)
	{
	
		
			int id = (int)context.getAttribute("bookingId");
			RestAssured
			.given()
				.log()
				.all()
				.baseUri("https://restful-booker.herokuapp.com/")
				.basePath("booking/"+id)
				.header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
				.contentType(ContentType.JSON)
				.body("{\r\n" + 
					"    \"firstname\" : \"Amod\",\r\n" + 
					"    \"lastname\" : \"Mahajan\",\r\n" + 
					"    \"totalprice\" : 222,\r\n" + 
					"    \"depositpaid\" : true,\r\n" + 
					"    \"bookingdates\" : {\r\n" + 
					"        \"checkin\" : \"2022-01-01\",\r\n" + 
					"        \"checkout\" : \"2022-01-01\"\r\n" + 
					"    },\r\n" + 
					"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
					"}")
			.when()
				.put()
			.then()
				.log()
				.all();
			
			
			
	}
}
