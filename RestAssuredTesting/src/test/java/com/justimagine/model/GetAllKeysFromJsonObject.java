package com.justimagine.model;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class GetAllKeysFromJsonObject {
	
	
	@Test
	public void getAllKeysFromJsonObjectUsingObjectMapper() throws JsonMappingException, JsonProcessingException
	{
		
		
		String jsonObject="{\r\n"+" \"firstName\": \"Rohit\",\r\n"+
							"\r\n"+"\"lastName\":\"doke\"\r\n"+"}";
		
		ObjectMapper mapper=new ObjectMapper();
		
		Map<String, String> map = mapper.readValue(jsonObject, new TypeReference<Map<String,String>>(){});
		
		
		
		Set<String> set = map.keySet();
		
		
		
		set.stream().forEach(k->System.out.println(k));
		
		
		
	
	
								
	}
	
	
	

	

		@Test
		public void getAllKeysFromJsonObjectUsingObjectMapper1() throws JsonMappingException, JsonProcessingException
		{
			
			String jsonObject = "{\r\n" + 
					"  \"firstName\": \"Animesh\",\r\n" + 
					"  \"lastName\": \"Prashant\"\r\n" + 
					"}";
			
			
			String jsonObject2 = "{\r\n" + 
					"  \"firstName\": \"Animesh\",\r\n" + 
					"  \"lastName\": \"Prashant\",\r\n" + 
					"  \"address\": {\r\n" + 
					"    \"city\": \"Katihar\",\r\n" + 
					"    \"State\": \"Bihar\"\r\n" + 
					"  }\r\n" + 
					"}";
			ObjectMapper objectMapper = new ObjectMapper();
			// Converting JSON Object string to JsonNode
			JsonNode jsonNode = objectMapper.readTree(jsonObject2);
			
			
			Iterator<String> fieldNames = jsonNode.fieldNames();
			
			//System.out.println("All keys are : ");
		//	fieldNames.forEachRemaining(k -> System.out.println(k));
			
			
			
			//getting all keys from the json object
			
			fieldNames.forEachRemaining(k->{
				
					Object value = jsonNode.get(k);
					
					
					if(value instanceof TextNode)
					{
						
						System.out.println(k);
					}
					else if(value instanceof ObjectNode)
					{
						
							Iterator<String> keys=((ObjectNode)value).fieldNames();
			
							keys.forEachRemaining(ke-> System.out.println(ke));
					}
			});
		}
	
}
