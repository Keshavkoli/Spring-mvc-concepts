<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<link rel="stylesheet" href="<spring:theme code='styleSheet'/>" type="text/css"/>

	<p>
		<a
			href="/SpringMVCCRUDSimple/admissionForm.html?siteTheme=green">Green</a>
		| <a
			href="/SpringMVCCRUDSimple/admissionForm.html?siteTheme=red">Red</a>
	</p>


	<a href="/SpringMVCCRUDSimple/submitAdmissionForm.html?siteLanguage=en">English</a>
	|
	<a href="/SpringMVCCRUDSimple/submitAdmissionForm.html?siteLanguage=fr">French</a>
	<h1>${headerMessage}</h1>
<!-- 	<h1>STUDENT ADMISSION FORM FOR ENGINEERING COURSES</h1> -->
	<h3>
		<spring:message code="label.admissionForm" />
	</h3>

	<form:errors path="student1.*" />

	<form action="/SpringMVCCRUDSimple/submitAdmissionForm.html"
		method="post">

		<table>
			<tr>
				<td>student NAME:</td>
				<td><spring:message code="label.studentName" /></td>
				<td><input type="text" name="studentName" /></td>
			</tr>

			<tr>
				<td>Student Hobby :</td>
				<td><spring:message code="label.studentHobby" /></td>
				<td><form:errors path="studentHobby" cssClass="error"
						autocomplete="off" /><input type="text" name="studentHobby" /></td>
			</tr>

			<tr>
				<td>Student Mobile :</td>
				<td><spring:message code="label.studentMobile" /></td>
				<td><input type="text" name="studentMobile" /></td>
			</tr>

			<tr>
				<td>Student Date Of Birth (dd/MM/yyyy):</td>
				<td><spring:message code="label.studentDOB" /></td>
				<td><input type="text" name="studentDOB" /></td>
			</tr>

			<tr>
				<td>Student Skills :</td>
				<td><spring:message code="label.studentSkills" /></td>
				<td><select name="studentSkills" multiple>
						<option value="Core Java">Core Java</option>
						<option value="Spring Core">Spring Core</option>
						<option value="Spring Mvc">Spring Mvc</option>
				</select></td>
			</tr>


		</table>

		<table>
			<tr>
				<td>Student 's Address :</td>
			</tr>
			<td><spring:message code="label.studentAddress" /></td>
			<tr>
				<td>country : <spring:message code="label.country" /><input
					type="text" name="studentAddress.country" /></td>
				<td>city :<spring:message code="label.city" /><input
					type="text" name="studentAddress.city" /></td>
				<td>street :<spring:message code="label.street" /><input
					type="text" name="studentAddress.street" /></td>
				<td>pincode :<spring:message code="label.pincode" /><input
					type="text" name="studentAddress.pincode" /></td>
			<tr>
				<td><input type="submit"
					value="Submit this form by Clicking here" /></td>
			</tr>
		</table>
	</form>
</body>
</html>