package com.exam.examen.utils;

import org.springframework.context.annotation.Configuration;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.entitys.calificaciones;
import com.exam.examen.entitys.materias;

@Configuration
public class validaciones {

	public boolean validateAlumno(alumnos alu) {
		if (alu != null || alu.getId() >= 0 || alu.getNombre()!= null ||alu.getNombre().isEmpty()
				|| alu.getPaterno()!=null || alu.getPaterno().isEmpty()
				|| alu.getMaterno()!=null || alu.getMaterno().isEmpty()
				|| alu.getMateria() >=0 )
			{
				return true;
			}
			return false;
	}
	
	public boolean validateCalificaciones(calificaciones cal) {
		if(cal.getId() <=0 || cal.getAlumno() <=0  || cal.getMateria() <=0 ) {
			return false;
		}
		else {
			return true;
		}
	}
}
