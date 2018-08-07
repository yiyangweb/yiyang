/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : cs_projects

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-06-21 09:50:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for annex
-- ----------------------------
DROP TABLE IF EXISTS `annex`;
CREATE TABLE `annex` (
  `ID` varchar(36) NOT NULL COMMENT '附件编号',
  `TableType` varchar(50) DEFAULT NULL COMMENT '附件类型 表名',
  `TableContentID` varchar(36) DEFAULT NULL COMMENT '关联ID 对应主键',
  `AnnexName` varchar(100) DEFAULT NULL COMMENT '附件真实名',
  `AnnexPath` varchar(100) DEFAULT NULL COMMENT '附件下载地址',
  `DownLoadTimes` int(11) DEFAULT NULL COMMENT '下载次数',
  `AnnexPoint` varchar(36) DEFAULT NULL,
  `State` varchar(10) DEFAULT NULL COMMENT '状态',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of annex
-- ----------------------------

-- ----------------------------
-- Table structure for base_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `base_dictionary`;
CREATE TABLE `base_dictionary` (
  `ID` varchar(50) NOT NULL COMMENT 'ID',
  `PARACODE` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL COMMENT '参数编码',
  `PARANAME` text COMMENT '参数名称',
  `ISDEFAULT` int(65) DEFAULT NULL COMMENT '是默认值，0：否，1：是',
  `ISSYSTEM` int(65) DEFAULT NULL COMMENT '是系统节点，0：否，1：是',
  `ISLEAF` int(65) DEFAULT NULL COMMENT '是叶子节点，0：否，1：是',
  `SEQUENCE` int(65) DEFAULT NULL COMMENT '排序号',
  `PID` varchar(50) DEFAULT NULL COMMENT '父节点ID',
  `EXTEND1` varchar(255) DEFAULT NULL COMMENT '父类目ID',
  `EXTEND2` text COMMENT '类目级别',
  `EXTEND3` text,
  `EXTEND4` varchar(255) DEFAULT NULL,
  `EXTEND5` varchar(255) DEFAULT NULL,
  `EXTEND6` varchar(255) DEFAULT NULL,
  `REMARK` varchar(200) DEFAULT NULL COMMENT '备注',
  `BRIEF_DEPT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据字典';

-- ----------------------------
-- Records of base_dictionary
-- ----------------------------
INSERT INTO `base_dictionary` VALUES ('07028a41-2f19-446f-b2c5-3f00ced7ca70', 'ProjectCategory', '项目类别', null, null, null, '4', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, '正式项目类型中项目类别', null);
INSERT INTO `base_dictionary` VALUES ('0cf6b0fd-d938-4757-8e81-10eb56fe6f83', 'A1', '处长', null, null, null, '1', 'a2d75c22-e6cb-4a00-98f3-09313f293281', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('0d404503-8c61-4897-be3f-de5a0b93c7f3', 'BIZ_TYPE', '业务类型', null, null, null, '2', '23c64891-1967-4c59-927b-0a3ec29b3c12', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('134c0d51-707b-4960-af85-dda35055c50c', 'B1', '科长', null, null, null, '3', 'a2d75c22-e6cb-4a00-98f3-09313f293281', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('1b055ef0-8ed1-487c-9881-5c968a3e5d79', 'B02', '项目评审附件', null, null, null, '2', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目评审材料', null);
INSERT INTO `base_dictionary` VALUES ('23964e6e-06c8-457c-9957-451268a00278', 'B031', '项目实施方案', null, null, null, '3', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目实施时上传项目实施方案', null);
INSERT INTO `base_dictionary` VALUES ('23c64891-1967-4c59-927b-0a3ec29b3c12', 'ALL', '全部', null, null, null, '1', '0', '', '', '', '', '', null, '', '');
INSERT INTO `base_dictionary` VALUES ('24241e91-c1d4-421c-9e9a-be9edb31bca8', 'B042', '项目督查相关图片', null, null, null, '8', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目督查时上传督查相关图片（压缩包）', null);
INSERT INTO `base_dictionary` VALUES ('26fbd020-1b20-428c-8981-22d2ab90ec6b', '1', '教授', null, null, null, '1', '8a7805a8-3640-485a-a43e-278d06136f68', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('2f980878-cd32-4f44-af37-5a493e415261', 'Office', '科室', null, null, null, '8', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('30a8eaf5-dd58-4ef4-9720-63d75665a112', 'B034', '项目下达文件', null, null, null, '6', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目实施时上传项目下达文件', null);
INSERT INTO `base_dictionary` VALUES ('3176a8cf-f42f-4a9d-bc85-88fa381691bd', 'A011', '乡镇审核中', null, null, null, '1', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_提交申请', null);
INSERT INTO `base_dictionary` VALUES ('32f03036-6880-49c3-8802-c1286e60e1c3', '3', '工程师', null, null, null, '3', '8a7805a8-3640-485a-a43e-278d06136f68', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('3898654a-85b7-44e9-a181-f446e65652df', 'AnnexType', '附件类型', null, null, null, '9', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('3d525243-18fa-4f2b-b4d8-31645002d538', 'B2', '副科长', null, null, null, '4', 'a2d75c22-e6cb-4a00-98f3-09313f293281', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('42f32445-e09a-4dd2-87e2-b61d1defd267', 'B010', '未提交', null, null, null, '0', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_申请未提交', null);
INSERT INTO `base_dictionary` VALUES ('48d51985-cf46-4647-9c65-5085ce716e55', 'C1', '科员', null, null, null, '5', 'a2d75c22-e6cb-4a00-98f3-09313f293281', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('4e8f974f-24fb-4aed-be90-2c64105cf113', '3', '竞争类', null, null, null, '3', '07028a41-2f19-446f-b2c5-3f00ced7ca70', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('57f445ce-ef4c-4703-b90a-aa158a28a00b', 'B053', '项目验收相关图片', null, null, null, '11', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目验收时上传验收相关图片（压缩包）', null);
INSERT INTO `base_dictionary` VALUES ('589b4659-476b-4970-b4df-ce453a3f6c2e', 'B052', '评审不通过', null, null, null, '7', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_专家评审不通过', null);
INSERT INTO `base_dictionary` VALUES ('58c5ec06-1355-4185-8b41-672b61f3e379', 'SYS_PARAMS', '系统参数', null, null, null, '3', '23c64891-1967-4c59-927b-0a3ec29b3c12', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('58dc9966-8bcd-4b59-a9ee-2da362f5a2ed', 'B051', '评审通过', null, null, null, '6', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_专家评审完毕', null);
INSERT INTO `base_dictionary` VALUES ('613321ec-12bd-47fe-82fe-437cd57cf76b', '2', '副教授', null, null, null, '2', '8a7805a8-3640-485a-a43e-278d06136f68', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('61e30453-d591-432d-92ce-c5843c2cad0b', 'DefaultPutInPoint', '默认项目入库审批流程', null, null, null, '1', '58c5ec06-1355-4185-8b41-672b61f3e379', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('67b4605a-2189-4dab-bb79-14d07b374161', '3', '种植类', null, null, null, '2', 'a1998950-25c4-4265-92b3-e2ddcc7b04bb', null, null, null, null, null, null, '', null);
INSERT INTO `base_dictionary` VALUES ('69303202-be08-4aef-97ab-401e154c3811', 'B041', '项目督查资料', null, null, null, '7', '3898654a-85b7-44e9-a181-f446e65652df', '', null, null, null, null, null, '项目督查时上传督查资料', null);
INSERT INTO `base_dictionary` VALUES ('6f4c5c19-df84-425e-bb0b-0443296c53c7', '4', '综合管理类', null, null, null, '3', 'a1998950-25c4-4265-92b3-e2ddcc7b04bb', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('7021687d-23e4-4ee9-b206-c8690aadd829', '1', '工程类', null, null, null, '0', 'a1998950-25c4-4265-92b3-e2ddcc7b04bb', null, null, null, null, null, null, '', null);
INSERT INTO `base_dictionary` VALUES ('7432108d-1f67-4f6f-9646-00dd1f62c8b7', 'B061', '实施材料未上传', null, null, null, '8', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目实施计划未上传', null);
INSERT INTO `base_dictionary` VALUES ('74f74048-6805-4b41-9749-b95d5827bdb8', 'B071', '验收中', null, null, null, '10', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目申请验收', null);
INSERT INTO `base_dictionary` VALUES ('77dc3447-877b-409d-9760-c9dfd4dda80e', 'xumuke', '畜牧科', null, null, null, '2', '2f980878-cd32-4f44-af37-5a493e415261', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('78097b66-0904-431e-a04c-911b5ed81d41', '1', '任务类', null, null, null, '1', '07028a41-2f19-446f-b2c5-3f00ced7ca70', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('7d486a1f-260a-4168-b8f3-67e89662f7f1', '2', '奖补类', null, null, null, '2', '07028a41-2f19-446f-b2c5-3f00ced7ca70', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('86d6371e-6100-4300-a3a5-2401dad5627e', 'B073', '申请终止', null, null, null, '12', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目申请终止', null);
INSERT INTO `base_dictionary` VALUES ('8a7805a8-3640-485a-a43e-278d06136f68', 'ExpPosition', '专家职位', null, null, null, '6', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('8d34b044-98b0-41e3-a4db-2b23be614845', 'A010', '未提交', null, null, null, '0', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_本地保存', null);
INSERT INTO `base_dictionary` VALUES ('9157ed6e-b518-4715-96b1-157e548320a7', 'A01', '项目入库附件', null, null, null, '0', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目入库时提交的附件', null);
INSERT INTO `base_dictionary` VALUES ('92694a5e-f03d-44bf-a590-c90c4827a47c', 'A031', '入库完成', null, null, null, '4', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_业务对口科室同意', null);
INSERT INTO `base_dictionary` VALUES ('977e3bf0-c83d-4962-9d77-19b1e218a8e3', 'DefaultProjectPoint', '默认项目管理审批流程', null, null, null, '2', '58c5ec06-1355-4185-8b41-672b61f3e379', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('98dde96d-22f3-4196-890a-2cb290ea6f50', 'B062', '实施中', null, null, null, '9', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目实施中', null);
INSERT INTO `base_dictionary` VALUES ('a1998950-25c4-4265-92b3-e2ddcc7b04bb', 'ExpertType', '专家类型', null, null, null, '2', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('a2d75c22-e6cb-4a00-98f3-09313f293281', 'ExpDuty', '专家职务', null, null, null, '5', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('a7b1a284-875f-44cb-a071-91f480539c0f', 'B022', '乡镇驳回', null, null, null, '3', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_乡镇不同意', null);
INSERT INTO `base_dictionary` VALUES ('ad65f673-a49c-4093-9005-54598ca0a2ab', 'B021', '业务对口科室审核中', null, null, null, '2', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_乡镇审批同意', null);
INSERT INTO `base_dictionary` VALUES ('b709ccea-7c66-4a6f-8ad5-030eb7fbc344', 'A032', '业务对口科室驳回', null, null, null, '5', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_业务对口科室不同意', null);
INSERT INTO `base_dictionary` VALUES ('ba2da5e7-55e1-4409-a8b5-7843e40bb4e4', 'yuyeke', '渔业科', null, null, null, '1', '2f980878-cd32-4f44-af37-5a493e415261', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('bf95fedb-771e-4fd3-8fac-4cfe70c0dcf1', 'B074', '项目终止', null, null, null, '13', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_终止申请_乡镇同意', null);
INSERT INTO `base_dictionary` VALUES ('c1f0ee3f-40dc-4fd1-9254-9d45fea79a6b', 'B033', '项目批复文件', null, null, null, '5', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目实施时上传项目批复文件', null);
INSERT INTO `base_dictionary` VALUES ('c2e57ec5-a940-4fe9-802b-e2c25a8d4a8e', 'A2', '副处长', null, null, null, '2', 'a2d75c22-e6cb-4a00-98f3-09313f293281', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('c9e4663b-0b23-461c-bf3e-74547ffca17a', 'B01', '项目申报附件', null, null, null, '1', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目提交申请时上传的附件', null);
INSERT INTO `base_dictionary` VALUES ('cb84f012-03af-4130-9850-530193c64eea', 'meili', '梅李镇', null, null, null, '1', 'e93abfce-37b1-496b-b2a0-b7a9e9c17f8b', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('ccf53065-1046-46ea-9554-4f5d9c0ac01e', 'B011', '乡镇审核中', null, null, null, '1', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_提交申请', null);
INSERT INTO `base_dictionary` VALUES ('cd504412-dcfd-48fb-98cf-51b70e8f6af7', 'A021', '业务对口科室审核中', null, null, null, '2', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_乡镇审批同意', null);
INSERT INTO `base_dictionary` VALUES ('cf0d70c9-da89-43e3-bdba-e68fece79abf', 'B052', '项目验收审计报告', null, null, null, '10', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目验收时上传审计报告', null);
INSERT INTO `base_dictionary` VALUES ('cf6ecac9-ca81-42fb-b210-876f98817fcc', '2', '养殖类', null, null, null, '1', 'a1998950-25c4-4265-92b3-e2ddcc7b04bb', null, null, null, null, null, null, '', null);
INSERT INTO `base_dictionary` VALUES ('d3684712-c473-4d8e-86f7-e5913ef2713a', 'B051', '项目验收申请', null, null, null, '9', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目验收时上传验收申请', null);
INSERT INTO `base_dictionary` VALUES ('d3c26dbc-b3b4-4d41-946e-f561cc240f80', 'B032', '业务对口科室驳回', null, null, null, '5', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_业务对口科室不同意', null);
INSERT INTO `base_dictionary` VALUES ('e36f150f-be03-47ed-a3e7-40f8be1cc451', 'A022', '乡镇驳回', null, null, null, '3', '61e30453-d591-432d-92ce-c5843c2cad0b', null, null, null, null, null, null, '项目入库申报_乡镇审批同意', null);
INSERT INTO `base_dictionary` VALUES ('e4b738c8-dfdf-47c4-8642-a9ba01ea5d12', 'B072', '项目完成', null, null, null, '11', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目验收完成', null);
INSERT INTO `base_dictionary` VALUES ('e506784e-5cb4-459f-b9b7-679d551a4594', '4', '高级工程师', null, null, null, '4', '8a7805a8-3640-485a-a43e-278d06136f68', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('e93abfce-37b1-496b-b2a0-b7a9e9c17f8b', 'Town', '乡镇', null, null, null, '7', '0d404503-8c61-4897-be3f-de5a0b93c7f3', null, null, null, null, null, null, null, null);
INSERT INTO `base_dictionary` VALUES ('eaa80678-ca7d-43e8-9f94-312f8d700684', 'B081', '项目已归档', null, null, null, '14', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_项目已归档', null);
INSERT INTO `base_dictionary` VALUES ('eb6c4c0b-4a33-47a2-8ec7-ce80a57e7096', 'B032', '项目实施相关图片', null, null, null, '4', '3898654a-85b7-44e9-a181-f446e65652df', null, null, null, null, null, null, '项目实施时上传项目实施相关图片（压缩包）', null);
INSERT INTO `base_dictionary` VALUES ('eff0159b-fa09-4aac-b49b-826527f9db12', 'B031', '评审中', null, null, null, '4', '977e3bf0-c83d-4962-9d77-19b1e218a8e3', null, null, null, null, null, null, '项目申报_业务对口科室同意', null);

-- ----------------------------
-- Table structure for expert
-- ----------------------------
DROP TABLE IF EXISTS `expert`;
CREATE TABLE `expert` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `Name` varchar(50) DEFAULT NULL COMMENT '专家名称',
  `Department` varchar(100) DEFAULT NULL COMMENT '专家单位',
  `PhoneNumber` varchar(20) DEFAULT NULL COMMENT '专家联系电话',
  `Type` varchar(36) DEFAULT NULL COMMENT '专家类型',
  `Gender` varchar(5) DEFAULT NULL COMMENT '专家性别 ',
  `ExpPosition` varchar(36) DEFAULT NULL COMMENT '专家职位',
  `ExpDuty` varchar(36) DEFAULT NULL COMMENT '专家职务',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='专家库';

-- ----------------------------
-- Records of expert
-- ----------------------------
INSERT INTO `expert` VALUES ('2a3d61c5-d391-4c1e-858e-f7af401514ee', '测试01', '测试01', '18827012988', '1', '男', '1', 'A1', 'admin', '2018-06-20 10:50:59', null, null);
INSERT INTO `expert` VALUES ('3b071d4a-eace-4f53-9bca-545cf118eb50', '111111', '常熟', '1111111111111', '2', '女', '2', 'B1', 'admin', '2018-06-20 14:09:17', 'admin', '2018-06-20 14:09:27');
INSERT INTO `expert` VALUES ('85f16c9e-bf98-4061-bdc8-67445f1f59d5', '王五', '苏州', '11111111', '1', '男', '4', 'C1', 'admin', '2018-06-15 12:45:54', 'admin', '2018-06-15 14:50:35');
INSERT INTO `expert` VALUES ('c6aaaab6-d88e-4d06-84d5-26e79d7fcad6', '张二', '农委', '18268370000', '2', '男', '2', 'C1', '张三', '2018-06-19 10:36:10', null, null);
INSERT INTO `expert` VALUES ('df8f2049-aa3b-4402-a320-7d9795b9ba7e', '小红', '浙江', '4444446', '2', '女', '2', 'A2', 'admin', '2018-06-15 14:46:26', 'admin', '2018-06-20 12:52:47');
INSERT INTO `expert` VALUES ('fc52d031-3e76-4aab-ab4c-68dcf534fa37', '朱', '农委1', '18268370001', '3', '男', '3', 'C1', '张三', '2018-06-20 10:30:16', null, null);

-- ----------------------------
-- Table structure for op_attach
-- ----------------------------
DROP TABLE IF EXISTS `op_attach`;
CREATE TABLE `op_attach` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `OP_TYPE` varchar(50) DEFAULT NULL COMMENT '业务类型',
  `BIZ_TYPE` varchar(50) DEFAULT NULL COMMENT '附件业务类型',
  `LINK_NO` varchar(50) DEFAULT NULL COMMENT '关联单据号',
  `FILE_TYPE` varchar(5) NOT NULL COMMENT '附件类型',
  `FILE_NAME_ORIGIN` varchar(500) NOT NULL COMMENT '原始文件名称',
  `FILE_NAME_DEFINE` varchar(500) NOT NULL COMMENT '系统文件名称',
  `FILE_DESP` varchar(500) DEFAULT NULL COMMENT '附件描述',
  `FILE_OCCUR_DATE` date DEFAULT NULL COMMENT '附件日期',
  `FILE_LIMIT_DATE` date DEFAULT NULL COMMENT '证件有效期',
  `FILE_PATH` varchar(500) NOT NULL COMMENT '文件路径',
  `FILE_SIZE` int(11) DEFAULT NULL COMMENT '文件大小',
  `FILE_EXT` varchar(20) DEFAULT NULL COMMENT '文件扩展类型',
  `DOWN_NUM` int(11) DEFAULT NULL COMMENT '下载次数',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(20) NOT NULL,
  `CREATE_DEPT` varchar(20) DEFAULT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL COMMENT '最新更新时间',
  `UPDATE_USER` varchar(20) DEFAULT NULL COMMENT '更新人',
  `UPDATE_DEPT` varchar(20) DEFAULT NULL,
  `EXTEND1` varchar(200) DEFAULT NULL COMMENT '扩展1',
  `EXTEND2` varchar(200) DEFAULT NULL COMMENT '扩展2',
  `EXTEND3` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公用附件表';

-- ----------------------------
-- Records of op_attach
-- ----------------------------

-- ----------------------------
-- Table structure for op_log
-- ----------------------------
DROP TABLE IF EXISTS `op_log`;
CREATE TABLE `op_log` (
  `ID` int(30) NOT NULL AUTO_INCREMENT,
  `OPERATE_USER` varchar(50) DEFAULT NULL COMMENT '操作人',
  `OPERATE_TIME` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '操作时间',
  `BILL_NO` varchar(100) DEFAULT NULL COMMENT '业务单据号',
  `OP_TYPE` varchar(50) DEFAULT NULL COMMENT '业务类别',
  `IP` varchar(50) DEFAULT NULL COMMENT 'IP',
  `CONTENT` varchar(200) DEFAULT NULL COMMENT '操作描述',
  `EXTEND1` varchar(50) DEFAULT NULL,
  `EXTEND2` varchar(50) DEFAULT NULL,
  `EXTEND3` varchar(50) DEFAULT NULL,
  `SYSTEM` varchar(50) DEFAULT NULL COMMENT '系统',
  `MODULE` varchar(50) DEFAULT NULL COMMENT '模块',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2427 DEFAULT CHARSET=utf8 COMMENT='系统日志表';

-- ----------------------------
-- Records of op_log
-- ----------------------------
INSERT INTO `op_log` VALUES ('1468', 'admin', '2018-06-13 15:55:44', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1469', 'admin', '2018-06-13 16:03:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1470', 'room', '2018-06-13 16:05:19', 'room', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1471', 'admin', '2018-06-13 16:05:38', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1472', 'admin', '2018-06-13 16:45:55', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1473', 'room', '2018-06-13 16:48:04', 'room', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1474', 'admin', '2018-06-14 08:37:13', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1475', 'qiyi', '2018-06-14 08:39:04', 'qiye', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1476', 'admin', '2018-06-14 08:39:18', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1477', 'admin', '2018-06-14 08:44:14', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1478', 'admin', '2018-06-14 08:48:32', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1479', 'admin', '2018-06-14 08:50:27', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1480', 'admin', '2018-06-14 08:56:33', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1481', 'admin', '2018-06-14 09:01:07', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1482', 'admin', '2018-06-14 09:07:00', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1483', 'admin', '2018-06-14 09:16:58', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1484', 'admin', '2018-06-14 09:35:35', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1485', 'admin', '2018-06-14 09:41:17', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1486', 'admin', '2018-06-14 09:42:18', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1487', 'admin', '2018-06-14 09:46:55', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1488', 'admin', '2018-06-14 09:47:52', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1489', 'admin', '2018-06-14 09:49:07', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1490', 'admin', '2018-06-14 09:50:10', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1491', 'admin', '2018-06-14 09:53:39', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1492', 'admin', '2018-06-14 09:58:08', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1493', 'admin', '2018-06-14 09:58:11', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1494', 'admin', '2018-06-14 09:58:55', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1495', 'admin', '2018-06-14 10:05:27', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1496', 'admin', '2018-06-14 10:06:55', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1497', 'admin', '2018-06-14 11:52:24', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('1498', 'admin', '2018-06-14 11:58:09', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1499', 'admin', '2018-06-14 11:58:09', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1500', 'admin', '2018-06-14 11:58:09', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1501', 'admin', '2018-06-14 11:58:09', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1502', 'admin', '2018-06-14 11:59:53', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1503', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1504', 'admin', '2018-06-14 11:59:53', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1505', 'admin', '2018-06-14 11:59:53', 'BG_BILL_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1506', 'admin', '2018-06-14 11:59:53', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1507', 'admin', '2018-06-14 11:59:53', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1508', 'admin', '2018-06-14 11:59:53', '11', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1509', 'admin', '2018-06-14 11:59:53', 'ENTER_OUT_FLAG', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1510', 'admin', '2018-06-14 11:59:53', 'I', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1511', 'admin', '2018-06-14 11:59:53', 'E', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1512', 'admin', '2018-06-14 11:59:53', 'LICENSEDOCU', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1513', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1514', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1515', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1516', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1517', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1518', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1519', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1520', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE_8', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1521', 'admin', '2018-06-14 11:59:53', 'FEE_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1522', 'admin', '2018-06-14 11:59:53', 'GeneralIm', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1523', 'admin', '2018-06-14 11:59:53', 'GeneralExp', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1524', 'admin', '2018-06-14 11:59:53', 'BondedIm', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1525', 'admin', '2018-06-14 11:59:53', 'BondedExp', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1526', 'admin', '2018-06-14 11:59:53', 'BIZ_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1527', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1528', 'admin', '2018-06-14 11:59:53', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1529', 'admin', '2018-06-14 11:59:53', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1530', 'admin', '2018-06-14 11:59:53', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1531', 'admin', '2018-06-14 11:59:53', 'ENT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1532', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1533', 'admin', '2018-06-14 11:59:53', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1534', 'admin', '2018-06-14 11:59:53', 'ENT_QUALITY', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1535', 'admin', '2018-06-14 11:59:53', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1536', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1537', 'admin', '2018-06-14 11:59:53', 'COMPANY_SUBJECT', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1538', 'admin', '2018-06-14 11:59:53', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1539', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1540', 'admin', '2018-06-14 11:59:53', 'REGIST_OVERSEA', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1541', 'admin', '2018-06-14 11:59:53', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1542', 'admin', '2018-06-14 11:59:53', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1543', 'admin', '2018-06-14 11:59:53', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1544', 'admin', '2018-06-14 11:59:53', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1545', 'admin', '2018-06-14 11:59:53', '5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1546', 'admin', '2018-06-14 11:59:53', '6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1547', 'admin', '2018-06-14 11:59:53', '7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1548', 'admin', '2018-06-14 11:59:53', 'BUSINESS_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1549', 'admin', '2018-06-14 11:59:53', 'ATTACH_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1550', 'admin', '2018-06-14 11:59:53', 'ATTACH_TYPE_COMPANY', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1551', 'admin', '2018-06-14 11:59:53', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1552', 'admin', '2018-06-14 11:59:53', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1553', 'admin', '2018-06-14 11:59:53', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1554', 'admin', '2018-06-14 11:59:53', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1555', 'admin', '2018-06-14 11:59:53', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1556', 'admin', '2018-06-14 11:59:54', 'ATTACH_CONTENT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1557', 'admin', '2018-06-14 11:59:54', 'doc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1558', 'admin', '2018-06-14 11:59:54', 'jpg', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1559', 'admin', '2018-06-14 11:59:54', 'jpeg', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1560', 'admin', '2018-06-14 11:59:54', 'xls', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1561', 'admin', '2018-06-14 11:59:54', 'docx', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1562', 'admin', '2018-06-14 11:59:54', 'xlsx', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1563', 'admin', '2018-06-14 11:59:54', 'pdf', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1564', 'admin', '2018-06-14 11:59:54', 'png', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1565', 'admin', '2018-06-14 11:59:54', 'txt', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1566', 'admin', '2018-06-14 11:59:54', 'ppt', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1567', 'admin', '2018-06-14 11:59:54', 'ATTACH_BIZ_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1568', 'admin', '2018-06-14 11:59:54', 'NeededDoc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1569', 'admin', '2018-06-14 11:59:54', 'ControlMeasure', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1570', 'admin', '2018-06-14 11:59:54', 'AccompanyDoc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1571', 'admin', '2018-06-14 11:59:54', 'ATTACTMENT_PARAM', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1572', 'admin', '2018-06-14 11:59:54', 'ORGNIZATION', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1573', 'admin', '2018-06-14 11:59:54', 'PERSONAL', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1574', 'admin', '2018-06-14 11:59:54', 'TAX_PAYER_NATURE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1575', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1576', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1577', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1578', 'admin', '2018-06-14 11:59:54', 'DRAWBACK_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1579', 'admin', '2018-06-14 11:59:54', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1580', 'admin', '2018-06-14 11:59:54', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1581', 'admin', '2018-06-14 11:59:54', 'RK_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1582', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1583', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1584', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1585', 'admin', '2018-06-14 11:59:54', 'LOGISTICS_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1586', 'admin', '2018-06-14 11:59:54', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1587', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1588', 'admin', '2018-06-14 11:59:54', 'FOR_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1589', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1590', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1591', 'admin', '2018-06-14 11:59:54', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1592', 'admin', '2018-06-14 11:59:54', 'CHECKLIST_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1593', 'admin', '2018-06-14 11:59:54', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1594', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1595', 'admin', '2018-06-14 11:59:54', 'IMPORT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1596', 'admin', '2018-06-14 11:59:54', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1597', 'admin', '2018-06-14 11:59:54', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1598', 'admin', '2018-06-14 11:59:54', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1599', 'admin', '2018-06-14 11:59:54', 'TYPE_OF_ID CERTIFICATE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1600', 'admin', '2018-06-14 11:59:54', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1601', 'admin', '2018-06-14 11:59:54', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1602', 'admin', '2018-06-14 11:59:54', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1603', 'admin', '2018-06-14 11:59:54', 'DECLARECOMPANY_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1604', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1605', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1606', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1607', 'admin', '2018-06-14 11:59:54', 'PAPER_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1608', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1609', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1610', 'admin', '2018-06-14 11:59:54', 'BUYERID_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1611', 'admin', '2018-06-14 11:59:54', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1612', 'admin', '2018-06-14 11:59:54', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1613', 'admin', '2018-06-14 11:59:54', 'USETO_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1614', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1615', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1616', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1617', 'admin', '2018-06-14 11:59:54', 'APP_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1618', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1619', 'admin', '2018-06-14 11:59:54', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1620', 'admin', '2018-06-14 11:59:54', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1621', 'admin', '2018-06-14 11:59:54', 'MARK_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1622', 'admin', '2018-06-14 11:59:54', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1623', 'admin', '2018-06-14 11:59:54', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1624', 'admin', '2018-06-14 11:59:54', 'BAG_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1625', 'admin', '2018-06-14 12:00:29', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1626', 'admin', '2018-06-14 12:00:29', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1627', 'admin', '2018-06-14 12:00:29', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1628', 'admin', '2018-06-14 12:00:29', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1629', 'admin', '2018-06-14 12:00:29', 'T0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1630', 'admin', '2018-06-14 12:00:29', 'SEND_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1631', 'admin', '2018-06-14 12:00:29', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1632', 'admin', '2018-06-14 12:00:29', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1633', 'admin', '2018-06-14 12:00:29', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1634', 'admin', '2018-06-14 12:00:29', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1635', 'admin', '2018-06-14 12:00:29', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1636', 'admin', '2018-06-14 12:00:29', '06', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1637', 'admin', '2018-06-14 12:00:29', '07', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1638', 'admin', '2018-06-14 12:00:29', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1639', 'admin', '2018-06-14 12:00:29', '09', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1640', 'admin', '2018-06-14 12:00:29', 'CUS_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1641', 'admin', '2018-06-14 12:00:29', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1642', 'admin', '2018-06-14 12:00:29', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1643', 'admin', '2018-06-14 12:00:29', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1644', 'admin', '2018-06-14 12:00:29', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1645', 'admin', '2018-06-14 12:00:29', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1646', 'admin', '2018-06-14 12:00:29', '06', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1647', 'admin', '2018-06-14 12:00:29', '07', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1648', 'admin', '2018-06-14 12:00:29', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1649', 'admin', '2018-06-14 12:00:29', 'CIQ_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1650', 'admin', '2018-06-14 12:00:29', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1651', 'admin', '2018-06-14 12:00:29', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1652', 'admin', '2018-06-14 12:00:29', '30', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1653', 'admin', '2018-06-14 12:00:29', '40', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1654', 'admin', '2018-06-14 12:00:29', '50', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1655', 'admin', '2018-06-14 12:00:29', 'LOGISTICS_I_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1656', 'admin', '2018-06-14 12:00:29', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1657', 'admin', '2018-06-14 12:00:29', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1658', 'admin', '2018-06-14 12:00:29', '30', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1659', 'admin', '2018-06-14 12:00:29', '40', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1660', 'admin', '2018-06-14 12:00:29', 'LOGISTICS_E_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1661', 'admin', '2018-06-14 12:00:29', '32', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1662', 'admin', '2018-06-14 12:00:29', '33', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1663', 'admin', '2018-06-14 12:00:29', '34', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1664', 'admin', '2018-06-14 12:00:29', '41', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1665', 'admin', '2018-06-14 12:00:29', '42', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1666', 'admin', '2018-06-14 12:00:29', '51', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1667', 'admin', '2018-06-14 12:00:29', '52', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1668', 'admin', '2018-06-14 12:00:29', '61', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1669', 'admin', '2018-06-14 12:00:29', '62', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1670', 'admin', '2018-06-14 12:00:29', 'M3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1671', 'admin', '2018-06-14 12:00:29', '80', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1672', 'admin', '2018-06-14 12:00:29', '90', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1673', 'admin', '2018-06-14 12:00:29', '91', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1674', 'admin', '2018-06-14 12:00:29', '92', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1675', 'admin', '2018-06-14 12:00:29', 'RELEASE_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1676', 'admin', '2018-06-14 12:00:29', '32', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1677', 'admin', '2018-06-14 12:00:29', '99', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1678', 'admin', '2018-06-14 12:00:29', '33', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1679', 'admin', '2018-06-14 12:00:29', '34', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1680', 'admin', '2018-06-14 12:00:29', '42', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1681', 'admin', '2018-06-14 12:00:29', '80', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1682', 'admin', '2018-06-14 12:00:29', '51', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1683', 'admin', '2018-06-14 12:00:29', '53', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1684', 'admin', '2018-06-14 12:00:29', '52', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1685', 'admin', '2018-06-14 12:00:29', 'M4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1686', 'admin', '2018-06-14 12:00:29', 'M5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1687', 'admin', '2018-06-14 12:00:29', 'M6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1688', 'admin', '2018-06-14 12:00:29', 'N1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1689', 'admin', '2018-06-14 12:00:29', 'N2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1690', 'admin', '2018-06-14 12:00:29', 'N3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1691', 'admin', '2018-06-14 12:00:29', 'INVENTORY_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1692', 'admin', '2018-06-14 12:00:29', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1693', 'admin', '2018-06-14 12:00:29', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1694', 'admin', '2018-06-14 12:00:29', 'APP_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1695', 'admin', '2018-06-14 12:00:46', 'ENT_AUDIT_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1696', 'admin', '2018-06-14 12:01:15', 'ENT_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1697', 'admin', '2018-06-14 12:01:15', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1698', 'admin', '2018-06-14 12:01:15', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1699', 'admin', '2018-06-14 12:01:15', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1700', 'admin', '2018-06-14 12:01:15', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1701', 'admin', '2018-06-14 12:01:15', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1702', 'admin', '2018-06-14 12:01:15', 'ENT_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1703', 'admin', '2018-06-14 12:01:15', '00', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1704', 'admin', '2018-06-14 12:01:15', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1705', 'admin', '2018-06-14 12:01:15', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1706', 'admin', '2018-06-14 12:01:15', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1707', 'admin', '2018-06-14 12:01:15', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1708', 'admin', '2018-06-14 12:01:15', 'BILL_STATE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1709', 'admin', '2018-06-14 12:01:15', 'ATTACH_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1710', 'admin', '2018-06-14 12:01:15', 'CCF_DOCUTYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1711', 'admin', '2018-06-14 12:01:15', '00000008', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1712', 'admin', '2018-06-14 12:01:15', '00000001', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1713', 'admin', '2018-06-14 12:01:15', '00000002', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1714', 'admin', '2018-06-14 12:01:15', '00000003', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1715', 'admin', '2018-06-14 12:01:15', '00000004', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1716', 'admin', '2018-06-14 12:01:15', '00000005', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1717', 'admin', '2018-06-14 12:01:15', '00000006', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1718', 'admin', '2018-06-14 12:01:15', '00000007', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1719', 'admin', '2018-06-14 12:01:15', '00000009', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1720', 'admin', '2018-06-14 12:01:15', '10000001', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1721', 'admin', '2018-06-14 12:01:15', '10000002', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1722', 'admin', '2018-06-14 12:01:15', '10000003', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1723', 'admin', '2018-06-14 12:01:15', 'REC_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1724', 'admin', '2018-06-14 12:01:15', 'A', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1725', 'admin', '2018-06-14 12:01:15', 'B', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1726', 'admin', '2018-06-14 12:01:15', 'C', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1727', 'admin', '2018-06-14 12:01:15', 'D', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1728', 'admin', '2018-06-14 12:01:15', 'E', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1729', 'admin', '2018-06-14 12:01:15', 'F', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1730', 'admin', '2018-06-14 12:01:15', 'G', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1731', 'admin', '2018-06-14 12:01:15', 'H', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1732', 'admin', '2018-06-14 12:01:15', 'J', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1733', 'admin', '2018-06-14 12:01:15', 'K', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1734', 'admin', '2018-06-14 12:01:15', 'CUSTOMER_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1735', 'admin', '2018-06-14 12:01:15', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1736', 'admin', '2018-06-14 12:01:15', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1737', 'admin', '2018-06-14 12:01:15', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1738', 'admin', '2018-06-14 12:01:15', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1739', 'admin', '2018-06-14 12:01:15', '5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1740', 'admin', '2018-06-14 12:01:15', '6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1741', 'admin', '2018-06-14 12:01:15', '7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1742', 'admin', '2018-06-14 12:01:15', 'BILL_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1743', 'admin', '2018-06-14 12:01:15', 'DEFAULT_ADVICE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1744', 'admin', '2018-06-14 12:01:15', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1745', 'admin', '2018-06-14 12:01:15', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1746', 'admin', '2018-06-14 12:01:15', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1747', 'admin', '2018-06-14 12:01:15', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1748', 'admin', '2018-06-14 12:01:15', 'SYS_PARAMS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1749', 'admin', '2018-06-14 12:02:19', '00', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1750', 'admin', '2018-06-14 12:02:19', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1751', 'admin', '2018-06-14 12:02:19', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1752', 'admin', '2018-06-14 12:02:19', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1753', 'admin', '2018-06-14 12:02:19', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1754', 'admin', '2018-06-14 12:02:19', 'ENT_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1755', 'admin', '2018-06-14 12:02:19', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1756', 'admin', '2018-06-14 12:02:19', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1757', 'admin', '2018-06-14 12:02:19', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1758', 'admin', '2018-06-14 12:02:19', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1759', 'admin', '2018-06-14 12:02:19', 'T0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1760', 'admin', '2018-06-14 12:02:19', 'SEND_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1761', 'admin', '2018-06-14 12:02:19', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1762', 'admin', '2018-06-14 12:02:19', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1763', 'admin', '2018-06-14 12:02:19', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1764', 'admin', '2018-06-14 12:02:19', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1765', 'admin', '2018-06-14 12:02:19', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1766', 'admin', '2018-06-14 12:02:19', '06', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1767', 'admin', '2018-06-14 12:02:19', '07', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1768', 'admin', '2018-06-14 12:02:19', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1769', 'admin', '2018-06-14 12:02:19', '09', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1770', 'admin', '2018-06-14 12:02:19', 'CUS_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1771', 'admin', '2018-06-14 12:02:19', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1772', 'admin', '2018-06-14 12:02:19', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1773', 'admin', '2018-06-14 12:02:19', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1774', 'admin', '2018-06-14 12:02:19', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1775', 'admin', '2018-06-14 12:02:19', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1776', 'admin', '2018-06-14 12:02:19', '06', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1777', 'admin', '2018-06-14 12:02:19', '07', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1778', 'admin', '2018-06-14 12:02:19', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1779', 'admin', '2018-06-14 12:02:19', 'CIQ_CHK_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1780', 'admin', '2018-06-14 12:02:19', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1781', 'admin', '2018-06-14 12:02:19', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1782', 'admin', '2018-06-14 12:02:19', '30', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1783', 'admin', '2018-06-14 12:02:19', '40', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1784', 'admin', '2018-06-14 12:02:19', '50', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1785', 'admin', '2018-06-14 12:02:19', 'LOGISTICS_I_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1786', 'admin', '2018-06-14 12:02:19', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1787', 'admin', '2018-06-14 12:02:19', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1788', 'admin', '2018-06-14 12:02:19', '30', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1789', 'admin', '2018-06-14 12:02:19', '40', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1790', 'admin', '2018-06-14 12:02:19', 'LOGISTICS_E_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1791', 'admin', '2018-06-14 12:02:19', '32', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1792', 'admin', '2018-06-14 12:02:19', '33', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1793', 'admin', '2018-06-14 12:02:19', '34', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1794', 'admin', '2018-06-14 12:02:19', '41', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1795', 'admin', '2018-06-14 12:02:19', '42', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1796', 'admin', '2018-06-14 12:02:19', '51', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1797', 'admin', '2018-06-14 12:02:19', '52', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1798', 'admin', '2018-06-14 12:02:19', '61', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1799', 'admin', '2018-06-14 12:02:19', '62', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1800', 'admin', '2018-06-14 12:02:19', 'M3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1801', 'admin', '2018-06-14 12:02:19', '80', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1802', 'admin', '2018-06-14 12:02:19', '90', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1803', 'admin', '2018-06-14 12:02:19', '91', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1804', 'admin', '2018-06-14 12:02:19', '92', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1805', 'admin', '2018-06-14 12:02:19', 'RELEASE_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1806', 'admin', '2018-06-14 12:02:19', '32', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1807', 'admin', '2018-06-14 12:02:19', '99', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1808', 'admin', '2018-06-14 12:02:19', '33', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1809', 'admin', '2018-06-14 12:02:19', '34', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1810', 'admin', '2018-06-14 12:02:19', '42', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1811', 'admin', '2018-06-14 12:02:19', '80', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1812', 'admin', '2018-06-14 12:02:19', '51', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1813', 'admin', '2018-06-14 12:02:19', '53', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1814', 'admin', '2018-06-14 12:02:19', '52', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1815', 'admin', '2018-06-14 12:02:19', 'M4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1816', 'admin', '2018-06-14 12:02:19', 'M5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1817', 'admin', '2018-06-14 12:02:19', 'M6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1818', 'admin', '2018-06-14 12:02:19', 'N1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1819', 'admin', '2018-06-14 12:02:19', 'N2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1820', 'admin', '2018-06-14 12:02:19', 'N3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1821', 'admin', '2018-06-14 12:02:19', 'INVENTORY_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1822', 'admin', '2018-06-14 12:02:19', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1823', 'admin', '2018-06-14 12:02:19', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1824', 'admin', '2018-06-14 12:02:19', 'APP_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1825', 'admin', '2018-06-14 12:02:31', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1826', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1827', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1828', 'admin', '2018-06-14 12:02:31', 'BG_BILL_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1829', 'admin', '2018-06-14 12:02:31', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1830', 'admin', '2018-06-14 12:02:31', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1831', 'admin', '2018-06-14 12:02:31', '11', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1832', 'admin', '2018-06-14 12:02:31', 'ENTER_OUT_FLAG', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1833', 'admin', '2018-06-14 12:02:31', 'I', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1834', 'admin', '2018-06-14 12:02:31', 'E', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1835', 'admin', '2018-06-14 12:02:31', 'LICENSEDOCU', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1836', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1837', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1838', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1839', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1840', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1841', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1842', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1843', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE_8', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1844', 'admin', '2018-06-14 12:02:31', 'FEE_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1845', 'admin', '2018-06-14 12:02:31', 'GeneralIm', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1846', 'admin', '2018-06-14 12:02:31', 'GeneralExp', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1847', 'admin', '2018-06-14 12:02:31', 'BondedIm', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1848', 'admin', '2018-06-14 12:02:31', 'BondedExp', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1849', 'admin', '2018-06-14 12:02:31', 'BIZ_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1850', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1851', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1852', 'admin', '2018-06-14 12:02:31', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1853', 'admin', '2018-06-14 12:02:31', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1854', 'admin', '2018-06-14 12:02:31', 'ENT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1855', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1856', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1857', 'admin', '2018-06-14 12:02:31', 'ENT_QUALITY', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1858', 'admin', '2018-06-14 12:02:31', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1859', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1860', 'admin', '2018-06-14 12:02:31', 'COMPANY_SUBJECT', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1861', 'admin', '2018-06-14 12:02:31', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1862', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1863', 'admin', '2018-06-14 12:02:31', 'REGIST_OVERSEA', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1864', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1865', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1866', 'admin', '2018-06-14 12:02:31', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1867', 'admin', '2018-06-14 12:02:31', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1868', 'admin', '2018-06-14 12:02:31', '5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1869', 'admin', '2018-06-14 12:02:31', '6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1870', 'admin', '2018-06-14 12:02:31', '7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1871', 'admin', '2018-06-14 12:02:31', 'BUSINESS_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1872', 'admin', '2018-06-14 12:02:31', 'ATTACH_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1873', 'admin', '2018-06-14 12:02:31', 'ATTACH_TYPE_COMPANY', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1874', 'admin', '2018-06-14 12:02:31', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1875', 'admin', '2018-06-14 12:02:31', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1876', 'admin', '2018-06-14 12:02:31', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1877', 'admin', '2018-06-14 12:02:31', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1878', 'admin', '2018-06-14 12:02:31', '05', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1879', 'admin', '2018-06-14 12:02:31', 'ATTACH_CONTENT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1880', 'admin', '2018-06-14 12:02:31', 'doc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1881', 'admin', '2018-06-14 12:02:31', 'jpg', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1882', 'admin', '2018-06-14 12:02:31', 'jpeg', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1883', 'admin', '2018-06-14 12:02:31', 'xls', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1884', 'admin', '2018-06-14 12:02:31', 'docx', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1885', 'admin', '2018-06-14 12:02:31', 'xlsx', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1886', 'admin', '2018-06-14 12:02:31', 'pdf', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1887', 'admin', '2018-06-14 12:02:31', 'png', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1888', 'admin', '2018-06-14 12:02:31', 'txt', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1889', 'admin', '2018-06-14 12:02:31', 'ppt', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1890', 'admin', '2018-06-14 12:02:31', 'ATTACH_BIZ_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1891', 'admin', '2018-06-14 12:02:31', 'NeededDoc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1892', 'admin', '2018-06-14 12:02:31', 'ControlMeasure', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1893', 'admin', '2018-06-14 12:02:31', 'AccompanyDoc', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1894', 'admin', '2018-06-14 12:02:31', 'ATTACTMENT_PARAM', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1895', 'admin', '2018-06-14 12:02:31', 'ORGNIZATION', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1896', 'admin', '2018-06-14 12:02:31', 'PERSONAL', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1897', 'admin', '2018-06-14 12:02:31', 'TAX_PAYER_NATURE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1898', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1899', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1900', 'admin', '2018-06-14 12:02:31', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1901', 'admin', '2018-06-14 12:02:31', 'DRAWBACK_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1902', 'admin', '2018-06-14 12:02:31', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1903', 'admin', '2018-06-14 12:02:31', '20', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1904', 'admin', '2018-06-14 12:02:31', 'RK_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1905', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1906', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1907', 'admin', '2018-06-14 12:02:31', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1908', 'admin', '2018-06-14 12:02:31', 'LOGISTICS_MODE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1909', 'admin', '2018-06-14 12:02:31', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1910', 'admin', '2018-06-14 12:02:31', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1911', 'admin', '2018-06-14 12:02:31', 'FOR_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1912', 'admin', '2018-06-14 12:02:31', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1913', 'admin', '2018-06-14 12:02:32', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1914', 'admin', '2018-06-14 12:02:32', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1915', 'admin', '2018-06-14 12:02:32', 'CHECKLIST_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1916', 'admin', '2018-06-14 12:02:32', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1917', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1918', 'admin', '2018-06-14 12:02:32', 'IMPORT_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1919', 'admin', '2018-06-14 12:02:32', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1920', 'admin', '2018-06-14 12:02:32', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1921', 'admin', '2018-06-14 12:02:32', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1922', 'admin', '2018-06-14 12:02:32', 'TYPE_OF_ID CERTIFICATE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1923', 'admin', '2018-06-14 12:02:32', '01', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1924', 'admin', '2018-06-14 12:02:32', '02', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1925', 'admin', '2018-06-14 12:02:32', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1926', 'admin', '2018-06-14 12:02:32', 'DECLARECOMPANY_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1927', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1928', 'admin', '2018-06-14 12:02:32', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1929', 'admin', '2018-06-14 12:02:32', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1930', 'admin', '2018-06-14 12:02:32', 'PAPER_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1931', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1932', 'admin', '2018-06-14 12:02:32', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1933', 'admin', '2018-06-14 12:02:32', 'BUYERID_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1934', 'admin', '2018-06-14 12:02:32', '08', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1935', 'admin', '2018-06-14 12:02:32', '10', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1936', 'admin', '2018-06-14 12:02:32', 'USETO_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1937', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1938', 'admin', '2018-06-14 12:02:32', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1939', 'admin', '2018-06-14 12:02:32', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1940', 'admin', '2018-06-14 12:02:32', 'APP_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1941', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1942', 'admin', '2018-06-14 12:02:32', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1943', 'admin', '2018-06-14 12:02:32', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1944', 'admin', '2018-06-14 12:02:32', 'MARK_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1945', 'admin', '2018-06-14 12:02:32', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1946', 'admin', '2018-06-14 12:02:32', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1947', 'admin', '2018-06-14 12:02:32', 'BAG_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1948', 'admin', '2018-06-14 12:04:58', 'ENT_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1949', 'admin', '2018-06-14 12:04:58', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1950', 'admin', '2018-06-14 12:04:58', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1951', 'admin', '2018-06-14 12:04:58', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1952', 'admin', '2018-06-14 12:04:58', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1953', 'admin', '2018-06-14 12:04:58', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1954', 'admin', '2018-06-14 12:04:58', 'ENT_AUDIT_STATUS', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1955', 'admin', '2018-06-14 12:04:58', '1', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1956', 'admin', '2018-06-14 12:04:58', '0', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1957', 'admin', '2018-06-14 12:04:58', '2', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1958', 'admin', '2018-06-14 12:04:58', '3', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1959', 'admin', '2018-06-14 12:04:58', 'BILL_STATE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1960', 'admin', '2018-06-14 12:05:30', 'CCF_DOCUTYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1961', 'admin', '2018-06-14 12:05:30', '00000008', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1962', 'admin', '2018-06-14 12:05:30', '00000001', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1963', 'admin', '2018-06-14 12:05:30', '00000002', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1964', 'admin', '2018-06-14 12:05:30', '00000003', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1965', 'admin', '2018-06-14 12:05:30', '00000004', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1966', 'admin', '2018-06-14 12:05:30', '00000005', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1967', 'admin', '2018-06-14 12:05:30', '00000006', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1968', 'admin', '2018-06-14 12:05:30', '00000007', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1969', 'admin', '2018-06-14 12:05:30', '00000009', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1970', 'admin', '2018-06-14 12:05:30', '10000001', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1971', 'admin', '2018-06-14 12:05:30', '10000002', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1972', 'admin', '2018-06-14 12:05:30', '10000003', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1973', 'admin', '2018-06-14 12:05:30', 'ATTACH_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1974', 'admin', '2018-06-14 12:11:47', 'D', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1975', 'admin', '2018-06-14 12:11:47', 'E', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1976', 'admin', '2018-06-14 12:11:47', 'F', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1977', 'admin', '2018-06-14 12:11:47', 'G', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1978', 'admin', '2018-06-14 12:11:47', 'H', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1979', 'admin', '2018-06-14 12:11:47', 'J', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1980', 'admin', '2018-06-14 12:11:48', 'K', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1981', 'admin', '2018-06-14 12:12:07', '4', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1982', 'admin', '2018-06-14 12:12:07', '5', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1983', 'admin', '2018-06-14 12:12:07', '6', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1984', 'admin', '2018-06-14 12:12:07', '7', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1985', 'admin', '2018-06-14 12:15:33', 'ExpertType', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1986', 'admin', '2018-06-14 12:16:35', '1', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1987', 'admin', '2018-06-14 12:17:00', 'A', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1988', 'admin', '2018-06-14 12:17:18', 'B', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1989', 'admin', '2018-06-14 12:17:33', 'C', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1990', 'admin', '2018-06-14 12:17:46', 'D', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1991', 'admin', '2018-06-14 12:18:57', 'ProjectCategory', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1992', 'admin', '2018-06-14 12:19:24', 'ProjectCategory', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1993', 'admin', '2018-06-14 12:20:01', 'A', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1994', 'admin', '2018-06-14 12:20:13', 'B', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1995', 'admin', '2018-06-14 12:20:24', 'C', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1996', 'admin', '2018-06-14 12:20:43', '03', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1997', 'admin', '2018-06-14 12:20:43', '04', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1998', 'admin', '2018-06-14 12:22:30', 'BIZ_TYPE', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('1999', 'admin', '2018-06-14 13:14:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2000', 'admin', '2018-06-14 13:23:59', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2001', 'admin', '2018-06-14 13:30:03', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2002', 'admin', '2018-06-14 13:33:17', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2003', 'admin', '2018-06-14 13:34:21', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2004', 'admin', '2018-06-14 13:37:30', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2005', 'admin', '2018-06-14 13:41:59', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2006', 'admin', '2018-06-14 13:43:16', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2007', 'admin', '2018-06-14 14:09:43', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2008', 'admin', '2018-06-14 14:14:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2009', 'admin', '2018-06-14 14:25:11', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2010', 'admin', '2018-06-14 14:30:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2011', 'admin', '2018-06-14 14:43:16', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2012', 'admin', '2018-06-14 15:39:07', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2013', 'admin', '2018-06-14 15:49:03', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2014', 'admin', '2018-06-14 16:08:12', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2015', 'admin', '2018-06-14 16:12:37', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2016', 'admin', '2018-06-14 16:19:54', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2017', 'admin', '2018-06-14 16:23:32', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2018', 'admin', '2018-06-14 16:25:40', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2019', 'admin', '2018-06-14 16:42:20', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2020', 'admin', '2018-06-14 16:56:40', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2021', 'admin', '2018-06-14 17:06:16', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2022', 'room', '2018-06-14 17:06:27', 'room', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2023', 'room1', '2018-06-14 17:06:49', 'room1', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2024', 'room2', '2018-06-14 17:07:33', 'room2', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2025', 'room3', '2018-06-14 17:08:07', 'room3', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2026', 'admin', '2018-06-14 17:16:28', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2027', 'admin', '2018-06-14 17:50:48', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2028', 'admin', '2018-06-14 18:20:27', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2029', 'admin', '2018-06-14 18:23:51', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2030', 'admin', '2018-06-14 18:25:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2031', 'admin', '2018-06-14 18:35:24', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2032', 'admin', '2018-06-15 08:59:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2033', 'admin', '2018-06-15 09:04:36', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2034', 'admin', '2018-06-15 09:28:28', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2035', 'admin', '2018-06-15 09:50:25', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2036', 'admin', '2018-06-15 10:27:27', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2037', 'admin', '2018-06-15 10:32:49', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2038', 'admin', '2018-06-15 10:46:58', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2039', 'admin', '2018-06-15 10:47:49', 'ExpertDuty', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2040', 'admin', '2018-06-15 10:48:05', 'ExpPosition', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2041', 'admin', '2018-06-15 10:48:55', 'A', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2042', 'admin', '2018-06-15 10:49:03', 'B', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2043', 'admin', '2018-06-15 10:49:14', 'C', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2044', 'admin', '2018-06-15 10:49:25', 'D', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2045', 'admin', '2018-06-15 10:49:34', 'A2', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2046', 'admin', '2018-06-15 10:49:41', 'A1', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2047', 'admin', '2018-06-15 10:49:49', 'B1', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2048', 'admin', '2018-06-15 10:49:56', 'B2', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2049', 'admin', '2018-06-15 10:50:15', 'C1', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2050', 'admin', '2018-06-15 10:50:37', '1', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2051', 'admin', '2018-06-15 10:51:29', '2', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2052', 'admin', '2018-06-15 10:51:36', '3', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2053', 'admin', '2018-06-15 10:52:22', '4', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2054', 'admin', '2018-06-15 10:53:46', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2055', 'admin', '2018-06-15 11:04:11', 'Default_Point', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2056', 'admin', '2018-06-15 11:04:33', 'DefaultPoint', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2057', 'admin', '2018-06-15 11:05:25', 'DefaultPoint', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2058', 'admin', '2018-06-15 11:05:46', 'A01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2059', 'admin', '2018-06-15 11:10:06', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2060', 'admin', '2018-06-15 11:11:02', 'A01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2061', 'admin', '2018-06-15 11:11:38', 'A02', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2062', 'admin', '2018-06-15 11:11:52', 'A021', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2063', 'admin', '2018-06-15 11:12:27', 'A020', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2064', 'admin', '2018-06-15 11:13:04', 'A022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2065', 'admin', '2018-06-15 13:06:49', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2066', 'admin', '2018-06-15 13:13:52', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2067', 'admin', '2018-06-15 13:28:28', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2068', 'admin', '2018-06-15 13:36:43', 'ExpDuty', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2069', 'admin', '2018-06-15 13:38:37', 'A031', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2070', 'admin', '2018-06-15 13:38:59', 'A032', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2071', 'admin', '2018-06-15 13:39:35', 'A021', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2072', 'admin', '2018-06-15 13:39:42', 'A022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2073', 'admin', '2018-06-15 13:39:53', 'A031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2074', 'admin', '2018-06-15 13:40:28', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2075', 'admin', '2018-06-15 13:41:02', 'A032', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2076', 'admin', '2018-06-15 13:43:03', 'A021', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2077', 'admin', '2018-06-15 13:43:08', 'A022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2078', 'admin', '2018-06-15 13:43:13', 'A031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2079', 'admin', '2018-06-15 13:43:18', 'A032', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2080', 'admin', '2018-06-15 13:43:29', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2081', 'admin', '2018-06-15 13:43:35', 'A01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2082', 'admin', '2018-06-15 13:44:55', 'DefaultPutInPoint', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2083', 'admin', '2018-06-15 13:45:29', 'DefaultProjectPoint', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2084', 'admin', '2018-06-15 13:46:23', 'B01', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2085', 'admin', '2018-06-15 13:46:33', 'B01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2086', 'admin', '2018-06-15 13:50:11', 'B021', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2087', 'admin', '2018-06-15 13:50:28', 'B022', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2088', 'admin', '2018-06-15 13:50:35', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2089', 'admin', '2018-06-15 13:50:42', 'B031', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2090', 'admin', '2018-06-15 13:50:57', 'B032', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2091', 'admin', '2018-06-15 13:54:27', 'B04', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2092', 'admin', '2018-06-15 13:54:40', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2093', 'admin', '2018-06-15 13:54:46', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2094', 'admin', '2018-06-15 14:06:24', 'B042', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2095', 'admin', '2018-06-15 14:06:42', 'B010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2096', 'admin', '2018-06-15 14:07:14', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2097', 'admin', '2018-06-15 14:31:49', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2098', 'admin', '2018-06-15 14:35:29', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2099', 'admin', '2018-06-15 14:43:52', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2100', 'admin', '2018-06-15 14:45:46', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2101', 'admin', '2018-06-15 14:57:13', 'Town', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2102', 'admin', '2018-06-15 14:58:04', 'meili', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2103', 'admin', '2018-06-17 10:09:33', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2104', 'admin', '2018-06-17 10:11:04', 'B061', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2105', 'admin', '2018-06-17 10:11:20', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2106', 'admin', '2018-06-17 10:11:27', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2107', 'admin', '2018-06-17 10:14:16', 'B062', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2108', 'admin', '2018-06-17 10:21:37', 'B071', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2109', 'admin', '2018-06-17 10:22:55', 'B072', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2110', 'admin', '2018-06-17 10:24:33', 'B073', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2111', 'admin', '2018-06-17 10:24:53', 'B080', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2112', 'admin', '2018-06-17 10:25:48', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2113', 'admin', '2018-06-17 10:26:20', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2114', 'admin', '2018-06-17 10:26:31', 'B082', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2115', 'admin', '2018-06-17 10:27:03', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2116', 'admin', '2018-06-17 10:27:21', 'B082', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2117', 'admin', '2018-06-17 10:28:59', 'B09', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2118', 'admin', '2018-06-17 10:29:07', 'B090', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2119', '项目扎口科室科员', '2018-06-18 15:03:20', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2120', '张三', '2018-06-18 15:08:54', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2121', '常熟市海虞茶叶有限公司', '2018-06-18 15:09:28', 'haiyuchaye', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2122', '常熟市海虞茶叶有限公司', '2018-06-18 15:10:18', 'haiyuchaye', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2123', '张三', '2018-06-18 15:19:30', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2124', '渔业科', '2018-06-18 15:20:25', 'yuyeke', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2125', '渔业科', '2018-06-18 15:24:58', 'yuyeke', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2126', 'admin', '2018-06-18 15:29:18', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2127', '渔业科', '2018-06-18 15:44:26', 'yuyeke', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2128', '梅李镇', '2018-06-18 15:44:56', 'meili', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2129', '梅李镇', '2018-06-18 15:46:03', 'meili', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2130', '张三', '2018-06-18 15:56:21', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2131', '张三', '2018-06-19 10:29:44', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2132', '张三', '2018-06-19 10:34:01', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2133', 'admin', '2018-06-19 10:35:38', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2134', '张三', '2018-06-19 11:17:38', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2135', '张三', '2018-06-19 12:00:51', 'Office', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2136', '张三', '2018-06-19 12:01:06', '1', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2137', '张三', '2018-06-19 12:01:23', '2', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2138', 'admin', '2018-06-19 12:33:01', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2139', 'admin', '2018-06-19 13:21:16', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2140', '张三', '2018-06-19 13:34:04', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2141', '张三', '2018-06-19 13:34:23', 'yuye', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2142', '张三', '2018-06-19 13:34:31', 'xumu', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2143', '张三', '2018-06-19 13:40:32', 'A010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2144', 'admin', '2018-06-19 14:01:26', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2145', '张三', '2018-06-19 14:06:34', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2146', '张三', '2018-06-19 14:12:53', 'yuyeke', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2147', '张三', '2018-06-19 14:12:59', 'xumuke', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2148', 'admin', '2018-06-19 15:01:09', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2149', 'admin', '2018-06-19 15:06:54', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2150', 'admin', '2018-06-19 15:08:33', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2151', 'admin', '2018-06-19 15:32:05', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2152', 'admin', '2018-06-19 15:33:53', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2153', 'admin', '2018-06-19 15:48:36', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2154', 'admin', '2018-06-19 15:54:12', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2155', 'admin', '2018-06-19 15:56:11', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2156', '张三', '2018-06-19 15:56:12', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2157', 'admin', '2018-06-19 15:56:23', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2158', 'admin', '2018-06-19 15:57:10', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2159', 'admin', '2018-06-19 16:09:20', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2160', 'admin', '2018-06-19 16:09:46', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2161', 'admin', '2018-06-19 16:16:32', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2162', 'admin', '2018-06-19 16:31:54', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2163', 'admin', '2018-06-19 16:37:47', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2164', 'admin', '2018-06-19 16:42:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2165', 'admin', '2018-06-19 16:42:45', 'AnnexType', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2166', 'admin', '2018-06-19 16:44:01', 'A01', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2167', 'admin', '2018-06-19 17:01:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2168', 'admin', '2018-06-19 17:02:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2169', 'admin', '2018-06-19 17:07:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2170', 'admin', '2018-06-19 17:09:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2171', 'admin', '2018-06-19 17:12:40', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2172', '张三', '2018-06-19 17:15:32', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2173', 'admin', '2018-06-19 17:16:27', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2174', 'admin', '2018-06-19 17:24:27', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2175', '张三', '2018-06-19 17:24:51', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2176', '张三', '2018-06-19 17:25:46', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2177', '梅李镇', '2018-06-19 17:26:24', 'meili', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2178', '梅李镇', '2018-06-19 17:29:42', 'meili', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2179', '张三', '2018-06-19 17:31:40', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2180', '张三', '2018-06-19 17:35:17', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2181', '张三', '2018-06-19 17:39:43', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2182', 'admin', '2018-06-19 17:40:17', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2183', '张三', '2018-06-19 17:40:29', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2184', '张三', '2018-06-19 17:42:25', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2185', 'admin', '2018-06-19 17:44:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2186', '张三', '2018-06-19 17:47:46', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2187', '张三', '2018-06-19 17:50:42', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2188', '张三', '2018-06-19 17:52:23', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2189', 'admin', '2018-06-19 17:53:50', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2190', '张三', '2018-06-19 17:54:14', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2191', 'admin', '2018-06-19 17:57:32', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2192', 'admin', '2018-06-19 18:01:25', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2193', '张三', '2018-06-19 18:02:51', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2194', '张三', '2018-06-19 18:04:27', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2195', 'admin', '2018-06-19 18:08:44', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2196', 'admin', '2018-06-19 18:14:05', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2197', 'admin', '2018-06-19 18:17:13', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2198', 'admin', '2018-06-19 18:21:16', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2199', 'admin', '2018-06-19 18:37:15', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2200', '张三', '2018-06-19 18:37:51', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2201', '张三', '2018-06-19 18:39:41', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2202', '张三', '2018-06-19 18:42:59', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2203', '张三', '2018-06-19 18:47:16', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2204', '张三', '2018-06-19 18:49:54', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2205', '张三', '2018-06-19 18:54:46', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2206', 'admin', '2018-06-19 18:57:53', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2207', 'admin', '2018-06-19 19:05:10', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2208', 'admin', '2018-06-19 19:12:05', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2209', 'admin', '2018-06-19 19:14:20', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2210', 'admin', '2018-06-20 08:34:32', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2211', '张三', '2018-06-20 08:37:53', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2212', '张三', '2018-06-20 08:38:59', 'B01', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2213', '张三', '2018-06-20 08:39:31', 'B01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2214', '张三', '2018-06-20 08:40:19', 'B02', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2215', '张三', '2018-06-20 08:40:52', 'B03', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2216', '张三', '2018-06-20 08:42:34', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2217', '张三', '2018-06-20 08:43:16', 'B042', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2218', '张三', '2018-06-20 08:44:01', 'B043', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2219', '张三', '2018-06-20 08:44:37', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2220', '张三', '2018-06-20 08:44:42', 'B052', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2221', '张三', '2018-06-20 08:44:47', 'B053', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2222', '张三', '2018-06-20 08:45:10', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2223', '张三', '2018-06-20 08:46:03', 'B042', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2224', '张三', '2018-06-20 08:48:25', 'B053', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2225', '张三', '2018-06-20 08:48:30', 'B052', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2226', '张三', '2018-06-20 08:48:36', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2227', '张三', '2018-06-20 08:48:42', 'B042', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2228', '张三', '2018-06-20 08:48:49', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2229', '张三', '2018-06-20 08:57:30', 'A01', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2230', '张三', '2018-06-20 08:58:16', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2231', '张三', '2018-06-20 08:58:25', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2232', '张三', '2018-06-20 08:58:30', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2233', '张三', '2018-06-20 08:59:43', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2234', '张三', '2018-06-20 09:03:44', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2235', 'admin', '2018-06-20 09:06:43', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2236', '张三', '2018-06-20 09:07:09', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2237', 'admin', '2018-06-20 09:07:59', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2238', 'admin', '2018-06-20 09:09:00', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2239', 'admin', '2018-06-20 09:09:47', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2240', '张三', '2018-06-20 09:11:09', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2241', '张三', '2018-06-20 09:16:18', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2242', 'admin', '2018-06-20 09:17:02', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2243', 'admin', '2018-06-20 09:17:13', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2244', '张三', '2018-06-20 09:21:35', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2245', 'admin', '2018-06-20 09:22:32', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2246', 'admin', '2018-06-20 09:29:34', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2247', 'admin', '2018-06-20 09:31:42', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2248', 'admin', '2018-06-20 09:33:55', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2249', 'admin', '2018-06-20 09:39:10', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2250', 'admin', '2018-06-20 09:44:28', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2251', '张三', '2018-06-20 09:44:50', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2252', '张三', '2018-06-20 09:47:46', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2253', 'admin', '2018-06-20 09:48:21', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2254', 'admin', '2018-06-20 09:49:18', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2255', '张三', '2018-06-20 09:51:33', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2256', 'admin', '2018-06-20 09:52:03', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2257', 'admin', '2018-06-20 09:53:32', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2258', 'admin', '2018-06-20 09:54:02', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2259', 'admin', '2018-06-20 10:03:49', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2260', '张三', '2018-06-20 10:05:37', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2261', 'admin', '2018-06-20 10:06:33', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2262', 'admin', '2018-06-20 10:10:41', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2263', 'admin', '2018-06-20 10:15:02', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2264', 'admin', '2018-06-20 10:32:05', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2265', '张三', '2018-06-20 10:35:03', 'B031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2266', '张三', '2018-06-20 10:35:38', 'B032', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2267', '张三', '2018-06-20 10:36:21', 'B033', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2268', '张三', '2018-06-20 10:36:59', 'B034', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2269', '张三', '2018-06-20 10:37:42', 'B042', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2270', 'admin', '2018-06-20 10:49:04', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2271', 'admin', '2018-06-20 10:56:47', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2272', 'admin', '2018-06-20 11:06:58', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2273', 'admin', '2018-06-20 11:08:39', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2274', 'admin', '2018-06-20 11:09:29', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2275', 'admin', '2018-06-20 11:13:56', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2276', 'admin', '2018-06-20 11:19:28', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2277', 'admin', '2018-06-20 12:38:14', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2278', 'admin', '2018-06-20 12:45:31', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2279', 'admin', '2018-06-20 12:50:41', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2280', 'admin', '2018-06-20 12:52:00', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2281', 'admin', '2018-06-20 12:55:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2282', '张三', '2018-06-20 12:56:55', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2283', 'admin', '2018-06-20 12:58:36', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2284', '张三', '2018-06-20 13:02:15', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2285', 'admin', '2018-06-20 13:04:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2286', 'admin', '2018-06-20 13:08:34', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2287', 'admin', '2018-06-20 13:08:51', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2288', '张三', '2018-06-20 13:12:29', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2289', '张三', '2018-06-20 13:14:10', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2290', '张三', '2018-06-20 13:21:05', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2291', 'admin', '2018-06-20 13:22:47', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2292', '张三', '2018-06-20 13:24:13', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2293', 'admin', '2018-06-20 13:30:26', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2294', '张三', '2018-06-20 13:33:48', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2295', 'admin', '2018-06-20 13:34:07', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2296', 'admin', '2018-06-20 13:34:49', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2297', 'admin', '2018-06-20 13:40:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2298', '张三', '2018-06-20 13:40:16', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2299', 'admin', '2018-06-20 13:40:49', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2300', 'admin', '2018-06-20 13:44:40', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2301', 'admin', '2018-06-20 13:47:22', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2302', '张三', '2018-06-20 13:48:21', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2303', 'admin', '2018-06-20 13:51:02', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2304', 'admin', '2018-06-20 13:52:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2305', 'admin', '2018-06-20 13:58:30', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2306', 'admin', '2018-06-20 14:01:49', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2307', 'admin', '2018-06-20 14:06:20', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2308', 'admin', '2018-06-20 14:06:24', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2309', 'admin', '2018-06-20 14:12:51', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2310', 'admin', '2018-06-20 14:15:39', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2311', 'admin', '2018-06-20 14:16:08', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2312', 'admin', '2018-06-20 14:17:50', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2313', 'admin', '2018-06-20 14:22:56', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2314', 'admin', '2018-06-20 14:23:26', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2315', 'admin', '2018-06-20 14:26:24', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2316', 'admin', '2018-06-20 14:32:14', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2317', 'admin', '2018-06-20 14:39:03', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2318', 'admin', '2018-06-20 14:39:43', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2319', 'admin', '2018-06-20 14:44:44', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2320', 'admin', '2018-06-20 14:57:03', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2321', 'admin', '2018-06-20 15:01:29', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2322', 'admin', '2018-06-20 15:02:40', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2323', 'admin', '2018-06-20 15:39:32', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2324', 'admin', '2018-06-20 15:52:11', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2325', 'admin', '2018-06-20 16:07:04', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2326', 'admin', '2018-06-20 16:09:26', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2327', 'admin', '2018-06-20 16:13:54', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2328', 'admin', '2018-06-20 16:14:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2329', 'admin', '2018-06-20 16:15:46', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2330', 'admin', '2018-06-20 16:16:56', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2331', 'admin', '2018-06-20 16:17:38', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2332', 'admin', '2018-06-20 16:17:51', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2333', 'admin', '2018-06-20 16:26:35', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2334', 'admin', '2018-06-20 17:10:43', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2335', 'admin', '2018-06-20 17:15:37', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2336', '张三', '2018-06-20 17:25:39', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2337', 'admin', '2018-06-20 17:29:33', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2338', '张三', '2018-06-20 17:46:13', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2339', '梅李镇', '2018-06-20 17:46:54', 'meili', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2340', '张三', '2018-06-20 17:52:48', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2341', 'admin', '2018-06-20 17:57:01', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2342', '张三', '2018-06-20 17:57:56', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2343', 'admin', '2018-06-20 18:01:05', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2344', 'admin', '2018-06-20 18:02:23', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2345', '常熟市海虞茶叶有限公司', '2018-06-20 18:03:02', 'haiyuchaye', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2346', '渔业科', '2018-06-20 18:04:37', 'yuyeke', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2347', 'admin', '2018-06-20 18:05:39', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2348', 'admin', '2018-06-20 18:06:35', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2349', 'admin', '2018-06-20 18:07:24', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2350', '张三', '2018-06-20 18:07:29', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2351', 'admin', '2018-06-20 18:08:19', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2352', 'admin', '2018-06-20 18:08:44', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2353', 'admin', '2018-06-20 18:09:30', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2354', 'admin', '2018-06-20 18:15:01', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2355', 'admin', '2018-06-20 18:23:15', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2356', 'admin', '2018-06-20 18:34:55', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2357', 'admin', '2018-06-20 18:38:14', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2358', 'admin', '2018-06-20 18:39:36', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2359', '常熟市海虞茶叶有限公司', '2018-06-20 18:41:21', 'haiyuchaye', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2360', '常熟市海虞茶叶有限公司', '2018-06-20 18:42:37', 'haiyuchaye', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2361', 'admin', '2018-06-20 18:43:45', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2362', 'admin', '2018-06-20 18:44:07', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2363', 'admin', '2018-06-20 18:44:33', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2364', 'admin', '2018-06-20 18:49:52', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2365', 'admin', '2018-06-20 18:51:51', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2366', 'admin', '2018-06-20 19:03:59', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2367', 'admin', '2018-06-20 19:04:09', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2368', 'admin', '2018-06-20 19:05:55', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2369', 'admin', '2018-06-20 19:06:43', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2370', 'admin', '2018-06-20 19:08:09', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2371', '张三', '2018-06-20 19:09:58', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2372', '张三', '2018-06-20 19:10:29', 'A010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2373', '张三', '2018-06-20 19:10:57', 'A011', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2374', '张三', '2018-06-20 19:18:14', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2375', '张三', '2018-06-20 19:18:22', 'B082', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2376', 'admin', '2018-06-20 19:27:33', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2377', 'admin', '2018-06-20 19:36:22', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2378', 'admin', '2018-06-21 08:44:35', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2379', '张三', '2018-06-21 09:00:55', 'zk1', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2380', 'admin', '2018-06-21 09:08:06', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2381', '张三', '2018-06-21 09:19:37', 'B010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2382', 'admin', '2018-06-21 09:19:45', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2383', '张三', '2018-06-21 09:20:14', 'B021', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2384', '张三', '2018-06-21 09:20:33', 'B022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2385', '张三', '2018-06-21 09:20:57', 'B022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2386', '张三', '2018-06-21 09:21:18', 'B031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2387', '张三', '2018-06-21 09:21:56', 'B032', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2388', '张三', '2018-06-21 09:22:49', 'B031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2389', '张三', '2018-06-21 09:23:30', 'B032', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2390', '张三', '2018-06-21 09:23:42', 'B041', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2391', '张三', '2018-06-21 09:23:56', 'B031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2392', '张三', '2018-06-21 09:25:57', 'B051', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2393', '张三', '2018-06-21 09:26:22', 'B052', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2394', '张三', '2018-06-21 09:26:41', 'B052', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2395', 'admin', '2018-06-21 09:28:11', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2396', '张三', '2018-06-21 09:28:32', 'B061', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2397', '张三', '2018-06-21 09:28:51', 'B061', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2398', '张三', '2018-06-21 09:29:03', 'B062', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2399', '张三', '2018-06-21 09:29:09', 'B062', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2400', 'admin', '2018-06-21 09:29:15', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2401', 'admin', '2018-06-21 09:31:31', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2402', 'admin', '2018-06-21 09:37:17', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2403', '张三', '2018-06-21 09:38:55', 'B071', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2404', 'admin', '2018-06-21 09:39:20', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2405', 'admin', '2018-06-21 09:39:20', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2406', '张三', '2018-06-21 09:39:29', 'B071', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2407', '张三', '2018-06-21 09:40:02', 'B072', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2408', 'admin', '2018-06-21 09:40:41', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2409', 'admin', '2018-06-21 09:40:55', 'admin', null, '0:0:0:0:0:0:0:1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2410', '张三', '2018-06-21 09:41:13', 'B080', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2411', '张三', '2018-06-21 09:42:25', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2412', '张三', '2018-06-21 09:42:37', 'B082', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2413', '张三', '2018-06-21 09:42:56', 'B090', null, '0:0:0:0:0:0:0:1', '数据字典删除', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2414', '张三', '2018-06-21 09:43:24', 'B091', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2415', '张三', '2018-06-21 09:44:06', 'B073', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2416', '张三', '2018-06-21 09:44:14', 'B074', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2417', '张三', '2018-06-21 09:44:21', 'B081', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2418', '张三', '2018-06-21 09:45:41', 'B011', null, '0:0:0:0:0:0:0:1', '数据字典新增', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2419', '张三', '2018-06-21 09:46:08', 'B010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2420', 'admin', '2018-06-21 09:46:50', 'admin', null, '127.0.0.1', '用户登录', null, null, null, 'Agricultural', '登录');
INSERT INTO `op_log` VALUES ('2421', '张三', '2018-06-21 09:47:26', 'A010', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2422', '张三', '2018-06-21 09:47:38', 'A011', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2423', '张三', '2018-06-21 09:48:08', 'A021', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2424', '张三', '2018-06-21 09:48:21', 'A022', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2425', '张三', '2018-06-21 09:48:50', 'A032', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');
INSERT INTO `op_log` VALUES ('2426', '张三', '2018-06-21 09:49:20', 'A031', null, '0:0:0:0:0:0:0:1', '数据字典修改', null, null, null, 'Agricultural', '字典管理');

-- ----------------------------
-- Table structure for projcet_accept
-- ----------------------------
DROP TABLE IF EXISTS `projcet_accept`;
CREATE TABLE `projcet_accept` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `AcceptExplain` varchar(500) DEFAULT NULL COMMENT '验收说明',
  `ProjectId` varchar(36) DEFAULT NULL COMMENT '对应项目表主键',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目验收';

-- ----------------------------
-- Records of projcet_accept
-- ----------------------------

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `ProjectName` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `FirstType` varchar(36) DEFAULT NULL COMMENT '项目类型大类',
  `SecondType` varchar(36) DEFAULT NULL COMMENT '项目类型小类',
  `ProjectClass` varchar(36) DEFAULT NULL COMMENT '项目类别（数据字典）',
  `ProjectSource` varchar(36) DEFAULT NULL COMMENT '项目来源（数据字典）',
  `DecDepartmentId` varchar(36) DEFAULT NULL COMMENT '项目单位Id',
  `DecDepartmentName` varchar(100) DEFAULT NULL COMMENT '项目单位名称',
  `IsPublic` int(11) DEFAULT NULL COMMENT '是否公开 0 不公开 1 公开',
  `TotalAmount` decimal(12,4) DEFAULT NULL COMMENT '计划总投资额（万元）',
  `CenterFund` decimal(12,4) DEFAULT NULL COMMENT '中央资金（万元）',
  `ProvinceFund` decimal(12,4) DEFAULT NULL COMMENT '省级资金（万元）',
  `SuzhouFund` decimal(12,4) DEFAULT NULL COMMENT '苏州市级资金（万元）',
  `ChangshuFund` decimal(12,4) DEFAULT NULL COMMENT '常熟市级资金（万元）',
  `SelfFund` decimal(12,4) DEFAULT NULL COMMENT '自筹资金（万元）',
  `PlaceTown` varchar(50) DEFAULT NULL COMMENT '建设地点乡镇',
  `PlaceDtl` varchar(200) DEFAULT NULL COMMENT '建设地点详情',
  `IsPutIn` int(11) DEFAULT NULL COMMENT '是否入库 0 不入库 1 入库',
  `GuideId` varchar(36) DEFAULT NULL COMMENT '申报指南编号',
  `GuideCode` varchar(36) DEFAULT NULL COMMENT '申报指南文号',
  `ProjectDescription` varchar(2000) DEFAULT NULL COMMENT '指南描述',
  `ProjectEvaluation` varchar(500) DEFAULT NULL COMMENT '项目描述',
  `ProjectSchedule` varchar(36) DEFAULT NULL COMMENT '项目进度',
  `PublicTime` datetime DEFAULT NULL COMMENT '公示日期',
  `ImpDepartment` varchar(200) DEFAULT NULL COMMENT '实施单位',
  `ImpDeadline` varchar(100) DEFAULT NULL COMMENT '实施期限',
  `ProjectState` varchar(10) DEFAULT NULL COMMENT '项目状态',
  `ProjectTown` varchar(30) DEFAULT NULL COMMENT '所属乡镇',
  `DecTownUser` varchar(36) DEFAULT NULL COMMENT '申报乡镇审批人',
  `DecTownTime` datetime DEFAULT NULL COMMENT '申报乡镇审批时间',
  `DecTownOpinion` varchar(500) DEFAULT NULL COMMENT '申报乡镇审批意见',
  `DecOfficeUser` varchar(36) DEFAULT NULL COMMENT '申报科室审批人',
  `DecOfficeTime` datetime DEFAULT NULL COMMENT '申报科室审批时间',
  `DecOfficeOpinion` varchar(500) DEFAULT NULL COMMENT '申报科室审批意见',
  `ExpertId` varchar(36) DEFAULT NULL COMMENT '评审专家',
  `ExperTime` datetime DEFAULT NULL COMMENT '评审日期',
  `ExperOpinion` varchar(500) DEFAULT NULL COMMENT '专家评审意见',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目主表';

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('111', '111', '1', '', '444', '555', '1', '1', '1', '1.0000', '1.0000', '1.0000', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2018-06-20 15:05:35', null, null);

-- ----------------------------
-- Table structure for project_build
-- ----------------------------
DROP TABLE IF EXISTS `project_build`;
CREATE TABLE `project_build` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `BuildInfo` varchar(500) DEFAULT NULL COMMENT '建设内容',
  `BuildScale` varchar(30) DEFAULT NULL COMMENT '建设规模',
  `BuildUnit` varchar(30) DEFAULT NULL COMMENT '建设单位（计量单位）',
  `BuildFrom` datetime DEFAULT NULL COMMENT '建设期限起',
  `BuildTo` datetime DEFAULT NULL COMMENT '建设期限止',
  `FnancialFund` decimal(12,4) DEFAULT NULL COMMENT '财政资金（万元）',
  `SelfFund` decimal(12,4) DEFAULT NULL COMMENT '自筹资金（万元）',
  `Remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `ProjectId` varchar(36) DEFAULT NULL COMMENT '对应项目表主键',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目建设';

-- ----------------------------
-- Records of project_build
-- ----------------------------

-- ----------------------------
-- Table structure for project_department
-- ----------------------------
DROP TABLE IF EXISTS `project_department`;
CREATE TABLE `project_department` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `Name` varchar(100) DEFAULT NULL COMMENT '单位名称',
  `UserName` varchar(100) DEFAULT NULL COMMENT '单位系统账号',
  `ProjectTown` varchar(36) DEFAULT NULL COMMENT '对应乡镇',
  `ProjectDep` varchar(36) DEFAULT NULL COMMENT '对应科室',
  `Address` varchar(300) DEFAULT NULL COMMENT '地址',
  `LegalPerson` varchar(30) DEFAULT NULL COMMENT '法人',
  `LegalPersonNumber` varchar(20) DEFAULT NULL COMMENT '法人电话',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='承接单位表';

-- ----------------------------
-- Records of project_department
-- ----------------------------
INSERT INTO `project_department` VALUES ('df8f2049-aa3b-4402-a320-7d9795b9ba8d', '名称1', 'admin', '梅岭乡', 'yuyeke', '常熟', '呵呵', '130********', 'admin', '2018-06-19 13:01:35', null, '2018-06-19 13:01:50');

-- ----------------------------
-- Table structure for project_guide
-- ----------------------------
DROP TABLE IF EXISTS `project_guide`;
CREATE TABLE `project_guide` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `GuideName` varchar(50) DEFAULT NULL COMMENT '指南名称',
  `PublicTime` datetime DEFAULT NULL COMMENT '公示日期',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目指南';

-- ----------------------------
-- Records of project_guide
-- ----------------------------

-- ----------------------------
-- Table structure for project_implement
-- ----------------------------
DROP TABLE IF EXISTS `project_implement`;
CREATE TABLE `project_implement` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `ImpPlan` varchar(500) DEFAULT NULL COMMENT '实施计划',
  `ImpTimeFrom` datetime DEFAULT NULL COMMENT '实施时间起',
  `ImpTimeTo` datetime DEFAULT NULL COMMENT '实施时间止',
  `ImpRate` decimal(12,4) DEFAULT NULL COMMENT '实施进度',
  `ImpRateTime` datetime DEFAULT NULL COMMENT '当前实施进度时间',
  `ProjectId` varchar(36) DEFAULT NULL COMMENT '对应项目表主键',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  `Column_12` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目实施';

-- ----------------------------
-- Records of project_implement
-- ----------------------------

-- ----------------------------
-- Table structure for project_implement_funds
-- ----------------------------
DROP TABLE IF EXISTS `project_implement_funds`;
CREATE TABLE `project_implement_funds` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `ImpId` varchar(36) NOT NULL COMMENT '对应实施表主键',
  `Fund` decimal(12,4) DEFAULT NULL COMMENT '拨付资金',
  `FundTime` datetime DEFAULT NULL COMMENT '拨付时间',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ImpId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目实施拨付表';

-- ----------------------------
-- Records of project_implement_funds
-- ----------------------------

-- ----------------------------
-- Table structure for project_official_type
-- ----------------------------
DROP TABLE IF EXISTS `project_official_type`;
CREATE TABLE `project_official_type` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `TypeName` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `TypeLevel` int(11) DEFAULT NULL COMMENT '类别层级 大类1 小类2 细类3',
  `ParentTypeId` varchar(36) DEFAULT '0' COMMENT '父类id',
  `TypeClass` varchar(36) DEFAULT NULL COMMENT '项目类别',
  `TypeDep` varchar(36) DEFAULT NULL COMMENT '对应科室',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='正式项目类别管理';

-- ----------------------------
-- Records of project_official_type
-- ----------------------------
INSERT INTO `project_official_type` VALUES ('0dfd210a-bc43-4864-acd7-29b3c5b9d603', '测试02', null, '1', null, null, 'admin', '2018-06-21 09:47:29', null, null);
INSERT INTO `project_official_type` VALUES ('1', '测试正式类型', '1', '0', '1', 'yuyeke', '', '2018-06-19 11:07:44', '', '2018-06-19 11:07:44');
INSERT INTO `project_official_type` VALUES ('42cc3466-0963-40bf-93bf-5091dd7025c7', '正式子项目01', null, 'c1325810-412c-49b8-aa70-fd994dc0c45b', null, null, 'admin', '2018-06-21 09:31:52', null, null);
INSERT INTO `project_official_type` VALUES ('c1325810-412c-49b8-aa70-fd994dc0c45b', '正式测试001', null, '0', '2', 'yuyeke', 'admin', '2018-06-21 09:14:51', 'admin', '2018-06-21 09:15:03');

-- ----------------------------
-- Table structure for project_publicity
-- ----------------------------
DROP TABLE IF EXISTS `project_publicity`;
CREATE TABLE `project_publicity` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `ProjectName` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `ProjectDescription` varchar(500) DEFAULT NULL COMMENT '指南描述',
  `ProjectEvaluation` varchar(500) DEFAULT NULL COMMENT '项目描述',
  `ProjectSchedule` varchar(36) DEFAULT NULL COMMENT '项目进度',
  `PublicTime` datetime DEFAULT NULL COMMENT '公示日期',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目公示';

-- ----------------------------
-- Records of project_publicity
-- ----------------------------

-- ----------------------------
-- Table structure for project_putin
-- ----------------------------
DROP TABLE IF EXISTS `project_putin`;
CREATE TABLE `project_putin` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `ProjectName` varchar(50) DEFAULT NULL COMMENT '项目名称',
  `PutInFirstType` varchar(36) DEFAULT NULL COMMENT '入库项目类型大类',
  `PutInSecondType` varchar(36) DEFAULT NULL COMMENT '入库项目类型小类',
  `PutInTypeDep` varchar(36) DEFAULT NULL COMMENT '业务对口科室',
  `ApplyDepartmentId` varchar(36) DEFAULT NULL COMMENT '申请部门',
  `ApplyDepartmentName` varchar(200) DEFAULT NULL COMMENT '申请部门',
  `TotalAmount` decimal(12,4) DEFAULT NULL COMMENT '总投资（万元）',
  `FnancialFund` decimal(12,4) DEFAULT NULL COMMENT '财政资金（万元）',
  `SelfFund` decimal(12,4) DEFAULT NULL COMMENT '自筹资金（万元）',
  `PlaceTown` varchar(50) DEFAULT NULL COMMENT '建设地点乡镇',
  `PlaceDtl` varchar(200) DEFAULT NULL COMMENT '建设地点详情',
  `BuildInfo` varchar(2000) DEFAULT NULL COMMENT '建设内容',
  `PublicTime` datetime DEFAULT NULL COMMENT '公示日期',
  `ProjectState` varchar(10) DEFAULT NULL COMMENT '项目状态',
  `ProjectTown` varchar(30) DEFAULT NULL COMMENT '所属乡镇',
  `DecTownUser` varchar(36) DEFAULT NULL COMMENT '申报乡镇审批人',
  `DecTownTime` datetime DEFAULT NULL COMMENT '申报乡镇审批时间',
  `DecTownOpinion` varchar(500) DEFAULT NULL COMMENT '申报乡镇审批意见',
  `DecOfficeUser` varchar(36) DEFAULT NULL COMMENT '申报科室审批人',
  `DecOfficeTime` datetime DEFAULT NULL COMMENT '申报科室审批时间',
  `DecOfficeOpinion` varchar(500) DEFAULT NULL COMMENT '申报科室审批意见',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目入库申报';

-- ----------------------------
-- Records of project_putin
-- ----------------------------
INSERT INTO `project_putin` VALUES ('1b6a07de-54ce-4d58-a6b0-ffe0884abb5d', '1111', '86d0c61e-4993-48e7-a7d4-024084b29010', '86d0c61e-4993-48e7-a7d4-024084b29066', 'yuyeke', null, '哈哈', '1.0000', '1.0000', '11.0000', 'meili', '1432', '234', null, 'A010', null, null, null, null, null, null, null, 'admin', '2018-06-20 18:55:29', null, null);
INSERT INTO `project_putin` VALUES ('2505ab74-de5b-4020-937c-efb385762716', '测试', '2113439a-1094-4c35-aad4-905d6994bcef', '86d0c61e-4993-48e7-a7d4-024084b29066', null, null, '1', '1.0000', '1.0000', '1.0000', 'meili', '1', '1', null, 'A010', null, null, null, null, null, null, null, 'admin', '2018-06-20 18:54:10', null, null);
INSERT INTO `project_putin` VALUES ('38278808-3dbc-4b8c-b060-6392355ef9c0', '4634', '2113439a-1094-4c35-aad4-905d6994bcef', '22415b3e-a57a-458a-98c6-b377e30e7085', 'yuyeke', null, '456', '653.0000', '3456.0000', '111111.0000', 'meili', '536', '4356', null, 'A010', 'meili', null, null, null, null, null, null, 'admin', '2018-06-20 19:06:59', 'admin', '2018-06-20 19:07:35');
INSERT INTO `project_putin` VALUES ('9a8f571f-8715-4bb4-9850-ac434882ea25', '343223', '86d0c61e-4993-48e7-a7d4-024084b29010', '86d0c61e-4993-48e7-a7d4-024084b29066', 'yuyeke', null, '23', '2342.0000', '234.0000', '234.0000', 'meili', null, '2342', null, 'A010', null, null, null, null, null, null, null, 'admin', '2018-06-20 19:04:27', null, null);

-- ----------------------------
-- Table structure for project_putin_type
-- ----------------------------
DROP TABLE IF EXISTS `project_putin_type`;
CREATE TABLE `project_putin_type` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `TypeName` varchar(50) DEFAULT NULL COMMENT '类型名称',
  `TypeLevel` int(11) DEFAULT NULL COMMENT '类别层级 大类1 小类2 细类3',
  `ParentTypeId` varchar(36) DEFAULT '0' COMMENT '父类id',
  `TypeDep` varchar(36) DEFAULT NULL COMMENT '对应科室',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目入库类别';

-- ----------------------------
-- Records of project_putin_type
-- ----------------------------
INSERT INTO `project_putin_type` VALUES ('2113439a-1094-4c35-aad4-905d6994bcef', '大类测试03', null, '0', 'yuyeke', 'admin', '2018-06-20 18:40:31', 'admin', '2018-06-20 19:12:35');
INSERT INTO `project_putin_type` VALUES ('22415b3e-a57a-458a-98c6-b377e30e7085', '小类测试2', null, '2113439a-1094-4c35-aad4-905d6994bcef', null, 'admin', '2018-06-20 19:06:48', null, null);
INSERT INTO `project_putin_type` VALUES ('86d0c61e-4993-48e7-a7d4-024084b29010', '大类测试1', null, '0', 'yuyeke', 'admin', '2018-06-20 18:40:19', null, null);

-- ----------------------------
-- Table structure for project_supervise
-- ----------------------------
DROP TABLE IF EXISTS `project_supervise`;
CREATE TABLE `project_supervise` (
  `id` varchar(36) NOT NULL COMMENT '主键',
  `SuperviseTitle` varchar(200) DEFAULT NULL COMMENT '督查标题',
  `SuperviseDescription` varchar(500) DEFAULT NULL COMMENT '督查说明',
  `SuperviseType` varchar(36) DEFAULT NULL COMMENT '督查类型，日常督查和中期督查',
  `ProjectId` varchar(36) DEFAULT NULL COMMENT '对应项目表主键',
  `CreateUser` varchar(36) DEFAULT NULL COMMENT '创建者',
  `CreateTime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `ModifyUser` varchar(36) DEFAULT NULL COMMENT '修改者',
  `ModifyTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='项目督查';

-- ----------------------------
-- Records of project_supervise
-- ----------------------------
