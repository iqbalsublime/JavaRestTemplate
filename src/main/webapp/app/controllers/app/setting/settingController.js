
'use strict';

define(['app'], function (app) {
	
	var settingController = function ($scope, $location, $filter, $log, setupdataService, constantService, 
		localStorageService, messageService) {
		
		var userInfo, promis;
		
		var categories = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		                  'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    	var data = [
    	 {
            name: 'Tokyo',
            data: [7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6]
        }, 
        {
            name: 'New York',
            data: [-0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5]
        }, 
        {
            name: 'Berlin',
            data: [-0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0]
        },
        {
            name: 'London',
            data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8]
        }
        ];
    	
		var getColor = {
		    'AB': '#90ED7D',
		    'BC': '#7CB5EC',
		    'CL': '#F7A35C', 
		    'CI': '#ED561B', 
		    'HB': '#DDDF00', 
		    'ON': '#24CBE5', 
		    'PM': '#64E572', 
		    'SR': '#FF9655', 
		    'TS': '#FFF263', 
		    'IS': '#6AF9C4', 
		    'FREE': '#00FF00'
		};
		
		var getColumnChartConfig = function (categories,data) {
			
			return { 
				options: {
		            chart: {
		                type: 'column',
		                margin: 75,
		                options3d: {
		                    enabled: false,
		                    alpha: 10,
		                    beta: 25,
		                    depth: 70
		                }
		            },
		            title: {
		            	 text: 'Monthly Average Call',
		                 x: -20 //center
		            },
			        subtitle: {
			        	text: '',
			            x: -20
			        },
			        xAxis: {
			        	categories: categories,
			            title: {
			                text: ''
			            }
			        },
			        yAxis: {
			        	 title: {
			                 text: 'Min (Thousands)'
			             },
			             plotLines: [{
			                 value: 0,
			                 width: 1,
			                 color: '#808080'
			             }]
			        },
			        tooltip: {
			        	valueSuffix: 'Min'
			        },
			        legend: {
			        	 layout: 'vertical',
			             align: 'right',
			             verticalAlign: 'middle',
			             borderWidth: 0
			        }
				},
				series: data,
				loading: false
			}
		};
    	
    	var init = function () {
    		$scope.columnChartConfig = getColumnChartConfig(categories, data);
	 	};

	 	init();
		
		
		
        
    };
    
    app.register.controller('settingController', ['$scope', '$location', '$filter', '$log', 'setupdataService',
    'constantService', 'localStorageService', 'messageService', settingController]);

});



