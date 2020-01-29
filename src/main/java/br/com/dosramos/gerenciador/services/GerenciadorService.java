package br.com.dosramos.gerenciador.services;

import java.util.List;

public interface GerenciadorService<T,S> {
	
	T findById(Long id);
	void removeById(Long id);
	
}
