<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>水电基础数据</title>
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

	//楼栋下拉
	$("#baseBuildingId").regionselect({
	  url:'<%=basePath%>/baseBuildingController.do?regionSelect',
	  buildingid:'baseBuildingId',
	  secondid:'baseBuildingRoomId',
	  second_search_value:'room'
	});
  });
 </script>
 <!-- 联动 -->
 <script src="webpage/com/buss/utils/jquery.regionselect.js" type="text/javascript"></script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="meterInfoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${meterInfoPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">计量设备编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="meter_info,no,id" datatype="*" ignore="checked"  value='${meterInfoPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计量设备编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">计量设备类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="meterType" type="radio"   typeGroupCode="meter_type"  defaultVal="${meterInfoPage.meterType}" hasLabel="false"  title="计量设备类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计量设备类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">计量设备名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.name}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计量设备名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">计量设备地址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.address}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计量设备地址</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">计量设备表描述:</label>
			</td>
			<td class="value">
		     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.description}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">计量设备表描述</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
				<input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.remark}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">楼栋名称:</label>
			</td>
			<td class="value">
				<input id="baseBuildingId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.baseBuildingId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
		     	 <input id="baseBuildingRoomId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${meterInfoPage.baseBuildingRoomId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="meterInfoController.do?meterReadingRecordList&id=${meterInfoPage.id}" icon="icon-search" title="水电抄表记录" id="meterReadingRecord"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_meterReadingRecord_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="meter_reading_record,no,meterReadingRecordList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">抄表记录编号</label>
				  </td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].reading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">读数</label>
				  </td>
				  <td align="left">
							<input name="meterReadingRecordList[#index#].readingTime" maxlength="8" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">抄表时间</label>
				  </td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].lastReading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">上期读数</label>
				  </td>
				  <td align="left">
							<input name="meterReadingRecordList[#index#].lastReadingTime" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">上期抄表时间</label>
				  </td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].price" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单价</label>
				  </td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].money" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">抄表间隔所需费用</label>
				  </td>
				  <td align="left">
					  		<input name="meterReadingRecordList[#index#].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/base/meter/meterInfo.js"></script>	
