package br.com.dosramos.gerenciador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.dosramos.gerenciador.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findDepartamentoByCodDepartamento(long cod);
	Departamento findDepartamentoIdByCodDepartamento(long cod);
	
	@Query("select d.nome from Departamento d")
	List<String> findAllNomeByDepartamento();
}
