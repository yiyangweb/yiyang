<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerEducatioinBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerEducatioinBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerEducatioinBtn').bind('click', function(){   
 		 var tr =  $("#add_customerEducatioin_table_template tr").clone();
	 	 $("#add_customerEducatioin_table").append(tr);
	 	 resetTrNum('add_customerEducatioin_table');
	 	 return false;
    });  
	$('#delCustomerEducatioinBtn').bind('click', function(){   
      	$("#add_customerEducatioin_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerEducatioin_table'); 
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
	<a id="addCustomerEducatioinBtn" href="#">添加</a> <a id="delCustomerEducatioinBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerEducatioin_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						起止时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						学校
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						专业
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						学历
				  </td>
	</tr>
	<tbody id="add_customerEducatioin_table">
	<%--
	<c:if test="${fn:length(customerEducatioinList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerEducatioinList[0].id" type="hidden"/>
					<input name="customerEducatioinList[0].createName" type="hidden"/>
					<input name="customerEducatioinList[0].createBy" type="hidden"/>
					<input name="customerEducatioinList[0].createDate" type="hidden"/>
					<input name="customerEducatioinList[0].updateName" type="hidden"/>
					<input name="customerEducatioinList[0].updateBy" type="hidden"/>
					<input name="customerEducatioinList[0].updateDate" type="hidden"/>
					<input name="customerEducatioinList[0].sysOrgCode" type="hidden"/>
					<input name="customerEducatioinList[0].sysCompanyCode" type="hidden"/>
					<input name="customerEducatioinList[0].customerId" type="hidden"/>
				  <td align="left">
					  	<input name="customerEducatioinList[0].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">起止时间</label>
					</td>
				  <td align="left">
					  	<input name="customerEducatioinList[0].schedule" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*6-16" ignore="checked" >
					  <label class="Validform_label" style="display: none;">学校</label>
					</td>
				  <td align="left">
					  	<input name="customerEducatioinList[0].major" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">专业</label>
					</td>
				  <td align="left">
					  	<input name="customerEducatioinList[0].education" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">学历</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerEducatioinList)  > 0 }">
		<c:forEach items="${customerEducatioinList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerEducatioinList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerEducatioinList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerEducatioinList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerEducatioinList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerEducatioinList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerEducatioinList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerEducatioinList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerEducatioinList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerEducatioinList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerEducatioinList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
				   <td align="left">
					  	<input name="customerEducatioinList[${stuts.index }].beginEndDate" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.beginEndDate }"/>
					  <label class="Validform_label" style="display: none;">起止时间</label>
				   </td>
				   <td align="left">
					  	<input name="customerEducatioinList[${stuts.index }].schedule" maxlength="200" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-100" ignore="checked"  value="${poVal.schedule }"/>
					  <label class="Validform_label" style="display: none;">学校</label>
				   </td>
				   <td align="left">
					  	<input name="customerEducatioinList[${stuts.index }].major" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.major }"/>
					  <label class="Validform_label" style="display: none;">专业</label>
				   </td>
				   <td align="left">
					  	<input name="customerEducatioinList[${stuts.index }].education" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.education }"/>
					  <label class="Validform_label" style="display: none;">学历</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
