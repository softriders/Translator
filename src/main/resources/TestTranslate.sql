-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 14, 2014 at 07:06 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `translate`
--
CREATE DATABASE IF NOT EXISTS `TestTranslate` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `TestTranslate`;

-- --------------------------------------------------------

--
-- Table structure for table `in`
--

CREATE TABLE IF NOT EXISTS `in` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `in`
--

INSERT INTO `in` (`vb`, `mean`) VALUES
('of', 'ගේ'),
('in', 'තුල'),
('to', 'ට'),
('for', 'සඳහා'),
('with', 'සමඟ'),
('on', 'උඩ'),
('at', 'ළඟ'),
('from', 'සිට'),
('by', 'විසින්'),
('about', 'ගැන'),
('as', 'ලෙස'),
('into', 'බවට'),
('like', 'වගේ'),
('through', 'අතරින්'),
('after', 'පසුව'),
('over', 'එහා'),
('between', 'අතර'),
('out', 'පිට'),
('against', 'ඉදිරිපිට'),
('during', 'අතරතුර'),
('without', 'හැර'),
('before', 'කලින්'),
('under', 'යට'),
('around', 'වටා'),
('among', 'අතර');

-- --------------------------------------------------------

--
-- Table structure for table `nn`
--

CREATE TABLE IF NOT EXISTS `nn` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nn`
--

INSERT INTO `nn` (`vb`, `mean`) VALUES
('time', 'වෙලාව'),
('person', 'පුද්ගලයා'),
('year', 'වසර'),
('way', 'මග'),
('day', 'දවස'),
('thing', 'දෙය'),
('man', 'මිනිසා'),
('world', 'ලෝකය'),
('life', 'ජීවිතය'),
('hand', 'අත'),
('part', 'කොටස'),
('child', 'ළමයා'),
('eye', 'ඇස'),
('woman', 'කාන්තාව'),
('place', 'ස්ථානය'),
('work', 'කාර්යය'),
('week', 'සතිය'),
('case', 'තත්වය'),
('point', 'කාරණය'),
('government', 'රජය'),
('company', 'වෙළඳ සමාගම'),
('number', 'අංකය'),
('group', 'කණ්ඩායම'),
('problem', 'ගැටළුව'),
('fact', 'කාරණාව');

-- --------------------------------------------------------

--
-- Table structure for table `rb`
--

CREATE TABLE IF NOT EXISTS `rb` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rb`
--

INSERT INTO `rb` (`vb`, `mean`) VALUES
('just', 'විතරයි'),
('also', 'ත්'),
('only', 'පමණයි'),
('even', 'පවා'),
('still', 'තවම'),
('always', 'සැමවිට'),
('often', 'නිතර'),
('usually', 'සාමාන්‍යයෙන්'),
('really', 'සැබැවින්ම'),
('never', 'කවදාවත්'),
('sometimes', 'බාගවිට'),
('actually', 'ඇත්තෙන්ම'),
('again', 'නැවත'),
('already', 'මේ වන විටත්'),
('quickly', 'ඉක්මනට');

-- --------------------------------------------------------

--
-- Table structure for table `vbd`
--

CREATE TABLE IF NOT EXISTS `vbd` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vbd`
--

INSERT INTO `vbd` (`vb`, `mean`) VALUES
('did', 'කලා'),
('said', 'කිව්වා'),
('got', 'ලැබුනා'),
('knew', 'දැනගත්තා'),
('took', 'ගත්තා'),
('saw', 'දැක්කා'),
('came', 'ආවා'),
('thought', 'සිතුවා'),
('looked', 'බැලුවා'),
('wanted', 'අවශ්‍ය වුනා'),
('gave', 'දුන්නා'),
('used', 'පාවිච්චි කලා'),
('found', 'සොයා ගත්තා'),
('told', 'කිව්වා'),
('asked', 'ඉල්ලා සිටියා'),
('worked', 'වැඩ කලා'),
('seemed', 'වගේ සිටියා'),
('felt', 'දැනුනා'),
('tried', 'උත්සහ දැරුවා'),
('left', 'පිටත් වුනා'),
('called', 'කතා කලා');

-- --------------------------------------------------------

--
-- Table structure for table `vbg`
--

CREATE TABLE IF NOT EXISTS `vbg` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vbg`
--

