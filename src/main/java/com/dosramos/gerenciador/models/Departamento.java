package com.dosramos.gerenciador.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

@Entity
public class Departamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_departamento")
	private long idDepartamento;
	
	@NotBlank(message =  "Insira um nome para o departamento")
	private String nome;
	
	@Column(name = "cod_departamento")
	private long codDepartamento;
	
	@OneToMany(mappedBy = "departamento")
	List<Usuario> usuarios;

	@OneToMany(mappedBy = "departamento")
	Set<Gerente_Departamento> gerenteDepartamento;
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public long getIdDepartamento() {
		return idDepartamento;
	}
	
	public void setIdDepartamento(long idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCodDepartamento() {
		return codDepartamento;
	}

	public void setCodDepartamento(long codDepartamento) {
		this.codDepartamento = codDepartamento;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idDepartamento ^ (idDepartamento >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamento other = (Departamento) obj;
		if (idDepartamento != other.idDepartamento)
			return false;
		return true;
	}
	
	
}
