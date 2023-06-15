package com.javatpoint.employee.details;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL) // we can hide the null values or null fields with this annotation
@JsonIgnoreProperties({"empSalary","empId"}) // it will ignore the empSalary field if we dont want to show any specific field we can use @JsonIgnoreProperties
@JsonPropertyOrder({"empDesignation", "employeeName","empSalary","empId"})// this is used to set the order in which order we want the filedS to be shown on UI
public class EmployeeDetails {

	// in this class we will make use of @JsonProperty annotation to change the
	// field name
	
	private String employeeName;
	private int empId;
	private float empSalary;
	private String empDesignation;
	@JsonProperty("EMPLOYEE_NAME")
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public float getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
}
