-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 15, 2020 at 03:36 AM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wad_ptest`
--

-- --------------------------------------------------------

--
-- Table structure for table `se_1703648_staff`
--

DROP TABLE IF EXISTS `se_1703648_staff`;
CREATE TABLE IF NOT EXISTS `se_1703648_staff` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `staffNo` varchar(9999) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `se_1703648_staff`
--

INSERT INTO `se_1703648_staff` (`id`, `staffNo`, `name`, `email`, `phone`) VALUES
(1, '1001', 'Wong Li Kheng', 'wonglk@company.my', '012-3258896'),
(2, '1025', 'Lim Wang Lei', 'limwl@company.my', ' 013-7854123'),
(3, '1030', ' Chia Liu Fang', 'chialf@company.my', '012-9721463'),
(4, '1056', 'Chong Liu Jie', 'chonglj@company.my', '019-7893024'),
(5, ' 1074', ' Ng Li Yong', 'ngly@company.my', ' 016-2143657\r\n'),
(6, ' 1117', 'Chia Zhang Jie', 'chiazj@company.my', ' 012-3322654\r\n');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
