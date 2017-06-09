<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body>
    <div class="flex-container">
        <div class="panel panel-default">
              <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead">List of Products </span></div>
		<form:form method="POST">
				<input type="text" id="productname" placeholder="Enter Product Name" name="productname" class="form-control">
				<input type="submit" class="btn btn-secondary" value="Search">
		</form:form>
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>img</th>
                        <th>name</th>
                        <th>price</th>
                        <th>desc</th>
                        <th>category</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${products}" var="prod">
                    <tr>
                        <td><img src="${prod.imgUrl}" height="100px" width="100px"></td>
                        <td>${prod.name}</td>
                        <td>${prod.price}</td>
                        <td>${prod.description}</td>
                        <td>${prod.category}</td>
                        <td><a href="<c:url value='/adminpanel/edit-product-${prod.id}' />" class="btn btn-success 
 
custom-width">edit</a></td>
                        <td><a href="<c:url value='/adminpanel/delete-product-${prod.id}' />" class="btn btn-danger 
 
custom-width">delete</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            </div>
            <a href="<c:url value='/adminpanel/newproduct'/>">Add New Product</a>
            </div>
</body>
</html>