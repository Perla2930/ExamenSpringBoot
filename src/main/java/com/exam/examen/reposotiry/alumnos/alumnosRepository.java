package com.exam.examen.reposotiry.alumnos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.exam.examen.entitys.alumnos;

import java.util.Optional;

@Repository
public interface alumnosRepository extends JpaRepository<alumnos, Integer> {

}
