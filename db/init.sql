SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for picshare_art_list
-- ----------------------------
DROP TABLE IF EXISTS `picshare_art`;
CREATE TABLE `picshare_art` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `art_title` varchar(150) DEFAULT NULL COMMENT '作品名',
  `img_link` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `art_tag` varchar(255) DEFAULT NULL COMMENT '图片 tag',
  `like_count` int(10) DEFAULT NULL COMMENT '图片 like 数',
  `star_count` int(10) DEFAULT NULL COMMENT '图片 star 数',
  `upload_date` datetime DEFAULT NULL COMMENT '上传日期',
  `description` varchar(255) DEFAULT NULL COMMENT '备注说明',
  `user_id` int(16) DEFAULT NULL COMMENT '上传者 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for picshare_user
-- ----------------------------
DROP TABLE IF EXISTS `picshare_user`;
CREATE TABLE `picshare_user` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `password` varchar(16) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(32) DEFAULT NULL COMMENT '昵称',
  `icon` varchar(255) DEFAULT NULL COMMENT '头像',
  `birth` date DEFAULT NULL COMMENT '出生日期',
  `sex` varchar(10) DEFAULT NULL COMMENT '性别',
  `register_date` date DEFAULT NULL COMMENT '注册日期',
  `login_date` datetime DEFAULT NULL COMMENT '上次登陆日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for picshare_like_list
-- ----------------------------
DROP TABLE IF EXISTS `picshare_like_list`;
CREATE TABLE `picshare_like_list` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `art_id` int(32) DEFAULT NULL COMMENT 'like 标记作品 id',
  `user_id` varchar(20) DEFAULT NULL COMMENT 'like 标记用户 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for picshare_star_list
-- ----------------------------
DROP TABLE IF EXISTS `picshare_star_list`;
CREATE TABLE `picshare_star_list` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `art_id` int(32) DEFAULT NULL COMMENT 'star 标记作品 id',
  `user_id` varchar(20) DEFAULT NULL COMMENT 'star 标记用户 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
