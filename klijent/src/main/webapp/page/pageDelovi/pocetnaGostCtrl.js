livadeApp.controller('pocetnaGostCtrl', ['$scope','$http', function ($scope,$http) {

    $scope.pretraga={}
    $scope.napredna = false;
    $scope.ngNapredna = function(flag) {
        if (flag) {
            $scope.napredna = false;
        } else {
            $scope.napredna = true;
        }
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
}]);