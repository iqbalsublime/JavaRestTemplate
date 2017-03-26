
'use strict';

define(['app', 'services/utils/configurationService', 'services/utils/navigationService',
        'services/utils/languageService', 'services/utils/localStorageService', 'services/utils/constantService'], 
        function (app) {

    var authorizationService = function ($location, $rootScope, $route, $window, $http, $cookieStore,
    		configurationService, navigationService, languageService, localStorageService, constantService) {
    	
    	var userInfo;

        this.getUserInfo = function () {
        	userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
        	if(userInfo == undefined || userInfo == null){
        		return null;
        	}
        	var user = {};
        	user.loginID = userInfo.loginID;
        	user.roleID = userInfo.roleID;
        	user.roleDescription = userInfo.roleDescription;
        	user.name = userInfo.name;
        	user.imagePath = userInfo.imagePath;
        	user.status = userInfo.status;
        	user.sessionId = userInfo.sessionId;
            return user;
        };

        this.getMenu = function () {
        	userInfo = localStorageService.getValue(constantService.userInfoCookieStoreKey);
        	var menu = $.parseJSON(userInfo.menuJSON);
            return menu;
        };

        $rootScope.isLoggedIn = function () {
            return ($rootScope.loginInfo != null);
        };
            
       this.signOut = function () {
    		delete $http.defaults.headers.common['X-Auth-Token'];
            localStorageService.setValue(constantService.userInfoCookieStoreKey, null);
            $location.path('/');
        };
        
        this.authorizeLeftMenu = function (leftMenuId) {
        	var menuJson = localStorageService.getData(configurationService.loginMetaData).data.roleBean.menuJSON;
            for (var topMenuIndex = 0; topMenuIndex < menuJson.length; topMenuIndex++) {
                var leftMenuList = menuJson[topMenuIndex].leftmenuids;
                for (var leftMenuIndex = 0; leftMenuIndex < leftMenuList.length; leftMenuIndex++) {
                    if (leftMenuId == leftMenuList[leftMenuIndex]) {
                        return true;
                    }
                }
            }
            return false;
        };
        
    };
    
    app.service('authorizationService', ['$location', '$rootScope', '$route', '$window', '$http', '$cookieStore', 
          'configurationService', 'navigationService', 'languageService', 'localStorageService', 'constantService',
          authorizationService]);

});
