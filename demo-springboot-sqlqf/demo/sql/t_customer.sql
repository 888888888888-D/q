





CREATE TABLE `t_customer` (
                              `identity` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
                              `custname` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
                              `sex` int(11) DEFAULT NULL,
                              `address` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
                              `phone` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
                              `career` varchar(255) COLLATE utf8_turkish_ci DEFAULT NULL,
                              `createtime` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_turkish_ci;


INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('421087133414144412', '张⼩明', 1, '北京', '13456788987', '程序\r\n员', '2022-05-07 14:52:24');
INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('43131334113331131', '习⼤⼤', 1, '武汉', '13888888888', '国家最\r\n⾼领导⼈', '2022-05-07 14:52:24');
INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('431321199291331131', '张三', 1, '南京', '13431334113', '程序\r\n员', '2022-05-07 14:52:24');
INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('431321199291331132', '孙中⼭', 1, '⻓沙', '134131314131', '总\r\n统', '2022-05-07 14:52:24');
INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('431341134191311311', '李四', 0, '⻄\r\n安', '13451313113', 'CEO', '2022-05-07 14:52:24');
INSERT INTO `t_customer` (`identity`, `custname`, `sex`, `address`, `phone`, `career`, `createtime`) VALUES ('33131334113331131', '⼤⼤', 1, '武汉', '13888888888', '国家最\r\n⾼领导⼈', '2023-08-07 13:17:36');
