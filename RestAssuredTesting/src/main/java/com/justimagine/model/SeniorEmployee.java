package com.justimagine.model;



import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)

@JsonIgnoreProperties(value = {"gender","age"},ignoreUnknown = true)//Ignore the propeties from Json Response


//ignoreUnkwon value will not include the property in the Json response which are not included in the Pojo  class using json
//@JsonIgnoreProperties
public class SeniorEmployee {

	// private variables or data members of pojo class
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private double salary;
	private boolean married;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String[] mobileNo;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private List<String> cars;
	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Map<String,String> familyMembers;
	
	// Getter and setter methods
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public boolean getMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	} 	
	public String[] getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String[] mobileNo) {
		this.mobileNo = mobileNo;
	}
	public List<String> getCars() {
		return cars;
	}
	public void setCars(List<String> cars) {
		this.cars = cars;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}
}
