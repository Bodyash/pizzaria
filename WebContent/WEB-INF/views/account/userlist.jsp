<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/resources/css/admin.css" rel="stylesheet">
</head>
 
<body>
    <div class="flex-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Users </span></div>
		<form:form method="POST">
				<input type="text" id="ssoId" placeholder="Enter Username Here To Search User in all DataBase" name="ssoId" class="form-control">
				<input type="submit" class="btn btn-secondary" value="Search">
		</form:form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>SSO ID</th>
                        <th>Roles</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${userlist}" var="user">
                    <tr>
                        <td>${user.ssoId}</td>
                        <td>
                        <c:forEach items="${user.userRoles}" var="userRole">
                        	<c:out value="${userRole.type} "></c:out>
                        </c:forEach>
                        </td>
                        <td><a href="<c:url value='/adminpanel/edit-user-${user.ssoId}' />" class="btn btn-success 
 
custom-width">edit</a></td>
                        <td><a href="<c:url value='/adminpanel/delete-user-${user.ssoId}' />" class="btn btn-danger 
 
custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
            <a href="<c:url value='/adminpanel/newuser' />">Add New User</a>
    </div>
</body>
</html>