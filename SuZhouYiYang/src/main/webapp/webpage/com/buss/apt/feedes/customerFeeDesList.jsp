<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerFeeDesList" checkbox="false" pagination="true" fitColumns="true" title="费用详细" actionUrl="customerFeeDesController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费编号"  field="chargeNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费项目"  field="chargeName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用"  field="fee"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="属于"  field="belongTo"  hidden="true"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="收费部门"  field="belongDept"  queryMode="single"  dictionary="t_s_depart,org_code,departname"  width="120"></t:dgCol>
   <t:dgCol title="费用状态"  field="fdStatus"  query="true"  queryMode="single"  dictionary="sf_status"  width="120"></t:dgCol>
   <t:dgCol title="收费说明"  field="feeDes"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费日期"  field="feeDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费来源id"  field="feeOriginId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="计费人"  field="countPerson"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="生成时间"  field="countDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费人"  field="charger"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费日期"  field="chargeDate"  formatter="yyyy-MM-dd hh:mm:ss"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费单id"  field="feeBillId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerFeeDesController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="customerFeeDesController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerFeeDesController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerFeeDesController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerFeeDesController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/feedes/customerFeeDesList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerFeeDesController.do?upload', "customerFeeDesList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerFeeDesController.do?exportXls","customerFeeDesList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerFeeDesController.do?exportXlsByT","customerFeeDesList");
}

 </script>