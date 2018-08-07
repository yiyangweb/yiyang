<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>收费单</title>
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
	 <script src = "webpage/com/buss/apt/feebill/feeBill.js"></script>
 </head>
 <body style="overflow-x: hidden;">
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" tiptype="1" action="feeBillController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${feeBillPage.id }"/>
	  				<input id="customerNo" name="customerNo" type="hidden" value="${feeBillPage.customerNo }"/>
                    <input id="fbStatus" name="fbStatus" type="hidden" value="1"/>
				    <input id="feeOriginType" name="feeOriginType" type="hidden" value="${feeBillPage.feeOriginType }"/>
				    <input id="feeOriginId" name="feeOriginId" type="hidden" value="${feeBillPage.feeOriginId }"/>
	<table cellpadding="0" cellspacing="1" class="formtable">
		<tr>
			<td align="right">
				<label class="Validform_label">收费单编号:</label>
			</td>
			<td class="value">
		     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="fee_bill,no,id" datatype="*" ignore="checked" value='${feeBillPage.no}'/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收费单编号</label>
			</td>
			<td align="right">
				<label class="Validform_label">费用单名称:</label>
			</td>
			<td class="value">
		     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">费用单名称</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">顾客姓名:</label>
			</td>
			<td class="value">
				<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'no,name','customerNo,customerName','customer_base')"/>			 
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">顾客姓名</label>
			</td>
			<td align="right">
				<label class="Validform_label">费用小计:</label>
			</td>
			<td class="value">
		     	 <input id="totalFee" name="totalFee" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">费用小计</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">属于:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="belongTo" type="list"   typeGroupCode="cs_status"  defaultVal="${feeBillPage.belongTo}" hasLabel="false"  title="属于" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">属于</label>
			</td>
			<td align="right">
				<label class="Validform_label">收费部门:</label>
			</td>
			<td class="value">
					  <t:dictSelect field="belongDept" type="list"   dictTable="t_s_depart" dictField="org_code" dictText="departname"  defaultVal="${feeBillPage.belongDept}" hasLabel="false"  title="收费部门" ></t:dictSelect>     
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收费部门</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">收费人:</label>
			</td>
			<td class="value">
		     	 <input id="charger" name="charger" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收费人</label>
			</td>
			<td align="right">
				<label class="Validform_label">收费时间:</label>
			</td>
			<td class="value">
					  <input id="dealDate" name="dealDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">收费时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核人:</label>
			</td>
			<td class="value">
		     	 <input id="auditor" name="auditor" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value="${user.realName}"/>
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核人</label>
			</td>
			<td align="right">
				<label class="Validform_label">审核时间:</label>
			</td>
			<td class="value">
					  <input id="auditorDate" name="auditorDate" type="text" style="width: 150px"  class="Wdate" onClick="WdatePicker()"  ignore="ignore"  />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核时间</label>
			</td>
		</tr>
		<tr>
			<td align="right">
				<label class="Validform_label">审核内容:</label>
			</td>
			<td class="value">
		     	 <input id="auditorDes" name="auditorDes" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
				<span class="Validform_checktip"></span>
				<label class="Validform_label" style="display: none;">审核内容</label>
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
				 <t:tab href="feeBillController.do?customerFeeDesList&id=${feeBillPage.id}" icon="icon-search" title="收费详细" id="customerFeeDes"></t:tab>
				 <t:tab href="feeBillController.do?paymentListList&id=${feeBillPage.id}" icon="icon-search" title="缴费情况" id="paymentList"></t:tab>
				</t:tabs>
			</div>
			</t:formvalid>
			<!-- 添加 附表明细 模版 -->
	<table style="display:none">
	<tbody id="add_customerFeeDes_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  		<input name="customerFeeDesList[#index#].customerNo" name="customerFeeDesList[#index#].customerNo" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'no,name','customerNo,customerName','customer_base')"/>
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].chargeNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_fee_des,charge_no,customerFeeDesList[#index#].id" datatype="*" ignore="checked" />
					  <label class="Validform_label" style="display: none;">收费编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[#index#].chargeName" type="list"    dictTable="charge_type" dictField="id" dictText="name"  defaultVal="" hasLabel="false"  title="收费项目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费项目</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">费用</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[#index#].chargePurpose" type="list"    typeGroupCode="sf_purpose"  defaultVal="" hasLabel="false"  title="收费用途"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费用途</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[#index#].belongTo" type="list"    typeGroupCode="cs_status"  defaultVal="" hasLabel="false"  title="属于"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">属于</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].feeDes" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费说明</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].countPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">计费人</label>
				  </td>
				  <td align="left">
					      	<input name="customerFeeDesList[#index#].countDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">生成时间</label>
				  </td>
				  <td align="left">
					  	<input name="customerFeeDesList[#index#].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费人</label>
				  </td>
				  <td align="left">
					      	<input name="customerFeeDesList[#index#].chargeDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收费日期</label>
				  </td>
			</tr>
		 </tbody>
	<tbody id="add_paymentList_table_template">
		<tr>
			 <td align="center"><div style="width: 25px;" name="xh"></div></td>
			 <td align="center"><input style="width:20px;" type="checkbox" name="ck"/></td>
				  <td align="left">
					  	<input name="paymentListList[#index#].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">缴费编号</label>
				  </td>
				  <td align="left">
							<t:dictSelect field="paymentListList[#index#].payWay" type="list"    typeGroupCode="zf_model"  defaultVal="" hasLabel="false"  title="支付途径"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付途径</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].paySubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付方</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].payAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付账号</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].money" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">金额</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].receiveSubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收款方</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].receiveAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">收款账号</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].payDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">支付时间</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].receiveDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;" ignore="ignore" />
					  <label class="Validform_label" style="display: none;">到账时间</label>
				  </td>
				  <td align="left">
					  	<input name="paymentListList[#index#].remarks" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" />
					  <label class="Validform_label" style="display: none;">备注</label>
				  </td>
			</tr>
		 </tbody>
		</table>
 </body>
	