<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>来访者登记信息</title>
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
	 <script src = "webpage/com/buss/sale/visit/mmVisitorRecord.js"></script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="mmVisitorRecordController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${mmVisitorRecordPage.id }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">来访编号:</label>
			</td>
			<td class="value">
		     	 <input id="recordNo" name="recordNo" type="text" style="width: 150px" class="inputxt" 	readonly="true"	validType="mm_visitor_record,record_no,id" datatype="*" ignore="ignore" value='${mmVisitorRecordPage.recordNo}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">来访编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户姓名:</label>
			</td>
			<td class="value">
				<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext" 		datatype="*1-32" ignore="checked"  onclick="popupClick(this,'name,no,sex,age','customerName,customerNo,sexId,age','customer_base')"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="customerNo" name="customerNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
				<input name="sexId" type="hidden" value="${mmVisitorRecordPage.sex }" onchange="onSexChange(this)"/>
					  <t:dictSelect id="sexId" field="sex" type="list"   typeGroupCode="c_sex"  defaultVal="${mmVisitorRecordPage.sex}" hasLabel="false"  title="性别" ></t:dictSelect>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">年龄:</label>
			</td>
			<td class="value">
		     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">年龄</label>
			</td>
			<td align="right">
				<label class="Validform_label">联系方式:</label>
			</td>
			<td class="value">
		     	 <input id="phoneNo" name="phoneNo" type="text" style="width: 150px" class="inputxt" 		datatype="m" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系方式</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">联系地址:</label>
			</td>
			<td class="value">
		     	 <input id="adress" name="adress" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">联系地址</label>
			</td>
			<td align="right">
				<label class="Validform_label">获知渠道:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="learnChannel" type="list"   typeGroupCode="learn_type"  defaultVal="${mmVisitorRecordPage.learnChannel}" hasLabel="false"  title="获知渠道" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">获知渠道</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">介绍人:</label>
			</td>
			<td class="value">
		     	 <input id="introducer" name="introducer" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">介绍人</label>
			</td>
			<td align="right">
				<label class="Validform_label">需求类型:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="requirementType" type="list"   typeGroupCode="cs_status"  defaultVal="${mmVisitorRecordPage.requirementType}" hasLabel="false"  title="需求类型" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">需求类型</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">意向等级:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="intentionLevel" type="list"   typeGroupCode="yx_level"  defaultVal="${mmVisitorRecordPage.intentionLevel}" hasLabel="false"  title="意向等级" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">意向等级</label>
			</td>
			<td align="right">
				<label class="Validform_label">意向金:</label>
			</td>
			<td class="value">
		     	 <input id="intentionalGold" name="intentionalGold" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">意向金</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">来访状态:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="visitStatus" type="list"   typeGroupCode="lf_status"  defaultVal="${mmVisitorRecordPage.visitStatus}" hasLabel="false"  title="来访状态" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">来访状态</label>
			</td>
			<td align="right">
				<label class="Validform_label">来访次数:</label>
			</td>
			<td class="value">
		     	 <input id="visitNum" name="visitNum" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">来访次数</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">健康状况:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="health" type="list"   typeGroupCode="jk_status"  defaultVal="${mmVisitorRecordPage.health}" hasLabel="false"  title="健康状况" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">健康状况</label>
			</td>
			<td align="right">
				<label class="Validform_label">关注点:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="focus" type="checkbox"   typeGroupCode="focus_type"  defaultVal="${mmVisitorRecordPage.focus}" hasLabel="false"  title="关注点" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">关注点</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">其他:</label>
			</td>
			<td class="value">
		     	 <input id="others" name="others" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">其他</label>
			</td>
			<td align="right">
				<label class="Validform_label">兴趣爱好:</label>
			</td>
			<td class="value">
		     	 <input id="interests" name="interests" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">兴趣爱好</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">特殊要求:</label>
			</td>
			<td class="value">
		     	 <input id="specialRequirements" name="specialRequirements" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">特殊要求</label>
			</td>
			<td align="right">
				<label class="Validform_label">业务接待:</label>
			</td>
			<td class="value">
		     	 <input id="destClerk" name="destClerk" type="text" style="width: 150px" class="inputxt" 	value="${user.realName}"	datatype="*1-32" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">业务接待</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">登记日期:</label>
			</td>
			<td class="value">
					  <input id="vsitDate" name="vsitDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="checked"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">登记日期</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="mmVisitorRecordController.do?mmVisitorReturnList&id=${mmVisitorRecordPage.id}" icon="icon-search" title="回访记录" id="mmVisitorReturn"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_mmVisitorReturn_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[#index#].returnNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="mm_visitor_return,return_no,mmVisitorReturnList[#index#].id" datatype="*" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">回访编号</label>
				  </td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[#index#].visitor" maxlength="50" type="text" class="inputxt"  style="width:120px;" value="${mmVisitorRecordPage.customerName}"	datatype="*1-32" ignore="checked" />
					  <label class="Validform_label" style="display: none;">被访客户</label>
				  </td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[#index#].place" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">回访地点</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="mmVisitorReturnList[#index#].visitType" type="list"  		datatype="*"  typeGroupCode="hf_type"  defaultVal="" hasLabel="false"  title="回访方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">回访方式</label>
				  </td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[#index#].visitDetail" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">回访详情</label>
				  </td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[#index#].revisit" maxlength="32" type="text" class="inputxt"  style="width:120px;" 	value='${mmVisitorRecordPage.destClerk}'	datatype="*1-32" ignore="checked" />
					  <label class="Validform_label" style="display: none;">回访人</label>
				  </td>
				  <td align="left">
							<input name="mmVisitorReturnList[#index#].visitDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="checked" />
					  <label class="Validform_label" style="display: none;">回访时间</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
	