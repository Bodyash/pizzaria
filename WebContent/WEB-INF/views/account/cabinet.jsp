<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body>
    <div class="flex-container">
        Dear <strong>${user}</strong>, Welcome to cabinet Page.
        <br/>
        <br/>
        <a href="<c:url value="/logout" />">Logout</a>
    </div>
</body>
</html>