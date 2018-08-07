<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerToHotelList" checkbox="true" fitColumns="true" title="酒店管理" actionUrl="customerToHotelController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住编号"  field="no"  queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  queryMode="single" query="true" dictionary="customer_base_pop,name,customerName"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  queryMode="single"  dictionary="sex"  width="120"></t:dgCol>
   <t:dgCol title="顾客id"  field="customerId"  hidden="true"  queryMode="single"  dictionary="customer_base,id,name"  width="120"></t:dgCol>
   <t:dgCol title="楼栋名称"  field="buildingId"  queryMode="single"  dictionary="base_building,id,name"  width="120"></t:dgCol>
   <t:dgCol title="入住状态"  field="crStatus"  queryMode="single"  dictionary="jd_status"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="roomId"  queryMode="single"  dictionary="base_building_room,id,name"  width="120"></t:dgCol>
   <t:dgCol title="入住经办人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住时间"  field="inDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退住经办人"  field="outCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退房时间"  field="outDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerToHotelController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="customerToHotelController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerToHotelController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerToHotelController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerToHotelController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sale/hotel/customerToHotelList.js"></script>		
 <script type="text/javascript">
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerToHotelController.do?upload', "customerToHotelList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerToHotelController.do?exportXls","customerToHotelList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerToHotelController.do?exportXlsByT","customerToHotelList");
}
 </script>