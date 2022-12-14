package com.justimagine.model;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.justimagine.model.Employee;

public class EmployeeSerializationDeserialization {
	
	
	
	@Test
	public void createEmployeeJSONFromEmployeePOJOClass() throws JsonProcessingException
	{
		
		
		// Just create an object of Pojo class
				Employee employee = new Employee();
				// Set value as you wish
				employee.setFirstName("Rohit");
				employee.setLastName("Sharam");
				employee.setAge(29);
				employee.setGender("Male");
				employee.setSalary(3434343);
				employee.setMarried(false);
				
				
				//converting java Class object into the JSON payload
				
				
				ObjectMapper mapper=new ObjectMapper();
				
				
				String writeValueAsString = mapper.writeValueAsString(employee);
				
				
				System.out.println("Employee object As JSON  FORMAT"+writeValueAsString);
				
				
				
				
				
				
				
				
				
				// Converting Eployee json string to Employee class object
				
				//Reading JSON Object from in the form class object
				
				
				Employee employee2 = mapper.readValue(writeValueAsString, Employee.class);
				
				
				System.out.println("emp object form JSON object"+employee2);
				
				
				
				
				
				
				
		
		
	}

}
