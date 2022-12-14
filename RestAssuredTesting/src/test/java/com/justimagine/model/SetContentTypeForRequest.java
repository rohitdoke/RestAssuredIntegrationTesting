package com.justimagine.model;





import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class SetContentTypeForRequest {
	
	@org.junit.Test
	public void settingContentTypeAsContentType()
	{
		RestAssured
		.given()
		.log()
		.all()
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
		.log()
		.all();
	}

}