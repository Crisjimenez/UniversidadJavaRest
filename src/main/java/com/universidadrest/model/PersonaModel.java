package com.universidadrest.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
@Entity(name="tbl_persona")
public class PersonaModel implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column
	private String documento;
	
	@Column(name = "tipo_documento")
	private String tipoDocumento;
	
	@Column
	private int edad;
	
	@Column
	private String sexo;
	
	/*@OneToMany(mappedBy="persona")
	private List<ProfesorModel> profesores;
	
	@OneToMany(mappedBy="persona")
	private List<EstudianteModel> estudiantes;*/

}
