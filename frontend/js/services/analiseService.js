angular.module('app').factory('analiseService', function($http, conf){
    analisarProposta = function(proposta){
        return $http.post(`${conf.uriApi}/analisar`, proposta, conf.headers);
    }
    return {
        analisarProposta: analisarProposta
    }
});