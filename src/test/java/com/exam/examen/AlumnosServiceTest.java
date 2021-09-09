package com.exam.examen;

import com.exam.examen.entitys.alumnos;
import com.exam.examen.repository.alumnos.alumnosRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    @Rollback(value = false)
    public void getAlumnoTest(){

        alumnos alum = alumrepo.findById(1).get();

        assertEquals(alum.getId(), alumrepo.findById(1).get().getId());

    }

    @Test
    @Order(3)
    @Rollback(value = false)
    public void getListOfAlumno(){

        List<alumnos>  alum = alumrepo.findAll();

        assertEquals(alum.size(), alumrepo.findAll().size());

    }

}
