app = angular.module('basketApp', ['ngRoute', 'chart.js'])

app.config(['$routeProvider', function ($routeProvider) {
    $routeProvider
        .when('/questions', {
            templateUrl: 'questions.html',
            controller: 'appCtrl'
        })
        .when('/result', {
            templateUrl: 'result.html',
            controller: 'appCtrl'
        })
        .otherwise({redirectTo: '/'});
}]);

app.controller('appCtrl', function ($scope, $http, $filter) {
    $scope.labelsChart = ['2006', '2007', '2008', '2009', '2010', '2011', '2012'];
    $scope.series = ['Series A', 'Series B'];

    $scope.dataChart = [
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90],
        [65, 59, 80, 81, 56, 55, 40],
        [28, 48, 40, 19, 86, 27, 90]
    ];


    $scope.gadget = []
    $scope.internet = []
    $scope.messenger = []
    $scope.messenger.id5 = []
    $scope.messenger.id6 = []
    $scope.gadget.id1 = []
    $scope.gadget.id2 = []
    $scope.gadget.id4 = []
    $scope.internet.id3 = []

    $scope.internet.id4 = []

    $scope.gadget.id1.typeComputer1 = false
    $scope.gadget.id1.typeComputer2 = false
    $scope.gadget.id1.typeComputer3 = false
    $scope.gadget.id1.typeComputer4 = false

    $scope.internet.id4.q1 = false
    $scope.internet.id4.q2 = false
    $scope.internet.id4.q3 = false
    $scope.internet.id4.q4 = false
    $scope.internet.id4.q5 = false
    $scope.internet.id4.q6 = false
    $scope.internet.id4.q7 = false

    $scope.gaming = []
    $scope.gaming.id4 = []
    $scope.gaming.id6 = []
    $scope.gaming.id9 = []
    $scope.gaming.id9.q1 = false
    $scope.gaming.id9.q2 = false
    $scope.gaming.id9.q3 = false
    $scope.gaming.id9.q4 = false
    $scope.gaming.id9.q5 = false
    $scope.gaming.id9.q6 = false

    $scope.fisiology = []
    $scope.fisiology.id2 = []
    $scope.fisiology.id3 = []

    $scope.fisiology.id2.q1 = false
    $scope.fisiology.id2.q2 = false
    $scope.fisiology.id2.q3 = false
    $scope.fisiology.id2.q4 = false
    $scope.fisiology.id2.q5 = false
    $scope.fisiology.id2.q6 = false
    $scope.fisiology.id2.q7 = false
    $scope.fisiology.id2.q8 = false

    $scope.fisiology.id3.q1 = false
    $scope.fisiology.id3.q2 = false
    $scope.fisiology.id3.q3 = false
    $scope.fisiology.id3.q4 = false
    $scope.fisiology.id3.q5 = false
    $scope.fisiology.id3.q6 = false
    $scope.fisiology.id3.q7 = false


    $scope.createOrder = function () {
        $scope.responses = [
            {
                "id": "1",
                "type": "gadjet",
                "value": [$scope.gadget.id1.typeComputer1,
                    $scope.gadget.id1.typeComputer2,
                    $scope.gadget.id1.typeComputer3
                    , $scope.gadget.id1.typeComputer4]
            }, {
                "id": "2",
                "type": "gadjet",
                "value": [$scope.gadget.id2.q1,
                    $scope.gadget.id2.q2,
                    $scope.gadget.id2.q3,
                    $scope.gadget.id2.q4,
                    $scope.gadget.id2.q5,
                    $scope.gadget.id2.q6]
            }, {
                "id": "3",
                "type": "gadjet",
                "value": $scope.gadget.id3
            }, {
                "id": "4",
                "type": "gadjet",
                "value": $scope.gadget.id4
            }, {
                "id": "5",
                "type": "gadjet",
                "value": $scope.gadget.id5
            }, {
                "id": "6",
                "type": "gadjet",
                "value": $scope.gadget.id6
            }, {
                "id": "7",
                "type": "gadjet",
                "value": $scope.gadget.id7
            }, {
                "id": "1",
                "type": "internet",
                "value": $scope.internet.id1
            }, {
                "id": "2",
                "type": "internet",
                "value": $scope.internet.id2
            }, {
                "id": "3",
                "type": "internet",
                "value": [$scope.internet.id3.q1,
                    $scope.internet.id3.q2,
                    $scope.internet.id3.q3,
                    $scope.internet.id3.q4,
                    $scope.internet.id3.q5,
                    $scope.internet.id3.q6]
            }, {
                "id": "4",
                "type": "internet",
                "value": [$scope.internet.id4.q1,
                    $scope.internet.id4.q2,
                    $scope.internet.id4.q3
                    , $scope.internet.id4.q4, $scope.internet.id4.q5, $scope.internet.id4.q6, $scope.internet.id4.q7]
            }, {
                "id": "1",
                "type": "messenger",
                "value": $scope.messenger.id1
            }, {
                "id": "2",
                "type": "messenger",
                "value": $scope.messenger.id2
            }, {
                "id": "3",
                "type": "messenger",
                "value": $scope.messenger.id3
            }, {
                "id": "4",
                "type": "messenger",
                "value": $scope.messenger.id4
            }, {
                "id": "5",
                "type": "messenger",
                "value": [$scope.messenger.id5.q1,
                    $scope.messenger.id5.q2,
                    $scope.messenger.id5.q3
                    , $scope.messenger.id5.q4]
            }, {
                "id": "1",
                "type": "gaming",
                "value": $scope.gaming.id1
            }, {
                "id": "2",
                "type": "gaming",
                "value": $scope.gaming.id2
            }, {
                "id": "3",
                "type": "gaming",
                "value": [$scope.gaming.id3.q1,
                    $scope.gaming.id3.q2,
                    $scope.gaming.id3.q3,
                    $scope.gaming.id3.q4,
                    $scope.gaming.id3.q5,
                    $scope.gaming.id3.q6]
            }, {
                "id": "4",
                "type": "gaming",
                "value": $scope.gaming.id4
            }, {
                "id": "5",
                "type": "gaming",
                "value": $scope.gaming.id5
            }, {
                "id": "6",
                "type": "gaming",
                "value": [$scope.gaming.id6.q1,
                    $scope.gaming.id6.q2,
                    $scope.gaming.id6.q3,
                    $scope.gaming.id6.q4]
            }, {
                "id": "7",
                "type": "gaming",
                "value": $scope.gaming.id7
            }, {
                "id": "8",
                "type": "gaming",
                "value": $scope.gaming.id8
            }, {
                "id": "9",
                "type": "gaming",
                "value": [$scope.gaming.id9.q1,
                    $scope.gaming.id9.q2,
                    $scope.gaming.id9.q3
                    , $scope.gaming.id9.q4, $scope.gaming.id9.q5, $scope.gaming.id9.q6]
            }, {
                "id": "1",
                "type": "fisiology",
                "value": $scope.fisiology.id1
            }, {
                "id": "2",
                "type": "fisiology",
                "value": [$scope.fisiology.id2.q1,
                    $scope.fisiology.id2.q2,
                    $scope.fisiology.id2.q3
                    , $scope.fisiology.id2.q4, $scope.fisiology.id2.q5, $scope.fisiology.id2.q6,
                    $scope.fisiology.id2.q7, $scope.fisiology.id2.q8]
            }, {
                "id": "3",
                "type": "fisiology",
                "value": [$scope.fisiology.id3.q1,
                    $scope.fisiology.id3.q2,
                    $scope.fisiology.id3.q3
                    , $scope.fisiology.id3.q4, $scope.fisiology.id3.q5, $scope.fisiology.id3.q6,
                    $scope.fisiology.id3.q7]
            }, {
                "id": "4",
                "type": "fisiology",
                "value": $scope.fisiology.id4
            }, {
                "id": "5",
                "type": "fisiology",
                "value": $scope.fisiology.id5
            }, {
                "id": "6",
                "type": "fisiology",
                "value": $scope.fisiology.id6
            }
        ];

        console.log($scope.responses)

        var questionCreate = {
            "name": $scope.name, "age": $scope.age,
            "sex": $scope.sex, "napravlenie": $scope.napravlenie,
            "category": $scope.category,
            "data": $scope.responses
        }
        $http.post('/question/create', questionCreate).then(function (response) {

            if (response.data)
                console.log("Post Data Submitted Successfully!")
            console.log(response.data)

        }, function (response) {
            $scope.errors = []
            $scope.errors.msg = "Service not Exists";
            $scope.errors.statusval = response.status;
            $scope.errors.statustext = response.statusText;
            $scope.errors.headers = response.headers();
            console.log($scope.errors)
        });
    }
});