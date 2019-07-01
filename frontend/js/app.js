var app = angular.module('app', ['ngRoute', 'ngMask']);

app.config(function ($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'views/home.html',
            controller: 'HomeController'
        })
        .when('/cadastro', {
            templateUrl: 'views/cadastro.html',
            controller: 'AnaliseController'
        });
}).constant('conf', {
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    },
    uriApi: 'http://localhost:8080/proposta'
});