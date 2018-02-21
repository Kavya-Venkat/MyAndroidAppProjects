/*
SQLyog Community v12.4.1 (64 bit)
MySQL - 5.7.14 : Database - regappdb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`regappdb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `regappdb`;

/*Table structure for table `per_details` */

DROP TABLE IF EXISTS `per_details`;

CREATE TABLE `per_details` (
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `Address` varchar(255) NOT NULL,
  `City` varchar(50) NOT NULL,
  `Dist` varchar(25) NOT NULL DEFAULT 'ERODE',
  `State` varchar(20) NOT NULL DEFAULT 'TAMILNADU',
  `Samiti` varchar(20) DEFAULT NULL,
  `MobilePhone` varchar(12) DEFAULT '0',
  `EmailAddress` varchar(50) DEFAULT 'example@example.com',
  `Sex` int(1) NOT NULL,
  `Partiyatra` int(1) NOT NULL,
  `Stu_Balvikas` int(1) DEFAULT NULL,
  `Guru_Balvikas` int(1) DEFAULT NULL,
  `Education` varchar(50) DEFAULT NULL,
  `Occupation` varchar(50) DEFAULT NULL,
  `Other_Skill` varchar(250) DEFAULT NULL,
  `Marital_status` varchar(10) DEFAULT 'SINGLE',
  `Age` int(3) DEFAULT NULL,
  `comments` varchar(200) DEFAULT NULL,
  `interest` varchar(250) DEFAULT NULL,
  `Prev_sadhana` int(1) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `per_details` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
