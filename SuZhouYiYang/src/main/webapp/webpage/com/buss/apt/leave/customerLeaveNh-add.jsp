<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>退住管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerLeaveNhController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customerLeaveNhPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="customer_leave_nh,no,id" datatype="*" ignore="checked" value='${customerLeaveNhPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间:</label>
			</td>
			<td class="value">
				<input id="roomName" name="roomName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'id, room_id,room_name,room_name,customer_name,customer_no','stayinId,roomId,roomName,customerName,customerNo','stayin_info')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
		     	 <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">流程状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="leaveStatus" type="list"   typeGroupCode="tz_status"  defaultVal="${customerLeaveNhPage.leaveStatus}" hasLabel="false"  title="流程状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">流程状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">办理人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">办理日期:</label>
			</td>
			<td class="value">
					  <input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="auditor" name="auditor" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核日期:</label>
			</td>
			<td class="value">
					  <input id="auditDate" name="auditDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核日期</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核详情:</label>
			</td>
			<td class="value">
		     	 <input id="auditDes" name="auditDes" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核详情</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerLeaveNhController.do?checkLeaveNhList&id=${customerLeaveNhPage.id}" icon="icon-search" title="检查列表" id="checkLeaveNh"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_checkLeaveNh_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="checkLeaveNhList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">检查项目</label>
				  </td>
				  <td align="left">
					  	<input name="checkLeaveNhList[#index#].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属</label>
				  </td>
				  <td align="left">
					  	<input name="checkLeaveNhList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  	<input name="checkLeaveNhList[#index#].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查人</label>
				  </td>
				  <td align="left">
							<input name="checkLeaveNhList[#index#].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">完结日期</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="checkLeaveNhList[#index#].attribute" name="checkLeaveNhList[#index#].attribute" />
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNhList\\[#index#\\]\\.attribute')"/>
										<a  target="_blank" id="checkLeaveNhList[#index#].attribute_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/apt/leave/customerLeaveNh.js"></script>
	