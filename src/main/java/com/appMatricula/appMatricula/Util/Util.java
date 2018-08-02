package com.appMatricula.appMatricula.Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;


@Service
public class Util {
	
	public boolean validaEmail(String email) {
		boolean status = false;
		
		String strPadrao = "[a-zA-Z]+[a-zA-Z.]*+@ccc.ufcg.edu.br";
		Pattern pattern = Pattern.compile(strPadrao);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) 
			status = true;
		return status;
	}
	
	
	public boolean validaNomeAluno(String nome) {
		boolean status = false;
		
		String strPadrao = "[0-9]";
		Pattern pattern = Pattern.compile(strPadrao);
		Matcher matcher = pattern.matcher(nome);
		
		if (!matcher.find() && nome.length() > 2) 
			status = true;
		return status;
	}
	
	public boolean validaSenha(String senha) {
		boolean status = true;
		
		if (senha.length() < 6) 
			status = false;
		return status;
	}
	public boolean verificaSenha(String senhaUsuario, String senhaInformada) {
		boolean status = false;
		String senhaUsuarioDes = criptografar(senhaInformada);
		if (senhaUsuario.equalsIgnoreCase(senhaUsuarioDes))
			status = true;
		return status;
	}
	public String criptografar(String senha) {
		return Base64.encodeBase64String(senha.getBytes());
	}
}