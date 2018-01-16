CREATE TABLE `demo`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` FLOAT NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `demo`.`orders` (
  `id` INT NOT NULL,
  `full_name` VARCHAR(255) NOT NULL,
  `telephone` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC));

ALTER TABLE `demo`.`product`
  ADD COLUMN `order_id` INT(11) NULL AFTER `price`;


ALTER TABLE `demo`.`orders`
  CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT ;

INSERT INTO `demo`.`product` (`name`, `price`) VALUES ('car', '10000');
INSERT INTO `demo`.`product` (`name`, `price`) VALUES ('house ', '100000000');
INSERT INTO `demo`.`product` (`name`, `price`) VALUES ('pencil', '10');
INSERT INTO `demo`.`product` (`name`, `price`) VALUES ('keyboard', '100');


