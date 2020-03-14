package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import com.universidadrest.model.CarreraModel;

public interface ICarreraBusiness {
	
	CarreraModel consultarPorId(Integer id) throws Exception;
	List<CarreraModel> consultarTodos() throws Exception;
	CarreraModel crear(CarreraModel estudiante) throws Exception;
	CarreraModel actualizar(@Valid CarreraModel carrera) throws Exception;
	void eliminar(Integer id) throws Exception;

}
