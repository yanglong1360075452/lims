/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : lims

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-12-04 15:57:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cfg_wf
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf`;
CREATE TABLE `cfg_wf` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `application` int(11) DEFAULT NULL,
  `category` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `release_time` datetime DEFAULT NULL,
  `sop` text,
  `ver` varchar(255) DEFAULT NULL,
  `url_step` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf
-- ----------------------------
INSERT INTO `cfg_wf` VALUES ('1', '1', now(), '1', now(), '1', '1', '样本提取', null, '样本提取', now(), null, '1.0', 'ExtractSteps');
INSERT INTO `cfg_wf` VALUES ('2', '1', now(), '1', now(), '1', '2', 'RNA 样本检测流程。适用于 动物、植物、微生物的样本检测。', null, 'RNA样本检测', now(), null, '1.0', 'CheckSteps');

-- ----------------------------
-- Table structure for cfg_wf_activ
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_activ`;
CREATE TABLE `cfg_wf_activ` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `category` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `java_class` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `release_time` datetime DEFAULT NULL,
  `url_op` varchar(255) DEFAULT NULL,
  `url_rpt` varchar(255) DEFAULT NULL,
  `url_sop` varchar(255) DEFAULT NULL,
  `ver` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_activ
-- ----------------------------
INSERT INTO `cfg_wf_activ` VALUES ('1', '1', now(), '1', now(), '1', null, 'ExtractService', null, '样本提取', now(), 'ExtractOperate', 'ExtractReport', 'ExtractSop', '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('2', '1', now(), '1', now(), '2', null, null, null, '样本稀释', now(), null, null, null, '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('3', '1', now(), '1', now(), '3', null, null, null, 'Qubit检测', now(), null, null, null, '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('4', '1', now(), '1', now(), '4', null, null, null, '电泳测试', now(), null, null, null, '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('5', '1', now(), '1', now(), '5', null, null, null, 'A2100测试', now(), null, null, null, '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('6', '1', now(), '1', now(), '6', null, null, null, '质量分类', now(), null, null, null, '1.0');
INSERT INTO `cfg_wf_activ` VALUES ('7', '1', now(), '1', now(), '7', null, null, null, '出报告', now(), null, null, null, '1.0');

-- ----------------------------
-- Table structure for cfg_wf_activ_param
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_activ_param`;
CREATE TABLE `cfg_wf_activ_param` (
  `param` varchar(255) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `param_type` int(11) DEFAULT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `activ_id` bigint(20) NOT NULL,
  PRIMARY KEY (`activ_id`,`param`),
  CONSTRAINT `FK9m7n2gdmt1b7fovb9b0vv4bbw` FOREIGN KEY (`activ_id`) REFERENCES `cfg_wf_activ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_activ_param
-- ----------------------------

-- ----------------------------
-- Table structure for cfg_wf_activ_r
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_activ_r`;
CREATE TABLE `cfg_wf_activ_r` (
  `wf_id` bigint(20) NOT NULL,
  `activ_id` bigint(20) NOT NULL,
  KEY `FKimd9qh9pus5v8pg8wna630pvo` (`activ_id`),
  KEY `FKe1em0kwbr82lf0copa8ix9jsh` (`wf_id`),
  CONSTRAINT `FKe1em0kwbr82lf0copa8ix9jsh` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`),
  CONSTRAINT `FKimd9qh9pus5v8pg8wna630pvo` FOREIGN KEY (`activ_id`) REFERENCES `cfg_wf_activ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_activ_r
-- ----------------------------
INSERT INTO `cfg_wf_activ_r` VALUES ('1', '1');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '2');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '3');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '4');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '5');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '6');
INSERT INTO `cfg_wf_activ_r` VALUES ('2', '7');

-- ----------------------------
-- Table structure for cfg_wf_param_map
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_param_map`;
CREATE TABLE `cfg_wf_param_map` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `in_param` varchar(255) DEFAULT NULL,
  `out_param` tinyblob,
  `wf_id` bigint(20) NOT NULL,
  `in_activ_id` bigint(20) DEFAULT NULL,
  `out_activ_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1ekpb2bitad3j6ev7iiwwyw2c` (`wf_id`),
  KEY `FKja4b3apxpv0wa1749eunnk75r` (`in_activ_id`),
  KEY `FK37a6nxrvlx3pkoawulej8rgth` (`out_activ_id`),
  CONSTRAINT `FK1ekpb2bitad3j6ev7iiwwyw2c` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`),
  CONSTRAINT `FK37a6nxrvlx3pkoawulej8rgth` FOREIGN KEY (`out_activ_id`) REFERENCES `cfg_wf_activ` (`id`),
  CONSTRAINT `FKja4b3apxpv0wa1749eunnk75r` FOREIGN KEY (`in_activ_id`) REFERENCES `cfg_wf_activ` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_param_map
-- ----------------------------

-- ----------------------------
-- Table structure for cfg_wf_scheme_job_sample
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_scheme_job_sample`;
CREATE TABLE `cfg_wf_scheme_job_sample` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `sample_category` bigint(20) NOT NULL,
  `sample_type` bigint(20) NOT NULL,
  `species` bigint(20) NOT NULL,
  `wf_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqfd1f3plpgk0qv1ocleg5itqu` (`wf_id`),
  CONSTRAINT `FKqfd1f3plpgk0qv1ocleg5itqu` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_scheme_job_sample
-- ----------------------------

-- ----------------------------
-- Table structure for cfg_wf_trans
-- ----------------------------
DROP TABLE IF EXISTS `cfg_wf_trans`;
CREATE TABLE `cfg_wf_trans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `cond_desc` varchar(255) DEFAULT NULL,
  `cond_formula` varchar(255) DEFAULT NULL,
  `wf_id` bigint(20) NOT NULL,
  `from_activ_id` bigint(20) DEFAULT NULL,
  `to_activ_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmhlcpp7qc8s5t1fd3srkjw5wm` (`wf_id`),
  KEY `FKmt45alglclg3gbsafiyw9h05e` (`from_activ_id`),
  KEY `FKexi6o08gv05hu7c8683g4fld5` (`to_activ_id`),
  CONSTRAINT `FKexi6o08gv05hu7c8683g4fld5` FOREIGN KEY (`to_activ_id`) REFERENCES `cfg_wf_activ` (`id`),
  CONSTRAINT `FKmhlcpp7qc8s5t1fd3srkjw5wm` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`),
  CONSTRAINT `FKmt45alglclg3gbsafiyw9h05e` FOREIGN KEY (`from_activ_id`) REFERENCES `cfg_wf_activ` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cfg_wf_trans
-- ----------------------------
INSERT INTO `cfg_wf_trans` VALUES ('1', '1', now(), '1', now(), null, null, '1', null, '1');
INSERT INTO `cfg_wf_trans` VALUES ('2', '1', now(), '1', now(), null, null, '2', null, '2');
INSERT INTO `cfg_wf_trans` VALUES ('3', '1', now(), '1', now(), null, null, '2', '2', '3');
INSERT INTO `cfg_wf_trans` VALUES ('4', '1', now(), '1', now(), '合格', null, '2', '3', '4');
INSERT INTO `cfg_wf_trans` VALUES ('5', '1', now(), '1', now(), '不合格', null, '2', '3', '7');
INSERT INTO `cfg_wf_trans` VALUES ('6', '1', now(), '1', now(), '合格', NULL , '2', '4', '5');
INSERT INTO `cfg_wf_trans` VALUES ('7', '1', now(), '1', now(), '不合格', null, '2', '4', '7');
INSERT INTO `cfg_wf_trans` VALUES ('8', '1', now(), '1', now(), null, null, '2', '5', '6');
INSERT INTO `cfg_wf_trans` VALUES ('9', '1', now(), '1', now(), null, null, '2', '6', '7');
INSERT INTO `cfg_wf_trans` VALUES ('10', '1', now(), '1', now(), null, null, '2', '7', NULL );

-- ----------------------------
-- Table structure for exec_extract
-- ----------------------------
DROP TABLE IF EXISTS `exec_extract`;
CREATE TABLE `exec_extract` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `execution_id` bigint(20) NOT NULL,
  `extract_method` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exec_extract
-- ----------------------------

-- ----------------------------
-- Table structure for execution
-- ----------------------------
DROP TABLE IF EXISTS `execution`;
CREATE TABLE `execution` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `dosage` double DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `sub_task_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKhy2il4nflqkgc3v11y5thjxw8` (`sub_task_id`),
  CONSTRAINT `FKhy2il4nflqkgc3v11y5thjxw8` FOREIGN KEY (`sub_task_id`) REFERENCES `subtask` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of execution
-- ----------------------------

-- ----------------------------
-- Table structure for execution_sample_r
-- ----------------------------
DROP TABLE IF EXISTS `execution_sample_r`;
CREATE TABLE `execution_sample_r` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `dosage` double DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `execution_id` bigint(20) NOT NULL,
  `sample_id` bigint(20) NOT NULL,
  `subtask_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlqfwjbsh2s4dpnmmtc88bahco` (`execution_id`),
  KEY `FKj8e21spyvvs17exq33ut5coq6` (`sample_id`),
  KEY `FKcd0d0pf0t0l439cjovnt9otpe` (`subtask_id`),
  CONSTRAINT `FKcd0d0pf0t0l439cjovnt9otpe` FOREIGN KEY (`subtask_id`) REFERENCES `subtask` (`id`),
  CONSTRAINT `FKj8e21spyvvs17exq33ut5coq6` FOREIGN KEY (`sample_id`) REFERENCES `sample` (`id`),
  CONSTRAINT `FKlqfwjbsh2s4dpnmmtc88bahco` FOREIGN KEY (`execution_id`) REFERENCES `execution` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of execution_sample_r
-- ----------------------------

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `params` json DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKarjdud1mbnhkes90edvyq2h14` (`project_id`),
  CONSTRAINT `FKarjdud1mbnhkes90edvyq2h14` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` text,
  `ip` varchar(255) NOT NULL,
  `operate` int(11) NOT NULL,
  `operate_object_id` bigint(20) DEFAULT NULL,
  `operate_time` datetime NOT NULL,
  `operate_type` int(11) NOT NULL,
  `operator` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `code` int(11) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '1', now(), '1', now(), '0', null, '用户角色管理');
