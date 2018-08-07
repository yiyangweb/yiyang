<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerOutRoomList" checkbox="true" fitColumns="true" title="退房管理" actionUrl="customerOutRoomController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退房编号"  field="no"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住id"  field="stayinId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="roomName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客名称"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="退房状态"  field="outStatus"  queryMode="single" query="true" dictionary="tf_status"  width="120"></t:dgCol>
   <t:dgCol title="检查清单"  field="checkInfo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="是否换房"  field="isChange"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="办理人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="办理日期"  field="dealDate"  formatter="yyyy-MM-dd"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="auditor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核日期"  field="auditDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核详情"  field="auditDes"  queryMode="single"  width="120"></t:dgCol>
   <t:dgToolBar title="录入" icon="icon-add" url="customerOutRoomController.do?goAdd"  funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerOutRoomController.do?goUpdate"  funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerOutRoomController.do?doOut_put" funname="doOut_put" ></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerOutRoomController.do?doBatchDel"  funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerOutRoomController.do?goUpdate"  funname="detail" width="100%" height="100%"></t:dgToolBar>

  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/stayout/customerOutRoomList.js"></script>		
 <script type="text/javascript">
     /**
      * 重写更新事件打开窗口
      * @param title 编辑框标题
      * @param url//目标页面地址
      * @param id//主键字段
      */

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
         if("2"==rowsData[0].outStatus||"3"==rowsData[0].outStatus){
             tip('只有草稿和退回状态的信息才可以修改！');
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
                 if("2"==rows[i].outStatus||"3"==rows[i].outStatus){
                     tip("只有草稿和退回状态的信息才可以删除！");
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
 	//自定义按钮-sql增强-提交
 	function doOut_put(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择提交项目');
			return;
		}
        if(("2"==rowData['outStatus'])||("3"==rowData['outStatus'])){
            tip('只有草稿和退回状态的单证才需要提交！');
            return;
        }
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-同意退房
 	function doOut_pass(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择同意退房项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-退回
 	function doOut_return(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择退回项目');
			return;
		}
		url = url+"&id="+rowData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerOutRoomController.do?upload', "customerOutRoomList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerOutRoomController.do?exportXls","customerOutRoomList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerOutRoomController.do?exportXlsByT","customerOutRoomList");
}
 </script>