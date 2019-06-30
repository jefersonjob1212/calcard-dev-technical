var app = angular.module('app', ['ngAnimate', 'ngRoute', 'ngResource']);

app.config(function($routeProvider) {
    $routeProvider
    .when('/', {
        templateUrl: 'views/home.html'
    })
    .when('/cadastro', {
        templateUrl: 'views/cadastro.html',
        controller: 'AnaliseController'
    });
});