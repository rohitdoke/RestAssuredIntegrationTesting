package com.justimagine.JsonPath;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathJsonArray {
	@Test
	public void testJsonArray()
	{
		String jsonArrayString = "{\r\n" + 
				"  \"firstName\": \"Amod\",\r\n" + 
				"  \"lastName\": \"Mahajan\",\r\n" + 
				"  \"address\": [\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"permanent\",\r\n" + 
				"      \"city\": \"Bengaluru\",\r\n" + 
				"      \"state\": \"KA\"\r\n" + 
				"    },\r\n" + 
				"    {\r\n" + 
				"      \"type\": \"temp\",\r\n" + 
				"      \"city\": \"Bhopal\",\r\n" + 
				"      \"state\": \"MP\"\r\n" + 
				"    }\r\n" + 
				"  ]\r\n" + 
				"}";
		
		
		JsonPath jsonPath = JsonPath.from(jsonArrayString);
		
		//fetch first address type
		String firstAddrType = jsonPath.getString("address[0].type");
		
		System.out.println("first Address Type"+firstAddrType);
		//fetching secong address type
		
		String secondAddrType = jsonPath.getString("address[1].type");
		System.out.println("second address type"+secondAddrType);
		
		
		// We can get address types as a list as well
		
		
		List<String> addressTypelist = jsonPath.getList("address.type");
		
		System.out.println("List of Address Type"+addressTypelist);
		
		System.out.println("List of All Address");
		List<Map<String,Object>>addressList=jsonPath.getList("address");
		
		
	addressList.stream().forEach(a->System.out.println(a));
		
	}
	
	
	

}
