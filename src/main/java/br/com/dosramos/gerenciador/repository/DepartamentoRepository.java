package br.com.dosramos.gerenciador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.dosramos.gerenciador.models.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>{

	Departamento findDepartamentoByCodDepartamento(long cod);
	Departamento findDepartamentoIdByCodDepartamento(long cod);
}
