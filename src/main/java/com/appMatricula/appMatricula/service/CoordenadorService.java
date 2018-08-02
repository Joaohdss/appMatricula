package com.appMatricula.appMatricula.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appMatricula.appMatricula.Util.Util;
import com.appMatricula.appMatricula.models.Coordenador;
import com.appMatricula.appMatricula.repository.CoordenadorRepository;

@Service
public class CoordenadorService {
	
	@Autowired
	CoordenadorRepository coordenadorRepository;
	@Autowired
	Util util;
	
	public Coordenador add(Coordenador coordenador) throws Exception {
		Coordenador coordAdd = null;
		if (util.validaEmail(coordenador.getEmail()) && util.validaSenha(coordenador.getSenha())
				&& !(existeEmail(coordenador.getEmail()))) {
			coordenador.setSenha(util.criptografar(coordenador.getSenha()));
			coordAdd = coordenadorRepository.save(coordenador);
			return coordAdd;
		}
		throw new Exception("Não foi possivel fazer o cadastro");
	}
	
	public Collection<Coordenador> buscarTodos(){
		return coordenadorRepository.findAll();
	}
	public boolean Login(String email,String senhaInformada) throws Exception{
		Coordenador resulCoord = buscaEmail(email);
		String senhaCord = resulCoord.getSenha();
		if(!util.verificaSenha(senhaCord, senhaInformada)) {
			throw new Exception("Login ou senha invalido");
		}
		return true;
		
	}
	public Coordenador buscaEmail(String email) {
		Collection<Coordenador> coordenadors = buscarTodos();
		for (Coordenador coordenador : coordenadors) {
			if(coordenador.getEmail().equalsIgnoreCase(email)) {
				return coordenador;
			}
		}
		return null;
	}
	public Coordenador excluir(Integer id) throws Exception{
		Optional<Coordenador> opCoordenador = coordenadorRepository.findById(id);
		
		if(!opCoordenador.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Coordenador coord = opCoordenador.get();
		coordenadorRepository.delete(coord);
		
		return coord;
	}
	public Coordenador atualizarSenha(Coordenador coordenador,Integer id) throws Exception {
		Optional<Coordenador> opCoordenador = coordenadorRepository.findById(id);
		if (!opCoordenador.isPresent()) {
			throw new Exception("Todo don't exists");
		}
		if (!util.validaSenha(coordenador.getSenha()))
			return null;
		Coordenador newCoord = opCoordenador.get();
		newCoord.setSenha(coordenador.getSenha());
		
		coordenadorRepository.save(newCoord);
		
		return newCoord;
	}
	public Integer encontrarIdPorEmail(String email) {
		Collection<Coordenador> coordenadores = coordenadorRepository.findAll();
		for (Coordenador coordenador : coordenadores) {
			if(coordenador.getEmail().equalsIgnoreCase(email)) {
				return coordenador.getIdCoordenador();
			}
		}
		return -1;
	}
	public  boolean existeEmail(String email) {
		Collection<Coordenador> coordenadores = buscarTodos();
		for (Coordenador coordenador : coordenadores) {
			if(coordenador.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}
}
