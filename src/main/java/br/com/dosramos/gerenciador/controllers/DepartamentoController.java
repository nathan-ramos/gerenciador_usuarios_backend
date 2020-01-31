package br.com.dosramos.gerenciador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dosramos.gerenciador.models.Departamento;
import br.com.dosramos.gerenciador.services.GerenciadorService;

@RestController
@RequestMapping("/api/departamentos/")
public class DepartamentoController {

	@Autowired
	@Qualifier("departamentoService")
	private GerenciadorService gerenciadorService;
	
	@GetMapping("/relacionamentos")
	public List<Departamento> getAllDepartamentos(){
		return gerenciadorService.findAll();
	}
	@GetMapping("/nomes/")
	public List<String> findAllNomesDepartamentos(){
		return gerenciadorService.findAllNomes();
	}
	
}
