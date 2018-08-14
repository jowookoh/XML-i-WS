livadeApp.controller('pocetnaGostCtrl', ['$scope','$http', function ($scope,$http) {
    $scope.title="vuko";

    /*$http.get("http://localhost:8080/tip/poz").success(function (data) {
        alert("ajaj");
        $scope.content = data;
    });*/
    /*$http.get("http://localhost:8080/tip/poz")
        .then(function(response) {
            $scope.content = response.data;
        }, function(response) {
            $scope.content = "Something went wrong";
        });*/
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