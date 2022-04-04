-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 29-03-2022 a las 16:55:15
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `lavadospring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `idcliente` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apaterno` varchar(50) NOT NULL,
  `amaterno` varchar(50) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `fecha_registro` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idcliente`, `nombre`, `apaterno`, `amaterno`, `direccion`, `telefono`, `correo`, `fecha_registro`, `status`) VALUES
(1, 'Adalid', 'Islas', 'Quintero', 'CALLE AGUSTIN LARA NO. 69-B	COL. EX-NORMAL TUXTEPEC', '7461202200', 'adalis52@gmail.com', '2022-03-07', 1),
(2, 'Are', 'Aguilar', 'Farias', 'BALBUENA , MEXICO , DF', '7461026590', 'arely.aguilarfarias@utxicotepec.edu.mx', '2022-03-18', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `idservicio` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `costo` double NOT NULL,
  `fecha_registro` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicio`
--

INSERT INTO `servicio` (`idservicio`, `nombre`, `costo`, `fecha_registro`, `status`) VALUES
(1, 'Lavado x', 600, '2022-03-29', 1),
(2, 'Lavado de llantas', 200, '2022-03-18', 1),
(3, 'Lavado de ventanas', 150, '2022-03-26', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajador`
--

CREATE TABLE `trabajador` (
  `idtrabajador` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `aparterno` varchar(50) NOT NULL,
  `amaterno` varchar(50) NOT NULL,
  `direccion` varchar(150) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `correo` varchar(60) NOT NULL,
  `contrasena` varchar(25) NOT NULL,
  `tipo` enum('Cajero','Lavador','') NOT NULL,
  `fecha_registro` date NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `trabajador`
--

INSERT INTO `trabajador` (`idtrabajador`, `nombre`, `aparterno`, `amaterno`, `direccion`, `telefono`, `correo`, `contrasena`, `tipo`, `fecha_registro`, `status`) VALUES
(1, 'Juanito', 'Hernandez', 'Sanchez', 'Calle Balderas #27, Centro Histórico Ciudad de México, Del. Cuauhtémoc', '5568210024', 'juanhdz@gmail.com', '12345', 'Lavador', '2022-03-18', 1),
(3, 'Jesus', 'Hernandez', 'Cruz', 'calle hadas s/n, Lazaro Cardenas Puebla', '5586421025', 'jescruz@gmail.com', '5678', 'Cajero', '2022-03-26', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculo`
--

CREATE TABLE `vehiculo` (
  `idvehiculo` int(11) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `tipo` enum('Sedan','Deportivo','Camioneta Cerrada','Tractor','Camioneta de Batea','Camion','Autobus') NOT NULL,
  `marca` enum('WV','FORD','TOYOTA','BMW','NISSAN','CHEVROLET','TESLA') NOT NULL,
  `modelo` enum('1985','1986','1987','1988','1989','1990','1991') NOT NULL,
  `color` varchar(25) NOT NULL,
  `fecha_registro` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  `idcliente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vehiculo`
--

INSERT INTO `vehiculo` (`idvehiculo`, `matricula`, `tipo`, `marca`, `modelo`, `color`, `fecha_registro`, `status`, `idcliente`) VALUES
(2, '553200', 'Camioneta Cerrada', 'FORD', '1989', 'Azul', '2022-03-26', 1, 2),
(6, '556230', 'Deportivo', 'WV', '1991', 'Rojo', '2022-03-28', 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `idventa` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `idtrabajador` int(11) NOT NULL,
  `idcajero` int(11) NOT NULL,
  `idservicio` int(11) NOT NULL,
  `idvehiculo` int(11) NOT NULL,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ventas`
--

INSERT INTO `ventas` (`idventa`, `fecha`, `idtrabajador`, `idcajero`, `idservicio`, `idvehiculo`, `status`) VALUES
(3, '2022-03-30', 1, 1, 1, 2, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`idservicio`);

--
-- Indices de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  ADD PRIMARY KEY (`idtrabajador`);

--
-- Indices de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD PRIMARY KEY (`idvehiculo`),
  ADD KEY `FK_id_cliente` (`idcliente`) USING BTREE;

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`idventa`),
  ADD UNIQUE KEY `FK_idtrabajador` (`idtrabajador`),
  ADD UNIQUE KEY `FK_idservicio` (`idservicio`),
  ADD UNIQUE KEY `FK_idvehiculo` (`idvehiculo`),
  ADD KEY `FK_idcajero` (`idcajero`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `idservicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `trabajador`
--
ALTER TABLE `trabajador`
  MODIFY `idtrabajador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  MODIFY `idvehiculo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `idventa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `vehiculo`
--
ALTER TABLE `vehiculo`
  ADD CONSTRAINT `vehiculo_ibfk_1` FOREIGN KEY (`idcliente`) REFERENCES `cliente` (`idcliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`idservicio`) REFERENCES `servicio` (`idservicio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_2` FOREIGN KEY (`idtrabajador`) REFERENCES `trabajador` (`idtrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_3` FOREIGN KEY (`idvehiculo`) REFERENCES `vehiculo` (`idvehiculo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `ventas_ibfk_4` FOREIGN KEY (`idcajero`) REFERENCES `trabajador` (`idtrabajador`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
