-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 27/02/2020 às 11:56
-- Versão do servidor: 10.4.11-MariaDB
-- Versão do PHP: 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `udemy`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `address`
--

CREATE TABLE `address` (
  `id` int(11) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `optional_information` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `address`
--

INSERT INTO `address` (`id`, `number`, `optional_information`, `street`, `zipcode`, `city_id`, `customer_id`) VALUES
(1, '1', 'apt 202', 'Street customer One', '4250281', 1, 1),
(2, '12', 'apt 2021', 'Street customer One', '4250281', 1, 1),
(3, '3', 'apt 2022', 'Street customer Two', '4250281', 2, 2),
(4, '12', 'apt 2021', 'Street customer Two', '4250281', 2, 2),
(5, '1', 'apt 202', 'Street customer One', '4250281', 6, 3),
(6, '12', 'apt 2021', 'Street customer One', '4250281', 6, 3),
(7, '3', 'apt 2022', 'Street customer Two', '4250281', 7, 4),
(8, '12', 'apt 2021', 'Street customer Two', '4250281', 7, 4),
(9, '1', 'apt 202', 'Street customer One', '4250281', 11, 5),
(10, '12', 'apt 2021', 'Street customer One', '4250281', 11, 5),
(11, '3', 'apt 2022', 'Street customer Two', '4250281', 12, 6),
(12, '12', 'apt 2021', 'Street customer Two', '4250281', 12, 6),
(13, '1', 'apt 202', 'Street customer One', '4250281', 16, 7),
(14, '12', 'apt 2021', 'Street customer One', '4250281', 16, 7),
(15, '3', 'apt 2022', 'Street customer Two', '4250281', 17, 8),
(16, '12', 'apt 2021', 'Street customer Two', '4250281', 17, 8),
(17, '1', 'apt 202', 'Street customer One', '4250281', 21, 9),
(18, '12', 'apt 2021', 'Street customer One', '4250281', 21, 9),
(19, '3', 'apt 2022', 'Street customer Two', '4250281', 22, 10),
(20, '12', 'apt 2021', 'Street customer Two', '4250281', 22, 10),
(21, '1', 'apt 202', 'Street customer One', '4250281', 26, 11),
(22, '12', 'apt 2021', 'Street customer One', '4250281', 26, 11),
(23, '3', 'apt 2022', 'Street customer Two', '4250281', 27, 12),
(24, '12', 'apt 2021', 'Street customer Two', '4250281', 27, 12),
(25, '1', 'apt 202', 'Street customer One', '4250281', 31, 13),
(26, '12', 'apt 2021', 'Street customer One', '4250281', 31, 13),
(27, '3', 'apt 2022', 'Street customer Two', '4250281', 32, 14),
(28, '12', 'apt 2021', 'Street customer Two', '4250281', 32, 14),
(29, '1', 'apt 202', 'Street customer One', '4250281', 36, 15),
(30, '12', 'apt 2021', 'Street customer One', '4250281', 36, 15),
(31, '3', 'apt 2022', 'Street customer Two', '4250281', 37, 16),
(32, '12', 'apt 2021', 'Street customer Two', '4250281', 37, 16),
(33, '1', 'apt 202', 'Street customer One', '4250281', 41, 17),
(34, '12', 'apt 2021', 'Street customer One', '4250281', 41, 17),
(35, '3', 'apt 2022', 'Street customer Two', '4250281', 42, 18),
(36, '12', 'apt 2021', 'Street customer Two', '4250281', 42, 18),
(37, '1', 'apt 202', 'Street customer One', '4250281', 46, 19),
(38, '12', 'apt 2021', 'Street customer One', '4250281', 46, 19),
(39, '3', 'apt 2022', 'Street customer Two', '4250281', 47, 20),
(40, '12', 'apt 2021', 'Street customer Two', '4250281', 47, 20);

-- --------------------------------------------------------

--
-- Estrutura para tabela `address_seq`
--

CREATE TABLE `address_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `address_seq`
--

INSERT INTO `address_seq` (`next_val`) VALUES
(41);

-- --------------------------------------------------------

--
-- Estrutura para tabela `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `category`
--

INSERT INTO `category` (`id`, `description`, `name`) VALUES
(1, 'office description', 'Office'),
(2, 'Tecnology description', 'Tecnology'),
(3, 'office description', 'Office'),
(4, 'Tecnology description', 'Tecnology'),
(5, 'office description', 'Office'),
(6, 'Tecnology description', 'Tecnology'),
(7, 'office description', 'Office'),
(8, 'Tecnology description', 'Tecnology'),
(9, 'office description', 'Office'),
(10, 'Tecnology description', 'Tecnology'),
(11, 'office description', 'Office'),
(12, 'Tecnology description', 'Tecnology'),
(13, 'office description', 'Office'),
(14, 'Tecnology description', 'Tecnology'),
(15, 'office description', 'Office'),
(16, 'Tecnology description', 'Tecnology'),
(17, 'office description', 'Office'),
(18, 'Tecnology description', 'Tecnology'),
(19, 'office description', 'Office'),
(20, 'Tecnology description', 'Tecnology');

-- --------------------------------------------------------

--
-- Estrutura para tabela `category_seq`
--

CREATE TABLE `category_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `category_seq`
--

INSERT INTO `category_seq` (`next_val`) VALUES
(21);

-- --------------------------------------------------------

--
-- Estrutura para tabela `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `province_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `city`
--

INSERT INTO `city` (`id`, `name`, `province_id`) VALUES
(1, 'Paranhos', 1),
(2, 'Maia', 1),
(3, 'Cedofeita', 1),
(4, 'Ilhavo', 2),
(5, 'Gafanha', 2),
(6, 'Paranhos', 3),
(7, 'Maia', 3),
(8, 'Cedofeita', 3),
(9, 'Ilhavo', 4),
(10, 'Gafanha', 4),
(11, 'Paranhos', 5),
(12, 'Maia', 5),
(13, 'Cedofeita', 5),
(14, 'Ilhavo', 6),
(15, 'Gafanha', 6),
(16, 'Paranhos', 7),
(17, 'Maia', 7),
(18, 'Cedofeita', 7),
(19, 'Ilhavo', 8),
(20, 'Gafanha', 8),
(21, 'Paranhos', 9),
(22, 'Maia', 9),
(23, 'Cedofeita', 9),
(24, 'Ilhavo', 10),
(25, 'Gafanha', 10),
(26, 'Paranhos', 11),
(27, 'Maia', 11),
(28, 'Cedofeita', 11),
(29, 'Ilhavo', 12),
(30, 'Gafanha', 12),
(31, 'Paranhos', 13),
(32, 'Maia', 13),
(33, 'Cedofeita', 13),
(34, 'Ilhavo', 14),
(35, 'Gafanha', 14),
(36, 'Paranhos', 15),
(37, 'Maia', 15),
(38, 'Cedofeita', 15),
(39, 'Ilhavo', 16),
(40, 'Gafanha', 16),
(41, 'Paranhos', 17),
(42, 'Maia', 17),
(43, 'Cedofeita', 17),
(44, 'Ilhavo', 18),
(45, 'Gafanha', 18),
(46, 'Paranhos', 19),
(47, 'Maia', 19),
(48, 'Cedofeita', 19),
(49, 'Ilhavo', 20),
(50, 'Gafanha', 20);

-- --------------------------------------------------------

--
-- Estrutura para tabela `city_seq`
--

CREATE TABLE `city_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `city_seq`
--

INSERT INTO `city_seq` (`next_val`) VALUES
(51);

-- --------------------------------------------------------

--
-- Estrutura para tabela `contacts`
--

CREATE TABLE `contacts` (
  `customer_id` int(11) NOT NULL,
  `contacts` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `contacts`
--

INSERT INTO `contacts` (`customer_id`, `contacts`) VALUES
(1, '123456'),
(1, '212221212'),
(3, '123456'),
(3, '212221212'),
(5, '123456'),
(5, '212221212'),
(7, '123456'),
(7, '212221212'),
(9, '123456'),
(9, '212221212'),
(11, '123456'),
(11, '212221212'),
(13, '123456'),
(13, '212221212'),
(15, '123456'),
(15, '212221212'),
(17, '123456'),
(17, '212221212'),
(19, '123456'),
(19, '212221212');

-- --------------------------------------------------------

--
-- Estrutura para tabela `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_type` int(11) DEFAULT NULL,
  `document` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `customer`
--

INSERT INTO `customer` (`id`, `customer_type`, `document`, `email`, `name`) VALUES
(1, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(2, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(3, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(4, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(5, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(6, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(7, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(8, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(9, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(10, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(11, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(12, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(13, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(14, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(15, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(16, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(17, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(18, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two'),
(19, 1, '01010101010', 'customerOne@mail.com', 'customer_one'),
(20, 2, '10101010101', 'customerTwo@mail.com', 'customer_Two');

-- --------------------------------------------------------

--
-- Estrutura para tabela `customer_seq`
--

CREATE TABLE `customer_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `customer_seq`
--

INSERT INTO `customer_seq` (`next_val`) VALUES
(21);

-- --------------------------------------------------------

--
-- Estrutura para tabela `ordered`
--

CREATE TABLE `ordered` (
  `id` int(11) NOT NULL,
  `orderem_time` datetime DEFAULT NULL,
  `adress_id` int(11) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `ordered`
--

INSERT INTO `ordered` (`id`, `orderem_time`, `adress_id`, `customer_id`) VALUES
(1, '2017-09-30 10:32:00', 2, 1),
(2, '2017-08-30 10:32:00', 1, 1),
(3, '2017-10-30 10:32:00', 3, 2),
(4, '2017-09-30 10:32:00', 4, 2),
(5, '2017-09-30 10:32:00', 6, 3),
(6, '2017-08-30 10:32:00', 5, 3),
(7, '2017-10-30 10:32:00', 7, 4),
(8, '2017-09-30 10:32:00', 8, 4),
(9, '2017-09-30 10:32:00', 10, 5),
(10, '2017-08-30 10:32:00', 9, 5),
(11, '2017-10-30 10:32:00', 11, 6),
(12, '2017-09-30 10:32:00', 12, 6),
(13, '2017-09-30 10:32:00', 14, 7),
(14, '2017-08-30 10:32:00', 13, 7),
(15, '2017-10-30 10:32:00', 15, 8),
(16, '2017-09-30 10:32:00', 16, 8),
(17, '2017-09-30 10:32:00', 18, 9),
(18, '2017-08-30 10:32:00', 17, 9),
(19, '2017-10-30 10:32:00', 19, 10),
(20, '2017-09-30 10:32:00', 20, 10),
(21, '2017-09-30 10:32:00', 22, 11),
(22, '2017-08-30 10:32:00', 21, 11),
(23, '2017-10-30 10:32:00', 23, 12),
(24, '2017-09-30 10:32:00', 24, 12),
(25, '2017-09-30 10:32:00', 26, 13),
(26, '2017-08-30 10:32:00', 25, 13),
(27, '2017-10-30 10:32:00', 27, 14),
(28, '2017-09-30 10:32:00', 28, 14),
(29, '2017-09-30 10:32:00', 30, 15),
(30, '2017-08-30 10:32:00', 29, 15),
(31, '2017-10-30 10:32:00', 31, 16),
(32, '2017-09-30 10:32:00', 32, 16),
(33, '2017-09-30 10:32:00', 34, 17),
(34, '2017-08-30 10:32:00', 33, 17),
(35, '2017-10-30 10:32:00', 35, 18),
(36, '2017-09-30 10:32:00', 36, 18),
(37, '2017-09-30 10:32:00', 38, 19),
(38, '2017-08-30 10:32:00', 37, 19),
(39, '2017-10-30 10:32:00', 39, 20),
(40, '2017-09-30 10:32:00', 40, 20);

-- --------------------------------------------------------

--
-- Estrutura para tabela `payment`
--

CREATE TABLE `payment` (
  `ordered_id` int(11) NOT NULL,
  `status` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `payment`
--

INSERT INTO `payment` (`ordered_id`, `status`) VALUES
(1, 1),
(2, 2),
(5, 1),
(6, 2),
(9, 1),
(10, 2),
(13, 1),
(14, 2),
(17, 1),
(18, 2),
(21, 1),
(22, 2),
(25, 1),
(26, 2),
(29, 1),
(30, 2),
(33, 1),
(34, 2),
(37, 1),
(38, 2);

-- --------------------------------------------------------

--
-- Estrutura para tabela `payment_billet`
--

CREATE TABLE `payment_billet` (
  `date_of_payment` datetime DEFAULT NULL,
  `limit_date_of_payment` datetime DEFAULT NULL,
  `ordered_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `payment_billet`
--

INSERT INTO `payment_billet` (`date_of_payment`, `limit_date_of_payment`, `ordered_id`) VALUES
(NULL, '2017-09-30 10:32:00', 2),
(NULL, '2017-09-30 10:32:00', 6),
(NULL, '2017-09-30 10:32:00', 10),
(NULL, '2017-09-30 10:32:00', 14),
(NULL, '2017-09-30 10:32:00', 18),
(NULL, '2017-09-30 10:32:00', 22),
(NULL, '2017-09-30 10:32:00', 26),
(NULL, '2017-09-30 10:32:00', 30),
(NULL, '2017-09-30 10:32:00', 34),
(NULL, '2017-09-30 10:32:00', 38);

-- --------------------------------------------------------

--
-- Estrutura para tabela `payment_card`
--

CREATE TABLE `payment_card` (
  `parcel_time` int(11) DEFAULT NULL,
  `ordered_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `payment_card`
--

INSERT INTO `payment_card` (`parcel_time`, `ordered_id`) VALUES
(6, 1),
(6, 5),
(6, 9),
(6, 13),
(6, 17),
(6, 21),
(6, 25),
(6, 29),
(6, 33),
(6, 37);

-- --------------------------------------------------------

--
-- Estrutura para tabela `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `product`
--

INSERT INTO `product` (`id`, `name`, `price`) VALUES
(1, 'Computer', 2000),
(2, 'Printer', 400),
(3, 'chair', 40),
(4, 'Computer', 2000),
(5, 'Printer', 400),
(6, 'chair', 40),
(7, 'Computer', 2000),
(8, 'Printer', 400),
(9, 'chair', 40),
(10, 'Computer', 2000),
(11, 'Printer', 400),
(12, 'chair', 40),
(13, 'Computer', 2000),
(14, 'Printer', 400),
(15, 'chair', 40),
(16, 'Computer', 2000),
(17, 'Printer', 400),
(18, 'chair', 40),
(19, 'Computer', 2000),
(20, 'Printer', 400),
(21, 'chair', 40),
(22, 'Computer', 2000),
(23, 'Printer', 400),
(24, 'chair', 40),
(25, 'Computer', 2000),
(26, 'Printer', 400),
(27, 'chair', 40),
(28, 'Computer', 2000),
(29, 'Printer', 400),
(30, 'chair', 40);

-- --------------------------------------------------------

--
-- Estrutura para tabela `product_category`
--

CREATE TABLE `product_category` (
  `product_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `product_category`
--

INSERT INTO `product_category` (`product_id`, `category_id`) VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(4, 3),
(5, 3),
(5, 4),
(6, 3),
(7, 5),
(8, 5),
(8, 6),
(9, 5),
(10, 7),
(11, 7),
(11, 8),
(12, 7),
(13, 9),
(14, 9),
(14, 10),
(15, 9),
(16, 11),
(17, 11),
(17, 12),
(18, 11),
(19, 13),
(20, 13),
(20, 14),
(21, 13),
(22, 15),
(23, 15),
(23, 16),
(24, 15),
(25, 17),
(26, 17),
(26, 18),
(27, 17),
(28, 19),
(29, 19),
(29, 20),
(30, 19);

-- --------------------------------------------------------

--
-- Estrutura para tabela `product_ordered`
--

CREATE TABLE `product_ordered` (
  `discount` double DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_id` int(11) NOT NULL,
  `ordered_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `product_ordered`
--

INSERT INTO `product_ordered` (`discount`, `number`, `price`, `product_id`, `ordered_id`) VALUES
(0, 1, 2000, 1, 1),
(0, 1, 80, 3, 1),
(100, 1, 800, 2, 2),
(0, 1, 2000, 4, 5),
(0, 1, 80, 6, 5),
(100, 1, 800, 5, 6),
(0, 1, 2000, 7, 9),
(0, 1, 80, 9, 9),
(100, 1, 800, 8, 10),
(0, 1, 2000, 10, 13),
(0, 1, 80, 12, 13),
(100, 1, 800, 11, 14),
(0, 1, 2000, 13, 17),
(0, 1, 80, 15, 17),
(100, 1, 800, 14, 18),
(0, 1, 2000, 16, 21),
(0, 1, 80, 18, 21),
(100, 1, 800, 17, 22),
(0, 1, 2000, 19, 25),
(0, 1, 80, 21, 25),
(100, 1, 800, 20, 26),
(0, 1, 2000, 22, 29),
(0, 1, 80, 24, 29),
(100, 1, 800, 23, 30),
(0, 1, 2000, 25, 33),
(0, 1, 80, 27, 33),
(100, 1, 800, 26, 34),
(0, 1, 2000, 28, 37),
(0, 1, 80, 30, 37),
(100, 1, 800, 29, 38);

-- --------------------------------------------------------

--
-- Estrutura para tabela `product_seq`
--

CREATE TABLE `product_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `product_seq`
--

INSERT INTO `product_seq` (`next_val`) VALUES
(31);

-- --------------------------------------------------------

--
-- Estrutura para tabela `province`
--

CREATE TABLE `province` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `province`
--

INSERT INTO `province` (`id`, `name`) VALUES
(1, 'Porto'),
(2, 'Aveiro'),
(3, 'Porto'),
(4, 'Aveiro'),
(5, 'Porto'),
(6, 'Aveiro'),
(7, 'Porto'),
(8, 'Aveiro'),
(9, 'Porto'),
(10, 'Aveiro'),
(11, 'Porto'),
(12, 'Aveiro'),
(13, 'Porto'),
(14, 'Aveiro'),
(15, 'Porto'),
(16, 'Aveiro'),
(17, 'Porto'),
(18, 'Aveiro'),
(19, 'Porto'),
(20, 'Aveiro');

-- --------------------------------------------------------

--
-- Estrutura para tabela `province_seq`
--

CREATE TABLE `province_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Despejando dados para a tabela `province_seq`
--

INSERT INTO `province_seq` (`next_val`) VALUES
(21);

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpo044ng5x4gynb291cv24vtea` (`city_id`),
  ADD KEY `FK93c3js0e22ll1xlu21nvrhqgg` (`customer_id`);

--
-- Índices de tabela `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKll21eddgtrjc9f40ueeouyr8f` (`province_id`);

--
-- Índices de tabela `contacts`
--
ALTER TABLE `contacts`
  ADD KEY `FKdj8o7a028419dd714jjgjh5lw` (`customer_id`);

--
-- Índices de tabela `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `ordered`
--
ALTER TABLE `ordered`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkj0ngqy8rtq1q4i10khol5te4` (`adress_id`),
  ADD KEY `FKfoh2vkayc2d3hq1grc0s5phda` (`customer_id`);

--
-- Índices de tabela `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`ordered_id`);

--
-- Índices de tabela `payment_billet`
--
ALTER TABLE `payment_billet`
  ADD PRIMARY KEY (`ordered_id`);

--
-- Índices de tabela `payment_card`
--
ALTER TABLE `payment_card`
  ADD PRIMARY KEY (`ordered_id`);

--
-- Índices de tabela `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Índices de tabela `product_category`
--
ALTER TABLE `product_category`
  ADD KEY `FKkud35ls1d40wpjb5htpp14q4e` (`category_id`),
  ADD KEY `FK2k3smhbruedlcrvu6clued06x` (`product_id`);

--
-- Índices de tabela `product_ordered`
--
ALTER TABLE `product_ordered`
  ADD PRIMARY KEY (`ordered_id`,`product_id`),
  ADD KEY `FKjlu5p24233eh82qphkngs8syh` (`product_id`);

--
-- Índices de tabela `province`
--
ALTER TABLE `province`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `ordered`
--
ALTER TABLE `ordered`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `FK93c3js0e22ll1xlu21nvrhqgg` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKpo044ng5x4gynb291cv24vtea` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`);

--
-- Restrições para tabelas `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `FKll21eddgtrjc9f40ueeouyr8f` FOREIGN KEY (`province_id`) REFERENCES `province` (`id`);

--
-- Restrições para tabelas `contacts`
--
ALTER TABLE `contacts`
  ADD CONSTRAINT `FKdj8o7a028419dd714jjgjh5lw` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`);

--
-- Restrições para tabelas `ordered`
--
ALTER TABLE `ordered`
  ADD CONSTRAINT `FKfoh2vkayc2d3hq1grc0s5phda` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `FKkj0ngqy8rtq1q4i10khol5te4` FOREIGN KEY (`adress_id`) REFERENCES `address` (`id`);

--
-- Restrições para tabelas `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `FK7qpdcpar4lev3hg5bfck9fmh9` FOREIGN KEY (`ordered_id`) REFERENCES `ordered` (`id`);

--
-- Restrições para tabelas `payment_billet`
--
ALTER TABLE `payment_billet`
  ADD CONSTRAINT `FKkkxm2rs250f03nm6k61knd4rj` FOREIGN KEY (`ordered_id`) REFERENCES `payment` (`ordered_id`);

--
-- Restrições para tabelas `payment_card`
--
ALTER TABLE `payment_card`
  ADD CONSTRAINT `FK6pnarvdymiv42xatvljp3mk0p` FOREIGN KEY (`ordered_id`) REFERENCES `payment` (`ordered_id`);

--
-- Restrições para tabelas `product_category`
--
ALTER TABLE `product_category`
  ADD CONSTRAINT `FK2k3smhbruedlcrvu6clued06x` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKkud35ls1d40wpjb5htpp14q4e` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Restrições para tabelas `product_ordered`
--
ALTER TABLE `product_ordered`
  ADD CONSTRAINT `FKjlu5p24233eh82qphkngs8syh` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `FKlu4j6x3olm5tig3ouaiavkgju` FOREIGN KEY (`ordered_id`) REFERENCES `ordered` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
