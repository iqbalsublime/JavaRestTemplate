
'use strict';

define(['app'], function (app) {
    
    var ratioController = function ($scope, $location, $filter, $log, constantService, 
		localStorageService, messageService) {
    	
    	var categories = ['Apples', 'Oranges', 'Pears', 'Grapes', 'Bananas'];
    	var data = [{
            name: 'John',
            data: [5, 3, 4, 7, 2]
        }, {
            name: 'Jane',
            data: [2, 2, 3, 2, 1]
        }, {
            name: 'Joe',
            data: [3, 4, 4, 2, 5]
        }];
    	
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
			Highcharts.setOptions({
				lang: {
					thousandsSep: ','
				}
			});
			
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
		            	text: 'Stacked column chart'
		            },
			        subtitle: {
			        	text: ''
			        },
			        xAxis: {
			        	categories: categories,
			            title: {
			                text: ''
			            }
			        },
			        yAxis: {
			            min: 0,
			            title: {
			            	text: 'Total fruit consumption',
			                align: 'high'
			            },
			            labels: {
			                overflow: 'justify'
			            },
			            stackLabels: {
			                enabled: true,
			                style: {
			                    fontWeight: 'bold',
			                    color: (Highcharts.theme && Highcharts.theme.textColor) || 'gray'
			                }
			            }
			        },
			        tooltip: {
			            formatter: function () {
			                return '<b>' + this.x + '</b><br/>' +
			                    this.series.name + ': ' + this.y + '<br/>' +
			                    'Total: ' + this.point.stackTotal;
			            }
			        },
			        legend: {
			            layout: 'vertical',
			            align: 'right',
			            x: -30,
			            y: 25,
			            verticalAlign: 'top',
			            floating: true,
			            backgroundColor: (Highcharts.theme && Highcharts.theme.background2) || 'white',
			            borderColor: '#CCC',
			            borderWidth: 1,
			            shadow: false
			        },
			        plotOptions: {
			            column: {
			            	stacking: 'normal',
			            	dataLabels: {
			                    enabled: true,
			                    color: (Highcharts.theme && Highcharts.theme.dataLabelsColor) || 'white',
			                    style: {
			                        textShadow: '0 0 3px black'
			                    }
			                },
			            	pointPadding: 0.2,
			                borderWidth: 0,
			                depth: 25
			            }
			        },
			        credits: {
			            enabled: false
			        },
			        exporting : {
			        	enabled : false
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
    
    
    app.register.controller('ratioController', ['$scope', '$location', '$filter', '$log',
    'constantService', 'localStorageService', 'messageService', ratioController]);

});


