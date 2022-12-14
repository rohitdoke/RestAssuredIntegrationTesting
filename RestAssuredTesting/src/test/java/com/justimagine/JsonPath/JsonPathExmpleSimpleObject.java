package com.justimagine.JsonPath;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathExmpleSimpleObject {
	
	
	@Test
	public void testJsonObject()
	{
		String jsonString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\"\r\n" + 
				"}";
		
		
		//Get JsonPath instance of above JSON string
	JsonPath jsonPath=JsonPath.from(jsonString);
	
	
	// Since firstName holds a string value use getString() method and provide json path of firstName
	
	
	
String firstName=jsonPath.getString("firstName");

String lastName=jsonPath.getString("lastName");


System.out.println("First Name"+firstName);
System.out.println("Last Name"+lastName);


//Since $ is root node of a JSON, we can get whole JSON string using $ as JSON path



System.out.println("$ Root Node"+jsonPath.getString("$"));

//There are two other ways to do the same thing as above

System.out.println("2nd way getting root node"+jsonPath.getString(""));
System.out.println("3rd way getting root node"+jsonPath.get());






	
	
	
		 
	}

}
