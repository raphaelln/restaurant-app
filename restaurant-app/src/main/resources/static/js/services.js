'use strict';

restaurantApp.factory('Restaurant',function($resource){
    return $resource('http://localhost:8080/api/restaurant/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).factory('Menu',function($resource){
    return $resource('http://localhost:8080/api/menu/:id',{id:'@id'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});