<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addChargeListServiceBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delChargeListServiceBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addChargeListServiceBtn').bind('click', function(){   
 		 var tr =  $("#add_chargeListService_table_template tr").clone();
	 	 $("#add_chargeListService_table").append(tr);
	 	 resetTrNum('add_chargeListService_table');
	 	 return false;
    });  
	$('#delChargeListServiceBtn').bind('click', function(){   
      	$("#add_chargeListService_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_chargeListService_table'); 
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
	<a id="addChargeListServiceBtn" href="#">添加</a> <a id="delChargeListServiceBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="chargeListService_table">
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
						备注
				  </td>
	</tr>
	<tbody id="add_chargeListService_table">
	<%--
	<c:if test="${fn:length(chargeListServiceList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="chargeListServiceList[0].id" type="hidden"/>
					<input name="chargeListServiceList[0].createName" type="hidden"/>
					<input name="chargeListServiceList[0].createBy" type="hidden"/>
					<input name="chargeListServiceList[0].createDate" type="hidden"/>
					<input name="chargeListServiceList[0].updateName" type="hidden"/>
					<input name="chargeListServiceList[0].updateBy" type="hidden"/>
					<input name="chargeListServiceList[0].updateDate" type="hidden"/>
					<input name="chargeListServiceList[0].sysOrgCode" type="hidden"/>
					<input name="chargeListServiceList[0].sysCompanyCode" type="hidden"/>
					<input name="chargeListServiceList[0].serviceId" type="hidden"/>
				  <td align="left">
					  	<input name="chargeListServiceList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_service,no,chargeListServiceList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
					  	<input name="chargeListServiceList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费名称</label>
					</td>
				  <td align="left">
					  	<input name="chargeListServiceList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费描述</label>
					</td>
				  <td align="left">
					  	<input name="chargeListServiceList[0].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费价格</label>
					</td>
				  <td align="left">
							<t:dictSelect field="chargeListServiceList[0].mode" type="list"   typeGroupCode="sf_mode"  defaultVal="${chargeListServicePage.mode}" hasLabel="false"  title="收费模式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费模式</label>
					</td>
				  <td align="left">
					  	<input name="chargeListServiceList[0].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(chargeListServiceList)  > 0 }">
		<c:forEach items="${chargeListServiceList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="chargeListServiceList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="chargeListServiceList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="chargeListServiceList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="chargeListServiceList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="chargeListServiceList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="chargeListServiceList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="chargeListServiceList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="chargeListServiceList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="chargeListServiceList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="chargeListServiceList[${stuts.index }].serviceId" type="hidden" value="${poVal.serviceId }"/>
					    <input name="chargeListServiceList[${stuts.index }].mode" type="hidden" value="${poVal.mode }"/>
				   <td align="left">
					  	<input name="chargeListServiceList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_service,no,chargeListServiceList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">收费编号</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListServiceList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">收费名称</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListServiceList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">收费描述</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListServiceList[${stuts.index }].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.unitPrice }"/>
					  <label class="Validform_label" style="display: none;">收费价格</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListServiceList[${stuts.index }].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
