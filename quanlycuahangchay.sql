-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 19, 2024 at 10:10 AM
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
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
CREATE TABLE IF NOT EXISTS `hoadon` (
  `mahd` varchar(10) NOT NULL,
  `ngayxuat` date NOT NULL,
  `pttt` varchar(50) NOT NULL,
  `tongtien` float NOT NULL,
  `manv` varchar(10) NOT NULL,
  `tennv` varchar(50) NOT NULL,
  `makh` varchar(10) NOT NULL,
  `tenkh` varchar(50) NOT NULL,
  PRIMARY KEY (`mahd`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makh` varchar(10) NOT NULL,
  `tenkh` varchar(50) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `sdt` varchar(11) NOT NULL,
  PRIMARY KEY (`makh`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `khachhang`
--

INSERT INTO `khachhang` (`makh`, `tenkh`, `diachi`, `sdt`) VALUES
('KH01', 'Tèo', 'Hà nội', '0123456789'),
('KH02', 'Nhung', 'Lào Cai', '0987655555'),
('KH03', 'bbb', 'aa', 'a');

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manv` varchar(10) NOT NULL,
  `hoten` varchar(50) NOT NULL,
  `matkhau` varchar(50) NOT NULL,
  `gioitinh` varchar(20) NOT NULL,
  `ngaysinh` date NOT NULL,
  `sdt` varchar(11) NOT NULL,
  `diachi` varchar(50) NOT NULL,
  `vaitro` varchar(50) NOT NULL,
  PRIMARY KEY (`manv`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`manv`, `hoten`, `matkhau`, `gioitinh`, `ngaysinh`, `sdt`, `diachi`, `vaitro`) VALUES
('NV01', 'Trần Thanh Sơn', '123456', 'Nam', '2002-03-24', '0123456789', 'tiền giang', 'Nhân viên'),
('NV02', 'Trần Thanh Sơn5', '1234567', 'Nữ', '2002-03-23', '0123456789', 'tiền giang', 'Nhân viên'),
('NV03', 'Sơn', '123123', 'Nam', '0029-08-23', '000', 'Tiền Giang', 'Quản lý');

-- --------------------------------------------------------

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
CREATE TABLE IF NOT EXISTS `sanpham` (
  `masp` varchar(10) NOT NULL,
  `tensp` varchar(50) NOT NULL,
  `gia` float NOT NULL,
  `soluong` int NOT NULL,
  `mota` varchar(100) NOT NULL,
  PRIMARY KEY (`masp`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `sanpham`
--

INSERT INTO `sanpham` (`masp`, `tensp`, `gia`, `soluong`, `mota`) VALUES
('SP01', 'Tàu hủ chay', 5000, 20, 'rất ngon'),
('SP02', 'Hủ tiếu chay', 1000, 100, 'Ngon'),
('SP03', 'Ruốc chay', 1000, 100, 'Ngon');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
