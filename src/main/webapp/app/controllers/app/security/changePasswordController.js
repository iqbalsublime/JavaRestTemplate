
'use strict';

define(['app'], function (app) {
	
	var changePasswordController = function ($rootScope, $scope, _, messageService,
		userService, constantService, authorizationService, localStorageService,
		configurationService, ngProgress, loadService, $upload) {
		
		var promis, userInfo;
		var userObj = { oldPassword : '', newPassword : '', confirmPassword : '' };
		
		$scope.changePassword = function (user) {
			if(!userService.validateChangePasswordForm(user)){
				return;
			}
			loadService.showDialog();
		    userInfo = authorizationService.getUserInfo();
		    user.loginBean = userInfo;
			user.operation = constantService.ChangePassword;
	    	promis = userService.postObject(user);
			promis.then(function (data) {
				loadService.hideDialog();
	    		if (!data.success) {
					messageService.showMessage(constantService.Danger, data.code);
					return;
				}
				messageService.showMessage(constantService.Success, data.code);
			});
		};
		 
		$scope.resetChangePassword = function () {
			$scope.user = angular.copy(userObj);
		};
		 
	 	var init = function () {
			 ngProgress.start();
		     ngProgress.complete();
	 	};

	 	init();
	 	
	 };
	 
    app.register.controller('changePasswordController', ['$rootScope', '$scope', '_', 'messageService', 'userService', 
    'constantService', 'authorizationService', 'localStorageService', 'configurationService', 'ngProgress', 'loadService', '$upload', 
    changePasswordController]);
   
	
});

