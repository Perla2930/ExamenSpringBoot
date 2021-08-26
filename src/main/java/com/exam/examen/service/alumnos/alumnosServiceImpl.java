package com.exam.examen.service.alumnos;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.reposotiry.alumnos.alumnosRepository;
import com.exam.examen.utils.validaciones;

@Service
public class alumnosServiceImpl implements alumnosService {

	@Autowired
	alumnosRepository alumnosRepository;
	
	@Autowired
	validaciones validaciones;

	@Override
	public List<alumnos> getAllAlumnos() {
		List<alumnos> list = alumnosRepository.findAll(); 
		List<alumnos> listAlus = new ArrayList<>();
		for(alumnos alu: list) {
			alumnos a1 = new alumnos();
			a1.setId(alu.getId());
			a1.setNombre(alu.getNombre());
			a1.setPaterno(alu.getPaterno());
			a1.setMaterno(alu.getMaterno());
			a1.setMateria(alu.getMateria());
			
			listAlus.add(a1);
		}
		return listAlus;
	}

	@Override
	public alumnos save(alumnos alu) {
		if(validaciones.validateAlumno(alu)) {
			alumnosRepository.save(alu);
			return alu;
		}
		return null;
	}

	@Override
	public alumnos findById(int id) {
		List<alumnos> alus = getAllAlumnos();
		for(alumnos al: alus) {
			if(al.getId() == id) {
				return al;
			}
		}
		//
		return null;
	}

	
}
