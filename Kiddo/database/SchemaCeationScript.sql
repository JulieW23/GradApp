-- MySQL Script generated by MySQL Workbench
-- Sun 13 Nov 2016 06:14:36 PM EST
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema kiddodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `kiddodb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
SHOW WARNINGS;
USE `kiddodb` ;

-- -----------------------------------------------------
-- Table `kiddodb`.`Administrators`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Administrators` (
  `idAdministrator` INT NOT NULL,
  `idSchool` INT NOT NULL,
  `uname` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAdministrator`),
  UNIQUE INDEX `idAdministrator_UNIQUE` (`idAdministrator` ASC),
  UNIQUE INDEX `idSchool_UNIQUE` (`idSchool` ASC),
  UNIQUE INDEX `uname_UNIQUE` (`uname` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Teachers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Teachers` (
  `idTeacher` INT NOT NULL,
  `idSchool` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `uname` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTeacher`),
  UNIQUE INDEX `idTeacher_UNIQUE` (`idTeacher` ASC),
  INDEX `fk_Teachers_1_idx` (`idSchool` ASC),
  UNIQUE INDEX `uname_UNIQUE` (`uname` ASC),
  CONSTRAINT `fk_Teachers_1`
    FOREIGN KEY (`idSchool`)
    REFERENCES `kiddodb`.`Administrators` (`idSchool`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Classes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Classes` (
  `idClass` INT NOT NULL,
  `idSchool` INT NOT NULL,
  `idTeacher` INT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idClass`),
  INDEX `fk_Classes_2_idx` (`idTeacher` ASC),
  CONSTRAINT `fk_Classes_1`
    FOREIGN KEY (`idSchool`)
    REFERENCES `kiddodb`.`Administrators` (`idSchool`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Classes_2`
    FOREIGN KEY (`idTeacher`)
    REFERENCES `kiddodb`.`Teachers` (`idTeacher`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Students` (
  `idStudent` INT NOT NULL,
  `name` VARCHAR(90) NOT NULL,
  `idClass` INT NOT NULL,
  `idParent1` INT NOT NULL,
  `idParent2` INT NOT NULL,
  PRIMARY KEY (`idStudent`),
  INDEX `fk_Students_1_idx` (`idParent1` ASC, `idParent2` ASC),
  INDEX `fk_Students_2_idx` (`idClass` ASC),
  CONSTRAINT `fk_Students_1`
    FOREIGN KEY (`idParent1` , `idParent2`)
    REFERENCES `kiddodb`.`Parents` (`idParent` , `idParent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_Students_2`
    FOREIGN KEY (`idClass`)
    REFERENCES `kiddodb`.`Classes` (`idClass`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Parents`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Parents` (
  `idParent` INT NOT NULL,
  `fName` VARCHAR(45) NOT NULL,
  `lName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `uname` VARCHAR(45) NOT NULL,
  `pass` VARCHAR(45) NOT NULL,
  `idStudent` INT NULL,
  PRIMARY KEY (`idParent`),
  UNIQUE INDEX `uname_UNIQUE` (`uname` ASC),
  UNIQUE INDEX `idParent_UNIQUE` (`idParent` ASC),
  INDEX `fk_Parents_1_idx` (`idStudent` ASC),
  CONSTRAINT `fk_Parents_1`
    FOREIGN KEY (`idStudent`)
    REFERENCES `kiddodb`.`Students` (`idStudent`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Events`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Events` (
  `idEvent` INT NOT NULL,
  `idClass` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `location` VARCHAR(45) NULL,
  `startTime` DATETIME NOT NULL,
  `endTime` DATETIME NOT NULL,
  `comments` LONGTEXT NULL,
  PRIMARY KEY (`idEvent`),
  INDEX `fk_Events_1_idx` (`idClass` ASC),
  UNIQUE INDEX `idEvent_UNIQUE` (`idEvent` ASC),
  CONSTRAINT `fk_Events_1`
    FOREIGN KEY (`idClass`)
    REFERENCES `kiddodb`.`Classes` (`idClass`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Messages`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Messages` (
  `idMessage` INT NOT NULL,
  `idSender` INT NOT NULL,
  `idRecipient` INT NOT NULL,
  `creationTime` DATETIME NOT NULL,
  `readTime` DATETIME NULL,
  `body` LONGTEXT NULL,
  `media` BLOB NULL,
  PRIMARY KEY (`idMessage`),
  UNIQUE INDEX `idMessage_UNIQUE` (`idMessage` ASC))
ENGINE = InnoDB;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `kiddodb`.`Announcements`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `kiddodb`.`Announcements` (
  `postTime` DATETIME NOT NULL,
  `idClass` INT NOT NULL,
  `title` VARCHAR(80) NOT NULL,
  `body` LONGTEXT NULL,
  `media` BLOB NULL,
  INDEX `fk_Announcements_1_idx` (`idClass` ASC),
  PRIMARY KEY (`postTime`),
  UNIQUE INDEX `postTime_UNIQUE` (`postTime` ASC),
  CONSTRAINT `fk_Announcements_1`
    FOREIGN KEY (`idClass`)
    REFERENCES `kiddodb`.`Classes` (`idClass`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
