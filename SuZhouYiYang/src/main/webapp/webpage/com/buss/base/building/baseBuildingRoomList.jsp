<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="baseBuildingRoomList" checkbox="true" fitColumns="true" sortName="no" title="建筑物房间信息" actionUrl="baseBuildingRoomController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="建筑名称"  field="baseBuildingId"  query="true"  queryMode="single"  dictionary="base_building,id,name"  width="120"></t:dgCol>
   <t:dgCol title="楼层名称"  field="baseBuildingStoreyId"  queryMode="single"  dictionary="base_building_storey,id,name"  width="120"></t:dgCol>
   <t:dgCol title="房间类型"  field="baseBuildingRoomTypeId"  queryMode="single"  dictionary="base_building_room_type,id,name"  width="120"></t:dgCol>
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间编号"  field="no"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="name"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="管理员"  field="manager"  queryMode="single"  dictionary="t_s_base_user,id,realname"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="keeper"  queryMode="single"  dictionary="t_s_base_user,id,realname"  width="120"></t:dgCol>
   <t:dgCol title="房间状态"  field="status"  query="true"  queryMode="single"  dictionary="rom_status"  width="120"></t:dgCol>
   <t:dgCol title="房间信息描述"  field="description"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="类型"  field="belongTo"  query="true"  queryMode="single"  dictionary="build_type"  width="120"></t:dgCol>
   <t:dgCol title="启用标记"  field="enabled"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核标记"  field="approved"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="删除标记"  field="deleted"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属区域"  field="baseBuildingAreaId"  queryMode="group"  dictionary="base_building_area,id,name"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="baseBuildingRoomController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="baseBuildingRoomController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="baseBuildingRoomController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="baseBuildingRoomController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="baseBuildingRoomController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/base/building/baseBuildingRoomList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'baseBuildingRoomController.do?upload', "baseBuildingRoomList");
}

//导出
function ExportXls() {
	JeecgExcelExport("baseBuildingRoomController.do?exportXls","baseBuildingRoomList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("baseBuildingRoomController.do?exportXlsByT","baseBuildingRoomList");
}
 </script>