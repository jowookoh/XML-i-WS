livadeApp.controller('loginCtrl', ['$scope','$state', function ($scope,$state) {
    $scope.korisnik={};

    $scope.toOsnovna = function() {

        $state.go("osnovna");
    }
}]);