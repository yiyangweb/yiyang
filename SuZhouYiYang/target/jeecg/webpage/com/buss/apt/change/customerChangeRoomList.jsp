<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerChangeRoomList" checkbox="true" fitColumns="true" title="换房管理" actionUrl="customerChangeRoomController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="换房编号"  field="no"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住id"  field="originId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  queryMode="single"  dictionary="stayin_info,originId,customerName,originRoomId,originRoom,originBuildingId,originBuildingName,id,customer_name,room_id,room_name,building_id,building_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="原房间id"  field="originRoomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原房间"  field="originRoom"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原楼栋id"  field="originBuildingId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="原楼栋"  field="originBuildingName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交换房间id"  field="newRoomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交换房间"  field="newRoomName"  queryMode="single"  dictionary="empty_room_info,newRoomId,newRoomName,newBuildingId,newBuildingName,room_id,room_name,building_id,building_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="交换楼栋id"  field="newBuildingId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="交换楼栋"  field="newBuildingName"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="换房状态"  field="status"  queryMode="single"  dictionary="hf_status"  width="120"></t:dgCol>
   <t:dgCol title="办理人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="办理时间"  field="dealDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="auditor"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核时间"  field="auditDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核意见"  field="auditDes"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属"  field="belongTo"  hidden="true"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerChangeRoomController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="customerChangeRoomController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerChangeRoomController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerChangeRoomController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerChangeRoomController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <%--<t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>--%>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerChangeRoomController.do?doCommit" funname="doCommit" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/change/customerChangeRoomList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-提交
 	function doCommit(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择提交项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerChangeRoomController.do?upload', "customerChangeRoomList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerChangeRoomController.do?exportXls","customerChangeRoomList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerChangeRoomController.do?exportXlsByT","customerChangeRoomList");
}
 </script>