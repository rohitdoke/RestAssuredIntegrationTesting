package com.justimagine.JsonPath;

import java.io.File;
import java.util.List;

import org.junit.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathSyntaxForJsonArray {
	
	//Learn to write JsonPath expressions or JsonPath syntax
	
	@Test
	public void testJsonPathSyntaxForArray()
	{
		
		
		File jsonFile=new File(System.getProperty("user.dir")+"\\src\\main\\resources\\jsonFiles\\jsonArraySyntaxDemo.json");

						JsonPath jsonPath = JsonPath.from(jsonFile);
						
						/*
						 * To get a specific field value of an indexed element [0] will give you first
						 * element in an array and using dot operator we are retrieving value of
						 * firstName
						 */			
						
						String firstName = jsonPath.getString("[0].first_name");
						
						System.out.println("First Name of [0] index:"+firstName);
						
						System.out.println("First Name of [1]index:"+jsonPath.getString("[1].first_name"));
						
						
						/*
						 * To get first names of all employees Since it is a JSON array and we are not
						 * specifying index then it will pick firstName from each element and return as
						 * a list.
						 */
						
						List<Object> listFirstName = jsonPath.getList("first_name");
						
						listFirstName.stream().forEach(n->System.out.println(n));
						
						/* To get all first name of all females only 
						 * If we want to filter records based on conditions we can use find or findAll expression.
						 * findAll will iterate through each element in array and match condition. "it" represent current element.
						 * For each element it will check if gender is "female". If yes then take firstName of current element. 
						 * findAl returns a List. */
						
						
						List<String> list = jsonPath.getList("findAll{it.gender=='Female'}.first_name");
						List<String> maleList=jsonPath.getList("findAll{it->it.gender=='Male'}.first_name");
						
						List<String> findById=jsonPath.getList("findAll{it.id==4}.first_name");
						
						System.out.println("Name of Employee id=4"+findById);
						
						System.out.println("List Female Gender"+list);
						
						System.out.println("Male List"+maleList);
						
						
						/*
						 * We can also use relational operator like first name of all employees whose id is 5 or more
						 */
						System.out.println("First name of all employees whose id is 5 or more : " + jsonPath.getList("findAll{it.id >= 5}.first_name"));
						// we can use use and (&) operator - logical
						List<Object> list2 = jsonPath.getList("findAll{it.id>=5 & it.id<8}.first_name");
						
						
						System.out.println("List of Employees 5<id>8:"+list2);
						
						
						// We can also use or (|) operator
						System.out.println("First name of all employees whose id is greater than 9 or gender is female : " + jsonPath.getList("findAll{it.id >= 9 | it.gender == 'Female'}.first_name"));
						
						// We can get size of array using size() or size
						System.out.println("Total number of employees : " + jsonPath.getString("size()"));
						
						
						
						
	}
	
	

}
