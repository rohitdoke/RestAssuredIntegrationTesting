package com.justimagine.model;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParseJsonObjectToReadValues {

	
	
	
	private static JsonNode jsonNode;
	
/*
 *  Fetch Value From JSON Object Using JsonNode – Jackson – Get() & Path() Methods
	*/
@Test
	public void parseJsonObjectToReadValues() throws JsonMappingException, JsonProcessingException
	{
		
		
		String jsonObject = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"married\": false,\r\n" + 
				"  \"salary\": 2000.54,\r\n" + 
				"  \"addressPin\": 45324\r\n" + 
				"}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		   jsonNode = mapper.readTree(jsonObject);
		   
		   
		   
		   String text = jsonNode.get("firstName").asText();
		   String text2 = jsonNode.get("lastName").asText();
		   
		   
		   				boolean asBoolean = jsonNode.get("married").asBoolean();
		   				
		   				String asText = jsonNode.get("married").asText();
		   				long asLong = jsonNode.get("addressPin").asLong();
		   				
		   				System.out.println("FirstName is : "+text);
		   				System.out.println("LastName is  : "+text2);
		   				System.out.println("Married is   : "+asBoolean);
		   				System.out.println("Salary is    : "+asText);
		   				System.out.println("Addresspin is: "+asLong);
		   				
		   				


		   				// Retrieving value of non-existing key
//		   				String notExitsing = jsonNode.get("notExistingField").asText("Default node");
//		   				System.out.println("Not Existing Field"+notExitsing);
		   				
		   				
		   				
		   				
		   				/*
		   				As per the official doc – path() method is similar to get(String),
		   				except that instead of returning null if no such value exists 
		   				(due to this node not being an object, or object not having value for the specified field),
		   				a “missing node” will be returned.
		   				This allows for convenient and safe chained access via path calls.
		   				
		   				*/
		   				
		   				String asText2 = jsonNode.path("notExitsing").asText("not provided");
		   				System.out.println("Default Node: "+asText2);
		   				
	}
}
