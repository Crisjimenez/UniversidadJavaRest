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

import com.universidadrest.business.IMateriaBusiness;
import com.universidadrest.model.MateriaModel;

@RestController
@RequestMapping("/materia")
@CrossOrigin("*") 
public class MateriaC {

	@Autowired
	IMateriaBusiness materiaBusiness;

	// Consultar por id
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<MateriaModel> consultarPorId(@PathVariable Integer id) {
		try {
			MateriaModel retornarMateria = materiaBusiness.consultarPorId(id);
			return ResponseEntity.ok(retornarMateria);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

	// Consultar todos
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<MateriaModel>> consultarTodas() {
		try {
			List<MateriaModel> listaRetorno = materiaBusiness.consultarTodos();
			return ResponseEntity.ok(listaRetorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Crear registro Save
	@PostMapping("/crear/")
	@ResponseBody
	public ResponseEntity<MateriaModel> crear(@Valid @RequestBody MateriaModel materia) {
		try {
			MateriaModel retorno = materiaBusiness.crear(materia);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Actualizar registro
	@PutMapping("/actualizar/{id}")
	@ResponseBody
	public ResponseEntity<MateriaModel> actualizar(@PathVariable(value = "id") Integer materiaId,
			@Valid @RequestBody MateriaModel materia) {

		try {
			MateriaModel retorno = materiaBusiness.actualizar(materia);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Borrar Materia
	@DeleteMapping("/borrar/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminar(@PathVariable(value = "id") Integer id) {
		try {
			materiaBusiness.eliminar(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
