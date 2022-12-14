package com.justimagine.Testing;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JaksonObjectMapper {
	
	
	@Test
	public void jaksonmapper() throws JsonProcessingException
	{
	// Create an object to ObjectMapper
	ObjectMapper objectMapper =new ObjectMapper();
			
	// Creating Node that maps to JSON Object structures in JSON content
	
			ObjectNode bookingDetails = objectMapper.createObjectNode();
			

			
	// It is similar to map put method. put method is overloaded to accept different types of data
	// String as field value
	bookingDetails.put("firstname", "Jim");
	bookingDetails.put("lastname", "Brown");
	// integer as field value
	bookingDetails.put("totalprice", 111);
	// boolean as field value
	bookingDetails.put("depositpaid", true);
	bookingDetails.put("additionalneeds", "Breakfast");
	// Duplicate field name. Will override value
	bookingDetails.put("additionalneeds", "Lunch");
	// To print created json object
	String createdPlainJsonObject = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
	System.out.println("Created plain JSON Object is : \n"+ createdPlainJsonObject);
	
	//retrieve joson object field by passing field name
	
	// We can retrieve field value by passing field name. Since it is string, use asText().
	String firstName = bookingDetails.get("firstname").asText();
	System.out.println("First name is : "+firstName);
	 
	// We can use asText() as well but return type will be string
	boolean depositpaid = bookingDetails.get("depositpaid").asBoolean();
	System.out.println("deposit paid is : "+depositpaid);
	 
	// To retrieve value of nested ObjectNode
	bookingDetails.get("bookingdates").get("checkin").asText();
	System.out.println("Checkin date is : "+depositpaid);
	
	}
}
