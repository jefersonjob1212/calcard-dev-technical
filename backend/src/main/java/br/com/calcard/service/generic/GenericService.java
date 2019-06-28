package br.com.calcard.service.generic;

import java.util.List;

public interface GenericService<T, ID> {

	T salvar(T entity);
	
	List<T> listaTodos();
	
	T buscarPorId(ID id);
}
