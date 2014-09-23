-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 29, 2014 at 02:54 PM
-- Server version: 5.5.37
-- PHP Version: 5.3.10-1ubuntu3.13

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `Translate`
--

-- --------------------------------------------------------

--
-- Table structure for table `VBG`
--

CREATE TABLE IF NOT EXISTS `VBG` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `VBG`
--

INSERT INTO `VBG` (`vb`, `mean`) VALUES
('coming', 'එමින්'),
('eating', 'කමින්'),
('drinking', 'බොමින්'),
('riding', 'පදිමින්'),
('runing', 'දුවමින්'),
('kissing', 'හාදු දෙමින්'),
('reading', 'කියවමින්'),
('going', 'යමින්'),
('talking', 'කතා කරමින්'),
('writing', 'ලියමින්');

-- --------------------------------------------------------

--
-- Table structure for table `VBN`
--

CREATE TABLE IF NOT EXISTS `VBN` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `VBN`
--

INSERT INTO `VBN` (`vb`, `mean`) VALUES
('gone', 'ගොස්'),
('come', 'පැමින'),
('eatten', 'කා'),
('drunk', 'බී'),
('read', 'කියවා');

-- --------------------------------------------------------

--
-- Table structure for table `VBP`
--

CREATE TABLE IF NOT EXISTS `VBP` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `VBP`
--

INSERT INTO `VBP` (`vb`, `mean`) VALUES
('go', 'යති'),
('come', 'එති');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
