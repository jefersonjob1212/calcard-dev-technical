package br.com.calcard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.dto.AnaliseDTO;
import br.com.calcard.dto.ClienteDTO;
import br.com.calcard.model.Mensagem;
import br.com.calcard.service.AnaliseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "proposta")
public class PropostaController {

	@Autowired
	private AnaliseService analiseService;
	
	@ApiOperation(
			value="Cadastrar um novo cliente e enviar proposta para análise",
			response=Mensagem.class,
			notes="Método que cadastra um cliente, realiza a análise e salva em um banco de Dados"
	)
	@ApiResponses(value = {
			@ApiResponse(
					code = 200,
					message = "Retorna uma mensagem de sucesso utilizando a classe Mensagem",
					response = Mensagem.class
			),
			@ApiResponse(
					code = 500,
					message = "Lança exceção do tipo Campo Vazio ou Nulo"
			)
	})	
	@PostMapping(path = "analisar", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody AnaliseDTO salvarAnalisar(@RequestBody ClienteDTO body) {
		return analiseService.analisarCreditoCliente(body);
	}
	
	@ApiOperation(
			value="Buscar proposta através de um CPF",
			response=Mensagem.class,
			notes="Método que retorna as informações da proposta do cliente pelo CPF"
	)
	@ApiResponses(value = {
			@ApiResponse(
					code = 200,
					message = "Retorna a proposta do Cliente",
					response = Mensagem.class
			),
			@ApiResponse(
					code = 500,
					message = "Lança exceção do sistema"
			)
	})
	@GetMapping(path = "getPropostaCliente/{cpf}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody AnaliseDTO getPropostaByClienteCpf(@PathVariable("cpf") String cpf) {
		return analiseService.findByClienteCpf(cpf);
	}
	
	@ApiOperation(
			value="Lista todas as análises feitas",
			response=Mensagem.class,
			notes="Método que retorna as informações da proposta do cliente pelo CPF"
	)
	@ApiResponses(value = {
			@ApiResponse(
					code = 200,
					message = "Retorna a listagem de propostas cadastradas",
					response = Mensagem.class
			),
			@ApiResponse(
					code = 500,
					message = "Lança exceção do sistema"
			)
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<AnaliseDTO> getPropostas() {
		return analiseService.findAll();
	}
}
