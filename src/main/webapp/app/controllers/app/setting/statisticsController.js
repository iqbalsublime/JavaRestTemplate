
'use strict';

define(['app'], function (app) {
	
	var statisticsController = function ($scope, $location, $filter, $log, setupdataService, constantService, 
		localStorageService, messageService) {
		
		var userInfo, promis;
		
		var categories = ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun',
		                  'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'];
    	/*var data = [
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
        ];*/
    	
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
		
		var getColumnChartConfig = function (categories) {
			Highcharts.setOptions({
				global: {
	                useUTC: false
	            }
			});
			
			return { 
				options: {
					 chart: {
			                type: 'spline',
			                animation: Highcharts.svg, // don't animate in old IE
			                marginRight: 10,
			                events: {
			                    load: function () {

			                        // set up the updating of the chart each second
			                        var series = this.series[0];
			                        setInterval(function () {
			                            var x = (new Date()).getTime(), // current time
			                                y = Math.random();
			                            series.addPoint([x, y], true, true);
			                        }, 1000);
			                    }
			                }
			            },
		            title: {
		                text: 'Live random data'
		            },
		            xAxis: {
		                type: 'datetime',
		                tickPixelInterval: 150
		            },
		            yAxis: {
		                title: {
		                    text: 'Value'
		                },
		                plotLines: [{
		                    value: 0,
		                    width: 1,
		                    color: '#808080'
		                }]
		            },
		            tooltip: {
		                formatter: function () {
		                    return '<b>' + this.series.name + '</b><br/>' +
		                        Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
		                        Highcharts.numberFormat(this.y, 2);
		                }
		            },
		            legend: {
		                enabled: false
		            },
		            exporting: {
		                enabled: false
		            },
				},
				 series: [{
		                name: 'Random data',
		                data: (function () {
		                    // generate an array of random data
		                    var data = [],
		                        time = (new Date()).getTime(),
		                        i;

		                    for (i = -39; i <= 0; i += 1) {
		                        data.push({
		                            x: time + i * 1000,
		                            y: Math.random()
		                        });
		                    }
		                    return data;
		                }())
		            }],
				loading: false
			}
		};
    	
    	var init = function () {
    		$scope.columnChartConfig = getColumnChartConfig(categories);
	 	};

	 	init();
    };
    
    app.register.controller('statisticsController', ['$scope', '$location', '$filter', '$log', 'setupdataService',
    'constantService', 'localStorageService', 'messageService', statisticsController]);

});



