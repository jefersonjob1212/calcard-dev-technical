package br.com.calcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.exceptions.CampoVazioOuNuloException;
import br.com.calcard.model.Cliente;
import br.com.calcard.repository.ClienteRepository;
import br.com.calcard.service.ClienteService;
import br.com.calcard.service.generic.impl.GenericServiceImpl;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente, Long> implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public Cliente findByCpf(String cpf) throws CampoVazioOuNuloException {
		// TODO Auto-generated method stub
		return repository.findByCpf(cpf);
	}

}
