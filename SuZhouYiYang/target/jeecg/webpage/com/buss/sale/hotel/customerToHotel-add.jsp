<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>酒店管理</title>
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
	$("#buildingId").regionselect({
	  	url:'<%=basePath%>/baseBuildingController.do?regionSelect',
		buildingid:'buildingId',
        secondid:'roomId',
        second_search_value:'room'
	});
  });
 </script>
 <!-- 联动 -->
 <script src="webpage/com/buss/utils/jquery.regionselect.js" type="text/javascript"></script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerToHotelController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customerToHotelPage.id }"/>
	  				<input id="customerId" name="customerId" type="hidden" value="${customerToHotelPage.customerId }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">入住编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="customer_to_hotel,no,id" datatype="*" ignore="checked" value='${customerToHotelPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
				<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'id,no,name','customerId,customerNo,customerName','customer_base_pop')"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">顾客编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="sex" type="list"   typeGroupCode="sex"  defaultVal="${customerToHotelPage.sex}" hasLabel="false"  title="性别" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">楼栋名称:</label>
			</td>
			<td class="value">
				<input type="text" id="buildingId" style="width:155px;" value=""/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">入住状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="crStatus" type="list"   typeGroupCode="jd_status"  defaultVal="${customerToHotelPage.crStatus}" hasLabel="false"  title="入住状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
				<input type="text" id="roomId" style="width:155px;" value=""/>
					<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">入住经办人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住经办人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">入住时间:</label>
			</td>
			<td class="value">
					  <input id="inDate" name="inDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">退住经办人:</label>
			</td>
			<td class="value">
		     	 <input id="outCharge" name="outCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">退住经办人</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">退房时间:</label>
			</td>
			<td class="value">
					  <input id="outDate" name="outDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">退房时间</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="remarks" name="remarks" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerToHotelController.do?chargeListHotelList&id=${customerToHotelPage.id}" icon="icon-search" title="收费列表" id="chargeListHotel"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_chargeListHotel_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="chargeListHotelList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_hotel,no,chargeListHotelList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
					  		<input name="chargeListHotelList[#index#].name" name="chargeListHotelList[#index#].name" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'chargetypeid,name,description,mode,remark,belongdeptcode,belongdeptname','chargeTypeId,name,description,modeCode,remark,belongDept,belongDeptName','charge_type_one_popup')"/>
					  <label class="Validform_label" style="display: none;">收费名称</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListHotelList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费描述</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListHotelList[#index#].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">价格</label>
				  </td>
				  <td align="left">
					  <input name="chargeListHotelList[#index#].modeCode" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" onchange="onModeChange(this)"/>
					  <t:dictSelect id="dictSelectMode#index#" field="chargeListHotelList[#index#].mode" type="list"    typeGroupCode="sf_mode"  defaultVal="" hasLabel="false"  title="收费模式"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">收费模式</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListHotelList[#index#].belongDeptName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
				  </td>
				  <td align="left">
					  	<input name="chargeListHotelList[#index#].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/sale/hotel/customerToHotel.js"></script>
	