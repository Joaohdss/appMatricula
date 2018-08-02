package com.appMatricula.appMatricula.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Alunos")
public class Aluno {
	
	@Id
	private Long matricula;
	private String nome;
	private String email;
	private int periodoInicial;
	private String senha;
	private ArrayList<String> disciplinasPreMatriculadas = new ArrayList<>();
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getPeriodoInicial() {
		return periodoInicial;
	}
	
	public void setPeriodoInicial(int periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	
	public String getEmail() {
		return email;
	}
	
	public ArrayList<String> getDisciplinasPreMatriculadas() {
		return disciplinasPreMatriculadas;
	}

	public void setDisciplinasPreMatriculadas(ArrayList<String> disciplinasPreMatriculadas) {
		this.disciplinasPreMatriculadas = disciplinasPreMatriculadas;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Long getMatricula() {
		return matricula;
	}
	
	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
