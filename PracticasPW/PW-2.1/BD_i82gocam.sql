-- phpMyAdmin SQL Dump
-- version 2.7.0-pl2
-- http://www.phpmyadmin.net
-- 
-- Servidor: oraclepr.uco.es
-- Tiempo de generación: 19-08-2022 a las 13:37:06
-- Versión del servidor: 5.1.73
-- Versión de PHP: 5.3.3
-- 
-- Base de datos: `i82gocam`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Criticas`
-- 

CREATE TABLE `Criticas` (
  `id` int(6) NOT NULL,
  `puntuacion` float NOT NULL,
  `titulo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `resena` varchar(250) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `correo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `Like` int(9) NOT NULL,
  `dislike` int(9) NOT NULL,
  `idEspectaculo` int(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_Critica` (`titulo`,`id`),
  KEY `fk_Mail` (`correo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Criticas`
-- 

INSERT INTO `Criticas` VALUES (57692, 6, 'Bonito cuento', 'Me ha gustado pero es infantil', 'a@a.com', 3, 2, 17596);
INSERT INTO `Criticas` VALUES (85375, 8, 'Una pasada de Cuento de Magos', 'Ha sido una historia que me ha fascinado, estoy deseando que saquen el siguiente libro', 'hola@hola.com', 7, 1, 24623);
INSERT INTO `Criticas` VALUES (8430, 9, 'Las tecnologias son el futuro', 'Tengo mejor conocimiento sobre la tecnología, me ha encantado', 'a@a.com', 5, 3, 15887);
INSERT INTO `Criticas` VALUES (38708, 4, 'Decepcion', 'No me ha gustado mucho la verdad', 'angel@angel.com', 0, 0, 18513);
INSERT INTO `Criticas` VALUES (45178, 8, 'Gran Concierto', 'El concierto de Melendi me ha encantado, estoy deseando que vuelva por la zona', 'hola@hola.com', 0, 1, 64993);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `EspectaculoPaseMultiple`
-- 

CREATE TABLE `EspectaculoPaseMultiple` (
  `id` int(9) NOT NULL,
  `titulo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `contenido` varchar(999) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `localidadesTotales` int(6) NOT NULL,
  `localidadesVendidas` int(6) NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_Puntual` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `EspectaculoPaseMultiple`
-- 

INSERT INTO `EspectaculoPaseMultiple` VALUES (17596, 'Cuento de Hadas', 'Un cuento de hadas que hara historia', 333, 45, 'Teatro');
INSERT INTO `EspectaculoPaseMultiple` VALUES (24623, 'Cuento de Magos', 'Un peculiar cuento que te hara imaginar como nunca', 55, 20, 'Historia');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `EspectaculoPuntual`
-- 

CREATE TABLE `EspectaculoPuntual` (
  `id` int(9) NOT NULL,
  `titulo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `contenido` varchar(999) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `localidadesTotales` int(9) NOT NULL,
  `localidadesVendidas` int(9) NOT NULL,
  `fecha` datetime NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_Puntual` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `EspectaculoPuntual`
-- 

INSERT INTO `EspectaculoPuntual` VALUES (15887, 'Tecnologias del mundo', 'Se muestran las diferentes tecnologias, las cuales te pueden impresionar', 234, 123, '2022-08-12 12:53:00', 'Tecnologia');
INSERT INTO `EspectaculoPuntual` VALUES (18513, 'Circo del Sol', 'Un espectacular Circo llega a Cordoba para iluminar a las personas', 200, 50, '2022-05-05 16:08:00', 'Circo');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `EspectaculoTemporada`
-- 

CREATE TABLE `EspectaculoTemporada` (
  `id` int(9) NOT NULL,
  `titulo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `contenido` varchar(999) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `localidadesTotales` int(6) NOT NULL,
  `localidadesVendidas` int(6) NOT NULL,
  `tipo` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UC_Temp` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `EspectaculoTemporada`
-- 

INSERT INTO `EspectaculoTemporada` VALUES (13444, 'Concierto David Bisbal', 'Un concierto que disfrutaras como nadie', 100, 0, 'Concierto');
INSERT INTO `EspectaculoTemporada` VALUES (64993, 'Concierto Melendi', 'El cantante asturiano dara un concierto en Malaga el 1 de septiembre', 100, 44, 'Concierto');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Fechas`
-- 

CREATE TABLE `Fechas` (
  `id` int(9) NOT NULL,
  `fecha` datetime NOT NULL,
  PRIMARY KEY (`fecha`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Fechas`
-- 

INSERT INTO `Fechas` VALUES (62312, '2022-08-13 16:36:00');
INSERT INTO `Fechas` VALUES (54767, '2022-08-13 16:34:00');
INSERT INTO `Fechas` VALUES (30787, '2022-08-13 16:38:00');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `MultiplesFechas`
-- 

CREATE TABLE `MultiplesFechas` (
  `id` int(9) NOT NULL,
  `idFecha` int(9) NOT NULL,
  PRIMARY KEY (`idFecha`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `MultiplesFechas`
-- 

INSERT INTO `MultiplesFechas` VALUES (17596, 62312);
INSERT INTO `MultiplesFechas` VALUES (17596, 54767);
INSERT INTO `MultiplesFechas` VALUES (24623, 30787);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Pases`
-- 

CREATE TABLE `Pases` (
  `id` int(9) NOT NULL,
  `inicioFecha` datetime NOT NULL,
  `diasS` varchar(20) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `finalFecha` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Pases`
-- 

INSERT INTO `Pases` VALUES (15329, '2021-12-29 16:12:00', 'Viernes', '2022-01-19 16:10:00');
INSERT INTO `Pases` VALUES (21520, '2022-01-24 16:09:00', 'Domingo', '2022-02-18 16:09:00');
INSERT INTO `Pases` VALUES (1312, '2022-01-24 16:11:00', 'MiÃ©rcoles', '2022-03-04 16:11:00');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `PasesTemporada`
-- 

CREATE TABLE `PasesTemporada` (
  `id` int(9) NOT NULL,
  `idPase` int(9) NOT NULL,
  PRIMARY KEY (`id`,`idPase`),
  KEY `fk_paseTP` (`idPase`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `PasesTemporada`
-- 

INSERT INTO `PasesTemporada` VALUES (51023, 15329);
INSERT INTO `PasesTemporada` VALUES (51023, 21520);
INSERT INTO `PasesTemporada` VALUES (64993, 1312);

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `Usuarios`
-- 

CREATE TABLE `Usuarios` (
  `correo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `contrasena` varchar(50) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `nombre` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `nombreUsuario` varchar(100) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `tipoUsuario` varchar(10) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `horaRegistro` datetime NOT NULL,
  `ultimaConexion` datetime NOT NULL,
  PRIMARY KEY (`correo`),
  UNIQUE KEY `UC_Usuario` (`correo`,`nombreUsuario`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `Usuarios`
-- 

INSERT INTO `Usuarios` VALUES ('hola@hola.com', '1234', 'hola', 'holausuario', 'user', '2022-08-13 18:54:00', '2022-08-13 18:54:00');
INSERT INTO `Usuarios` VALUES ('a@a.com', 'a', 'a', 'ausuario', 'user', '2022-08-13 19:08:00', '2022-08-13 19:08:00');
INSERT INTO `Usuarios` VALUES ('angel@angel.com', '1234', 'Angel', 'Angelusuario', 'admin', '2022-08-13 18:44:00', '2022-08-13 18:44:00');

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `VotantesCriticas`
-- 

CREATE TABLE `VotantesCriticas` (
  `correo` varchar(99) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `id` int(6) NOT NULL,
  `voto` varchar(30) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL,
  `idVotantes` int(6) NOT NULL,
  PRIMARY KEY (`idVotantes`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- 
-- Volcar la base de datos para la tabla `VotantesCriticas`
-- 

INSERT INTO `VotantesCriticas` VALUES ('hola@hola.com', 45178, 'like', 3666);
INSERT INTO `VotantesCriticas` VALUES ('a@a.com', 57692, 'like', 19700);
INSERT INTO `VotantesCriticas` VALUES ('hola@hola.com', 85375, 'dislike', 8591);
INSERT INTO `VotantesCriticas` VALUES ('a@a.com', 8430, 'like', 20385);
