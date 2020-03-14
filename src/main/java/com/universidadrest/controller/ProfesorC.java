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

import com.universidadrest.business.IProfesorBusiness;
import com.universidadrest.model.ProfesorModel;

@RestController
@RequestMapping("/profesor")
@CrossOrigin("*")

public class ProfesorC {

	@Autowired
	IProfesorBusiness profesorBusiness;

	// Consultar por id
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<ProfesorModel> consultarPorId(@PathVariable Integer id) {
		try {
			ProfesorModel retornarProfesor = profesorBusiness.consultarPorId(id);
			return ResponseEntity.ok(retornarProfesor);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Consultar todos
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<ProfesorModel>> consultarTodas() {
		try {
			List<ProfesorModel> listaRetorno = profesorBusiness.consultarTodos();
			return ResponseEntity.ok(listaRetorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Crear registro Save
	@PostMapping("/crear/")
	@ResponseBody
	public ResponseEntity<ProfesorModel> crear(@Valid @RequestBody ProfesorModel profesor) {
		try {
			ProfesorModel retorno = profesorBusiness.crear(profesor);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Actualizar registro
	@PutMapping("/actualizar/{id}")
	@ResponseBody
	public ResponseEntity<ProfesorModel> actualizar(@PathVariable(value = "id") Integer profesorId,
			@Valid @RequestBody ProfesorModel profesor) {

		try {
			ProfesorModel retorno = profesorBusiness.actualizar(profesor);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Borrar Carrera
	@DeleteMapping("/borrar/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminar(@PathVariable(value = "id") Integer id) {
		try {
			profesorBusiness.eliminar(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
