package com.justimagine.JsonPath;

import org.junit.Test;

import com.justimagine.model.Emp;

import io.restassured.path.json.JsonPath;


public class DeserializationUsingJsonPath {

//	Converting a Java object to a JSON object is called serialization and the reverse of it is called deserialization. 
//	JsonPath class provides a method named “T getObject(String path, Class objectType)”
//	which helps to get the result of an Object path expression as a java Object.
//	
	@Test
	public void testDeserializationUsingJsonPath()
	{
		
		String jsonObject = "{\r\n" + 
				"  \"id\": 1,\r\n" + 
				"  \"first_name\": \"Lothaire\",\r\n" + 
				"  \"last_name\": \"Benazet\",\r\n" + 
				"  \"email\": \"lbenazet0@tinyurl.com\",\r\n" + 
				"  \"gender\": \"Male\"\r\n" + 
				"}";
		
		
		JsonPath jsonPath = JsonPath.from(jsonObject);
		
		Emp e1 = jsonPath.getObject("", Emp.class);
		
		System.out.println("Id is         : "+e1.getId());
		System.out.println("First name is : "+e1.getFirst_name());
		System.out.println("Last name is  : "+e1.getLast_name());
		System.out.println("Email id is   : "+e1.getEmail());
		System.out.println("Gender is     : "+e1.getGender());
		
	
		// Another way
				Emp employee1 = jsonPath.getObject("$", Emp.class);
				System.out.println("Id is         : "+employee1.getId());
				System.out.println("First name is : "+employee1.getFirst_name());
				System.out.println("Last name is  : "+employee1.getLast_name());
				System.out.println("Email id is   : "+employee1.getEmail());
				System.out.println("Gender is     : "+employee1.getGender());
		 
	}
	
	
	@Test
	public void DeserializationJsonArray()
	{
		
		
		String jsonObject = "[{\r\n" + 
				"  \"id\": 1,\r\n" + 
				"  \"first_name\": \"Lothaire\",\r\n" + 
				"  \"last_name\": \"Benazet\",\r\n" + 
				"  \"email\": \"lbenazet0@tinyurl.com\",\r\n" + 
				"  \"gender\": \"Male\"\r\n" + 
				"}, {\r\n" + 
				"  \"id\": 2,\r\n" + 
				"  \"first_name\": \"Shellie\",\r\n" + 
				"  \"last_name\": \"Cowser\",\r\n" + 
				"  \"email\": \"scowser1@163.com\",\r\n" + 
				"  \"gender\": \"Female\"\r\n" + 
				"}]";
		
		
		
		JsonPath jsonPath = JsonPath.from(jsonObject);
		
		
		Emp employee = jsonPath.getObject("[1]", Emp.class);
		
		
		System.out.println("Id is         : "+employee.getId());
		System.out.println("First name is : "+employee.getFirst_name());
		System.out.println("Last name is  : "+employee.getLast_name());
		System.out.println("Email id is   : "+employee.getEmail());
		System.out.println("Gender is     : "+employee.getGender());
	}
	
}
