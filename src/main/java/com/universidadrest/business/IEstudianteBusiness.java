package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import com.universidadrest.model.EstudianteModel;

public interface IEstudianteBusiness {

	EstudianteModel consultarPorId(Integer id) throws Exception;
	List<EstudianteModel> consultarTodos() throws Exception;
	EstudianteModel crear(EstudianteModel estudiante) throws Exception;
	EstudianteModel actualizar(@Valid EstudianteModel estudiante) throws Exception;
	void eliminar(Integer id) throws Exception;
	List<EstudianteModel> consultarPorNombre(String nombre) throws Exception;
	List<EstudianteModel> consultarMayores() throws Exception;
	List<EstudianteModel> consultarPorNombreCarrera(String carrera) throws Exception;

}
