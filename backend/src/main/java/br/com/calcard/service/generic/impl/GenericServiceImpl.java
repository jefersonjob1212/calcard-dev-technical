package br.com.calcard.service.generic.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.calcard.repository.generic.GenericRepository;
import br.com.calcard.service.generic.GenericService;

public class GenericServiceImpl<T, ID> implements GenericService<T, ID> {

	@Autowired
	private GenericRepository<T, ID> repository;
	
	@Override
	public T salvar(T entity) {
		// TODO Auto-generated method stub
		return repository.save(entity);
	}

	@Override
	public List<T> listaTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public T buscarPorId(ID id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}
	
	public GenericRepository<T, ID> getRepository() {
		return this.repository;
	}

}
