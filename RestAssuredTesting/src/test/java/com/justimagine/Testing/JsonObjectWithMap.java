package com.justimagine.Testing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class JsonObjectWithMap {

	@Test
	public void passBodyAsMap()
	{
		Map<String,String> authPayload = new HashMap<String,String>();
		authPayload.put("username", "admin");
		authPayload.put("password", "password123");
		
		
		//GIVEN
		RestAssured
		   .given()
			  .baseUri("https://restful-booker.herokuapp.com/auth")
			  .contentType(ContentType.JSON)
			  .body(authPayload)
			  .log()
			  .all()
		// WHEN
		   .when()
			   .post()
		// THEN
		   .then()
			   .assertThat()
			   .statusCode(200)
			   .log()
			   .all();
		
	}
	
	
	@Test
	public void creatingNesteedJsonObject()
	{

		Map<String,Object> jsonBodyUsingMap=new HashMap<String,Object>();
		
		
		jsonBodyUsingMap.put("firstname", "jim");
		
		jsonBodyUsingMap.put("lastname", "Brown");
		
		jsonBodyUsingMap.put("totalprice", 111);
		
		jsonBodyUsingMap.put("depositpaid", true);
		
		Map<String,String> bookingDatesMap = new HashMap<>();
		bookingDatesMap.put("checkin", "2022-11-01");
		bookingDatesMap.put("checkout", "2022-11-05");
		
		jsonBodyUsingMap.put("bookingdatesmap", bookingDatesMap);
		jsonBodyUsingMap.put("additonalneeds", "breakfast");
		
		

		
		
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking")
		.contentType(ContentType.JSON)
		.body(jsonBodyUsingMap)
		.log()
		.all()
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(500)
		.log()
		.all();
		
		
	}

	
	@Test
	public void creatinglistJsonObject()
	{

		Map<String,Object> jsonBodyUsingMap=new HashMap<String,Object>();
		
		
		jsonBodyUsingMap.put("firstname", "jim");
		
		jsonBodyUsingMap.put("lastname", "Brown");
		
		jsonBodyUsingMap.put("totalprice", 111);
		
		jsonBodyUsingMap.put("depositpaid", true);
		
		Map<String,String> bookingDatesMap = new HashMap<>();
		bookingDatesMap.put("checkin", "2022-11-01");
		bookingDatesMap.put("checkout", "2022-11-05");
		
		jsonBodyUsingMap.put("bookingdatesmap", bookingDatesMap);
		jsonBodyUsingMap.put("additonalneeds", "breakfast");
		
		
		
Map<String,Object> jsonBodyUsingMap1=new HashMap<String,Object>();
		
		
		jsonBodyUsingMap1.put("firstname", "ram");
		
		jsonBodyUsingMap1.put("lastname", "don");
		
		jsonBodyUsingMap1.put("totalprice", 111);
		
		jsonBodyUsingMap1.put("depositpaid", true);
		
		Map<String,String> bookingDatesMap1 = new HashMap<>();
		bookingDatesMap1.put("checkin", "2022-11-10");
		bookingDatesMap1.put("checkout", "2022-11-10");
		
		jsonBodyUsingMap1.put("bookingdatesmap", bookingDatesMap);
		jsonBodyUsingMap1.put("additonalneeds", "breakfast");
		
		
		
		List<Map<String,Object>> listofjsonobject=new ArrayList<Map<String,Object>>();
		
		
		listofjsonobject.add(jsonBodyUsingMap);
		listofjsonobject.add(jsonBodyUsingMap);
		
		RestAssured.given()
		.baseUri("https://restful-booker.herokuapp.com/booking")
		.contentType(ContentType.JSON)
		.body(listofjsonobject)
		.log()
		.all()
		.when()
		.post()
		.then()
		.assertThat()
		.statusCode(500)
		.log()
		.all();
		
		
	}

}


