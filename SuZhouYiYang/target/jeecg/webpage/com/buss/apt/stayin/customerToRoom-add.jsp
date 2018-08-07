<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>入住管理</title>
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

    var date = new Date().format("yyyy-MM-dd hh:mm:ss");
    $("#inDate").val(date);
  });
 </script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerToRoomController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customerToRoomPage.id }"/>
				  <input id="customerId" name="customerId" type="hidden" value="${customerToRoomPage.customerId }"/>
	      		  <input id="buildingId" name="buildingId" type="hidden" value="${customerToRoomPage.buildingId }"/>
				  <input id="roomId" name="roomId" type="hidden" value="${customerToRoomPage.roomId }"/>
				  <input id="crStatus" name="crStatus" type="hidden" value="1"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">入住编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 	readonly="true"	validType="customer_to_room,no,id" datatype="*" ignore="checked" value='${customerToRoomPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">合同编号:</label>
			</td>
			<td class="value">
				<input id="contractNo" name="contractNo" type="text" style="width: 150px" class="searchbox-inputtext"  datatype="*" ignore="checked"  onclick="popupClick(this,'customer_id,customer_name,customer_no,contract_no,building_id,building_name,room_id,room_name,contract_type_id','customerId,customerName,customerNo,contractNo,buildingId,buildingName,roomId,roomName,stayinTypeCode','contract_info')"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">合同编号</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
		     	 <input id="customerName" name="customerName" type="text" style="width: 150px" class="inputxt" 		datatype="*" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
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
				<label class="Validform_label">楼栋名称:</label>
			</td>
			<td class="value">
		     	 <input id="buildingName" name="buildingName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">楼栋名称</label>
			</td>
			<td align="right">
				<label class="Validform_label">房间名称:</label>
			</td>
			<td class="value">
		     	 <input id="roomName" name="roomName" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">房间名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">培训状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="trainStatus" type="list"   typeGroupCode="px_status"  defaultVal="1" hasLabel="false"  title="培训状态" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">培训状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">入住类型:</label>
			</td>
			<td class="value">
				<input name="stayinTypeCode" type="hidden" value="${customerToRoomPage.stayinType }" onchange="onStayinTypeChange(this)"/>
					  <t:dictSelect field="stayinType" type="list"   typeGroupCode="si_type"  defaultVal="${customerToRoomPage.stayinType}" hasLabel="false"  title="入住类型" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">入住经办人:</label>
			</td>
			<td class="value">
		     	 <input id="inCharge" name="inCharge" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${user.realName}"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住经办人</label>
			</td>
			<td align="right">
				<label class="Validform_label">入住时间:</label>
			</td>
			<td class="value">
					  <input id="inDate" name="inDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">入住时间</label>
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
				 <t:tab href="customerToRoomController.do?checkListDesList&id=${customerToRoomPage.id}" icon="icon-search" title="入住检查" id="checkListDes"></t:tab>
				 <t:tab href="customerToRoomController.do?customerTrainInfoList&id=${customerToRoomPage.id}" icon="icon-search" title="入住培训" id="customerTrainInfo"></t:tab>
				 <t:tab href="customerToRoomController.do?customerRoomDesList&id=${customerToRoomPage.id}" icon="icon-search" title="入住情况" id="customerRoomDes"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_checkListDes_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="checkListDesList[#index#].checkListName" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
				  </td>
				  <td align="left">
					  	<input name="checkListDesList[#index#].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">归属</label>
				  </td>
				  <td align="left">
					  	<input name="checkListDesList[#index#].description" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  	<input name="checkListDesList[#index#].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">检查人</label>
				  </td>
				  <td align="left">
							<input name="checkListDesList[#index#].endDete" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">完成时间</label>
				  </td>
				  <td align="left">
										<input type="hidden" id="checkListDesList[#index#].attribute" name="checkListDesList[#index#].attribute" />
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkListDesList\\[#index#\\]\\.attribute')"/>
										<a  target="_blank" id="checkListDesList[#index#].attribute_href"></a>
					  <label class="Validform_label" style="display: none;">附件</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerTrainInfo_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					      	<input name="customerTrainInfoList[#index#].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">开始时间</label>
				  </td>
				  <td align="left">
					      	<input name="customerTrainInfoList[#index#].endDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">结束时间</label>
				  </td>
				  <td align="left">
					  	<input name="customerTrainInfoList[#index#].trainner" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">主讲人</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerTrainInfoList[#index#].trainType" type="list"    typeGroupCode="px_type"  defaultVal="" hasLabel="false"  title="培训类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">培训类别</label>
				  </td>
				  <td align="left">
					  	<input name="customerTrainInfoList[#index#].des" maxlength="800" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">培训内容</label>
				  </td>
				  <td align="left">
					  	<input name="customerTrainInfoList[#index#].place" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">地点</label>
				  </td>
				  <td align="left">
					  	<input name="customerTrainInfoList[#index#].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerRoomDes_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
					<input name="customerRoomDesList[#index#].customerId" type="hidden"/>
				  <td align="left">
					  		<input name="customerRoomDesList[#index#].customerName" name="customerRoomDesList[#index#].customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*" ignore="checked"  onclick="popupClick(this,'id,name','customerId,customerName','customer_base')"/>
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerRoomDesList[#index#].relationship" type="list"  		datatype="*"  typeGroupCode="qs_type"  defaultVal="" hasLabel="false"  title="亲属关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">亲属关系</label>
				  </td>
				  <td align="left">
					      	<input name="customerRoomDesList[#index#].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">入住时间</label>
				  </td>
				  <td align="left">
					  	<input name="customerRoomDesList[#index#].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/apt/stayin/customerToRoom.js"></script>
	