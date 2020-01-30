package br.com.dosramos.gerenciador;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import br.com.dosramos.gerenciador.services.DepartamentoServiceImpl;

@SpringBootTest
@TestConfiguration
class GerenciadorUsuariosApplicationTests {

	@Bean
	public DepartamentoServiceImpl departamentoServicer() {
		System.err.println("Instanciando DepartamentoServiceImpl");
		return new DepartamentoServiceImpl();
	}
	
	@Test
	void contextLoads() {
	}

}
