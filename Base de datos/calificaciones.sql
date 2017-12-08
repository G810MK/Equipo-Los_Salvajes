-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 04-12-2017 a las 18:28:46
-- Versión del servidor: 5.7.17-log
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `calificaciones`
--
CREATE DATABASE IF NOT EXISTS `calificaciones` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `calificaciones`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actitud`
--

CREATE TABLE `actitud` (
  `idActitud` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Asistencia` int(11) NOT NULL,
  `Fecha` date NOT NULL,
  `Unidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE `alumno` (
  `idAlumno` int(11) NOT NULL,
  `Lista_idLista` int(11) NOT NULL,
  `NC` int(11) DEFAULT NULL,
  `Nombre` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `desempeno`
--

CREATE TABLE `desempeno` (
  `idDesempeno` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Trabajo` varchar(70) NOT NULL,
  `Calificacion` int(11) NOT NULL,
  `Unidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion_diagnostica`
--

CREATE TABLE `evaluacion_diagnostica` (
  `idEvaluacion_diagnostica` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Calificacion` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `evaluacion_unidad`
--

CREATE TABLE `evaluacion_unidad` (
  `idEvaluacion_unidad` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Unidad` int(11) DEFAULT NULL,
  `Conocimiento` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista`
--

CREATE TABLE `lista` (
  `idLista` int(11) NOT NULL,
  `Materia` varchar(50) DEFAULT NULL,
  `Grupo` varchar(255) DEFAULT NULL,
  `Semestre` int(11) DEFAULT NULL,
  `Carrera` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Tareas` varchar(70) NOT NULL,
  `Calificacion` int(11) NOT NULL,
  `Unidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `puntos_extras`
--

CREATE TABLE `puntos_extras` (
  `idPuntos_Extras` int(11) NOT NULL,
  `Alumno_idAlumno` int(11) NOT NULL,
  `Puntos` int(11) NOT NULL,
  `unidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actitud`
--
ALTER TABLE `actitud`
  ADD PRIMARY KEY (`idActitud`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD PRIMARY KEY (`idAlumno`),
  ADD KEY `Lista_idLista` (`Lista_idLista`);

--
-- Indices de la tabla `desempeno`
--
ALTER TABLE `desempeno`
  ADD PRIMARY KEY (`idDesempeno`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- Indices de la tabla `evaluacion_diagnostica`
--
ALTER TABLE `evaluacion_diagnostica`
  ADD PRIMARY KEY (`idEvaluacion_diagnostica`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- Indices de la tabla `evaluacion_unidad`
--
ALTER TABLE `evaluacion_unidad`
  ADD PRIMARY KEY (`idEvaluacion_unidad`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- Indices de la tabla `lista`
--
ALTER TABLE `lista`
  ADD PRIMARY KEY (`idLista`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- Indices de la tabla `puntos_extras`
--
ALTER TABLE `puntos_extras`
  ADD PRIMARY KEY (`idPuntos_Extras`),
  ADD KEY `Alumno_idAlumno` (`Alumno_idAlumno`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actitud`
--
ALTER TABLE `actitud`
  MODIFY `idActitud` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `idAlumno` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `desempeno`
--
ALTER TABLE `desempeno`
  MODIFY `idDesempeno` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `evaluacion_diagnostica`
--
ALTER TABLE `evaluacion_diagnostica`
  MODIFY `idEvaluacion_diagnostica` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `evaluacion_unidad`
--
ALTER TABLE `evaluacion_unidad`
  MODIFY `idEvaluacion_unidad` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `lista`
--
ALTER TABLE `lista`
  MODIFY `idLista` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `puntos_extras`
--
ALTER TABLE `puntos_extras`
  MODIFY `idPuntos_Extras` int(11) NOT NULL AUTO_INCREMENT;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actitud`
--
ALTER TABLE `actitud`
  ADD CONSTRAINT `actitud_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`Lista_idLista`) REFERENCES `lista` (`idLista`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `desempeno`
--
ALTER TABLE `desempeno`
  ADD CONSTRAINT `desempeno_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evaluacion_diagnostica`
--
ALTER TABLE `evaluacion_diagnostica`
  ADD CONSTRAINT `evaluacion_diagnostica_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `evaluacion_unidad`
--
ALTER TABLE `evaluacion_unidad`
  ADD CONSTRAINT `evaluacion_unidad_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `puntos_extras`
--
ALTER TABLE `puntos_extras`
  ADD CONSTRAINT `puntos_extras_ibfk_1` FOREIGN KEY (`Alumno_idAlumno`) REFERENCES `alumno` (`idAlumno`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
