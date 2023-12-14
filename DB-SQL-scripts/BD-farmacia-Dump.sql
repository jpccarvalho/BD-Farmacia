-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bdfarmacia
-- ------------------------------------------------------
-- Server version	8.0.34

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `endereco` varchar(200) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `codigo_postal` varchar(15) NOT NULL,
  `localidade` varchar(45) NOT NULL,
  `numero_contribuinte` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Pedro Gouveia','Rua Ingram 20, Forest Hills','(11)92382-2313','3421399','Belo Horizonte','232.123.898-23'),(2,'Bruce Wayne','Rua da Gotham City','(11)217327918','2131239','Belo Horizonte','123.145.576.89'),(3,'Patrick Watson','Rua dos Abraços','(21)98782-2343','3424549','Alfenas','178.465.677.89'),(4,'Mary Jane Watson','Rua dos Abraços, 45','(21)98213-5487','3424549','Alfenas','198.754.223.61'),(5,'Diana Prince','Avenida Themyscira, 123','(11)91732-5648','1234567','Gotham City','456.789.123.45'),(6,'Bruce Wayne','Mansão Wayne, Gotham City','(11)88888-8888','1234567','Gotham City','123.000.111.22'),(7,'Tony Stark','Torre Stark, Malibu','(12)55555-5555','5432198','Los Angeles','987.654.321.00'),(8,'Steve Rogers','Apartamento 2B, Brooklyn','(12)44444-4444','1122334','New York','222.333.444.55'),(9,'Peter Parker','Apartamento 5A, Forest Hills','(11)92382-2313','3421399','Belo Horizonte','232.123.898.23'),(10,'Clark Kent','Fazenda Kent, Smallville','(23)77777-7777','6789012','Metropolis','777.888.999.11'),(11,'Barry Allen','Laboratório Star Labs, Central City','(13)99999-9999','9876543','Central City','888.777.666.55'),(12,'Oliver Queen','Mansão Queen, Star City','(14)77777-7777','7654321','Star City','777.666.555.44'),(13,'John','123 Main Street, Anytown','(99)12345-6789','5432109','Anytown','111.222.333.44');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_cliente` int NOT NULL,
  `data_compra` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compras_1_idx` (`id_cliente`),
  CONSTRAINT `fk_compras_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (1,1,'2019-05-18'),(2,1,'2023-09-12'),(3,2,'2023-08-25'),(4,3,'2023-10-05'),(5,4,'2023-09-21'),(6,5,'2023-09-15'),(7,6,'2023-09-30'),(8,7,'2023-08-10'),(9,8,'2023-07-29'),(10,9,'2023-08-18'),(11,10,'2023-08-01'),(12,11,'2023-10-09'),(13,12,'2023-09-05'),(14,13,'2023-09-12'),(15,1,'2021-06-15'),(16,2,'2021-07-20'),(17,3,'2021-08-25'),(18,4,'2021-09-10'),(19,5,'2022-03-05'),(20,6,'2022-04-18'),(21,7,'2022-05-22'),(22,8,'2022-06-30'),(23,9,'2022-07-12'),(24,10,'2022-08-24'),(25,11,'2022-09-01'),(26,12,'2022-10-07'),(27,13,'2022-11-15');
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fabricantes`
--

DROP TABLE IF EXISTS `fabricantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fabricantes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fabricante` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fabricantes`
--

