-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 20, 2024 at 12:03 PM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlycuahangchay`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
CREATE TABLE IF NOT EXISTS `chitiethoadon` (
  `macthd` int NOT NULL AUTO_INCREMENT,
  `mahd` varchar(10) NOT NULL,
  `masp` varchar(10) NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `soluong` int NOT NULL,
  `dongia` float NOT NULL,
  `thanhtien` float NOT NULL,
  PRIMARY KEY (`macthd`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `chitiethoadon`
--

INSERT INTO `chitiethoadon` (`macthd`, `mahd`, `masp`, `tensp`, `soluong`, `dongia`, `thanhtien`) VALUES
(1, 'HD01', 'SP01', 'Tàu hủ chay', 10, 1000, 10000),
(2, 'HD01', 'SP02', 'Hủ tiếu chay', 12, 1000, 12000),
(6, 'HD04', 'SP03', 'Ruốc chay', 23, 1000, 23000),
(5, 'HD04', 'SP02', 'Hủ tiếu chay', 12, 1000, 12000),
(7, 'HD03', 'SP02', 'Hủ tiếu chay', 24, 1000, 24000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
