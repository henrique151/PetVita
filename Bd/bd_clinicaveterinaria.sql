-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 31-Out-2023 às 02:14
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_clinicaveterinaria`
--
CREATE DATABASE `bd_clinicaveterinaria`;
USE `bd_clinicaveterinaria`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `animais`
--

CREATE TABLE `animais` (
  `Cod_animal` int(11) NOT NULL,
  `Cod_cliente` int(11) NOT NULL,
  `Nome_animal` varchar(100) NOT NULL,
  `DataNasc_animal` varchar(14) NOT NULL,
  `Cod_raca` int(11) NOT NULL,
  `Peso_animal` double NOT NULL,
  `Cor_animal` varchar(50) NOT NULL,
  `Sexo_animal` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `animais`
--

INSERT INTO `animais` (`Cod_animal`, `Cod_cliente`, `Nome_animal`, `DataNasc_animal`, `Cod_raca`, `Peso_animal`, `Cor_animal`, `Sexo_animal`) VALUES
(1, 1, 'Cleiton', '21/10/2000', 1, 25, 'Branco', 'Masculino'),
(2, 2, 'Messi', '11/11/2012', 2, 35, 'Preto e Cinza', 'Masculino'),
(3, 3, 'Totó', '02/10/2019', 3, 450, 'Preto e Cinza', 'Masculino'),
(6, 3, 'Luz Vermelha', '12/12/2021', 2, 42, 'Azul e Preto', 'Feminino');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cadastro`
--

CREATE TABLE `cadastro` (
  `Usuario` varchar(255) NOT NULL,
  `Senha` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cadastro`
--

INSERT INTO `cadastro` (`Usuario`, `Senha`) VALUES
('Henrique', '123'),
('Guilherme', '456'),
('João', '789'),
('a', '1'),
('b', '2'),
('a', '123'),
('b', '456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `Cod_cargo` int(11) NOT NULL,
  `Descricao_cargo` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`Cod_cargo`, `Descricao_cargo`) VALUES
(1, 'Veterinário'),
(2, 'Admin'),
(3, 'Atendente');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `Cod_cliente` int(11) NOT NULL,
  `Nome_cliente` varchar(100) NOT NULL,
  `Tel_cliente` varchar(14) NOT NULL,
  `Endereco_cliente` varchar(200) NOT NULL,
  `CPF_cliente` varchar(14) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`Cod_cliente`, `Nome_cliente`, `Tel_cliente`, `Endereco_cliente`, `CPF_cliente`) VALUES
(1, 'João Lucas', '(55)4214-8821', 'Rua do João Pedro, Lucas II N°123', '521.996.346-51'),
(2, 'Jorge de Angelis', '(55)9242-9312', 'Rua do Céu Azul', '954-551-421-03'),
(3, 'Gael Santos', '(55)8412-2123', 'Rua do São Pedro II ', '221.490.926-02');

-- --------------------------------------------------------

--
-- Estrutura da tabela `consulta`
--

CREATE TABLE `consulta` (
  `Cod_consulta` int(11) NOT NULL,
  `DataHora_consulta` varchar(20) NOT NULL,
  `Cod_animal` int(11) NOT NULL,
  `Cod_func` int(11) NOT NULL,
  `Descricao_consulta` varchar(350) NOT NULL,
  `Receita` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `consulta`
--

INSERT INTO `consulta` (`Cod_consulta`, `DataHora_consulta`, `Cod_animal`, `Cod_func`, `Descricao_consulta`, `Receita`) VALUES
(1, '29/08/2023 14:30', 1, 1, 'Na consulta levei meu cachorro, ao veterinário para seu check-up anual. O veterinário examinou-o cuidadosamente, atualizou suas vacinas e recomendou um novo tratamento para prevenção de pulgas e carrapatos. O cachorro está saudável e em ótima forma!', 'Sem problemas ao cachorro.'),
(2, '10/11/2023 16:30', 1, 1, 'Na consulta, o animal estava gravemente ferido devido a um acidente. Durante a consulta, ele sofreu uma parada cardiorrespiratória e desenvolveu coágulos em suas veias. Infelizmente, o animal faleceu rapidamente, com o momento da morte registrado às 16:17.', 'Entrar em contato com a família para dar a má notícia. '),
(5, '25/10/2022 15:20', 2, 3, 'Exame, vacinação e saúde em dia. ', 'Recomendação: dieta balanceada e exercícios.');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `Cod_func` int(11) NOT NULL,
  `Cod_cargo` int(11) NOT NULL,
  `Nome_func` varchar(100) NOT NULL,
  `CPF_func` varchar(14) NOT NULL,
  `Turno_func` varchar(30) NOT NULL,
  `DataNasc_func` varchar(14) NOT NULL,
  `Sexo_func` varchar(35) NOT NULL,
  `Endereco_func` varchar(200) NOT NULL,
  `Tel_func` varchar(14) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`Cod_func`, `Cod_cargo`, `Nome_func`, `CPF_func`, `Turno_func`, `DataNasc_func`, `Sexo_func`, `Endereco_func`, `Tel_func`) VALUES
(1, 1, 'Roberto Pereira', '213.621.512-12', 'Noite', '20/10/1998', 'Masculino', 'Rua dos Abacateiros', '(55)9121-2141'),
(2, 2, 'Bernardi Monti', '766.566.129-55', 'Manhã', '11/10/2002', 'Masculino', 'Rua do Mar Profundo', '(55)1214-2212'),
(4, 3, 'Elisa da Silva', '321.812.190-13', 'Tarde/Manhã', '31/01/1998', 'Feminino', 'Rua do Santa Cruz', '(55)9812-2412');

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE `raca` (
  `Cod_raca` int(11) NOT NULL,
  `Raca` varchar(50) NOT NULL,
  `Cod_tipo` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`Cod_raca`, `Raca`, `Cod_tipo`) VALUES
(1, 'Husky Siberiano', 1),
(2, 'Border collie', 1),
(3, 'Ashera', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tipo`
--

CREATE TABLE `tipo` (
  `Cod_tipo` int(11) NOT NULL,
  `Descricao_tipo` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `tipo`
--

INSERT INTO `tipo` (`Cod_tipo`, `Descricao_tipo`) VALUES
(1, 'Cachorro'),
(2, 'Gato');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `animais`
--
ALTER TABLE `animais`
  ADD PRIMARY KEY (`Cod_animal`);

--
-- Índices para tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`Cod_cargo`);

--
-- Índices para tabela `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Cod_cliente`);

--
-- Índices para tabela `consulta`
--
ALTER TABLE `consulta`
  ADD PRIMARY KEY (`Cod_consulta`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`Cod_func`);

--
-- Índices para tabela `raca`
--
ALTER TABLE `raca`
  ADD PRIMARY KEY (`Cod_raca`);

--
-- Índices para tabela `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`Cod_tipo`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `animais`
--
ALTER TABLE `animais`
  MODIFY `Cod_animal` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `Cod_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `cliente`
--
ALTER TABLE `cliente`
  MODIFY `Cod_cliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `consulta`
--
ALTER TABLE `consulta`
  MODIFY `Cod_consulta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `Cod_func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `raca`
--
ALTER TABLE `raca`
  MODIFY `Cod_raca` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `tipo`
--
ALTER TABLE `tipo`
  MODIFY `Cod_tipo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
