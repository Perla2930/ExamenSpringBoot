package com.exam.examen.controller.calificaciones;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examen.entitys.calificaciones;
import com.exam.examen.service.calificaciones.calificacionesService;
import com.exam.examen.utils.validaciones;

@RestController
@RequestMapping(value = "/api/exam/calificacion")
public class calificacionController {

	@Autowired
	private calificacionesService calificacionesService;

	@Autowired
	validaciones validaciones;

	// Registro de calificacion
	@PostMapping("/registrar")
	public ResponseEntity<?> addCalif(@RequestBody calificaciones cal) {
		if (validaciones.validateCalificaciones(cal)) {
			return ResponseEntity.status(HttpStatus.CREATED).body(calificacionesService.save(cal));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se puede registrar calificacion");
	}

	// Eliminacion de calificacion
	@DeleteMapping("/eliminar/{alumno}/{materia}")
	public ResponseEntity<?> deleteCalif(@PathVariable(value="alumno") int alumno, @PathVariable(value="materia") int materia) {
		if (alumno <= 0 || materia <= 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se pudo eliminar el registro");
		} else {
			if(calificacionesService.delete(alumno, materia)) {
				return ResponseEntity.status(HttpStatus.OK).body("Eliminacion exitosa");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se pudo eliminar el registro");
		}
	}

	// Modificacion de calificacion

	@PutMapping("/modificar")
	public ResponseEntity<?> updateCal(@RequestBody calificaciones cal) {

		System.out.println(cal.getId()+" "+cal.getAlumno()+" "+cal.getMateria());
		
		if (validaciones.validateCalificaciones(cal)) {
			if(calificacionesService.modificar(cal)) {
				return ResponseEntity.status(HttpStatus.OK).body("Modificación Exitosa");
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se pudo modificar el registro");
			
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se pudo modificar el registro");
		}
	}

}