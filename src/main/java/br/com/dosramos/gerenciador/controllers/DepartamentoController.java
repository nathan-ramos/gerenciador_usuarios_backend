package br.com.dosramos.gerenciador.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dosramos.gerenciador.models.Departamento;
import br.com.dosramos.gerenciador.services.GerenciadorService;

@CrossOrigin
@RestController
@RequestMapping("/api/departamentos/")
public class DepartamentoController {

	@Autowired
	@Qualifier("departamentoService")
	private GerenciadorService<Departamento> gerenciadorService;
	
	@GetMapping("/relacionamentos")
	public List<Departamento> getAllDepartamentos(){
		return gerenciadorService.findAll();
	}
	@GetMapping
	public List<String> findAllNomesDepartamentos(){
		return gerenciadorService.findAllNomes();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamentoById(@PathVariable Long id){
		
		Departamento departamento = gerenciadorService.findById(id);
		
		if(departamento != null) {
			return ResponseEntity.ok(departamento);
		}
		else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
