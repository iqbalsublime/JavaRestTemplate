
'use strict';

define(['app'], function (app) {

	var setupdataService = function ($rootScope, $resource, $q, configurationService) {
		
		var setupdataResource, delay, postObject;
	    
		setupdataResource = $resource(configurationService.setupdata, {}, {
			postObject: 		{ method: 'POST' }
		});
	    
		
		this.postObject = function (obj) {
            delay = $q.defer();
            setupdataResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
        
    };
    
    app.service('setupdataService', ['$rootScope', '$resource', '$q', 'configurationService', setupdataService]);

});

