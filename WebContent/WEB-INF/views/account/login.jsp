<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form action="${loginUrl}" method="post" class="signUp" id="myForm">
			<h1 class="signUpTitle">Login Form</h1>
			<c:if test="${param.error != null}">
				<div class="alert alert-danger">
					<p>Invalid username and password.</p>
				</div>
			</c:if>
			<c:if test="${param.logout != null}">
				<div class="alert alert-success">
					<p>You have been logged out successfully.</p>
				</div>
			</c:if>
			<c:if test="${success != null}">
				<div class="alert alert-success">
					<p>${success}</p>
				</div>
			</c:if>
			<input type="text" class="signUpInput" id="username" name="ssoId"
				placeholder="Enter Username" autofocus required> <input
				type="password" class="signUpInput" id="password" name="password"
				placeholder="Enter Password" required> <input type="hidden"
				name="${_csrf.parameterName}" value="${_csrf.token}" /> 
				<input type="submit" class="signUpButton"
				value="Login"> <br> <br>
			<center>
				<a href="signup">Or SignUp</a>
			</center>
		</form>
	</div>
</body>
</html>