LOCK TABLES `fabricantes` WRITE;
/*!40000 ALTER TABLE `fabricantes` DISABLE KEYS */;
INSERT INTO `fabricantes` VALUES (1,'Roche'),(2,'Vitalis'),(3,'Palmolive'),(4,'Bayer'),(5,'Johnson & Johnson'),(6,'Pfizer'),(7,'GSK (GlaxoSmithKline)'),(8,'Sanofi'),(9,'Procter & Gamble'),(10,'Unilever'),(11,'Colgate-Palmolive'),(12,'Nestlé'),(13,'Aveeno');
/*!40000 ALTER TABLE `fabricantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicos`
--

DROP TABLE IF EXISTS `medicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(200) NOT NULL,
  `CRM` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicos`
--

LOCK TABLES `medicos` WRITE;
/*!40000 ALTER TABLE `medicos` DISABLE KEYS */;
INSERT INTO `medicos` VALUES (1,'Paulo César','232131-MG'),(2,'Paula Carvalho','276251-SP'),(3,'Felipe','129383-RS'),(4,'Maria Santos','175632-RJ'),(5,'Ricardo Oliveira','342179-SP'),(6,'Ana Costa','198723-MG'),(7,'Fernando Pereira','276541-PR'),(8,'Carla Martins','128765-RJ'),(9,'Roberto eu','234567-SP'),(10,'Lúcia Ferreira','319876-PR'),(11,'André fortuna','289876-MG');
/*!40000 ALTER TABLE `medicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `produto` varchar(45) NOT NULL,
  `desiginacao` varchar(200) NOT NULL,
  `composicao` varchar(200) NOT NULL,
  `preco_venda` double DEFAULT NULL,
  `id_tipo_produto` int NOT NULL,
  `id_fabricante` int NOT NULL,
  `designacao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produtos_1_idx` (`id_tipo_produto`),
  KEY `fk_produtos_2_idx` (`id_fabricante`),
  CONSTRAINT `fk_produtos_1` FOREIGN KEY (`id_tipo_produto`) REFERENCES `tipos_produtos` (`id`),
  CONSTRAINT `fk_produtos_2` FOREIGN KEY (`id_fabricante`) REFERENCES `fabricantes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (2,'Dipirona','Dores em geral','Metil-propileno',10.44,1,1,NULL),(3,'Dorflex','Alívio da dor','Paracetamol e Orfenadrina',9.99,1,4,NULL),(4,'Tylenol','Analgésico','Paracetamol',79,1,4,NULL),(5,'Loção Hidratante','Hidratação Corporal','Manteiga de Karité',14.99,2,2,NULL),(6,'Creme Antirrugas','Anti-Envelhecimento','Ácido Hialurônico',29.99,2,2,NULL),(7,'Escova de Dentes','Higiene Bucal','Cerdas Macias',4,3,3,NULL),(8,'Sabonete Líquido','Limpeza Corporal','Glicerina',3.5,3,3,NULL),(9,'Vitamina C','Suplemento','Ácido Ascórbico',12.99,7,4,NULL),(10,'Multivitamínico','Suplemento','Vitaminas A a Z',19.99,7,4,NULL),(11,'Kit de Primeiros Socorros','Emergências','Vários Itens',29.99,8,5,NULL),(12,'Curativo Adesivo','Curativo','Tecido não Tecido',1.99,8,5,NULL),(13,'Creme Hidratante','Hidratação Facial','Ácido Hialurônico',19.99,2,2,NULL),(14,'Loção Solar','Proteção Solar','Óxido de Zinco',15.99,2,2,NULL),(15,'Termômetro Digital','Medição de Temperatura','Eletrônico',6.99,10,1,NULL),(16,'Babador Infantil','Cuidados com Bebês','Tecido Lavável',3.49,11,8,NULL),(17,'Fralda Descartável','Cuidados com Bebês','Polpa de Celulose',16.99,11,8,NULL),(18,'Xampu Infantil','Higiene Capilar','Extrato de Camomila',4.99,6,3,NULL),(19,'Hidratante para Bebês','Cuidados com Bebês','Manteiga de Karité',5.99,6,2,NULL);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_compra`
--

DROP TABLE IF EXISTS `produtos_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_compra` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produto` int NOT NULL,
  `id_compra` int NOT NULL,
  `quantidade` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_produtos_compra_1_idx` (`id_produto`),
  KEY `fk_produtos_compra_2_idx` (`id_compra`),
  CONSTRAINT `fk_produtos_compra_1` FOREIGN KEY (`id_produto`) REFERENCES `produtos` (`id`),
  CONSTRAINT `fk_produtos_compra_2` FOREIGN KEY (`id_compra`) REFERENCES `compras` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_compra`
--

LOCK TABLES `produtos_compra` WRITE;
/*!40000 ALTER TABLE `produtos_compra` DISABLE KEYS */;
INSERT INTO `produtos_compra` VALUES (4,2,1,2),(5,2,1,2),(6,2,2,1),(8,4,2,2),(9,5,3,3),(10,6,4,1),(11,7,5,2),(12,8,6,3),(14,10,7,2),(15,11,8,3),(16,12,9,2),(17,13,10,1),(18,14,11,3),(19,15,12,2),(20,16,13,1),(21,17,14,2),(22,18,15,3),(23,19,16,1),(24,2,17,2),(25,3,18,3);
/*!40000 ALTER TABLE `produtos_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receitas_medica`
--

DROP TABLE IF EXISTS `receitas_medica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receitas_medica` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `id_produto_compra` int NOT NULL,
  `id_medico` int NOT NULL,
  `receita` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_receitas_medica_1_idx` (`id_medico`),
  KEY `fk_receitas_medica_2_idx` (`id_produto_compra`),
  CONSTRAINT `fk_receitas_medica_1` FOREIGN KEY (`id_medico`) REFERENCES `medicos` (`id`),
  CONSTRAINT `fk_receitas_medica_2` FOREIGN KEY (`id_produto_compra`) REFERENCES `produtos_compra` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receitas_medica`
--

LOCK TABLES `receitas_medica` WRITE;
/*!40000 ALTER TABLE `receitas_medica` DISABLE KEYS */;
INSERT INTO `receitas_medica` VALUES (6,4,1,'receita.pdf'),(7,4,1,'receita1.pdf'),(8,4,2,'receita2.pdf'),(10,12,4,'receita4.pdf'),(11,8,5,'receita5.pdf');
/*!40000 ALTER TABLE `receitas_medica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipos_produtos`
--

DROP TABLE IF EXISTS `tipos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipos_produtos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipos_produtos`
--

LOCK TABLES `tipos_produtos` WRITE;
/*!40000 ALTER TABLE `tipos_produtos` DISABLE KEYS */;
INSERT INTO `tipos_produtos` VALUES (1,'Remédios'),(2,'Cosmético'),(3,'Diversos'),(6,'Produtos de Higiene Pessoal'),(7,'Vitaminas e Suplementos'),(8,'Primeiros Socorros'),(9,'Medicação com Receita'),(10,'Acessórios para Saúde'),(11,'Cuidados com Bebês');
/*!40000 ALTER TABLE `tipos_produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-14 10:29:08
