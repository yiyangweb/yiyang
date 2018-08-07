<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:0px;border:0px">
  <t:datagrid name="customerContractNhList" checkbox="true" fitColumns="true" title="签订合同记录" actionUrl="customerContractNhController.do?datagrid" idField="id" fit="true" queryMode="group">
   <t:dgCol title="id"  field="id"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人名称"  field="createName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建人登陆名称"  field="createBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="创建日期"  field="createDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人名称"  field="updateName"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新人登陆名称"  field="updateBy"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="更新日期"  field="updateDate"  formatter="yyyy-MM-dd"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属部门"  field="sysOrgCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="所属公司"  field="sysCompanyCode"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="顾客id"  field="customerId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="顾客名称"  field="customerName"  query="true"  queryMode="single" width="120"></t:dgCol>
   <t:dgCol title="顾客编号"  field="customerNo"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同编号"  field="no"  query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="所属"  field="belongTo"  queryMode="single"  dictionary="cs_status"  width="120"></t:dgCol>
   <t:dgCol title="生效日期"  field="beginDate"  hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="截止日期"  field="endDate"  hidden="true" formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="签订日期"  field="signDate"  formatter="yyyy-MM-dd"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="付款进度"  field="paymentStatus" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="enabled"  field="enabled"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="approved"  field="approved"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="deleted"  field="deleted"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="负责人"  field="charger"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="楼栋id"  field="buildingId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="房间id"  field="roomId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="床位id"  field="bedId"  hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="楼栋名称"  field="buildingName" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="房间名称"  field="roomName" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位名称"  field="bedName" query="true" queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="床位费"  field="unitPrice"  hidden="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="护理等级"  field="nurseLevel"  queryMode="group"  dictionary="nurse_level_info,nurseLevel,nurseCharge,name,charge_standard"  popup="true"  width="120"></t:dgCol>
   <t:dgCol title="护理费"  field="nurseCharge" hidden="true"  queryMode="single"  width="120"></t:dgCol>
   <t:dgCol title="合同状态"  field="contractStatus" queryMode="single"  dictionary="ht_status"  width="120"></t:dgCol>
   <t:dgCol title="附件"  field="attach" hidden="true"  queryMode="group"  downloadName="附件下载"  width="120"></t:dgCol>
   <t:dgCol title="是否包房"  field="isChartered" hidden="true"  queryMode="group"  width="120"></t:dgCol>
   <%--<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="customerContractNhController.do?doDel&id={id}"  urlclass="ace_button" urlfont="fa-trash-o"/>--%>
   <t:dgToolBar title="录入" icon="icon-add" url="customerContractNhController.do?goAdd" funname="add" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="customerContractNhController.do?goUpdate" funname="reUpdate" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="customerContractNhController.do?doBatchDel" funname="reDeleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="customerContractNhController.do?goUpdate" funname="detail" width="100%" height="100%"></t:dgToolBar>
   <t:dgToolBar title="提交" icon="icon-le-ok"  url="customerContractNhController.do?doCommit" funname="doCommit" ></t:dgToolBar>
   <%--<t:dgToolBar title="缴费" icon="icon-edit"  url="customerContractNhController.do?doCharge" funname="doCharge" ></t:dgToolBar>--%>
  </t:datagrid>
  </div>
 </div>
 <script src = "webpage/com/buss/sale/contractnh/customerContractNhList.js"></script>		
 <script type="text/javascript">
 	//自定义按钮-sql增强-提交
 	function doCommit(title,url,id){
        gridname=id;
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择提交项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再提交');
            return;
        }
        if("1"!=rowsData[0]['contractStatus'].toString()){
            tip('只有待提交状态的信息才可以提交！');
            return;
        }
		url = url+"&id="+rowsData[0]['id'];
 		createdialog('确认 ', '确定'+title+'吗 ?', url,gridname);
 	}
 	//自定义按钮-sql增强-缴费
 	function doCharge(title,url,id){
        gridname=id;
 		var rowsData = $('#'+id).datagrid('getSelections');
		if (!rowsData) {
			tip('请选择缴费项目');
			return;
		}
        if (rowsData.length>1) {
            tip('请选择一条记录再提交');
            return;
        }
        if("2"!=rowsData[0]['contractStatus'].toString()){
            tip('只有收费中状态的信息才可以缴费！');
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
        if("1"!=rowsData[0]['contractStatus'].toString()){
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
                if("1"!=rows[i].contractStatus){
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
	openuploadwin('Excel导入', 'customerContractNhController.do?upload', "customerContractNhList");
}

//导出
function ExportXls() {
	JeecgExcelExport("customerContractNhController.do?exportXls","customerContractNhList");
}

//模板下载
function ExportXlsByT() {
	JeecgExcelExport("customerContractNhController.do?exportXlsByT","customerContractNhList");
}
 </script>