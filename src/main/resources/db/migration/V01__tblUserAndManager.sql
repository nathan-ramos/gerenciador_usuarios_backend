CREATE TABLE departamento(
	id_departamento BIGINT NOT NULL AUTO_INCREMENT,
	cod_departamento BIGINT NOT NULL,
	nome VARCHAR(30) NOT NULL,
	
	PRIMARY KEY (id_departamento)

)ENGINE=InnoDB;

CREATE TABLE usuario(
	id_usuario BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(15) NOT NULL,
	sobrenome VARCHAR(15),
	ultimo_sobrenome VARCHAR(15) NOT NULL,
	idade int NOT NULL,
	cargo VARCHAR(20) NOT NULL,
	gerente BOOLEAN NOT NULL,
	id_departamento BIGINT NOT NULL,
	
	PRIMARY KEY(id_usuario),
	CONSTRAINT FK_Usuario_IdDepartamento FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)
	
)ENGINE=InnoDB;

CREATE TABLE gerente_departamento(
	id_gerente_departamento BIGINT NOT NULL AUTO_INCREMENT,
	id_gerente BIGINT NOT NULL,
	id_departamento BIGINT NOT NULL,
	data_modificacao DATETIME NOT NULL,
	
	PRIMARY KEY(id_gerente_departamento),
	CONSTRAINT FK_Gerente_Usuario_IdGerente FOREIGN KEY (id_gerente) REFERENCES usuario(id_usuario),
	CONSTRAINT FK_Gerente_Usuario_IdDepartamento FOREIGN KEY (id_departamento) REFERENCES departamento(id_departamento)
	
)ENGINE=InnoDB;
