package com.universidadrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidadrest.model.ProfesorModel;

@Repository
public interface IProfesorRepository extends JpaRepository<ProfesorModel, Integer> {

}
