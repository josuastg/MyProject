-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2019 at 10:03 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `wmb_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `cashier`
--

CREATE TABLE `cashier` (
  `id` int(10) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `password` varchar(25) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cashier`
--

INSERT INTO `cashier` (`id`, `name`, `password`) VALUES
(1, 'Febri', '12345'),
(2, 'Josua', '54321');

-- --------------------------------------------------------

--
-- Table structure for table `desk`
--

CREATE TABLE `desk` (
  `id` int(5) NOT NULL,
  `name` varchar(5) DEFAULT NULL,
  `capacity` int(5) DEFAULT NULL,
  `status` varchar(29) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `desk`
--

INSERT INTO `desk` (`id`, `name`, `capacity`, `status`) VALUES
(1, 'A1', 2, 'NON AVAILABLE'),
(2, 'A2', 2, 'NON AVAILABLE'),
(3, 'A3', 2, 'NON AVAILABLE'),
(4, 'A4', 2, 'AVAILABLE'),
(5, 'A5', 2, 'AVAILABLE'),
(6, 'A6', 2, 'AVAILABLE'),
(7, 'A7', 2, 'NON AVAILABLE'),
(8, 'A8', 2, 'AVAILABLE'),
(9, 'A9', 2, 'AVAILABLE'),
(10, 'A10', 2, 'AVAILABLE'),
(11, 'B1', 4, 'AVAILABLE'),
(12, 'B2', 4, 'AVAILABLE'),
(13, 'B3', 4, 'NON AVAILABLE'),
(14, 'B4', 4, 'AVAILABLE'),
(15, 'B5', 4, 'AVAILABLE'),
(16, 'B6', 4, 'AVAILABLE'),
(17, 'B7', 4, 'NON AVAILABLE'),
(18, 'B8', 4, 'AVAILABLE'),
(19, 'B9', 4, 'AVAILABLE'),
(20, 'B10', 4, 'AVAILABLE'),
(21, 'C1', 6, 'NON AVAILABLE'),
(22, 'C2', 6, 'AVAILABLE'),
(23, 'C3', 6, 'AVAILABLE'),
(24, 'C4', 6, 'AVAILABLE'),
(25, 'C5', 6, 'NON AVAILABLE'),
(26, 'C6', 6, 'NON AVAILABLE'),
(27, 'C7', 6, 'AVAILABLE'),
(28, 'C8', 6, 'NON AVAILABLE'),
(29, 'C9', 6, 'AVAILABLE'),
(30, 'C10', 6, 'NON AVAILABLE');

-- --------------------------------------------------------

--
-- Table structure for table `drinks`
--

CREATE TABLE `drinks` (
  `id` int(5) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `stock` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `drinks`
--

INSERT INTO `drinks` (`id`, `name`, `price`, `stock`) VALUES
(1, 'Mineral Water', 3000, 30),
(2, 'Happy Tea', 5000, 26),
(3, 'Orange Juice', 7000, 19),
(4, 'Zam Zam Water', 20000, 30),
(5, 'Es Doger', 6000, 38),
(6, 'Es Kelapa', 3000, 18),
(7, 'Lemon Tea', 4000, 28);

-- --------------------------------------------------------

--
-- Table structure for table `foods`
--

CREATE TABLE `foods` (
  `id` int(10) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int(10) DEFAULT NULL,
  `stock` int(5) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foods`
--

INSERT INTO `foods` (`id`, `name`, `price`, `stock`) VALUES
(2, 'Chicken Noodle', 15000, 4),
(3, 'Burger Lord', 20000, 37),
(4, 'Long Rice Vegetable', 10000, 40),
(5, 'Yellow Rice', 11000, 39),
(7, 'Diamond Rice With Peanut Sauce', 20000, 48),
(9, 'Soda Milk', 5000, 60),
(10, 'Mineral Water', 2000, 60);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `qty_foods` int(5) DEFAULT NULL,
  `qty_drinks` int(5) DEFAULT NULL,
  `sub_total` int(5) DEFAULT NULL,
  `drinks_id` int(5) DEFAULT NULL,
  `foods_id` int(10) DEFAULT NULL,
  `transaction_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `qty_foods`, `qty_drinks`, `sub_total`, `drinks_id`, `foods_id`, `transaction_id`) VALUES
(3, 1, 1, 20000, 2, 2, 2),
(4, 1, 1, 20000, 2, 2, 3),
(5, 2, 2, 54000, 3, 3, 3),
(9, 1, 2, 55000, 4, 2, 7),
(10, 1, 2, 30000, 2, 3, 8),
(12, 1, 2, 50000, 4, 4, 10),
(13, 1, 2, 30000, 2, 3, 11),
(14, 1, 2, 29000, 3, 2, 12),
(16, 1, 2, 50000, 4, 4, 14),
(20, 1, 2, 29000, 3, 2, 18),
(24, 2, 2, 44000, 3, 2, 22),
(28, 2, 2, 50000, 2, 3, 26),
(29, 2, 2, 70000, 4, 2, 27),
(30, 2, 2, 80000, 4, 3, 28),
(32, 2, 2, 40000, 2, 2, 30),
(33, 2, 2, 60000, 4, 4, 31),
(35, 2, 2, 26000, 1, 4, 33),
(36, 1, 1, 20000, 2, 2, 35),
(37, 2, 2, 54000, 3, 3, 35),
(38, 2, 2, 28000, 1, 5, 36),
(44, 2, 3, 51000, 3, 2, 42),
(45, 2, 3, 45000, 2, 2, 43),
(46, 2, 3, 45000, 2, 2, 44),
(47, 2, 3, 45000, 2, 2, 45),
(48, 2, 3, 45000, 2, 2, 46),
(49, 2, 3, 45000, 2, 2, 48),
(50, 2, 3, 45000, 2, 2, 54),
(51, 2, 3, 45000, 2, 2, 55),
(52, 2, 3, 45000, 2, 2, 55),
(53, 2, 3, 45000, 2, 2, 56),
(54, 2, 3, 45000, 2, 2, 57),
(58, 1, 1, 20000, 2, 2, 62),
(61, 4, 4, 52000, 6, 4, 65),
(62, 2, 2, 34000, 5, 5, 66),
(67, 2, 2, 50000, 2, 7, 71),
(68, 3, 2, 100000, 4, 3, 72),
(70, -2, 0, -30000, 1, 2, 74),
(71, 3, 3, 60000, 2, 2, 75),
(72, 5, 2, 63000, 7, 5, 76),
(73, 1, 1, 20000, 2, 2, 77),
(74, 1, 1, 20000, 2, 2, 78),
(75, 1, 1, 20000, 2, 2, 79),
(76, 1, 1, 20000, 2, 2, 79),
(77, 2, 2, 34000, 5, 5, 80);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` int(10) NOT NULL,
  `date` date DEFAULT current_timestamp(),
  `total` int(10) DEFAULT NULL,
  `name_pic` varchar(25) DEFAULT NULL,
  `qty_customer` int(5) DEFAULT NULL,
  `status` varchar(25) DEFAULT NULL,
  `desk_id` int(5) NOT NULL,
  `cashier_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `date`, `total`, `name_pic`, `qty_customer`, `status`, `desk_id`, `cashier_id`) VALUES
(2, '2019-11-13', 20000, 'febri', 2, 'Paid', 1, 1),
(3, '2019-11-13', 74000, 'Naruto kun', 2, 'Paid', 1, 1),
(4, '2019-11-13', 18000, 'Jono', 2, 'Paid', 3, 2),
(5, '2019-11-13', 26000, 'jonatan', 2, 'Paid', 10, 2),
(6, '2019-11-13', 52000, 'Jovanka', 2, 'Paid', 2, 2),
(7, '2019-11-13', 55000, 'Miftah', 2, 'Paid', 2, 2),
(8, '2019-11-13', 30000, 'Munthe', 3, 'Paid', 15, 2),
(9, '2019-11-13', 18000, 'Fandi', 2, 'Paid', 3, 2),
(10, '2019-11-13', 50000, 'ujang', 3, 'Paid', 12, 2),
(11, '2019-11-13', 30000, 'Jambrong', 2, 'Paid', 2, 2),
(12, '2019-11-13', 29000, 'koko', 2, 'Paid', 4, 2),
(13, '2019-11-13', 26000, 'awan', 2, 'Paid', 10, 2),
(14, '2019-11-13', 50000, 'Melly', 3, 'Paid', 18, 2),
(15, '2019-11-13', 22000, 'Anju', 4, 'Paid', 16, 2),
(16, '2019-11-13', 26000, 'ade', 2, 'Paid', 2, 2),
(17, '2019-11-13', 22000, 'wawan', 2, 'Paid', 4, 2),
(18, '2019-11-13', 29000, 'wani', 2, 'Paid', 4, 2),
(19, '2019-11-13', 39000, 'Zaki', 2, 'Paid', 2, 2),
(20, '2019-11-13', 45000, 'wadimor', 2, 'Paid', 6, 2),
(21, '2019-11-14', 34000, 'Jeremy', 2, 'Paid', 2, 2),
(22, '2019-11-14', 44000, 'febri', 2, 'Paid', 3, 2),
(23, '2019-11-14', 38000, 'woro', 2, 'Paid', 3, 2),
(24, '2019-11-14', 30000, 'Lolox', 2, 'Paid', 6, 2),
(25, '2019-11-14', 34000, 'Wanju', 4, 'Paid', 19, 2),
(26, '2019-11-14', 50000, 'Fandri', 2, 'Paid', 3, 2),
(27, '2019-11-14', 70000, 'Syehanduk', 2, 'Paid', 10, 2),
(28, '2019-11-14', 80000, 'Sanda', 2, 'Paid', 2, 2),
(29, '2019-11-14', 30000, 'Kindo', 2, 'Paid', 1, 2),
(30, '2019-11-14', 40000, 'jonadi', 2, 'Paid', 1, 2),
(31, '2019-11-14', 60000, 'Jaja', 2, 'Paid', 2, 2),
(32, '2019-11-14', 30000, 'Jandia', 2, 'Paid', 3, 2),
(33, '2019-11-14', 26000, 'Joko susiol', 2, 'Paid', 5, 2),
(35, '2019-11-14', 74000, 'Sasuke Kun', 2, 'Paid', 9, 2),
(36, '2019-11-14', 28000, 'sojoo', 3, 'Paid', 11, 2),
(37, '2019-11-14', 38000, 'ojoj', 1, 'Paid', 4, 2),
(38, '2019-11-14', 18000, 'rizal', 3, 'Paid', 12, 2),
(39, '2019-11-14', 14000, 'Jajang', 2, 'Paid', 6, 2),
(40, '2019-11-14', 44000, 'rizal', 2, 'Paid', 10, 2),
(41, '2019-11-14', 44000, 'Arians', 4, 'Paid', 18, 2),
(42, '2019-11-14', 51000, 'jo', 2, 'Paid', 8, 2),
(43, '2019-11-14', 45000, 'Sasuke Kun', 2, 'Paid', 10, 1),
(44, '2019-11-14', 45000, 'Sasuke Kun', 2, 'Paid', 12, 1),
(45, '2019-11-14', 45000, 'Sasuke Kun', 2, 'Paid', 19, 1),
(46, '2019-11-14', 45000, 'Sasuke Kun', 2, 'Unpaid', 21, 1),
(48, '2019-11-15', 45000, 'Sasuke Kun', 2, 'Unpaid', 1, 1),
(54, '2019-11-15', 45000, 'Sasuke Kun', 2, 'Unpaid', 17, 2),
(55, '2019-11-15', 90000, 'Sasuke Kun', 2, 'Unpaid', 28, 2),
(56, '2019-11-15', 45000, 'Sasuke Kun', 2, 'Unpaid', 13, 1),
(57, '2019-11-15', 45000, 'Sasuke Kun', 2, 'Unpaid', 25, 1),
(58, '2019-11-15', 33000, 'Sasuke Kun', 2, 'Unpaid', 2, 1),
(59, '2019-11-15', 33000, 'josua', 2, 'Unpaid', 3, 2),
(61, '2019-11-15', 38000, 'jao', 2, 'Paid', 4, 2),
(62, '2019-11-15', 20000, 'pindo', 2, 'Paid', 18, 2),
(63, '2019-11-15', 50000, 'josua', 2, 'Paid', 5, 2),
(64, '2019-11-15', 31000, 'Ayu', 2, 'Paid', 5, 2),
(65, '2019-11-15', 52000, 'Nani', 2, 'Paid', 4, 2),
(66, '2019-11-15', 34000, 'josandi', 2, 'Paid', 4, 2),
(67, '2019-11-15', 63000, 'Jono', 2, 'Paid', 4, 2),
(68, '2019-11-16', 10000, 'Jimmy', 2, 'Paid', 9, 2),
(69, '2019-11-16', 26000, 'Filain', 6, 'Unpaid', 26, 2),
(70, '2019-11-16', 34000, 'Sajojo', 5, 'Unpaid', 30, 2),
(71, '2019-11-16', 50000, 'Melly', 2, 'Paid', 4, 2),
(72, '2019-11-16', 100000, 'Putri', 2, 'Paid', 4, 2),
(74, '2019-11-16', -30000, 'fikri', 2, 'Paid', 4, 2),
(75, '2019-11-16', 60000, 'keke', 2, 'Paid', 1, 2),
(76, '2019-11-16', 63000, 'jojo', 4, 'Paid', 14, 2),
(77, '2019-11-16', 20000, 'febri', 2, 'Unpaid', 1, 1),
(78, '2019-11-16', 20000, 'febri', 2, 'Unpaid', 7, 1),
(79, '2019-11-16', 40000, 'febri', 2, 'Paid', 8, 1),
(80, '2019-11-18', 34000, 'fedri', 2, 'Paid', 4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cashier`
--
ALTER TABLE `cashier`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `desk`
--
ALTER TABLE `desk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `foods`
--
ALTER TABLE `foods`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_orders_drinks_idx` (`drinks_id`),
  ADD KEY `fk_orders_foods1_idx` (`foods_id`),
  ADD KEY `fk_orders_transaction1_idx` (`transaction_id`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_transaction_desk2_idx` (`desk_id`),
  ADD KEY `fk_transaction_cashier1_idx` (`cashier_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cashier`
--
ALTER TABLE `cashier`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `desk`
--
ALTER TABLE `desk`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT for table `drinks`
--
ALTER TABLE `drinks`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `foods`
--
ALTER TABLE `foods`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_orders_drinks` FOREIGN KEY (`drinks_id`) REFERENCES `drinks` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orders_foods1` FOREIGN KEY (`foods_id`) REFERENCES `foods` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_orders_transaction1` FOREIGN KEY (`transaction_id`) REFERENCES `transaction` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `fk_transaction_cashier1` FOREIGN KEY (`cashier_id`) REFERENCES `cashier` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_transaction_desk2` FOREIGN KEY (`desk_id`) REFERENCES `desk` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
