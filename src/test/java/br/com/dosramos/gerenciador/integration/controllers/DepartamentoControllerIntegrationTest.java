package br.com.dosramos.gerenciador.integration.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.com.dosramos.gerenciador.controllers.DepartamentoController;
import br.com.dosramos.gerenciador.services.GerenciadorService;

@RunWith(SpringRunner.class)
@WebMvcTest(DepartamentoController.class)
public class DepartamentoControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	@Qualifier("departamentoService")
	private GerenciadorService gerenciadorService;
	
	@Test
	public void listAllDepartaments() {
		try {
			var a = mockMvc.perform(get("/api/departamentos/relacionamentos/")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
				    .andExpect(content().string(containsString("Desenvolvimento")));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	@Test
	public void findAllDepartamentoNomes() {
		try {
			mockMvc.perform(get("/api/departamentos/")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(content().string(not("id")));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
}
