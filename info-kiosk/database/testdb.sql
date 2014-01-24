-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2014 at 09:21 PM
-- Server version: 5.5.34
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `testdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `ekthemata`
--

CREATE TABLE IF NOT EXISTS `ekthemata` (
  `id` int(11) NOT NULL,
  `onoma` varchar(30) CHARACTER SET greek COLLATE greek_bin NOT NULL,
  `aithousa` int(11) NOT NULL,
  `plirofories` text CHARACTER SET greek COLLATE greek_bin NOT NULL,
  `image` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ekthemata`
--

INSERT INTO `ekthemata` (`id`, `onoma`, `aithousa`, `plirofories`, `image`) VALUES
(1, 'Απολίθωμα φοιτητή ΤΕΙ Πειραιά', 1, 'Πρέπει κάποια στιγμή <br> να πάρει πτυχίο.', 'dinoauctionsama.jpg'),
(2, 'Σκελετός Tυραννόσαυρου Ρεξ ', 1, 'Ο Τυραννόσαυρος είναι γένος θηριόποδου <br>δεινόσαυρου. Έζησε σε όλη την περιοχή<br> της σημερινής δυτικής Βόρειας Αμερικής.', 'dinoauctionsama.jpg'),
(485, 'Test', 1, 'jJunit Testing', 'testimage.jpg'),
(538, 'Test2', 1, 'jUnit test', 'testimage.jpg');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
