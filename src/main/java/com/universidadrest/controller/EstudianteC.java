package com.universidadrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.universidadrest.business.IEstudianteBusiness;
import com.universidadrest.model.EstudianteModel;

@RestController
@RequestMapping("/estudiante")
@CrossOrigin("*")
public class EstudianteC {

	@Autowired
	IEstudianteBusiness estudianteBusiness;

	// Consultar por id
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<EstudianteModel> consultarPorId(@PathVariable Integer id) {
		
		try {
			EstudianteModel retornarEstudiante = estudianteBusiness.consultarPorId(id);
			return ResponseEntity.ok(retornarEstudiante);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Consultar por nombre
	@GetMapping(value = "cosultar-nombre/{nombre}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<EstudianteModel>> consultarPorNombre(@PathVariable String nombre) {
		
		try {
			List<EstudianteModel> retornarEstudiante = estudianteBusiness.consultarPorNombre(nombre);
			return ResponseEntity.ok(retornarEstudiante);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	// Consultar por id
	@GetMapping(value = "cosultar-mayores/", produces = "application/json")
	@ResponseBody
	public ResponseEntity<List<EstudianteModel>> consultarMayores() {
		
		try {
			List<EstudianteModel> retornarEstudiante = estudianteBusiness.consultarMayores();
			return ResponseEntity.ok(retornarEstudiante);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Consultar todos
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<EstudianteModel>> consultarTodas() {
		try {
			List<EstudianteModel> listaRetorno = estudianteBusiness.consultarTodos();
			return ResponseEntity.ok(listaRetorno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
    }

	//Crear registro Save
    @PostMapping("/crear/")
    @ResponseBody
    public ResponseEntity<EstudianteModel> crear(@Valid @RequestBody EstudianteModel estudiante) {
 
    	try {
    		EstudianteModel retorno = estudianteBusiness.crear(estudiante);
			return ResponseEntity.ok(retorno);
		}catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
    }


  //Actualizar registro
    @PutMapping("/actualizar/{id}")
    @ResponseBody
    public ResponseEntity<EstudianteModel> actualizar(@PathVariable(value = "id") Integer estudianteId,
                           @Valid @RequestBody EstudianteModel estudiante) {
    	try {
    		EstudianteModel retorno = estudianteBusiness.actualizar(estudiante);
			return ResponseEntity.ok(retorno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
    }


  //Borrar 
    @DeleteMapping("/borrar/{id}")
    @ResponseBody
    public ResponseEntity<?> eliminar(@PathVariable(value = "id") Integer id) {
    	try {
    		estudianteBusiness.eliminar(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
    }


}
