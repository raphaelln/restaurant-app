'use strict';

restaurantApp.controller('RestaurantListController',function($scope,$location,popupService,Restaurant,$modal){

    $scope.restaurants=Restaurant.query();
    
    $scope.showDeleteModal=function(restaurant) {
    	$scope.itemSelected=restaurant;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete Restaurant'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(restaurant){
    	restaurant.$delete(function(){
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.restaurants=Restaurant.query();
    	});
    }
    

}).controller('RestaurantViewController',function($scope,$routeParams,Restaurant){
    $scope.restaurant=Restaurant.get({id:$routeParams.id});

}).controller('RestaurantCreateController',function($scope,$location,$routeParams,Restaurant){

    $scope.restaurant=new Restaurant();
    $scope.submitting=false;

    $scope.addRestaurant=function(){
    	$scope.submitting = true;
		$scope.restaurant.$save(function(){
			$scope.submitting = false;
			$location.path("/restaurants")
		});
    }

}).controller('RestaurantEditController',function($scope,$location,$routeParams,Restaurant){

    $scope.updateRestaurant=function(){
        $scope.restaurant.$update(function(){
        	$location.path("/restaurants")
        });
    };

    $scope.loadRestaurant=function(){
        $scope.restaurant=Restaurant.get({id:$routeParams.id});
    };

    $scope.loadRestaurant();
});