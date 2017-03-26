
'use strict';

define(['app'], function (app) {
    
    var subscriberListController = function ($scope, $location, $filter, $log, constantService, 
		localStorageService, messageService, ngProgress, loadService, subscriberService) {
    	
    	var userInfo, promis;
    	
    	$scope.pageSize = 10;
        $scope.itemsPerPage = 5;
        $scope.currentPage = 1;
        
        $scope.pageDataBegin = 0;
        $scope.pageDataEnd = 0;
        $scope.pageDataTotal = 0;
        $scope.pageItemText = "";
        
        $scope.subscribers = [];
        $scope.filteredSubscribers = [];
        $scope.filteredTotalRecords = 0;
		
    	
    	var filterSubscribers = function (filterText) {
        	var result = $filter("subscriberFilter")($scope.subscribers, filterText);
        	
        	var begin = (($scope.currentPage - 1) * $scope.pageSize), end = begin + ($scope.pageSize - 0);
        	$scope.filteredSubscribers = result.slice(begin, end);
        	
        	$scope.filteredTotalRecords =  Math.ceil($scope.subscribers.length);
        	$scope.pageDataTotal = $scope.filteredTotalRecords;
        	if($scope.pageDataTotal == 0){
        		$scope.pageDataBegin = 0;
            	$scope.pageDataEnd = 0;        		    		
    		} else {
        		$scope.pageDataBegin = (($scope.currentPage - 1) * $scope.pageSize) + 1;
            	$scope.pageDataEnd = $scope.pageDataBegin + $scope.pageSize - 1;    		
    		}
        	
        	if($scope.pageDataTotal != 0 && $scope.pageDataEnd > $scope.pageDataTotal) {
        		$scope.pageDataEnd = $scope.pageDataTotal
        	}  
        	       	
    		$scope.pageItemText = constantService.getPageItemText($scope.pageDataBegin, $scope.pageDataEnd, 
					$scope.pageDataTotal, 'Subscribers', 'English');
        };

        $scope.numPages = function () {
        	return Math.ceil($scope.subscribers.length / $scope.pageSize);
        };
    	
    	var createWatches = function () {
        	
    		$scope.$watch("searchText", function (filterText) {
        		filterSubscribers(filterText);
            	$scope.currentPage = 1;
            });
            
            $scope.$watch('currentPage + pageSize', function() {
            	var begin = (($scope.currentPage - 1) * $scope.pageSize), end = begin + ($scope.pageSize - 0);
            	$scope.filteredSubscribers = $scope.subscribers.slice(begin, end);
            	$scope.pageDataTotal = $scope.filteredTotalRecords;
            	if($scope.pageDataTotal == 0) {
            		$scope.pageDataBegin = 0;
                	$scope.pageDataEnd = 0;        		    		
        		} else {
            		$scope.pageDataBegin = begin + 1;
                	$scope.pageDataEnd = end;
        		}
            	if($scope.pageDataTotal != 0 && $scope.pageDataEnd > $scope.pageDataTotal) {
            		$scope.pageDataEnd = $scope.pageDataTotal
            	}
        		$scope.pageItemText = constantService.getPageItemText($scope.pageDataBegin, $scope.pageDataEnd, 
						$scope.pageDataTotal, "Supplier", "English");
            });
        };
    	
		var getAllSubscriber = function () {	
			ngProgress.start();		
			loadService.showDialog();
			var subscriberObj = { operation : constantService.GetAllSubscriber};
        	promis = subscriberService.postObject(subscriberObj);
            promis.then(function (data) {
   		     	ngProgress.complete();
            	loadService.hideDialog();
    			if (!data.success) {
            		messageService.showMessage(constantService.Danger, data.code);
                    return;
                }
            	$scope.subscribers = data.data;
            	filterSubscribers('');
        		createWatches();
            });
        };
    	
    	var init = function () {
			 getAllSubscriber();
	 	};

	 	init();
        
    };
    
    
    app.register.controller('subscriberListController', ['$scope', '$location', '$filter', '$log',
    'constantService', 'localStorageService', 'messageService', 'ngProgress', 'loadService', 
    'subscriberService', subscriberListController]);

});


