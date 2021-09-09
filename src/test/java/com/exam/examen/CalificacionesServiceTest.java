package com.exam.examen;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.entitys.calificaciones;
import com.exam.examen.repository.alumnos.alumnosRepository;
import com.exam.examen.repository.calificaciones.calificacionesRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@AutoConfigureTestDatabase
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
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
        assertEquals(alum.getId(), alumRepository.findById(2).get().getId());
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
            assertEquals(calif.getId(), califRepository.findById(3).get().getId());
        }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getCalificacionesTest(){

        calificaciones calif = califRepository.findById(3).get();

        assertEquals(calif.getId(), califRepository.findById(3).get().getId());

    }

    @Test
    @Order(4)
    @Rollback(value = false)
    public void getListOfCalificaciones(){

        List<calificaciones> calif = califRepository.findAll();

        assertEquals(calif.size(), califRepository.findAll().size());

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    public void updateCalificacionesTest(){

        calificaciones calif = califRepository.getidDelete(1, 2);

        int califUpdate = califRepository.update(10,calif.getAlumno(), calif.getMateria());

        assertEquals(1,califUpdate);

    }

    @Test
    @Order(6)
    @Rollback(value = false)
    public void deleteCalificacionesTest(){

        calificaciones calif = califRepository.getidDelete(1, 2);

        califRepository.deleteById(calif.getId());

        assertFalse(califRepository.existsById(calif.getId()));

    }

}
