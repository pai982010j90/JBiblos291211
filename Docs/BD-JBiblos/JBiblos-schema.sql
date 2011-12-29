-- phpMyAdmin SQL Dump
-- version 3.3.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 30, 2011 at 08:57 PM
-- Server version: 5.1.54
-- PHP Version: 5.3.5-1ubuntu7.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jbiblos`
--
CREATE DATABASE `jbiblos` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `jbiblos`;

-- --------------------------------------------------------

--
-- Table structure for table `acceso`
--

CREATE TABLE IF NOT EXISTS `acceso` (
  `usuario_dni` int(8) unsigned zerofill NOT NULL,
  `fecha_hora_entrada` datetime NOT NULL,
  `fecha_hora_salida` datetime DEFAULT NULL,
  PRIMARY KEY (`usuario_dni`,`fecha_hora_entrada`),
  KEY `fk_acceso_usuario1` (`usuario_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='control de accesos';

--
-- Dumping data for table `acceso`
--


-- --------------------------------------------------------

--
-- Table structure for table `autor`
--

CREATE TABLE IF NOT EXISTS `autor` (
  `id_autor` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nombre_autor` varchar(35) COLLATE latin1_spanish_ci NOT NULL,
  `apellido1_autor` varchar(35) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2_autor` varchar(45) COLLATE latin1_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`id_autor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='autores' AUTO_INCREMENT=8 ;



-- --------------------------------------------------------

--
-- Table structure for table `dewey`
--

CREATE TABLE IF NOT EXISTS `dewey` (
  `categoria_dewey` smallint(3) unsigned zerofill NOT NULL,
  `nombre_categoria_dewey` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`categoria_dewey`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Clasificación decimal de Dewey\n';



-- --------------------------------------------------------

--
-- Table structure for table `editorial`
--

CREATE TABLE IF NOT EXISTS `editorial` (
  `id_editorial` smallint(5) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `nombre_editorial` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_editorial`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='tabla de editoriales' AUTO_INCREMENT=8 ;



-- --------------------------------------------------------

--
-- Table structure for table `idioma_639_1`
--

CREATE TABLE IF NOT EXISTS `idioma_639_1` (
  `id_idioma_639_1` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  `idioma_639_1` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_idioma_639_1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='tabla de idiomas';



-- --------------------------------------------------------

--
-- Table structure for table `plantilla`
--

CREATE TABLE IF NOT EXISTS `plantilla` (
  `id_plantilla` tinyint(3) unsigned NOT NULL,
  `nombre_plantilla` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_plantilla`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Plantillas de hojas de estilo CSS';



-- --------------------------------------------------------

--
-- Table structure for table `tipo`
--

CREATE TABLE IF NOT EXISTS `tipo` (
  `id_tipo_usuario` tinyint(3) unsigned NOT NULL,
  `tipo_usuario` varchar(15) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`id_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='tabla de tipo de usuarios';



-- --------------------------------------------------------

--
-- Table structure for table `titulo`
--

CREATE TABLE IF NOT EXISTS `titulo` (
  `dewey_categoria_dewey` smallint(3) unsigned zerofill NOT NULL,
  `id_apellido` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `id_titulo` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `nombre_titulo` varchar(50) COLLATE latin1_spanish_ci NOT NULL,
  `isbn` bigint(10) DEFAULT NULL,
  `fecha_publicacion` date DEFAULT NULL,
  `fecha_adquisicion` datetime DEFAULT NULL,
  `sinopsis` text COLLATE latin1_spanish_ci,
  `num_paginas` smallint(5) unsigned DEFAULT NULL,
  `edicion` tinyint(3) unsigned NOT NULL,
  `editorial_id_editorial` smallint(5) unsigned zerofill NOT NULL,
  `idioma_639_1_id_idioma_639_1` varchar(2) COLLATE latin1_spanish_ci NOT NULL,
  PRIMARY KEY (`dewey_categoria_dewey`,`id_apellido`,`id_titulo`),
  KEY `fk_ttitulo_dewey1` (`dewey_categoria_dewey`),
  KEY `fk_titulo_editorial1` (`editorial_id_editorial`),
  KEY `fk_titulo_idioma_639_11` (`idioma_639_1_id_idioma_639_1`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='titulo';


-- --------------------------------------------------------

--
-- Table structure for table `titulo_has_autor`
--

CREATE TABLE IF NOT EXISTS `titulo_has_autor` (
  `titulo_dewey_categoria_dewey` smallint(3) unsigned zerofill NOT NULL,
  `titulo_id_apellido` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `titulo_id_titulo` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `autor_id_autor` smallint(5) unsigned NOT NULL,
  PRIMARY KEY (`titulo_dewey_categoria_dewey`,`titulo_id_apellido`,`titulo_id_titulo`,`autor_id_autor`),
  KEY `fk_titulo_has_autor_autor1` (`autor_id_autor`),
  KEY `fk_titulo_has_autor_titulo1` (`titulo_dewey_categoria_dewey`,`titulo_id_apellido`,`titulo_id_titulo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;


-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `dni` int(8) unsigned zerofill NOT NULL,
  `clave` varchar(10) COLLATE latin1_spanish_ci NOT NULL,
  `nombre_usuario` varchar(25) COLLATE latin1_spanish_ci NOT NULL,
  `apellido1_usuario` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `apellido2_usuario` varchar(30) COLLATE latin1_spanish_ci DEFAULT NULL,
  `email` varchar(30) COLLATE latin1_spanish_ci NOT NULL,
  `telefono` int(13) NOT NULL,
  `direccion` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `plantilla_id_plantilla` tinyint(3) unsigned NOT NULL,
  `tipo_id_tipo_usuario` tinyint(3) unsigned NOT NULL,
  `isAdministrador` tinyint(1) NOT NULL,
  PRIMARY KEY (`dni`),
  KEY `fk_usuario_plantilla1` (`plantilla_id_plantilla`),
  KEY `fk_usuario_tipo1` (`tipo_id_tipo_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci COMMENT='Tabla donde se guardan todos los usuarios, tanto lectores co';


-- --------------------------------------------------------

--
-- Table structure for table `usuario_has_titulo`
--

CREATE TABLE IF NOT EXISTS `usuario_has_titulo` (
  `usuario_dni` int(8) unsigned zerofill NOT NULL,
  `titulo_dewey_categoria_dewey` smallint(3) unsigned zerofill NOT NULL,
  `titulo_id_apellido` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `titulo_id_titulo` varchar(3) COLLATE latin1_spanish_ci NOT NULL,
  `fecha_hora_prestamo` datetime NOT NULL,
  `fecha_hora_devolucion_propuesta` datetime NOT NULL,
  `fecha_hora_devolucion_efectiva` datetime DEFAULT NULL,
  PRIMARY KEY (`usuario_dni`,`titulo_dewey_categoria_dewey`,`titulo_id_apellido`,`titulo_id_titulo`),
  KEY `fk_usuario_has_titulo_titulo1` (`titulo_dewey_categoria_dewey`,`titulo_id_apellido`,`titulo_id_titulo`),
  KEY `fk_usuario_has_titulo_usuario1` (`usuario_dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;




--
-- Constraints for dumped tables
--

--
-- Constraints for table `acceso`
--
ALTER TABLE `acceso`
  ADD CONSTRAINT `fk_acceso_usuario1` FOREIGN KEY (`usuario_dni`) REFERENCES `usuario` (`dni`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `titulo`
--
ALTER TABLE `titulo`
  ADD CONSTRAINT `fk_titulo_editorial1` FOREIGN KEY (`editorial_id_editorial`) REFERENCES `editorial` (`id_editorial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_titulo_idioma_639_11` FOREIGN KEY (`idioma_639_1_id_idioma_639_1`) REFERENCES `idioma_639_1` (`id_idioma_639_1`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_ttitulo_dewey1` FOREIGN KEY (`dewey_categoria_dewey`) REFERENCES `dewey` (`categoria_dewey`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `titulo_has_autor`
--
ALTER TABLE `titulo_has_autor`
  ADD CONSTRAINT `fk_titulo_has_autor_autor1` FOREIGN KEY (`autor_id_autor`) REFERENCES `autor` (`id_autor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_titulo_has_autor_titulo1` FOREIGN KEY (`titulo_dewey_categoria_dewey`, `titulo_id_apellido`, `titulo_id_titulo`) REFERENCES `titulo` (`dewey_categoria_dewey`, `id_apellido`, `id_titulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `fk_usuario_plantilla1` FOREIGN KEY (`plantilla_id_plantilla`) REFERENCES `plantilla` (`id_plantilla`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_usuario_tipo1` FOREIGN KEY (`tipo_id_tipo_usuario`) REFERENCES `tipo` (`id_tipo_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `usuario_has_titulo`
--
ALTER TABLE `usuario_has_titulo`
  ADD CONSTRAINT `fk_usuario_has_titulo_titulo1` FOREIGN KEY (`titulo_dewey_categoria_dewey`, `titulo_id_apellido`, `titulo_id_titulo`) REFERENCES `titulo` (`dewey_categoria_dewey`, `id_apellido`, `id_titulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_usuario_has_titulo_usuario1` FOREIGN KEY (`usuario_dni`) REFERENCES `usuario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;
