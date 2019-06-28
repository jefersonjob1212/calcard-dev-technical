package br.com.calcard.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.calcard.dto.ClienteDTO;
import br.com.calcard.model.Cliente;
import br.com.calcard.model.Mensagem;
import br.com.calcard.service.AnaliseService;
import br.com.calcard.service.ClienteService;

@RestController
@CrossOrigin(value = "*")
@RequestMapping(value = "cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AnaliseService analiseService;
	
	private ModelMapper mapper;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Mensagem salvarCliente(@RequestBody ClienteDTO body) {
		mapper = new ModelMapper();

		clienteService.salvar(mapper.map(body, Cliente.class));
		return new Mensagem("Cliente cadastrado com sucesso");
	}
}