INSERT INTO `permission` VALUES ('2', '1', now(), '1', now(), '1', null, '项目编辑');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `actual_complete_time` datetime DEFAULT NULL,
  `business_no` varchar(255) DEFAULT NULL,
  `contract_name` varchar(255) NOT NULL,
  `contract_no` varchar(255) NOT NULL,
  `contract_note` text,
  `customer_email` varchar(255) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_no` varchar(255) NOT NULL,
  `customer_phone` varchar(255) NOT NULL,
  `customer_representative` varchar(255) NOT NULL,
  `customer_unit` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `no` varchar(255) DEFAULT NULL,
  `plan_complete_time` datetime DEFAULT NULL,
  `priority` int(2) NOT NULL DEFAULT '3',
  `product_status` int(11) DEFAULT NULL,
  `project_status` int(11) NOT NULL,
  `project_type` bigint(20) NOT NULL,
  `sample_category` bigint(20) NOT NULL,
  `sample_Type` bigint(20) NOT NULL,
  `special_require` text,
  `species` bigint(20) NOT NULL,
  `sub_contract_name` varchar(255) DEFAULT NULL,
  `sub_contract_no` varchar(255) DEFAULT NULL,
  `summary_note` text,
  `temp_contract` varchar(255) DEFAULT NULL,
  `sample_lot_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96c384m3vl8ng6x8acffgu8gi` (`sample_lot_id`),
  CONSTRAINT `FK96c384m3vl8ng6x8acffgu8gi` FOREIGN KEY (`sample_lot_id`) REFERENCES `sample_lot` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of project
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '1', now(), '1', now(), null, '管理员');

-- ----------------------------
-- Table structure for role_permission_r
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_r`;
CREATE TABLE `role_permission_r` (
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`permission_id`),
  KEY `FK28lliirou1m0tqgenk0qrt3i0` (`permission_id`),
  CONSTRAINT `FK28lliirou1m0tqgenk0qrt3i0` FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`),
  CONSTRAINT `FKnd7g7kuv584h1mgthp8yd4quq` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_r
-- ----------------------------
INSERT INTO `role_permission_r` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sample
-- ----------------------------
DROP TABLE IF EXISTS `sample`;
CREATE TABLE `sample` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `actual_concentration` double DEFAULT NULL,
  `deliver_concentration` double DEFAULT NULL,
  `deliver_quality` double DEFAULT NULL,
  `disqualified_reason` text,
  `execution_id` bigint(20) DEFAULT NULL,
  `init_volume` double DEFAULT NULL,
  `library_index` varchar(255) DEFAULT NULL,
  `limit_time` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `no` varchar(255) DEFAULT NULL,
  `note` text,
  `original_id` bigint(20) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `product_status` int(11) DEFAULT NULL,
  `product_time` datetime DEFAULT NULL,
  `qualified` bit(1) DEFAULT NULL,
  `receive_time` datetime DEFAULT NULL,
  `sample_status` int(11) NOT NULL,
  `storage_location` varchar(255) DEFAULT NULL,
  `surplus_volume` double DEFAULT NULL,
  `sample_lot_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqgstwakf9clyqx5bj6ygop4yo` (`sample_lot_id`),
  CONSTRAINT `FKqgstwakf9clyqx5bj6ygop4yo` FOREIGN KEY (`sample_lot_id`) REFERENCES `sample_lot` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sample
-- ----------------------------

-- ----------------------------
-- Table structure for sample_lot
-- ----------------------------
DROP TABLE IF EXISTS `sample_lot`;
CREATE TABLE `sample_lot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `affix` varchar(255) DEFAULT NULL,
  `description` text,
  `library_fragment` varchar(255) DEFAULT NULL,
  `library_index`bigint(20) DEFAULT NULL,
  `library_size` bigint(20) DEFAULT NULL,
  `library_structure` varchar(255) DEFAULT NULL,
  `no` varchar(255) NOT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `project_ref` int(11) DEFAULT NULL,
  `sample_category` bigint(20) NOT NULL,
  `sample_note` varchar(255) DEFAULT NULL,
  `sample_source` bigint(20) NOT NULL,
  `sample_type` bigint(20) NOT NULL,
  `save_way` bigint(20) DEFAULT NULL,
  `species` bigint(20) NOT NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sample_lot
