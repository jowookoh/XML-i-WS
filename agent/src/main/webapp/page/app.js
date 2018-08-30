var livadeApp= angular.module('livadeApp',['ui.router','angularjs-dropdown-multiselect'])

livadeApp.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
    $urlRouterProvider.otherwise('/login');
    $stateProvider
        .state('login',{
            url:'/login',
            controller: 'loginCtrl',
            templateUrl: 'pageDelovi/login.html'
        })
        .state('osnovna',{
            url:'/osnovna',
            controller: 'osnovnaCtrl',
            templateUrl: 'pageDelovi/osnovna.html'
        })

}])