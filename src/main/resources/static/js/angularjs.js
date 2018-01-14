app = angular.module('basketApp',['ngRoute'])

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/commons', {
            templateUrl: 'commons.html',
            controller: 'basketCtrl'
        })
        .when('/list_product', {
            templateUrl: 'list_product.html',
            controller: 'appCtrl'
        })
        .otherwise({redirectTo:'/'});
}]);

app.controller('appCtrl',function ($scope,$http,$filter) {
    $http.get('/product/all').then(function (response) {
        $scope.products = response.data
    })
    $scope.addToBasket = function (index) {
        $http.post('/product/')
    }
});

app.controller('basketCtrl',function ($scope,$http,$filter) {

});