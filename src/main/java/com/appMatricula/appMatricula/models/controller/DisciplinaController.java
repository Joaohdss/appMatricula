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

import com.appMatricula.appMatricula.models.Disciplina;
import com.appMatricula.appMatricula.service.DisciplinaService;

@Controller
@CrossOrigin(origins = "*")
public class DisciplinaController {
	
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/api/post", method = RequestMethod.POST)
	public ResponseEntity<Disciplina> add(@RequestBody Disciplina disciplina) throws Exception {
		return new ResponseEntity<>(disciplinaService.add(disciplina),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/get", method = RequestMethod.GET)
	public ResponseEntity<Collection<Disciplina>> getDisciplina() {
		Collection<Disciplina> disciplinas = disciplinaService.buscarTodos();
		return new ResponseEntity<>(disciplinas, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/get/{id}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(disciplinaService.BuscaId(id), HttpStatus.OK);
	}
	@RequestMapping(value = "/api/get/nome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Disciplina> buscaNome(@PathVariable("nome") String nome) throws Exception {
		return new ResponseEntity<>(disciplinaService.buscaPorNome(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/put/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> setDisciplina(@PathVariable("id") int id, @RequestBody Disciplina disciplina) throws Exception {
		Disciplina disciplinaAlterada = disciplinaService.update(disciplina, id);
		return new ResponseEntity<>(disciplinaAlterada,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(disciplinaService.excluir(id), HttpStatus.OK);
	}

	@RequestMapping(value = "/api/put/diminuirVaga/{nome}", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> diminuirVaga(@PathVariable("nome") String nome) throws Exception {
		return new ResponseEntity<>(disciplinaService.diminuirVaga(nome), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/put/aumentarVaga/{nome}", method = RequestMethod.PUT)
	public ResponseEntity<Disciplina> aumentarVaga(@PathVariable("nome") String nome) throws Exception {
		return new ResponseEntity<>(disciplinaService.aumentarVaga(nome), HttpStatus.OK);
	}
}
