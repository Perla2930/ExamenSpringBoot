package com.exam.examen;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.entitys.calificaciones;
import com.exam.examen.repository.alumnos.alumnosRepository;
import com.exam.examen.repository.calificaciones.calificacionesRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureTestDatabase
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CalificacionesServiceTest {


    @Autowired
    alumnosRepository alumRepository;

    @Autowired
    calificacionesRepository califRepository;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAlumnoTest() {
        alumnos alum = alumnos.builder()
                .nombre("Ad")
                .paterno("Gu")
                .materno("Ch")
                .materia(2)
                .build();
        alumRepository.save(alum);
        assertEquals(alum.getId(), alumRepository.findById(1).get().getId());
    }


    @Test
    @Order(2)
    @Rollback(value = false)
    public void saveCalificacionesTest() {
        calificaciones calif = calificaciones.builder()
                .alumno(1)
                .materia(2)
                .calificacion(8)
                .build();
            califRepository.save(calif);
            assertEquals(calif.getId(), califRepository.findById(2).get().getId());
        }

    @Test
    @Order(3)
    public void getCalificacionesTest(){

        calificaciones calif = califRepository.findById(2).get();

        assertEquals(calif.getId(), califRepository.findById(2).get().getId());

    }

}
