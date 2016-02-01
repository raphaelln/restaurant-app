'use strict';

restaurantApp.controller('MenuListController',function($scope,$location,popupService,Menu,$modal,Restaurant){
	
    $scope.menus=Menu.query();
    $scope.showDeleteModal=function(menu) {
    	$scope.itemSelected=menu;
    	$scope.deleteModal= $modal({
    		scope: $scope,
    		templateUrl: 'templates/modal.delete.tpl.html',
    		show: true,
    		title: 'Delete Menu'
    	});
    	
    	$scope.deleteModal.$promise.then($scope.deleteModal.show);
    }

    $scope.deleteItem=function(menu){
    	
    	menu.$delete(function(){
    		$scope.itemSelected=null;
    		$scope.deleteModal.hide();
    		$scope.menus=Menu.query();
    	});
    }
    

}).controller('MenuViewController',function($scope,$routeParams,Menu){
    $scope.menu=Menu.get({id:$routeParams.id});

}).controller('MenuCreateController',function($scope,$location,$routeParams,Menu,Restaurant){
	
	$scope.restaurants=Restaurant.query();

    $scope.menu=new Menu();
    $scope.submitting=false;

    $scope.addMenu=function(){
    	$scope.submitting = true;
		$scope.menu.$save(function(){
			$scope.submitting = false;
			$location.path("/menus")
		});
    }
    
    
    $scope.removeItem = function(item) {
    	
    	$scope.menu.items.pop(item);
    }
    
    $scope.addItemRow = function() {
    	
    	if (!$scope.menu.items) {
    		$scope.menu.items = [];	
    	}
    	
    	$scope.menu.items.push({id:"",itemName:"", price:0.0, content:""});
    }

}).controller('MenuEditController',function($scope,$location,$routeParams,Menu,Restaurant){
	
	$scope.restaurants=Restaurant.query();

    $scope.updateMenu=function(){
        $scope.menu.$update(function(){
        	$location.path("/menus")
        });
    };

    $scope.loadMenu=function(){
        $scope.menu=Menu.get({id:$routeParams.id});
    };

    $scope.loadMenu();
});