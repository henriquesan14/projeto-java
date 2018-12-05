-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 05-Dez-2018 às 17:38
-- Versão do servidor: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbclinicajava`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `id_consulta` int(11) NOT NULL,
  `data_consulta` date NOT NULL,
  `turno` varchar(20) NOT NULL,
  `id_paciente_fk` int(11) NOT NULL,
  `id_medico_fk` int(11) NOT NULL,
  `id_usuario_fk` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`id_consulta`, `data_consulta`, `turno`, `id_paciente_fk`, `id_medico_fk`, `id_usuario_fk`) VALUES
(13, '2018-12-01', 'Manhã', 32, 7, 1),
(18, '2018-12-01', 'Manhã', 32, 7, 1),
(19, '2018-12-01', 'Manhã', 32, 7, 1),
(20, '2018-12-01', 'Manhã', 32, 7, 1),
(21, '2018-12-01', 'Manhã', 32, 7, 1),
(22, '2018-12-01', 'manha', 32, 7, 1),
(23, '2018-12-01', 'manha', 32, 7, 1),
(24, '2018-12-01', 'Manhã', 32, 7, 1),
(25, '2018-12-01', 'manha', 32, 7, 1),
(26, '2018-12-01', 'Manhã', 32, 7, 1),
(27, '2018-12-01', 'Manhã', 32, 7, 1),
(28, '2015-11-11', 'Manhã', 33, 7, 1),
(29, '2015-12-12', 'Manhã', 32, 7, 1),
(30, '2018-12-01', 'Manhã', 32, 7, 1),
(31, '2018-12-01', 'Manhã', 32, 7, 1),
(32, '2018-12-01', 'Manhã', 32, 7, 1),
(33, '2018-12-01', 'Manhã', 32, 7, 1),
(35, '2018-12-01', 'Noite', 32, 7, 1),
(36, '2018-12-01', 'Manhã', 32, 8, 1),
(37, '2005-02-01', 'Manhã', 32, 7, 21);

-- --------------------------------------------------------

--
-- Estrutura da tabela `medico`
--

CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL,
  `nome_medico` varchar(100) NOT NULL,
  `especialidade` varchar(100) NOT NULL,
  `crm` varchar(100) NOT NULL,
  `cpf_medico` varchar(20) NOT NULL,
  `telefone_medico` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `medico`
--

INSERT INTO `medico` (`id_medico`, `nome_medico`, `especialidade`, `crm`, `cpf_medico`, `telefone_medico`) VALUES
(7, 'jose', 'cardio', '1111', '111', '22222'),
(8, 'jose', 'cardio', '1111', '111', '22222'),
(9, 'jose', 'cardio', '1111', '111', '22222'),
(10, 'jose', 'cardio', '1111', '111', '22222'),
(11, 'jose', 'cardio', '1111', '111', '22222'),
(12, 'Serio Ramos', 'Nutri', '111111111', '111.111.111-11', '(81)99999-9999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `paciente`
--

CREATE TABLE `paciente` (
  `id_paciente` int(11) NOT NULL,
  `nome_paciente` varchar(100) NOT NULL,
  `rg` varchar(20) NOT NULL,
  `cpf_paciente` varchar(20) NOT NULL,
  `data_nascimento` date NOT NULL,
  `telefone_paciente` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `paciente`
--

INSERT INTO `paciente` (`id_paciente`, `nome_paciente`, `rg`, `cpf_paciente`, `data_nascimento`, `telefone_paciente`) VALUES
(32, 'henrique', '111111111111', '111.111.111-11', '2011-11-11', '(81)88888-8888'),
(33, 'jubileu', '222222222', '222.222.222-22', '2019-05-05', '(99)99999-9999');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nome_usuario` varchar(100) NOT NULL,
  `login` varchar(50) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `ativo` int(11) NOT NULL,
  `role` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nome_usuario`, `login`, `senha`, `ativo`, `role`) VALUES
(1, 'jose', 'juvenal', 'karla', 1, 'user'),
(2, 'henrique', 'admin', 'admin', 1, 'admin'),
(3, 'henrique', 'admin', 'admin', 1, 'admin'),
(5, 'henrique', 'admin', 'admin', 1, 'admin'),
(6, 'henrique', 'admin', 'admin', 1, 'admin'),
(7, 'henrique', 'admin', 'admin', 1, 'admin'),
(8, 'henrique', 'admin', 'admin', 1, 'admin'),
(9, 'henrique', 'admin', 'admin', 1, 'admin'),
(10, 'henrique', 'admin', 'admin', 1, 'admin'),
(11, 'henrique', 'admin', 'admin', 1, 'admin'),
(12, 'henrique', 'admin', 'admin', 1, 'admin'),
(13, 'henrique', 'admin', 'admin', 1, 'admin'),
(14, 'henrique', 'admin', 'admin', 1, 'admin'),
(15, 'henrique', 'admin', 'admin', 1, 'admin'),
(16, 'teste', 'teste', 'teste', 1, 'admin'),
(17, 'teste', 'teste', 'teste', 1, 'admin'),
(18, 'karla', 'karla', 'karla', 1, 'user'),
(19, '', '', '', 1, 'admin'),
(20, '', '', '', 1, 'user'),
(21, 'Jurema', 'jurema', '123456', 1, 'user'),
(22, 'José', 'jose', '123456', 1, 'user'),
(23, 'aaaaaa', 'aaaaa', 'aaaaaaaaa', 0, 'admin'),
(24, 'aaaaaaa', 'aaaaa', 'aaaaaaaaaaaa', 1, 'user'),
(25, 'aaaaaaaa', 'aaaaaaaa', 'aaaaaaaaaaaa', 1, 'admin'),
(26, 'aaaaaaaaa', 'aaaaaaaaaa', 'aaaaaaaaaa', 1, 'user'),
(27, 'aaaaaaaaa', 'jose1', 'aaa', 1, 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`id_consulta`);

--
-- Indexes for table `medico`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`id_medico`);

--
-- Indexes for table `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id_paciente`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `consulta`
--
ALTER TABLE `consulta`
  MODIFY `id_consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT for table `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
