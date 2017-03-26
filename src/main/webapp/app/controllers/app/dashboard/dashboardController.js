
'use strict';

define(['app'], function (app) {
    
	 var dashboardController = function ($rootScope, $scope, _, messageService, 
		 dashboardService, constantService, navigationService, localStorageService, 
		 configurationService,  ngProgress, loadService, $upload) {
		 
		
		 /*$scope.upload = function (files) {
    		if (files && files.length) {
    			for (var i = 0; i < files.length; i++) {
    				var file = files[i];
                    $upload.upload({
                    	url : configurationService.fileupload+"?folderName=student",
                        fields: {
                            'userName': 'Test'
                        },
                        file: file
                    }).progress(function (evt) {
                        var progressPercentage = parseInt(100.0 * evt.loaded / evt.total);
                        console.log('Progress: ' + progressPercentage + '% ' + evt.config.file.name);                    	
                    }).success(function (data, status, headers, config) {
                        if($scope.student != undefined){
                        	$scope.student.imagePath = data.data;
                        }
                    }).error(function (data, status, headers, config) {
                        if($scope.student != undefined){
                        	$scope.student.imagePath = '';
                        }
			        });;
                }
    		}
    	};*/
	    	
	    	
	 	var init = function () {
			 ngProgress.start();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('dashboardController', ['$rootScope', '$scope', '_', 'messageService', 'dashboardService', 
    'constantService', 'navigationService', 'localStorageService','configurationService', 'ngProgress', 'loadService', '$upload', 
    dashboardController]);
   
	
});

