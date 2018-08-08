<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerJobBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerJobBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerJobBtn').bind('click', function(){   
 		 var tr =  $("#add_customerJob_table_template tr").clone();
	 	 $("#add_customerJob_table").append(tr);
	 	 resetTrNum('add_customerJob_table');
	 	 return false;
    });  
	$('#delCustomerJobBtn').bind('click', function(){   
      	$("#add_customerJob_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerJob_table'); 
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
	<a id="addCustomerJobBtn" href="#">添加</a> <a id="delCustomerJobBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerJob_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						起止时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单位性质
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						职位
				  </td>
	</tr>
	<tbody id="add_customerJob_table">
	<%--
	<c:if test="${fn:length(customerJobList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerJobList[0].id" type="hidden"/>
					<input name="customerJobList[0].createName" type="hidden"/>
					<input name="customerJobList[0].createBy" type="hidden"/>
					<input name="customerJobList[0].createDate" type="hidden"/>
					<input name="customerJobList[0].updateName" type="hidden"/>
					<input name="customerJobList[0].updateBy" type="hidden"/>
					<input name="customerJobList[0].updateDate" type="hidden"/>
					<input name="customerJobList[0].sysOrgCode" type="hidden"/>
					<input name="customerJobList[0].sysCompanyCode" type="hidden"/>
					<input name="customerJobList[0].customerId" type="hidden"/>
				  <td align="left">
					  	<input name="customerJobList[0].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">起止时间</label>
					</td>
				  <td align="left">
					  	<input name="customerJobList[0].company" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*6-16" ignore="checked" >
					  <label class="Validform_label" style="display: none;">单位</label>
					</td>
				  <td align="left">
					  	<input name="customerJobList[0].companyType" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单位性质</label>
					</td>
				  <td align="left">
					  	<input name="customerJobList[0].position" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">职位</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerJobList)  > 0 }">
		<c:forEach items="${customerJobList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerJobList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerJobList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerJobList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerJobList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerJobList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerJobList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerJobList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerJobList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerJobList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerJobList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
				   <td align="left">
					  	<input name="customerJobList[${stuts.index }].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.beginEndDate }"/>
					  <label class="Validform_label" style="display: none;">起止时间</label>
				   </td>
				   <td align="left">
					  	<input name="customerJobList[${stuts.index }].company" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-100" ignore="checked"  value="${poVal.company }"/>
					  <label class="Validform_label" style="display: none;">单位</label>
				   </td>
				   <td align="left">
					  	<input name="customerJobList[${stuts.index }].companyType" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.companyType }"/>
					  <label class="Validform_label" style="display: none;">单位性质</label>
				   </td>
				   <td align="left">
					  	<input name="customerJobList[${stuts.index }].position" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.position }"/>
					  <label class="Validform_label" style="display: none;">职位</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
