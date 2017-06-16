<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html ng-app="cartApp">
<head>
<link href="/resources/css/content.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="/resources/js/controllers.js"></script>
</head>
<body ng-controller="cartController" ng-init="initCartId('${cartId}')">
<ul class="flex-container">
	<c:forEach items="${drinks}" var="drink">
  		<li class="flex-item">
  		<article class="block__content">
  			<header>
				<h3>${drink.name}</h3>
			</header>
			<section class="description">
				<p>${drink.description}
			</section>
			<section class="food_img">
				<img alt="" src="${drink.imgUrl}" height="220px" width="220px">
			</section>
			<footer>
				<a ng-click="addToCart('${drink.id}')" href="#" class="btn btn-primary">Add to Cart (<fmt:formatNumber value="${drink.price}" type="currency" currencyCode="UAH"/>)</a>
			</footer>
  		</article>
 		 </li>
	</c:forEach>
</ul>
</body>
</html>