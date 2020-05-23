app = angular.module('basketApp', ['ngRoute'])

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/basket', {
            templateUrl: 'basket.html',
            controller: 'appCtrl'
        })
        .when('/questions', {
            templateUrl: 'questions.html',
            controller: 'appCtrl'
        })
        .otherwise({redirectTo: '/'});
}]);

app.controller('appCtrl', function ($scope, $http, $filter) {
    // $http.get('/product/all').then(function (response) {
    //     $scope.products = response.data
    // })
    // $http.get('/basket/all').then(function (response) {
    //     $scope.productsInBasket = response.data
    // })
    // $scope.addToBasket = function (index) {
    //     $http.post('/basket/add',$scope.products[index])
    //     $http.get('/basket/all').then(function (response) {
    //         $scope.productsInBasket = response.data
    //     })
    //
    // }
    // $scope.deleteFromBasket = function (index) {
    //     var idElement = $scope.productsInBasket[index]['id']
    //     $http.delete('/basket/delete/'+idElement)
    //     $scope.productsInBasket.splice(index,1)
    //
    // }
    $scope.gadget  = []
    $scope.internet  = []
    $scope.gadget.id1  = []
    $scope.gadget.id2  = []
    $scope.gadget.id4  = []

    $scope.internet.id4 = []

    $scope.gadget.id1.typeComputer1 = false
    $scope.gadget.id1.typeComputer2 = false
    $scope.gadget.id1.typeComputer3 = false
    $scope.gadget.id1.typeComputer4 = false

    $scope.internet.id4.boring1 = false
    $scope.internet.id4.boring2 = false
    $scope.internet.id4.boring3 = false
    $scope.internet.id4.boring4 = false
    $scope.internet.id4.boring5 = false
    $scope.internet.id4.boring6 = false
    $scope.internet.id4.boring7 = false


    $scope.createOrder = function () {
        $scope.responses = [
            {
                "id": "1",
                "value": [$scope.gadget.id1.typeComputer1,
                    $scope.gadget.id1.typeComputer2,
                    $scope.gadget.id1.typeComputer3
                ,$scope.gadget.id1.typeComputer4]
            },
            {
                "id": "2",
                "value": [$scope.gadget.id2.q1,
                    $scope.gadget.id2.q2,
                    $scope.gadget.id2.q3,
                    $scope.gadget.id2.q4,
                    $scope.gadget.id2.q5,
                    $scope.gadget.id2.q6,]
            },
            {
                "id": "3",
                "value": $scope.gadget.id3
            }
            ,
            {
                "id": "4",
                "value": $scope.gadget.id4
            }
            ,
            {
                "id": "5",
                "value": $scope.gadget.id5
            }
            ,
            {
                "id": "6",
                "value": $scope.gadget.id6
            }
            ,
            {
                "id": "7",
                "value": $scope.gadget.id7
            }
        ];

        console.log($scope)
        console.log($scope.gadget)

        var data = {"name": $scope.name, "age": $scope.age,
        "sex":$scope.sex,"napravlenie": $scope.napravlenie,
            "category": $scope.category,
            "data": $scope.responses
        }
        $http.post('/question/create', data)
    }
});