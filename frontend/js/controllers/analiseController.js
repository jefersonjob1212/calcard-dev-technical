'use strict'

angular.module('app').controller('AnaliseController',
    function ($scope, $rootScope, analiseService, $http) {
        $scope.cliente = {};
        $scope.cliente.nome = "";
        $scope.cliente.nome = "";
        $scope.cliente.cpf = "";
        $scope.cliente.idade = 0;
        $scope.cliente.estado = "";
        $scope.cliente.dependentes = 0;
        $scope.cliente.estado_civil = "";
        $scope.cliente.sexo = "";
        $scope.cliente.renda = 0.00;

        $scope.analise = {}
        $scope.analise.limite = "";
        $scope.motivo = "";
        $scope.resultado = "";
        $scope.analise.cliente = [];

        $scope.analisarProposta = function () {
            analiseService.sendToAnalyze($scope.cliente).then(function (data) {
                $scope.analise = data;
            });
        }
    });