-- ----------------------------

-- ----------------------------
-- Table structure for subtask
-- ----------------------------
DROP TABLE IF EXISTS `subtask`;
CREATE TABLE `subtask` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `activ_name` varchar(255) DEFAULT NULL,
  `activ_ver` varchar(255) DEFAULT NULL,
  `end_time` datetime DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `pre_subtask_id` bigint(20) DEFAULT NULL,
  `start_time` datetime DEFAULT NULL,
  `wf_name` varchar(255) DEFAULT NULL,
  `wf_ver` varchar(255) DEFAULT NULL,
  `wf_id` bigint(20) NOT NULL COMMENT '工作流ID',
  `activ_id` bigint(20) NOT NULL,
  `task_id` bigint(20) NOT NULL,
  `finishSampleCount` int(11) DEFAULT NULL,
  `sampleCount` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3ghst4ujrftxc3ovpbumookpm` (`wf_id`),
  KEY `FKcsikqffaynp2d13tfljvmv2r3` (`activ_id`),
  KEY `FKqogp98iwmph591yu58frt48ud` (`task_id`),
  CONSTRAINT `FK3ghst4ujrftxc3ovpbumookpm` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`),
  CONSTRAINT `FKcsikqffaynp2d13tfljvmv2r3` FOREIGN KEY (`activ_id`) REFERENCES `cfg_wf_activ` (`id`),
  CONSTRAINT `FKqogp98iwmph591yu58frt48ud` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subtask
