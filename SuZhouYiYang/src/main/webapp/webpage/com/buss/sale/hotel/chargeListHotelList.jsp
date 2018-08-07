<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addChargeListHotelBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delChargeListHotelBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addChargeListHotelBtn').bind('click', function(){   
 		 var tr =  $("#add_chargeListHotel_table_template tr").clone();
	 	 $("#add_chargeListHotel_table").append(tr);
	 	 resetTrNum('add_chargeListHotel_table');
	 	 return false;
    });  
	$('#delChargeListHotelBtn').bind('click', function(){   
      	$("#add_chargeListHotel_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_chargeListHotel_table'); 
        return false;
    }); 
    $(document).ready(function(){
    	$(".datagrid-toolbar").parent().css("width","auto");
    	if(location.href.indexOf("load=detail")!=-1){
			$(":input").attr("disabled","true");
			$(".datagrid-toolbar").hide();
		}
    });
    function onModeChange(item) {
        var value = item.value;
        var reg = /\[(.*?)\]/g;
        var indexStr = item.name.match(reg)[0];
        var index = indexStr.substring(1,indexStr.length-1);
        $('#dictSelectMode'+index).val(value);
    }
</script>
<div style="padding: 3px; height: 25px;width:auto;" class="datagrid-toolbar">
	<a id="addChargeListHotelBtn" href="#">添加</a> <a id="delChargeListHotelBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="chargeListHotel_table">
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
						价格
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费模式
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费部门名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_chargeListHotel_table">
	<%--
	<c:if test="${fn:length(chargeListHotelList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="chargeListHotelList[0].id" type="hidden"/>
					<input name="chargeListHotelList[0].createName" type="hidden"/>
					<input name="chargeListHotelList[0].createBy" type="hidden"/>
					<input name="chargeListHotelList[0].createDate" type="hidden"/>
					<input name="chargeListHotelList[0].updateName" type="hidden"/>
					<input name="chargeListHotelList[0].updateBy" type="hidden"/>
					<input name="chargeListHotelList[0].updateDate" type="hidden"/>
					<input name="chargeListHotelList[0].sysOrgCode" type="hidden"/>
					<input name="chargeListHotelList[0].sysCompanyCode" type="hidden"/>
					<input name="chargeListHotelList[0].chId" type="hidden"/>
					<input name="chargeListHotelList[0].chargeTypeId" type="hidden"/>
					<input name="chargeListHotelList[0].belongDept" type="hidden"/>
				  <td align="left">
					  	<input name="chargeListHotelList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_hotel,no,chargeListHotelList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
							 <input  id="chargeListHotelList[0].name" name="chargeListHotelList[0].name" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.name }"   ignore="ignore"   onclick="popupClick(this,'no,name','no,name','charge_type_popup')"/> 			 
					  <label class="Validform_label" style="display: none;">收费名称</label>
					</td>
				  <td align="left">
					  	<input name="chargeListHotelList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费描述</label>
					</td>
				  <td align="left">
					  	<input name="chargeListHotelList[0].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">价格</label>
					</td>
				  <td align="left">
							<t:dictSelect field="chargeListHotelList[0].mode" type="list"   typeGroupCode="sf_mode"  defaultVal="${chargeListHotelPage.mode}" hasLabel="false"  title="收费模式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">收费模式</label>
					</td>
				  <td align="left">
					  	<input name="chargeListHotelList[0].belongDeptName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
					</td>
				  <td align="left">
					  	<input name="chargeListHotelList[0].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(chargeListHotelList)  > 0 }">
		<c:forEach items="${chargeListHotelList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="chargeListHotelList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="chargeListHotelList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="chargeListHotelList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="chargeListHotelList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="chargeListHotelList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="chargeListHotelList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="chargeListHotelList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="chargeListHotelList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="chargeListHotelList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="chargeListHotelList[${stuts.index }].chId" type="hidden" value="${poVal.chId }"/>
						<input name="chargeListHotelList[${stuts.index }].chargeTypeId" type="hidden" value="${poVal.chargeTypeId }"/>
						<input name="chargeListHotelList[${stuts.index }].belongDept" type="hidden" value="${poVal.belongDept }"/>
				   <td align="left">
					  	<input name="chargeListHotelList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list_hotel,no,chargeListHotelList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">收费编号</label>
				   </td>
				   <td align="left">
							 <input  id="chargeListHotelList[${stuts.index }].name" name="chargeListHotelList[${stuts.index }].name"  type="text" style="width: 150px" class="searchbox-inputtext"   ignore="ignore"  onclick="popupClick(this,'chargetypeid,name,description,mode,remark,belongdeptcode,belongdeptname','chargeTypeId,name,description,modeCode,remark,belongDept,belongDeptName','charge_type_one_popup')"    value="${poVal.name }" />
					  <label class="Validform_label" style="display: none;">收费名称</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListHotelList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">收费描述</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListHotelList[${stuts.index }].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.unitPrice }"/>
					  <label class="Validform_label" style="display: none;">价格</label>
				   </td>
				   <td align="left">
                       <input name="chargeListHotelList[${stuts.index }].modeCode" maxlength="32" type="hidden" class="inputxt"  style="width:120px;"  ignore="ignore" value="${poVal.mode }" onchange="onModeChange(this)"/>
                       <t:dictSelect id="dictSelectMode${stuts.index }" field="chargeListHotelList[${stuts.index }].mode" type="list"   typeGroupCode="sf_mode"  defaultVal="${poVal.mode }" hasLabel="false"  title="收费模式"></t:dictSelect>
					  <label class="Validform_label" style="display: none;">收费模式</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListHotelList[${stuts.index }].belongDeptName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.belongDeptName }"/>
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListHotelList[${stuts.index }].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
