package com.appMatricula.appMatricula.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appMatricula.appMatricula.models.Disciplina;
import com.appMatricula.appMatricula.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	public Disciplina add(Disciplina disciplina) throws Exception {
		if (existeDisciplina(disciplina.getNome())) {
			throw new Exception("Disciplina já cadastrada no banco de dados");
		}
		return disciplinaRepository.save(disciplina);
	}

	public Collection<Disciplina> buscarTodos() {
		return disciplinaRepository.findAll();
	}

	public Disciplina BuscaId(Integer id) throws Exception {
		Optional<Disciplina> opDisciplina = disciplinaRepository.findById(id);

		if (!opDisciplina.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Disciplina materia = opDisciplina.get();
		return materia;
	}

	public Disciplina excluir(Integer id) throws Exception {
		Optional<Disciplina> opDisciplina = disciplinaRepository.findById(id);

		if (!opDisciplina.isPresent()) {
			throw new Exception("ERROR!!");
		}
		Disciplina materia = opDisciplina.get();
		disciplinaRepository.delete(materia);

		return materia;
	}

	public Disciplina alterar(Disciplina disciplina) {
		return disciplinaRepository.save(disciplina);
	}

	public Disciplina update(Disciplina disciplina, int id) throws Exception {
		Optional<Disciplina> optDisciplina = disciplinaRepository.findById(id);
		if (!optDisciplina.isPresent()) {
			throw new Exception("Todo don't exists");
		}
		Disciplina newDisciplina = optDisciplina.get();
		newDisciplina.setNome(disciplina.getNome());
		disciplinaRepository.save(newDisciplina);
		return newDisciplina;
	}

	public Disciplina buscaPorNome(String nome) throws Exception {
		Collection<Disciplina> disciplinas = buscarTodos();
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nome)) {
				return disciplina;
			}
		}
		throw new Exception("Não existe disciplina");
	}
	public boolean existeDisciplina(String nome){
		Collection<Disciplina> disciplinas = buscarTodos();
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getNome().equals(nome)) {
				return true;
			}
		}
		return false;
	}
	
	public Disciplina diminuirVaga(String disciplina) throws Exception {
		Collection<Disciplina> disciplinas = buscarTodos();
		for (Disciplina disci : disciplinas) {
			if (disci.getNome().equalsIgnoreCase(disciplina)) {
				Optional<Disciplina> optDisciplina = disciplinaRepository.findById(disci.getId());
				if (!optDisciplina.isPresent()) {
					throw new Exception("Todo don't exists");
				}
				Disciplina newDisciplina = optDisciplina.get();
				newDisciplina.setVagas(disci.getVagas() - 1);
				disciplinaRepository.save(newDisciplina);
				return newDisciplina;
			}
		}
		throw new Exception("Não foi possivel aumentar as vagas");
	}

	public Disciplina aumentarVaga(String disciplina) throws Exception {
		Collection<Disciplina> disciplinas = buscarTodos();
		for (Disciplina disci : disciplinas) {
			if (disci.getNome().equalsIgnoreCase(disciplina)) {
				Optional<Disciplina> optDisciplina = disciplinaRepository.findById(disci.getId());
				if (!optDisciplina.isPresent()) {
					throw new Exception("Todo don't exists");
				}
				Disciplina newDisciplina = optDisciplina.get();

				newDisciplina.setVagas(disci.getVagas() + 1);
				disciplinaRepository.save(newDisciplina);
				return newDisciplina;
			}
		}
		throw new Exception("Não foi possivel aumentar as vagas");
	}
}