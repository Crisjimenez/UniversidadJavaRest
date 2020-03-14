package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import com.universidadrest.model.ProfesorModel;

public interface IProfesorBusiness {
	
	ProfesorModel consultarPorId(Integer id) throws Exception;
	List<ProfesorModel> consultarTodos() throws Exception;
	ProfesorModel crear(ProfesorModel profesor) throws Exception;
	ProfesorModel actualizar(@Valid ProfesorModel profesor) throws Exception;
	void eliminar(Integer id) throws Exception;

}
