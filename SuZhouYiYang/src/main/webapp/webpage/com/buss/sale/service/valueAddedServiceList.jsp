<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="valueAddedServiceList" checkbox="true" fitColumns="true" title="增值服务" actionUrl="${dataurl}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务编号"  field="serviceId"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间号"  field="customerRoomName"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位号"  field="customerBedName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="服务类型"  field="serviceType"  queryMode="single"  dictionary="zz_status"  width="120"></t:dgCol>
   <t:dgCol title="服务说明"  field="serviceDetail"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remark"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客ID"  field="customerId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间ID"  field="customerRoomId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位ID"  field="customerBedId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属"  field="belongTo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="状态"  field="status"  queryMode="single"  dictionary="vs_status"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="valueAddedServiceController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="valueAddedServiceController.do?goAdd&type=${type}" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="valueAddedServiceController.do?goUpdate&type=${type}" funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="valueAddedServiceController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="valueAddedServiceController.do?goUpdate&type=${type}" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="valueAddedServiceController.do?doCommit" funname="doCommit" ></t:dgToolBar>
   <t:dgToolBar title="完成" icon="icon-le-ok"  url="valueAddedServiceController.do?doComplete" funname="doComplete" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sale/service/valueAddedServiceList.js"></script>		
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
        if("1"!=rowsData[0]['status'].toString()){
            tip('只有待提交状态的信息才可以修改！');
            return;
        }
		url = url+"&id="+rowsData['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-完成
 	function doComplete(title,url,id){
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择完成项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再编辑');
            return;
        }
        if("3"!=rowsData[0]['status'].toString()){
            tip('只有办理中状态的信息才可以修改！');
            return;
        }
		url = url+"&id="+rowsData['id'];
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
        if("1"!=rowsData[0]['status'].toString()){
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
                if("1"==rows[i].status){
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
	openuploadwin('Excel导入', 'valueAddedServiceController.do?upload', "valueAddedServiceList");
}

//导出
function ExportXls() {
	JeecgExcelExport("valueAddedServiceController.do?exportXls","valueAddedServiceList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("valueAddedServiceController.do?exportXlsByT","valueAddedServiceList");
}
 </script>