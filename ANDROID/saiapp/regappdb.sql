-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 27, 2017 at 05:33 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `regappdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `per_details`
--

CREATE TABLE `per_details` (
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(30) NOT NULL,
  `Dist` varchar(25) NOT NULL DEFAULT 'ERODE',
  `State` varchar(20) NOT NULL DEFAULT 'TAMILNADU',
  `Samiti` varchar(20) DEFAULT NULL,
  `MobilePhone` varchar(30) DEFAULT '0',
  `EmailAddress` varchar(30) DEFAULT 'example@example.com',
  `Sex` int(1) NOT NULL,
  `Partiyatra` int(1) NOT NULL,
  `Stu_Balvikas` int(1) DEFAULT NULL,
  `Guru_Balvikas` int(1) DEFAULT NULL,
  `Education` varchar(30) DEFAULT NULL,
  `Occupation` varchar(30) DEFAULT NULL,
  `Other_Skill` varchar(50) DEFAULT NULL,
  `Marital_status` varchar(10) DEFAULT 'SINGLE',
  `Age` int(3) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `interest` varchar(250) DEFAULT NULL,
  `Prev_sadhana` int(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
