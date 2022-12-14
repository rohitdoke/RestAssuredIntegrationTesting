package com.justimagine.model;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateEmployeeJSONPayload {
	
	
	@Test
	public void testEmpJosn() throws IOException {
		
		
		Employee  emp1=new Employee();
		
		
		emp1.setFirstName("Rohit");
		//emp1.setLastName("Doke");
		emp1.setGender("Male");
		//emp1.setAge(26); 
		//IF NOT set value of filed it will not print the default
		//value of age if use @JsonInclude(Include.NON_DEFAULT)it will ignore that field
		emp1.setMarried(false);
		emp1.setSalary(10000);

		ObjectMapper mapper=new ObjectMapper();
		
		
		String string = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp1);
		
		System.out.println(string);
		String userDir= System.getProperty("user.dir");
		
		File outputJSONfile=new File(userDir+"\\src\\main\\resources\\EmployeePayload.json");
		
		
		mapper.writerWithDefaultPrettyPrinter().writeValue(outputJSONfile,emp1);
	}
}
