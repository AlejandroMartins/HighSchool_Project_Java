
DROP DATABASE if exists restaurante;
CREATE DATABASE  IF NOT EXISTS `restaurante` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `restaurante`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurante
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `compra`
--

create table usuario(
name varchar(50),
password varchar(50)
);

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra` (
  `id_compra` int NOT NULL AUTO_INCREMENT,
  `valortotal` float NOT NULL,
  `hora` varchar(20) NOT NULL,
  `dia` varchar(20) NOT NULL,
  `total` float NOT NULL,
  `metodopagamento_id` int NOT NULL,
  PRIMARY KEY (`id_compra`),
  KEY `metodopagamento_id` (`metodopagamento_id`),
  CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`metodopagamento_id`) REFERENCES `metodopagamento` (`id_metodopagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,8.5,'10:19','16/Apr/2022',123.2,2),(2,3.5,'11:04','5/Oct/2022',132.1,3),(3,3.5,'10:39','14/Jun/2022',234.1,1),(4,13.5,'2:41','28/Dec/2022',23.2,4),(5,22.5,'12:41','28/Mar/2022',121.2,2),(6,20.5,'1:39','16/Apr/2022',12.4,1),(7,24.5,'1:46','10/Mar/2022',32.2,4),(8,12.5,'2:00','15/May/2022',323.2,1),(9,12.5,'9:54','27/Aug/2022',423.2,1),(10,18.5,'2:08','25/Feb/2022',213.2,3),(11,19.5,'3:29','11/Sep/2022',93,3),(12,18.5,'3:44','9/Jul/2022',13.2,4),(13,2.5,'11:11','4/Oct/2022',243,3),(14,9.5,'10:15','18/Aug/2022',353,2),(15,13.5,'11:52','27/Nov/2022',121.5,3),(16,23.5,'9:36','26/Dec/2022',113.7,2),(17,16.5,'9:09','1/Jun/2022',45,3),(18,22.5,'11:17','18/Nov/2022',123.2,1),(19,17.5,'10:40','2/Apr/2022',143.2,2),(20,11.5,'5:47','28/Oct/2022',131.3,3);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id_fornecedor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `cnpj` varchar(14) NOT NULL,
  `email` varchar(50) NOT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_fornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'Tatyana Holmes','83026279270490','semper@protonmail.org','(82) 92487-0388','80537-591','R. Chantale Patel',872,'','Dominic','Curitiba','Rio Grande do Sul'),(2,'Jolene Bartlett','17734622054322','dis.parturient@icloud.org','(58) 98473-6071','62621-825','R. Eagan Alston',873,'','Daria','Jundiaí','Pernambuco'),(3,'Autumn Wolf','27290237833999','ut.lacus@aol.net','(23) 96719-6794','65172-220','R. Jermaine Barnett',152,'','Cassidy','Cametá','Paraná'),(4,'Daquan Warner','33094627901357','dapibus.id@aol.ca','(75) 95424-5664','65611-137','R. Tiger Patterson',509,'','Margaret','Osasco','Rio de Janeiro'),(5,'Rafael Herrera','56947984055101','duis.mi.enim@google.couk','(82) 99378-1978','61875-805','R. Quyn Alexander',444,'','Rashad','João Pessoa','Maranhão'),(6,'Lesley Rasmussen','67392367212953','pede.nunc.sed@aol.net','(82) 95488-3776','81826-832','R. Hedwig Church',415,'','Hillary','Diadema','São Paulo'),(7,'Wyatt Johnston','90694796524219','elit.sed@icloud.net','(88) 91483-8505','74784-832','R. Britanney Conrad',738,'','Kay','Feira de Santana','Paraná'),(8,'Harrison Cunningham','67970175642674','ipsum.ac.mi@icloud.net','(94) 95648-3270','58675-230','R. Aretha Thornton',987,'','Tad','Belém','Rio de Janeiro'),(9,'Hayley Patterson','99289039160348','dignissim@icloud.org','(62) 92472-2691','16561-325','R. Amal Watson',526,'','Jin','Sobral','Bahia'),(10,'Chanda Waters','37072750222400','felis.purus@yahoo.org','(95) 93842-7092','58392-960','R. Nomlanga Wagner',151,'','Erasmus','Rio Grande','Minas Gerais'),(11,'Lana Frye','17550992319882','augue@protonmail.ca','(49) 94854-7296','89772-467','R. Mari Bell',452,'','Stone','Anápolis','Santa Catarina'),(12,'Barbara Battle','71551759358406','integer.sem@outlook.couk','(00) 91958-2809','55528-743','R. Roth Hendricks',621,'','Kyle','Marabá','Pernambuco'),(13,'Jameson Mann','13573606137027','non.egestas@protonmail.edu','(22) 98459-3629','52646-511','R. Raja Rutledge',76,'','Ivy','Caruaru','Maranhão'),(14,'Hunter Rogers','87459221995870','quisque.varius@icloud.edu','(23) 90175-6263','65585-568','R. Craig Thomas',258,'','Lisandra','Criciúma','São Paulo'),(15,'Mohammad Cline','65897675892825','diam@icloud.couk','(42) 95749-5654','44223-788','R. Shelley Wilkinson',780,'','Damian','Cabo de Santo Agostinho','Santa Catarina');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) DEFAULT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `usuario` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `salario` decimal(10,2) DEFAULT NULL,
  `celular` varchar(30) DEFAULT NULL,
  `cep` varchar(100) DEFAULT NULL,
  `rua` varchar(255) DEFAULT NULL,
  `numero` int DEFAULT NULL,
  `complemento` varchar(200) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'Cara Hull','9115186560','Cyrus','Melanie',149.00,'(53)91642-6287','39746333','R. Eric Surrame',28,'','Kay','Feira de Santana','RJ','Vendedor'),(2,'Hunter Church','48032986794','Sydney','Ramona',149.00,'(72)98359-4813','73738-666','R. Gloria Surrame',20,'','Elaine','Belford Roxo','RJ','Peão'),(3,'Amos Gardner','85194603166','Inez','Iris',151.00,'(44)98790-6466','43522-742','R. Desirae Surrame',872,'','Gage','Rio Grande','SP','Vendedor'),(4,'Sarah Mcdaniel','91984989594','Plato','Keelie',139.00,'(24)94979-5472','67303-621','R. Irene Surrame',799,'','Keith','Campinas','CE','Vendedor'),(5,'Denise Gamble','73644738544','Mercedes','Ann',114.00,'(34)96375-5717','61647-266','R. Austin Surrame',778,'','Alexander','Ribeirão Preto','GO','Peão'),(6,'Destiny Holder','38342480906','Melyssa','Justine',144.00,'(14)98875-4443','65166-322','R. Moses Surrame',757,'','Cairo','Paço do Lumiar','CE','Recepcionista'),(7,'Wyatt Baker','81443056206','Carson','Sandra',143.00,'(54)93347-8850','50077-775','R. Dale Surrame',297,'','Daquan','Caxias','RJ','Recepcionista'),(8,'Tashya Roberson','22498822835','Hedley','Minerva',149.00,'(56)92864-5664','68348-936','R. Camille Surrame',491,'','Cameron','Vitória da Conquista','GO','Vendedor'),(9,'Drake Gomez','40925806698','Yeo','Kiayada',121.00,'(76)96804-7554','37801651','R. Veronica Surrame',48,'','Gray','Florianópolis','CE','Vendedor'),(10,'Courtney Cortez','96436159296','Richard','Minerva',121.00,'(87)98208-2629','22286-871','R. Dustin Surrame',109,'','Chandler','Sobral','PR','Peão'),(11,'Craig Olsen','17101396727','Illana','Lara',115.00,'(37)97957-8068','25948-404','R. Rama Surrame',728,'','Moana','Jundiaí','SP','Peão'),(12,'Dillon Marquez','33279516951','Unity','Cara',107.00,'(62)97658-1732','13306-655','R. Jane Surrame',246,'','Alexander','Cascavel','CE','Recepcionista'),(13,'Liberty Fuller','57161369193','Chava','Latifah',108.00,'(53)96523-4071','60292-661','R. Hannah Surrame',48,'','Rhona','Cabo de Santo Agostinho','PB','Peão'),(14,'Jacob Campos','32140188600','Winter','Adele',110.00,'(71)96169-8233','83203-718','R. Lacey Surrame',267,'','Garrison','Maranguape','CE','Recepcionista'),(15,'Zeus Wilkinson','46500150815','Callie','Summer',131.00,'(97)94753-3103','63653-187','R. Whilemina Surrame',39,'','Allen','Piracicaba','SP','Recepcionista');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupoingrediente`
--

DROP TABLE IF EXISTS `grupoingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupoingrediente` (
  `id_GrupoIngrediente` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id_GrupoIngrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupoingrediente`
