package br.com.dosramos.gerenciador.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
public class Gerente_Departamento{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerente_departamento")
	private long idGerenteDepartamento;
	
	@ManyToOne
	@JoinColumn(name = "id_gerente")
	private Usuario gerente;

	@ManyToOne
	@JoinColumn(name = "id_departamento")
	private Departamento departamento;
		
	@NotBlank
	@Column(name = "data_modificacao")
	private LocalDateTime datetime;

	public long getIdGerenteDepartamento() {
		return idGerenteDepartamento;
	}

	public void setIdGerenteDepartamento(long idGerenteDepartamento) {
		this.idGerenteDepartamento = idGerenteDepartamento;
	}

	public Usuario getGerente() {
		return gerente;
	}

	public void setGerente(Usuario gerente) {
		this.gerente = gerente;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idGerenteDepartamento ^ (idGerenteDepartamento >>> 32));
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
		Gerente_Departamento other = (Gerente_Departamento) obj;
		if (idGerenteDepartamento != other.idGerenteDepartamento)
			return false;
		return true;
	}
	
}
