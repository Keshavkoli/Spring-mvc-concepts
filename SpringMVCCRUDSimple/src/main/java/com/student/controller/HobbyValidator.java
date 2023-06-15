package com.student.controller;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class HobbyValidator implements ConstraintValidator<IsValidHobby, String> {

	// In here the Custom validation before making call to isValid method it first
	// call the initialize function of this corresponding validator class
	// of this custom validation class

	private String listofValidHobbes;

	@Override
	public void initialize(IsValidHobby isValidHobby) {
		this.listofValidHobbes=isValidHobby.listOfHobbies();

	}

	@Override
	public boolean isValid(String studentHobby, ConstraintValidatorContext cxt) {

		if (studentHobby == null) {
			return false;
		}

		// the values given are hardcoded we can have developer provided values also
		if (studentHobby.matches(listofValidHobbes)) {
			return true;
		} else {
			return false;
		}

	}

}
