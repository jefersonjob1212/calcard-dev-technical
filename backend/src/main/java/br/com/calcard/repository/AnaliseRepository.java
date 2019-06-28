package br.com.calcard.repository;

import br.com.calcard.model.Analise;
import br.com.calcard.repository.generic.GenericRepository;

public interface AnaliseRepository extends GenericRepository<Analise, Long> {

	Analise findByClienteCpf(String cpf);
}
