-- --------------------------------------------------------
-- Hôte :                        localhost
-- Version du serveur:           5.7.24 - MySQL Community Server (GPL)
-- SE du serveur:                Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Listage des données de la table clientbase.role : 5 rows
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_PATIENT'),
	(3, 'ROLE_DOCTOR'),
	(4, 'ROLE_NURSE'),
	(5, 'ROLE_DECISION_MAKER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

-- Listage des données de la table clientbase.users : 1 rows
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `address`, `email`, `firstname`, `lastname`, `password`, `phone_number`) VALUES
	(1, 'Yaounde/Cradat', 'admin@gmail.com', 'admin', 'admin', '$2a$10$QIsK.zJxZla50I/45P651eVLbo3AxZx604KzB5UAZU1ECq3/S8zDO', '+237 698920506');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Listage des données de la table clientbase.usersrole : 1 rows
/*!40000 ALTER TABLE `usersrole` DISABLE KEYS */;
INSERT INTO `usersrole` (`id`, `role_id`, `user_id`) VALUES
	(1, 1, 1);
/*!40000 ALTER TABLE `usersrole` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
