CREATE DATABASE Calificaciones;
USE Calificaciones;

CREATE TABLE Lista (
  idLista INTEGER  NOT NULL AUTO_INCREMENT,
  Materia VARCHAR(50) NULL,
  Grupo VARCHAR(10) NULL,
  Semetre INTEGER  NULL,
  PRIMARY KEY(idLista)
);

CREATE TABLE Producto (
  idProducto INTEGER  NOT NULL AUTO_INCREMENT,
  Tareas VARCHAR(70) NULL,
  Calificacion INTEGER  NULL,
  PRIMARY KEY(idProducto)
);

CREATE TABLE Desempeno (
  idDesempeno INTEGER  NOT NULL AUTO_INCREMENT,
  Trabajo VARCHAR(70) NULL,
  Calificacion INT NULL,
  PRIMARY KEY(idDesempeno)
);

CREATE TABLE Actitud (
  idActitud INTEGER  NOT NULL AUTO_INCREMENT,
  Asistencia INTEGER  NULL,
  Fecha DATE NULL,
  PRIMARY KEY(idActitud)
);

CREATE TABLE Alumno (
  idAlumno INTEGER  NOT NULL AUTO_INCREMENT,
  Desempeno_idDesempeno INTEGER  NOT NULL,
  Actitud_idActitud INTEGER  NOT NULL,
  Producto_idProducto INTEGER  NOT NULL,
  Lista_idLista INTEGER  NOT NULL,
  NC INTEGER  NULL,
  Nombre VARCHAR(50) NULL,
  PRIMARY KEY(idAlumno),
  FOREIGN KEY(Lista_idLista)
    REFERENCES Lista(idLista),
  FOREIGN KEY(Producto_idProducto)
    REFERENCES Producto(idProducto),
  FOREIGN KEY(Desempeno_idDesempeno)
    REFERENCES Desempeno(idDesempeno),
  FOREIGN KEY(Actitud_idActitud)
    REFERENCES Actitud(idActitud)
);

CREATE TABLE Evaluacion_unidad (
  idEvaluacion_unidad INTEGER  NOT NULL AUTO_INCREMENT,
  Alumno_idAlumno INTEGER  NOT NULL,
  Unidad INTEGER  NULL,
  Conocimiento DOUBLE NULL,
  Producto DOUBLE NULL,
  Desempeno DOUBLE NULL,
  Actitud DOUBLE NULL,
  PRIMARY KEY(idEvaluacion_unidad),
  FOREIGN KEY(Alumno_idAlumno)
    REFERENCES Alumno(idAlumno)
);


