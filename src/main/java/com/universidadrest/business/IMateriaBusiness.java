package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import com.universidadrest.model.MateriaModel;

public interface IMateriaBusiness {
	
	MateriaModel consultarPorId(Integer id) throws Exception;
	List<MateriaModel> consultarTodos() throws Exception;
	MateriaModel crear(MateriaModel materia) throws Exception;
	MateriaModel actualizar(@Valid MateriaModel carrera) throws Exception;
	void eliminar(Integer id) throws Exception;
	List<MateriaModel> consultarPorNombre(String nombre, String carrera) throws Exception;

}
