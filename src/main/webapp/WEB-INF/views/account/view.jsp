<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<meta http-equiv="content-type" content="text/html;charset=UTF-8" />
<title>${user.username}</title>
</head>
<body>
	<body background=https://www.tesla.com/tesla_theme/assets/img/models/section-hero-background.jpg?20170115>
	<div class="jumbotron">
		<div class="container" style="margin-left: 120px">
			<div style="margin-bottom: 20px">
				<h1>Our sales manager will contact you as soon as possible to clarify other issues! Have a nice day!</h1>
				<h2>Profile</h2>
			</div>
			<fieldset class="form-group">
				<label class="col-sm-2 control-label">Username:</label> <label
					class="col-sm-10">${user.username}</label>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label">First Name:</label> <label
					class="col-sm-10">${user.firstName}</label>
			</fieldset>

			<fieldset class="form-group">
				<label class="col-sm-2 control-label">Last Name:</label> <label
					class="col-sm-10">${user.lastName}</label>
			</fieldset>


			<fieldset class="form-group">
				<label class="col-sm-2 control-label">Password:</label> <label
					class="col-sm-10">${user.password}</label>
			</fieldset>

			<a class="btn btn-danger" href="${user.username}/edit">Edit
				Profile</a>

		</div>
	</div>

</body>
</html>