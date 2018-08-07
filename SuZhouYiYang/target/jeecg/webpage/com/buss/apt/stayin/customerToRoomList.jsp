<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerToRoomList" checkbox="true" fitColumns="true" title="入住管理" actionUrl="customerToRoomController.do?datagrid" idField="id" fit="true" queryMode="group">
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
   <t:dgCol title="合同编号"  field="contractNo"  queryMode="single"  dictionary="contract_info,customerId,customerName,customerNo,contractNo,buildingId,buildingName,roomId,roomName,customer_id,customer_name,customer_no,contract_no,building_id,building_name,room_id,room_name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="顾客id"  field="customerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼栋id"  field="buildingId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼栋名称"  field="buildingName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="roomName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="检查清单"  field="checkInfo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住状态"  field="crStatus"  queryMode="single"  dictionary="cr_status"  width="120"></t:dgCol>
   <t:dgCol title="培训状态"  field="trainStatus"  queryMode="single"  dictionary="px_status"  width="120"></t:dgCol>
   <t:dgCol title="入住类型"  field="stayinType"  queryMode="single"  dictionary="si_type"  width="120"></t:dgCol>
   <t:dgCol title="入住经办人"  field="inCharge"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="入住时间"  field="inDate"  formatter="yyyy-MM-dd hh:mm:ss"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerToRoomController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="customerToRoomController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerToRoomController.do?goUpdate" funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerToRoomController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerToRoomController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerToRoomController.do?doCommit" funname="doCommit" ></t:dgToolBar>
   <t:dgToolBar title="确认入住" icon="icon-le-ok"  url="customerToRoomController.do?doConfirm" funname="doConfirm" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/stayin/customerToRoomList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-提交
 	function doCommit(title,url,id){
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择提交项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再编辑');
            return;
        }
        if("1"!=rowsData[0]['crStatus'].toString()){
            tip('只有待提交状态的信息才可以修改！');
            return;
        }
		url = url+"&id="+rowsData[0]['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-确认入住
 	function doConfirm(title,url,id){
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择确认入住项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再编辑');
            return;
        }
        if("2"!=rowsData[0]['crStatus'].toString()){
            tip('只有待提交状态的信息才可以修改！');
            return;
        }
		url = url+"&id="+rowsData[0]['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
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
        if("1"!=rowsData[0]['crStatus'].toString()){
            tip('只有待提交状态的信息才可以修改！');
            return;
        }
        if(isRestful!='undefined'&&isRestful){
            url += '/'+rowsData[0].id;
        }else{
            url += '&id='+rowsData[0].id;
        }
        createwindow(title,url,width,height);
    }
    function reDeleteALLSelect(title,url,gname) {
        gridname=gname;
        var ids = [];
        var rows = $("#"+gname).datagrid('getSelections');
        if (rows.length > 0) {
            for ( var i = 0; i < rows.length; i++) {
                if("1"!=rows[i].crStatus){
                    tip("只有草稿状态的信息才可以删除！");
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
//导入
function ImportXls() {
	openuploadwin('Excel导入', 'customerToRoomController.do?upload', "customerToRoomList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerToRoomController.do?exportXls","customerToRoomList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerToRoomController.do?exportXlsByT","customerToRoomList");
}
 </script>