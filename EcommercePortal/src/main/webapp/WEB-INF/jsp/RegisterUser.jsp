<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

<div align="left">
<img alt="Sporty Shoes logo" height="500px" src="<spring:url value="/resources/images/sporty-shoes-logo.png" />">
</div>

<div class="register" align="center">
	<h1>
	CREATE A PROFILE
	</h1>
	
	<form:form action="register" name="registerForm" id="registerForm" modelAttribute="customer" method="post">	
		<table>
			<tr>
				<td><span style="font-family:Arial">First Name:</span></td>
				<td><form:input path="custFirstName" name="custFirstName" id="custFirstName" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Last Name:</span></td>
				<td><form:input path="custLastName" name="custLastName" id="custLastName" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Email:</span></td>
				<td><form:input path="custEmail" name="custEmail" id="custEmail" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Phone:</span></td>
				<td><form:input path="custPhone" name="custPhone" id="custPhone" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Username:</span></td>
				<td><form:input path="userID" name="userID" id="userID" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Password:</span></td>
				<td><form:password path="userPass" name="userPass" id="userPass" /></td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			<tr></tr>
			
			<tr>
				<td>
					<input type="submit" name="btnSub" id="btnSub" value="Submit" />
				</td>	
				<td>
					Have An Account? <a href=main >Click Here</a>
				</td>
			</tr>
			
		</table>
	</form:form>
</div>

<div id="errorDiv" class="registerPageError" align="center">
${message}
</div>


</body>
</html>