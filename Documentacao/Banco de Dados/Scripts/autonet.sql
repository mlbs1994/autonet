-- MySQL Script generated by MySQL Workbench
-- 06/29/17 14:29:23
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema autonet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema autonet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `autonet` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `autonet` ;

-- -----------------------------------------------------
-- Table `autonet`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`endereco` (
  `idEndereco` INT NOT NULL AUTO_INCREMENT,
  `logradouro` VARCHAR(100) NOT NULL,
  `numero` INT NOT NULL,
  `complemento` VARCHAR(45) NULL,
  `bairro` VARCHAR(45) NULL,
  `cidade` VARCHAR(45) NULL,
  `estado` VARCHAR(3) NULL,
  PRIMARY KEY (`idEndereco`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(90) NOT NULL,
  `login` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `telefone` VARCHAR(45) NOT NULL,
  `celular` VARCHAR(45) NOT NULL,
  `idEndereco` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_usuario_endereco_idx` (`idEndereco` ASC),
  CONSTRAINT `fk_usuario_endereco`
    FOREIGN KEY (`idEndereco`)
    REFERENCES `autonet`.`endereco` (`idEndereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `fk_cliente_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_cliente_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `autonet`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`funcionario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`funcionario` (
  `idFuncionario` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  INDEX `fk_funcionario_usuario1_idx` (`idUsuario` ASC),
  CONSTRAINT `fk_funcionario_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `autonet`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`fabricante` (
  `idFabricante` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`idFabricante`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`carro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`carro` (
  `idCarro` INT NOT NULL AUTO_INCREMENT,
  `modelo` VARCHAR(60) NOT NULL,
  `imagem` VARCHAR(150) NULL,
  `descricao` VARCHAR(200) NULL,
  `valorAluguel` FLOAT NULL,
  `idUsuario` INT NULL,
  `idFabricante` INT NOT NULL,
  `idCategoria` INT NOT NULL,
  PRIMARY KEY (`idCarro`),
  INDEX `fk_carro_usuario1_idx` (`idUsuario` ASC),
  INDEX `fk_carro_fabricante1_idx` (`idFabricante` ASC),
  INDEX `fk_carro_categoria1_idx` (`idCategoria` ASC),
  CONSTRAINT `fk_carro_usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `autonet`.`usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carro_fabricante1`
    FOREIGN KEY (`idFabricante`)
    REFERENCES `autonet`.`fabricante` (`idFabricante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_carro_categoria1`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `autonet`.`categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`bandeira`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`bandeira` (
  `idBandeira` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idBandeira`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `autonet`.`cartao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `autonet`.`cartao` (
  `idCartao` INT NOT NULL AUTO_INCREMENT,
  `numero` VARCHAR(45) NOT NULL,
  `codigoSeguranca` VARCHAR(45) NOT NULL,
  `idBandeira` INT NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idCartao`),
  INDEX `fk_cartao_cliente1_idx` (`idCliente` ASC),
  INDEX `fk_cartao_bandeira1_idx` (`idBandeira` ASC),
  CONSTRAINT `fk_cartao_cliente1`
    FOREIGN KEY (`idCliente`)
    REFERENCES `autonet`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cartao_bandeira1`
    FOREIGN KEY (`idBandeira`)
    REFERENCES `autonet`.`bandeira` (`idBandeira`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
