app = angular.module('resultApp', [])

app.controller('resultCtrl', function ($scope, $http, $filter) {
    $scope.persons = []
    $http.get('/question/result').then(function (response) {
        console.log(response)
        $scope.persons =response.data
    })
});