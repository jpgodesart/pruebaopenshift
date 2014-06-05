-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-06-2014 a las 15:36:31
-- Versión del servidor: 5.6.12-log
-- Versión de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gestiontareas`
--
CREATE DATABASE IF NOT EXISTS `jpgodesart` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `jpgodesart`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(6) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `ape1` varchar(50) DEFAULT NULL,
  `ape2` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `dni` varchar(9) DEFAULT NULL,
  `numexpediente` varchar(50) DEFAULT NULL,
  `sexo` varchar(50) DEFAULT NULL,
  `domicilio` varchar(50) DEFAULT NULL,
  `codpostal` varchar(50) DEFAULT NULL,
  `poblacion` varchar(50) DEFAULT NULL,
  `provincia` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`id`, `id_usuario`, `nombre`, `ape1`, `ape2`, `email`, `dni`, `numexpediente`, `sexo`, `domicilio`, `codpostal`, `poblacion`, `provincia`, `telefono`) VALUES
(1, 1, 'Juan', 'Perez', 'Godesart', 'fgfg@hotmail.com', '22589243T', '5461325484', 'Hombre', 'Alabau', '46026', 'Valencia', 'Valencia', '638550815');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estado`
--

CREATE TABLE IF NOT EXISTS `estado` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `estado`
--

INSERT INTO `estado` (`id`, `nombre`) VALUES
(1, 'Asignada'),
(2, 'En proceso'),
(3, 'Terminada'),
(4, 'Cerrada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `id_usuario` int(6) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `ape1` varchar(50) DEFAULT NULL,
  `ape2` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`id`, `id_usuario`, `nombre`, `ape1`, `ape2`, `email`) VALUES
(1, 2, 'Profesor', 'Apeprofesor', 'Apedosprofesor', 'dfer@hotmail.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proyecto`
--

CREATE TABLE IF NOT EXISTS `proyecto` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `proyecto`
--

INSERT INTO `proyecto` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Proyecto1', 'descripcion del proyecto 1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tarea`
--

CREATE TABLE IF NOT EXISTS `tarea` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(200) DEFAULT NULL,
  `id_estado` int(6) DEFAULT NULL,
  `id_proyecto` int(6) DEFAULT NULL,
  `id_usuario` int(6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `tarea`
--

INSERT INTO `tarea` (`id`, `nombre`, `descripcion`, `id_estado`, `id_proyecto`, `id_usuario`) VALUES
(1, 'Tarea1', 'descripcion tarea1', 1, 1, 1),
(2, 'ertg', 'dfg', 2, 1, 1),
(3, 'bnmbnm', 'vbnbvn', 3, 1, 1),
(4, 'aaaaa', 'aaaaa', 4, 1, 1),
(5, 'kkkkkk', 'kkkkkk', 3, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(6) NOT NULL AUTO_INCREMENT,
  `login` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login` (`login`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `login`, `password`) VALUES
(1, 'alumno1', 'alumno1'),
(2, 'profe1', 'profe1');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
