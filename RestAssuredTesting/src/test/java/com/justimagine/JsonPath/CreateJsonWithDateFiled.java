package com.justimagine.JsonPath;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justimagine.model.Booking1;

import io.restassured.path.json.JsonPath;

public class CreateJsonWithDateFiled {
	
	@Test
	public void testCreateJosonWithDatefield() throws JsonProcessingException
	{
		
		Booking1 b=new Booking1();
		
		b.setFirstName("Rohit");
		b.setLastName("Doke");
		
		
		//default fromat yy-mm-dd
		LocalDate currentDate = LocalDate.now();
		b.setCheckin(currentDate.plusDays(10).toString());
		
		b.setCheckout(currentDate.plusDays(20).toString());
		
		
		
		//pojo to json Serialization
		
		ObjectMapper mapper=new ObjectMapper();
		
		String jsonbooking = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(b);
		
		System.out.println(jsonbooking);
		
		
		//Deserialization json to pojo
		
		
		
		JsonPath jsonPath = JsonPath.from(jsonbooking);
		
		
		Booking1 booking1 = jsonPath.getObject("", Booking1.class);
		
		
		System.out.println(booking1);
		
	}
	@Test
	public void testWithdateformatter() throws JsonProcessingException
	{
		Booking1 booking1 = new Booking1();
		booking1.setFirstName("Amod");
		booking1.setLastName("Mahajan");
		
		// default format is yyyy-MM-dd
		LocalDate currentDate = LocalDate.now();
		
		// Get 10 days from current date
		booking1.setCheckin(currentDate.plusDays(10).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
		// Get 20 days from current date
		booking1.setCheckout(currentDate.plusDays(20).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy")));
		
		// POJO to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking1);
		System.out.println(s);
		
		// JSON to POJO
		Booking1 b2 = objectMapper.readValue(s, Booking1.class);
		System.out.println("Passed checkin date is "+ b2.getCheckin());
		System.out.println("Passed checkout date is "+ b2.getCheckout());
		
		
	}
	@Test
	public void testTimestamp() throws JsonProcessingException
	{
		
		Booking1 booking1 = new Booking1();
		booking1.setFirstName("Amod");
		booking1.setLastName("Mahajan");
		
		// default format is yyyy-MM-dd
		LocalDateTime currentDate = LocalDateTime.now();
		
		// Get 10 days from current date
		booking1.setCheckin(currentDate.plusDays(10).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));
		// Get 20 days from current date
		booking1.setCheckout(currentDate.plusDays(20).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));
		
		// POJO to JSON
		ObjectMapper objectMapper = new ObjectMapper();
		String s = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking1);
		System.out.println(s);
		
		// JSON to POJO
		Booking1 b2 = objectMapper.readValue(s, Booking1.class);
		System.out.println("Passed checkin date is "+ b2.getCheckin());
		System.out.println("Passed checkout date is "+ b2.getCheckout());
		
		
	}
}
