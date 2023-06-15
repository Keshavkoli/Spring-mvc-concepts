package com.student.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;

//below is the example of @RequestParam and also the example of @ModelAttribute
// steps Creating StudentAdmissionController.java class
//Creating admissionForm.jsp and AdmissionSuccess.jsp
// and write how to handle html in spring mvc
// we can have a empty value and can also handle it with default value
@Controller
public class StudentAdmissionController {
	
	
	// below performing  databinding called the initBinder it is used to ignore some fields  example it will ignore the studentMobile number and it will not print it 

	@InitBinder
	public void initBinder(WebDataBinder binder) {
//		binder.setDisallowedFields(new String[] {"studentMobile"});// it will not print because we have used the @InitBinder annotation to setDisallowedFields
		binder.setDisallowedFields(new String[] {"studentDOB"});
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");// in which format we want the date
		binder.registerCustomEditor(Date.class, "studentDOB",new CustomDateEditor(dateformat, false));
		binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());// this line is added to print the default Ms value in the Student class in studentName colum 
																						// which is used in the StudentNameEditor class
	}

	
	@RequestMapping(value = "/admissionForm.html", method = RequestMethod.GET) // method = RequestMethod.GET are the http request that the client has made
	public ModelAndView getAdmissionForm() throws Exception{

		ModelAndView model = new ModelAndView("AdmissionForm");

		return model;
	}

	
	// below is the example of Student Class with getter and setter
	// its also show here how we can set the default value for a field
	// this same code is written with the help of @ModelAttribute and shorten the code its from line 68 to 75 please check
	
	/*
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value = "studentName", defaultValue = "Mr, ABC") String studentName,
			@RequestParam("studentHobby") String studentHobby, @RequestParam("studentMobile") Long studentMobile,@RequestParam("studentDOB") String studentDOB,@RequestParam("studentSkills") String[] studentSkills) {
		
		Student student1 = new Student();
		try {
			student1.setStudentName(studentName);
			student1.setStudentHobby(studentHobby);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			student1.setStudentDOB(format.parse(studentDOB));
			student1.setStudentMobile(studentMobile);
			ArrayList<String> skillsetList = new ArrayList<String>();
			for(int i=0;i < studentSkills.length;i++) {
				skillsetList.add(studentSkills[i]);
			}
			student1.setStudentSkills(skillsetList);
			System.out.println(student1.toString());
		}
		
		catch(Exception e) {
			
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("student1",student1);
		return model;		
	}
	
	*/
	
	/*
	
	// to have a multiple @RequestParam we can use the map<String,String>
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam Map<String, String> reqpar) {

		String name = reqpar.get("studentName");
		String hobby = reqpar.get("studentHobby");
		System.out.println(hobby);

		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("msg", "Details Submitted by you :: Name  " + name + " Hobby  " + hobby);
		return model;
	}
*/	
	
	// below is the example of @ModelAttribute which works like @RequestParam but its shorts the code 
	// to use the @ModelAttribute we have to declare the fields name same in the Student class AdmissionForm.jsp and AdmissionSuccess.jsp
	//@ModelAttribute will automatically bind all request parameter or form elements submitted by the user in the corresponding properties in the Student Object
	// In the Corresponding jsp file for AdmissionSuccess.jsp file student1 reference to jsp key
	
	
	@ModelAttribute
	public void addingCommonObjects(Model model1) {
		model1.addAttribute("headerMessage", "Keshav College of Engineering, India");
	}
	
	@RequestMapping(value = "/submitAdmissionForm.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm( @Valid @ModelAttribute("student1") Student student,BindingResult result) {
		// here BindingResult in the method argument will handle the mismatch values from long to string or any other values
		// steps to put the BindingResult is first in the Method Argument and then put a taglib library in AdmissionForm.jsp and <form :error path="student1.*"/>
		
         
		if(result.hasErrors()) {
			ModelAndView model1 = new ModelAndView("AdmissionForm");
			System.out.println(":student :=> "+student.getStudentName());
			System.out.println(":StudentHobby :=> "+student.getStudentHobby());
			System.out.println(":StudentMobile :=> "+student.getStudentMobile());
			System.out.println(":StudentDOB :=> "+student.getStudentDOB());
			System.out.println(":StudentSkills :=> "+student.getStudentSkills());
			System.out.println(":student Address Country:=> "+student.getStudentAddress().getCountry().toString());
			System.out.println(":student Address city:=> "+student.getStudentAddress().getCity().toString());
			System.out.println(":student Address street:=> "+student.getStudentAddress().getStreet().toString());
			System.out.println(":student Address pincode:=> "+student.getStudentAddress().getPincode().toString());
			return model1;
		}
		ModelAndView model1 = new ModelAndView("AdmissionSuccess");		
		return model1;
	}
			
}
