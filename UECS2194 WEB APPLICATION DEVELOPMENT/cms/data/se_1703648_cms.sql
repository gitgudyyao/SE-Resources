-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 13, 2020 at 05:31 AM
-- Server version: 10.4.11-MariaDB
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
-- Database: `se_1703648_cms`
--

-- --------------------------------------------------------

--
-- Table structure for table `se_1703648_contact`
--

DROP TABLE IF EXISTS `se_1703648_contact`;
CREATE TABLE IF NOT EXISTS `se_1703648_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) DEFAULT NULL,
  `Email` varchar(255) DEFAULT NULL,
  `Title` varchar(255) DEFAULT NULL,
  `Message` text DEFAULT NULL,
  `status` enum('0','1') DEFAULT NULL,
  `date` date NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `se_1703648_contact`
--

INSERT INTO `se_1703648_contact` (`id`, `Name`, `Email`, `Title`, `Message`, `status`, `date`) VALUES
(1, 'Ali', 'bruh@gmail.com', 'Don\'t give up!', 'you can do it!', NULL, '2020-05-13'),
(2, 'Abu', 'Abu@g.com', 'Hi', 'hi', NULL, '2020-05-13'),
(3, 'Akau', 'Akau@G.BOM', 'Bye', 'bye', NULL, '2020-05-13'),
(4, 'Bob', '330@gmail.com', 'Good day ', 'have a good day', NULL, '2020-05-13'),
(5, 'Tyrone', 'ty@gmail.com', 'tyrone', 'tyrone tyrone', NULL, '2020-05-13'),
(6, 'Newton', 'nw@gmail.com', 'Bro', 'have u tried the quote generator?', NULL, '2020-05-13'),
(7, 'Hardeep', 'T@GMAIL.com', 'Don\'t test me', 'I go', NULL, '2020-05-13'),
(8, 'Steven', 'asdf@gmail.com', 'Steve', 'Stevie', NULL, '2020-05-13'),
(9, 'Abdullah', 'goog@gmail.com', 'Return', 'return my book', NULL, '2020-05-13'),
(10, 'Buddy', 'brara@gmail.com', 'Hi', 'Bye', NULL, '2020-05-13'),
(11, 'InternetGuy', 'IG@gmail.com', 'Did you?', 'Receive this?', NULL, '2020-05-13');

-- --------------------------------------------------------

--
-- Table structure for table `se_1703648_diary`
--

DROP TABLE IF EXISTS `se_1703648_diary`;
CREATE TABLE IF NOT EXISTS `se_1703648_diary` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(255) DEFAULT NULL,
  `Category` varchar(255) DEFAULT NULL,
  `Message` text DEFAULT NULL,
  `CurrentDate` date DEFAULT current_timestamp(),
  `status` enum('0','1') DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `se_1703648_diary`
--

INSERT INTO `se_1703648_diary` (`id`, `Title`, `Category`, `Message`, `CurrentDate`, `status`) VALUES
(1, 'Day 3 of MCO', 'Desperate', 'Ate my dog\'s food', '2020-03-20', NULL),
(2, 'Month 2 of MCO', 'Should I?', 'Should I eat my neighbour?', '2020-05-13', NULL),
(3, 'Day 13 of MCO', 'Really desperate', 'Ate my dog', '2020-03-30', NULL),
(4, 'Day 2 of MCO', 'Starvation', 'I have finished all my food', '2020-03-19', NULL),
(5, 'Day 1 of MCO', 'Buying Food', 'Bought enough food for 30 days', '2020-03-18', NULL),
(7, 'Month 1 of MCO', 'Discovery', 'you can eat grass', '2020-04-03', NULL),
(8, 'Month 2 of MCO', 'How much longer', 'i cant keep eating grass', '2020-04-20', NULL),
(9, 'Month 2 of MCO', 'Good samaritan', 'Neighbour gave me some candy', '2020-05-03', NULL),
(10, 'Month 2 of MCO', 'Candy runs out', 'this is bad', '2020-05-10', NULL);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
