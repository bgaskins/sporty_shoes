<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>

<link href="<spring:url value="/resources/css/main.css"/>" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Password Reset</title>
</head>
<body>
<div align="left">
<img alt="Sporty Shoes logo" height="500px" src="<spring:url value="/resources/images/sporty-shoes-logo.png" />">
</div>

<div class="resetPass" align="center">
	<h1>
	RESET PASSWORD
	</h1>
	<form action="resetPass" name="resetPass" method="post">
		<table>
			<tr>			
				<td><span style="font-family:Arial">Username:</span></td>
				<td><input type="text" name="userName" id="userName" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Old Password:</span></td>
				<td><input type="password" name="oldPassword" id="oldPassword" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">New Password:</span></td>
				<td><input type="password" name="newPassword" id="newPassword" /></td>
			</tr>
			<tr>
				<td><span style="font-family:Arial">Confirm Password:</span></td>
				<td><input type="password" name="confirmPassword" id="confirmPassword" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="btnSub" id="btnSub" value="Submit" />
				</td>	
				<td>
					Have An Account? <a href="main" >Click Here</a>
				</td>			
			</tr>
			
		</table>
	</form>
</div>

<div id="errorDiv" class="resetPassPageError">
${errorMessage}
</div>


</body>
</html>