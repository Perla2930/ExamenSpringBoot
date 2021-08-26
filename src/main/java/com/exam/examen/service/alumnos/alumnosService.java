package com.exam.examen.service.alumnos;

import java.util.List;

import com.exam.examen.entitys.alumnos;

public interface alumnosService {

	public List<alumnos> getAllAlumnos();
	
	public alumnos save(alumnos alu);
	
	public alumnos findById(int id);
	
}
