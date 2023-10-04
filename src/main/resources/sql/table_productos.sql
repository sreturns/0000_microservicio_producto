CREATE TABLE `productos_bd`.`productos` (
  `codigo_producto` INT NOT NULL AUTO_INCREMENT,
  `producto` VARCHAR(45) NULL,
  `precio_unitario` DOUBLE NULL,
  `stock` INT NULL,
  PRIMARY KEY (`codigo_producto`));
