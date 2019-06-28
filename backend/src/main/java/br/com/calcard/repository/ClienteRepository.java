package br.com.calcard.repository;

import br.com.calcard.model.Cliente;
import br.com.calcard.repository.generic.GenericRepository;

public interface ClienteRepository extends GenericRepository<Cliente, Long> {
	
	Cliente findByCpf(String cpf);

}