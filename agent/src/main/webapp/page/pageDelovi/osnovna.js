livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.tempLokacija={};
    $scope.korisnik={};
    $scope.smestaj={};
    $scope.rezervacija={};
    $scope.novaPoruka={};
    $scope.izabraneUsluge = [];
    $scope.prikazSettings = {displayProp: 'naziv'};
    $scope.showDiv=true;
    $scope.slike=[];

    //#region meseci

    $scope.meseci=[];

    $scope.m1={};
    $scope.m1.mesec="2016-01-10";
    $scope.m2={};
    $scope.m1.mesec="2016-02-10";
    $scope.m3={};
    $scope.m1.mesec="2016-03-10";
    $scope.m4={};
    $scope.m1.mesec="2016-04-10";
    $scope.m5={};
    $scope.m1.mesec="2016-05-10";
    $scope.m6={};
    $scope.m1.mesec="2016-06-10";
    $scope.m7={};
    $scope.m1.mesec="2016-07-10";
    $scope.m8={};
    $scope.m1.mesec="2016-08-10";
    $scope.m9={};
    $scope.m1.mesec="2016-09-10";
    $scope.m10={};
    $scope.m1.mesec="2016-10-10";
    $scope.m11={};
    $scope.m1.mesec="2016-11-10";
    $scope.m12={};
    $scope.m1.mesec="2016-12-10";

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
                            /*$http.get('/api/smestaj/moj/'+$scope.ja.id)
                                .then(function(response) {
                                    $scope.smestaji=response.data;
                                    $scope.result = "Success";
                                    $scope.content = response;
                                }, function(response) {
                                    $scope.result = "Error";
                                    $scope.content = response;
                                });*/
                        }, function(response) {
                            $scope.result = "Error";
                            $scope.content = response;
                        });
                    $('#modalLogin').modal('hide');

                }else{
                    alert("Neispravno korisničko ime ili lozinka");
                }

            }, function(response) {
                alert("eror");
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
    $scope.ucitajSmestaje = function() {
        $http.get('/api/smestaj/moj/' + $scope.ja.id)
            .then(function (response) {
                $scope.smestaji = response.data;
                $scope.result = "Success";
                $scope.content = response;
            }, function (response) {
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
                alert("reze lose");
                $scope.result = "Error";
                $scope.content = response;
            });
    }

    $scope.pripremiUsluge=function (dobiven) {
        $scope.smestajUsluge=[];
        $scope.tempSU={};
        $scope.izabraneUsluge.forEach(function (value) {
            $scope.tempSU.usluga=value;
            $scope.tempSU.usluga=dobiven;
            $scope.smestajUsluge.push($scope.tempSU);

        })
        return $scope.smestajUsluge;
    }

    $scope.dodajSmestaj = function() {
        //DODAVANJE LOKACIJE
        $http.put('/api/lokacija/nova', $scope.tempLokacija)
            .then(function(response) {
                $scope.smestaj.agent=$scope.ja;
                $scope.smestaj.lokacija=response.data;
                //DODAVANJE SMESTAJA
                $http.put('/api/smestaj/nov', $scope.smestaj)
                    .then(function(response) {
                        $scope.dobivenSmestaj=response.data;
                        //PRIPREMA USLUGA
                        $scope.pripremiUsluge( $scope.dobivenSmestaj)
                            .then(function(data) {
                                $scope.spremneUsluge = data;
                                //DODAVANJE USLUGA
                                $http.put('api/smestaj/uslugeSmestaja',$scope.spremneUsluge)
                                    .then(function (response) {
                                        // DODAVANJE CENA
                                        $scope.m1.smestaj=$scope.dobivenSmestaj;
                                        $scope.m2.smestaj=$scope.dobivenSmestaj;
                                        $scope.m3.smestaj=$scope.dobivenSmestaj;
                                        $scope.m4.smestaj=$scope.dobivenSmestaj;
                                        $scope.m5.smestaj=$scope.dobivenSmestaj;
                                        $scope.m6.smestaj=$scope.dobivenSmestaj;
                                        $scope.m7.smestaj=$scope.dobivenSmestaj;
                                        $scope.m8.smestaj=$scope.dobivenSmestaj;
                                        $scope.m9.smestaj=$scope.dobivenSmestaj;
                                        $scope.m10.smestaj=$scope.dobivenSmestaj;
                                        $scope.m11.smestaj=$scope.dobivenSmestaj;
                                        $scope.m12.smestaj=$scope.dobivenSmestaj;
                                        $scope.meseci.push($scope.m1);
                                        $scope.meseci.push($scope.m2);
                                        $scope.meseci.push($scope.m3);
                                        $scope.meseci.push($scope.m4);
                                        $scope.meseci.push($scope.m5);
                                        $scope.meseci.push($scope.m6);
                                        $scope.meseci.push($scope.m7);
                                        $scope.meseci.push($scope.m8);
                                        $scope.meseci.push($scope.m9);
                                        $scope.meseci.push($scope.m10);
                                        $scope.meseci.push($scope.m11);
                                        $scope.meseci.push($scope.m12);
                                        $http.put('/api/cena/nove', $scope.meseci)
                                            .then(function(response) {
                                                //DODAVANJE SLIKA
                                                $http.put('/api/slika/nove', $scope.slike)
                                                    .then(function(response) {
                                                        $('#modalDodavanje').modal('hide');
                                                    });
                                            });
                                        //$('#modalDodavanje').modal('hide');
                                    });
                            }, function(err) {
                                //error
                            });


                    });
            }, function(response) {
                alert("loka lose");
                $scope.result = "Error";
                $scope.content = response;
            });


    }

    $scope.dodajSliku=function (sl) {
        $scope.slike.push(sl);
        $scope.tempSlika='';

    }
    $scope.odjaviSe=function () {
        $('#modalLogin').modal('show');
        $scope.korisnik.kime='';
        $scope.korisnik.lozinka='';
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