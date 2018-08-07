<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>建筑物信息</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="baseBuildingController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${baseBuildingPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">建筑物编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="base_building,no,id" datatype="*" ignore="checked" value='${baseBuildingPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">建筑物编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">建筑物名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">建筑物名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">建筑物地址:</label>
			</td>
			<td class="value">
		     	 <input id="address" name="address" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">建筑物地址</label>
			</td>
			<td align="right">
				<label class="Validform_label">建筑物描述:</label>
			</td>
			<td class="value">
		     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">建筑物描述</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">管理员:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="manager" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="管理员" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理员</label>
			</td>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="keeper" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="负责人" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
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
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="type" type="radio"   typeGroupCode="build_type"  defaultVal="${baseBuildingPage.type}" hasLabel="false"  title="类型" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="baseBuildingController.do?baseBuildingStoreyList&id=${baseBuildingPage.id}" icon="icon-search" title="楼层信息" id="baseBuildingStorey"></t:tab>
				 <t:tab href="baseBuildingController.do?baseBuildingRoomTypeList&id=${baseBuildingPage.id}" icon="icon-search" title="房间类型" id="baseBuildingRoomType"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_baseBuildingStorey_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[#index#].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_storey,no,baseBuildingStoreyList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">建筑物楼层编号</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[#index#].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">建筑物楼层名称</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[#index#].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">建筑物楼层描述</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[#index#].manager" type="list"    dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="管理员"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">管理员</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[#index#].keeper" type="list"    dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="负责人"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">负责人</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[#index#].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[#index#].type" type="radio"    typeGroupCode="build_type"  defaultVal="" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_baseBuildingRoomType_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_room_type,no,baseBuildingRoomTypeList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">房间类型编号</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">类型名称</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].numberOfBed" maxlength="4" type="text" class="inputxt"  style="width:120px;" 		datatype="n" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">床位数量</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[#index#].roomArea" type="list"  		datatype="n"  typeGroupCode="room_area"  defaultVal="" hasLabel="false"  title="房型面积"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房型面积</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[#index#].orientation" type="list"    typeGroupCode="room_turn"  defaultVal="" hasLabel="false"  title="房屋朝向"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房屋朝向</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">类型描述</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].shortPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">短期计费单价</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].longPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">长期计费单价</label>
				  </td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[#index#].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[#index#].type" type="radio"    typeGroupCode="build_type"  defaultVal="" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/base/building/baseBuilding.js"></script>
	