package br.com.calcard.service;

import java.util.List;

import br.com.calcard.dto.AnaliseDTO;
import br.com.calcard.dto.ClienteDTO;

public interface AnaliseService {
	
	AnaliseDTO findByClienteCpf(String cpf);
	
	List<AnaliseDTO> findAll();
	
	AnaliseDTO analisarCreditoCliente(ClienteDTO clienteDTO);
}
