package com.universidadrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.universidadrest.model.EstudianteModel.EstudianteModelBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "tbl_materia")
public class MateriaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column
	private String descripcion;
	
	@ManyToOne
	@JoinColumn(name="id_carrera")
	private CarreraModel carrera;
	
	@ManyToOne
	@JoinColumn(name="id_profesor")
	private ProfesorModel profesor;

}
