livadeApp.controller('pocetnaGostCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.gost=true;
    $scope.rezervacija={};
    $scope.pretraga={};
    $scope.korisnik={};
    $scope.rega={};
    $scope.novaPoruka={};
    $scope.napredna = false;
    $scope.ngNapredna = function(flag) {
        $scope.nabaviStvari();
        if (flag) {
            $scope.napredna = false;
        } else {
            $scope.napredna = true;
        }
    };

    //$('#modalLogin').modal('show');

    $scope.zaloguj=function () {
        $scope.korisnik.tipKorisnika="klijent";
        $http.post("http://localhost:8080/korisnik/login/",$scope.korisnik)
            .then(function(response) {
                if (response.data){
                    $http.get("http://localhost:8080/korisnik/dajKorisnika/"+$scope.korisnik.kime)
                        .then(function(response) {
                            $scope.ja=response.data;
                            $scope.gost=false;
                            $('#modalLogin').modal('hide');
                        }, function(response) {
                        });
                }
                else{
                    alert("Neispravno korisničko ime ili lozinka");
                }
            }, function(response) {
                alert("error");
            });
    }

    $scope.pribaviReze=function () {
        $scope.showDiv=true;
        $scope.novaPoruka.tekst='';
        $http.get("http://localhost:8080/rezervacija/sveRezervacijeKorisnika/"+$scope.ja.kime)
            .then(function(response) {
                $scope.rezervacije=response.data;
                $scope.result = "Success";
                $scope.content = response;
            }, function(response) {
                $scope.result = "Error";
                $scope.content = response;
            });
    }

    $scope.otvoriPoruke=function(reza){
        $scope.trenutnaReza=reza;
        $scope.showDiv=false;
        $http.get("http://localhost:8080/poruka/porukeRezervacije/"+ reza.id)
            .then(function(response) {
                $scope.poruke=response.data;
                $scope.result = "Success";
                $scope.content = response;
            }, function(response) {
                alert("poruke lose");
                $scope.result = "Error";
                $scope.content = response;
            });
    }

    $scope.posaljiPoruku = function() {
        $scope.novaPoruka.idRezervacije=$scope.trenutnaReza.id;
        $scope.novaPoruka.posiljalac=$scope.ja.kime;
        $http.post("http://localhost:8080/poruka/nova", $scope.novaPoruka)
            .then(function(response) {
                $('#modalReze').modal('hide');
            }, function(response) {
                alert("nova lose");
                $scope.result = "Error";
                $scope.content = response;
            });

    }

    $scope.rezervisi=function (stigla) {
        $http.post("http://localhost:8080/smestaj/dajSmestaj",stigla)
            .then(function(response) {
                $scope.rezervacija.smestaj=response.data;
                $scope.rezervacija.klijent=$scope.ja;
                $scope.rezervacija.od=$scope.pretraga.prvi;
                $scope.rezervacija.paOndaDo=$scope.pretraga.drugi;
                $http.post("http://localhost:8080/rezervacija/rezervisiSmestaj",$scope.rezervacija)
                    .then(function(response) {
                        alert("uspešna rezervacija!");
                    }, function(response) {
                        alert("reza lose");
                    });
            }, function(response) {
                alert("sm lose");
            });

    }

    $scope.switchKrit = function(krit) {
        $scope.kriter = krit;
    }
    $scope.switchPretip = function(pret) {
        $scope.pretip = pret.naziv;
    }
    $scope.switchPrekat = function(prek) {
        $scope.prekat = prek.naziv;
    }

    $scope.ponistiTipove = function () {
        $scope.pretip ='';
    }
    $scope.ponistiKate = function () {
        $scope.prekat ='';
    }



    $scope.switchMod = function(us) {

    }



    $scope.pretrazi = function () {
        $http.post("http://localhost:8080/smestaj/trazi/",$scope.pretraga)
            .then(function(response) {
                $scope.stigle=response.data;
                /*$scope.slike=$scope.stigle.slike;
                $scope.tekUrl=$scope.slike[0];*/
            }, function(response) {

            });
    };

    $scope.showSlike=function (stig) {
        $scope.sliks=stig.slike;
    }
    $scope.odjaviSe=function () {
        $scope.gost=true;
        $scope.korisnik.kime='';
        $scope.korisnik.lozinka='';
    }

    $scope.zaregistruj=function () {
        $scope.rega.tipKorisnika="klijent";
        $http.post("http://localhost:8080/korisnik/register", $scope.rega)
            .then(function(response) {
                if(response.data){
                    $('#modalRegister').modal('hide');
                }else{
                    alert("Neuspešna registracija");
                }
                //alert("Uspešna registracija!")

            }, function(response) {
                alert("rega lose");
                $scope.result = "Error";
                $scope.content = response;
            });
    }

    $scope.nabaviStvari=function () {
        $http.get("http://localhost:8080/tipSmestaja")
            .then(function(response) {
                $scope.tips=response.data;
            }, function(response) {
            });
        $http.get("http://localhost:8080/kategorija")
            .then(function(response) {
                $scope.kats=response.data;
            }, function(response) {
            });
        $http.get("http://localhost:8080/usluga")
            .then(function(response) {
                $scope.usls=response.data;
            }, function(response) {
            });
    }

}]);