<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="mmVisitorRecordList" checkbox="true" fitColumns="true" title="来访者登记信息" actionUrl="mmVisitorRecordController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="来访编号"  field="recordNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="customerName"  query="true"  queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="客户编号"  field="customerNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex"  query="true"  queryMode="single"  dictionary="c_sex"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系方式"  field="phoneNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="联系地址"  field="adress"  hidden="true"  queryMode="single"  width="300"></t:dgCol>
   <t:dgCol title="获知渠道"  field="learnChannel"  hidden="true"  queryMode="single"  dictionary="learn_type"  width="120"></t:dgCol>
   <t:dgCol title="介绍人"  field="introducer"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="需求类型"  field="requirementType"  hidden="true"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="意向等级"  field="intentionLevel"  query="true"  queryMode="single"  dictionary="yx_level"  width="120"></t:dgCol>
   <t:dgCol title="意向金"  field="intentionalGold"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="来访状态"  field="visitStatus"  queryMode="single"  dictionary="lf_status"  width="120"></t:dgCol>
   <t:dgCol title="来访次数"  field="visitNum"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="健康状况"  field="health"  hidden="true"  queryMode="single"  dictionary="jk_status"  width="120"></t:dgCol>
   <t:dgCol title="关注点"  field="focus"  hidden="true"  queryMode="single"  dictionary="focus_type"  width="120"></t:dgCol>
   <t:dgCol title="其他"  field="others"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="兴趣爱好"  field="interests"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="特殊要求"  field="specialRequirements"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务接待"  field="destClerk"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="登记日期"  field="vsitDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="mmVisitorRecordController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>
   <t:dgToolBar title="录入" icon="icon-add" url="mmVisitorRecordController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="mmVisitorRecordController.do?goUpdate" funname="update" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="mmVisitorRecordController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="mmVisitorRecordController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="确认提交" icon="icon-le-ok"  url="mmVisitorRecordController.do?doVisitsbt" funname="doVisitsbt" ></t:dgToolBar>
   <t:dgToolBar title="确认入住" icon="icon-put"  url="mmVisitorRecordController.do?doVisitput" funname="doVisitput" ></t:dgToolBar>
   <t:dgToolBar title="确认放弃" icon="icon-putout"  url="mmVisitorRecordController.do?doVisitputout" funname="doVisitputout" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sale/visit/mmVisitorRecordList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-确认提交
 	function doVisitsbt(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择确认提交项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-确认入住
 	function doVisitput(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择确认入住项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-确认放弃
 	function doVisitputout(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择确认放弃项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'mmVisitorRecordController.do?upload', "mmVisitorRecordList");
}

//导出
function ExportXls() {
	JeecgExcelExport("mmVisitorRecordController.do?exportXls","mmVisitorRecordList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("mmVisitorRecordController.do?exportXlsByT","mmVisitorRecordList");
}
 </script>