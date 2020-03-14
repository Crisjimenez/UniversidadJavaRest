package com.universidadrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.universidadrest.model.MateriaModel;

@Repository
public interface IMateriaRepository extends JpaRepository<MateriaModel, Integer>{

	List<MateriaModel> findByNombreLikeAndCarreraNombreLikeOrderByNombre(String nombre, String carrera);

}
