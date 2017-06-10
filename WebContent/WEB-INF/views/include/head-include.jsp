<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="req" value="${pageContext.request}"/>
<c:set var="url" value="${req.requestURL}"/>
<c:set var="contextPath" value="${req.contextPath}"/>

<meta name="viewport" content="width = device-width, initial-scale = 1"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" type="image/ico"
	href="/resources/images/pizza_favicon.png">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
      type="text/css">
<link href="https://gist.githubusercontent.com/nodesocket/5843712/raw/10f5747937c8502c896f5f21bf64d2a5a69bb798/bootstrap.flatten.css"
                            type="text/css" rel="stylesheet"/>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">


<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