INSERT INTO `vbg` (`vb`, `mean`) VALUES
('coming', 'එමින්'),
('eating', 'කමින්'),
('drinking', 'බොමින්'),
('riding', 'පදිමින්'),
('runing', 'දුවමින්'),
('kissing', 'හාදු දෙමින්'),
('reading', 'කියවමින්'),
('going', 'යමින්'),
('talking', 'කතා කරමින්'),
('writing', 'ලියමින්'),
('saying', 'කියමින්'),
('getting', 'ලැබෙමින්'),
('doing', 'කරමින්'),
('making', 'සාදමින්'),
('taking', 'ගනිමින්'),
('seeing', 'දකිමින්'),
('thinking', 'හිතමින්'),
('looking', 'බලමින්'),
('giving', 'දෙමින්'),
('using', 'පාවිච්චි කරමින්'),
('finding', 'සොයමින්'),
('telling', 'කියමින්'),
('asking', 'ඉල්ලමින්'),
('trying', 'උත්සහ කරමින්'),
('leaving', 'පිටත් වෙමින්'),
('calling', 'කතා කරමින්');

-- --------------------------------------------------------

--
-- Table structure for table `vbn`
--

CREATE TABLE IF NOT EXISTS `vbn` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vbn`
--

INSERT INTO `vbn` (`vb`, `mean`) VALUES
('gone', 'ගොස්'),
('come', 'පැමින'),
('drunk', 'බීල'),
('read', 'කියවා'),
('had', 'තිබිල'),
('done', 'කරල'),
('said', 'කියල'),
('got', 'ලැබිල'),
('made', 'සාදල'),
('known', 'දැනගෙන'),
('taken', 'අරගෙන'),
('seen', 'දැකල'),
('thought', 'හිතල'),
('looked', 'බලල'),
('given', 'දීල'),
('used', 'පාවිච්චි කරල'),
('found', 'සොයා'),
('told', 'කියල'),
('asked', 'ඉල්ලලා'),
('worked', 'වැඩ කරල'),
('felt', 'දැනිල'),
('tried', 'උත්සහ දරල'),
('left', 'පිටත් වෙලා'),
('called', 'කතා කරල'),
('eaten', 'කාල');

-- --------------------------------------------------------

--
-- Table structure for table `vbp`
--

CREATE TABLE IF NOT EXISTS `vbp` (
  `vb` varchar(50) COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vbp`
--

INSERT INTO `vbp` (`vb`, `mean`) VALUES
('go', 'යති'),
('come', 'එති'),
('eat', 'කති'),
('drink', 'බොති'),
('ride', 'පදිති'),
('run', 'දුවති'),
('read', 'කියවති'),
('do', 'කරති'),
('say', 'කියති'),
('get', 'ලබති'),
('make', 'සාදති'),
('know', 'දනිති'),
('take', 'ගනිති'),
('see', 'දකිති'),
('think', 'සිතති'),
('look', 'බලති'),
('give', 'දෙති'),
('use', 'පාවිච්චි කරති'),
('find', 'සොයති'),
('tell', 'කියති'),
('ask', 'ඉල්ලා සිටිති'),
('work', 'වැඩ කරති'),
('try', 'උත්සහ දරති'),
('leave', 'පිටත් වෙති'),
('call', 'කතා කරති');

-- --------------------------------------------------------

--
-- Table structure for table `vbz`
--

CREATE TABLE IF NOT EXISTS `vbz` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vbz`
--

INSERT INTO `vbz` (`vb`, `mean`) VALUES
('does', 'කරයි'),
('says', 'කියයි'),
('gets', 'ලැබෙයි'),
('makes', 'සකස් කරයි'),
('goes', 'යයි'),
('knows', 'දැන සිටියි'),
('takes', 'ගනියි'),
('sees', 'දකියි'),
('comes', 'පැමිණෙයි'),
('thinks', 'සිතයි'),
('looks', 'බලයි'),
('wants', 'අවශ්‍යයි'),
('gives', 'දෙයි'),
('uses', 'පාවිච්චි කරයි'),
('finds', 'සොයා ගනියි'),
('tells', 'කියයි'),
('asks', 'ඉල්ලා සිටියි'),
('works', 'වැඩ කරයි'),
('feels', 'දැනෙයි'),
('tries', 'උතසහ දරයි');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
