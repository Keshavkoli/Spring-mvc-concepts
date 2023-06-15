package com.student.controller;

import java.net.http.HttpHeaders;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Controller
//@RestController // if we specific the @RestController annotation on class then we dont needd to add the @ResponseBody annotation on methods 
public class WebServicesExample {
//	http://localhost:9090/SpringMVCCRUDSimple/students
	//***************************Retrieving All EmployeeDetails Records********************
	@ResponseBody
	@RequestMapping(value = "/students", method = RequestMethod.GET,produces =MediaType.APPLICATION_JSON_VALUE)
	public ArrayList<Student> getStudentList() {

		Student student1 = new Student();
		student1.setStudentName("The Great Khali");

		Student student2 = new Student();
		student2.setStudentName("The UnderTaker");

		Student student3 = new Student();
		student3.setStudentName("John Cena");

		ArrayList<Student> studentsList = new ArrayList<Student>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);

		return studentsList;
	}
	//***************************Retrieving All Students Records with the use of @PathVariable ********************
	
	@ResponseBody
	@RequestMapping(value="/students/{name}",method=RequestMethod.GET)
	public Student getStudent(@PathVariable("name") String studentName) {
		
		// fetch the student's record using "studentName" from DB
		Student student = new Student();
		student.setStudentName(studentName);
		student.setStudentHobby("Football");
		
		
		return student;
	}
	
	
	
	//added the new RestApi with the help of video number 40 to make update in the Restapi
	//***************************Updating the Student Records ********************
	/*
	@ResponseBody
	@RequestMapping(value="/students/{name}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_XML_VALUE) // this is restricted to support only one format 
	public boolean updateStudent(@PathVariable("name") String studentName,@RequestBody Student student) {
		System.out.println(":StudentName :"+studentName);
		System.out.println(":StudentName :"+student.getStudentName()+ "Student Hobby :"+student.getStudentHobby());
		
		//finding the matching student record using "studentName" from the DB
		//updating the matching student record with the information of student sent by the client successfully
		
		
		// return true if return is successfully done and return false if update is not done successfully
		
		return true;
 	}
 	
	@ResponseBody
	@RequestMapping(value="/students/{name}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE) // this is restricted to support only one format 
	public ResponseEntity<Void> updateStudent(@PathVariable("name") String studentName,@RequestBody Student student) {
		System.out.println(":StudentName :"+studentName);
		System.out.println(":StudentName :"+student.getStudentName()+ "Student Hobby :"+student.getStudentHobby());
		
		//finding the matching student record using "studentName" from the DB
		//updating the matching student record with the information of student sent by the client successfully
		
		
		// return true if return is successfully done and return false if update is not done successfully
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
 	}

	
	@ResponseBody
	@RequestMapping(value="/students/{name}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE) // this is restricted to support only one format 
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName,@RequestBody Student student) {
		System.out.println(":StudentName :"+studentName);
		System.out.println(":StudentName :"+student.getStudentName()+ "Student Hobby :"+student.getStudentHobby());
		
		//finding the matching student record using "studentName" from the DB
		//updating the matching student record with the information of student sent by the client successfully
		
		
		// return true if return is successfully done and return false if update is not done successfully
		
		return new ResponseEntity<Boolean>(true ,HttpStatus.NOT_FOUND);
 	}
	*/
	
	@ResponseBody
	@RequestMapping(value="/students/{name}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE) // this is restricted to support only one format 
	public ResponseEntity<Boolean> updateStudent(@PathVariable("name") String studentName,@RequestBody Student student) {
		System.out.println(":StudentName :"+studentName);
		System.out.println(":StudentName :"+student.getStudentName()+ "Student Hobby :"+student.getStudentHobby());
		
		//finding the matching student record using "studentName" from the DB
		//updating the matching student record with the information of student sent by the client successfully
		
		// return true if return is successfully done and return false if update is not done successfully		
		
		org.springframework.http.HttpHeaders httpHeader = new org.springframework.http.HttpHeaders();
		httpHeader.add("Key1", "Value1");
		httpHeader.add("Key2", "Value2");
		
		return new ResponseEntity<Boolean>(true ,httpHeader,HttpStatus.OK);
		// by the above code we can customise our own HttpResponse
 	}
	
	//***************************Posting the Student Records ********************
	@RequestMapping(value = "/students",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Boolean> postStudent(@RequestBody Student student){
		System.out.println("Student Name :"+student.getStudentName()+ "Student Hobby "+student.getStudentHobby());
		
		//insert the student record into the database 
		// the below code line number 136 and 137 is added from the video 45 	we would check what response we get in headers of postman
		org.springframework.http.HttpHeaders httpHeader = new org.springframework.http.HttpHeaders();
		httpHeader.add("Location",ServletUriComponentsBuilder.fromCurrentRequest().path("{/name}").buildAndExpand(student.getStudentName()).toUri().toString());
		
		//line number 136 and 137 is just telling to the client that what ever resource it has been created what ever student record it has inserted into the database
		//that resource can be read by making a get request in this rest api
		return new ResponseEntity<Boolean>(true,HttpStatus.CREATED);
	}

	//***************************Deleting the Student Records ********************
	@RequestMapping(value = "/students/{name}",method = RequestMethod.DELETE)
		public ResponseEntity<Boolean> deleteStudent(@PathVariable("name") String studentName){
			
			System.out.println("Student Name :"+studentName);
			//deleting the students records from the database
			return new ResponseEntity<Boolean>(true,HttpStatus.OK);
		}
	
	//***************************Deleting All Student Records ********************
		@RequestMapping(value = "/students",method = RequestMethod.DELETE)
			public ResponseEntity<Boolean> deleteAllStudent(){
				//deleting All students records from the database
				return new ResponseEntity<Boolean>(true,HttpStatus.OK);
			}
	
}
