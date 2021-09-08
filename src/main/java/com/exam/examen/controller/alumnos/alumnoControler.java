package com.exam.examen.controller.alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.service.alumnos.alumnosService;
import com.exam.examen.service.alumnos.alumnosServiceImpl;
import com.exam.examen.utils.validaciones;

@RestController
@RequestMapping(value="/api/exam/alumnos/")
public class alumnoControler {

	
	@Autowired
	private alumnosService alumnosService;
	
	@Autowired
	validaciones validaciones;
	
	//Creacion de nuevo alumno
	@PostMapping("/create")
	public ResponseEntity<?> createAlu (@RequestBody alumnos alu){
		if(validaciones.validateAlumno(alu)) {
		return ResponseEntity.status(HttpStatus.CREATED ).body(alumnosService.save(alu));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error no se puede crear el alumno");
	}
	
	//find Alumno
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getAlu(@PathVariable(value="id") int alumnoId) {
		alumnos objAlu = (alumnos) alumnosService.findById(alumnoId);
		System.out.println(objAlu.toString());
		if(objAlu != null) {
			return ResponseEntity.ok(objAlu);
		}
		return ResponseEntity.notFound().build();
	}
	
	//find All Alumnos
	@GetMapping("/findAll")
	public ResponseEntity<List<alumnos>> getAlumnos(){
		return ResponseEntity.status(HttpStatus.OK).body(alumnosService.getAllAlumnos());
	}
}
