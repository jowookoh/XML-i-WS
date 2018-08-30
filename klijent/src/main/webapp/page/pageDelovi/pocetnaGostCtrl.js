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


    $scope.pretrazi = function () {
        alert("prvo");
        $http.post('/someUrl', data, config).then(successCallback, errorCallback);
    };

    /*$http.get("http://localhost:8080/tip/poz/")
        .then(function(response) {
            $scope.sara=response.data;
            $scope.result = "Success";
            $scope.content = response;
        }, function(response) {
            $scope.result = "Error";
            $scope.content = response;
        });*/
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
    });
}]);