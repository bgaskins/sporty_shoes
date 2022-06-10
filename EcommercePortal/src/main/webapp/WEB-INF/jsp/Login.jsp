<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div align="left">
<img alt="Sporty Shoes welcome logo" height="500px" src="<spring:url value="/resources/images/sporty-shoes-logo.png" />">

</div>

<div class="login" align="center">
	<h1>
	LOGIN
	</h1>
	
	<form:form action="authenticate" name="loginForm" id="loginForm" modelAttribute="user" method="post">	
		<table>
			<tr>
				<td><span style="font-family:Arial">Username:</span></td>
				<td><form:input path="userID" name="username" id="username" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Password:</span></td>
				<td><form:password path="userPass" name="password" id="password" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="btnSub" id="btnSub" value="Submit" />
				</td>
				<td>
					<a href="dispResetPass" title="Click here to Reset Your Password">Reset Password</a>
				</td>
				<td>
					<a href="dispRegister" title="Click here to Register">Register</a>
				</td>
			</tr>
			
		</table>
	</form:form>
</div>

<div id="errorDiv" class="loginPageError">
${errorMessage}
</div>

</body>
</html>