-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 10, 2014 at 06:44 AM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `company`
--
CREATE DATABASE IF NOT EXISTS `company` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `company`;

-- --------------------------------------------------------

--
-- Table structure for table `calls`
--

CREATE TABLE IF NOT EXISTS `calls` (
  `tel_number` varchar(11) NOT NULL,
  `date` date NOT NULL,
  `start_time` time NOT NULL,
  `end_time` time NOT NULL,
  `call_id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`call_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=40 ;

--
-- Dumping data for table `calls`
--

INSERT INTO `calls` (`tel_number`, `date`, `start_time`, `end_time`, `call_id`) VALUES
('6938451187', '2014-07-01', '15:07:46', '16:07:55', 1),
('6938451187', '2014-06-04', '14:05:33', '15:04:23', 2),
('6938451187', '2014-01-01', '14:05:33', '15:04:23', 3),
('6938451187', '2014-03-02', '14:05:33', '15:04:23', 4),
('6938451187', '2014-10-03', '14:05:33', '15:04:23', 5),
('6938451187', '2014-11-04', '14:05:33', '15:04:23', 6),
('6938451187', '2014-12-05', '14:05:33', '15:04:23', 7),
('6938451187', '2014-07-06', '14:05:33', '15:04:23', 8),
('6938451187', '2014-07-07', '14:05:33', '15:04:23', 9),
('6938451187', '2014-07-08', '14:05:33', '15:04:23', 10),
('6938451187', '2014-02-09', '14:05:33', '15:04:23', 11),
('6938451187', '2014-06-01', '14:05:33', '15:04:23', 12),
('6938451187', '2014-06-02', '14:05:33', '15:04:23', 13),
('6938451187', '2014-04-03', '14:05:33', '15:04:23', 14),
('6938451187', '2014-05-04', '14:05:33', '15:04:23', 15),
('6974735215', '2014-01-04', '14:05:33', '16:04:23', 16),
('6974735215', '2014-02-04', '14:05:33', '17:04:23', 17),
('6974735215', '2014-03-04', '14:05:33', '18:04:23', 18),
('6974735215', '2014-04-04', '14:05:33', '19:04:23', 19),
('6974735215', '2014-05-04', '14:05:33', '18:04:23', 20),
('6974735215', '2014-06-04', '14:05:33', '17:04:23', 21),
('6974735215', '2014-07-04', '14:05:33', '15:37:23', 22),
('6974735215', '2014-08-04', '14:05:33', '15:36:23', 23),
('6974735215', '2014-09-04', '14:05:33', '15:08:23', 24),
('6974735215', '2014-10-04', '14:05:33', '15:22:23', 25),
('6974735215', '2014-11-04', '14:05:33', '20:09:23', 26),
('6974735215', '2014-12-04', '14:05:33', '15:02:23', 27),
('6974735215', '2014-01-04', '14:05:33', '16:04:23', 28),
('6974735215', '2014-02-04', '14:05:33', '17:04:23', 29),
('6974735215', '2014-03-04', '14:05:33', '18:04:23', 30),
('6974735215', '2014-04-04', '14:05:33', '19:04:23', 31),
('6974735215', '2014-05-04', '14:05:33', '18:04:23', 32),
('6974735215', '2014-06-04', '14:05:33', '17:04:23', 33),
('6974735215', '2014-07-04', '14:05:33', '15:37:23', 34),
('6974735215', '2014-08-04', '14:05:33', '15:36:23', 35),
('6974735215', '2014-09-04', '14:05:33', '15:08:23', 36),
('6974735215', '2014-10-04', '14:05:33', '15:22:23', 37),
('6974735215', '2014-11-04', '14:05:33', '20:09:23', 38),
('6974735215', '2014-12-04', '14:05:33', '15:02:23', 39);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `tel_number` varchar(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `surname` varchar(20) NOT NULL,
  PRIMARY KEY (`tel_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`tel_number`, `name`, `surname`) VALUES
('6938451187', 'NIKITAS', 'MAHMUDIS'),
('6974735215', 'KONSTANTINA', 'BINIARI'),
('6991716555', 'RAFALEA', 'THEA');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;