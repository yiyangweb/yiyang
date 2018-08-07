<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addContractNhChargeListBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delContractNhChargeListBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addContractNhChargeListBtn').bind('click', function(){   
 		 var tr =  $("#add_contractNhChargeList_table_template tr").clone();
	 	 $("#add_contractNhChargeList_table").append(tr);
	 	 resetTrNum('add_contractNhChargeList_table');
	 	 return false;
    });  
	$('#delContractNhChargeListBtn').bind('click', function(){   
      	$("#add_contractNhChargeList_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_contractNhChargeList_table'); 
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
	<a id="addContractNhChargeListBtn" href="#">添加</a> <a id="delContractNhChargeListBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="contractNhChargeList_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费价格
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						用途
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						是否缴费
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_contractNhChargeList_table">
	<%--
	<c:if test="${fn:length(contractNhChargeListList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="contractNhChargeListList[0].id" type="hidden"/>
					<input name="contractNhChargeListList[0].createName" type="hidden"/>
					<input name="contractNhChargeListList[0].createBy" type="hidden"/>
					<input name="contractNhChargeListList[0].createDate" type="hidden"/>
					<input name="contractNhChargeListList[0].updateName" type="hidden"/>
					<input name="contractNhChargeListList[0].updateBy" type="hidden"/>
					<input name="contractNhChargeListList[0].updateDate" type="hidden"/>
					<input name="contractNhChargeListList[0].sysOrgCode" type="hidden"/>
					<input name="contractNhChargeListList[0].sysCompanyCode" type="hidden"/>
					<input name="contractNhChargeListList[0].bpmStatus" type="hidden"/>
					<input name="contractNhChargeListList[0].type" type="hidden"/>
					<input name="contractNhChargeListList[0].belongDept" type="hidden"/>
					<input name="contractNhChargeListList[0].contractNhId" type="hidden"/>
					<input name="contractNhChargeListList[0].chargeTypeId" type="hidden"/>
				  <td align="left">
					  	<input name="contractNhChargeListList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="contract_nh_charge_list,no,contractNhChargeListList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
							 <input  id="contractNhChargeListList[0].name" name="contractNhChargeListList[0].name" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.name }"  		datatype="*" ignore="checked"   onclick="popupClick(this,'name,description,mode','name,description,type','charge_type_one_popup_nh')"/>
					  <label class="Validform_label" style="display: none;">收费名称</label>
					</td>
				  <td align="left">
					  	<input name="contractNhChargeListList[0].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费描述</label>
					</td>
				  <td align="left">
					  	<input name="contractNhChargeListList[0].price" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费价格</label>
					</td>
				  <td align="left">
							<t:dictSelect field="contractNhChargeListList[0].chargePurpose" type="list" 		datatype="*"  typeGroupCode="sf_purpose"  defaultVal="${contractNhChargeListPage.chargePurpose}" hasLabel="false"  title="用途"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">用途</label>
					</td>
				  <td align="left">
							<t:dictSelect field="contractNhChargeListList[0].status" type="list" 		datatype="*"  typeGroupCode="dev_flag"  defaultVal="${contractNhChargeListPage.status}" hasLabel="false"  title="是否缴费"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">是否缴费</label>
					</td>
				  <td align="left">
					  	<input name="contractNhChargeListList[0].remark" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(contractNhChargeListList)  > 0 }">
		<c:forEach items="${contractNhChargeListList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="contractNhChargeListList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="contractNhChargeListList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="contractNhChargeListList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="contractNhChargeListList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="contractNhChargeListList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="contractNhChargeListList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="contractNhChargeListList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="contractNhChargeListList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="contractNhChargeListList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="contractNhChargeListList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="contractNhChargeListList[${stuts.index }].type" type="hidden" value="${poVal.type }"/>
						<input name="contractNhChargeListList[${stuts.index }].belongDept" type="hidden" value="${poVal.belongDept }"/>
						<input name="contractNhChargeListList[${stuts.index }].contractNhId" type="hidden" value="${poVal.contractNhId }"/>
						<input name="contractNhChargeListList[${stuts.index }].chargeTypeId" type="hidden" value="${poVal.chargeTypeId }"/>
				   <td align="left">
					  	<input name="contractNhChargeListList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="contract_nh_charge_list,no,contractNhChargeListList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">收费编号</label>
				   </td>
				   <td align="left">
							 <input  id="contractNhChargeListList[${stuts.index }].name" name="contractNhChargeListList[${stuts.index }].name"  type="text" style="width: 150px" class="searchbox-inputtext"  		datatype="*" ignore="checked"  onclick="popupClick(this,'name,description,mode','name,description,type','charge_type_one_popup_nh')"    value="${poVal.name }" />
					  <label class="Validform_label" style="display: none;">收费名称</label>
				   </td>
				   <td align="left">
					  	<input name="contractNhChargeListList[${stuts.index }].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">收费描述</label>
				   </td>
				   <td align="left">
					  	<input name="contractNhChargeListList[${stuts.index }].price" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked"  value="${poVal.price }"/>
					  <label class="Validform_label" style="display: none;">收费价格</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="contractNhChargeListList[${stuts.index }].chargePurpose" type="list" 		datatype="*"  typeGroupCode="sf_purpose"  defaultVal="${poVal.chargePurpose }" hasLabel="false"  title="用途"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">用途</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="contractNhChargeListList[${stuts.index }].status" type="list" 		datatype="*"  typeGroupCode="dev_flag"  defaultVal="${poVal.status }" hasLabel="false"  title="是否缴费"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">是否缴费</label>
				   </td>
				   <td align="left">
					  	<input name="contractNhChargeListList[${stuts.index }].remark" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
