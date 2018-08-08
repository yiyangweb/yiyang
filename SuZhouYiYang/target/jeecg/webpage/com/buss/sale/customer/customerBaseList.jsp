<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerBaseList" checkbox="true" fitColumns="true" title="客户信息" actionUrl="${dataurl}" idField="id" fit="true" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建人登录名称"  field="createBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新人登录名称"  field="updateBy"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户编号"  field="no"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户姓名"  field="name"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="身份证号"  field="idCardNo"  query="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="客户状态"  field="customerStatus" queryMode="single"  dictionary="kh_status"  width="120"></t:dgCol>
   <t:dgCol title="性别"  field="sex" query="true" queryMode="single"  dictionary="c_sex"  width="120"></t:dgCol>
   <t:dgCol title="年龄"  field="age"  query="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="客户从属"  field="belongTo"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerBaseController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="customerBaseController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerBaseController.do?goUpdate" funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerBaseController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerBaseController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerBaseController.do?doCustomersbt" funname="doCustomersbt" ></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sale/customer/customerBaseList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-确认提交
 	function doCustomersbt(title,url,id){
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择确认提交项目');
			return;
		}
        if("1"!=rowsData[0]['customerStatus'].toString()){
            tip('只有待提交状态的信息才可以提交！');
            return;
        }
		url = url+"&id="+rowsData[0]['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
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
        if("1"!=rowsData[0]['customerStatus'].toString()){
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
                if("1"!=rows[i].customerStatus){
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
	openuploadwin('Excel导入', 'customerBaseController.do?upload', "customerBaseList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerBaseController.do?exportXls","customerBaseList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerBaseController.do?exportXlsByT","customerBaseList");
}
 </script>