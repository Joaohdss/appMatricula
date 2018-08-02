package com.appMatricula.appMatricula.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appMatricula.appMatricula.models.Coordenador;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer>{

}
