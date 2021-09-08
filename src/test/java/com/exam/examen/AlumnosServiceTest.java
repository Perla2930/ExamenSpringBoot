package com.exam.examen;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.repository.alumnos.alumnosRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@AutoConfigureTestDatabase
@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional
public class AlumnosServiceTest {



    @Autowired
    alumnosRepository alumrepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveAlumnoTest() {

        alumnos alum = alumnos.builder()
                .nombre("Pedro")
                .paterno("Ramirez")
                .materno("Martinez")
                .materia(2)
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
