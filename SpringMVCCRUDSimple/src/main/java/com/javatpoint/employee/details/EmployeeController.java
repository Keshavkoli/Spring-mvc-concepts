package com.javatpoint.employee.details;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Controller
@JsonAutoDetect(fieldVisibility = Visibility.ANY, getterVisibility = Visibility.NONE, setterVisibility = Visibility.NONE)
public class EmployeeController {

//	http://localhost:9090/SpringMVCCRUDSimple/employees
	//***************************Retrieving All EmployeeDetails Records********************
	@ResponseBody
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ArrayList<EmployeeDetails> getEmployeeList() {

		EmployeeDetails employee1 = new EmployeeDetails();
		employee1.setEmployeeName("Keshav");

		EmployeeDetails employee2 = new EmployeeDetails();
		employee2.setEmployeeName("Kartik");

		EmployeeDetails employee3 = new EmployeeDetails();
		employee3.setEmployeeName("Kaveri");

		ArrayList<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();
		employeeList.add(employee1);
		employeeList.add(employee2);
		employeeList.add(employee3);

		return employeeList;
	}


}
