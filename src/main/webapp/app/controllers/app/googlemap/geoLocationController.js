
'use strict';

define(['app'], function (app) {
	
	var geoLocationController = function ($rootScope, $scope, _, messageService, constantService, 
		navigationService, localStorageService, configurationService,  ngProgress, loadService, $interval,
		userService) {
		
		var userInfo, promis;
    	
    	$scope.map = {
			center: [23.85569800975124, 90.32958984375],
			zoom : 7,
			options: function() {
				return {
					streetViewControl: true,
					scrollwheel: true
				}
			},
			events: {
				click: function(e, map) {
			    }
			}
		};
    	
		var getAllUsers = function () {	
			ngProgress.start();		
			loadService.showDialog();
			var userObj = { operation : constantService.GetAllUser };
        	promis = userService.postObject(userObj);
            promis.then(function (data) {
   		        ngProgress.complete();
            	loadService.hideDialog();
    			if (!data.success) {
            		messageService.showMessage(constantService.Danger, data.code);
                    return;
                }

            	var coords = [];
            	angular.forEach(data.data, function(user, key) {
            		if(user.roleID == 'Retailer'){
                    	var lat = parseFloat(user.lat);
                    	var lng = parseFloat(user.lng);
                    	coords.push([lat, lng]);
            		}
            	});

        		$scope.points = {
        			coords: coords,
        		    options: function(coords, properties, i, map) {
        		    	return {
        		    		draggable: false
        		    	}
        		    },
        		    events: {
        		    	click: function(e, point, map, points) {
        		    	    $scope.$apply();
        		    	}
        		    },
        		    decimals: 4
        		};
            	
            });
        };
	    	
	 	var init = function () {
			 getAllUsers();
	 	};

	 	init();
	 	
	 	
	 };
	 
    app.register.controller('geoLocationController', ['$rootScope', '$scope', '_', 'messageService', 
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', 
    '$interval', 'userService', geoLocationController]);
   
	
});

