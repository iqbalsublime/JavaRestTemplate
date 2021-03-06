
'use strict';

define(['app'], function (app) {

    var constantService = function ($rootScope, $cookieStore) {
    	
        this.getAppLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/app/Header.html', isVisible: true },
                leftPanel: { location: 'app/views/layout/app/LeftPanel.html', isVisible: true},
            };
            return layout;
        };

        this.getWebLayout = function () {
            var layout = {
                header: { location: 'app/views/layout/web/Header.html', isVisible: false },
                leftPanel: { location: 'app/views/layout/web/LeftPanel.html', isVisible: false },
            };
            return layout;
        };
        
        this.getRandomInt = function (min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }
        
        this.userInfoCookieStoreKey = 'user.info.cookie.store.key';
        this.AlertMessage = 'AlertMessage';
        
        this.Login = 'Login';
        this.Logout = 'Logout';
        
        this.Active = 'A';
        this.Inactive = 'I';
        
        this.Save = 'Save';
        this.Update = 'Update';
        this.GetAll = 'GetAll';
        this.GetAllRole = 'GetAllRole';
        this.GetUserByLoginID = 'GetUserByLoginID';
        this.GetAllUser = 'GetAllUser';
        this.GetAllSubscriber = 'GetAllSubscriber';
        this.ChangePassword = 'ChangePassword';
        this.ResetPassword = 'ResetPassword';

        this.Danger = 'danger';
        this.Success = 'success';
        this.Info = 'info';
        this.Warning = 'warning';
        
        this.getPageItemText = function(pageDataBegin, pageDataEnd, pageDataTotal, recordTypeText, language) {
        	var pageItemText = "Showing "+pageDataBegin+
			" to "+pageDataEnd+
			" of "+pageDataTotal+
			" total "+recordTypeText+".";
			
			return pageItemText;       	
        };
    };
    
    app.service('constantService', ['$rootScope', '$cookieStore',  constantService]);

});
