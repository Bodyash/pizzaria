<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>Signup</title>
<link href="/resources/css/signup.css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/registration.js"></script>
</head>
<body>
	<div class="container">
		<form class="signUp" id="myForm" method="POST" action="...">
			<h1 class="signUpTitle">Sign up in seconds</h1>
			<input id="field_username" placeholder="Type your username" autofocus class="signUpInput" title="Username must not be blank and contain only letters, numbers and underscores." type="text" required pattern="\w+" name="username">
			<input id="field_pwd1" placeholder="Choose a password" class="signUpInput" title="Password must contain at least 6 characters, including UPPER/lowercase and numbers." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd1">
			<input id="field_pwd2" placeholder="Repeat a password" class="signUpInput" title="Please enter the same Password as above." type="password" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}" name="pwd2">
			<p><input type="submit" class="signUpButton" value="Submit"></p>
		</form>
	</div>
	<!-- Looking for source of this page? Contact me: vk.com/id20444094 or 0637129869 -->
</body>
</html>