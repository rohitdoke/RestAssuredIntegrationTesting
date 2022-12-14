package com.justimagine.Testing;

import java.util.Iterator;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JSONArray {

	@Test
	public void jsonarray() throws JsonProcessingException {

	ObjectMapper mapper =new ObjectMapper();
	
	ArrayNode BookArrayNode = mapper.createArrayNode();
	
	
	//First Book object
	ObjectNode book1 = mapper.createObjectNode();
	
	
	book1.put("id", 111);
	
	book1.put("bookname", "c");
	
	book1.put("price", 5000);
	
	ObjectNode authorDeatil = mapper.createObjectNode();
	
	
	authorDeatil.put("name", "ganesh");
	
	authorDeatil.put("email", "Ganesh@yahoo.com");
	
	authorDeatil.put("Addrress", "pune");
	
	book1.set("AuthorDeatil", authorDeatil);
	
	//Second Book Object
	
ObjectNode book2 = mapper.createObjectNode();
	
	
	book2.put("id", 112);
	
	book2.put("bookname", "R");
	
	book2.put("price", 500);
	
	ObjectNode authorDeatil2 = mapper.createObjectNode();
	
	
	authorDeatil2.put("name", "Rohit");
	
	authorDeatil2.put("email", "Rohit@yahoo.com");
	
	authorDeatil2.put("Addrress", "mumbai");
	
	book2.set("AuthorDeatil", authorDeatil2);
	
		BookArrayNode.add(book1);
		
		BookArrayNode.add(book2);
		
		
		
		String writeValueAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(BookArrayNode);
		
		System.out.println("Crated json Array List"+writeValueAsString);
		//List<Object> list = Arrays.asList(BookArrayNode).forEach(b1->System.out.println(b1));
	
	//Retrieving JSON object form jSONArray

		System.out.println("First Element in JSON Array");
		JsonNode firstElements = BookArrayNode.get(0);
		
		
		System.out.println(firstElements);
		
		//Calculating Size of the JSON Array
		int size = BookArrayNode.size();
		System.out.println(size);
		System.out.println("All Elements in the JSON Array");
		BookArrayNode.iterator().forEachRemaining(b1->System.out.println(b1));
		
		//Remove the first Element in the Array
		
		BookArrayNode.remove(0);
		System.out.println("first Element removed");
		
		//Removing Element in the JSON Array
		
		 BookArrayNode.removeAll();
		 System.out.println("All  Elements Arrray are Removed");
		 
		 
		
		
	
		
		

	
	
	}
}
