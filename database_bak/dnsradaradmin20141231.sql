/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : dnsradaradmin

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-12-31 14:46:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_appconf`
-- ----------------------------
DROP TABLE IF EXISTS `t_appconf`;
CREATE TABLE `t_appconf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `radarDBip` varchar(255) DEFAULT NULL,
  `proberip` varchar(255) DEFAULT NULL,
  `defaultGwip` varchar(255) DEFAULT NULL,
  `localDNSip` varchar(255) DEFAULT NULL,
  `radarDBport` varchar(255) DEFAULT NULL,
  `radarDBname` varchar(255) DEFAULT NULL,
  `radarDBuser` varchar(255) DEFAULT NULL,
  `radarDBpasswd` varchar(255) DEFAULT NULL,
  `fakePortBase` varchar(255) DEFAULT NULL,
  `processNumForDig` varchar(255) DEFAULT NULL,
  `digIteration` varchar(255) DEFAULT NULL,
  `maxSendRate` varchar(255) DEFAULT NULL,
  `maxTaskNum` varchar(255) DEFAULT NULL,
  `sendThreadNumByThousand` varchar(255) DEFAULT NULL,
  `EnableLog` varchar(255) DEFAULT NULL,
  `extractThreadNum` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_appconf
-- ----------------------------
INSERT INTO `t_appconf` VALUES ('1', '219.245.186.180', '192.168.2.250', '192.168.2.1', '202.117.0.20', null, 'imiss_dns', 'sa', 'imiss@108', '4000', '10', '2', '10000', '10', '1', 'true', '1');

-- ----------------------------
-- Table structure for `t_cluster`
-- ----------------------------
DROP TABLE IF EXISTS `t_cluster`;
CREATE TABLE `t_cluster` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cluster_interval` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_cluster
-- ----------------------------
INSERT INTO `t_cluster` VALUES ('1', '13');
INSERT INTO `t_cluster` VALUES ('2', '13');
INSERT INTO `t_cluster` VALUES ('3', '13');
INSERT INTO `t_cluster` VALUES ('4', '12');

-- ----------------------------
-- Table structure for `t_dbinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_dbinfo`;
CREATE TABLE `t_dbinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `db_ip` varchar(15) DEFAULT NULL,
  `db_port` varchar(16) DEFAULT NULL,
  `db_name` varchar(255) DEFAULT NULL,
  `db_user` varchar(255) DEFAULT NULL,
  `db_passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dbinfo
-- ----------------------------
INSERT INTO `t_dbinfo` VALUES ('2', '134.13.13.13', '12', 'zsy\'', '1', '2');
INSERT INTO `t_dbinfo` VALUES ('5', '12.12.12.12', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for `t_dns_probe_conf`
-- ----------------------------
DROP TABLE IF EXISTS `t_dns_probe_conf`;
CREATE TABLE `t_dns_probe_conf` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `localIP` varchar(255) DEFAULT NULL,
  `gatewayIP` varchar(255) DEFAULT NULL,
  `localDNS` varchar(255) DEFAULT NULL,
  `pcapDir` varchar(255) DEFAULT NULL,
  `dns_result_db_ip` varchar(255) DEFAULT NULL,
  `dns_result_db_name` varchar(255) DEFAULT NULL,
  `dns_result_db_user` varchar(255) DEFAULT NULL,
  `dns_result_db_pass` varchar(255) DEFAULT NULL,
  `probe_record_db_ip` varchar(255) DEFAULT NULL,
  `probe_record_db_name` varchar(255) DEFAULT NULL,
  `probe_record_db_user` varchar(255) DEFAULT NULL,
  `probe_record_db_pass` varchar(255) DEFAULT NULL,
  `extractAveRateParameter_db_ip` varchar(255) DEFAULT NULL,
  `extractAveRateParameter_db_name` varchar(255) DEFAULT NULL,
  `extractAveRateParameter_db_user` varchar(255) DEFAULT NULL,
  `extractAveRateParameter_db_pass` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dns_probe_conf
-- ----------------------------
INSERT INTO `t_dns_probe_conf` VALUES ('1', '219.245.186.181', '219.245.186.5', '8.8.8.8', null, '219.245.186.180', 'imiss_dns', 'sa', 'imiss@108', '219.245.186.185', 'DNS_CACHE_PROBE', 'sa', 'imiss@108', 'undefined.undefined.undefined.undefined', null, null, null);

-- ----------------------------
-- Table structure for `t_dns_scan_conf`
-- ----------------------------
DROP TABLE IF EXISTS `t_dns_scan_conf`;
CREATE TABLE `t_dns_scan_conf` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `DNSScanDBip` varchar(255) DEFAULT NULL,
  `scannerIP` varchar(255) DEFAULT NULL,
  `scanDefaultGwip` varchar(255) DEFAULT NULL,
  `testDomainIp` varchar(255) DEFAULT NULL,
  `DNSScanDBname` varchar(255) DEFAULT NULL,
  `DNSScanDBuser` varchar(255) DEFAULT NULL,
  `DNSScanDBpasswd` varchar(255) DEFAULT NULL,
  `testDomain` varchar(255) DEFAULT NULL,
  `packetRate` varchar(255) DEFAULT NULL,
  `packetNum` varchar(255) DEFAULT NULL,
  `outputDir` varchar(255) DEFAULT NULL,
  `probeNum` varchar(255) DEFAULT NULL,
  `extractNum` varchar(255) DEFAULT NULL,
  `fakePort` varchar(255) DEFAULT NULL,
  `ttl` varchar(255) DEFAULT NULL,
  `maxIteration` varchar(255) DEFAULT NULL,
  `resolverUpdate` varchar(100) DEFAULT NULL,
  `resolverInterval` varchar(255) DEFAULT NULL,
  `nonrecursive` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dns_scan_conf
-- ----------------------------
INSERT INTO `t_dns_scan_conf` VALUES ('1', '219.245.186.180', '219.245.186.180', '219.245.186.6', '202.117.54.210', 'imiss_dns', 'sa', 'imiss@108', 'botnet.xjtu.edu.cn', '201', '3', 'D:\\', '2', '2', '4001', '100', '20', 'false', '10', 'true');

-- ----------------------------
-- Table structure for `t_ftpinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_ftpinfo`;
CREATE TABLE `t_ftpinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `port` varchar(16) DEFAULT NULL,
  `user` varchar(255) DEFAULT NULL,
  `passwd` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ftpinfo
