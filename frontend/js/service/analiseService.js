var module = angular.module('app');

var uriApi = 'http://localhost:8080/proposta';

module.factory('analiseService', function($http, $q){
    sendToAnalyze = function(proposal) {
        var config = {
            headers: {
                'Content-Type': 'application/json'
            }
        }
        return $http.post(`${uriApi}/analisar`, proposal, config).then(function(response) {
            return response.data;
        }, function(err){
            return $q.reject(err);
        });
    }
    return sendToAnalyze;
});