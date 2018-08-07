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
  Date.prototype.format = function(fmt)
  {
	  var o = {
		  "M+" : this.getMonth()+1,                 //月份
		  "d+" : this.getDate(),                    //日
		  "h+" : this.getHours(),                   //小时
		  "m+" : this.getMinutes(),                 //分
		  "s+" : this.getSeconds(),                 //秒
		  "q+" : Math.floor((this.getMonth()+3)/3), //季度
		  "S"  : this.getMilliseconds()             //毫秒
	  };
	  if(/(y+)/.test(fmt))
		  fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
	  for(var k in o)
		  if(new RegExp("("+ k +")").test(fmt))
			  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
	  return fmt;
  }
  $(document).ready(function(){
	$('#tt').tabs({
	   onSelect:function(title){
	       $('#tt .panel-body').css('width','auto');
		}
	});
	$(".tabs-wrap").css('width','100%');
      var date = new Date().format("yyyy-MM-dd");
      $("#signDate").val(date);
      $("#beginDate").val(date);
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerContractNhController.do?doAdd" callback="jeecgFormFileCallBack@Override">
					<input id="id" name="id" type="hidden" value="${customerContractNhPage.id }"/>
				    <input id="customerId" name="customerId" type="hidden" value="${customerContractNhPage.customerId }"/>
				    <input id="buildingId" name="buildingId" type="hidden" value="${customerContractNhPage.buildingId }"/>
				    <input id="roomId" name="roomId" type="hidden" value="${customerContractNhPage.roomId }"/>
	  			    <input id="bedId" name="bedId" type="hidden" value="${customerContractNhPage.bedId }"/>
				    <input id="contractStatus" name="contractStatus" type="hidden" value="1"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">顾客名称:</label>
			</td>
			<td class="value">
				<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'id,name,no','customerId,customerName,customerNo','customer_base')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">合同编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 	readonly="true"	validType="customer_contract_nh,no,id" datatype="*" ignore="checked" value='${customerContractNhPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">所属:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="belongTo" type="list" 		datatype="*"  typeGroupCode="cs_status"  defaultVal="2" hasLabel="false"  title="所属" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">生效日期:</label>
			</td>
			<td class="value">
					  <input id="beginDate" name="beginDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">生效日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">截止日期:</label>
			</td>
			<td class="value">
					  <input id="endDate" name="endDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">截止日期</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">签订日期:</label>
			</td>
			<td class="value">
					  <input id="signDate" name="signDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">签订日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">付款进度:</label>
			</td>
			<td class="value">
		     	 <input id="paymentStatus" name="paymentStatus" type="text" style="width: 150px" readonly="true" value="0%" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">付款进度</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
		     	 <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt" value="${user.realName}" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
			<td align="right">
				<label class="Validform_label">楼栋名称:</label>
			</td>
			<td class="value">
				<input id="buildingName" name="buildingName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'building_id,building_name,room_id,room_name,bed_id,bed_name,price','buildingId,buildingName,roomId,roomName,bedId,bedName,unitPrice','empty_bed_info')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
		     	 <input id="roomName" name="roomName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">床位名称:</label>
			</td>
			<td class="value">
		     	 <input id="bedName" name="bedName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">床位名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">床位费:</label>
			</td>
			<td class="value">
		     	 <input id="unitPrice" name="unitPrice" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">床位费</label>
			</td>
			<td align="right">
				<label class="Validform_label">是否为包房:</label>
			</td>
			<td class="value">
				<t:dictSelect field="isChartered" type="list" datatype="*"  typeGroupCode="dev_flag"  defaultVal="0" hasLabel="false"  title="是否为包房"></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">是否为包房</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">护理等级:</label>
			</td>
			<td class="value">
				<input id="nurseLevel" name="nurseLevel" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'name,charge_standard','nurseLevel,nurseCharge','nurse_level_info')"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">护理等级</label>
			</td>
			<td align="right">
				<label class="Validform_label">护理费:</label>
			</td>
			<td class="value">
		     	 <input id="nurseCharge" name="nurseCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">护理费</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">附件:</label>
			</td>
			<td class="value">
					<table></table>
					<div class="form jeecgDetail"> 
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
											'cgFormName':'customer_contract_nh',
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
					</div> 
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
				 <t:tab href="customerContractNhController.do?contractNhChargeListList&id=${customerContractNhPage.id}" icon="icon-search" title="合同收费列表" id="contractNhChargeList"></t:tab>
				 <t:tab href="customerContractNhController.do?customerContractNhSubList&id=${customerContractNhPage.id}" icon="icon-search" title="附属合同" id="customerContractNhSub"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_contractNhChargeList_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				<input name="contractNhChargeListList[#index#].id" type="hidden"/>
				<input name="contractNhChargeListList[#index#].belongDept" type="hidden"/>
				<input name="contractNhChargeListList[#index#].contractId" type="hidden"/>
				<input name="contractNhChargeListList[#index#].type" type="hidden"/>
				<input name="contractNhChargeListList[#index#].chargeTypeId" type="hidden"/>
				  <td align="left">
					  	<input name="contractNhChargeListList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="contract_nh_charge_list,no,contractNhChargeListList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
					  		<input name="contractNhChargeListList[#index#].name" name="contractNhChargeListList[#index#].name" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'chargetypeid,name,description,mode','chargeTypeId,name,description,type','charge_type_one_popup_nh')"/>
					  <label class="Validform_label" style="display: none;">收费名称</label>
				  </td>
				  <td align="left">
					  	<input name="contractNhChargeListList[#index#].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费描述</label>
				  </td>
				  <td align="left">
					  	<input name="contractNhChargeListList[#index#].price" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费价格</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="contractNhChargeListList[#index#].chargePurpose" type="list"  		datatype="*"  typeGroupCode="sf_purpose"  defaultVal="1" hasLabel="false"  title="用途"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">用途</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="contractNhChargeListList[#index#].status" type="list"  		datatype="*"  typeGroupCode="dev_flag"  defaultVal="0" hasLabel="false"  title="是否缴费"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">是否缴费</label>
				  </td>
				  <td align="left">
					  	<input name="contractNhChargeListList[#index#].remark" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerContractNhSub_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">编号</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">标题</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客名称</label>
				  </td>
				  <td align="left">
							<input name="customerContractNhSubList[#index#].signDate" maxlength="8" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">签署日期</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">负责人</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">签署日期</label>
				  </td>
				  <td align="left">
					  	<input name="customerContractNhSubList[#index#].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">变化情况</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="customerContractNhSubList[#index#].attachment" name="customerContractNhSubList[#index#].attachment" />
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'customerContractNhSubList\\[#index#\\]\\.attachment')"/>
										<a  target="_blank" id="customerContractNhSubList[#index#].attachment_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/sale/contractnh/customerContractNh.js"></script>
  	<script type="text/javascript">
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
	