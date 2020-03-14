package com.universidadrest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
@Entity(name="tbl_estudiante")
public class EstudianteModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_estudiante")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_persona")
	private PersonaModel persona;
	
	@ManyToOne
	@JoinColumn(name="id_carrera")
	private CarreraModel carrera;
	

}
