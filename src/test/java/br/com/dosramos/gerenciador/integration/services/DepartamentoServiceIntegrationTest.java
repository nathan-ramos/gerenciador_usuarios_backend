package br.com.dosramos.gerenciador.integration.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.dosramos.gerenciador.models.Departamento;
import br.com.dosramos.gerenciador.services.DepartamentoServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartamentoServiceIntegrationTest {

	@Autowired
	private DepartamentoServiceImpl departamentoServiceImpl;
	
	@Test
	public void findDepartamentoById() {
		Departamento departamento = departamentoServiceImpl.findById(1L);
		
		System.err.println(departamento.getNome());
		
		assertThat(departamento.getIdDepartamento()).isEqualTo(1L);
		
	}
	
}
