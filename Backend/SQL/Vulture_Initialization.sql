SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `Vulture` ;
CREATE SCHEMA IF NOT EXISTS `Vulture` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `Vulture` ;

-- -----------------------------------------------------
-- Table `Vulture`.`Gender`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Gender` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Gender` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Sexuality`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Sexuality` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Sexuality` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`HairColor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`HairColor` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`HairColor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Tutor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Tutor` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Tutor` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `CostPerHour` DECIMAL(10,2) NULL ,
  `Rating` INT NULL ,
  `Description` LONGTEXT NULL ,
  `Height` INT NULL ,
  `Weight` INT NULL ,
  `HairColor` INT UNSIGNED NOT NULL ,
  `HasTattoos` TINYINT(1) NULL ,
  `Active` TINYINT(1) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Tutor_HairColor1_idx` (`HairColor` ASC) ,
  CONSTRAINT `fk_Tutor_HairColor`
    FOREIGN KEY (`HairColor` )
    REFERENCES `Vulture`.`HairColor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Users` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Users` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Username` VARCHAR(40) NULL ,
  `Password` VARCHAR(40) NOT NULL ,
  `Email` VARCHAR(128) NOT NULL ,
  `FirstName` VARCHAR(45) NULL ,
  `LastName` VARCHAR(45) NULL ,
  `Address` VARCHAR(256) NULL ,
  `City` VARCHAR(45) NULL ,
  `State` VARCHAR(2) NULL ,
  `ZipCode` VARCHAR(5) NULL ,
  `Age` INT UNSIGNED NULL ,
  `Sexuality` INT UNSIGNED NULL ,
  `Gender` INT UNSIGNED NULL ,
  `Tutor` INT UNSIGNED NULL ,
  `Active` TINYINT(1) NULL ,
  `DateCreated` DATETIME NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `UserName_UNIQUE` (`Username` ASC) ,
  UNIQUE INDEX `Email_UNIQUE` (`Email` ASC) ,
  INDEX `fk_Users_Gender1_idx` (`Gender` ASC) ,
  INDEX `fk_Users_Sexuality1_idx` (`Sexuality` ASC) ,
  INDEX `fk_Users_Tutor1_idx` (`Tutor` ASC) ,
  CONSTRAINT `fk_Users_Gender`
    FOREIGN KEY (`Gender` )
    REFERENCES `Vulture`.`Gender` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_Sexuality`
    FOREIGN KEY (`Sexuality` )
    REFERENCES `Vulture`.`Sexuality` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Users_Tutor`
    FOREIGN KEY (`Tutor` )
    REFERENCES `Vulture`.`Tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`UserImage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`UserImage` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`UserImage` (
  `UserID` INT UNSIGNED NOT NULL ,
  `ImagePath` VARCHAR(64) NOT NULL ,
  INDEX `UserID_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_UserImage_User_ID`
    FOREIGN KEY (`UserID` )
    REFERENCES `Vulture`.`Users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Subject`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Subject` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Subject` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`TutorOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`TutorOrder` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`TutorOrder` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Date` DATETIME NULL ,
  `Location` VARCHAR(512) NULL ,
  `LengthHours` INT NULL ,
  `TotalCost` DECIMAL(10,2) NULL ,
  `Comments` LONGTEXT NULL ,
  `UserID` INT UNSIGNED NOT NULL ,
  `TutorID` INT UNSIGNED NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_TutorOrder_Tutor1_idx` (`TutorID` ASC) ,
  INDEX `fk_TutorOrder_Users1_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_TutorOrder_Tutor_ID`
    FOREIGN KEY (`TutorID` )
    REFERENCES `Vulture`.`Tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TutorOrder_Users_ID`
    FOREIGN KEY (`UserID` )
    REFERENCES `Vulture`.`Users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`PurchaseMethords`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`PurchaseMethords` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`PurchaseMethords` (
  `UserID` INT UNSIGNED NULL ,
  `WalletAddress` VARCHAR(255) NULL ,
  INDEX `UserID_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_PurchaseMethods_User_ID`
    FOREIGN KEY (`UserID` )
    REFERENCES `Vulture`.`Users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Schedule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Schedule` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Schedule` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `TutorID` INT UNSIGNED NULL ,
  `StartDateTime` DATETIME NULL ,
  `Length` INT NULL ,
  `EventName` VARCHAR(50) NULL ,
  `Description` VARCHAR(500) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Schedule_Tutor1_idx` (`TutorID` ASC) ,
  CONSTRAINT `fk_Schedule_Tutor_ID`
    FOREIGN KEY (`TutorID` )
    REFERENCES `Vulture`.`Tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Products`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Products` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Products` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Name` VARCHAR(45) NULL ,
  `Description` LONGTEXT NULL ,
  `Rating` INT NULL ,
  `Qantity` INT NULL ,
  `Cost` DECIMAL(10,2) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`ProductImage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`ProductImage` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`ProductImage` (
  `productID` INT UNSIGNED NOT NULL ,
  `ImagePath` VARCHAR(45) NOT NULL ,
  CONSTRAINT `fk_Product_Image_Product_ID`
    FOREIGN KEY (`productID` )
    REFERENCES `Vulture`.`Products` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`ProductOrder`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`ProductOrder` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`ProductOrder` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ProductID` INT UNSIGNED NULL ,
  `Quantity` INT NULL ,
  `Cost` DECIMAL(10,2) NULL ,
  `Date` DATETIME NULL ,
  `UserID` INT UNSIGNED NULL COMMENT '	' ,
  `Comments` LONGTEXT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ProductOrder_Products1_idx` (`ProductID` ASC) ,
  CONSTRAINT `fk_ProductOrder_Products_ID`
    FOREIGN KEY (`ProductID` )
    REFERENCES `Vulture`.`Products` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`Ratings`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`Ratings` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`Ratings` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `Rating` DOUBLE NULL ,
  `Comment` VARCHAR(500) NULL ,
  `ProductID` INT UNSIGNED NULL ,
  `TutorID` INT UNSIGNED NULL ,
  `Date` DATETIME NULL ,
  `UserID` INT UNSIGNED NULL ,
  `Recommend` TINYINT(1) NULL ,
  `Verified` TINYINT(1) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_Ratings_Products1_idx` (`ProductID` ASC) ,
  INDEX `fk_Ratings_Tutor_ID_idx` (`TutorID` ASC) ,
  INDEX `fk_Ratings_User_ID_idx` (`UserID` ASC) ,
  CONSTRAINT `fk_Ratings_Products_ID`
    FOREIGN KEY (`ProductID` )
    REFERENCES `Vulture`.`Products` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ratings_Tutor_ID`
    FOREIGN KEY (`TutorID` )
    REFERENCES `Vulture`.`Tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ratings_User_ID`
    FOREIGN KEY (`UserID` )
    REFERENCES `Vulture`.`Users` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`TutorSubjects`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`TutorSubjects` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`TutorSubjects` (
  `TutorID` INT UNSIGNED NOT NULL ,
  `SubjectID` INT UNSIGNED NOT NULL ,
  INDEX `fk_TutorSubjects_Subject1_idx` (`SubjectID` ASC) ,
  CONSTRAINT `fk_TutorSubjects_SubjectID`
    FOREIGN KEY (`SubjectID` )
    REFERENCES `Vulture`.`Subject` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_TutorSubjects_TutorID`
    FOREIGN KEY (`TutorID` )
    REFERENCES `Vulture`.`Tutor` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Vulture`.`OrderItems`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Vulture`.`OrderItems` ;

CREATE  TABLE IF NOT EXISTS `Vulture`.`OrderItems` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT ,
  `ProductID` INT UNSIGNED NULL ,
  `Quantity` INT NULL ,
  `OrderID` INT UNSIGNED NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `OrderID_idx` (`OrderID` ASC) ,
  INDEX `ProductID_idx` (`ProductID` ASC) ,
  CONSTRAINT `fk_OrderItems_ProductOrder_ID`
    FOREIGN KEY (`OrderID` )
    REFERENCES `Vulture`.`ProductOrder` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orderITems_Product_ID`
    FOREIGN KEY (`ProductID` )
    REFERENCES `Vulture`.`Products` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `Vulture` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
