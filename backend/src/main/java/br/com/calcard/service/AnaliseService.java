package br.com.calcard.service;

import br.com.calcard.model.Analise;
import br.com.calcard.model.Cliente;
import br.com.calcard.service.generic.GenericService;

public interface AnaliseService extends GenericService<Analise, Long> {

	Analise retornaProposta(Cliente cliente);
}
