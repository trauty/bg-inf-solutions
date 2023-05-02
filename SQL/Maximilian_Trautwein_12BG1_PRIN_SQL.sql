-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.4.0.6659
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for uebung
CREATE DATABASE IF NOT EXISTS `uebung` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `uebung`;

-- Dumping structure for table uebung.abteilung
CREATE TABLE IF NOT EXISTS `abteilung` (
  `AbtNr` int(11) NOT NULL AUTO_INCREMENT,
  `AbtName` text DEFAULT NULL,
  `Budget` int(11) DEFAULT NULL,
  PRIMARY KEY (`AbtNr`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table uebung.abteilung: ~5 rows (approximately)
INSERT INTO `abteilung` (`AbtNr`, `AbtName`, `Budget`) VALUES
	(1, 'Forschung und Entwicklung', 300000),
	(2, 'Produktion', 200000),
	(3, 'Vertrieb', 500000),
	(4, 'Buchhaltung', 50000),
	(5, 'Geschäftsführung', 800000);

-- Dumping structure for table uebung.mitarbeiter
CREATE TABLE IF NOT EXISTS `mitarbeiter` (
  `PersNr` int(11) NOT NULL AUTO_INCREMENT,
  `Anrede` text DEFAULT NULL,
  `Nachname` text DEFAULT NULL,
  `Vorname` text DEFAULT NULL,
  `AbtNr` int(11) DEFAULT NULL,
  `Geburtsdatum` date DEFAULT NULL,
  `Eintrittsdatum` date DEFAULT NULL,
  `Krankenkasse` text DEFAULT NULL,
  `Gehalt` decimal(20,6) DEFAULT NULL,
  `VorgNr` int(11) DEFAULT NULL,
  `Telefon` text DEFAULT NULL,
  `Jahresgehalt` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`PersNr`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table uebung.mitarbeiter: ~5 rows (approximately)
INSERT INTO `mitarbeiter` (`PersNr`, `Anrede`, `Nachname`, `Vorname`, `AbtNr`, `Geburtsdatum`, `Eintrittsdatum`, `Krankenkasse`, `Gehalt`, `VorgNr`, `Telefon`, `Jahresgehalt`) VALUES
	(1, 'Herr', 'Jakob', 'Michael', 1, '1982-09-10', '2012-09-10', 'AOK', 2000.000000, 2, '069-45678', 24000),
	(2, 'Frau', 'Vogel', 'Melanie', 1, '1979-09-05', '2003-07-18', 'Techniker', 4500.000000, 4, '06151-62479', 54000),
	(3, 'Herr', 'Vogel', 'Ernst', 1, '1977-09-19', '2003-07-18', 'Techniker', 2500.000000, 2, NULL, 30000),
	(4, 'Herr', 'Peters', 'Steffen', 5, '1960-04-25', '1983-07-18', 'Debeka', 7500.000000, NULL, '069-568341', 90000),
	(5, 'Frau', 'Meier', 'Stefanie', 4, '1967-03-14', '1984-09-15', 'AOK', 3000.000000, 4, '0694-4723894', 36000);

-- Dumping structure for table uebung.monatsgehalt
CREATE TABLE IF NOT EXISTS `monatsgehalt` (
  `PersNr` int(11) NOT NULL,
  `Monat` int(11) NOT NULL,
  `Jahr` year(4) NOT NULL,
  `Auszahlung` decimal(10,0) DEFAULT NULL,
  `Boni` decimal(10,0) DEFAULT NULL,
  `Steuer` decimal(10,0) DEFAULT NULL,
  `SobAbzuege` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`PersNr`,`Monat`,`Jahr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table uebung.monatsgehalt: ~7 rows (approximately)
INSERT INTO `monatsgehalt` (`PersNr`, `Monat`, `Jahr`, `Auszahlung`, `Boni`, `Steuer`, `SobAbzuege`) VALUES
	(1, 7, '2015', 1500, 0, 300, 200),
	(1, 8, '2015', 1500, 0, 300, 200),
	(2, 7, '2015', 1500, 250, 1500, 500),
	(2, 8, '2015', 4500, 0, 1500, 500),
	(3, 7, '2015', 3500, 0, 800, 300),
	(3, 8, '2015', 3500, 0, 800, 300),
	(5, 7, '2015', 3000, 100, 900, 280);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
