package com.universidadrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidadrest.model.PersonaModel;

@Repository
public interface IPersonaRepository extends JpaRepository<PersonaModel, Integer> {

}
