CREATE schema postgres;


CREATE TABLE materias(
    id INTEGER CONSTRAINT materia_pk PRIMARY KEY,
    materia VARCHAR(255)
);

CREATE TABLE alumnos (
    id INTEGER CONSTRAINT alumno_pk PRIMARY KEY,
    nombre VARCHAR(255),
    paterno VARCHAR(255),
    materno VARCHAR(255),
    materia INTEGER REFERENCES materias(id)
);


CREATE TABLE calificaciones(
    id INTEGER CONSTRAINT calificacion_pk PRIMARY KEY,
    alumno INTEGER REFERENCES alumnos(id),
    materia INTEGER REFERENCES materias(id),
    calificacion INTEGER
);