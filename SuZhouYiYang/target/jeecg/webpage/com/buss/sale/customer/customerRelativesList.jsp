<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerRelativesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerRelativesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerRelativesBtn').bind('click', function(){   
 		 var tr =  $("#add_customerRelatives_table_template tr").clone();
	 	 $("#add_customerRelatives_table").append(tr);
	 	 resetTrNum('add_customerRelatives_table');
	 	 return false;
    });  
	$('#delCustomerRelativesBtn').bind('click', function(){   
      	$("#add_customerRelatives_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerRelatives_table'); 
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
	<a id="addCustomerRelativesBtn" href="#">添加</a> <a id="delCustomerRelativesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerRelatives_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						名字
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						性别
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						相对关系
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						联系电话
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						邮箱
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						住址
				  </td>
	</tr>
	<tbody id="add_customerRelatives_table">
	<%--
	<c:if test="${fn:length(customerRelativesList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerRelativesList[0].id" type="hidden"/>
					<input name="customerRelativesList[0].createName" type="hidden"/>
					<input name="customerRelativesList[0].createBy" type="hidden"/>
					<input name="customerRelativesList[0].createDate" type="hidden"/>
					<input name="customerRelativesList[0].updateName" type="hidden"/>
					<input name="customerRelativesList[0].updateBy" type="hidden"/>
					<input name="customerRelativesList[0].updateDate" type="hidden"/>
					<input name="customerRelativesList[0].sysOrgCode" type="hidden"/>
					<input name="customerRelativesList[0].sysCompanyCode" type="hidden"/>
					<input name="customerRelativesList[0].relativeId" type="hidden"/>
					<input name="customerRelativesList[0].customerId" type="hidden"/>
				  <td align="left">
					  	<input name="customerRelativesList[0].name" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="*6-16" ignore="checked" >
					  <label class="Validform_label" style="display: none;">名字</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerRelativesList[0].sex" type="list"   typeGroupCode="sex"  defaultVal="${customerRelativesPage.sex}" hasLabel="false"  title="性别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">性别</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerRelativesList[0].relationType" type="list"   typeGroupCode="qs_type"  defaultVal="${customerRelativesPage.relationType}" hasLabel="false"  title="相对关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">相对关系</label>
					</td>
				  <td align="left">
					  	<input name="customerRelativesList[0].phoneNo" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">联系电话</label>
					</td>
				  <td align="left">
					  	<input name="customerRelativesList[0].email" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore" >
					  <label class="Validform_label" style="display: none;">邮箱</label>
					</td>
				  <td align="left">
					  	<input name="customerRelativesList[0].adress" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">住址</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerRelativesList)  > 0 }">
		<c:forEach items="${customerRelativesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerRelativesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerRelativesList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerRelativesList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerRelativesList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerRelativesList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerRelativesList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerRelativesList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerRelativesList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerRelativesList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerRelativesList[${stuts.index }].relativeId" type="hidden" value="${poVal.relativeId }"/>
						<input name="customerRelativesList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
				   <td align="left">
					  	<input name="customerRelativesList[${stuts.index }].name" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-32" ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">名字</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerRelativesList[${stuts.index }].sex" type="list"   typeGroupCode="sex"  defaultVal="${poVal.sex }" hasLabel="false"  title="性别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">性别</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerRelativesList[${stuts.index }].relationType" type="list"   typeGroupCode="qs_type"  defaultVal="${poVal.relationType }" hasLabel="false"  title="相对关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">相对关系</label>
				   </td>
				   <td align="left">
					  	<input name="customerRelativesList[${stuts.index }].phoneNo" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.phoneNo }"/>
					  <label class="Validform_label" style="display: none;">联系电话</label>
				   </td>
				   <td align="left">
					  	<input name="customerRelativesList[${stuts.index }].email" maxlength="36" type="text" class="inputxt"  style="width:120px;" 		datatype="e" ignore="ignore"  value="${poVal.email }"/>
					  <label class="Validform_label" style="display: none;">邮箱</label>
				   </td>
				   <td align="left">
					  	<input name="customerRelativesList[${stuts.index }].adress" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.adress }"/>
					  <label class="Validform_label" style="display: none;">住址</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
