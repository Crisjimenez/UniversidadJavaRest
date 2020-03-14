package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadrest.model.EstudianteModel;
import com.universidadrest.model.MateriaModel;
import com.universidadrest.repository.IMateriaRepository;

@Service
public class MateriaBusiness implements IMateriaBusiness{
	
	@Autowired
	IMateriaRepository materiaRepository;
	
	@Override
	public MateriaModel consultarPorId(Integer id) throws Exception {
		return materiaRepository.findById(id).orElse(null);
	}

	@Override
	public List<MateriaModel> consultarTodos() throws Exception {
		return materiaRepository.findAll();
	}

	@Override
	public MateriaModel crear(MateriaModel materia) throws Exception {
		return materiaRepository.save(materia);
	}

	@Override
	public MateriaModel actualizar(@Valid MateriaModel materia) throws Exception {
		return materiaRepository.save(materia);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		materiaRepository.deleteById(id);
		
	}
	
	@Override
	public List<MateriaModel> consultarPorNombre(String nombre, String carrera) throws Exception {
		nombre = "%" + nombre + "%";
		carrera = "%" + carrera + "%";
		return materiaRepository.findByNombreLikeAndCarreraNombreLikeOrderByNombre(nombre, carrera);
	}

}
