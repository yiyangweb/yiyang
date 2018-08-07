<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCheckListTypeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCheckListTypeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCheckListTypeBtn').bind('click', function(){   
 		 var tr =  $("#add_checkListType_table_template tr").clone();
	 	 $("#add_checkListType_table").append(tr);
	 	 resetTrNum('add_checkListType_table');
	 	 return false;
    });  
	$('#delCheckListTypeBtn').bind('click', function(){   
      	$("#add_checkListType_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_checkListType_table'); 
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
	<a id="addCheckListTypeBtn" href="#">添加</a> <a id="delCheckListTypeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="checkListType_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查项目名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查项目归属
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						完成时间
				  </td>
	</tr>
	<tbody id="add_checkListType_table">
	<%--
	<c:if test="${fn:length(checkListTypeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="checkListTypeList[0].id" type="hidden"/>
					<input name="checkListTypeList[0].enabled" type="hidden"/>
					<input name="checkListTypeList[0].createName" type="hidden"/>
					<input name="checkListTypeList[0].createBy" type="hidden"/>
					<input name="checkListTypeList[0].createDate" type="hidden"/>
					<input name="checkListTypeList[0].updateName" type="hidden"/>
					<input name="checkListTypeList[0].updateBy" type="hidden"/>
					<input name="checkListTypeList[0].updateDate" type="hidden"/>
					<input name="checkListTypeList[0].sysOrgCode" type="hidden"/>
					<input name="checkListTypeList[0].sysCompanyCode" type="hidden"/>
					<input name="checkListTypeList[0].checkoutListId" type="hidden"/>
				  <td align="left">
					  	<input name="checkListTypeList[0].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
					</td>
				  <td align="left">
					  	<input name="checkListTypeList[0].beloneTo" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查项目归属</label>
					</td>
				  <td align="left">
					  	<input name="checkListTypeList[0].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
							<input name="checkListTypeList[0].serviceDate" maxlength="8"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">完成时间</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(checkListTypeList)  > 0 }">
		<c:forEach items="${checkListTypeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="checkListTypeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="checkListTypeList[${stuts.index }].enabled" type="hidden" value="${poVal.enabled }"/>
						<input name="checkListTypeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="checkListTypeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="checkListTypeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="checkListTypeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="checkListTypeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="checkListTypeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="checkListTypeList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="checkListTypeList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="checkListTypeList[${stuts.index }].checkoutListId" type="hidden" value="${poVal.checkoutListId }"/>
				   <td align="left">
					  	<input name="checkListTypeList[${stuts.index }].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
				   </td>
				   <td align="left">
					  	<input name="checkListTypeList[${stuts.index }].beloneTo" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.beloneTo }"/>
					  <label class="Validform_label" style="display: none;">检查项目归属</label>
				   </td>
				   <td align="left">
					  	<input name="checkListTypeList[${stuts.index }].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
							<input name="checkListTypeList[${stuts.index }].serviceDate" maxlength="8" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.serviceDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">完成时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
