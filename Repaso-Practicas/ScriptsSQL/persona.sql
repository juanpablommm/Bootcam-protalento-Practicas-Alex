DROP TABLE IF EXISTS `persona`;
 
CREATE TABLE `persona` (
  `id` int(10) NOT NULL,
  `nombre` varchar(30) default NULL,
  `edad` int(3) default NULL,
  `profesion` varchar(30) default NULL,
  `telefono` decimal(10,0) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 