<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerLeaveNurseList" checkbox="true" fitColumns="true" title="退住申请" actionUrl="customerLeaveNurseController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退住编号"  field="no"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住id"  field="stayinId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间"  field="roomName"  query="true"  queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="床位id"  field="bedId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位"  field="bedName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退住状态"  field="leaveStatus"  query="true"  queryMode="single"  dictionary="tz_status"  width="120"></t:dgCol>
   <t:dgCol title="办理人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="办理日期"  field="dealDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="auditor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核日期"  field="auditDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核详情"  field="auditDes"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="customerLeaveNurseController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerLeaveNurseController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerLeaveNurseController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerLeaveNurseController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   	<t:dgToolBar title="提交" icon="icon-commit"  url="customerLeaveNurseController.do?doLeave_sbt" funname="doLeave_sbt" ></t:dgToolBar>
   	<t:dgToolBar title="同意" icon="icon-le-ok"  url="customerLeaveNurseController.do?doLeave_pass" funname="doLeave_pass" ></t:dgToolBar>
   	<t:dgToolBar title="不同意" icon="icon-le-no"  url="customerLeaveNurseController.do?doLeave_no" funname="doLeave_no" ></t:dgToolBar>
   	<t:dgToolBar title="确认退住" icon="icon-text"  url="customerLeaveNurseController.do?doLeave_confirm" funname="doLeave_confirm" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/nh/leave/customerLeaveNurseList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-提交
 	function doLeave_sbt(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择提交项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-同意
 	function doLeave_pass(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择同意项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-不同意
 	function doLeave_no(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择不同意项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-确认退住
 	function doLeave_confirm(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择确认退住项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerLeaveNurseController.do?upload', "customerLeaveNurseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerLeaveNurseController.do?exportXls","customerLeaveNurseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerLeaveNurseController.do?exportXlsByT","customerLeaveNurseList");
}
 </script>