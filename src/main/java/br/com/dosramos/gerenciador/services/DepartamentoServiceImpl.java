package br.com.dosramos.gerenciador.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.dosramos.gerenciador.models.Departamento;
import br.com.dosramos.gerenciador.repository.DepartamentoRepository;

@Service
@Qualifier("departamentoService")
public class DepartamentoServiceImpl implements GerenciadorService<Departamento>{

	@Autowired
	private DepartamentoRepository repository;
	
	@Override
	public Departamento findById(Long id) throws NoSuchElementException{
		
		return repository.findById(id).orElseThrow();
	}

	@Override
	public void removeById(Long id) {
		
		repository.deleteById(id);
	}

	public void save(Departamento entity) {
		repository.save(entity);
		
	}

	@Override
	public List<Departamento> findAll() {
		return repository.findAll();
	}

	@Override
	public List<String> findAllNomes() {
	return repository.findAllNomeByDepartamento();
	}
	
	
	

}
