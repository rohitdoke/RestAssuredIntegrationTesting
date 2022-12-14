package com.justimagine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SeniorEmployeeTest {
	
	
	@Test
	@Ignore
	public void noValuessetForAnyField() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of noValuessetForAnyField...");
		System.out.println(employeeJson);
	}
	
	@Test
	@Ignore
	public void noValueSetForArrayListMap() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		seniorEmployee.setFirstName("Amod");
		seniorEmployee.setLastName("Mahajan");
		seniorEmployee.setAge(29);
		seniorEmployee.setGender("Male");
		seniorEmployee.setSalary(12323.56);
		seniorEmployee.setMarried(false);
		
		// Empty array
		String[] mobileNo = {};
		seniorEmployee.setMobileNo(mobileNo);
		
		// Empty list
		List<String> cars = new ArrayList<String>();
		seniorEmployee.setCars(cars);
		
		// Empty Map
		Map<String,String> familyMembers = new HashMap<>();
		seniorEmployee.setFamilyMembers(familyMembers);
		
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of noValueSetForArrayListMap...");
		System.out.println(employeeJson);
	}
	
	
	//A NULL value is also considered as EMPTY.
	//For Collections and Map, isEmpty() method is called to check emptiness i.e. without any content.
	//For an array and string, the length is checked for emptiness.
	@Test
	public void valueSetForFields() throws JsonProcessingException {
		// Just create an object of Pojo class
		SeniorEmployee seniorEmployee = new SeniorEmployee();
		seniorEmployee.setFirstName("Amod");
		seniorEmployee.setLastName("Mahajan");
		
		seniorEmployee.setAge(29);
		seniorEmployee.setGender("Male");
		seniorEmployee.setSalary(12323.56);
		seniorEmployee.setMarried(false);
		
		String[] mobileNo = new String[2];
		mobileNo[0] = "12345";
		mobileNo[1] = "67890";
		seniorEmployee.setMobileNo(mobileNo);
		
		List<String> cars = new ArrayList<String>();
		cars.add("Audi");
		cars.add("bmw");
		seniorEmployee.setCars(cars);
		
		Map<String,String> familyMembers = new HashMap<>();
		familyMembers.put("1", "Father");
		familyMembers.put("2", "Mother");
		familyMembers.put("3", "Brother");
		seniorEmployee.setFamilyMembers(familyMembers);
		// Converting a Java class object to a JSON payload as string
		ObjectMapper objectMapper = new ObjectMapper();

		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		String employeeJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(seniorEmployee);
		System.out.println("Output of valueSetForFields...");
		System.out.println(employeeJson);
	}

}
