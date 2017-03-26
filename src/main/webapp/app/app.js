
'use strict';

define(['services/utils/routeResolver'], function () {

	var app = angular.module('mbmsApp', ['localization', 'ngRoute', 'ngAnimate', 'ngResource', 
      'ngCookies', 'ui.bootstrap', 'ui', 'ui.select2', 'highcharts-ng', 'ngTable', 'routeResolverServices', 
      'underscore', 'ngProgress', 'ui.bootstrap.transition', 'angularFileUpload', 'ngMaps', 'ngBootstrap']);

	app.run(['$rootScope', '$route', '$http', '$location', 'constantService', 'localize', 'authorizationService',
	         function ($rootScope, $route, $http, $location, constantService, localize, authorizationService) {
	
		var userInfo;
		$rootScope.messagePageLocation = 'app/partials/message.html';
		localize.setLanguage('en-US');
		
		$rootScope.$on("$routeChangeStart", function (oldPath, newPath) {
			$rootScope.isWeb = true;
			if (newPath.$$route == undefined || newPath.$$route.isWeb) {
	        	$rootScope.layout = constantService.getWebLayout();
	            return;
	        } 
	        userInfo = authorizationService.getUserInfo();
	        if(userInfo === undefined || userInfo === null){
	            $rootScope.layout = constantService.getWebLayout();
	            $location.path('/');
	            return;
	        }
	        $rootScope.isWeb = false;
	        $rootScope.layout = constantService.getAppLayout();
	    });
    
	}]); 

	app.config(['$routeProvider','routeResolverProvider','$controllerProvider', '$compileProvider', 
	            '$filterProvider', '$provide', '$locationProvider', '$httpProvider',  
	         function ($routeProvider,routeResolverProvider, $controllerProvider, $compileProvider, 
	        	$filterProvider, $provide, $locationProvider, $httpProvider) {
    
		app.register = {
	        controller: $controllerProvider.register,
	        //directive: $compileProvider.directive,
	        filter: $filterProvider.register,
	        //factory: $provide.factory,
	        //service: $provide.service
	    };
		
		// Provider-based service.
        app.service = function( name, constructor ) {
            $provide.service( name, constructor );
            return( this );
        };
        
        // Provider-based factory.
        app.factory = function( name, factory ) {
            $provide.factory( name, factory );
            return( this );
        };
        
        // Provider-based directive.
        app.directive = function( name, factory ) {
            $compileProvider.directive( name, factory );
            return( this );
        };
     
		var route = routeResolverProvider.route;
		$routeProvider
		//page and controller name prefix, dir path, title, isWeb
		.when('/', 									route.resolve('signin', 					'app/security/', 		'Signin', 			true))
        .when('/dashboard', 						route.resolve('dashboard', 					'app/dashboard/', 		'Dashboard', 		false))
        .when('/analytics', 						route.resolve('analytics', 					'app/analytics/', 		'Analytics', 		false))
        .when('/ratio', 							route.resolve('ratio', 						'app/analytics/', 		'Ratio', 			false))
        .when('/subscribers', 						route.resolve('subscriberList', 			'app/analytics/', 		'subscribers', 		false))
        .when('/setupdata', 						route.resolve('setupdata', 					'app/setting/', 		'Setup', 			false))
		.when('/geolocation', 						route.resolve('geoLocation', 				'app/googlemap/', 		'Google Map', 		false))
        .when('/test', 								route.resolve('test', 						'app/', 				'Test', 			false))
        .when('/user', 								route.resolve('user', 						'app/security/', 		'User', 			false))
        .when('/user/:loginID', 					route.resolve('user', 						'app/security/', 		'User', 			false))
        .when('/users', 							route.resolve('userList', 					'app/security/', 		'List of User', 	false))
        .when('/changepassword', 					route.resolve('changePassword', 			'app/security/', 		'Change Password', 	false))
        .when('/setting', 							route.resolve('setting', 					'app/setting/', 		'Settings', 		false))
        .when('/geolocation', 						route.resolve('geoLocation', 				'app/googlemap/', 		'Google Map', 		false))
        .when('/statistics', 						route.resolve('statistics', 				'app/setting/', 		'Statistics', 		false))
        .when('/pie', 								route.resolve('pie', 						'app/setting/', 		'Pie', 				false))
        .when('/addemployee', 						route.resolve('addemployee', 				'app/people/', 			'Employee', 		false))
        .when('/employees', 						route.resolve('employees', 					'app/people/', 			'Employees', 		false))
        .otherwise({ redirectTo: '/' });
		
	}]);

	return app;

});

    