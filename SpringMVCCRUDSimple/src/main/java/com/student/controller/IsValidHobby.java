package com.student.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = HobbyValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface IsValidHobby {
	String listOfHobbies();
	
//	String listOfValidHobbies() default "Music|Football|Cricket|Hockey";

	String message() default "Please provide a valid Hobby"
			+ "accepted hobbies are - Music, Football,Cricket, Hockey (choose any one)";
	// the above code is mandatory for validation

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
