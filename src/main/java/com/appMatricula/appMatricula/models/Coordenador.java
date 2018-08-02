package com.appMatricula.appMatricula.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Coordenador")
public class Coordenador {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer idCoordenador;

	private String email;

	private String senha;
	
	public Integer getIdCoordenador() {
		return idCoordenador;
	}
	public void setIdCoordenador(Integer idCoordenador) {
		this.idCoordenador = idCoordenador;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
