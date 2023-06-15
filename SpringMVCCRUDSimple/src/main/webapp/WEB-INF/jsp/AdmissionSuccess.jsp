<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${headerMessage}</h1>
	<h1>Congratulations !! The Engineering college has processed your
		Application form Successfully</h1>

	<h2>Details Submitted by you ::</h2>

	<table>
		<tr>
			<td>Student Name :</td>
			<td>${student1.studentName}</td>
		</tr>
		<tr>
			<td>Student Hobby :</td>
			<td>${student1.studentHobby}</td>
		</tr>

		<tr>
			<td>Student student Mobile :</td>
			<td>${student1.studentMobile}</td>
		</tr>

   		<tr>  
			<td>Student student DOB :</td>
			<td>${student1.studentDOB}</td>
		</tr>
		


		<tr>
			<td>Student Skills :</td>
			<td>${student1.studentSkills}</td>
		</tr>
		
		<tr>
		<td>Student Address :</td>
		<td>country :${student1.studentAddress.country}
			city :${student1.studentAddress.city}
			street :${student1.studentAddress.street}
			pincode :${student1.studentAddress.pincode}</td> 
		</tr>
		 

	</table>
</body>
</html>