package com.universidadrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.universidadrest.model.EstudianteModel;


//https://docs.spring.io/spring-data/jpa/docs/1.3.4.RELEASE/reference/html/jpa.repositories.html 
@Repository
public interface IEstudianteRepository extends JpaRepository<EstudianteModel, Integer> {

	List<EstudianteModel> findByPersonaNombreLikeOrderByPersonaNombre(String nombre);

	/*@Query("select e from EstudianteModel e " + 
			"where e.persona.edad >= ?1 order by e.persona.nombre")
	List<EstudianteModel> consultarMayores(int edad);*/

	List<EstudianteModel> findByCarreraNombreLikeOrderByPersonaNombre(String carrera);

	
}
