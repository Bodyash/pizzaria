<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="/resources/css/login.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<form class="signUp" id="myForm" method="POST" action="...">
			<h1 class="signUpTitle">Please, Login!</h1>
			<input id="field_username" placeholder="Type your username" autofocus class="signUpInput" type="text" required name="username">
			<input id="field_pwd1" placeholder="Enter password here" class="signUpInput" type="password" required name="pwd">
			<input type="submit" class="signUpButton" value="Login">
			<br>
			<br>
			<center><a href="signup">Or SignUp</a></center>
		</form>
	</div>
	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or +380637129869 -->
</body>
</html>