package com.student.controller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport{
	
	//when you will submit the addmission form -->
	//spring mvc will run setAsTExt fucntion of the class -->
	// before performing the data binding task for studentName property of the student object
	// it is used to set the defulat value for studentName if Mr. is not given before studentName then it will by default put Ms. before studentName
	
	
	public void setAsText(String studentName)throws IllegalArgumentException{
		
		if(studentName.contains("Mr. ") || studentName.contains("Ms. ")){
			setValue(studentName);
		}
		else{
			studentName = "Ms. "+studentName;
			setValue(studentName);//WHAT every value you will provide to setValue --- spring mvc will use the 
									// same value to perform data binding task for studentName property
		}
	}

}
