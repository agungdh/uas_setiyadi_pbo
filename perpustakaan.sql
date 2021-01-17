-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 17, 2021 at 09:23 AM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.3.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Table structure for table `buku`
--

CREATE TABLE `buku` (
  `kode` varchar(5) NOT NULL,
  `judul` varchar(100) NOT NULL,
  `penulis` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `buku`
--

INSERT INTO `buku` (`kode`, `judul`, `penulis`, `penerbit`) VALUES
('PBO1', 'Pemrograman Berbasis Objek dengan Java', 'Sandri', 'Setiyadi'),
('PBO2', 'Pemrograman Berbasis Objek dengan PHP', 'Setiyadi', 'Sandri');

-- --------------------------------------------------------

--
-- Table structure for table `peminjam`
--

CREATE TABLE `peminjam` (
  `kode` varchar(8) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjam`
--

INSERT INTO `peminjam` (`kode`, `nama`) VALUES
('11', 'Say'),
('11 2', 'Say dd'),
('11 2 3', 'Say dd 4'),
('2', '44');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id` int(11) NOT NULL,
  `kode_peminjam` varchar(8) NOT NULL,
  `kode_buku` varchar(5) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id`, `kode_peminjam`, `kode_buku`, `tanggal`) VALUES
(1, '11', 'PBO1', '2021-12-31'),
(2, '11 2', 'PBO1', '2021-12-31'),
(4, '11 2', 'PBO1', '2021-12-31'),
(6, '11 2', 'PBO1', '2021-12-31'),
(7, '11 2', 'PBO1', '2021-12-31'),
(8, '11 2', 'PBO2', '2021-12-31'),
(11, '11 2', 'PBO1', '2020-12-14'),
(12, '11 2', 'PBO1', '2021-12-31');

-- --------------------------------------------------------

--
-- Table structure for table `pengembalian`
--

CREATE TABLE `pengembalian` (
  `id` int(11) NOT NULL,
  `kode_peminjam` varchar(8) NOT NULL,
  `kode_buku` varchar(5) NOT NULL,
  `tanggal` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengembalian`
--

INSERT INTO `pengembalian` (`id`, `kode_peminjam`, `kode_buku`, `tanggal`) VALUES
(1, '11', 'PBO1', '2020-12-16'),
(2, '11 2 3', 'PBO2', '2020-12-16'),
(4, '11', 'PBO2', '2020-12-16'),
(5, '2', 'PBO1', '2020-12-16'),
(6, '11', 'PBO1', '2020-12-16');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `peminjam`
--
ALTER TABLE `peminjam`
  ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `kode_peminjam` (`kode_peminjam`);

--
-- Indexes for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `kode_buku` (`kode_buku`),
  ADD KEY `kode_peminjam` (`kode_peminjam`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pengembalian`
--
ALTER TABLE `pengembalian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode`),
  ADD CONSTRAINT `peminjaman_ibfk_2` FOREIGN KEY (`kode_peminjam`) REFERENCES `peminjam` (`kode`);

--
-- Constraints for table `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`kode_buku`) REFERENCES `buku` (`kode`),
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`kode_peminjam`) REFERENCES `peminjam` (`kode`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
