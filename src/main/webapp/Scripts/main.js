
require.config({
    baseUrl: 'app',
    urlArgs: 'v=1.0'
});

require(
    [
        'app',
        'directives/ngEnter',
        'directives/decimalMask',
        'directives/integerMask',
        'directives/highChart',
        'directives/dateRange',
        'directives/myCalendar',
        'services/utils/routeResolver',
        'services/utils/constantService',
        'services/utils/configurationService',
        'services/utils/localStorageService',
        'services/utils/navigationService',
        'services/utils/authorizationService',
        'services/utils/languageService',
        'services/utils/menuService',
        'services/utils/loadService',
        'services/utils/alertService',
        'services/utils/dataService',
        'services/utils/modalService',
        'services/utils/confirmationService',
        'services/utils/messageService',
        'services/app/signInService',
        'services/app/wsClientService',
        'services/app/dashboardService',
        'services/app/userService',
        'services/app/roleService',
        'services/app/setupdataService',
        'services/app/subscriberService',
        'filters/partnerFilter',
        'filters/userFilter',
        'filters/subscriberFilter',
        'controllers/util/appHeaderController',
        'controllers/util/appLeftMenuController',
        'controllers/util/messageController'
    ],
function () {
    angular.bootstrap(document, ['mbmsApp']);
});

