package br.com.dosramos.gerenciador.services;

public interface GerenciadorService<T> {
	
	T findById(Long id);
	void removeById(Long id);
		
}
