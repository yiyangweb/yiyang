<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>增值服务</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="valueAddedServiceController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${valueAddedServicePage.id }"/>
				    <input id="customerId" name="customerId" type="hidden" value="${valueAddedServicePage.customerId }"/>
				    <input id="customerRoomId" name="customerRoomId" type="hidden" value="${valueAddedServicePage.customerRoomId }"/>
	  				<input id="customerBedId" name="customerBedId" type="hidden" value="${valueAddedServicePage.customerBedId }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">服务编号:</label>
			</td>
			<td class="value">
		     	 <input id="serviceId" name="serviceId" type="text" style="width: 150px" class="inputxt" 		validType="value_added_service,service_id,id" datatype="*" ignore="checked" value='${valueAddedServicePage.serviceId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
				<c:if test="${type == '1'}">
				<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'customer_id,customer_name,room_id,room_name','customerId,customerName,customerRoomId,customerRoomName','customer_room_info')"/>
				</c:if>
				<c:if test="${type == '2'}">
					<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'customer_id,customer_name,room_id,room_name,bed_id,bed_name','customerId,customerName,customerRoomId,customerRoomName,customerBedId,customerBedName','customer_bed_info')"/>
				</c:if>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间号:</label>
			</td>
			<td class="value">
		     	 <input id="customerRoomName" name="customerRoomName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间号</label>
			</td>
			<c:if test="${type == '2'}">
			<td align="right">
				<label class="Validform_label">床位号:</label>
			</td>
			<td class="value">
				<input id="customerBedName" name="customerBedName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">床位号</label>
			</td>
			</c:if>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">服务类型:</label>
			</td>
			<td class="value">
				<t:dictSelect field="serviceType" type="list" 		datatype="*"  typeGroupCode="zz_status"  defaultVal="${valueAddedServicePage.serviceType}" hasLabel="false"  title="服务类型" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">服务说明:</label>
			</td>
			<td class="value">
		     	 <input id="serviceDetail" name="serviceDetail" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">服务说明</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
				<input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="valueAddedServiceController.do?chargeListServiceList&id=${valueAddedServicePage.id}" icon="icon-search" title="收费列表" id="chargeListService"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_chargeListService_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				<input name="chargeListServiceList[#index#].id" type="hidden" value="${poVal.id }"/>
				<input name="chargeListServiceList[#index#].serviceId" type="hidden" value="${poVal.serviceId }"/>
				<input name="chargeListServiceList[#index#].mode" type="hidden" value="${poVal.mode }"/>
				  <td align="left">
					  	<input name="chargeListServiceList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_service,no,chargeListServiceList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListServiceList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费名称</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListServiceList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费描述</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListServiceList[#index#].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费价格</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListServiceList[#index#].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/sale/service/valueAddedService.js"></script>
	