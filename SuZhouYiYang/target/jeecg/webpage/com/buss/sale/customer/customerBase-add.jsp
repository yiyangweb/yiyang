<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>客户信息</title>
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
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="customerBaseController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${customerBasePage.id }"/>
	  				<input id="customerStatus" name="customerStatus" type="hidden" value="1"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">客户编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 	readonly="true"	validType="customer_base,no,id" datatype="*" ignore="ignore" value='${customerBasePage.no}' />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户姓名:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt" 		datatype="*1-32" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户姓名</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">身份证号:</label>
			</td>
			<td class="value">
		     	 <input id="idCardNo" name="idCardNo" type="text" style="width: 150px" class="inputxt" 		datatype="*18-18" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">身份证号</label>
			</td>
			<td align="right">
				<label class="Validform_label">性别:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="sex" type="list"   typeGroupCode="c_sex"  defaultVal="${customerBasePage.sex}" hasLabel="false"  title="性别" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">性别</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">年龄:</label>
			</td>
			<td class="value">
		     	 <input id="age" name="age" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="checked" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">年龄</label>
			</td>
			<td align="right">
				<label class="Validform_label">客户从属:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="belongTo" type="list" 		datatype="*"  typeGroupCode="cs_status"  defaultVal="${customerBasePage.belongTo}" hasLabel="false"  title="客户从属" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">客户从属</label>
			</td>
		</tr>
	
	</table>
			<div style="width: auto;height: 200px;">
				<%-- 增加一个div，用于调节页面大小，否则默认太小 --%>
				<div style="width:800px;height:1px;"></div>
				<t:tabs id="tt" iframe="false" tabPosition="top" fit="false">
				 <t:tab href="customerBaseController.do?customerProfileList&id=${customerBasePage.id}" icon="icon-search" title="详细信息" id="customerProfile"></t:tab>
				 <t:tab href="customerBaseController.do?customerRelativesList&id=${customerBasePage.id}" icon="icon-search" title="亲属关系" id="customerRelatives"></t:tab>
				 <t:tab href="customerBaseController.do?customerEducatioinList&id=${customerBasePage.id}" icon="icon-search" title="教育情况" id="customerEducatioin"></t:tab>
				 <t:tab href="customerBaseController.do?customerJobList&id=${customerBasePage.id}" icon="icon-search" title="工作经历" id="customerJob"></t:tab>
				 <t:tab href="customerBaseController.do?customerCommonChargeList&id=${customerBasePage.id}" icon="icon-search" title="周期收费" id="customerCommonCharge"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_customerProfile_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
							<input name="customerProfileList[#index#].birthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"		datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">阳历生日</label>
				  </td>
				  <td align="left">
							<input name="customerProfileList[#index#].lunarBirthDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">阴历生日</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].mateName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">配偶姓名</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].lifeHabit" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">生活习惯</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].cellPhone" maxlength="15" type="text" class="inputxt"  style="width:120px;" 		datatype="m" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">手机号码</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].telephone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">固定电话</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].email" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">邮箱</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].language" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">语言</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].vehicle" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">交通工具</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].registerAddress" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">户籍地址</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].subDistrict" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">所属街道</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].liveAddress" maxlength="100" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">居住地址</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].company" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">公司</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].job" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职业</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].educatioin" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">教育程度</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].olderLiveInfo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">居住情况</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].urgentContact" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">紧急联系人</label>
				  </td>
				  <td align="left">
					  	<input name="customerProfileList[#index#].contactPhone" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">电话</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerRelatives_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="customerRelativesList[#index#].name" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-32" ignore="checked" />
					  <label class="Validform_label" style="display: none;">名字</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerRelativesList[#index#].sex" type="list"    typeGroupCode="sex"  defaultVal="" hasLabel="false"  title="性别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">性别</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerRelativesList[#index#].relationType" type="list"    typeGroupCode="qs_type"  defaultVal="" hasLabel="false"  title="相对关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">相对关系</label>
				  </td>
				  <td align="left">
					  	<input name="customerRelativesList[#index#].phoneNo" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">联系电话</label>
				  </td>
				  <td align="left">
					  	<input name="customerRelativesList[#index#].email" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">邮箱</label>
				  </td>
				  <td align="left">
					  	<input name="customerRelativesList[#index#].adress" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">住址</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerEducatioin_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="customerEducatioinList[#index#].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">起止时间</label>
				  </td>
				  <td align="left">
					  	<input name="customerEducatioinList[#index#].schedule" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-100" ignore="checked" />
					  <label class="Validform_label" style="display: none;">学校</label>
				  </td>
				  <td align="left">
					  	<input name="customerEducatioinList[#index#].major" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">专业</label>
				  </td>
				  <td align="left">
					  	<input name="customerEducatioinList[#index#].education" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">学历</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerJob_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="customerJobList[#index#].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">起止时间</label>
				  </td>
				  <td align="left">
					  	<input name="customerJobList[#index#].company" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-100" ignore="checked" />
					  <label class="Validform_label" style="display: none;">单位</label>
				  </td>
				  <td align="left">
					  	<input name="customerJobList[#index#].companyType" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">单位性质</label>
				  </td>
				  <td align="left">
					  	<input name="customerJobList[#index#].position" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">职位</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_customerCommonCharge_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="customerCommonChargeList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_common_charge,no,customerCommonChargeList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">编号</label>
				  </td>
				  <td align="left">
					  		<input name="customerCommonChargeList[#index#].chargeNo" name="customerCommonChargeList[#index#].chargeNo" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="checked"  onclick="popupClick(this,'no,name,description,mode,belongdeptcode','chargeNo,name,description,modeCode,belongDept','charge_type_not_one_pop')"/>
					  <label class="Validform_label" style="display: none;">收费类型编号</label>
				  </td>
				  <td align="left">
					  	<input name="customerCommonChargeList[#index#].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费项目</label>
				  </td>
				  <td align="left">
					  	<input name="customerCommonChargeList[#index#].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">描述</label>
				  </td>
				  <td align="left">
					  	<input name="customerCommonChargeList[#index#].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" />
					  <label class="Validform_label" style="display: none;">价格</label>
				  </td>
				  <td align="left">
					  		<input name="customerCommonChargeList[#index#].modeCode" type="hidden" onchange="onModeChange(this)"/>
							<t:dictSelect id="dictSelectMode#index" field="customerCommonChargeList[#index#].mode" type="list"    typeGroupCode="sf_mode"  defaultVal="" hasLabel="false"  title="模式"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">模式</label>
				  </td>
				  <td align="left">
							<input name="customerCommonChargeList[#index#].beginDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="checked" />
					  <label class="Validform_label" style="display: none;">生效时间</label>
				  </td>
				  <td align="left">
							<input name="customerCommonChargeList[#index#].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" ignore="checked" />
					  <label class="Validform_label" style="display: none;">截止时间</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
 <script src = "webpage/com/buss/sale/customer/customerBase.js"></script>
	