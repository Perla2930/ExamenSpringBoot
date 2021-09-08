package com.exam.examen.service.calificaciones;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.examen.entitys.calificaciones;
import com.exam.examen.repository.calificaciones.calificacionesRepository;
import com.exam.examen.utils.validaciones;

@Service
public class calificacionesServiceImpl implements calificacionesService {

	@Autowired
    calificacionesRepository calificacionesRepository;

	@Autowired
	validaciones validaciones;

	@Override
	public List<calificaciones> getAllCalificaciones() {
		return calificacionesRepository.findAll();
	}

	@Override
	public Optional<calificaciones> findById(int id) {
		return calificacionesRepository.findById(id);
	}

	@Override
	public calificaciones save(calificaciones cal) {
		return calificacionesRepository.save(cal);
	}

	@Override
	public boolean delete(int idAlu, int idMateria) {
		if (idAlu <= 0 || idMateria <= 0) {
			return false;
		} else {
			calificaciones calif = calificacionesRepository.getidDelete(idAlu, idMateria);
			int idDelete = calif.getId();
			calificacionesRepository.deleteById(idDelete);
			return true;
		}
	}

	@Override
	public boolean modificar(calificaciones cal) {
		if (validaciones.validateCalificaciones(cal)) {
			int id = cal.getId();
			calificacionesRepository.deleteById(id);
			calificaciones calif = new calificaciones();
			calif.setId(id);
			calif.setAlumno(cal.getAlumno());
			calif.setMateria(cal.getMateria());
			calif.setCalificacion(cal.getCalificacion());
			calificacionesRepository.save(calif);

			return true;
		}

		else {
			return false;
		}
	}

}
