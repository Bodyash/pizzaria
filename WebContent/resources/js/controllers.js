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
				 .success($scope.refreshCart($scope.cartId));
			};
				  
			$scope.initCartId = function(cartId) {
				$scope.cartId=cartId;
				$scope.refreshCart($scope.cartId);
			};
			
			$scope.addToCart = function(productId) {
				 $http.put('/rest/cart/add/'+productId)
				 .success(function(data) {
					$scope.refreshCart( $http.get ('/rest/cart/'+$scope.cartId));
					alert("Product Successfully added to the Cart!");
				});
			 };
			 
			 $scope.removeFromCart = function(productId) {
				 $http.put('/rest/cart/remove/'+productId)
				 .success(function(data) {
					 $scope.refreshCart( $http.get('/rest/cart/cartId'));
				 });
			};
	
	});