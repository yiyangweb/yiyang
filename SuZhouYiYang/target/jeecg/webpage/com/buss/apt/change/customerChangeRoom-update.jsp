<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>换房管理</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerChangeRoomController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${customerChangeRoomPage.id }"/>
				  <input id="originId" name="originId" type="hidden" value="${customerChangeRoomPage.originId }"/>
				  <input id="originRoomId" name="originRoomId" type="hidden" value="${customerChangeRoomPage.originRoomId }"/>
				  <input id="originBuildingId" name="originBuildingId" type="hidden" value="${customerChangeRoomPage.originBuildingId }"/>
				  <input id="newRoomId" name="newRoomId" type="hidden" value="${customerChangeRoomPage.newRoomId }"/>
				  <input id="newBuildingId" name="newBuildingId" type="hidden" value="${customerChangeRoomPage.newBuildingId }"/>
				  <input id="customerNo" name="customerNo" type="hidden" value="${customerChangeRoomPage.customerNo }"/>
				  <input id="belongTo" name="belongTo" type="hidden" value="${customerChangeRoomPage.belongTo }"/>
                  <input id="status" name="status" type="hidden" value="${customerChangeRoomPage.status }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">换房编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">换房编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
					<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"   onclick="popupClick(this,'id,customer_no,customer_name,room_id,room_name,building_id,building_name','originId,customerNo,customerName,originRoomId,originRoom,originBuildingId,originBuildingName','stayin_info')"  value='${customerChangeRoomPage.customerName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">原房间:</label>
			</td>
			<td class="value">
		     	 <input id="originRoom" name="originRoom" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.originRoom}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原房间</label>
			</td>
			<td align="right">
				<label class="Validform_label">原楼栋:</label>
			</td>
			<td class="value">
		     	 <input id="originBuildingName" name="originBuildingName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.originBuildingName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">原楼栋</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">交换房间:</label>
			</td>
			<td class="value">
					<input id="newRoomName" name="newRoomName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"   onclick="popupClick(this,'newRoomId,newRoomName,newBuildingId,newBuildingName','empty_room_info')"  value='${customerChangeRoomPage.newRoomName}'/>			    
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">交换房间</label>
			</td>
			<td align="right">
				<label class="Validform_label">交换楼栋:</label>
			</td>
			<td class="value">
		     	 <input id="newBuildingName" name="newBuildingName" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.newBuildingName}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">交换楼栋</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">办理人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.inCharge}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">办理人</label>
			</td>
            <td align="right">
                <label class="Validform_label">办理时间:</label>
            </td>
            <td class="value">
                <input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" ignore="ignore"  value='<fmt:formatDate value='${customerChangeRoomPage.dealDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">办理时间</label>
            </td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="auditor" name="auditor" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.auditor}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
            <td align="right">
                <label class="Validform_label">审核时间:</label>
            </td>
            <td class="value">
                <input id="auditDate" name="auditDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()" ignore="ignore"  value='<fmt:formatDate value='${customerChangeRoomPage.auditDate}' type="date" pattern="yyyy-MM-dd"/>'/>
                <span class="Validform_checktip"></span>
                <label class="Validform_label" style="display: none;">审核时间</label>
            </td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核意见:</label>
			</td>
			<td class="value">
		     	 <input id="auditDes" name="auditDes" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${customerChangeRoomPage.auditDes}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核意见</label>
			</td>
		</tr>
	
			</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerChangeRoomController.do?checkChangeDesList&id=${customerChangeRoomPage.id}" icon="icon-search" title="换房检查" id="checkChangeDes"></t:tab>
				 <t:tab href="customerChangeRoomController.do?changeRoomFeeList&id=${customerChangeRoomPage.id}" icon="icon-search" title="退缴费情况" id="changeRoomFee"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
		<table style="display:none">
		<tbody id="add_checkChangeDes_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="checkChangeDesList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="check_change_des,no,checkChangeDesList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">编号</label>
				  </td>
				  <td align="left">
					  		<input name="checkChangeDesList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
				  </td>
				  <td align="left">
					  		<input name="checkChangeDesList[#index#].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">归属</label>
				  </td>
				  <td align="left">
					  		<input name="checkChangeDesList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  		<input name="checkChangeDesList[#index#].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查人</label>
				  </td>
				  <td align="left">
							<input name="checkChangeDesList[#index#].endDete" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">完成时间</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="checkChangeDesList[#index#].attribute" name="checkChangeDesList[#index#].attribute" />
									    <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkChangeDesList\\[#index#\\]\\.attribute')"/>
										<a  target="_blank" id="checkChangeDesList[#index#].attribute_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
		<tbody id="add_changeRoomFee_table_template">
			<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="changeRoomFeeList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="change_room_fee,no,changeRoomFeeList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="changeRoomFeeList[#index#].feeType" type="list"   typeGroupCode="fee_type"  defaultVal="" hasLabel="false"  title="退缴类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">退缴类型</label>
				  </td>
				  <td align="left">
					  		<input name="changeRoomFeeList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" />
					  <label class="Validform_label" style="display: none;">项目</label>
				  </td>
				  <td align="left">
					  		<input name="changeRoomFeeList[#index#].feeNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" />
					  <label class="Validform_label" style="display: none;">费用</label>
				  </td>
                <td align="left">
                    <input name="changeRoomFeeList[#index#].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
                    <label class="Validform_label" style="display: none;">描述</label>
                </td>
				  <td align="left">
					  <t:dictSelect field="changeRoomFeeList[#index#].belongDeptCode" type="list"   dictTable="t_s_depart" dictField="id" dictText="departname"  defaultVal="" hasLabel="false"  title="收费部门名称"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/apt/change/customerChangeRoom.js"></script>	
