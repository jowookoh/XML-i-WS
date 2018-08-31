livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', '$window', function ($scope,$state,$http,$window) {

    $scope.smestaj={};
    $scope.rezervacija={}
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
            alert("imas");
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
    $http.get('/api/smestaj/moj/3')
        .then(function(response) {
            $scope.smestaji=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });

    $scope.ucitajPristigle = function() {
        $http.get('/api/rezervacija/moje/3')
            .then(function(response) {
                $scope.rezervacije=response.data;
                $scope.result = "Success";
                $scope.content = response;
            }, function(response) {
                $scope.result = "Error";
                $scope.content = response;
            });
    }

    $scope.dodajSmestaj = function() {

    }
    $scope.potvrdiRezu=function (reza) {
        $http.put('/api/rezervacija/secured/izmeni', reza)
            .then(function(response) {
                $window.location.reload();
            });
    }
    $scope.postaviFejk = function() {
        $http.post('/api/rezervacija/fejk',$scope.rezervacija)
            .then(function(response) {
                $window.location.reload();
            }, function(response) {
                alert("moze ito");
            });
    }





}]);