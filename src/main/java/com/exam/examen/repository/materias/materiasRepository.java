package com.exam.examen.repository.materias;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exam.examen.entitys.materias;

@Repository
public interface materiasRepository extends JpaRepository<materias, Integer> {

}
