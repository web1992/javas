 CREATE TABLE `t_order` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `order_no` varchar(255) DEFAULT NULL,
   `user_id` varchar(255) DEFAULT NULL,
   `commodity_code` varchar(255) DEFAULT NULL,
   `count` int(11) DEFAULT '0',
   `amount` double(14,2) DEFAULT '0.00',
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8