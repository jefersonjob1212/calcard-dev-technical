'use strict'

angular
    .module('app')
    .controller('HomeController', function($scope, homeService){

        $scope.cpfFilter = "";
        $scope.filterByCPF = false;
        $scope.showListaAnalise = false;

        $scope.buscaAnalises = function() {
            homeService.listarTodos().then(function(d){
                $scope.analise = {};
                $scope.analises = d.data;
                $scope.showListaAnalise = true;
            });
        };

        $scope.buscarAnalisePorCpf = function(cpf){
            homeService.buscarAnalisePorCpf(cpf).then(function(d) {
                $scope.analises = [];
                $scope.analise = d.data;
                $scope.showListaAnalise = false;
            });
        };
});