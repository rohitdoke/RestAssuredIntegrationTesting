package com.justimagine.model;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class ParseJsonArrayToReadValues {

	
	//Fetch Value From JSON Array Using JsonNode – Jackson – Get() & Path() Methods
	@Ignore
	@Test
	public void parseJsonArrayToReadValues() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"age\": 28,\r\n" + 
				"    \"isMarried\": false,\r\n" + 
				"    \"salary\": 23456.54\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Rahul\",\r\n" + 
				"    \"lastName\": \"Arora\",\r\n" + 
				"    \"age\": 32,\r\n" + 
				"    \"isMarried\": true,\r\n" + 
				"    \"salary\": 33456.54\r\n" + 
				"  }\r\n" + 
				"]";
		
		
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		JsonNode readTree = objectMapper.readTree(jsonArray);
		

		// To know if tree is a JSON object or JSON array
			Boolean b=(readTree instanceof ObjectNode);
		
			Boolean b2=(readTree instanceof ArrayNode);
			
			//getting First Json ArrayNode
			JsonNode firstJsonObject = readTree.get(0);
			
			
			
			// Get value of firstName as string
			String firstName = firstJsonObject.get("firstName").asText();
			String lastName = firstJsonObject.get("lastName").asText();
			// Get value of married as boolean
			int age = firstJsonObject.get("age").asInt();
			boolean married = firstJsonObject.get("isMarried").asBoolean();
			double salary = firstJsonObject.get("salary").asLong();
			
			System.out.println("FirstName is : "+firstName);
			System.out.println("LastName is  : "+lastName);
			System.out.println("Age is   : "+age);
			System.out.println("Maritial status is    : "+married);
			System.out.println("Salary is: "+salary);
			
			
			//Getting Second Json ArrayNode
			
			
			JsonNode secondJsonObject = readTree.get(1);
			
			
			

			// Get value of firstName as string
			firstName = secondJsonObject.get("firstName").asText();
			lastName = secondJsonObject.get("lastName").asText();
			// Get value of married as boolean
			age = secondJsonObject.get("age").asInt();
			married = secondJsonObject.get("isMarried").asBoolean();
			salary = secondJsonObject.get("salary").asLong();
			
			System.out.println("FirstName is : "+firstName);
			System.out.println("LastName is  : "+lastName);
			System.out.println("Age is   : "+age);
			System.out.println("Maritial status is    : "+married);
			System.out.println("Salary is: "+salary);
			
	
		
	}
	
	@Test
	public void parseJsonArrayToReadValuesUsingAtMethod() throws JsonMappingException, JsonProcessingException
	{
		String jsonArray = "[\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Amod\",\r\n" + 
				"    \"lastName\": \"Mahajan\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Permanent\",\r\n" + 
				"        \"city\": \"Bengaluru\",\r\n" + 
				"        \"state\": \"Karnataka\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Communication\",\r\n" + 
				"        \"city\": \"Katihar\",\r\n" + 
				"        \"state\": \"Bihar\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  },\r\n" + 
				"  {\r\n" + 
				"    \"firstName\": \"Animesh\",\r\n" + 
				"    \"lastName\": \"Prashant\",\r\n" + 
				"    \"address\": [\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Permanent\",\r\n" + 
				"        \"city\": \"Delhi\",\r\n" + 
				"        \"state\": \"Delhi\"\r\n" + 
				"      },\r\n" + 
				"      {\r\n" + 
				"        \"type\": \"Communication\",\r\n" + 
				"        \"city\": \"Indore\",\r\n" + 
				"        \"state\": \"MP\"\r\n" + 
				"      }\r\n" + 
				"    ]\r\n" + 
				"  }\r\n" + 
				"]";
		
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		
		JsonNode readTree = objectMapper.readTree(jsonArray);
		
		
		//Retreving the value using the get Method
		String firstName = readTree.get(0).get("firstName").asText();
		
		
		
		String addressType = readTree.get(0).get("address").get(0).get("type").asText();
		
		
		System.out.println("Fetch values using get method"+firstName+addressType);
		//Fetch values using at Method
		
		// Using at() method
				// Printing details of first indexed node
		System.out.println("First Index of Array");
		
		String first = readTree.at("/0/firstName").asText();
		String addr = readTree.at("/0/address/0/type").asText();
		
		System.out.println("Fetch values using at method"+first+addr);
		
		System.out.println(readTree.at("/0/address/1/type").asText());
	
		
		
		//Second indexed Node
		System.out.println("Second Index of Array");
		
		
		System.out.println(readTree.at("/1/firstName").asText());
		System.out.println(readTree.at("/1/address/0/type").asText());
		System.out.println(readTree.at("/1/address/1/type").asText());
		System.out.println(".....................................................................");
		System.out.println(readTree.at("/0/address/0/0").asText());
		System.out.println(readTree.at("/0/address/1/0").asText());
		
	}
	
	
}
