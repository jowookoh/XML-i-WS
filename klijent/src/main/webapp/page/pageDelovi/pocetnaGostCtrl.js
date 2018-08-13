livadeApp.controller('pocetnaGostCtrl', ['$scope','$http', function ($scope,$http) {
    $scope.title="vuko";

    $http.get("http://localhost:8080/abc/runlist")
        .then(function(response) {
            $scope.content = response.data;
        }, function(response) {
            $scope.content = "Something went wrong";
        });
}]);