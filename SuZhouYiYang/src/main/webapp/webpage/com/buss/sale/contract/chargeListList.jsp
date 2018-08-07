<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addChargeListBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delChargeListBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addChargeListBtn').bind('click', function(){
        if($("select[name='isInstalments']").val().toString() == "1") {
            var tr = $("#add_chargeList_table_template tr").clone();
            $("#add_chargeList_table").append(tr);
            resetTrNum('add_chargeList_table');
            return false;
        }else{
            $.messager.alert("错误","请先选择分期！");
            return false;
		}
    });  
	$('#delChargeListBtn').bind('click', function(){   
      	$("#add_chargeList_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_chargeList_table'); 
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
	<a id="addChargeListBtn" href="#">添加</a> <a id="delChargeListBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="chargeList_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						序号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						生成收费单
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						缴费日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收费描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_chargeList_table">
	<%--
	<c:if test="${fn:length(chargeListList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="chargeListList[0].id" type="hidden"/>
					<input name="chargeListList[0].createName" type="hidden"/>
					<input name="chargeListList[0].createBy" type="hidden"/>
					<input name="chargeListList[0].createDate" type="hidden"/>
					<input name="chargeListList[0].updateName" type="hidden"/>
					<input name="chargeListList[0].updateBy" type="hidden"/>
					<input name="chargeListList[0].updateDate" type="hidden"/>
					<input name="chargeListList[0].sysOrgCode" type="hidden"/>
					<input name="chargeListList[0].sysCompanyCode" type="hidden"/>
					<input name="chargeListList[0].contractId" type="hidden"/>
				  <td align="left">
					  	<input name="chargeListList[0].orderNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">序号</label>
					</td>
				  <td align="left">
					  	<input name="chargeListList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list,no,chargeListList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费编号</label>
					</td>
				  <td align="left">
					  	<input name="chargeListList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费项目</label>
					</td>
				  <td align="left">
					  	<input name="chargeListList[0].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
							<t:dictSelect field="chargeListList[0].isFee" type="list"   typeGroupCode="dev_flag"  defaultVal="${chargeListPage.isFee}" hasLabel="false"  title="生成收费单"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">生成收费单</label>
					</td>
				  <td align="left">
							<input name="chargeListList[0].chargeDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">缴费日期</label>
					</td>
				  <td align="left">
					  	<input name="chargeListList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收费描述</label>
					</td>
				  <td align="left">
					  	<input name="chargeListList[0].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(chargeListList)  > 0 }">
		<c:forEach items="${chargeListList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="chargeListList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="chargeListList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="chargeListList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="chargeListList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="chargeListList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="chargeListList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="chargeListList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="chargeListList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="chargeListList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="chargeListList[${stuts.index }].contractId" type="hidden" value="${poVal.contractId }"/>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].orderNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.orderNo }"/>
					  <label class="Validform_label" style="display: none;">序号</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="charge_list,no,chargeListList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">收费编号</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">收费项目</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].unitPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.unitPrice }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="chargeListList[${stuts.index }].isFee" type="list"   typeGroupCode="dev_flag"  defaultVal="${poVal.isFee }" hasLabel="false"  title="生成收费单"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">生成收费单</label>
				   </td>
				   <td align="left">
							<input name="chargeListList[${stuts.index }].chargeDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.chargeDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">缴费日期</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">收费描述</label>
				   </td>
				   <td align="left">
					  	<input name="chargeListList[${stuts.index }].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
