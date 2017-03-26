
'use strict';

define(['app'], function (app) {
	
	var appHeaderController = function ($rootScope, $scope, $window, authorizationService, constantService, signInService) {
		
		var userInfo, promis;
        
        $scope.menuToggle = function () {
        	if ($window.innerWidth <= 992) {
                $('.row-offcanvas').toggleClass('active', 500);
                $('.left-side').removeClass("collapse-left");
                $(".right-side").removeClass("strech");
                $('.row-offcanvas').toggleClass("relative", 500);
            } else {
                $(".right-side").toggleClass("strech", 500);
                $('.left-side').toggleClass("collapse-left", 500);
            }
        };
        
        $scope.userToggle = function () {
        	$("#userToggle").addClass('open', 500);
        	$("#userToggle").toggleClass('open', 500);
        };
        
		$scope.logout = function () {		
        	userInfo = authorizationService.getUserInfo();
        	userInfo.operation = constantService.Logout;
            promis = signInService.postObject(userInfo);
            promis.then(function (data) {
            	authorizationService.signOut();
            });
        };
        
        var init = function () {
        	$scope.userInfo = authorizationService.getUserInfo();      
	    }; 
	    
	    init();
       
		 
	};
    
	app.controller('appHeaderController', ['$rootScope', '$scope', '$window', 'authorizationService', 'constantService', 
    'signInService', appHeaderController]);
	
});














