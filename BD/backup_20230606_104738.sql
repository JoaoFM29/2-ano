-- MySQL dump 10.13  Distrib 8.0.33, for macos13.3 (arm64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Adotante`
--

DROP TABLE IF EXISTS `Adotante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Adotante` (
  `Id` int NOT NULL,
  `Nome` varchar(40) NOT NULL,
  `D_nascimento` datetime NOT NULL,
  `Sexo` char(1) NOT NULL,
  `N_Porta` int NOT NULL,
  `Rua` varchar(50) NOT NULL,
  `CódigoPostal` int NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `CódigoPostalAdotante` CHECK ((`CódigoPostal` between 1000000 and 9999999)),
  CONSTRAINT `SexoAdotante` CHECK ((`Sexo` in (_utf8mb4'M',_utf8mb4'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Adotante`
--

LOCK TABLES `Adotante` WRITE;
/*!40000 ALTER TABLE `Adotante` DISABLE KEYS */;
INSERT INTO `Adotante` VALUES (1,'Nuno Rodrigues','2003-10-16 00:00:00','M',7,'Rua dos Peoes',4710192),(2,'Maria Joana','2000-02-05 00:00:00','F',12,'Rua dos Capelistas',4710112);
/*!40000 ALTER TABLE `Adotante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `adotantecontactos`
--

DROP TABLE IF EXISTS `adotantecontactos`;
/*!50001 DROP VIEW IF EXISTS `adotantecontactos`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `adotantecontactos` AS SELECT 
 1 AS `Id`,
 1 AS `Nome`,
 1 AS `D_nascimento`,
 1 AS `Sexo`,
 1 AS `N_Porta`,
 1 AS `Rua`,
 1 AS `CódigoPostal`,
 1 AS `Contactos`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Animal`
--

DROP TABLE IF EXISTS `Animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Animal` (
  `id` int NOT NULL,
  `Nome` varchar(40) DEFAULT NULL,
  `Idade` int DEFAULT NULL,
  `Perfil` varchar(45) DEFAULT NULL,
  `D_nascimento` date DEFAULT NULL,
  `Registo_clinico` text,
  `Categoria` varchar(20) NOT NULL,
  `Cor` varchar(20) NOT NULL,
  `D_adoção` datetime DEFAULT NULL,
  `D_saida` datetime DEFAULT NULL,
  `D_chegada` datetime NOT NULL,
  `Sexo` char(1) NOT NULL,
  `Raça e espécie` varchar(20) NOT NULL,
  `Peso` int NOT NULL,
  `Adotante_Id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dataChegada` (`D_chegada`),
  KEY `fk` (`Adotante_Id`),
  CONSTRAINT `animal_ibfk_1` FOREIGN KEY (`Adotante_Id`) REFERENCES `Adotante` (`Id`),
  CONSTRAINT `SexoAnimal` CHECK ((`Sexo` in (_utf8mb3'M',_utf8mb3'F')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Animal`
--

LOCK TABLES `Animal` WRITE;
/*!40000 ALTER TABLE `Animal` DISABLE KEYS */;
INSERT INTO `Animal` VALUES (1,NULL,NULL,'Agressivo',NULL,NULL,'Canideo','Preto e Castanho',NULL,NULL,'2023-04-10 00:00:00','M','Arracado Boxer',29,NULL),(2,'Pantufa',5,'Docil','2018-01-10','Vacinado e Castrado','Canideo','Castanho','2023-06-06 10:45:15',NULL,'2023-04-15 00:00:00','M','Chow Chow',27,1),(3,'Lua',4,'Docil','2019-03-22','Vacinado e Castrado','Canideo','Branco','2023-06-06 10:45:15',NULL,'2023-04-12 00:00:00','F','Arracado Samoyed',17,2),(4,'Balu',2,'Docil','2020-08-11','Vacinado','Canideo','Castanho','2023-06-06 10:45:15',NULL,'2023-03-30 00:00:00','M','Bulldog',25,1),(5,'Coco',5,'Docil','2018-02-10','Vacinado e Castrado','Felino','Branco',NULL,NULL,'2023-04-05 00:00:00','F','Ragdoll',8,NULL),(6,'Mia',6,'Docil','2017-01-22','Vacinado','Felino','Laranja',NULL,NULL,'2023-04-12 00:00:00','F','Persian',5,NULL),(7,'Ozzy',NULL,'Agressivo',NULL,'Vacinado','Felino','Preto',NULL,NULL,'2023-03-29 00:00:00','M','Arracado Bombay',4,NULL),(8,'Lizzy',NULL,'Docil',NULL,'Teste as Bacterias','Iguanids','Verde',NULL,NULL,'2023-04-25 00:00:00','M','Iguana-Verde',4,NULL);
/*!40000 ALTER TABLE `Animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Competência`
--

DROP TABLE IF EXISTS `Competência`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Competência` (
  `Aptidão` varchar(40) NOT NULL,
  `Funcionário_Id` int NOT NULL,
  PRIMARY KEY (`Aptidão`,`Funcionário_Id`),
  KEY `fk_Competência_Funcionário` (`Funcionário_Id`),
  CONSTRAINT `fk_Competência_Funcionário` FOREIGN KEY (`Funcionário_Id`) REFERENCES `Funcionário` (`Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Competência`
--

LOCK TABLES `Competência` WRITE;
/*!40000 ALTER TABLE `Competência` DISABLE KEYS */;
INSERT INTO `Competência` VALUES ('Tratador',1),('Veterinário',1),('Enfermeiro',2),('Secretário',2),('Tratador',2),('Tratador',3),('Tratador',4);
/*!40000 ALTER TABLE `Competência` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Comprovativo`
--

DROP TABLE IF EXISTS `Comprovativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Comprovativo` (
  `IBAN` varchar(45) NOT NULL,
  `Operação` varchar(45) NOT NULL,
  `Montante` double NOT NULL,
  `NomeBanco` varchar(60) NOT NULL,
  `Donativo_Id` int NOT NULL,
  `DataMovimento` datetime NOT NULL,
  PRIMARY KEY (`IBAN`,`Donativo_Id`),
  KEY `fk_Comprovativo_Donativo` (`Donativo_Id`),
  CONSTRAINT `fk_Comprovativo_Donativo` FOREIGN KEY (`Donativo_Id`) REFERENCES `Donativo` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Comprovativo`
--

LOCK TABLES `Comprovativo` WRITE;
/*!40000 ALTER TABLE `Comprovativo` DISABLE KEYS */;
INSERT INTO `Comprovativo` VALUES ('PT00000000000000000000000000000001','Transferência',10000000,'SANTANDER TOTTA',10,'2023-02-02 00:00:00');
/*!40000 ALTER TABLE `Comprovativo` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_update_quantidade` AFTER INSERT ON `comprovativo` FOR EACH ROW BEGIN
	UPDATE donativo SET donativo.quantidade = new.montante
		WHERE donativo.Id = new.Donativo_Id;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `Contacto`
--

DROP TABLE IF EXISTS `Contacto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Contacto` (
  `Número` int NOT NULL,
  `Adotante_Id` int NOT NULL,
  PRIMARY KEY (`Número`,`Adotante_Id`),
  KEY `fk_Contacto_Adotante1` (`Adotante_Id`),
  CONSTRAINT `fk_Contacto_Adotante1` FOREIGN KEY (`Adotante_Id`) REFERENCES `Adotante` (`Id`) ON DELETE CASCADE,
  CONSTRAINT `NúmeroContacto` CHECK ((`Número` between 100000000 and 999999999))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Contacto`
--

LOCK TABLES `Contacto` WRITE;
/*!40000 ALTER TABLE `Contacto` DISABLE KEYS */;
INSERT INTO `Contacto` VALUES (927563128,1),(927961282,2);
/*!40000 ALTER TABLE `Contacto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Disponibilidade`
--

DROP TABLE IF EXISTS `Disponibilidade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Disponibilidade` (
  `Funcionário_Id` int NOT NULL,
  `DiaDaSemana` enum('Segunda-feira','Terca-feira','Quarta-feira','Quinta-feira','Sexta-feira','Sabado','Domingo') NOT NULL,
  PRIMARY KEY (`Funcionário_Id`,`DiaDaSemana`),
  CONSTRAINT `DisponibilidadeConstrain` FOREIGN KEY (`Funcionário_Id`) REFERENCES `Funcionário` (`Id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Disponibilidade`
--

LOCK TABLES `Disponibilidade` WRITE;
/*!40000 ALTER TABLE `Disponibilidade` DISABLE KEYS */;
INSERT INTO `Disponibilidade` VALUES (1,'Segunda-feira'),(1,'Terca-feira'),(1,'Quarta-feira'),(1,'Quinta-feira'),(1,'Sexta-feira'),(1,'Sabado'),(1,'Domingo'),(2,'Segunda-feira'),(2,'Terca-feira'),(2,'Quarta-feira'),(2,'Quinta-feira'),(2,'Sexta-feira'),(2,'Sabado'),(2,'Domingo'),(3,'Segunda-feira'),(3,'Terca-feira'),(3,'Quarta-feira'),(4,'Quinta-feira'),(4,'Sexta-feira');
/*!40000 ALTER TABLE `Disponibilidade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Doador`
--

DROP TABLE IF EXISTS `Doador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Doador` (
  `Id` int NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Nome` varchar(40) NOT NULL,
  `Número` int NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `NúmeroDoador` CHECK ((`Número` between 100000000 and 999999999))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Doador`
--

LOCK TABLES `Doador` WRITE;
/*!40000 ALTER TABLE `Doador` DISABLE KEYS */;
INSERT INTO `Doador` VALUES (1,'renatomartins@gmail.com','Renato Martins',984123089),(2,'diogoPaiva@gmail.com','Diogo Paiva',921125089),(3,'RodrigoGomes@gmail.com','Rodrigo Gomes',924143059),(4,'jeff@gmail.com','Jeffrey Bezos',966123089),(5,'antonioM3des@gmail.com','Antonio Mendes',911123089),(6,'nelo@gmail.com','Nelo Chapeiro',961531089);
/*!40000 ALTER TABLE `Doador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `doadoremdinheiro`
--

DROP TABLE IF EXISTS `doadoremdinheiro`;
/*!50001 DROP VIEW IF EXISTS `doadoremdinheiro`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `doadoremdinheiro` AS SELECT 
 1 AS `IBAN`,
 1 AS `Operação`,
 1 AS `Montante`,
 1 AS `NomeBanco`,
 1 AS `DataMovimento`,
 1 AS `Nome`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Donativo`
--

DROP TABLE IF EXISTS `Donativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Donativo` (
  `Id` int NOT NULL,
  `Categoria` varchar(20) NOT NULL,
  `D_validade` date DEFAULT NULL,
  `Quantidade` double DEFAULT NULL,
  `Doador_Id` int NOT NULL,
  PRIMARY KEY (`Id`,`Doador_Id`),
  KEY `fk_Donativo_Doador1` (`Doador_Id`),
  KEY `dataValidade` (`D_validade`),
  CONSTRAINT `fk_Donativo_Doador1` FOREIGN KEY (`Doador_Id`) REFERENCES `Doador` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Donativo`
--

LOCK TABLES `Donativo` WRITE;
/*!40000 ALTER TABLE `Donativo` DISABLE KEYS */;
INSERT INTO `Donativo` VALUES (1,'Comida para Cão','2023-05-30',1,1),(2,'Comida para Gato','2023-05-30',2,1),(3,'Comida para Pássaro','2023-07-11',1,2),(4,'Comida para Coelho','2023-08-05',1,2),(5,'Manta',NULL,3,3),(8,'Cama',NULL,1,6),(9,'Brinquedo para Gato',NULL,1,5),(10,'Dinheiro',NULL,10000000,4),(11,'Dinheiro',NULL,NULL,4);
/*!40000 ALTER TABLE `Donativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `funcionariocompetenciasdisponiblidade`
--

DROP TABLE IF EXISTS `funcionariocompetenciasdisponiblidade`;
/*!50001 DROP VIEW IF EXISTS `funcionariocompetenciasdisponiblidade`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `funcionariocompetenciasdisponiblidade` AS SELECT 
 1 AS `Nome`,
 1 AS `comp_combinadas`,
 1 AS `Disp_combinadas`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `Funcionário`
--

DROP TABLE IF EXISTS `Funcionário`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Funcionário` (
  `Id` int NOT NULL,
  `Nome` varchar(45) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Estatuto` varchar(1) NOT NULL,
  `Rua` varchar(45) NOT NULL,
  `N_Porta` int NOT NULL,
  `CódigoPostal` int NOT NULL,
  `Número` int NOT NULL,
  PRIMARY KEY (`Id`),
  CONSTRAINT `CódigoPostalFuncionário` CHECK ((`CódigoPostal` between 1000000 and 9999999)),
  CONSTRAINT `EstatutoFuncionário` CHECK ((`Estatuto` in (_utf8mb4'V',_utf8mb4'P'))),
  CONSTRAINT `NúmeroFuncionário` CHECK ((`Número` between 100000000 and 999999999))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Funcionário`
--

LOCK TABLES `Funcionário` WRITE;
/*!40000 ALTER TABLE `Funcionário` DISABLE KEYS */;
INSERT INTO `Funcionário` VALUES (1,'Rodrigo Gomes','rodgm@gmail.com','P','Avenida Lateral',10,4716221,910389123),(2,'João Magalhães','jmag@gmail.com','P','Rua 15 de Maio',223,4800275,966375141),(3,'Raquel Silva','rqsil@gmail.com','V','Rua da Capela de Baixo',111,4705791,926169626),(4,'Duarte Antunes','dant12@gmail.com','V','Rua da Igreja Nova',84,4710077,911122153);
/*!40000 ALTER TABLE `Funcionário` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `trigger_update_disponiblidade` AFTER INSERT ON `funcionário` FOR EACH ROW BEGIN
	IF new.Estatuto = 'P' THEN
	INSERT IGNORE INTO mydb.Disponibilidade (Funcionário_Id, DiaDaSemana) VALUES (NEW.Id, 'Segunda-feira');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Terca-feira');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Quarta-feira');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Quinta-feira');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Sexta-feira');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Sabado');
    INSERT IGNORE INTO mydb.Disponibilidade(Funcionário_Id,DiaDaSemana) VALUES (new.Id,'Domingo');
    END IF;

END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `TB_AnimalFuncionário`
--

DROP TABLE IF EXISTS `TB_AnimalFuncionário`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TB_AnimalFuncionário` (
  `Animal_id` int NOT NULL,
  `Funcionário_Id` int NOT NULL,
  `D_tratamento` datetime NOT NULL,
  PRIMARY KEY (`Animal_id`,`Funcionário_Id`,`D_tratamento`),
  KEY `fk_Animal_has_Funcionário_Funcionário1` (`Funcionário_Id`),
  CONSTRAINT `fk_Animal_has_Funcionário_Animal1` FOREIGN KEY (`Animal_id`) REFERENCES `Animal` (`id`),
  CONSTRAINT `fk_Animal_has_Funcionário_Funcionário1` FOREIGN KEY (`Funcionário_Id`) REFERENCES `Funcionário` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TB_AnimalFuncionário`
--

LOCK TABLES `TB_AnimalFuncionário` WRITE;
/*!40000 ALTER TABLE `TB_AnimalFuncionário` DISABLE KEYS */;
/*!40000 ALTER TABLE `TB_AnimalFuncionário` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TB_FuncionárioDonativo`
--

DROP TABLE IF EXISTS `TB_FuncionárioDonativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TB_FuncionárioDonativo` (
  `Donativo_Id` int NOT NULL,
  `Funcionário_Id` int NOT NULL,
  `D_acesso` datetime NOT NULL,
  PRIMARY KEY (`Donativo_Id`,`Funcionário_Id`,`D_acesso`),
  KEY `fk_TB_FuncionárioDonativo_Funcionário1` (`Funcionário_Id`),
  CONSTRAINT `fk_Funcionário_has_Donativo1_Donativo1` FOREIGN KEY (`Donativo_Id`) REFERENCES `Donativo` (`Id`),
  CONSTRAINT `fk_TB_FuncionárioDonativo_Funcionário1` FOREIGN KEY (`Funcionário_Id`) REFERENCES `Funcionário` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TB_FuncionárioDonativo`
--

LOCK TABLES `TB_FuncionárioDonativo` WRITE;
/*!40000 ALTER TABLE `TB_FuncionárioDonativo` DISABLE KEYS */;
/*!40000 ALTER TABLE `TB_FuncionárioDonativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `adotantecontactos`
--

/*!50001 DROP VIEW IF EXISTS `adotantecontactos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `adotantecontactos` AS select `adotante`.`Id` AS `Id`,`adotante`.`Nome` AS `Nome`,`adotante`.`D_nascimento` AS `D_nascimento`,`adotante`.`Sexo` AS `Sexo`,`adotante`.`N_Porta` AS `N_Porta`,`adotante`.`Rua` AS `Rua`,`adotante`.`CódigoPostal` AS `CódigoPostal`,group_concat(distinct `contacto`.`Número` separator ',') AS `Contactos` from (`adotante` join `contacto` on((`adotante`.`Id` = `contacto`.`Adotante_Id`))) group by `adotante`.`Id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `doadoremdinheiro`
--

/*!50001 DROP VIEW IF EXISTS `doadoremdinheiro`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `doadoremdinheiro` AS select `comprovativo`.`IBAN` AS `IBAN`,`comprovativo`.`Operação` AS `Operação`,`comprovativo`.`Montante` AS `Montante`,`comprovativo`.`NomeBanco` AS `NomeBanco`,`comprovativo`.`DataMovimento` AS `DataMovimento`,`doador`.`Nome` AS `Nome` from ((`comprovativo` join `donativo` on((`comprovativo`.`Donativo_Id` = `donativo`.`Id`))) join `doador` on((`donativo`.`Doador_Id` = `doador`.`Id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `funcionariocompetenciasdisponiblidade`
--

/*!50001 DROP VIEW IF EXISTS `funcionariocompetenciasdisponiblidade`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `funcionariocompetenciasdisponiblidade` AS select `funcionário`.`Nome` AS `Nome`,group_concat(distinct `competência`.`Aptidão` separator ',') AS `comp_combinadas`,group_concat(distinct `disponibilidade`.`DiaDaSemana` separator ',') AS `Disp_combinadas` from ((`funcionário` join `competência` on((`funcionário`.`Id` = `competência`.`Funcionário_Id`))) join `disponibilidade` on((`funcionário`.`Id` = `disponibilidade`.`Funcionário_Id`))) group by `funcionário`.`Nome` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-06 10:47:38
