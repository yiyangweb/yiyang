<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>建筑物房间信息</title>
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
		secondid:'baseBuildingStoreyId',
		thirdid:'baseBuildingRoomTypeId',
		second_search_value:'story',
		third_search_value:'roomtype'
	});
  });
 </script>
 <!-- 联动 -->
 <script src="webpage/com/buss/utils/jquery.regionselect.js" type="text/javascript"></script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="baseBuildingRoomController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${baseBuildingRoomPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">建筑名称:</label>
			</td>
			<td class="value">
		     	 <input id="baseBuildingId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.baseBuildingId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">建筑名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">楼层名称:</label>
			</td>
			<td class="value">
		     	 <input id="baseBuildingStoreyId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.baseBuildingStoreyId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼层名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间类型:</label>
			</td>
			<td class="value">
		     	 <input id="baseBuildingRoomTypeId" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.baseBuildingRoomTypeId}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="base_building_room,no,id" datatype="*" ignore="checked"  value='${baseBuildingRoomPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.name}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">管理员:</label>
			</td>
			<td class="value">
					<t:dictSelect field="manager" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingRoomPage.manager}" hasLabel="false"  title="管理员"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">管理员</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">负责人:</label>
			</td>
			<td class="value">
					<t:dictSelect field="keeper" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingRoomPage.keeper}" hasLabel="false"  title="负责人"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">负责人</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间状态:</label>
			</td>
			<td class="value">
					<t:dictSelect field="status" type="list"   typeGroupCode="rom_status"  defaultVal="${baseBuildingRoomPage.status}" hasLabel="false"  title="房间状态"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间状态</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">房间信息描述:</label>
			</td>
			<td class="value">
		     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.description}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间信息描述</label>
			</td>
			<td align="right">
				<label class="Validform_label">备注:</label>
			</td>
			<td class="value">
		     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${baseBuildingRoomPage.remark}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">备注</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">类型:</label>
			</td>
			<td class="value">
					<t:dictSelect field="belongTo" type="radio"   typeGroupCode="build_type"  defaultVal="${baseBuildingRoomPage.belongTo}" hasLabel="false"  title="类型"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">类型</label>
			</td>
			<td align="right">
				<label class="Validform_label">所属区域:</label>
			</td>
			<td class="value">
					<t:dictSelect field="baseBuildingAreaId" type="list"   dictTable="base_building_area" dictField="id" dictText="name"  defaultVal="${baseBuildingRoomPage.baseBuildingAreaId}" hasLabel="false"  title="所属区域"></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">所属区域</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="baseBuildingRoomController.do?baseBuildingBedList&id=${baseBuildingRoomPage.id}" icon="icon-search" title="建筑物床位信息" id="baseBuildingBed"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_baseBuildingBed_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="baseBuildingBedList[#index#].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_bed,no,baseBuildingBedList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">建筑物床位编号</label>
				  </td>
				  <td align="left">
					  		<input name="baseBuildingBedList[#index#].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">床位别名</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingBedList[#index#].status" type="list"   typeGroupCode="bed_status"  defaultVal="" hasLabel="false"  title="床位状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">床位状态</label>
				  </td>
				  <td align="left">
					  		<input name="baseBuildingBedList[#index#].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">床位信息描述</label>
				  </td>
				  <td align="left">
					  		<input name="baseBuildingBedList[#index#].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="baseBuildingBedList[#index#].belongTo" type="radio"   typeGroupCode="build_type"  defaultVal="" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/base/building/baseBuildingRoom.js"></script>	
