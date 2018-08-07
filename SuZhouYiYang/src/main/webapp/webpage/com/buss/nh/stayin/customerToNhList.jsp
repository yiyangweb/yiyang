<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerToNhList" checkbox="true" pagination="true" fitColumns="true" title="护理院入住" actionUrl="customerToNhController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住编号"  field="no"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客id"  field="customerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"   width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="roomName" query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位"  field="bedName"   queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客性别"  field="sex"  query="true"  queryMode="single"  dictionary="sex"  width="120"></t:dgCol>
   <t:dgCol title="合同编号"  field="contractNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="护理等级"  field="nurseLevel"  query="true"  queryMode="single"  dictionary="nurse_level_info,id,name"  width="120"></t:dgCol>
   <t:dgCol title="楼栋id"  field="buildingId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼栋"  field="buildingName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位id"  field="bedId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住状态"  field="crStatus"  queryMode="single"  dictionary="cr_status"  width="120"></t:dgCol>
   <t:dgCol title="入住经办人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住时间"  field="inDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="customerToNhController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerToNhController.do?goUpdate" funname="reUpdate"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerToNhController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerToNhController.do?doIn_sbt" funname="doIn_sbt" ></t:dgToolBar>
   <t:dgToolBar title="确认入住" icon="icon-commit"  url="customerToNhController.do?doIn_commit" funname="doIn_commit" ></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerToNhController.do?goUpdate"  funname="detail" width="100%" height="100%"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/nh/stayin/customerToNhList.js"></script>		
 <script type="text/javascript">
 $(document).ready(function(){
 });
 function reUpdate(title,url, id,width,height,isRestful) {
     gridname=id;
     var rowsData = $('#'+id).datagrid('getSelections');
     if (!rowsData || rowsData.length==0) {
         tip('请选择编辑项目');
         return;
     }

     if (rowsData.length>1) {
         tip('请选择一条记录再编辑');
         return;
     }
     if("1"!=rowsData[0].crStatus){
         tip('只有草稿状态的信息才可以修改！');
         return;
     }
     if(isRestful!='undefined'&&isRestful){
         url += '/'+rowsData[0].id;
     }else{
         url += '&id='+rowsData[0].id;
     }
     createwindow(title,url,width,height);
 }

 /**
  * 多记录刪除請求
  * @param title
  * @param url
  * @param gname
  * @return
  */
 function reDeleteALLSelect(title,url,gname) {
     gridname=gname;
     var ids = [];
     var rows = $("#"+gname).datagrid('getSelections');
     if (rows.length > 0) {
         for ( var i = 0; i < rows.length; i++) {
             if("2"==rows[i].crStatus||"3"==rows[i].crStatus){
                 tip("只有草稿的信息才可以删除！");
                 return;
             }
         }

         $.dialog.setting.zIndex = getzIndex(true);
         $.dialog.confirm('你确定永久删除该数据吗?', function(r) {
             if (r) {
                 for ( var i = 0; i < rows.length; i++) {
                     ids.push(rows[i].id);
                 }
                 $.ajax({
                     url : url,
                     type : 'post',
                     data : {
                         ids : ids.join(',')
                     },
                     cache : false,
                     success : function(data) {
                         var d = $.parseJSON(data);
                         if (d.success) {
                             var msg = d.msg;
                             tip(msg);
                             reloadTable();
                             $("#"+gname).datagrid('unselectAll');
                             ids='';
                         }
                     }
                 });
             }
         });
     } else {
         tip("请选择需要删除的数据");
     }
 }



     	//自定义按钮-提交
	 	function doIn_sbt(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择提交项目');
				return;
			}
            if(("2"==rowData['crStatus'])||("3"==rowData['crStatus'])){
                tip('只有草稿状态的单证才需要提交！');
                return;
            }
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
     	//自定义按钮-确认入住
	 	function doIn_commit(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择确认入住项目');
				return;
			}
            if(("2"!=rowData['crStatus'])){
                tip('只有入住中的信息才可以操作！');
                return;
            }
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}

 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerToNhController.do?upload', "customerToNhList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerToNhController.do?exportXls","customerToNhList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerToNhController.do?exportXlsByT","customerToNhList");
}

 </script>