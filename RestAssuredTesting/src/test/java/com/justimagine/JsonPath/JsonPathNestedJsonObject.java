package com.justimagine.JsonPath;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathNestedJsonObject {
	
	
	
	@Test
	public void testNestedJsonObject()
	{
		
		String jsonString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": {\r\n" + 
				"    \"houseNo\": 404,\r\n" + 
				"    \"buildingName\": \"Not Found\",\r\n" + 
				"    \"streetName\": \"Gumnam gali\",\r\n" + 
				"    \"city\": \"Bengaluru\",\r\n" + 
				"    \"state\": \"Karnataka\",\r\n" + 
				"    \"country\": \"India\"\r\n" + 
				"  },\r\n" + 
				"  \"skills\": {\r\n" + 
				"    \"language\": {\r\n" + 
				"      \"name\": \"Java\",\r\n" + 
				"      \"proficiency\": \"Medium\"\r\n" + 
				"    }\r\n" + 
				"  }\r\n" + 
				"}";
		
		
		
		
		JsonPath jsonPath=JsonPath.from(jsonString);
		
		//Fetching simple element
		
		String firstName=jsonPath.getString("firstName");
		
		System.out.println("FirstName"+firstName);
		
		// Since houseNo holds an int value use getInt() method and provide json path of houseNo
		Integer houseNo=jsonPath.getInt("address.houseNo");
		
		
		System.out.println("House No:"+houseNo);
		
		// getting $skills.language.name
		
		
	String languageName=jsonPath.getString("skills.language.name");
		
	
	System.out.println("Language Name:"+languageName);
	
	
	
		
		
	}

}
