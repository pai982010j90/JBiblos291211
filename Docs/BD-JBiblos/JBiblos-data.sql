--
-- Dumping data for table `autor`
--

INSERT INTO `autor` (`id_autor`, `nombre_autor`, `apellido1_autor`, `apellido2_autor`) VALUES
(1, 'Ken', 'Follet', NULL),
(2, 'Miguel', 'de Cervantes', 'Saavedra'),
(3, 'Dante', 'Alighieri', NULL),
(4, 'Julio', 'Verne', NULL),
(5, 'Franz', 'Kafka', NULL),
(6, 'Isaac', 'Asimov', NULL),
(7, 'J.K.', 'Rowlig', NULL);

--
-- Dumping data for table `dewey`
--

INSERT INTO `dewey` (`categoria_dewey`, `nombre_categoria_dewey`) VALUES
(000, 'Obras Generales'),
(100, 'Filosofía'),
(200, 'Religión'),
(300, 'Ciencias Sociales'),
(400, 'Lingüística'),
(500, 'Ciencias Puras'),
(600, 'Ciencias Aplicadas'),
(700, 'Artes y Recreación'),
(800, 'Literatura'),
(900, 'Historia');

--
-- Dumping data for table `editorial`
--

INSERT INTO `editorial` (`id_editorial`, `nombre_editorial`) VALUES
(00001, 'Planeta'),
(00002, 'Anaya'),
(00003, 'Ramón Sopena editorial S.A.'),
(00004, 'Amazon'),
(00005, 'Fantasia'),
(00006, 'schocken books'),
(00007, 'salamandra');

--
-- Dumping data for table `idioma_639_1`
--

INSERT INTO `idioma_639_1` (`id_idioma_639_1`, `idioma_639_1`) VALUES
('en', 'inglés'),
('es', 'español');


--
-- Dumping data for table `plantilla`
--

INSERT INTO `plantilla` (`id_plantilla`, `nombre_plantilla`) VALUES
(1, 'plantilla1'),
(10, 'System'),
(11, 'Motif'),
(12, 'GTK'),
(13, 'Metal');


--
-- Dumping data for table `tipo`
--

INSERT INTO `tipo` (`id_tipo_usuario`, `tipo_usuario`) VALUES
(0, 'administrador'),
(1, 'lector');


--
-- Dumping data for table `titulo`
--

INSERT INTO `titulo` (`dewey_categoria_dewey`, `id_apellido`, `id_titulo`, `nombre_titulo`, `isbn`, `fecha_publicacion`, `fecha_adquisicion`, `sinopsis`, `num_paginas`, `edicion`, `editorial_id_editorial`, `idioma_639_1_id_idioma_639_1`) VALUES
(000, 'ALI', 'THE', 'The divine comedy', 192835025, '2011-11-26', '2011-08-17 10:46:16', 'This story begins in a shadowed forest on Good Friday in the year of our Lord 1300. It proceeds on a journey that, in its intense re-creation of the depths and the heights of human experience, has become the key with which Western civilization has sought to unlock the mystery of its own identity', 259, 1, 00004, 'en'),
(000, 'DCE', 'ELI', 'El ingenioso hidalgo don Quijote de la Mancha', 8430304070, '2011-11-26', '2011-08-17 10:35:28', 'El Quijote narra la historia de un hidalgo manchego, de unos cincuenta años, que se vuelve loco por leer muchos libros de caballerías. El protagonista llega a creer que las narraciones caballerescas relatan sucesos reales, y decide salir de su aldea en busca de aventuras similares a las de sus héroes literarios con el objetivo de<<desfacer agravios, enderezar entuertos y proteger doncellas>>. En su mente, confunde la realidad y la literatura: así, la venta de un camino le parecerá un castillo; los molinos serán gigantes, y los rebaños se transformarán en ejércitos de conocidos caballeros.     ', NULL, 1, 00003, 'es'),
(100, 'KAF', 'THE', 'The Metamorphosis ', 140015728, '2011-11-26', '2011-08-17 11:01:41', NULL, 500, 2, 00006, 'en'),
(300, 'ASI', 'FUN', 'Fundación', 8422626985, '2011-11-26', '2011-08-17 11:10:23', 'Literatura inglesa. Novela. Siglo XX.', 158, 2, 00004, 'es'),
(700, 'ROW', 'HAC', 'Harry Potter y la camara secreta', 9788498382679, '2011-11-26', '2011-08-16 11:20:22', 'Segundo libro de la saga', 288, 1, 00007, 'es'),
(700, 'ROW', 'HAR', 'Harry Potter y la piedra filosofal', 9788498382662, '2011-11-26', '2011-08-15 11:16:52', 'Primer libro de la saga', 256, 1, 00007, 'es'),
(800, 'FOL', 'los', 'Los Pilares de la Tierra', NULL, NULL, NULL, NULL, NULL, 1, 00001, 'es'),
(800, 'VER', 'DEL', 'De la tierra a la luna ', 8476347804, '2011-11-26', '2011-08-17 10:56:34', 'Literatura francesa. Siglo XIX. Novelas de Aventura. Ciencia Ficción.', 221, 1, 00005, 'es'),
(800, 'VER', 'VEI', 'Veinte mil leguas de viaje submarin', 8476348630, '2011-11-26', '2011-08-17 10:53:22', 'Literatura francesa. Siglo XIX. Novelas de Aventura. Ciencia Ficción.', 221, 1, 00005, 'es');



--
-- Dumping data for table `titulo_has_autor`
--

INSERT INTO `titulo_has_autor` (`titulo_dewey_categoria_dewey`, `titulo_id_apellido`, `titulo_id_titulo`, `autor_id_autor`) VALUES
(800, 'FOL', 'LOS', 1),
(000, 'ALI', 'THE', 2),
(000, 'DCE', 'ELI', 2),
(000, 'ALI', 'THE', 3),
(800, 'VER', 'DEL', 4),
(800, 'VER', 'VEI', 4),
(100, 'KAF', 'THE', 5),
(300, 'ASI', 'FUN', 6),
(700, 'ROW', 'HAC', 7),
(700, 'ROW', 'HAR', 7);


--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`dni`, `clave`, `nombre_usuario`, `apellido1_usuario`, `apellido2_usuario`, `email`, `telefono`, `direccion`, `plantilla_id_plantilla`, `tipo_id_tipo_usuario`, `isAdministrador`) VALUES
(00000001, '1', 'lector1', 'lector1_apellido1', 'lector_apellido2', 'lector1_email', 1, 'lector1_direccion', 10, 1, 0),
(00000002, '2', 'administrador1', 'administrador1_apellido1', NULL, 'administrador1_emal', 2, 'administrador1_direccion', 12, 0, 1);


--
-- Dumping data for table `usuario_has_titulo`
--