--

LOCK TABLES `grupoingrediente` WRITE;
/*!40000 ALTER TABLE `grupoingrediente` DISABLE KEYS */;
INSERT INTO `grupoingrediente` VALUES (1,' Carne'),(2,'Vegetal'),(3,'Tempero');
/*!40000 ALTER TABLE `grupoingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupoproduto`
--

DROP TABLE IF EXISTS `grupoproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupoproduto` (
  `id_GrupoProduto` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id_GrupoProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupoproduto`
--

LOCK TABLES `grupoproduto` WRITE;
/*!40000 ALTER TABLE `grupoproduto` DISABLE KEYS */;
INSERT INTO `grupoproduto` VALUES (1,' Bebida'),(2,'Prato');
/*!40000 ALTER TABLE `grupoproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingrediente`
--

DROP TABLE IF EXISTS `ingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingrediente` (
  `id_ingrediente` int NOT NULL AUTO_INCREMENT,
  `fornecedor_id` int NOT NULL,
  `subGrupoIngrediente_id` int NOT NULL,
  `nome` varchar(20) NOT NULL,
  `unid` varchar(5) NOT NULL,
  `estoque` float NOT NULL,
  `valor` float NOT NULL,
  PRIMARY KEY (`id_ingrediente`),
  KEY `fornecedor_id` (`fornecedor_id`),
  KEY `subGrupoIngrediente_id` (`subGrupoIngrediente_id`),
  CONSTRAINT `ingrediente_ibfk_1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id_fornecedor`),
  CONSTRAINT `ingrediente_ibfk_2` FOREIGN KEY (`subGrupoIngrediente_id`) REFERENCES `subgrupoingrediente` (`id_subGrupoIngrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingrediente`
--

LOCK TABLES `ingrediente` WRITE;
/*!40000 ALTER TABLE `ingrediente` DISABLE KEYS */;
INSERT INTO `ingrediente` VALUES (1,1,2,'Tomate','Kg',31,16.5),(2,2,2,'Abobrinha','Kg',0,87.5),(3,3,4,'Limão','Kg',32,68.5),(4,4,4,'Laranja','Kg',49,50.5),(5,5,4,'Peito de Frango','g',55,66.5),(6,6,1,'Coxa frango','L',41,65.5),(7,7,3,'Contra coxa frango','Kg',65,92.5),(8,8,2,'Costelinha porco','L',17,7.5),(9,9,4,'Alface','u',3,60.5),(10,10,4,'Vodka','ml',13,48.5),(11,11,1,'Queijo','g',80,22.5),(12,12,2,'Pimentão','g',62,71.5),(13,13,3,'Paprica','ml',94,69.5),(14,14,3,'Cebolinha','g',99,49.5),(15,15,1,'Oregano','g',29,43.5),(16,6,2,'Picanha','Kg',37,92.5),(17,11,1,'Chedar','Kg',64,71.5),(18,1,4,'Barbecue','L',93,34.5),(19,3,5,'Pão','ml',91,19.5),(20,7,3,'Bife','Kg',64,41.5);
/*!40000 ALTER TABLE `ingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemcompra`
--

DROP TABLE IF EXISTS `itemcompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemcompra` (
  `id_itemcompra` int NOT NULL AUTO_INCREMENT,
  `compra_id` int NOT NULL,
  `produto_id` int DEFAULT NULL,
  `ingrediente_id` int DEFAULT NULL,
  `quantidade` int NOT NULL,
  `subtotal` float NOT NULL,
  PRIMARY KEY (`id_itemcompra`),
  KEY `compra_id` (`compra_id`),
  KEY `produto_id` (`produto_id`),
  KEY `ingrediente_id` (`ingrediente_id`),
  CONSTRAINT `itemcompra_ibfk_1` FOREIGN KEY (`compra_id`) REFERENCES `compra` (`id_compra`),
  CONSTRAINT `itemcompra_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `itemcompra_ibfk_3` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemcompra`
--

LOCK TABLES `itemcompra` WRITE;
/*!40000 ALTER TABLE `itemcompra` DISABLE KEYS */;
INSERT INTO `itemcompra` VALUES (1,14,7,NULL,19,21),(2,7,7,NULL,47,47),(3,10,19,NULL,21,21),(4,1,2,NULL,68,22),(5,4,7,NULL,20,12),(6,8,16,NULL,15,13),(7,18,16,NULL,87,14),(8,15,18,NULL,74,124),(9,7,6,NULL,46,10),(10,15,15,NULL,34,67),(11,12,3,NULL,33,29),(12,15,10,NULL,87,10),(13,10,11,NULL,11,11),(14,16,12,NULL,66,66),(15,9,NULL,9,36,20),(16,16,NULL,8,92,89),(17,9,NULL,17,46,11),(18,12,NULL,10,95,90),(19,14,NULL,18,24,24),(20,18,NULL,7,42,56),(21,8,NULL,19,81,10),(22,12,NULL,19,10,81),(23,20,NULL,10,21,50),(24,2,NULL,1,50,90),(25,18,NULL,4,34,78),(26,7,NULL,12,89,12),(27,14,NULL,2,83,2),(28,1,NULL,10,52,23),(29,17,NULL,5,90,10),(30,2,NULL,2,55,9);
/*!40000 ALTER TABLE `itemcompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itempedido`
--

DROP TABLE IF EXISTS `itempedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itempedido` (
  `id_itempedido` int NOT NULL AUTO_INCREMENT,
  `pedido_id` int NOT NULL,
  `produto_id` int NOT NULL,
  PRIMARY KEY (`id_itempedido`),
  KEY `pedido_id` (`pedido_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `itempedido_ibfk_1` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id_pedido`),
  CONSTRAINT `itempedido_ibfk_2` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itempedido`
--

LOCK TABLES `itempedido` WRITE;
/*!40000 ALTER TABLE `itempedido` DISABLE KEYS */;
INSERT INTO `itempedido` VALUES (1,7,15),(2,14,13),(3,5,2),(4,8,8),(5,9,4),(6,18,4),(7,7,9),(8,9,13),(9,1,17),(10,4,13),(11,5,16),(12,2,19),(13,8,18),(14,19,14),(15,11,20),(16,12,20),(17,8,16),(18,20,2),(19,2,14),(20,19,4),(21,1,2),(22,14,4),(23,2,4),(24,2,12),(25,12,16),(26,6,15),(27,14,14),(28,1,14),(29,17,20),(30,17,2);
/*!40000 ALTER TABLE `itempedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemproduto`
--

DROP TABLE IF EXISTS `itemproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemproduto` (
  `id_itemproduto` int NOT NULL AUTO_INCREMENT,
  `ingrediente_id` int NOT NULL,
  `produto_id` int NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id_itemproduto`),
  KEY `produto_id` (`produto_id`),
  KEY `ingrediente_id` (`ingrediente_id`),
  CONSTRAINT `itemproduto_ibfk_1` FOREIGN KEY (`produto_id`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `itemproduto_ibfk_2` FOREIGN KEY (`ingrediente_id`) REFERENCES `ingrediente` (`id_ingrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemproduto`
--

LOCK TABLES `itemproduto` WRITE;
/*!40000 ALTER TABLE `itemproduto` DISABLE KEYS */;
INSERT INTO `itemproduto` VALUES (1,6,6,30),(2,4,16,31),(3,11,18,43),(4,13,11,84),(5,13,13,67),(6,2,11,92),(7,10,1,35),(8,6,18,16),(9,8,9,87),(10,15,5,69),(11,2,19,26),(12,18,20,44),(13,10,18,79),(14,8,13,49),(15,9,18,85),(16,7,5,25),(17,17,9,54),(18,3,5,54),(19,3,16,9),(20,5,13,26),(21,19,9,57),(22,11,18,59),(23,15,12,50),(24,2,19,58),(25,13,4,62),(26,8,11,55),(27,2,10,4),(28,4,5,96),(29,5,11,86),(30,1,16,58);
/*!40000 ALTER TABLE `itemproduto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mesa`
--

DROP TABLE IF EXISTS `mesa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mesa` (
  `id_mesa` int NOT NULL AUTO_INCREMENT,
  `estado` tinyint(1) NOT NULL,
  PRIMARY KEY (`id_mesa`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mesa`
--

LOCK TABLES `mesa` WRITE;
/*!40000 ALTER TABLE `mesa` DISABLE KEYS */;
INSERT INTO `mesa` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1);
/*!40000 ALTER TABLE `mesa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `metodopagamento`
--

DROP TABLE IF EXISTS `metodopagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `metodopagamento` (
  `id_metodopagamento` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_metodopagamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `metodopagamento`
--

LOCK TABLES `metodopagamento` WRITE;
/*!40000 ALTER TABLE `metodopagamento` DISABLE KEYS */;
INSERT INTO `metodopagamento` VALUES (1,'Cartão de Credito'),(2,'Cartão de Debito'),(3,'Pix'),(4,'A vista'),(5,'Boleto');
/*!40000 ALTER TABLE `metodopagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `mesa_id` int NOT NULL,
  `funcionario_id` int NOT NULL,
  `metodopagamento_id` int NOT NULL,
  `valortotal` float NOT NULL,
  `hora` varchar(20) NOT NULL,
  `dia` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `metodopagamento_id` (`metodopagamento_id`),
  KEY `mesa_id` (`mesa_id`),
  KEY `funcionario_id` (`funcionario_id`),
  CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`metodopagamento_id`) REFERENCES `metodopagamento` (`id_metodopagamento`),
  CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`mesa_id`) REFERENCES `mesa` (`id_mesa`),
  CONSTRAINT `pedido_ibfk_3` FOREIGN KEY (`funcionario_id`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,24,2,3,42.5,'9:10','23/Jul/2022'),(2,8,4,1,92.5,'9:47','7/Jan/2022'),(3,7,4,1,133.5,'8:08','20/Aug/2022'),(4,17,3,2,105.5,'8:33','9/Jun/2022'),(5,18,8,1,67.5,'9:50','22/Jan/2022'),(6,5,1,1,83.5,'11:28','3/Sep/2022'),(7,15,6,1,128.5,'9:16','24/Apr/2022'),(8,9,1,1,87.5,'9:57','17/Mar/2022'),(9,19,9,1,114.5,'7:48','6/Sep/2022'),(10,19,9,1,2.5,'9:48','6/Sep/2022'),(11,22,3,2,8.5,'8:55','11/May/2022'),(12,24,2,2,126.5,'11:49','16/Jun/2022'),(13,10,2,3,190.5,'7:55','23/Feb/2022'),(14,17,1,1,59.5,'9:56','19/Oct/2022'),(15,11,6,1,57.5,'11:59','19/Mar/2022'),(16,9,5,2,31.5,'7:54','9/Aug/2022'),(17,23,4,3,99.5,'11:43','17/Mar/2022'),(18,22,5,1,114.5,'7:30','12/May/2022'),(19,3,9,1,102.5,'11:31','20/Nov/2022'),(20,23,4,3,168.5,'7:22','7/Oct/2022');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id_produto` int NOT NULL AUTO_INCREMENT,
  `fornecedor_id` int DEFAULT NULL,
  `subGrupoProduto_id` int NOT NULL,
  `nome` varchar(20) NOT NULL,
  `unid` varchar(5) NOT NULL,
  `estoque` float NOT NULL,
  `valor` float NOT NULL,
  `descricao` varchar(20) NOT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `fornecedor_id` (`fornecedor_id`),
  KEY `subGrupoProduto_id` (`subGrupoProduto_id`),
  CONSTRAINT `produto_ibfk_1` FOREIGN KEY (`fornecedor_id`) REFERENCES `fornecedor` (`id_fornecedor`),
  CONSTRAINT `produto_ibfk_2` FOREIGN KEY (`subGrupoProduto_id`) REFERENCES `subgrupoproduto` (`id_subGrupoProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,2,4,'Porção Picanha','g',87,6.5,''),(2,3,3,'Frango a passarinho','g',4,5.5,''),(3,1,4,'Porção Tilapia','g',84,21.5,''),(4,4,3,'Coca 600','ml',85,2.5,''),(5,6,2,'Fanta 350','g',30,16.5,''),(6,5,4,'Arroz e feijão','ml',77,2.5,''),(7,4,2,'Sprite 350','ml',97,67.5,''),(8,7,4,'Coca 2L','L',39,52.5,''),(9,8,1,'Coca 1L','L',82,62.5,''),(10,1,4,'Bife acebolado','g',11,2.5,''),(11,9,4,'Pizza Calabresa','L',67,32.5,''),(12,12,4,'Pizza a moda','ml',90,47.5,''),(13,10,2,'Suco laranja','ml',35,72.5,''),(14,11,2,'Suco limão','ml',37,65.5,''),(15,12,2,'Caipirinha','ml',47,33.5,''),(16,13,2,'Mojito','ml',41,29.5,''),(17,14,4,'Feijoada','Kg',30,6.5,''),(18,11,4,'Strogonoff','L',97,52.5,''),(19,7,4,'Muceca','Kg',59,85.5,''),(20,2,4,'Lasanha','Kg',41,69.5,'');
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subgrupoingrediente`
--

DROP TABLE IF EXISTS `subgrupoingrediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subgrupoingrediente` (
  `id_subGrupoIngrediente` int NOT NULL AUTO_INCREMENT,
  `GrupoIngrediente_id` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id_subGrupoIngrediente`),
  KEY `GrupoIngrediente_id` (`GrupoIngrediente_id`),
  CONSTRAINT `subgrupoingrediente_ibfk_1` FOREIGN KEY (`GrupoIngrediente_id`) REFERENCES `grupoingrediente` (`id_GrupoIngrediente`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subgrupoingrediente`
--

LOCK TABLES `subgrupoingrediente` WRITE;
/*!40000 ALTER TABLE `subgrupoingrediente` DISABLE KEYS */;
INSERT INTO `subgrupoingrediente` VALUES (1,1,'Frango'),(2,1,'Boi'),(3,1,'Porco'),(4,2,'Grão'),(5,2,'Folha'),(6,2,'Fruta'),(7,2,'Raiz'),(8,2,'Forte'),(9,2,'Fraco');
/*!40000 ALTER TABLE `subgrupoingrediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subgrupoproduto`
--

DROP TABLE IF EXISTS `subgrupoproduto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subgrupoproduto` (
  `id_subGrupoProduto` int NOT NULL AUTO_INCREMENT,
  `GrupoProduto_id` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id_subGrupoProduto`),
  KEY `GrupoProduto_id` (`GrupoProduto_id`),
  CONSTRAINT `subgrupoproduto_ibfk_1` FOREIGN KEY (`GrupoProduto_id`) REFERENCES `grupoproduto` (`id_GrupoProduto`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subgrupoproduto`
--

LOCK TABLES `subgrupoproduto` WRITE;
/*!40000 ALTER TABLE `subgrupoproduto` DISABLE KEYS */;
INSERT INTO `subgrupoproduto` VALUES (1,1,'Refrigerante'),(2,1,'Suco'),(3,2,'Entrada'),(4,2,'Principal'),(5,1,'Vinho');
/*!40000 ALTER TABLE `subgrupoproduto` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-01  8:26:04
