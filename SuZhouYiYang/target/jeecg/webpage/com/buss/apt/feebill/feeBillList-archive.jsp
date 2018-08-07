<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="feeBillList" checkbox="true" fitColumns="true" title="收费单" actionUrl="${dataurl}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费单编号"  field="no"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="费用单名称"  field="name"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="顾客姓名"  field="customerName"  query="true"  queryMode="single"  dictionary="customer_base,customerNo,customerName,no,name"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="费用小计"  field="totalFee"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="属于"  field="belongTo"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="收费部门"  field="belongDept"  queryMode="single"  dictionary="t_s_depart,org_code,departname"  width="120"></t:dgCol>
   <t:dgCol title="单据状态"  field="fbStatus"  queryMode="single"  dictionary="sf_status"  width="120"></t:dgCol>
   <t:dgCol title="收费人"  field="charger"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="收费时间"  field="dealDate"  formatter="yyyy-MM-dd"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核人"  field="auditor"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核时间"  field="auditorDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="审核内容"  field="auditorDes"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务类型"  field="feeOriginType"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="业务ID"  field="feeOriginId"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="feeBillController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="feeBillController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="feeBillController.do?goUpdate" funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="feeBillController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="feeBillController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="归档" icon="icon-le-ok"  url="feeBillController.do?doArchive" funname="doArchive"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/apt/feebill/feeBillList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-归档
 	function doArchive(title,url,id){
 		var rowData = $('#'+id).datagrid('getSelected');
		if (!rowData) {
			tip('请选择归档项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再编辑');
            return;
        }
        if("4"!=rowsData[0]['fbStatus'].toString()){
            tip('只有已收状态的信息才可以修改！');
            return;
        }
		url = url+"&id="+rowData[0]['id'];
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
        if("1"!=rowsData[0]['fbStatus'].toString()){
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
                if("1"!=rows[i].fbStatus){
                    tip("只有待提交状态的信息才可以删除！");
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
	openuploadwin('Excel导入', 'feeBillController.do?upload', "feeBillList");
}

//导出
function ExportXls() {
	JeecgExcelExport("feeBillController.do?exportXls","feeBillList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("feeBillController.do?exportXlsByT","feeBillList");
}
 </script>