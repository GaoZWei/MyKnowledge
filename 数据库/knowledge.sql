/*
Navicat MySQL Data Transfer

Source Server         : knowledge
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : knowledge

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-09-06 10:22:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123');

-- ----------------------------
-- Table structure for ad_pic
-- ----------------------------
DROP TABLE IF EXISTS `ad_pic`;
CREATE TABLE `ad_pic` (
  `id` int(11) NOT NULL,
  `path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ad_pic
-- ----------------------------

-- ----------------------------
-- Table structure for cate
-- ----------------------------
DROP TABLE IF EXISTS `cate`;
CREATE TABLE `cate` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `catename` char(100) NOT NULL,
  `isdelete` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cate
-- ----------------------------
INSERT INTO `cate` VALUES ('1', '语文', '0');
INSERT INTO `cate` VALUES ('2', '英语', '0');
INSERT INTO `cate` VALUES ('3', '数学', '0');
INSERT INTO `cate` VALUES ('4', 'java', '0');
INSERT INTO `cate` VALUES ('5', '语文1', '0');
INSERT INTO `cate` VALUES ('6', '体育', '0');
INSERT INTO `cate` VALUES ('7', '高数', '0');
INSERT INTO `cate` VALUES ('8', '思品', '0');
INSERT INTO `cate` VALUES ('9', 'HTML', '0');
INSERT INTO `cate` VALUES ('10', '历史', '0');
INSERT INTO `cate` VALUES ('11', '俄语2233', '1');
INSERT INTO `cate` VALUES ('12', '物流', '0');
INSERT INTO `cate` VALUES ('13', '电子商务', '0');
INSERT INTO `cate` VALUES ('14', '计算机', '0');
INSERT INTO `cate` VALUES ('15', '经济学', '0');
INSERT INTO `cate` VALUES ('16', '土木工程', '0');
INSERT INTO `cate` VALUES ('17', '物理', '0');
INSERT INTO `cate` VALUES ('18', '人工智能', '0');

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `knowledgeid` int(11) NOT NULL,
  `count` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_CollectList_0` (`userid`),
  KEY `FK_CollectList_1` (`knowledgeid`),
  KEY `count` (`count`),
  CONSTRAINT `collection_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collection_ibfk_2` FOREIGN KEY (`knowledgeid`) REFERENCES `knowledge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '2', '1', '1135');
INSERT INTO `collection` VALUES ('2', '2', '2', '2137');
INSERT INTO `collection` VALUES ('3', '2', '3', '2139');
INSERT INTO `collection` VALUES ('4', '2', '4', '2140');
INSERT INTO `collection` VALUES ('5', '2', '5', '3123');
INSERT INTO `collection` VALUES ('40', '2', '3', '2141');

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `knowledge`;
CREATE TABLE `knowledge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) DEFAULT NULL,
  `knowledgecontent` varchar(2000) DEFAULT NULL,
  `time` varchar(224) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `cateid` int(11) DEFAULT NULL,
  `sfshare` int(1) unsigned zerofill DEFAULT '0',
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `FK_Knowledge_0` (`userid`),
  KEY `FK_Knowledge_2` (`cateid`),
  KEY `count` (`count`),
  CONSTRAINT `knowledge_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `knowledge_ibfk_2` FOREIGN KEY (`cateid`) REFERENCES `cate` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of knowledge
-- ----------------------------
INSERT INTO `knowledge` VALUES ('1', '必背古文1', '文言文，天将降大任于斯人也，必先苦其心志。。。。。。', '2018-09-06 10:00:17', '2', '1', '0', '8915');
INSERT INTO `knowledge` VALUES ('2', '学习高数第一天', '广义地说，初等数学之外的数学都是高等数学，也有将中学较深入的代数、几何以及简单的集合论初步、逻辑初步称为中等数学的，将其作为中小学阶段的初等数学与大学阶段的高等数学的过渡。', '2018-07-14 11:50:53', '2', '7', '1', '987');
INSERT INTO `knowledge` VALUES ('3', '初涉java', 'helloworld的编写....', '2018-07-14 10:50:53', '2', '4', '1', '2141');
INSERT INTO `knowledge` VALUES ('4', '快速记英语单词', ' 1、拼读法。掌握正确的拼法与读音之间的关系,可以根据单词的读音,正确地拼写单词。 2、谐音法。根据外语单词的读音到汉语中去寻找与其读音相...', '2018-07-05 12:50:59', '2', '2', '1', '3123');
INSERT INTO `knowledge` VALUES ('5', '奥运会记录', '世界纪录是指在某一个特定的学科或项目中最好的成绩。一般来说，世界纪录分为体育赛事世界纪录和非体育赛事世界纪录。', '2018-09-05 22:11:59', '2', '6', '0', '4534');
INSERT INTO `knowledge` VALUES ('7', '秦始皇的统治', '一、治方面：建立封建专制主义中央集权制度。⑴、最高统治者称皇帝，国家大权集中在皇帝一人之手。⑵、中央政府设立丞相、太尉、御史大夫协助皇帝处理政务，他们都要皇帝亲自任命。⑶、废除分封制，推行郡县制。⑷、颁行通行全国的“秦律”。这套制度延续两千多年。', '2018-09-06 08:35:16', '2', '5', '0', '4606');
INSERT INTO `knowledge` VALUES ('8', '2018时事政治', '国家税务总局近日发出《通知》，在前期推行“放管服”改革30条、办税事项“最多跑一次”清单的基础上，针对纳税人反映最强烈、最突出的问题，精准推出()10项硬举措，进一步打造稳定公平透明的税收营商环境。', '2018-09-06 08:37:46', '2', '8', '0', '3244');
INSERT INTO `knowledge` VALUES ('9', '第一个html页面编写', '关于HTML的历史以及描述，这里就不赘述了。详细请见百度百科HTML.\r\n\r\n         如果要完全遵照XML来创建XHTML文件，则必须牢记一些严格个规则：\r\n\r\n                 1)  网页的开头处要有文档类型申明(DOCTYPE)。\r\n\r\n                 2)  标签和标签属性必须用小写字母。\r\n\r\n                 3)   标签属性必须用双引号标记。\r\n\r\n                 4)  所有标签(甚至空标签)都必须关闭。如果没有关闭标签的标签，则需要在该标签的结尾处加上一个正斜杠符号，如<br />', '2018-09-06 08:57:32', '2', '9', '0', '653');
INSERT INTO `knowledge` VALUES ('11', 'www', 'wwww222', '2018-09-06 09:20:34', '2', '3', '0', '1055');
INSERT INTO `knowledge` VALUES ('12', 'qqq', 'qqqq', '2018-09-06 09:09:12', '2', '5', '0', '353');
INSERT INTO `knowledge` VALUES ('13', 'eee', 'eeee', '2018-09-06 09:10:38', '2', '8', '0', '7675');
INSERT INTO `knowledge` VALUES ('14', 'rrrr', 'rrrr', '2018-09-06 09:11:48', '2', '11', '0', '432');
INSERT INTO `knowledge` VALUES ('89', 'yyy', 'yyyy', '2018-09-06 09:18:17', '2', '7', '0', '0');

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagname` varchar(100) NOT NULL,
  `isdelete` int(2) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES ('1', 'java大神分享1', '1');
INSERT INTO `tag` VALUES ('2', '数学公式', '0');
INSERT INTO `tag` VALUES ('3', 'ssm框架', '0');
INSERT INTO `tag` VALUES ('4', '大神', '1');
INSERT INTO `tag` VALUES ('5', '牛人大大', '0');
INSERT INTO `tag` VALUES ('6', '日语教学', '0');
INSERT INTO `tag` VALUES ('7', '计算机与网络', '0');
INSERT INTO `tag` VALUES ('8', '大学物理', '0');
INSERT INTO `tag` VALUES ('9', '政治基础', '0');
INSERT INTO `tag` VALUES ('10', '中国近代史', '0');
INSERT INTO `tag` VALUES ('11', 'html基础', '0');
INSERT INTO `tag` VALUES ('12', '世界地形', '0');
INSERT INTO `tag` VALUES ('13', '文言文鉴赏', '0');
INSERT INTO `tag` VALUES ('14', 'java入门', '0');
INSERT INTO `tag` VALUES ('15', '速记英语', '0');
INSERT INTO `tag` VALUES ('16', '健身达人', '0');
INSERT INTO `tag` VALUES ('17', '上下五千年', '0');

-- ----------------------------
-- Table structure for tags
-- ----------------------------
DROP TABLE IF EXISTS `tags`;
CREATE TABLE `tags` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tagid` int(11) NOT NULL,
  `knowledgeid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tagid` (`tagid`),
  KEY `knowledgeid` (`knowledgeid`),
  CONSTRAINT `tags_ibfk_1` FOREIGN KEY (`tagid`) REFERENCES `tag` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tags_ibfk_2` FOREIGN KEY (`knowledgeid`) REFERENCES `knowledge` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tags
-- ----------------------------
INSERT INTO `tags` VALUES ('1', '13', '1');
INSERT INTO `tags` VALUES ('3', '14', '3');
INSERT INTO `tags` VALUES ('4', '15', '4');
INSERT INTO `tags` VALUES ('5', '16', '5');
INSERT INTO `tags` VALUES ('6', '2', '2');
INSERT INTO `tags` VALUES ('7', '17', '7');
INSERT INTO `tags` VALUES ('8', '9', '8');
INSERT INTO `tags` VALUES ('9', '11', '9');
INSERT INTO `tags` VALUES ('11', '4', '11');
INSERT INTO `tags` VALUES ('12', '6', '12');
INSERT INTO `tags` VALUES ('13', '8', '13');
INSERT INTO `tags` VALUES ('14', '9', '14');
INSERT INTO `tags` VALUES ('34', '3', '89');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `username` varchar(50) NOT NULL,
  `age` int(5) NOT NULL,
  `telephone` int(15) NOT NULL,
  `ident` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '312', '123', 'ni', '20', '123456789', '1');
INSERT INTO `user` VALUES ('3', '310', '123', 'zhang', '20', '12345678', '1');
INSERT INTO `user` VALUES ('4', '309', '123', '张晓明', '20', '12', '1');
INSERT INTO `user` VALUES ('5', '308', '123', '王晓明', '20', '13', '1');
INSERT INTO `user` VALUES ('6', 'wangzibin', 'bvybz', 'wzb', '20', '123', '1');
INSERT INTO `user` VALUES ('7', 'ligang', '123', 'ligang', '25', '1234', '1');
INSERT INTO `user` VALUES ('8', '305', '123', 'zhengwei', '20', '12321', '1');
