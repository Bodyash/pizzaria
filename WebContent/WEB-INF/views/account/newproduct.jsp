<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body>
    <div class="flex-container">
    
	<c:choose>
		<c:when test="${edit}">
			<h1>Now you are editing product: "<c:out value="${prod.name}"></c:out>"</h1>
		</c:when>
        <c:otherwise>
			<h1>New Product Form</h1>
         </c:otherwise>
	</c:choose>
    
    <form:form method="POST" modelAttribute="prod" class="form-horizontal">
    <form:input type="hidden" path="id" id="id"/>
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="imgUrl">Image Url</label>
                <div class="col-md-7">
					<form:input type="text" path="imgUrl" id="imgUrl" class="form-control input-sm"/>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Product name</label>
                <div class="col-md-7">
					<form:input type="text" path="name" id="name" class="form-control input-sm"/>
                </div>
            </div>
        </div>
 
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="price">Price</label>
                <div class="col-md-7">
					<form:input type="text" path="price" id="price" class="form-control input-sm"/>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="name">Description</label>
                <div class="col-md-7">
					<form:input type="text" path="description" id="description" class="form-control input-sm"/>
                </div>
            </div>
        </div>
        
        <div class="row">
            <div class="form-group col-md-12">
                <label class="col-md-3 control-lable" for="category">Category</label>
                <div class="col-md-7">
                	<form:select path="category" cssClass="form-control">
    					<form:options items="${category}"/>
					</form:select>
                </div>
            </div>
        </div>
        
                <div class="row">
            <div class="form-actions floatRight">
            <c:choose>
                    <c:when test="${edit}">
                        <input type="submit" value="Save" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/adminpanel' />">Cancel</a>
                    </c:when>
                    <c:otherwise>
                        <input type="submit" value="Add" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/adminpanel' />">Cancel</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
    </div>
</body>
</html>