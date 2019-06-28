package br.com.calcard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.calcard.model.Analise;
import br.com.calcard.model.Cliente;
import br.com.calcard.repository.AnaliseRepository;
import br.com.calcard.service.AnaliseService;
import br.com.calcard.service.generic.impl.GenericServiceImpl;

@Service
public class AnaliseServiceImpl extends GenericServiceImpl<Analise, Long> implements AnaliseService {

	@Autowired
	private AnaliseRepository repository;
	
	@Override
	public Analise retornaProposta(Cliente cliente) {
		// TODO Auto-generated method stub
		return repository.findByClienteCpf(cliente.getCpf());
	}

}
