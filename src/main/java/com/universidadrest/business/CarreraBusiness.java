package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadrest.model.CarreraModel;
import com.universidadrest.repository.ICarreraRepository;

@Service
public class CarreraBusiness implements ICarreraBusiness {
	
	@Autowired
	ICarreraRepository carreraRepository;

	@Override
	public CarreraModel consultarPorId(Integer id) throws Exception {
		return carreraRepository.findById(id).orElse(null);
	}

	@Override
	public List<CarreraModel> consultarTodos() throws Exception {
		return carreraRepository.findAll();
	}

	@Override
	public CarreraModel crear(CarreraModel carrera) throws Exception {
		return carreraRepository.save(carrera);
	}

	@Override
	public CarreraModel actualizar(@Valid CarreraModel carrera) throws Exception {
		return carreraRepository.save(carrera);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		carreraRepository.deleteById(id);
		
	}
	
	
	
}
