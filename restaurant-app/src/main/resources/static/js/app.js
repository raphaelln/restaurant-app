'use strict';

var restaurantApp = angular.module('restaurantApp',['ngRoute','ngResource','jcs-autoValidate','angular-ladda','mgcrea.ngStrap','ng-currency'])

restaurantApp.config(function($routeProvider,$httpProvider){
	
	
	$routeProvider.when('/restaurants', {
		 templateUrl:'partials/restaurant/restaurants.html',
		 ccontroller:'RestaurantListController'
	}).when('/restaurants/:id/view', {
		templateUrl : 'partials/restaurant/restaurant-view.html',
		controller : 'RestaurantViewController'
	}).when('/restaurants/new', {
		templateUrl : 'partials/restaurant/restaurant-add.html',
		controller : 'RestaurantCreateController'
	}).when('/restaurants/:id/edit', {
		templateUrl : 'partials/restaurant/restaurant-edit.html',
		controller : 'RestaurantEditController'
	}).when('/menus', {
		templateUrl:'partials/menu/menus.html',
		ccontroller:'MenuListController'
	}).when('/menus/:id/view', {
		templateUrl : 'partials/menu/menu-view.html',
		controller : 'MenuViewController'
	}).when('/menus/new', {
		templateUrl : 'partials/menu/menu-add.html',
		controller : 'MenuCreateController'
	}).when('/menus/:id/edit', {
		templateUrl : 'partials/menu/menu-edit.html',
		controller : 'MenuEditController'
	});
  
}).run(function($location){
   $location.path("/restaurants");
});