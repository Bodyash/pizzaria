<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="/resources/css/content.css" rel="stylesheet">
</head>
<body>
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
				<a class="btn btn-primary">Add to Cart (${drink.price} ₴)</a>
			</footer>
  		</article>
 		 </li>
	</c:forEach>
</ul>
</body>
</html>