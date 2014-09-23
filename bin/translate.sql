-- phpMyAdmin SQL Dump
-- version 3.4.10.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Sep 24, 2014 at 12:41 AM
-- Server version: 5.5.31
-- PHP Version: 5.3.10-1ubuntu3.14

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `translate`
--

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
('fact', 'කාරණාව'),
('home', 'ගෙදර'),
('rice', 'බත්'),
('mother', 'අම්මා'),
('Saman', 'සමන්'),
('father', 'තාත්තා'),
('brother', 'සහෝදරයා'),
('sister', 'සහෝදරිය'),
('Kamal', 'කමල්'),
('Nimal', 'නිමල්'),
('cat', 'පූසා');

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
  `mean` varchar(60) COLLATE utf8_bin NOT NULL,
  `I_mean` varchar(60) COLLATE utf8_bin NOT NULL,
  `we_mean` varchar(60) COLLATE utf8_bin NOT NULL,
  `root` varchar(60) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `vbp`
--

INSERT INTO `vbp` (`vb`, `mean`, `I_mean`, `we_mean`, `root`) VALUES
('go', 'යති', 'යමි', 'යමු', 'ය'),
('come', 'එති', '', '', 'එ'),
('eat', 'කති', '', '', 'ක'),
('drink', 'බොති', '', '', 'බො'),
('ride', 'පදිති', '', '', 'පදි'),
('run', 'දුවති', '', '', 'දුව'),
('read', 'කියවති', '', '', 'කියව'),
('do', 'කරති', '', '', ''),
('say', 'කියති', '', '', ''),
('get', 'ලබති', '', '', ''),
('make', 'සාදති', '', '', ''),
('know', 'දනිති', '', '', ''),
('take', 'ගනිති', '', '', ''),
('see', 'දකිති', '', '', ''),
('think', 'සිතති', '', '', ''),
('look', 'බලති', '', '', ''),
('give', 'දෙති', '', '', ''),
('use', 'පාවිච්චි කරති', '', '', ''),
('find', 'සොයති', '', '', ''),
('tell', 'කියති', '', '', ''),
('ask', 'ඉල්ලා සිටිති', '', '', ''),
('work', 'වැඩ කරති', '', '', ''),
('try', 'උත්සහ දරති', '', '', ''),
('leave', 'පිටත් වෙති', '', '', ''),
('call', 'කතා කරති', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `vbz`
--

CREATE TABLE IF NOT EXISTS `vbz` (
  `vb` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `male_mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `female_mean` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `meann` varchar(60) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vbz`
--

INSERT INTO `vbz` (`vb`, `mean`, `male_mean`, `female_mean`, `meann`) VALUES
('does', 'කරයි', 'කරන්නේය', 'කරන්නීය', 'කර'),
('says', 'කියයි', 'කියන්නේය', 'කියන්නීය', 'කිය'),
('gets', 'ලැබෙයි', '0', 'ලැබෙන්නීය', 'ලැබෙ'),
('makes', 'සකස් කරයි', '0', 'සකස් කර', 'සකස් කර'),
('goes', 'යයි', '0', 'ය', 'ය'),
('knows', 'දැන සිටියි', '0', 'දැන සිටි', 'දැන සිටි'),
('takes', 'ගනියි', '0', 'ගන්', 'ගන්'),
('sees', 'දකියි', '0', 'දකි', 'දකි'),
('comes', 'පැමිණෙයි', '0', 'පැමිණෙ', 'පැමිණෙ'),
('thinks', 'සිතයි', '0', 'සිත', 'සිත'),
('looks', 'බලයි', '0', 'බල', 'බල'),
('wants', 'අවශ්‍යයි', '0', '', ''),
('gives', 'දෙයි', '0', 'දෙ', 'දෙ'),
('uses', 'පාවිච්චි කරයි', '0', 'පාවිච්චි කර', 'පාවිච්චි කර'),
('finds', 'සොයා ගනියි', '0', 'සොයා ගන්', 'සොයා ගන්'),
('tells', 'කියයි', '0', 'කිය', 'කිය'),
('asks', 'ඉල්ලා සිටියි', '0', 'ඉල්ලා සිටි', 'ඉල්ලා සිටි'),
('works', 'වැඩ කරයි', '0', 'වැඩ කර', 'වැඩ කර'),
('feels', 'දැනෙයි', '0', 'දැනෙ', 'දැනෙ'),
('tries', 'උත්සහ දරයි', '0', 'උත්සහ දර', 'උත්සහ දර');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