-- ----------------------------
INSERT INTO `t_ftpinfo` VALUES ('6', '1.1.1.1', '11', '2', '1');

-- ----------------------------
-- Table structure for `t_license`
-- ----------------------------
DROP TABLE IF EXISTS `t_license`;
CREATE TABLE `t_license` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `license` varchar(255) DEFAULT NULL,
  `expires` timestamp NULL DEFAULT NULL,
  `isvalid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_license
-- ----------------------------
INSERT INTO `t_license` VALUES ('1', '76B368B7EBB282017742B614DC4742797AD2D67B7751017E5C132C66BEF79A8CA0D2F4B1E088E2F4077C50910C7C3C46', null, '0');
INSERT INTO `t_license` VALUES ('4', '76B368B7EBB282017742B614DC4742797AD2D67B7751017E5C132C66BEF79A8CA0D2F4B1E088E2F4077C50910C7C3C46', null, '-1');

-- ----------------------------
-- Table structure for `t_netconfinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_netconfinfo`;
CREATE TABLE `t_netconfinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `netip` varchar(15) DEFAULT NULL,
  `maskip` varchar(15) DEFAULT NULL,
  `gateip` varchar(15) DEFAULT NULL,
  `dns1ip` varchar(15) DEFAULT NULL,
  `dns2ip` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_netconfinfo
