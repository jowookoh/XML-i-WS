livadeApp.controller('pocetnaGostCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.pretraga={}
    $scope.napredna = false;
    $scope.ngNapredna = function(flag) {
        if (flag) {
            $scope.napredna = false;
        } else {
            $scope.napredna = true;
        }
    };

    $scope.toRegister = function() {
        $state.go("register");
    }
    $scope.toLogin = function() {
        $state.go("login");
    }
    $scope.toMojeRezervacije = function() {
        $state.go("mojeRezervacije");
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
            }, function(response) {

            });
    };

    /*$http.get("http://localhost:8080/tip/poz/")
        .then(function(response) {
            $scope.sara=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });
    $http({
        method: 'GET',
        url: "http://localhost:8080/tip/poz/"
    }).then(function successCallback(response) {
        // this callback will be called asynchronously
        // when the response is available
        $scope.sara=response.data;
    }, function errorCallback(response) {
        // called asynchronously if an error occurs
        // or server returns response with an error status.
    });*/
}]);