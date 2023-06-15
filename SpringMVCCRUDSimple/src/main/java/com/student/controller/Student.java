package com.student.controller;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonInclude(JsonInclude.Include.NON_NULL) // we can hide the null values or null fields with this annotation
public class Student {
	// to make use of this use add the hibernate validator dependency in the pom.xml file and also add the @Valid value in the StudentAddmissionController class before @ModeAttribute
	@Pattern(regexp="[^0-9]*")// this code will not allow any number values in the field
	private String studentName;
	//, message = "Please Enter the value for studentHobby field between {min} and {max} characters."
	// we can have the same message which is in the above code we can have it in the properties files also 
	//we have to make changes like 1) add bean id="messageSource" in spring-servlet.xml and also the property and value also add the code in the student.message.properties	
	@Size(min = 2, max = 30) @IsValidHobby(listOfHobbies = "Music|Football|Cricket|Hockey") // for by default if you do not provide the list of hobbies in the parameter it will get the values from IsValidHobby interface from String listOfValidHobbies() default "Music|Football|Cricket|Hockey"; by default
	private String studentHobby;
	@Max(2222) //must be equal or less then 2222
	private Long studentMobile;
//	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past // by providing the @Past validation pattern it will not allow us to use the future date(must be the past)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date studentDOB;
	private ArrayList<String> studentSkills;

	private Address studentAddress;

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentHobby() {
		return studentHobby;
	}

	public void setStudentHobby(String studentHobby) {
		this.studentHobby = studentHobby;
	}

	public Long getStudentMobile() {
		return studentMobile;
	}

	public void setStudentMobile(Long studentMobile) {
		this.studentMobile = studentMobile;
	}

	public Date getStudentDOB() {
		return studentDOB;
	}

	public void setStudentDOB(Date studentDOB) {
		this.studentDOB = studentDOB;
	}

	public ArrayList<String> getStudentSkills() {
		return studentSkills;
	}

	public void setStudentSkills(ArrayList<String> studentSkills) {
		this.studentSkills = studentSkills;
	}

	public Address getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(Address studentAddress) {
		this.studentAddress = studentAddress;
	}

}
