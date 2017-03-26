
'use strict';

define(['app'], function (app) {
	
	var signinController = function ($rootScope, $scope, signInService, navigationService, localStorageService, 
		configurationService, constantService, authorizationService, messageService) {
		
		var promis;
		$scope.login = { loginID : 'iqbal', password : 'secl2013', msg : 'Df1000' };
		
		
		$scope.signIn = function (login) {
        	if(!validateLoginForm()){
        		return;
        	}
        	var user = {};
        	user.loginID = login.loginID;
        	user.password = login.password;
        	user.operation = constantService.Login;
			promis = signInService.postObject(user);
			promis.then(function (data) {
				if (!data.success) {
					$scope.login.msg = data.code;
					return;
				}
				var menuJson = $.parseJSON(data.data.menuJSON);
				var userInfo = data.data;
				if(menuJson[0].child == undefined || menuJson[0].child == null || menuJson[0].child.length == 0){
					userInfo.selectedLeftMenu = menuJson[0].url;
				} else {
					userInfo.selectedLeftMenu = menuJson[0].child[0].url;
				}
				localStorageService.setValue(constantService.userInfoCookieStoreKey, userInfo);
				navigationService.menuNavigation(userInfo.selectedLeftMenu);
			});
		};
		
		$scope.$watch("login.loginID", function (filterText) {
			validateLoginForm();
        });
		
		$scope.$watch("login.password", function (filterText) {
			validateLoginForm();
        });
			
	 	var validateLoginForm = function () {
	 		var isValid = false;
	 		if($scope.login == undefined || $scope.login == null || 
	 				$scope.login.loginID == undefined || $scope.login.loginID == null || $scope.login.loginID.trim().length == 0){
	 			$scope.login.msg = 'Nl1001';
	 		} else if ($scope.login.password == undefined || $scope.login.password == null || $scope.login.password.trim().length == 0){
	 			$scope.login.msg = 'Nl1002';
	 		} else {
	 			$scope.login.msg = 'Df1000';
	 			isValid = true;
	 		}
	 		return isValid;
	 	};
			
	 	var init = function () {
	 		$(".right-side").addClass("strech");
            $('.left-side').addClass("collapse-left");
	 	};

	 	init();
		 
 	};

 	
    app.register.controller('signinController', ['$rootScope', '$scope', 'signInService', 'navigationService', 
    'localStorageService', 'configurationService','constantService', 'authorizationService', 'messageService', 
    signinController]);
   
	
});














