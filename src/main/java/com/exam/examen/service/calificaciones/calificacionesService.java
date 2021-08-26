package com.exam.examen.service.calificaciones;

import java.util.List;
import java.util.Optional;

import com.exam.examen.entitys.calificaciones;

public interface calificacionesService {
	
	public List<calificaciones> getAllCalificaciones();
	
	public calificaciones save(calificaciones cal);
	
	public Optional<calificaciones> findById(int id);
	
	public boolean delete(int idAlu, int idMateria);
	
	public boolean modificar(calificaciones cal);
	

}
