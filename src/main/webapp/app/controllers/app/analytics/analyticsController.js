
'use strict';

define([ 'app' ], function(app) {
	
	var analyticsController = function($scope, $location, $filter, $log, $modal, constantService, 
		localStorageService, confirmationService, messageService,navigationService,ngTableParams) {

		var promis, userInfo;
		$scope.exceptionLinks = [
			        	           {
			        	        	   "id" : "timesheetlog", 
			        	        	   "url" : "test",
			        	        	   "linkText" : "Registration Summary",
			        	        	   "description" : "Registration Summary by time, SR etc.",
			        	        	   "class" : ""
				        		   },
			        	           {
				        			   "id" : "employeestimesheetcalendar", 
			        	        	   "url" : "test",
				        			   "linkText" : "Verification Summary", 
				        			   "description" : "Verification Summary by time, SR etc.", 
				        			   "class" : "" 
			    				   },
			        	           {
			        				   "id" : "employeestimesheetcalendar",
			        	        	   "url" : "test",
			        				   "linkText" : "Multiple Registration List", 
			        				   "description" : "NIDS having multiple registrations", 
			        				   "class" : "" 
								   },
			        	           {
			        				   "id" : "revenuereport",
			        	        	   "url" : "test",
			        				   "linkText" : "Revenue Report", 
			        				   "description" : "Applicable charges payable, revenue receivable", 
			        				   "class" : "" 
								   }
		        	        ];
		
		$scope.analysticsLinks = [
	        	           {
	        	        	   "id" : "ratio", 
	        	        	   "url" : "ratio",
	        	        	   "linkText" : "Ratio",
	        	        	   "description" : "Time Series and dimensional analysis on registrations",
	        	        	   "class" : ""
		        		   },
	        	           {
		        			   "id" : "subscribers", 
	        	        	   "url" : "subscribers",
		        			   "linkText" : "Subscribers Analysis", 
		        			   "description" : "Time Series and dimensional on verifications", 
		        			   "class" : "" 
	    				   },
	    				   {
		        			   "id" : "auditlogreport", 
	        	        	   "url" : "test",
		        			   "linkText" : "Audit Log Report", 
		        			   "description" : "Analysis for Audit with log", 
		        			   "class" : "" 
	    				   },
	    				   {
		        			   "id" : "operatorwisecountregistrationreport", 
	        	        	   "url" : "test", 
		        			   "linkText" : "Operator wise NID Registration", 
		        			   "description" : "Operator wise NID Registration", 
		        			   "class" : "" 
	    				   }
        	        ];
		
		$scope.registrationLinks = [
	        	           {
	        	        	   "id" : "regsuccessreport", 
	        	        	   "url" : "test",
	        	        	   "linkText" : "Registration Success Analysis",
	        	        	   "description" : "Time Series and dimensional analysis on registrations",
	        	        	   "class" : ""
		        		   },
	        	           {
		        			   "id" : "employeestimesheetcalendar", 
	        	        	   "url" : "test",
		        			   "linkText" : "Verification Analysis", 
		        			   "description" : "Time Series and dimensional on verifications", 
		        			   "class" : "" 
	    				   }
        	        ];
		
		$scope.statisticalLinks = [
			        	           {
			        	        	   "id" : "regFrequencyreport", 
			        	        	   "url" : "test",
			        	        	   "linkText" : "Frequency Report",
			        	        	   "description" : "Average, 95th and 99th percentile analysis on latency",
			        	        	   "class" : ""
				        		   },
			        	           {
				        			   "id" : "testLink", 
			        	        	   "url" : "test",
				        			   "linkText" : "Frequency Report by Location", 
				        			   "description" : "Session concurrency report", 
				        			   "class" : "" 
			    				   },
			        	           {
			        				   "id" : "employeestimesheetcalendar",
			        	        	   "url" : "test",
			        				   "linkText" : "Throughput report", 
			        				   "description" : "Overall system throughput report", 
			        				   "class" : "" 
								   },
			        	           {
			        				   "id" : "employeestimesheetcalendar",
			        	        	   "url" : "test",
			        				   "linkText" : "System Node report", 
			        				   "description" : "Report on Application node performance", 
			        				   "class" : "" 
								   }
		        	        ];
		
		$scope.miscellaneousLinks = [
			        	           {
			        	        	   "id" : "regfailurereport", 
			        	        	   "url" : "test",
			        	        	   "linkText" : "Registration Failure Analysis",
			        	        	   "description" : "Dimensional analysis on Registration Failure",
			        	        	   "class" : ""
				        		   },
			        	           {
				        			   "id" : "employeestimesheetcalendar", 
			        	        	   "url" : "test",
				        			   "linkText" : "Verification Failure Analysis", 
				        			   "description" : "Dimensional analysis on Verification Failure", 
				        			   "class" : "" 
			    				   },
			        	           {
			        				   "id" : "employeestimesheetcalendar",
			        	        	   "url" : "test",
			        				   "linkText" : "System Fault Report", 
			        				   "description" : "Report on System Fault like fault events, downtime", 
			        				   "class" : "" 
								   }
		        	        ];
		
		$scope.performClickAction = function(menuId){			
			navigationService.menuNavigation(menuId);
		};
		
		var init = function(){
           	$log.info('Timesheetanalytics Controller Active');
		};
		
		init();
	};
	app.register.controller('analyticsController', [ '$scope', '$location', '$filter', '$log', '$modal',
    'constantService', 'localStorageService', 'confirmationService', 'messageService','navigationService',
    'ngTableParams', analyticsController ]);

	
	 	
});
