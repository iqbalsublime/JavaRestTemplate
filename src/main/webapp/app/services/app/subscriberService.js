
'use strict';

define(['app'], function (app) {

	var subscriberService = function ($rootScope, $resource, $q, constantService, configurationService, messageService) {
		
		var subscriberResource, delay;
	    
		subscriberResource = $resource(configurationService.subscriber, {}, {
			postObject: { method: 'POST' }
		});
		
        
        this.postObject = function (obj) {
            delay = $q.defer();
            subscriberResource.postObject(obj, function (data) {
                delay.resolve(data);
            }, function () {
                delay.reject('Unable to fetch..');
            });
            return delay.promise;
        };
		
	
    };
    
    app.service('subscriberService', ['$rootScope', '$resource', '$q', 'constantService', 'configurationService', 
    'messageService', subscriberService]);

});

