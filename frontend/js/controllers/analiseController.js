'use strict'

angular.module('app').controller('AnaliseController',
    function ($scope, analiseService) {

        $scope.estadosList = [
            { key: 'AC', label: 'Acre' },
            { key: 'AL', label: 'Alagoas' },
            { key: 'AP', label: 'Amapá' },
            { key: 'AM', label: 'Amazonas' },
            { key: 'BA', label: 'Bahia' },
            { key: 'CE', label: 'Ceará' },
            { key: 'DF', label: 'Distrito Federal' },
            { key: 'ES', label: 'Espírito Santo' },
            { key: 'GO', label: 'Goiás' },
            { key: 'MA', label: 'Maranhão' },
            { key: 'MT', label: 'Mato Grosso' },
            { key: 'MS', label: 'Mato Grosso do Sul' },
            { key: 'MG', label: 'Minas Gerais' },
            { key: 'PA', label: 'Pará' },
            { key: 'PR', label: 'Paraná' },
            { key: 'PB', label: 'Paraíba' },
            { key: 'PE', label: 'Pernambuco' },
            { key: 'PI', label: 'Piauí' },
            { key: 'RJ', label: 'Rio de Janeiro' },
            { key: 'RN', label: 'Rio Grande do Norte' },
            { key: 'RS', label: 'Rio Grande do Sul' },
            { key: 'RO', label: 'Rondonia' },
            { key: 'RR', label: 'Roraima' },
            { key: 'SC', label: 'Santa Catarina' },
            { key: 'SP', label: 'São Paulo' },
            { key: 'SE', label: 'Sergipe' },
            { key: 'TO', label: 'Tocantins' }
        ];

        $scope.sexoList = [
            { key: 'MASCULINO', label: 'Masculino' },
            { key: 'FEMININO', label: 'Feminino' }
        ];

        $scope.estadoCivilList = [
            { key: 'SOLTEIRO', label: 'Solteiro(a)' },
            { key: 'CASADO', label: 'Casado(a)' },
            { key: 'DIVORCIADO', label: 'Divorciado(a)' },
            { key: 'VIUVO', label: 'Viúvo(a)' }
        ]

        $scope.cliente = {};

        $scope.analise = {}
        $scope.analise.limite = "";
        $scope.motivo = "";
        $scope.resultado = false;
        $scope.analise.cliente = [];

        $scope.showTable = false;



        $scope.analisarProposta = function (isValid) {

            if (isValid) {
                analiseService.analisarProposta($scope.cliente).then(function (response) {
                    $scope.showResult = true;
                    $scope.analise = response.data;
                });
            }
        }

        $scope.limparCliente = function () {
            $scope.cliente = {};
            $scope.analise = {};
            $scope.showResult = false;
        }
    });