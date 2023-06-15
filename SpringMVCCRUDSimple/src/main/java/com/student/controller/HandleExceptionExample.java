package com.student.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HandleExceptionExample {

	@RequestMapping(value = "/admissionFormHandle.html", method = RequestMethod.GET) // method = RequestMethod.GET are
																						// the http request that the
																						// client has made
	public ModelAndView getAdmissionForm() throws Exception {

		String exceptionOccured = "NULL_POINTER";
		if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		}
		// line number 15 to 17 is provided from the video Spring MVC Tutorials 28 -
		// Exception Handling 01 to create the nullPointerException and below line
		// number 24 to 29 is to handle the Null_PointerException
		ModelAndView model = new ModelAndView("AdmissionForm");

		return model;
	}

	@ExceptionHandler(value = NullPointerException.class)
	public String handleNullPointerException(Exception e) {

		// logging Null Pointer
		System.out.println("Null Pointer Exception Occured " + e);
		return "NullPointerException"; // its return to the NullPointerException.jsp page

	}

	// below is the code to handle the IO-Exception same as the
	// Null_PointerException
	@RequestMapping(value = "/admissionFormHandle2.html", method = RequestMethod.GET) // method = RequestMethod.GET are
																						// the http request that the
																						// client has made
	public ModelAndView getAdmissionForm2() throws Exception {

		String exceptionOccured = "IO_Exception";
		if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		} else if (exceptionOccured.equalsIgnoreCase("IO_Exception")) {
			throw new IOException();
		}
		ModelAndView model = new ModelAndView("AdmissionForm");

		return model;
	}

	@ExceptionHandler(value = IOException.class)
	public String handleIOException(Exception e) {

		// logging Null Pointer
		System.out.println("IO - Exception Occured " + e);
		return "IOException"; // its return to the NullPointerException.jsp page

	}

	// below is the code to handle the Generic Exception Handler
	@RequestMapping(value = "/admissionFormHandle3.html", method = RequestMethod.GET) // method = RequestMethod.GET are
																						// the http request that the
																						// client has made
	public ModelAndView getAdmissionForm3() throws Exception {

		String exceptionOccured = "ARITHMETIC_EXCEPTION";
		if (exceptionOccured.equalsIgnoreCase("NULL_POINTER")) {
			throw new NullPointerException("Null Pointer Exception");
		} else if (exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")) {
			throw new ArithmeticException("ARITHMETIC_EXCEPTION");
		}
		ModelAndView model = new ModelAndView("AdmissionForm");
 
		return model;
	}

	
	// we can add Generic Exception Handler to Handle all types of Exceptions
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value=Exception.class)
	public String handleException(Exception e) {

		// Logging Generic Unknow Exception
		System.out.println("Unknow Exception Occured " + e);
		return "Exception";
	}
	

}
