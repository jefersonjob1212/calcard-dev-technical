package br.com.calcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calcard.model.Analise;

public interface AnaliseRepository extends JpaRepository<Analise, Long> {

	Analise findByClienteCpf(String cpf);
}
