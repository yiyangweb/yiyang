<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>退住申请</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerLeaveNurseController.do?doUpdate" >
	  <input id="id" name="id" type="hidden" value="${customerLeaveNursePage.id }"/>
	  <input id="stayinId" name="stayinId" type="hidden" value="${customerLeaveNursePage.stayinId }" />
	  <input id="roomId" name="roomId" type="hidden" value="${customerLeaveNursePage.roomId }" />
	  <input id="bedId" name="bedId" type="hidden" value="${customerLeaveNursePage.bedId }" />
	  <input id="customerNo" name="customerNo" type="hidden" value="${customerLeaveNursePage.customerNo }" />
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">退住编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" readonly="true"  ignore="ignore"  value='${customerLeaveNursePage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">退住编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间:</label>
			</td>
			<td class="value">
					<input id="roomName" name="roomName" readonly="true" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'id,room_id,room_name,bed_id,bed_name,customer_name,customer_no','stayinId,roomId,roomName,bedId,bedName,customerName,customerNo','stayin_info_nh')" value='${customerLeaveNursePage.roomName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">床位:</label>
			</td>
			<td class="value">
		     	 <input id="bedName" name="bedName" type="text" style="width: 150px" class="inputxt" readonly="true" ignore="ignore"  value='${customerLeaveNursePage.bedName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">床位</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
		     	 <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt" 	readonly="true"	datatype="*" ignore="checked"  value='${customerLeaveNursePage.customerName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">办理人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked"  value='${customerLeaveNursePage.inCharge}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理人</label>
			</td>
			<td align="right">
				<label class="Validform_label">办理日期:</label>
			</td>
			<td class="value">
				<input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='${customerLeaveNursePage.dealDate}'	datatype="*" ignore="checked"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理日期</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerLeaveNurseController.do?checkLeaveNurseList&id=${customerLeaveNursePage.id}" icon="icon-search" title="检查情况" id="checkLeaveNurse"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_checkLeaveNurse_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="checkLeaveNurseList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">检查项目</label>
				  </td>
				  <td align="left">
					  		<input name="checkLeaveNurseList[#index#].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">属于</label>
				  </td>
				  <td align="left">
					  		<input name="checkLeaveNurseList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  		<input name="checkLeaveNurseList[#index#].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查人</label>
				  </td>
				  <td align="left">
							<input name="checkLeaveNurseList[#index#].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查日期</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="checkLeaveNurseList[#index#].attribute" name="checkLeaveNurseList[#index#].attribute" />
									    <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNurseList\\[#index#\\]\\.attribute')"/>
										<a  target="_blank" id="checkLeaveNurseList[#index#].attribute_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/nh/leave/customerLeaveNurse.js"></script>	
