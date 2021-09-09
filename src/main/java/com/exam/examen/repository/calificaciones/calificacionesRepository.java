package com.exam.examen.repository.calificaciones;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.exam.examen.entitys.calificaciones;

import javax.transaction.Transactional;


@Repository
public interface calificacionesRepository extends JpaRepository<calificaciones, Integer>{
	
		
	@Query("SELECT e FROM #{#entityName} e WHERE alumno = :alumno AND materia = :materia")
	calificaciones getidDelete( @Param("alumno") Integer alumno, @Param("materia") Integer materia);

	@Transactional
	@Modifying
	@Query("UPDATE  #{#entityName} e  SET calificacion = :calificacion WHERE  alumno = :alumno AND materia = :materia")
	int update(@Param("calificacion") Integer calificacion, @Param("alumno") Integer alumno, @Param("materia") Integer materia);


}

