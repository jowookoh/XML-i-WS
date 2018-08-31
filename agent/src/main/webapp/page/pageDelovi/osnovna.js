livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', '$window', function ($scope,$state,$http,$window) {

    $scope.smestaj={};
    $scope.rezervacija={}
    $scope.novaPoruka={};
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
    $http.get('/api/smestaj/moj/3')
        .then(function(response) {
            $scope.smestaji=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });
    $scope.otvoriPoruke=function(reza){
        $scope.trenutnaReza=reza;
        $http.get('/api/poruka/porukeRezervacije/'+ reza.id)
            .then(function(response) {
                $scope.poruke=response.data;
                $scope.result = "Success";
                $scope.content = response;
            }, function(response) {
                $scope.result = "Error";
                $scope.content = response;
            });
    }

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
    $http.get('/api/korisnik/3')
        .then(function(response) {
            $scope.ja=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });

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

    $scope.posaljiPoruku = function() {
        var redni=$scope.poruke.length+1;
        $scope.novaPoruka.rezervacija=$scope.trenutnaReza
        $scope.novaPoruka.posiljalac=$scope.ja;
        $scope.novaPoruka.poRedu=redni;
        $http.put('/api/poruka/nova', $scope.novaPoruka)
            .then(function(response) {
                $window.location.reload();
            });

    }




}]);