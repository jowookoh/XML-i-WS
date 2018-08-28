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



    $http.get("http://localhost:8080/tip/poz/")
        .then(function(response) {
            $scope.sara=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });
}]);