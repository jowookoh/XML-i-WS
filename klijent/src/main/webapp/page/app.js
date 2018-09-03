var livadeApp= angular.module('livadeApp',['ui.router'])

livadeApp.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
    $urlRouterProvider.otherwise('/pocetnaGost');
    $stateProvider
        .state('pocetnaGost',{
            url:'/pocetnaGost',
            controller: 'pocetnaGostCtrl',
            templateUrl: 'pageDelovi/pocetnaGost.html'
        })
        .state('register',{
            url:'/register',
            controller: 'registerCtrl',
            templateUrl: 'pageDelovi/register.html'
        })
        .state('mojeRezervacije',{
            url:'/mojeRezervacije',
            controller: 'mojeRezervacijeCtrl',
            templateUrl: 'pageDelovi/mojeRezervacije.html'
        })

}])