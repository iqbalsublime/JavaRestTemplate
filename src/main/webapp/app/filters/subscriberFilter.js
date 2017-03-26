
'use strict';

define(['app'], function (app) {

    var subscriberFilter = function () {

        return function (subscribers, filterValue) {
            if (!filterValue) return subscribers;
            var matches = [];
            filterValue = filterValue.toLowerCase();
            for (var i = 0; i < subscribers.length; i++) {
                var subscriber = subscribers[i];
                if ((subscriber.nID != undefined && subscriber.nID.toLowerCase().indexOf(filterValue) > -1) ||
                    (subscriber.nameEN != undefined && subscriber.nameEN.toLowerCase().indexOf(filterValue) > -1) ||
                    (subscriber.mSISDN != undefined && subscriber.mSISDN.toLowerCase().indexOf(filterValue) > -1) ||
                    (subscriber.status != undefined && subscriber.status.toLowerCase().indexOf(filterValue) > -1) ) {
                    matches.push(subscriber);
                }
            }
            return matches;
        };
    };

    app.filter('subscriberFilter', subscriberFilter);

});