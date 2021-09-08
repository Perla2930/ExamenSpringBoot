package com.exam.examen.entitys;

import javax.persistence.*;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "calificaciones", schema="public")

public class calificaciones {

	@Id
	@Column(name="id", unique = true)
	@GeneratedValue(
			strategy= GenerationType.AUTO,
			generator="native"
	)
	private int id;
	
	/*
	@OneToOne
	@JoinColumn(name="alumno", referencedColumnName = "id")
	*/
	@Column(name="alumno")
	private int alumno;
	
	/*
	@OneToOne
	@JoinColumn(name="materia", referencedColumnName = "id")
	*/
	
	@Column(name="materia")
	private int materia;
	
	@Column(name="calificacion")
	private int calificacion;
}
