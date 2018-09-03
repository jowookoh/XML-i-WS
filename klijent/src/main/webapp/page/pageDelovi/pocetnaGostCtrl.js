livadeApp.controller('pocetnaGostCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.gost=true;
    $scope.rezervacija={};
    $scope.pretraga={};
    $scope.korisnik={};
    $scope.rega={};
    $scope.novaPoruka={};
    $scope.napredna = false;
    $scope.ngNapredna = function(flag) {
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
        $scope.pretip = pret;
    }
    $scope.switchPrekat = function(prek) {
        $scope.prekat = prek;
    }
    //#region checkboxovi

    var parkto= true;
    var vifito= true;
    var dorto= true;
    var poluto= true;
    var panto= true;
    var tvto= true;
    var kuhto= true;
    var kupto= true;


    $scope.switchMod1 = function() {
        if (parkto){$scope.mod1="parking"; parkto= !parkto; }
        else{ $scope.mod1=""; parkto= !parkto;}
    }
    $scope.switchMod2 = function() {
        if (vifito){$scope.mod2="wifi"; vifito= !vifito; }
        else{ $scope.mod2="";vifito= !vifito; }
    }
    $scope.switchMod3 = function() {
        if (dorto){$scope.mod3="dorucak"; dorto= !dorto; }
        else{ $scope.mod3=""; dorto= !dorto; }
    }
    $scope.switchMod4 = function() {
        if (poluto){$scope.mod4="polupanison"; poluto= !poluto; }
        else{ $scope.mod4="";  poluto= !poluto;}
    }
    $scope.switchMod5 = function() {
        if (panto){$scope.mod5="pansion"; panto= !panto; }
        else{ $scope.mod5=""; panto= !panto;}
    }
    $scope.switchMod6 = function() {
        if (tvto){$scope.mod6="tv"; tvto= !tvto; }
        else{ $scope.mod6=""; tvto= !tvto;}
    }
    $scope.switchMod7 = function() {
        if (kuhto){$scope.mod7="kuhinja"; kuhto= !kuhto; }
        else{ $scope.mod7=""; kuhto= !kuhto;}
    }
    $scope.switchMod8 = function() {
        if (kupto){$scope.mod8="privatno kupatilo"; kupto= !kupto; }
        else{ $scope.mod8="";  kupto= !kupto;}
    }
    //#endregion checkboxovi

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

}]);