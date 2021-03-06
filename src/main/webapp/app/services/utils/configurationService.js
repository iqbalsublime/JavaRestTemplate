
'use strict';

define(['app'], function (app) {

    var configurationService = function ($rootScope) {
    	
    	this.server = 'localhost';
        this.port = ':8080';
        this.appname = '/svca(1)/';
        
        // Local Host
        this.apprest = this.appname+'rest/';
        
        // Cloud Foundry
    	//this.apprest = '/rest/';
        
        this.rootUrl = 'http://' + this.server + this.port + this.appname;
        this.baseUrl = 'http://' + this.server + this.port + this.apprest;
    	this.wsBaseUrl = 'ws://' + this.server + this.port +this.appname;
		this.fileupload = this.apprest + 'fileupload/upload';
    	this.data = this.apprest + 'data/post';
    	this.role = this.apprest + 'role/post';
		this.dashboard = this.apprest + 'dashboard';
		this.login = this.apprest + 'security/useraccess';
		this.user = this.apprest + 'user/post';
		this.subscriber = this.apprest + 'subscriber/post';
		this.setupdata = this.apprest + 'setupdata/post';
		this.wsDashboard = this.wsBaseUrl + 'websocketservice';
    	
    };
    
    app.service('configurationService', ['$rootScope', configurationService]);

});


