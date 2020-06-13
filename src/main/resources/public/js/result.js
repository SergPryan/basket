app = angular.module('resultApp', [])

app.controller('resultCtrl', function ($scope, $http, $filter) {
    $scope.movies = [{title: "Avatar"}, {title: "Spectre"}, {title: "Teletubbies"}]
});