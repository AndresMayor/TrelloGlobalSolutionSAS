-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 26-11-2020 a las 01:46:41
-- Versión del servidor: 10.4.16-MariaDB
-- Versión de PHP: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tareas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doingJaimeMayor`
--

CREATE TABLE `doingJaimeMayor` (
  `id` int(11) NOT NULL,
  `descripccion` varchar(100) DEFAULT NULL,
  `fecha` decimal(50,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `doingJaimeMayor`
--

INSERT INTO `doingJaimeMayor` (`id`, `descripccion`, `fecha`) VALUES
(126, 'Jugar play', '1606280400000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doneJaimeMayor`
--

CREATE TABLE `doneJaimeMayor` (
  `id` int(11) NOT NULL,
  `descripccion` varchar(100) DEFAULT NULL,
  `fecha` decimal(50,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `doneJaimeMayor`
--

INSERT INTO `doneJaimeMayor` (`id`, `descripccion`, `fecha`) VALUES
(63, 'Sustencion de liderazgo', '1606280400000'),
(65, 'Terminar Practico', '1606280400000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `toDoJaimeMayor`
--

CREATE TABLE `toDoJaimeMayor` (
  `id` int(11) NOT NULL,
  `descripccion` varchar(100) DEFAULT NULL,
  `fecha` decimal(50,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `toDoJaimeMayor`
--

INSERT INTO `toDoJaimeMayor` (`id`, `descripccion`, `fecha`) VALUES
(95, 'Domir', '1606351535757'),
(96, 'Hacer Deporte', '1606351542382');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `doingJaimeMayor`
--
ALTER TABLE `doingJaimeMayor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `doneJaimeMayor`
--
ALTER TABLE `doneJaimeMayor`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `toDoJaimeMayor`
--
ALTER TABLE `toDoJaimeMayor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `doingJaimeMayor`
--
ALTER TABLE `doingJaimeMayor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=128;

--
-- AUTO_INCREMENT de la tabla `doneJaimeMayor`
--
ALTER TABLE `doneJaimeMayor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=68;

--
-- AUTO_INCREMENT de la tabla `toDoJaimeMayor`
--
ALTER TABLE `toDoJaimeMayor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=97;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
