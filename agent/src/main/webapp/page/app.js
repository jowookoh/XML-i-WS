var livadeApp= angular.module('livadeApp',['ui.router'])

livadeApp.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
    $urlRouterProvider.otherwise('/pocetnaGost');
    $stateProvider
        .state('pocetnaGost',{
            url:'/pocetnaGost',
            controller: 'pocetnaGostCtrl',
            templateUrl: 'pageDelovi/pocetnaGost.html'
        })

}])