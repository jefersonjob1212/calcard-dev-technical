angular.module('app').factory('homeService', function($http, conf){
    listarTodos = function(){
        return $http.get(conf.uriApi, conf.headers);
    };

    listarPorCpf = function(cpf){
        return $http.get(`${conf.uriApi}/getPropostaCliente/${cpf}`, conf.headers);
    }

    return {
        listarTodos: listarTodos,
        buscarAnalisePorCpf: listarPorCpf
    }
});