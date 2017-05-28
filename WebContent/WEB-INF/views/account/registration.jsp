<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="/resources/css/signup.css" rel="stylesheet">
<!-- <script type="text/javascript" src="/resources/js/registration.js"></script> -->
</head>
<body>
	<div class="container">
	 <form:form method="POST" modelAttribute="user" class="signUp" id="myForm">

			<h1 class="signUpTitle">Sign up in seconds</h1>
			<form:input type="text" path="ssoId" id="ssoId" class="signUpInput" title="Username must not be blank and contain only letters, numbers and underscores." name="ssoId"/>
			<form:input type="password" path="password" placeholder="Choose a password" id="password" class="signUpInput" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers."/>
			<form:select path="userRoles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm"/>
			<p><input type="submit" class="signUpButton" value="Submit"></p>

	</form:form>
	</div>
	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or +380637129869 -->
</body>
</html>