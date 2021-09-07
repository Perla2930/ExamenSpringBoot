package com.exam.examen.entitys;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "alumnos", schema="public")

public class alumnos {
	
	@Id
	@Column(name="id", unique = true)
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
	)
	private int id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="paterno")
	private String paterno;
	
	@Column(name="materno")
	private String materno;
	
	@Column(name="materia")
	private int materia;
	
	/*
	@OneToOne()
	@JoinColumn(name="materia", referencedColumnName = "id")
	private materias materia;
	*/
}
