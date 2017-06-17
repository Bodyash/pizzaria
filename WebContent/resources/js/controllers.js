var cartApp = angular.module('cartApp', []);
cartApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
}
]);
cartApp.controller('cartController', function($scope, $http){
	
			$scope.refreshCart = function(cartId){
				$http.get('/rest/cart/'+$scope.cartId)
				.success(function(data){
					$scope.cart = data;
				});
			};
			
			$scope.clearCart = function() {
				$http.delete('/rest/cart/'+$scope.cartId)
				 .success(function(data){
					 $scope.refreshCart($scope.cartId);
				 });
			};
				  
			$scope.initCartId = function(cartId) {
				$scope.cartId=cartId;
				$scope.refreshCart($scope.cartId);
			};
			
			$scope.addToCart = function(productId) {
				 $http.put('/rest/cart/add/'+productId)
				 .success(function(data) {
					$scope.refreshCart( $http.get ('/rest/cart/'+$scope.cartId));
					tempAlert("Product Successfully added to the Cart!", 2300);
				});
			 };
			 
			 $scope.removeFromCart = function(productId) {
				 $http.put('/rest/cart/remove/'+productId)
				 .success(function(data) {
					 $scope.refreshCart( $http.get('/rest/cart/cartId'));
				 });
			};
	
	});

function tempAlert(msg,duration)
{
 var el = document.createElement("div");
 el.setAttribute("style","position:absolute;top:40%;left:40%;background-color:white;padding:20px;");
 el.innerHTML = msg;
 setTimeout(function(){
  el.parentNode.removeChild(el);
 },duration);
 document.body.appendChild(el);
}