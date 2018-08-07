<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerCommonChargeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerCommonChargeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerCommonChargeBtn').bind('click', function(){   
 		 var tr =  $("#add_customerCommonCharge_table_template tr").clone();
	 	 $("#add_customerCommonCharge_table").append(tr);
	 	 resetTrNum('add_customerCommonCharge_table');
	 	 return false;
    });  
	$('#delCustomerCommonChargeBtn').bind('click', function(){   
      	$("#add_customerCommonCharge_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerCommonCharge_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addCustomerCommonChargeBtn" href="#">添加</a> <a id="delCustomerCommonChargeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerCommonCharge_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						价格
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						模式
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						生效时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						截止时间
				  </td>
	</tr>
	<tbody id="add_customerCommonCharge_table">
	<%--
	<c:if test="${fn:length(customerCommonChargeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerCommonChargeList[0].id" type="hidden"/>
					<input name="customerCommonChargeList[0].createName" type="hidden"/>
					<input name="customerCommonChargeList[0].createBy" type="hidden"/>
					<input name="customerCommonChargeList[0].createDate" type="hidden"/>
					<input name="customerCommonChargeList[0].updateName" type="hidden"/>
					<input name="customerCommonChargeList[0].updateBy" type="hidden"/>
					<input name="customerCommonChargeList[0].updateDate" type="hidden"/>
					<input name="customerCommonChargeList[0].sysOrgCode" type="hidden"/>
					<input name="customerCommonChargeList[0].sysCompanyCode" type="hidden"/>
					<input name="customerCommonChargeList[0].status" type="hidden"/>
					<input name="customerCommonChargeList[0].belongDept" type="hidden"/>
					<input name="customerCommonChargeList[0].customerId" type="hidden"/>
					<input name="customerCommonChargeList[0].originId" type="hidden"/>
					<input name="customerCommonChargeList[0].originName" type="hidden"/>
				  <td align="left">
					  	<input name="customerCommonChargeList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_common_charge,no,customerCommonChargeList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">编号</label>
					</td>
				  <td align="left">
							 <input  id="customerCommonChargeList[0].chargeNo" name="customerCommonChargeList[0].chargeNo" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.chargeNo }"   ignore="checked"   onclick="popupClick(this,'charge_no,name,description,mode,belong_dept','no,name,description,mode,belongdeptcode','charge_type_not_one_pop')"/> 			 
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
					  	<input name="customerCommonChargeList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费项目</label>
					</td>
				  <td align="left">
					  	<input name="customerCommonChargeList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					  	<input name="customerCommonChargeList[0].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">价格</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerCommonChargeList[0].mode" type="list"   typeGroupCode="sf_mode"  defaultVal="${customerCommonChargePage.mode}" hasLabel="false"  title="模式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">模式</label>
					</td>
				  <td align="left">
							<input name="customerCommonChargeList[0].beginDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">生效时间</label>
					</td>
				  <td align="left">
							<input name="customerCommonChargeList[0].endDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">截止时间</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerCommonChargeList)  > 0 }">
		<c:forEach items="${customerCommonChargeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerCommonChargeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerCommonChargeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerCommonChargeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerCommonChargeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerCommonChargeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerCommonChargeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerCommonChargeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerCommonChargeList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerCommonChargeList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerCommonChargeList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="customerCommonChargeList[${stuts.index }].belongDept" type="hidden" value="${poVal.belongDept }"/>
						<input name="customerCommonChargeList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
						<input name="customerCommonChargeList[${stuts.index }].originId" type="hidden" value="${poVal.originId }"/>
						<input name="customerCommonChargeList[${stuts.index }].originName" type="hidden" value="${poVal.originName }"/>
                        <input name="customerCommonChargeList[${stuts.index }].chargeNo" type="hidden" value="${poVal.chargeNo }"/>
				   <td align="left">
					  	<input name="customerCommonChargeList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_common_charge,no,customerCommonChargeList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">编号</label>
				   </td>
				   <td align="left">
							 <input  id="customerCommonChargeList[${stuts.index }].chargeNo" name="customerCommonChargeList[${stuts.index }].chargeNo"  type="text" style="width: 150px" class="searchbox-inputtext" datatype="*"  ignore="checked"  onclick="popupClick(this,'no,name,description,mode,belongdeptcode','chargeNo,name,description,modeCode,belongDept','charge_type_not_one_pop')"    value="${poVal.chargeNo }" />
					  <label class="Validform_label" style="display: none;">收费类型编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerCommonChargeList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="*" ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">收费项目</label>
				   </td>
				   <td align="left">
					  	<input name="customerCommonChargeList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;" ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					  	<input name="customerCommonChargeList[${stuts.index }].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;" datatype="*" ignore="checked"  value="${poVal.unitPrice }"/>
					  <label class="Validform_label" style="display: none;">价格</label>
				   </td>
				   <td align="left">
                            <input name="customerCommonChargeList[${stuts.index }].modeCode" type="hidden" value="${poVal.mode }" onchange="onModeChange(this)"/>
							<t:dictSelect id="dictSelectMode${stuts.index }" field="customerCommonChargeList[${stuts.index }].mode" type="list"   typeGroupCode="sf_mode" datatype="*" defaultVal="${poVal.mode }" hasLabel="false"  title="模式"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">模式</label>
				   </td>
				   <td align="left">
							<input name="customerCommonChargeList[${stuts.index }].beginDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" datatype="*"  ignore="checked"  value="<fmt:formatDate value='${poVal.beginDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">生效时间</label>
				   </td>
				   <td align="left">
							<input name="customerCommonChargeList[${stuts.index }].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;" datatype="*"  ignore="checked"  value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">截止时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
