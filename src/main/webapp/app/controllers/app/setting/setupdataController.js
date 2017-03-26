
'use strict';

define(['app'], function (app) {
	
	var setupdataController = function ($scope, $location, $filter, $log, setupdataService, constantService, 
		localStorageService, messageService) {
		
		var userInfo, promis;
		
    	var getListOfSetupItem = function() {
    		var obj = {operation:  constantService.GetAll };    		
    		promis = setupdataService.postObject(obj);
			promis.then(function (res) {
				if(!res.success){
					messageService.showMessage(constantService.Danger, res.code);
					return;
				}
				$scope.configureItems = $.parseJSON(res.data.valueJSON);
				console.log($scope.configureItems);
			});
		};
		
		$scope.updateSetupValue = function() {
			var jsonValue = angular.toJson($scope.configureItems);
		    var updateObj =	{ valueJSON : jsonValue, operation : constantService.Update };		    				  
		    promis = setupdataService.postObject(updateObj);
			promis.then(function (res) {
				if(!res.success){
					messageService.showMessage(constantService.Success, res.code);
					return;
				}
				
			});
		};
		
        var init = function () {
        	getListOfSetupItem();
        };
        
        init();
        
    };
    
    app.register.controller('setupdataController', ['$scope', '$location', '$filter', '$log', 'setupdataService',
    'constantService', 'localStorageService', 'messageService', setupdataController]);

});



