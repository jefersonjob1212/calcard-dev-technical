package br.com.calcard.service;

import br.com.calcard.exceptions.CampoVazioOuNuloException;
import br.com.calcard.model.Cliente;
import br.com.calcard.service.generic.GenericService;

public interface ClienteService extends GenericService<Cliente, Long> {
	
	Cliente findByCpf(String cpf) throws CampoVazioOuNuloException;

}
