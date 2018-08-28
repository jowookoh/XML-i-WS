livadeApp.controller('osnovnaCtrl', ['$scope','$state','$http', function ($scope,$state,$http) {

    $scope.toOsnovna = function() {
        $state.go("osnovna");
    }

    $http.get('/api/kategorijasmestaja/secured/svi').success(function (data) {
        $scope.kategorije=data;
    })
    $http.get('/api/tipsmestaja/secured/svi').success(function (data) {
        $scope.tipovi=data;
    })
    $http.get('/api/usluga/secured/svi').success(function (data) {
        $scope.usluge=data;
    })

}]);