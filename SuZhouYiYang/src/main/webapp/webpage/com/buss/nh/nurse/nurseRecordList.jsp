<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="nurseRecordList" checkbox="true" pagination="true" fitColumns="true" title="护理记录" actionUrl="nurseRecordController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床号"  field="bedId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间"  field="roomName"  queryMode="single" query="true" width="120"></t:dgCol>
   <t:dgCol title="床位"  field="bedName"  hidden="true"    queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="护士"  field="charger"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="记录日期"  field="recordDate"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="记录状态"  field="jlStatus"  queryMode="single"  dictionary="cg_status"  width="120"></t:dgCol>
   <t:dgCol title="血压"  field="bloodPressure"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="脉搏"  field="pulse"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="体温"  field="animalHeat"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="呼吸"  field="breath"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否吸氧"  field="isOxygen"  hidden="true"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="口服药"  field="takeMedicine"  hidden="true"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="心理护理"  field="mentalHelp"  hidden="true"  queryMode="single"  dictionary="sf_yn"  width="120"></t:dgCol>
   <t:dgCol title="交班事项"  field="handoverDes"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="attachment"  hidden="true"  queryMode="single"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="nurseRecordController.do?goAdd" funname="add"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="nurseRecordController.do?goUpdate" funname="reUpdate"></t:dgToolBar>
   <t:dgToolBar title="确认" icon="icon-commit"  url="nurseRecordController.do?doNurse_sbt" funname="doNurse_sbt" ></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="nurseRecordController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="nurseRecordController.do?goUpdate" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导入" icon="icon-put" funname="ImportXls"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
   <t:dgToolBar title="模板下载" icon="icon-putout" funname="ExportXlsByT"></t:dgToolBar>

  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/nh/nurse/nurseRecordList.js"></script>		
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
     if("1"!=rowsData[0].jlStatus){
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
             if("2"==rows[i].jlStatus){
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

     	//自定义按钮-确认
	 	function doNurse_sbt(title,url,gridname){
	 		var rowData = $('#'+gridname).datagrid('getSelected');
			if (!rowData) {
				tip('请选择确认项目');
				return;
			}
            if("2"==rowData['jlStatus']){
                tip('只有草稿状态的单证才需要确认！');
                return;
            }
			url = url+"&id="+rowData['id'];
	 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
	 	}
   
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'nurseRecordController.do?upload', "nurseRecordList");
}

//导出
function ExportXls() {
	JeecgExcelExport("nurseRecordController.do?exportXls","nurseRecordList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("nurseRecordController.do?exportXlsByT","nurseRecordList");
}

 </script>