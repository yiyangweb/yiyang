<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="propertyManageList" checkbox="false" pagination="true" fitColumns="true" title="物业管理" actionUrl="propertyManageController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长者ID"  field="customerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="长者姓名"  field="customerName"  query="true"  queryMode="single"  dictionary="customer_room_info,customerName,customer_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="房间ID"  field="roomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间编号"  field="roomNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="keeper"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="负责人电话"  field="keeperTel"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="维修人"  field="repairman"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="维修人电话"  field="repairmanTel"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="流程状态"  field="status"  query="true"  queryMode="single"  dictionary="wy_status"  width="120"></t:dgCol>
   <t:dgCol title="维修项目"  field="detail"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用"  field="charge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="开始时间"  field="startTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="完成时间"  field="finishTime"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="propertyManageController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="propertyManageController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="propertyManageController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="propertyManageController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="propertyManageController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/property/propertyManageList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'propertyManageController.do?upload', "propertyManageList");
}

//导出
function ExportXls() {
	JeecgExcelExport("propertyManageController.do?exportXls","propertyManageList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("propertyManageController.do?exportXlsByT","propertyManageList");
}

 </script>