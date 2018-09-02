livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {


    $scope.korisnik={};
    $scope.smestaj={};
    $scope.rezervacija={}
    $scope.novaPoruka={};
    $scope.izabraneUsluge = [];
    $scope.prikazSettings = {displayProp: 'naziv'};
    $scope.showDiv=true;

    //#region meseci


    $scope.m1={};
    $scope.m2={};
    $scope.m3={};
    $scope.m4={};
    $scope.m5={};
    $scope.m6={};
    $scope.m7={};
    $scope.m8={};
    $scope.m9={};
    $scope.m10={};
    $scope.m11={};
    $scope.m12={};

    //#endregion

    $('#modalLogin').modal('show');

    $scope.zaloguj = function() {

        $http.post("http://localhost:8082/login/login",$scope.korisnik)
            .then(function(response) {
                if(response.data){
                    $http.get('/api/korisnik/'+$scope.korisnik.kime)
                        .then(function(response) {
                            $scope.ja=response.data;
                            $scope.result = "Success";
                            $scope.content = response;
                            $http.get('/api/smestaj/moj/'+$scope.ja.id)
                                .then(function(response) {
                                    $scope.smestaji=response.data;
                                    $scope.result = "Success";
                                    $scope.content = response;
                                }, function(response) {
                                    $scope.result = "Error";
                                    $scope.content = response;
                                });
                        }, function(response) {
                            $scope.result = "Error";
                            $scope.content = response;
                        });
                    $('#modalLogin').modal('hide');

                }else{
                    alert("Neispravno korisničko ime ili lozinka");
                }

            }, function(response) {

            });

    }

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


    $scope.otvoriPoruke=function(reza){
        $scope.trenutnaReza=reza;
        $scope.showDiv=false;
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
        $scope.showDiv=true;
        $scope.novaPoruka.tekst='';
        $http.get('/api/rezervacija/moje/'+$scope.ja.id)
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
        $('#modalDodavanje').modal('hide');
    }


    $scope.potvrdiRezu=function (reza) {
        $http.put('/api/rezervacija/secured/izmeni', reza)
            .then(function(response) {
                $('#modalPotvrda').modal('hide');
            });
    }
    $scope.postaviFejk = function() {
        $http.post('/api/rezervacija/fejk',$scope.rezervacija)
            .then(function(response) {
                $('#modalZauzetost').modal('hide');
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
                $('#modalPoruke').modal('hide');
            });

    }

    $scope.ngMesecno = function(flag) {
        if (flag) {
            $scope.mesecno = false;
        } else {
            $scope.mesecno = true;
        }
    };



}]);