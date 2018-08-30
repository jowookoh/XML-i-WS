livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.smestaj={};
    $scope.izabraneUsluge = [];
    $scope.prikazSettings = {displayProp: 'naziv'};


    $http.get('/api/kategorijasmestaja/secured/svi')
        .then(function(response) {
            $scope.kategorije=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });
    $http.get('/api/tipsmestaja/secured/svi')
        .then(function(response) {
            $scope.tipovi=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });
    $http.get('/api/usluga/secured/svi')
        .then(function(response) {
            $scope.usluge=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });

    $scope.dodajSmestaj = function() {
    }





}]);