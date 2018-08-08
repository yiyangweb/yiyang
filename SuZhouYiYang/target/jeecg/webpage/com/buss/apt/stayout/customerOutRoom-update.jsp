<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>退房管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerOutRoomController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${customerOutRoomPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">退房编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="customer_out_room,no,id" datatype="*" ignore="checked"  value='${customerOutRoomPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">退房编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
					<input id="roomName" name="roomName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'room_name,customer_name,customer_no,id,room_id','roomName,customerName,customerNo,stayinId,roomId','stayin_info')"  value='${customerOutRoomPage.roomName}'/>
				<input id="stayinId" name="stayinId" type="hidden" value='${customerOutRoomPage.stayinId}'/>
				<input id="roomId" name="roomId" type="hidden" value='${customerOutRoomPage.roomId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">顾客名称:</label>
			</td>
			<td class="value">
		     	 <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked"  value='${customerOutRoomPage.customerName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerOutRoomPage.customerNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">办理人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerOutRoomPage.inCharge}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理人</label>
			</td>
			<td align="right">
				<label class="Validform_label">办理日期:</label>
			</td>
			<td class="value">
				<!--<input id="dealDate" name="dealDate" type="text" style="width: 150px"   ignore="ignore"  value='<fmt:formatDate value='${customerOutRoomPage.dealDate}' type="date" pattern="yyyy-MM-dd"/>'/>-->
				<input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" value='${customerOutRoomPage.dealDate}' pattern="yyyy-MM-dd" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理日期</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerOutRoomController.do?checkOutDesList&id=${customerOutRoomPage.id}" icon="icon-search" title="检查情况" id="checkOutDes"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_checkOutDes_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="checkOutDesList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">项目名称</label>
				  </td>
				  <td align="left">
					  		<input name="checkOutDesList[#index#].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属</label>
				  </td>
				  <td align="left">
					  		<input name="checkOutDesList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  		<input name="checkOutDesList[#index#].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查人</label>
				  </td>
				  <td align="left">
							<input name="checkOutDesList[#index#].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">完成时间</label>
				  </td>
				  <td align="left">
					  		<input name="checkOutDesList[#index#].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="checkOutDesList[#index#].attribute" name="checkOutDesList[#index#].attribute" />
									    <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkOutDesList\\[#index#\\]\\.attribute')"/>
										<a  target="_blank" id="checkOutDesList[#index#].attribute_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/apt/stayout/customerOutRoom.js"></script>	
