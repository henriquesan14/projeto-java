-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 10-Dez-2018 às 17:23
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
(45, '2018-12-10', 'Manhã', 37, 14, 2),
(46, '2018-12-20', 'Manhã', 37, 14, 2),
(47, '2018-12-11', 'Manhã', 38, 14, 2),
(48, '2018-12-03', 'Manhã', 37, 14, 2),
(49, '2018-12-03', 'Manhã', 37, 14, 2),
(50, '2018-12-03', 'Manhã', 37, 14, 2),
(51, '2018-12-03', 'Manhã', 37, 14, 2),
(52, '2018-12-03', 'Manhã', 37, 14, 2),
(53, '2018-12-03', 'Manhã', 37, 14, 2),
(54, '2018-12-03', 'Manhã', 37, 14, 2),
(55, '2018-12-03', 'Manhã', 37, 14, 2),
(56, '2018-12-03', 'Manhã', 37, 14, 2),
(57, '2018-12-03', 'Manhã', 37, 14, 2),
(60, '2018-12-10', 'Tarde', 38, 16, 2),
(61, '2018-12-10', 'Manhã', 39, 15, 2),
(62, '2018-12-10', 'Manhã', 40, 17, 2);

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
(14, 'Roberto Carlos', 'Cardiologista', '111111111111111/PB', '555.555.555-55', '(83)88888-8888'),
(15, 'Adam Levine', 'Psicologa', '22222222222/PB', '777.777.777-77', '(83)77777-7777'),
(16, 'Tim Maia', 'Nutricionista', '99999999999/PE', '333.333.333-33', '(81)99999-9999'),
(17, 'Pelé', 'Pediatra', '55555555555/PB', '777.777.777-77', '(88)77777-7777');

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
(37, 'Marcel Melo', '111111111111', '111.111.111-11', '1995-08-15', '(83)99999-9999'),
(38, 'Michael Jackson', '222222222222', '222.222.222-22', '1995-08-30', '(83)99999-9999'),
(39, 'Faustão', '333333333333', '444.444.444-44', '1900-01-01', '(83)99999-9999'),
(40, 'Raul Seixas', '777777777777', '555.555.555-55', '1800-12-17', '(89)88888-8888');

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
(2, 'henrique', 'admin', 'admin', 1, 'admin'),
(29, 'Henrique', 'user', 'user', 1, 'user');

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
  MODIFY `id_consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `medico`
--
ALTER TABLE `medico`
  MODIFY `id_medico` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id_paciente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
