<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html ng-app="cartApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Checkout</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src='<c:url value="/resources/js/controllers.js" />'></script>
<link href="/resources/css/admin.css" rel="stylesheet">
</head>
<body ng-controller="cartController" ng-init="initCartId('${cartId}')">
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Checkout Page</h1>
				<c:choose>
					<c:when test="${emptycart}">
						<p>Cart is Empty</p>
					</c:when>
					<c:otherwise>
						<p>Rendering form to checkout...</p>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</section>

	<section class="flex-container">
		<div>
			<a href="/cart" class="btn btn-danger pull-left"> <span
				class="glyphicon glyphicon-remove-sign"></span> Go Back
			</a>
			<c:choose>
				<c:when test="${emptycart}">
					<a class="btn btn-success pull-right" disabled> <span
						class="glyphicon-shopping-cart glyphicon"></span> Check out
					</a>
				</c:when>
				<c:otherwise>

					<table class="table table-hover">
						<tr>
							<th>Product</th>
							<th>Quantity</th>
							<th>Unit price</th>
							<th>Price</th>
						</tr>
						<tr ng-repeat="item in cart.cartItems">
							<td>{{item.product.name}}</td>
							<td>{{item.quantity}}</td>
							<td>{{item.product.price}}</td>
							<td>{{item.totalPrice}}</td>
						</tr>
						<tr>
							<th></th>
							<th></th>
							<th>Grand Total</th>
							<th>{{cart.grandTotal}}</th>
							<th></th>
						</tr>

					</table>
					
					
						<form:form method="POST" modelAttribute="order" class="form-horizontal">
						<form:input type="hidden" path="id" id="id" />
						<form:input path="phone" id="phone" placeholder="Phone number"/><br>
						<form:input path="deliveryAdress" id="deliveryAdress" placeholder="Delivery adress"/><br>
						<form:input path="orderDetails" id="orderDetails" placeholder="Other Details"/><br>
						<form:input type="hidden" path="cart" id="cart" />
						<input type="submit" value="Deliver this to you!" class="btn btn-primary btn-sm"/> or <a href="<c:url value='/cart' />">Cancel</a>
					</form:form>
				</c:otherwise>
			</c:choose>
		</div>
	</section>

</body>
</html>