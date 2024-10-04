-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema guarniapp
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema guarniapp
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `guarniapp` ;
USE `guarniapp` ;

-- -----------------------------------------------------
-- Table `guarniapp`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guarniapp`.`user` (
  `iduser` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(10) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guarniapp`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guarniapp`.`categoria` (
  `idcategoria` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  `marcas` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guarniapp`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guarniapp`.`post` (
  `idpost` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `post_description` VARCHAR(500) NOT NULL,
  `post_file` VARCHAR(500) NOT NULL,
  `post_date` DATE NOT NULL,
  `post_title` VARCHAR(45) NOT NULL,
  `user_iduser` INT NOT NULL,
  `categoria_idcategoria` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`idpost`, `user_iduser`, `categoria_idcategoria`),
  INDEX `fk_post_user1_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_post_categoria1_idx` (`categoria_idcategoria` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `guarniapp`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `guarniapp`.`comments` (
  `idcomments` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `comment` VARCHAR(45) NOT NULL,
  `user_iduser` INT NOT NULL,
  `post_idpost` INT NOT NULL,
  `comment_date` DATE NOT NULL,
  PRIMARY KEY (`idcomments`, `user_iduser`, `post_idpost`),
  INDEX `fk_comments_user1_idx` (`user_iduser` ASC) VISIBLE,
  INDEX `fk_comments_post1_idx` (`post_idpost` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
