<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="valueAddedServiceTypeList" checkbox="true" pagination="true" fitColumns="true" title="增值服务类型" actionUrl="valueAddedServiceTypeController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="ID"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="增值服务编号"  field="no"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="增值服务名称"  field="name"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="增值服务说明"  field="description"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="增值服务从属"  field="beloneTo"  queryMode="group"  dictionary="build_type"  width="120"></t:dgCol>
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
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="valueAddedServiceTypeController.do?doDel&id={id}" urlclass="ace_button"  urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="valueAddedServiceTypeController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="valueAddedServiceTypeController.do?goUpdate" funname="update"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="valueAddedServiceTypeController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="valueAddedServiceTypeController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/base/contract/valueAddedServiceTypeList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'valueAddedServiceTypeController.do?upload', "valueAddedServiceTypeList");
}

//导出
function ExportXls() {
	JeecgExcelExport("valueAddedServiceTypeController.do?exportXls","valueAddedServiceTypeList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("valueAddedServiceTypeController.do?exportXlsByT","valueAddedServiceTypeList");
}

 </script>