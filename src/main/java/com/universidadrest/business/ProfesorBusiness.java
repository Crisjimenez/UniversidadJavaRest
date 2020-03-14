package com.universidadrest.business;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.universidadrest.model.PersonaModel;
import com.universidadrest.model.ProfesorModel;
import com.universidadrest.repository.IEstudianteRepository;
import com.universidadrest.repository.IPersonaRepository;
import com.universidadrest.repository.IProfesorRepository;

@Service
public class ProfesorBusiness implements IProfesorBusiness{
	
	@Autowired
	IProfesorRepository profesorRepository;
	@Autowired
	IPersonaRepository personaRepository;
	
	@Autowired
	IEstudianteRepository estudianteRepository;
	

	@Override
	public ProfesorModel consultarPorId(Integer id) throws Exception {
		return profesorRepository.findById(id).orElse(null);
	}

	@Override
	public List<ProfesorModel> consultarTodos() throws Exception {
		return profesorRepository.findAll();
	}

	@Override
	public ProfesorModel crear(ProfesorModel profesor) throws Exception {
		

		PersonaModel personaCreada = null;
		
		if (profesor.getPersona().getId() == null) {
			personaCreada = personaRepository.save(profesor.getPersona());
		} else {
			personaCreada = personaRepository.findById(profesor.getPersona().getId()).orElse(null);
		}
		
		profesor.setPersona(personaCreada);
		return profesorRepository.save(profesor);
		
		
	}

	@Override
	public ProfesorModel actualizar(@Valid ProfesorModel profesor) throws Exception {
		return profesorRepository.save(profesor);
	}

	@Override
	public void eliminar(Integer id) throws Exception {
		profesorRepository.deleteById(id);
		
	}

}
