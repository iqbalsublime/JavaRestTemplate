
'use strict';

define(['app'], function (app) {
    
    var testController = function ($scope, $location, $filter, $log, constantService, 
		localStorageService, messageService) {
        
    };
    
    
    app.register.controller('testController', ['$scope', '$location', '$filter', '$log',
    'constantService', 'localStorageService', 'messageService', testController]);

});


