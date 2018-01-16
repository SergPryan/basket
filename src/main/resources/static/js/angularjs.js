app = angular.module('basketApp',['ngRoute'])

app.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/basket', {
            templateUrl: 'basket.html',
            controller: 'appCtrl'
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
    $http.get('/basket/all').then(function (response) {
        $scope.productsInBasket = response.data
    })
    $scope.addToBasket = function (index) {
        $http.post('/basket/add',$scope.products[index])
        $http.get('/basket/all').then(function (response) {
            $scope.productsInBasket = response.data
        })

    }
    $scope.deleteFromBasket = function (index) {
        var idElement = $scope.productsInBasket[index]['id']
        $http.delete('/basket/delete/'+idElement)
        $scope.productsInBasket.splice(index,1)

    }
    $scope.createOrder = function () {
        var data = { "fullName": $scope.fullName,
        "telephone":$scope.telephone
        }
        $http.post('/basket/create',data)
    }
});