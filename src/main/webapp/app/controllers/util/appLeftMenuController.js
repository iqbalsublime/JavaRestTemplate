
'use strict';

define(['app'], function (app) {
    
	 var appLeftMenuController = function ($rootScope, $scope, navigationService, configurationService, 
		localStorageService, constantService, authorizationService) {
		
		
		$scope.clickChildItem = function(childItem){
			$("#"+childItem.id).parent().find('li').each(function () {
			    $(this).removeClass('active');
			});
			$("#"+childItem.id).removeClass('active').addClass('active');
			navigationService.menuNavigation(childItem.url);
		};
		
		$scope.clickTopItem = function(item){
			var isActive = $("#"+item.id).hasClass('active');
			if(item.child.length > 0) {
				if (isActive) {
	                $("#"+item.id).removeClass('active');
	                $("#"+item.id).children('a').children("i.fa-angle-down").first().removeClass("fa-angle-down").addClass("fa-angle-left");
	                $("#"+item.id).children('ul.treeview-menu').slideUp("slow","swing");
	            } else {
	                $("#"+item.id).addClass('active');
	                $("#"+item.id).children('a').children("i.fa-angle-left").first().removeClass("fa-angle-left").addClass("fa-angle-down");
	                $("#"+item.id).children('ul.treeview-menu').slideDown("slow","swing");
	            }
			} else {
				angular.forEach($scope.menu, function(itm, index) {
					if(itm.child.length == 0) {
						$("#"+itm.id).removeClass('active');
					}
	            });
				$("#"+item.id).addClass('active');
				navigationService.menuNavigation(item.url);
			}
		};
		
		var init = function () {
			$scope.userInfo = authorizationService.getUserInfo();
        	$scope.menu = authorizationService.getMenu();
	    }; 
	    
	    
	    init();
		 
	 };    
	 
	 app.controller('appLeftMenuController', ['$rootScope', '$scope', 'navigationService', 'configurationService', 
     'localStorageService','constantService', 'authorizationService', appLeftMenuController]);
	
});

