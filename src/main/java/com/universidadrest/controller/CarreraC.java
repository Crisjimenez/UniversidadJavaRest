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

import com.universidadrest.business.ICarreraBusiness;
import com.universidadrest.model.CarreraModel;

@RestController
@RequestMapping("/carrera")
@CrossOrigin("*")
public class CarreraC {

	@Autowired
	ICarreraBusiness carreraBusiness;

	// Consultar por id
	@GetMapping(value = "/{id}", produces = "application/json")
	@ResponseBody
	public ResponseEntity<CarreraModel> consultarPorId(@PathVariable Integer id) {
		try {
			CarreraModel retornarCarrera = carreraBusiness.consultarPorId(id);
			return ResponseEntity.ok(retornarCarrera);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Consultar todos
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<CarreraModel>> consultarTodas() {
		try {
			List<CarreraModel> listaRetorno = carreraBusiness.consultarTodos();
			return ResponseEntity.ok(listaRetorno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Crear registro Save
	@PostMapping("/crear/")
	@ResponseBody
	public ResponseEntity<CarreraModel> crear(@Valid @RequestBody CarreraModel carrera) {
		try {
    		CarreraModel retorno = carreraBusiness.crear(carrera);
			return ResponseEntity.ok(retorno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Actualizar registro
	@PutMapping("/actualizar/{id}")
	@ResponseBody
	public ResponseEntity<CarreraModel> actualizar(@PathVariable(value = "id") Integer carreraId,
            @Valid @RequestBody CarreraModel carrera) {

		try {
    		CarreraModel retorno = carreraBusiness.actualizar(carrera);
			return ResponseEntity.ok(retorno);
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	// Borrar Carrera
	@DeleteMapping("/borrar/{id}")
	@ResponseBody
	public ResponseEntity<?> eliminar(@PathVariable(value = "id") Integer id) {
    	try {
    		carreraBusiness.eliminar(id);
			return ResponseEntity.ok().build();
		}catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
    }

}
