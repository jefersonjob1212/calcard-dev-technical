package br.com.calcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.calcard.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByCpf(String cpf);

}