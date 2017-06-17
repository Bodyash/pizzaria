<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html ng-app="cartApp">
<head>
<link href="/resources/css/content.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src='<c:url value="/resources/js/controllers.js" />'></script>
</head>
<body ng-controller="cartController" ng-init="initCartId('${cartId}')"> 
<ul class="flex-container">
	<c:forEach items="${pizzas}" var="pizza">
  		<li class="flex-item">
  		<article class="block__content">
  			<header>
				<h3>${pizza.name}</h3>
			</header>
			<section class="description">
				<p>${pizza.description}
			</section>
			<section class="food_img">
				<img alt="" src="${pizza.imgUrl}" height="220px" width="220px">
			</section>
			<footer>
				<a ng-click="addToCart('${pizza.id}')" href="#" class="btn btn-primary">Add to Cart (<fmt:formatNumber value="${pizza.price}" type="currency" currencyCode="UAH"/>)</a>
			</footer>
  		</article>
 		 </li>
	</c:forEach>
</ul>
</body>
</html>
