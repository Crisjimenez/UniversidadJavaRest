package com.universidadrest.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadrest.model.EstudianteModel;
import com.universidadrest.model.PersonaModel;
import com.universidadrest.repository.IEstudianteRepository;
import com.universidadrest.repository.IPersonaRepository;

@Service
public class EstudianteBusiness implements IEstudianteBusiness {

	@Autowired
	IEstudianteRepository estudianteRepository;
	
	@Autowired
	IPersonaRepository personaRepository;
	
	@Override
	public EstudianteModel consultarPorId(Integer id) throws Exception {
		return estudianteRepository.findById(id).orElse(null);
	}

	@Override
	public List<EstudianteModel> consultarTodos() throws Exception {
		return estudianteRepository.findAll();
	}

	@Override
	public EstudianteModel crear(EstudianteModel estudiante) throws Exception {
		
		PersonaModel personaCreada = null;
		
		if (estudiante.getPersona().getId() == null) {
			personaCreada = personaRepository.save(estudiante.getPersona());
		} else {
			personaCreada = personaRepository.findById(
					estudiante.getPersona().getId()).orElse(null);
		}
		
		if (personaCreada == null)  {
			throw new Exception("No existe la persona");
		}
		estudiante.setPersona(personaCreada);
		return estudianteRepository.save(estudiante);
	}

	@Override
	public EstudianteModel actualizar(EstudianteModel estudiante) throws Exception {
		return estudianteRepository.save(estudiante);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		estudianteRepository.deleteById(id);
	}

	@Override
	public List<EstudianteModel> consultarPorNombre(String nombre) throws Exception {
		nombre = "%" + nombre + "%";
		return estudianteRepository.findByPersonaNombreLikeOrderByPersonaNombre(nombre);
	}

	@Override
	public List<EstudianteModel> consultarMayores() throws Exception {
		return null; //estudianteRepository.consultarMayores(18);
	}
	
	@Override
	public List<EstudianteModel> consultarPorNombreCarrera(String carrera) throws Exception {
		carrera = "%" + carrera + "%";
		return estudianteRepository.findByCarreraNombreLikeOrderByPersonaNombre(carrera);
	}
	
}
