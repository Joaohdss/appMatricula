package com.appMatricula.appMatricula.models.controller;



import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.appMatricula.appMatricula.models.Coordenador;
import com.appMatricula.appMatricula.service.CoordenadorService;

@Controller
@CrossOrigin(origins = "*")
public class CoordenadorController {
	
	@Autowired
	CoordenadorService coordenadorService;

	@RequestMapping(value = "/api/coord/post", method = RequestMethod.POST)
	public ResponseEntity<Coordenador> add(@RequestBody Coordenador coordenador) throws Exception {
		return new ResponseEntity<>(coordenadorService.add(coordenador),HttpStatus.OK);
	}
	
	@RequestMapping(value = "api/coord/get", method = RequestMethod.GET)
	public ResponseEntity<Collection<Coordenador>> busca() {
		return new ResponseEntity<>(coordenadorService.buscarTodos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/coord/put/{email}", method = RequestMethod.PUT)
	public ResponseEntity<Coordenador> editarSenhar(@PathVariable("email") String emailCoordenador, @RequestBody Coordenador coordenador) throws Exception {
		Integer id = coordenadorService.encontrarIdPorEmail(emailCoordenador);
		Coordenador cord = coordenadorService.atualizarSenha(coordenador, id);
		return new ResponseEntity<>(cord,HttpStatus.OK);
	}
	@RequestMapping(value = "/api/coord/login", method = RequestMethod.PUT)
	public ResponseEntity<HttpStatus> getLogin(@RequestBody Coordenador aluno) throws Exception {
		coordenadorService.Login(aluno.getEmail(), aluno.getSenha());
		return new ResponseEntity<>(HttpStatus.ACCEPTED,HttpStatus.OK);
	}
	
}
