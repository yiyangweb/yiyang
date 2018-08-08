<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerFeeDesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerFeeDesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerFeeDesBtn').bind('click', function(){   
 		 var tr =  $("#add_customerFeeDes_table_template tr").clone();
	 	 $("#add_customerFeeDes_table").append(tr);
	 	 resetTrNum('add_customerFeeDes_table');
	 	 return false;
    });  
	$('#delCustomerFeeDesBtn').bind('click', function(){   
      	$("#add_customerFeeDes_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerFeeDes_table'); 
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
	<a id="addCustomerFeeDesBtn" href="#">添加</a> <a id="delCustomerFeeDesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerFeeDes_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客姓名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费用途
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						属于
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费说明
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						计费人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						生成时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费日期
				  </td>
	</tr>
	<tbody id="add_customerFeeDes_table">
	<%--
	<c:if test="${fn:length(customerFeeDesList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerFeeDesList[0].id" type="hidden"/>
					<input name="customerFeeDesList[0].createName" type="hidden"/>
					<input name="customerFeeDesList[0].createBy" type="hidden"/>
					<input name="customerFeeDesList[0].createDate" type="hidden"/>
					<input name="customerFeeDesList[0].updateName" type="hidden"/>
					<input name="customerFeeDesList[0].updateBy" type="hidden"/>
					<input name="customerFeeDesList[0].updateDate" type="hidden"/>
					<input name="customerFeeDesList[0].sysOrgCode" type="hidden"/>
					<input name="customerFeeDesList[0].sysCompanyCode" type="hidden"/>
					<input name="customerFeeDesList[0].fdStatus" type="hidden"/>
					<input name="customerFeeDesList[0].feeDate" type="hidden"/>
					<input name="customerFeeDesList[0].feeOriginId" type="hidden"/>
					<input name="customerFeeDesList[0].feeBillId" type="hidden"/>
				  <td align="left">
							 <input  id="customerFeeDesList[0].customerNo" name="customerFeeDesList[0].customerNo" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.customerNo }"   ignore="ignore"   onclick="popupClick(this,'no,name','customerNo,customerName','customer_base')"/> 			 
					  <label class="Validform_label" style="display: none;">顾客编号</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].chargeNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_fee_des,charge_no,customerFeeDesList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[0].chargeName" type="list"   dictTable="charge_type" dictField="id" dictText="name"  defaultVal="${customerFeeDesPage.chargeName}" hasLabel="false"  title="收费项目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费项目</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">费用</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[0].chargePurpose" type="list"   typeGroupCode="sf_purpose"  defaultVal="${customerFeeDesPage.chargePurpose}" hasLabel="false"  title="收费用途"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费用途</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerFeeDesList[0].belongTo" type="list"   typeGroupCode="cs_status"  defaultVal="${customerFeeDesPage.belongTo}" hasLabel="false"  title="属于"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">属于</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].feeDes" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费说明</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].countPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">计费人</label>
					</td>
				  <td align="left">
					      	<input name="customerFeeDesList[0].countDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">生成时间</label>
					</td>
				  <td align="left">
					  	<input name="customerFeeDesList[0].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费人</label>
					</td>
				  <td align="left">
					      	<input name="customerFeeDesList[0].chargeDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费日期</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerFeeDesList)  > 0 }">
		<c:forEach items="${customerFeeDesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerFeeDesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerFeeDesList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerFeeDesList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerFeeDesList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerFeeDesList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerFeeDesList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerFeeDesList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerFeeDesList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerFeeDesList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerFeeDesList[${stuts.index }].fdStatus" type="hidden" value="${poVal.fdStatus }"/>
						<input name="customerFeeDesList[${stuts.index }].feeDate" type="hidden" value="${poVal.feeDate }"/>
						<input name="customerFeeDesList[${stuts.index }].feeOriginId" type="hidden" value="${poVal.feeOriginId }"/>
						<input name="customerFeeDesList[${stuts.index }].feeBillId" type="hidden" value="${poVal.feeBillId }"/>
				   <td align="left">
							 <input  id="customerFeeDesList[${stuts.index }].customerNo" name="customerFeeDesList[${stuts.index }].customerNo"  type="text" style="width: 150px" class="searchbox-inputtext"   ignore="ignore"  onclick="popupClick(this,'no,name','customerNo,customerName','customer_base')"    value="${poVal.customerNo }" /> 			 
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerName }"/>
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].chargeNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_fee_des,charge_no,customerFeeDesList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.chargeNo }"/>
					  <label class="Validform_label" style="display: none;">收费编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerFeeDesList[${stuts.index }].chargeName" type="list"   dictTable="charge_type" dictField="id" dictText="name"  defaultVal="${poVal.chargeName }" hasLabel="false"  title="收费项目"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费项目</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].fee" maxlength="32" type="text" class="inputxt"  style="width:120px;"  datatype="/^(-?\d+)(\.\d+)?$/"  ignore="ignore"  value="${poVal.fee }"/>
					  <label class="Validform_label" style="display: none;">费用</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerFeeDesList[${stuts.index }].chargePurpose" type="list"   typeGroupCode="sf_purpose"  defaultVal="${poVal.chargePurpose }" hasLabel="false"  title="收费用途"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费用途</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerFeeDesList[${stuts.index }].belongTo" type="list"   typeGroupCode="cs_status"  defaultVal="${poVal.belongTo }" hasLabel="false"  title="属于"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">属于</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].feeDes" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.feeDes }"/>
					  <label class="Validform_label" style="display: none;">收费说明</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].countPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.countPerson }"/>
					  <label class="Validform_label" style="display: none;">计费人</label>
				   </td>
				   <td align="left">
					      	<input name="customerFeeDesList[${stuts.index }].countDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore"  value="<fmt:formatDate value='${poVal.countDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">生成时间</label>
				   </td>
				   <td align="left">
					  	<input name="customerFeeDesList[${stuts.index }].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.charger }"/>
					  <label class="Validform_label" style="display: none;">收费人</label>
				   </td>
				   <td align="left">
					      	<input name="customerFeeDesList[${stuts.index }].chargeDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore"  value="<fmt:formatDate value='${poVal.chargeDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">收费日期</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
