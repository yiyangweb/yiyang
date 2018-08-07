<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>签订合同记录</title>
    <style>
  .ui-button {
  	  display: inline-block;
	  padding: 2px 2px;
	  margin-bottom: 0;
	  font-size: 8px;
	  font-weight: normal;
	  line-height: 1.42857143;
	  text-align: center;
	  white-space: nowrap;
	  vertical-align: middle;
	  -ms-touch-action: manipulation;
      touch-action: manipulation;
	  cursor: pointer;
	  -webkit-user-select: none;
      -moz-user-select: none;
      -ms-user-select: none;
      user-select: none;
	  background-image: none;
	  border: 1px solid transparent;
	  border-radius: 4px;
  }
  </style>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
		<link rel="stylesheet" href="plug-in/uploadify/css/uploadify.css" type="text/css" />
		<script type="text/javascript" src="plug-in/uploadify/jquery.uploadify-3.1.js"></script>
  <script type="text/javascript">
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" beforeSubmit="checkValid()" action="customerContractController.do?doUpdate" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${customerContractPage.id }"/>
				    <input id="customerId" name="customerId" type="hidden" value="${customerContractPage.customerId }"/>
				    <input id="buildingId" name="buildingId" type="hidden" value="${customerContractPage.buildingId }"/>
				    <input id="roomId" name="roomId" type="hidden" value="${customerContractPage.roomId }"/>
				    <input id="contractStatus" name="contractStatus" type="hidden" value="${customerContractPage.contractStatus }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">客户名称:</label>
			</td>
			<td class="value">
					<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'id,name,no','customerId,customerName,customerNo','customer_base')"  value='${customerContractPage.customerName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerContractPage.customerNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 	readonly="true"	validType="customer_contract,no,id" datatype="*" ignore="checked"  value='${customerContractPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">所属:</label>
			</td>
			<td class="value">
					<t:dictSelect field="belongTo" type="list"   typeGroupCode="cs_status" defaultVal="${customerContractPage.belongTo}" hasLabel="false"  title="所属"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="contractTypeId" type="list"   typeGroupCode="ht_type"  defaultVal="${customerContractPage.contractTypeId}" hasLabel="false"  title="合同类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">是否分期:</label>
			</td>
			<td class="value">
					<t:dictSelect field="isInstalments" type="list"   typeGroupCode="dev_flag"  defaultVal="${customerContractPage.isInstalments}" hasLabel="false"  title="是否分期"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否分期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">分期期数:</label>
			</td>
			<td class="value">
		     	 <input id="numOfPeriods" name="numOfPeriods" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="ignore"  value='${customerContractPage.numOfPeriods}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">分期期数</label>
			</td>
			<td align="right">
				<label class="Validform_label">付款进度:</label>
			</td>
			<td class="value">
		     	 <input id="paymentStatus" name="paymentStatus" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerContractPage.paymentStatus}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">付款进度</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">楼栋:</label>
			</td>
			<td class="value">
					<input id="buildingName" name="buildingName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'building_id,building_name,room_id,room_name,bed_id,bed_name','buildingId,buildingName,roomId,roomName,bedId,bedName','empty_room_info')"  value='${customerContractPage.buildingName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间:</label>
			</td>
			<td class="value">
		     	 <input id="roomName" name="roomName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerContractPage.roomName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">签订日期:</label>
			</td>
			<td class="value">
					  <input id="signDate" name="signDate" type="text" style="width: 150px"   ignore="ignore"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${customerContractPage.signDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">生效日期:</label>
			</td>
			<td class="value">
					  <input id="beginDate" name="beginDate" type="text" style="width: 150px"   ignore="ignore"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${customerContractPage.beginDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">生效日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">截止日期:</label>
			</td>
			<td class="value">
					  <input id="endDate" name="endDate" type="text" style="width: 150px"   ignore="ignore"  class="Wdate" onClick="WdatePicker()" value='<fmt:formatDate value='${customerContractPage.endDate}' type="date" pattern="yyyy-MM-dd"/>'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">截止日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
		     	 <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerContractPage.charger}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
			<td class="value">
					<table id="attach_fileTable"></table>
						<table></table>
						<script type="text/javascript">
							var serverMsg="";
							$(function(){
								$('#attach').uploadify({
									buttonText:'添加文件',
									auto:false,
									progressData:'speed',
									multi:true,
									height:25,
									overrideEvents:['onDialogClose'],
									fileTypeDesc:'文件格式:',
									queueID:'filediv_attach',
									fileSizeLimit:'15MB',
									swf:'plug-in/uploadify/uploadify.swf',	
									uploader:'cgUploadController.do?saveFiles&jsessionid='+$("#sessionUID").val()+'',
									onUploadStart : function(file) { 
										var cgFormId=$("input[name='id']").val();
										$('#attach').uploadify("settings", "formData", {
											'cgFormId':cgFormId,
											'cgFormName':'customer_contract',
											'cgFormField':'ATTACH'
										});
									} ,
									onQueueComplete : function(queueData) {
										 var win = frameElement.api.opener;
										 win.reloadTable();
										 win.tip(serverMsg);
										 frameElement.api.close();
									},
									onUploadSuccess : function(file, data, response) {
										var d=$.parseJSON(data);
										if(d.success){
											var win = frameElement.api.opener;
											serverMsg = d.msg;
										}
									},
									onFallback: function() {
					                    tip("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试")
					                },
					                onSelectError: function(file, errorCode, errorMsg) {
					                    switch (errorCode) {
					                    case - 100 : tip("上传的文件数量已经超出系统限制的" + $('#file').uploadify('settings', 'queueSizeLimit') + "个文件！");
					                        break;
					                    case - 110 : tip("文件 [" + file.name + "] 大小超出系统限制的" + $('#file').uploadify('settings', 'fileSizeLimit') + "大小！");
					                        break;
					                    case - 120 : tip("文件 [" + file.name + "] 大小异常！");
					                        break;
					                    case - 130 : tip("文件 [" + file.name + "] 类型不正确！");
					                        break;
					                    }
					                },
					                onUploadProgress: function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {}
								});
							});
						</script>
						<span id="file_uploadspan"><input type="file" name="attach" id="attach" /></span> 
						<div class="form" id="filediv_attach"></div>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">附件</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerContractController.do?contractChargeListList&id=${customerContractPage.id}" icon="icon-search" title="合同收费列表" id="contractChargeList"></t:tab>
				 <t:tab href="customerContractController.do?chargeListList&id=${customerContractPage.id}" icon="icon-search" title="分期情况" id="chargeList"></t:tab>
				 <t:tab href="customerContractController.do?customerContractSubList&id=${customerContractPage.id}" icon="icon-search" title="附属合同" id="customerContractSub"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_contractChargeList_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
                <input name="contractChargeListList[#index#].id" type="hidden"/>
                <input name="contractChargeListList[#index#].belongDept" type="hidden"/>
                <input name="contractChargeListList[#index#].contractId" type="hidden"/>
                <input name="contractChargeListList[#index#].type" type="hidden"/>
				<input name="contractChargeListList[#index#].chargeTypeId" type="hidden"/>
				  <td align="left">
					  		<input name="contractChargeListList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="contract_charge_list,no,contractChargeListList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
					  				<input name="contractChargeListList[#index#].name" name="contractChargeListList[#index#].name" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"    onclick="popupClick(this,'chargetypeid,name,description,mode,belongdeptcode','chargeTypeId,name,description,type,belongDept','charge_type_one_popup')" value="${poVal.name }" />
					     						
					       
					  <label class="Validform_label" style="display: none;">收费名称</label>
				  </td>
				  <td align="left">
					  		<input name="contractChargeListList[#index#].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费描述</label>
				  </td>
				  <td align="left">
					  		<input name="contractChargeListList[#index#].price" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费价格</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="contractChargeListList[#index#].chargePurpose" type="list" 		datatype="*"  typeGroupCode="sf_purpose"  defaultVal="1" hasLabel="false"  title="用途"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">用途</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="contractChargeListList[#index#].status" type="list"   typeGroupCode="dev_flag"  defaultVal="0" hasLabel="false"  title="是否缴费"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">是否缴费</label>
				  </td>
				  <td align="left">
					  		<input name="contractChargeListList[#index#].remark" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_chargeList_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="chargeListList[#index#].orderNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">序号</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list,no,chargeListList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费项目</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListList[#index#].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="chargeListList[#index#].isFee" type="list"   typeGroupCode="dev_flag"  defaultVal="" hasLabel="false"  title="生成收费单"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">生成收费单</label>
				  </td>
				  <td align="left">
							<input name="chargeListList[#index#].chargeDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">缴费日期</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费描述</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListList[#index#].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_customerContractSub_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_contract_sub,no,customerContractSubList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">编号</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">标题</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客名称</label>
				  </td>
				  <td align="left">
							<input name="customerContractSubList[#index#].signDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">签署日期</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">负责人</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">签署原因</label>
				  </td>
				  <td align="left">
					  		<input name="customerContractSubList[#index#].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">变化情况</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="customerContractSubList[#index#].attachment" name="customerContractSubList[#index#].attachment" />
									    <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'customerContractSubList\\[#index#\\]\\.attachment')"/>
										<a  target="_blank" id="customerContractSubList[#index#].attachment_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/sale/contract/customerContract.js"></script>	
  	<script type="text/javascript">
	  	//加载 已存在的 文件
	  	$(function(){
	  		var cgFormId=$("input[name='id']").val();
	  		$.ajax({
	  		   type: "post",
	  		   url: "customerContractController.do?getFiles&id=" +  cgFormId,
	  		   success: function(data){
	  			 var arrayFileObj = jQuery.parseJSON(data).obj;
	  			 
	  			$.each(arrayFileObj,function(n,file){
	  				var fieldName = file.field.toLowerCase();
	  				var table = $("#"+fieldName+"_fileTable");
	  				var tr = $("<tr style=\"height:34px;\"></tr>");
	  				var title = file.title;
	  				if(title.length > 15){
	  					title = title.substring(0,12) + "...";
	  				}
	  				var td_title = $("<td>" + title + "</td>");
	  		  		var td_download = $("<td><a style=\"margin-left:10px;\" href=\"commonController.do?viewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity\" title=\"下载\">下载</a></td>")
	  		  		var td_view = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0);\" onclick=\"openwindow('预览','commonController.do?openViewFile&fileid=" + file.fileKey + "&subclassname=org.jeecgframework.web.cgform.entity.upload.CgUploadEntity','fList',700,500)\">预览</a></td>");
	  		  		var td_del = $("<td><a style=\"margin-left:10px;\" href=\"javascript:void(0)\" class=\"jeecgDetail\" onclick=\"del('cgUploadController.do?delFile&id=" + file.fileKey + "',this)\">删除</a></td>");
	  		  		tr.appendTo(table);
	  		  		td_title.appendTo(tr);
	  		  		td_download.appendTo(tr);
	  		  		td_view.appendTo(tr);
	  		  		td_del.appendTo(tr);
	  			 });
	  		   }
	  		});
	  	})
	  	
		  	/**
		 	 * 删除图片数据资源
		 	 */
		  	function del(url,obj){
		  		var content = "请问是否要删除该资源";
		  		var navigatorName = "Microsoft Internet Explorer"; 
		  		if( navigator.appName == navigatorName ){ 
		  			$.dialog.confirm(content, function(){
		  				submit(url,obj);
		  			}, function(){
		  			});
		  		}else{
		  			layer.open({
						title:"提示",
						content:content,
						icon:7,
						yes:function(index){
							submit(url,obj);
						},
						btn:['确定','取消'],
						btn2:function(index){
							layer.close(index);
						}
					});
		  		}
		  	}
		  	
		  	function submit(url,obj){
		  		$.ajax({
		  			async : false,
		  			cache : false,
		  			type : 'POST',
		  			url : url,// 请求的action路径
		  			error : function() {// 请求失败处理函数
		  			},
		  			success : function(data) {
		  				var d = $.parseJSON(data);
		  				if (d.success) {
		  					var msg = d.msg;
		  					tip(msg);
		  					obj.parentNode.parentNode.parentNode.deleteRow(obj.parentNode.parentNode);
		  				} else {
		  					tip(d.msg);
		  				}
		  			}
		  		});
		  	}
	  	
  		function jeecgFormFileCallBack(data){
  			if (data.success == true) {
				uploadFile(data);
			} else {
				if (data.responseText == '' || data.responseText == undefined) {
					$.messager.alert('错误', data.msg);
					$.Hidemsg();
				} else {
					try {
						var emsg = data.responseText.substring(data.responseText.indexOf('错误描述'), data.responseText.indexOf('错误信息'));
						$.messager.alert('错误', emsg);
						$.Hidemsg();
					} catch(ex) {
						$.messager.alert('错误', data.responseText + '');
					}
				}
				return false;
			}
			if (!neibuClickFlag) {
				var win = frameElement.api.opener;
				win.reloadTable();
			}
  		}
  		function upload() {
					$('#attach').uploadify('upload', '*');
		}
		
		var neibuClickFlag = false;
		function neibuClick() {
			neibuClickFlag = true; 
			$('#btn_sub').trigger('click');
		}
		function cancel() {
					$('#attach').uploadify('cancel', '*');
		}
		function uploadFile(data){
			if(!$("input[name='id']").val()){
				if(data.obj!=null && data.obj!='undefined'){
					$("input[name='id']").val(data.obj.id);
				}
			}
			if($(".uploadify-queue-item").length>0){
				upload();
			}else{
				if (neibuClickFlag){
					alert(data.msg);
					neibuClickFlag = false;
				}else {
					var win = frameElement.api.opener;
					win.reloadTable();
					win.tip(data.msg);
					frameElement.api.close();
				}
			}
		}
  	</script>
