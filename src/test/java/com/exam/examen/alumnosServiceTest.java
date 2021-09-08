package com.exam.examen;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.reposotiry.alumnos.alumnosRepository;
import com.exam.examen.service.alumnos.alumnosService;
import com.exam.examen.service.alumnos.alumnosServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.annotation.Priority;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureTestDatabase
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class alumnosServiceTest<alumno> {



    @Autowired
    alumnosRepository alumrepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAlumnoTest() {

        alumnos alum = alumnos.builder()
                .id(1)
                .nombre("Pedro")
                .paterno("Ramirez")
                .materno("Martinez")
                .materia(1)
                .build();

        alumrepo.save(alum);

        assertEquals(alum.getId(), alumrepo.findById(1).get().getId());

    }


    @Test
    @Order(2)
    public void getAlumnoTest(){

        alumnos alum = alumrepo.findById(1).get();

        assertEquals(alum.getId(), alumrepo.findById(1).get().getId());

    }

    @Test
    @Order(3)
    public void getListOfAlumno(){

        List<alumnos>  alum = alumrepo.findAll();

        assertEquals(alum.size(), alumrepo.findAll().size());

    }

}
