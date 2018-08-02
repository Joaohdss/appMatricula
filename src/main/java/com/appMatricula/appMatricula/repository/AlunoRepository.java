package com.appMatricula.appMatricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appMatricula.appMatricula.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
}
