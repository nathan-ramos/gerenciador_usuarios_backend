package br.com.dosramos.gerenciador.integration.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dosramos.gerenciador.models.Departamento;
import br.com.dosramos.gerenciador.repository.DepartamentoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DepartamentoRepositoryIntegrationTest {

	@Autowired
	private TestEntityManager manager;
	
	@Autowired
	private DepartamentoRepository repository;
	
	@Test
	public void buscaNomeDepartamentoPorCod() {
		
		Departamento d = new Departamento();
		d.setCodDepartamento(9999);
		d.setNome("RH");

		manager.persist(d);
		manager.flush();
		
		Departamento departamento = repository.findDepartamentoByCodDepartamento(9999);
		
		assertThat(departamento.getCodDepartamento()).isEqualTo(d.getCodDepartamento());
		
	}
	
	@Test
	public void buscaDepartamentoIDFromDepartamentoCod() {
		
		Departamento d = new Departamento();
		d.setCodDepartamento(9999);
		d.setNome("RH");

		manager.persist(d);
		manager.flush();		
		Departamento dept = repository.findDepartamentoIdByCodDepartamento(9999);
		
		assertThat(d.getIdDepartamento()).isEqualTo(dept.getIdDepartamento());
		System.err.println(dept.getIdDepartamento());
		
	}
	
}