-- ----------------------------
INSERT INTO `t_netconfinfo` VALUES ('7', '202.117.54.197', '255.255.255.1', '202.117.54.1', '202.117.0.21', '1.1.1.1');
INSERT INTO `t_netconfinfo` VALUES ('8', null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_pot`
-- ----------------------------
DROP TABLE IF EXISTS `t_pot`;
CREATE TABLE `t_pot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `mac` char(17) DEFAULT '',
  `state` int(11) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pot
-- ----------------------------
INSERT INTO `t_pot` VALUES ('1', '192.168.1.2', '', '1');
INSERT INTO `t_pot` VALUES ('3', '2.2.2.2', '', '1');
INSERT INTO `t_pot` VALUES ('4', '3.3.3.3', '', '1');
INSERT INTO `t_pot` VALUES ('6', '121.211.121.26', '', '1');
INSERT INTO `t_pot` VALUES ('9', '134.13.13.13', '', '1');
INSERT INTO `t_pot` VALUES ('10', '134.13.13.13', '', '1');
INSERT INTO `t_pot` VALUES ('11', '134.13.13.13', '', '1');
INSERT INTO `t_pot` VALUES ('13', '1.1.1.1', '', '1');
INSERT INTO `t_pot` VALUES ('14', '1.1.1.1', '', '1');
INSERT INTO `t_pot` VALUES ('15', '1.1.1.1', '', '1');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `Username` varchar(32) DEFAULT NULL,
  `Password` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'ice', 'ice');
INSERT INTO `t_user` VALUES ('3', 'zsy', 'zsy');
INSERT INTO `t_user` VALUES ('6', '_imiss_botnet', 'botnet');
INSERT INTO `t_user` VALUES ('7', '1', '1');
INSERT INTO `t_user` VALUES ('8', 'a', 'a');

-- ----------------------------
-- Table structure for `t_whitedomain`
-- ----------------------------
DROP TABLE IF EXISTS `t_whitedomain`;
CREATE TABLE `t_whitedomain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `domain` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_whitedomain
-- ----------------------------
INSERT INTO `t_whitedomain` VALUES ('1', 'ww', 'w');
INSERT INTO `t_whitedomain` VALUES ('2', '2', '1');
INSERT INTO `t_whitedomain` VALUES ('3', '1.', '');
INSERT INTO `t_whitedomain` VALUES ('4', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', '');
INSERT INTO `t_whitedomain` VALUES ('5', 'wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww', 'dddddddddddddddddddddddddddddddddddddddddddddddddddddddddd');
INSERT INTO `t_whitedomain` VALUES ('6', '2222', '');
INSERT INTO `t_whitedomain` VALUES ('7', '1', '');
INSERT INTO `t_whitedomain` VALUES ('8', 'swdfdsf', '');
INSERT INTO `t_whitedomain` VALUES ('9', 'dfa', '');
INSERT INTO `t_whitedomain` VALUES ('10', 'dfa', '');
INSERT INTO `t_whitedomain` VALUES ('11', 'af', '');
INSERT INTO `t_whitedomain` VALUES ('12', 'fda', '');
INSERT INTO `t_whitedomain` VALUES ('13', 'fda', '');
INSERT INTO `t_whitedomain` VALUES ('14', 'qq', '');
INSERT INTO `t_whitedomain` VALUES ('15', '1', '');
INSERT INTO `t_whitedomain` VALUES ('16', '11', '');

-- ----------------------------
-- Table structure for `t_whiteip`
-- ----------------------------
DROP TABLE IF EXISTS `t_whiteip`;
CREATE TABLE `t_whiteip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ip` varchar(15) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `ifrunning` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_whiteip
-- ----------------------------
INSERT INTO `t_whiteip` VALUES ('2', '1.1.1.1', '1', '1');
INSERT INTO `t_whiteip` VALUES ('3', '2.2.2.2', '1', '0');
INSERT INTO `t_whiteip` VALUES ('4', '1.1.1.1', '', '0');
INSERT INTO `t_whiteip` VALUES ('5', '1.1.1.1', '', '0');
INSERT INTO `t_whiteip` VALUES ('6', '1.1.1.1', '', '0');
INSERT INTO `t_whiteip` VALUES ('7', '1.1.1.1', '', '0');
INSERT INTO `t_whiteip` VALUES ('8', '1.1.1.1', '', '0');
INSERT INTO `t_whiteip` VALUES ('9', '1.1.1.1', '', '0');