-- ----------------------------

-- ----------------------------
-- Table structure for subtask_sample_r
-- ----------------------------
DROP TABLE IF EXISTS `subtask_sample_r`;
CREATE TABLE `subtask_sample_r` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sample_id` bigint(20) NOT NULL,
  `subtask_id` bigint(20) NOT NULL,
  `job_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKraox6o7xleudquvfer4t5teoc` (`sample_id`),
  KEY `FKcxhv3mex802wuhsfydj8crvhd` (`subtask_id`),
  KEY `FKlfu4jiusfb6gpjbln833skdlj` (`job_id`),
  CONSTRAINT `FKcxhv3mex802wuhsfydj8crvhd` FOREIGN KEY (`subtask_id`) REFERENCES `subtask` (`id`),
  CONSTRAINT `FKlfu4jiusfb6gpjbln833skdlj` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FKraox6o7xleudquvfer4t5teoc` FOREIGN KEY (`sample_id`) REFERENCES `sample` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subtask_sample_r
-- ----------------------------

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `actual_complete_time` datetime DEFAULT NULL,
  `actual_labor_hour` int(11) DEFAULT NULL,
  `actual_start_time` datetime DEFAULT NULL,
  `allot_operator` bigint(20) DEFAULT NULL,
  `default_task` bit(1) NOT NULL,
  `no` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `operator` bigint(20) DEFAULT NULL,
  `plan_complete_time` datetime DEFAULT NULL,
  `plan_labor_hour` int(11) DEFAULT NULL,
  `plan_start_time` datetime DEFAULT NULL,
  `pre_id` varchar(255) DEFAULT NULL,
  `sample_amount` int(11) NOT NULL,
  `sop` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `task_allot_time` datetime DEFAULT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `wf_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9hh4r25ufrrdjgqm37vgbojnj` (`job_id`),
  KEY `FKk8qrwowg31kx7hp93sru1pdqa` (`project_id`),
  KEY `FK9hjg8bnahr7pvi3ilexrmgmd3` (`wf_id`),
  CONSTRAINT `FK9hh4r25ufrrdjgqm37vgbojnj` FOREIGN KEY (`job_id`) REFERENCES `job` (`id`),
  CONSTRAINT `FK9hjg8bnahr7pvi3ilexrmgmd3` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`),
  CONSTRAINT `FKk8qrwowg31kx7hp93sru1pdqa` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKsqu3nqn650g8c1bnary749omr` FOREIGN KEY (`wf_id`) REFERENCES `cfg_wf` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of task
