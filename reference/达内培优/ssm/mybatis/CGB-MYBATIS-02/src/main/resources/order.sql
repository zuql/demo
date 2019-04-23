use 'tcgbtms';
drop table  if exists `t_orders`;
CREATE TABLE `t_orders` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL COMMENT '订单号',
  `memberid` int(11) unsigned DEFAULT NULL COMMENT '会员id',
  `goodsid` int(11) unsigned DEFAULT NULL COMMENT '商品id',
  `totalprice` float(10,2) unsigned DEFAULT NULL COMMENT '总价(价格)',
  `status` int(1) unsigned DEFAULT '0' COMMENT '订单状态',
  `remark` mediumtext COMMENT '备注',
  `createdTime` datetime DEFAULT NULL COMMENT '创建时间',
   UNIQUE KEY   (`code`) USING BTREE,
   PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='订单表';

insert into t_orders
values
(null,'10001',1,1,100,1,'order01',now()),
(null,'10002',1,1,100,1,'order02',now()),
(null,'10003',2,1,200,1,'order03',now());








