CREATE TABLE `demo`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `demo`.`order` (
  `id` INT NOT NULL,
  `full_name` VARCHAR(255) NOT NULL,
  `telephone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

ALTER TABLE `demo`.`product`
  ADD COLUMN `order_id` INT(11) NULL AFTER `price`;


ALTER TABLE `demo`.`order`
  CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO `demo`.`order` (`full_name`, `telephone`) VALUES ('client 1', '123123213');


