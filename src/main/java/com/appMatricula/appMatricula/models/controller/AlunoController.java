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

import com.appMatricula.appMatricula.models.Aluno;
import com.appMatricula.appMatricula.models.Disciplina;
import com.appMatricula.appMatricula.service.AlunoService;

@Controller
@CrossOrigin(origins = "*")
public class AlunoController {
	
	@Autowired
	AlunoService alunoService;
	
	@RequestMapping(value = "/api/aluno/post", method = RequestMethod.POST)
	public ResponseEntity<Aluno> add(@RequestBody Aluno aluno) throws Exception {
		Aluno novoAluno = alunoService.add(aluno);
		return new ResponseEntity<>(novoAluno,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/get", method = RequestMethod.GET)
	public ResponseEntity<Collection<Aluno>> getAluno() {
		Collection<Aluno> alunos = alunoService.buscarTodos();
		return new ResponseEntity<>(alunos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/login", method = RequestMethod.PUT)
	public ResponseEntity<HttpStatus> getLogin(@RequestBody Aluno aluno) throws Exception {
		alunoService.Login(aluno.getEmail(), aluno.getSenha());
		return new ResponseEntity<>(HttpStatus.ACCEPTED,HttpStatus.OK);
	}
	@RequestMapping(value = "/api/aluno/matricula/{matricula}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscaMatricula(@PathVariable("matricula") Long matricula) throws Exception {
		return new ResponseEntity<>(alunoService.BuscaId(matricula), HttpStatus.OK);
	}
	@RequestMapping(value = "/api/aluno/get/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<Aluno> buscaEmail(@PathVariable("email") String email){
		return new ResponseEntity<>(alunoService.buscaEmail(email), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/put/{matricula}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> setAluno(@PathVariable("matricula") Long matricula, @RequestBody Aluno aluno) throws Exception {
		Aluno alunoAlterado = alunoService.update(aluno, matricula);
		return new ResponseEntity<>(alunoAlterado,HttpStatus.OK);
	}
	@RequestMapping(value = "/api/aluno/addcadeira/{matricula}", method = RequestMethod.PUT)
	public ResponseEntity<Aluno> addCadeira(@PathVariable("matricula") Long matricula,@RequestBody Disciplina disciplina) throws Exception {
		Aluno alunoAlterado = alunoService.AddDisciplina(disciplina.getNome(), matricula);
		return new ResponseEntity<>(alunoAlterado,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/aluno/delete/{matricula}", method = RequestMethod.DELETE)
	public ResponseEntity<Aluno> deleteAluno(@PathVariable("matricula") Long matricula) throws Exception {
		return new ResponseEntity<>(alunoService.excluir(matricula), HttpStatus.OK);
	}
}