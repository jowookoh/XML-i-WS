livadeApp.controller('loginCtrl', ['$scope','$state', function ($scope,$state) {
    $scope.toOsnovna = function() {
        $state.go("osnovna");
    }
}]);