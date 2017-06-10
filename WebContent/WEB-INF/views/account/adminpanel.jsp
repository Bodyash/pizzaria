<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Adminpanel</title>
<link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body>
    <div class="flex-container">
        Dear <strong> ${user}</strong>, Welcome to Admin Page.<br><br>
		<a href="<c:url value='/adminpanel/userlist' />">UserList (Edit, Create New User, Delete)</a><br><br>
		<a href="<c:url value='/adminpanel/productlist' />">List of All Products (Edit, add new, Delete)</a><br>
    </div>
</body>
</html>