-- ----------------------------

-- ----------------------------
-- Table structure for tracking
-- ----------------------------
DROP TABLE IF EXISTS `tracking`;
CREATE TABLE `tracking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `operate` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `project_id` bigint(20) DEFAULT NULL,
  `sample_id` bigint(20) DEFAULT NULL,
  `sample_lot_id` bigint(20) DEFAULT NULL,
  `task_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm2tby5ysegshnej25ff0kb4q8` (`project_id`),
  KEY `FKh17g6qx44cn4e2ppn7i0459gn` (`sample_id`),
  KEY `FKm7hff13xryfkolnwbd2sbqsrx` (`sample_lot_id`),
  KEY `FK3i0p1ixga60a818u9ijo8snqv` (`task_id`),
  CONSTRAINT `FK3i0p1ixga60a818u9ijo8snqv` FOREIGN KEY (`task_id`) REFERENCES `task` (`id`),
  CONSTRAINT `FKh17g6qx44cn4e2ppn7i0459gn` FOREIGN KEY (`sample_id`) REFERENCES `sample` (`id`),
  CONSTRAINT `FKm2tby5ysegshnej25ff0kb4q8` FOREIGN KEY (`project_id`) REFERENCES `project` (`id`),
  CONSTRAINT `FKm7hff13xryfkolnwbd2sbqsrx` FOREIGN KEY (`sample_lot_id`) REFERENCES `sample_lot` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tracking
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_by` bigint(20) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` bigint(20) NOT NULL,
  `update_time` datetime NOT NULL,
  `birth_time` datetime DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', now(), '1', now(), null, null, null, '超级管理员', null, '$2a$10$CWrbUjWX.Wx2pNlURnm0/edLl.Nenx6ubTNAkui08k8Mt8qXlm5ea', null, null, '1', '', 'admin');

-- ----------------------------
-- Table structure for user_role_r
-- ----------------------------
DROP TABLE IF EXISTS `user_role_r`;
CREATE TABLE `user_role_r` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKftu17l029b3nd3kcgoiatqpfc` (`role_id`),
  CONSTRAINT `FK4rlp0ib2kc39rpvuxppyvrowv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKftu17l029b3nd3kcgoiatqpfc` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_r
-- ----------------------------
INSERT INTO `user_role_r` VALUES ('1', '1');


-- ----------------------------
-- Table structure for extract_method
-- ----------------------------
DROP TABLE IF EXISTS `extract_method`;
CREATE TABLE `extract_method` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extract_method
-- ----------------------------
INSERT INTO `extract_method` VALUES ('1', 'SDS法提取标准方法', '', 'SDSSop');
INSERT INTO `extract_method` VALUES ('2', 'CTAB法提取标准方法', '', 'CTABStandardSop');
INSERT INTO `extract_method` VALUES ('3', '月桂酸钠法提取标准方法', '', 'SodiumSop');
INSERT INTO `extract_method` VALUES ('4', '血液基因组提取', '', 'BloodGenomeSop');
INSERT INTO `extract_method` VALUES ('5', '血液红细胞DNA提取法', '', 'BloodRbcSop');
INSERT INTO `extract_method` VALUES ('6', '昆虫DNA提取', '', 'InsectSop');
INSERT INTO `extract_method` VALUES ('7', '茶叶中微生物DNA的提取', '', 'TeaSop');
INSERT INTO `extract_method` VALUES ('8', 'STE方法提取', '', 'STESop');
INSERT INTO `extract_method` VALUES ('9', '香菇基因组DNA提取', '', 'MushroomSop');
INSERT INTO `extract_method` VALUES ('10', 'CHIP-Seq', '', 'CHIPSop');
INSERT INTO `extract_method` VALUES ('11', 'Trizol法RNA提取标准方法', '', 'TrizolSop');
INSERT INTO `extract_method` VALUES ('12', '多糖多酚植物总RNA提取', '', 'PolyphenolsSop');
INSERT INTO `extract_method` VALUES ('13', 'CTAB提取法', '', 'CTABSop');
INSERT INTO `extract_method` VALUES ('14', '药用植物提取', '', 'OfficinalSop');
INSERT INTO `extract_method` VALUES ('15', 'Planteasy法标准化', '', 'PlanteasySop');
INSERT INTO `extract_method` VALUES ('16', 'EASYspin 植物RNA', '', 'EASYspinSop');
INSERT INTO `extract_method` VALUES ('17', 'mirVana™ miRNA Isolation Kit', '', 'MirVanaSop');
INSERT INTO `extract_method` VALUES ('18', '草莓果实提取脱色法', '', 'StrawberrySop');
INSERT INTO `extract_method` VALUES ('19', '异硫氰酸胍二步法标准化', '', 'GuSCNTwoSop');
INSERT INTO `extract_method` VALUES ('20', '异硫氰酸胍法标准化操作', '', 'GuSCNStandardSop');


