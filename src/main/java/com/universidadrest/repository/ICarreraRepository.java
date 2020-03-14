package com.universidadrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidadrest.model.CarreraModel;

@Repository
public interface ICarreraRepository extends JpaRepository<CarreraModel, Integer> {

}
