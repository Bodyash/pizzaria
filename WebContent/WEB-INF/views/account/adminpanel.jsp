<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <div class="success">
        Dear <strong>${user}</strong>, Welcome to Admin Page.
        <br/>
        Would you like to <a href="<c:url value='adminpanel/newuser' />">Add Some Users</a> to keep yourself busy?
        <br/>
        <a href="<c:url value="/logout" />">Logout</a>
    </div>
</body>
</html>