-- ----------------------------
-- Table structure for extract_method_scheme
-- ----------------------------
DROP TABLE IF EXISTS `extract_method_scheme`;
CREATE TABLE `extract_method_scheme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `extract_method` bigint(20) DEFAULT NULL,
  `sample_category` bigint(20) DEFAULT NULL,
  `sample_type` bigint(20) DEFAULT NULL,
  `species` bigint(20) DEFAULT NULL,
  `save_way` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKq6yn4q3tyditn2lfnv0ehlxk4` (`extract_method`),
  CONSTRAINT `FKq6yn4q3tyditn2lfnv0ehlxk4` FOREIGN KEY (`extract_method`) REFERENCES `extract_method` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of extract_method_scheme
-- ----------------------------
INSERT INTO `extract_method_scheme` VALUES ('1', '1', '12', '17', '9', '65');
INSERT INTO `extract_method_scheme` VALUES ('2', '1', '12', '17', '11', '65');
INSERT INTO `extract_method_scheme` VALUES ('3', '2', '12', '17', '8', '65');
INSERT INTO `extract_method_scheme` VALUES ('4', '2', '12', '17', '11', '65');
INSERT INTO `extract_method_scheme` VALUES ('5', '3', '12', '17', '8', '65');
INSERT INTO `extract_method_scheme` VALUES ('6', '3', '12', '17', '184', '65');
INSERT INTO `extract_method_scheme` VALUES ('7', '4', '12', '17', '9', '65');
INSERT INTO `extract_method_scheme` VALUES ('8', '5', '12', '17', '9', '65');
INSERT INTO `extract_method_scheme` VALUES ('9', '6', '12', '17', '9', '65');
INSERT INTO `extract_method_scheme` VALUES ('10', '7', '12', '17', '8', '65');
INSERT INTO `extract_method_scheme` VALUES ('11', '8', '12', '17', '10', '65');
INSERT INTO `extract_method_scheme` VALUES ('12', '8', '12', '17', '11', '65');
INSERT INTO `extract_method_scheme` VALUES ('13', '9', '12', '17', '184', '65');
INSERT INTO `extract_method_scheme` VALUES ('14', '10', '12', '18', '8', '65');
INSERT INTO `extract_method_scheme` VALUES ('15', '10', '12', '18', '9', '65');
INSERT INTO `extract_method_scheme` VALUES ('16', '10', '12', '18', '10', '65');
INSERT INTO `extract_method_scheme` VALUES ('17', '10', '12', '18', '11', '65');
INSERT INTO `extract_method_scheme` VALUES ('18', '10', '12', '18', '184', '65');
INSERT INTO `extract_method_scheme` VALUES ('19', '11', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('20', '11', '14', '33', '9', '74');
INSERT INTO `extract_method_scheme` VALUES ('21', '11', '14', '33', '10', '74');
INSERT INTO `extract_method_scheme` VALUES ('22', '11', '14', '33', '11', '74');
INSERT INTO `extract_method_scheme` VALUES ('23', '11', '14', '33', '184', '74');
INSERT INTO `extract_method_scheme` VALUES ('24', '12', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('25', '13', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('26', '14', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('27', '15', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('28', '16', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('29', '17', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('30', '17', '14', '35', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('31', '18', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('32', '19', '14', '33', '8', '74');
INSERT INTO `extract_method_scheme` VALUES ('33', '20', '14', '33', '8', '74');