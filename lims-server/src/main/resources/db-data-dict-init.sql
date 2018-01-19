/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : lims

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-11-17 12:33:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_dict
-- ----------------------------
DROP TABLE IF EXISTS `data_dict`;
CREATE TABLE `data_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `code` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `second_parent_id` bigint(20) DEFAULT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=184 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of data_dict
-- ----------------------------
INSERT INTO `data_dict` VALUES ('1', '1', now(), '1', now(), '1', '免费', null, null, '1');
INSERT INTO `data_dict` VALUES ('2', '1', now(), '1', now(), '2', '收费', null, null, '1');
INSERT INTO `data_dict` VALUES ('3', '1', now(), '1', now(), '1', '1-特低', null, null, '2');
INSERT INTO `data_dict` VALUES ('4', '1', now(), '1', now(), '2', '2-低', null, null, '2');
INSERT INTO `data_dict` VALUES ('5', '1', now(), '1', now(), '3', '3-中等', null, null, '2');
INSERT INTO `data_dict` VALUES ('6', '1', now(), '1', now(), '4', '4-高', null, null, '2');
INSERT INTO `data_dict` VALUES ('7', '1', now(), '1', now(), '5', '5-紧急', null, null, '2');
#type 3=物种分类
INSERT INTO `data_dict` VALUES ('8', '1', now(), '1', now(), '1', '植物', null, null, '3');
INSERT INTO `data_dict` VALUES ('9', '1', now(), '1', now(), '2', '动物', null, null, '3');
INSERT INTO `data_dict` VALUES ('10', '1', now(), '1', now(), '3', '原核', null, null, '3');
INSERT INTO `data_dict` VALUES ('11', '1', now(), '1', now(), '4', '真核', null, null, '3');
INSERT INTO `data_dict` VALUES ('184', '1', now(), '1', now(), '5', '真菌', null, null, '3');

INSERT INTO `data_dict` VALUES ('12', '1', now(), '1', now(), '2', 'DNA', null, null, '4');
INSERT INTO `data_dict` VALUES ('13', '1', now(), '1', now(), '4', 'DNA文库', null, null, '4');
INSERT INTO `data_dict` VALUES ('14', '1', now(), '1', now(), '3', 'RNA', null, null, '4');
INSERT INTO `data_dict` VALUES ('15', '1', now(), '1', now(), '5', 'RNA文库', null, null, '4');
INSERT INTO `data_dict` VALUES ('16', '1', now(), '1', now(), '1', '组织样本', null, null, '4');
INSERT INTO `data_dict` VALUES ('17', '1', now(), '1', now(), '1', '基因组DNA', '12', null, '5');
INSERT INTO `data_dict` VALUES ('18', '1', now(), '1', now(), '2', 'ChIP DNA', '12', null, '5');
INSERT INTO `data_dict` VALUES ('19', '1', now(), '1', now(), '3', 'PCR产物', '12', null, '5');
INSERT INTO `data_dict` VALUES ('20', '1', now(), '1', now(), '4', '已打断的样本', '12', null, '5');
INSERT INTO `data_dict` VALUES ('21', '1', now(), '1', now(), '5', 'FFPE 样本', '12', null, '5');
INSERT INTO `data_dict` VALUES ('22', '1', now(), '1', now(), '6', 'cfDNA/ctDNA', '12', null, '5');
INSERT INTO `data_dict` VALUES ('23', '1', now(), '1', now(), '7', '单细胞DNA', '12', null, '5');
INSERT INTO `data_dict` VALUES ('24', '1', now(), '1', now(), '8', '其它（请说明）', '12', null, '5');
INSERT INTO `data_dict` VALUES ('25', '1', now(), '1', now(), '1', '基因组重测序文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('26', '1', now(), '1', now(), '2', '全基因组甲基化文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('27', '1', now(), '1', now(), '3', 'ChIP-seq文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('28', '1', now(), '1', now(), '4', '16S/18S/ITS扩增子文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('29', '1', now(), '1', now(), '5', '人全外显子组文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('30', '1', now(), '1', now(), '6', '单细胞基因组文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('31', '1', now(), '1', now(), '7', '宏基因组文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('32', '1', now(), '1', now(), '9', '其它（请说明）', '12', null, '16');
INSERT INTO `data_dict` VALUES ('33', '1', now(), '1', now(), '1', 'Total RNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('34', '1', now(), '1', now(), '2', 'mRNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('35', '1', now(), '1', now(), '3', 'Small RNA（<200nt）', '14', null, '5');
INSERT INTO `data_dict` VALUES ('36', '1', now(), '1', now(), '4', 'IP small RNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('37', '1', now(), '1', now(), '5', '-rRNA RNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('38', '1', now(), '1', now(), '6', '单链cDNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('39', '1', now(), '1', now(), '7', '双链cDNA', '14', null, '5');
INSERT INTO `data_dict` VALUES ('40', '1', now(), '1', now(), '8', '其它（请说明）', '14', null, '5');
INSERT INTO `data_dict` VALUES ('41', '1', now(), '1', now(), '1', '小RNA文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('42', '1', now(), '1', now(), '2', '真核链特异性转录组文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('43', '1', now(), '1', now(), '3', '真核普通转录组文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('44', '1', now(), '1', now(), '4', '原核链特异性转录组文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('45', '1', now(), '1', now(), '5', 'Lnc RNA文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('46', '1', now(), '1', now(), '6', 'circRNA文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('47', '1', now(), '1', now(), '7', '降解组文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('48', '1', now(), '1', now(), '8', '单细胞转录组文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('49', '1', now(), '1', now(), '10', '其它（请说明）', '14', null, '16');
INSERT INTO `data_dict` VALUES ('50', '1', now(), '1', now(), '1', '组织', '16', null, '5');
INSERT INTO `data_dict` VALUES ('51', '1', now(), '1', now(), '2', 'Trizol 均浆液', '16', null, '5');
INSERT INTO `data_dict` VALUES ('52', '1', now(), '1', now(), '3', '细胞', '16', null, '5');
INSERT INTO `data_dict` VALUES ('53', '1', now(), '1', now(), '4', '血液', '16', null, '5');
INSERT INTO `data_dict` VALUES ('54', '1', now(), '1', now(), '5', 'FFPE(贴片和卷片)', '16', null, '5');
INSERT INTO `data_dict` VALUES ('55', '1', now(), '1', now(), '6', '石蜡块', '16', null, '5');
INSERT INTO `data_dict` VALUES ('56', '1', now(), '1', now(), '7', '血浆（cfDNA/ctDNA）', '16', null, '5');
INSERT INTO `data_dict` VALUES ('57', '1', now(), '1', now(), '8', '菌体', '16', null, '5');
INSERT INTO `data_dict` VALUES ('58', '1', now(), '1', now(), '9', '菌液', '16', null, '5');
INSERT INTO `data_dict` VALUES ('59', '1', now(), '1', now(), '10', '土壤', '16', null, '5');
INSERT INTO `data_dict` VALUES ('60', '1', now(), '1', now(), '11', '其它（请说明）', '16', null, '5');
INSERT INTO `data_dict` VALUES ('61', '1', now(), '1', now(), '1', '冰冻', '16', null, '6');
INSERT INTO `data_dict` VALUES ('62', '1', now(), '1', now(), '2', '石蜡包埋', '16', null, '6');
INSERT INTO `data_dict` VALUES ('63', '1', now(), '1', now(), '3', '其它（说明）', '16', null, '6');
INSERT INTO `data_dict` VALUES ('64', '1', now(), '1', now(), '1', '溶于RNase水', '12', null, '6');
INSERT INTO `data_dict` VALUES ('65', '1', now(), '1', now(), '2', '溶于TE Buffer', '12', null, '6');
INSERT INTO `data_dict` VALUES ('66', '1', now(), '1', now(), '3', '溶于ddH2O', '12', null, '6');
INSERT INTO `data_dict` VALUES ('67', '1', now(), '1', now(), '4', '溶于DEPC水', '12', null, '6');
INSERT INTO `data_dict` VALUES ('68', '1', now(), '1', now(), '5', '沉淀溶于无水乙醇', '12', null, '6');
INSERT INTO `data_dict` VALUES ('69', '1', now(), '1', now(), '6', '干粉', '12', null, '6');
INSERT INTO `data_dict` VALUES ('70', '1', now(), '1', now(), '7', '其它（说明）', '12', null, '6');
INSERT INTO `data_dict` VALUES ('71', '1', now(), '1', now(), '1', '溶于RNase水', '14', null, '6');
INSERT INTO `data_dict` VALUES ('72', '1', now(), '1', now(), '2', '溶于TE Buffer', '14', null, '6');
INSERT INTO `data_dict` VALUES ('73', '1', now(), '1', now(), '3', '溶于ddH2O', '14', null, '6');
INSERT INTO `data_dict` VALUES ('74', '1', now(), '1', now(), '4', '溶于DEPC水', '14', null, '6');
INSERT INTO `data_dict` VALUES ('75', '1', now(), '1', now(), '5', '沉淀溶于无水乙醇', '14', null, '6');
INSERT INTO `data_dict` VALUES ('76', '1', now(), '1', now(), '6', '干粉', '14', null, '6');
INSERT INTO `data_dict` VALUES ('77', '1', now(), '1', now(), '7', '其它（说明）', '14', null, '6');
INSERT INTO `data_dict` VALUES ('78', '1', now(), '1', now(), '1', '溶于ddH2O', '13', null, '6');
INSERT INTO `data_dict` VALUES ('79', '1', now(), '1', now(), '2', '干粉', '13', null, '6');
INSERT INTO `data_dict` VALUES ('80', '1', now(), '1', now(), '3', '其它（说明）', '13', null, '6');
INSERT INTO `data_dict` VALUES ('81', '1', now(), '1', now(), '1', '溶于ddH2O', '15', null, '6');
INSERT INTO `data_dict` VALUES ('82', '1', now(), '1', now(), '2', '干粉', '15', null, '6');
INSERT INTO `data_dict` VALUES ('83', '1', now(), '1', now(), '3', '其它（说明）', '15', null, '6');
INSERT INTO `data_dict` VALUES ('84', '1', now(), '1', now(), '1', '电泳', null, null, '9');
INSERT INTO `data_dict` VALUES ('85', '1', now(), '1', now(), '2', 'NanoDrop', null, null, '9');
INSERT INTO `data_dict` VALUES ('86', '1', now(), '1', now(), '3', 'Qubit', null, null, '9');
INSERT INTO `data_dict` VALUES ('87', '1', now(), '1', now(), '4', 'AB2100', null, null, '9');
INSERT INTO `data_dict` VALUES ('88', '1', now(), '1', now(), '1', 'NanoDrop', null, null, '10');
INSERT INTO `data_dict` VALUES ('89', '1', now(), '1', now(), '2', 'Qubit', null, null, '10');
INSERT INTO `data_dict` VALUES ('90', '1', now(), '1', now(), '3', 'AB2100', null, null, '10');
INSERT INTO `data_dict` VALUES ('91', '1', now(), '1', now(), '1', 'P5--Index--DNA--P7', null, null, '11');
INSERT INTO `data_dict` VALUES ('92', '1', now(), '1', now(), '2', 'P5--DNA--Index--P7', null, null, '11');
INSERT INTO `data_dict` VALUES ('93', '1', now(), '1', now(), '3', 'P5--Index1--DNA--Index2--P7', null, null, '11');
INSERT INTO `data_dict` VALUES ('94', '1', now(), '1', now(), '1', '插入片段<600bp', null, null, '12');
INSERT INTO `data_dict` VALUES ('95', '1', now(), '1', now(), '2', '插入片段20-30bp', null, null, '12');
INSERT INTO `data_dict` VALUES ('96', '1', now(), '1', now(), '1', 'Illumina', null, null, '13');
INSERT INTO `data_dict` VALUES ('97', '1', now(), '1', now(), '2', 'Ion Torrent', null, null, '13');
INSERT INTO `data_dict` VALUES ('98', '1', now(), '1', now(), '1', 'HiSeq2500-SE50 rapid', '96', null, '14');
INSERT INTO `data_dict` VALUES ('99', '1', now(), '1', now(), '2', 'Hiseq 2500-PE125', '96', null, '14');
INSERT INTO `data_dict` VALUES ('100', '1', now(), '1', now(), '3', 'Hiseq 4000-PE150', '96', null, '14');
INSERT INTO `data_dict` VALUES ('101', '1', now(), '1', now(), '4', 'Hiseq X ten-PE150', '96', null, '14');
INSERT INTO `data_dict` VALUES ('102', '1', now(), '1', now(), '5', 'Hiseq 2500-PE250', '96', null, '14');
INSERT INTO `data_dict` VALUES ('103', '1', now(), '1', now(), '6', 'Hiseq 2500-SE50 v4', '96', null, '14');
INSERT INTO `data_dict` VALUES ('104', '1', now(), '1', now(), '7', 'Nextseq500-SE75', '96', null, '14');
INSERT INTO `data_dict` VALUES ('105', '1', now(), '1', now(), '1', 'PGM', '97', null, '14');
INSERT INTO `data_dict` VALUES ('106', '1', now(), '1', now(), '1', 'GB', null, null, '15');
INSERT INTO `data_dict` VALUES ('107', '1', now(), '1', now(), '2', 'Reads', null, null, '15');
INSERT INTO `data_dict` VALUES ('108', '1', now(), '1', now(), '1', 'DNA', null, null, '7');
INSERT INTO `data_dict` VALUES ('109', '1', now(), '1', now(), '2', 'RNA', null, null, '7');
INSERT INTO `data_dict` VALUES ('110', '1', now(), '1', now(), '3', 'CHIP-Seq', null, null, '7');
INSERT INTO `data_dict` VALUES ('111', '1', now(), '1', now(), '4', 'small RNA', null, null, '7');
INSERT INTO `data_dict` VALUES ('112', '1', now(), '1', now(), '1', 'SDS法提取标准方法', '12', '9', '8');
INSERT INTO `data_dict` VALUES ('113', '1', now(), '1', now(), '2', '血液基因组提取', '12', '9', '8');
INSERT INTO `data_dict` VALUES ('114', '1', now(), '1', now(), '3', '血液红细胞DNA提取法', '12', '9', '8');
INSERT INTO `data_dict` VALUES ('115', '1', now(), '1', now(), '4', '昆虫DNA提取', '12', '9', '8');
INSERT INTO `data_dict` VALUES ('116', '1', now(), '1', now(), '1', 'CTAB法提取标准方法', '12', '8', '8');
INSERT INTO `data_dict` VALUES ('117', '1', now(), '1', now(), '2', '月桂酸钠法提取标准方法', '12', '8', '8');
INSERT INTO `data_dict` VALUES ('118', '1', now(), '1', now(), '3', '茶叶中微生物DNA的提取', '12', '8', '8');
INSERT INTO `data_dict` VALUES ('119', '1', now(), '1', now(), '1', 'STE方法提取', '12', '10', '8');
INSERT INTO `data_dict` VALUES ('120', '1', now(), '1', now(), '1', 'SDS法提取标准方法', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('121', '1', now(), '1', now(), '2', 'CTAB法提取标准方法', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('122', '1', now(), '1', now(), '3', '月桂酸钠法提取标准方法', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('123', '1', now(), '1', now(), '4', 'STE方法提取', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('124', '1', now(), '1', now(), '5', '香菇基因组DNA提取', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('125', '1', now(), '1', now(), '1', 'Trizol法RNA提取标准方法', '14', '9', '8');
INSERT INTO `data_dict` VALUES ('126', '1', now(), '1', now(), '1', 'Trizol法RNA提取标准方法', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('127', '1', now(), '1', now(), '2', '多糖多酚植物总RNA提取', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('128', '1', now(), '1', now(), '3', 'CTAB提取法', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('129', '1', now(), '1', now(), '4', '药用植物提取', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('130', '1', now(), '1', now(), '5', 'Planteasy法标准化', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('131', '1', now(), '1', now(), '6', 'EASYspin 植物RNA', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('132', '1', now(), '1', now(), '7', 'mirVana™ miRNA Isolation Kit', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('133', '1', now(), '1', now(), '8', '草莓果实提取脱色法', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('134', '1', now(), '1', now(), '9', '异硫氰酸胍二步法标准化', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('135', '1', now(), '1', now(), '10', '异硫氰酸胍法标准化操作', '14', '8', '8');
INSERT INTO `data_dict` VALUES ('136', '1', now(), '1', now(), '1', 'Trizol法RNA提取标准方法', '14', '9', '8');
INSERT INTO `data_dict` VALUES ('137', '1', now(), '1', now(), '1', 'Trizol法RNA提取标准方法', '14', '9', '8');
INSERT INTO `data_dict` VALUES ('138', '1', now(), '1', now(), '1', 'CHIP-Seq', '12', '9', '8');
INSERT INTO `data_dict` VALUES ('139', '1', now(), '1', now(), '1', 'CHIP-Seq', '12', '8', '8');
INSERT INTO `data_dict` VALUES ('140', '1', now(), '1', now(), '1', 'CHIP-Seq', '12', '10', '8');
INSERT INTO `data_dict` VALUES ('141', '1', now(), '1', now(), '1', 'CHIP-Seq', '12', '11', '8');
INSERT INTO `data_dict` VALUES ('142', '1', now(), '1', now(), '1', 'mirVana™ miRNA Isolation Kit', '14', '9', '8');
INSERT INTO `data_dict` VALUES ('143', '1', now(), '1', now(), '6', '核酸序列', null, null, '4');
INSERT INTO `data_dict` VALUES ('144', '1', now(), '1', now(), '1', '核酸序列', '143', null, '5');
INSERT INTO `data_dict` VALUES ('145', '1', now(), '1', now(), '1', '基因组重测序文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('146', '1', now(), '1', now(), '2', '全基因组甲基化文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('147', '1', now(), '1', now(), '3', 'ChIP-seq文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('148', '1', now(), '1', now(), '4', '16S/18S/ITS扩增子文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('149', '1', now(), '1', now(), '5', '人全外显子组文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('150', '1', now(), '1', now(), '6', '单细胞基因组文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('151', '1', now(), '1', now(), '7', '宏基因组文库', '13', null, '5');
INSERT INTO `data_dict` VALUES ('152', '1', now(), '1', now(), '8', '其它（请说明）', '13', null, '5');
INSERT INTO `data_dict` VALUES ('153', '1', now(), '1', now(), '1', '小RNA文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('154', '1', now(), '1', now(), '2', '真核链特异性转录组文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('155', '1', now(), '1', now(), '3', '真核普通转录组文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('156', '1', now(), '1', now(), '4', '原核链特异性转录组文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('157', '1', now(), '1', now(), '5', 'Lnc RNA文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('158', '1', now(), '1', now(), '6', 'circRNA文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('159', '1', now(), '1', now(), '7', '降解组文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('160', '1', now(), '1', now(), '8', '单细胞转录组文库', '15', null, '5');
INSERT INTO `data_dict` VALUES ('161', '1', now(), '1', now(), '9', '其它（请说明）', '15', null, '5');
INSERT INTO `data_dict` VALUES ('179', '1', now(), '1', now(), '9', '小RNA文库', '14', null, '16');
INSERT INTO `data_dict` VALUES ('180', '1', now(), '1', now(), '8', 'ChIP-seq文库', '12', null, '16');
INSERT INTO `data_dict` VALUES ('181', '1', now(), '1', now(), '1', '其它（说明）', '143', null, '6');
INSERT INTO `data_dict` VALUES ('182', '1', now(), '1', now(), '1', 'Proton', '97', null, '14');
INSERT INTO `data_dict` VALUES ('183', '1', now(), '1', now(), '1', 'S5', '97', null, '14');
