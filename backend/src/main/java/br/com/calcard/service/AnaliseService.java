package br.com.calcard.service;

import br.com.calcard.dto.AnaliseDTO;
import br.com.calcard.dto.ClienteDTO;

public interface AnaliseService {
	
	AnaliseDTO findByClienteCpf(String cpf);
	
	AnaliseDTO analisarCreditoCliente(ClienteDTO clienteDTO);
}
