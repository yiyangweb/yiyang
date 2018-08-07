<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerRoomDesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerRoomDesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerRoomDesBtn').bind('click', function(){   
 		 var tr =  $("#add_customerRoomDes_table_template tr").clone();
	 	 $("#add_customerRoomDes_table").append(tr);
	 	 resetTrNum('add_customerRoomDes_table');
	 	 return false;
    });  
	$('#delCustomerRoomDesBtn').bind('click', function(){   
      	$("#add_customerRoomDes_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerRoomDes_table'); 
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
	<a id="addCustomerRoomDesBtn" href="#">添加</a> <a id="delCustomerRoomDesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerRoomDes_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客姓名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						亲属关系
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						入住时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_customerRoomDes_table">
	<%--
	<c:if test="${fn:length(customerRoomDesList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerRoomDesList[0].id" type="hidden"/>
					<input name="customerRoomDesList[0].createName" type="hidden"/>
					<input name="customerRoomDesList[0].createBy" type="hidden"/>
					<input name="customerRoomDesList[0].createDate" type="hidden"/>
					<input name="customerRoomDesList[0].updateName" type="hidden"/>
					<input name="customerRoomDesList[0].updateBy" type="hidden"/>
					<input name="customerRoomDesList[0].updateDate" type="hidden"/>
					<input name="customerRoomDesList[0].sysOrgCode" type="hidden"/>
					<input name="customerRoomDesList[0].sysCompanyCode" type="hidden"/>
					<input name="customerRoomDesList[0].status" type="hidden"/>
					<input name="customerRoomDesList[0].customerId" type="hidden"/>
					<input name="customerRoomDesList[0].inId" type="hidden"/>
				  <td align="left">
							 <input  id="customerRoomDesList[0].customerName" name="customerRoomDesList[0].customerName" type="text" style="width: 150px" class="searchbox-inputtext"  value="${poVal.customerName }"  		datatype="*" ignore="checked"   onclick="popupClick(this,'id,name','customerId,customerName','customer_base')"/> 			 
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerRoomDesList[0].relationship" type="list" 		datatype="*"  typeGroupCode="qs_type"  defaultVal="${customerRoomDesPage.relationship}" hasLabel="false"  title="亲属关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">亲属关系</label>
					</td>
				  <td align="left">
					      	<input name="customerRoomDesList[0].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">入住时间</label>
					</td>
				  <td align="left">
					  	<input name="customerRoomDesList[0].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerRoomDesList)  > 0 }">
		<c:forEach items="${customerRoomDesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerRoomDesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerRoomDesList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerRoomDesList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerRoomDesList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerRoomDesList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerRoomDesList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerRoomDesList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerRoomDesList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerRoomDesList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerRoomDesList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="customerRoomDesList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
						<input name="customerRoomDesList[${stuts.index }].inId" type="hidden" value="${poVal.inId }"/>
				   <td align="left">
							 <input  id="customerRoomDesList[${stuts.index }].customerName" name="customerRoomDesList[${stuts.index }].customerName"  type="text" style="width: 150px" class="searchbox-inputtext"  		datatype="*" ignore="checked"  onclick="popupClick(this,'id,name','customerId,customerName','customer_base')"    value="${poVal.customerName }" /> 			 
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerRoomDesList[${stuts.index }].relationship" type="list" 		datatype="*"  typeGroupCode="qs_type"  defaultVal="${poVal.relationship }" hasLabel="false"  title="亲属关系"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">亲属关系</label>
				   </td>
				   <td align="left">
					      	<input name="customerRoomDesList[${stuts.index }].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore"  value="<fmt:formatDate value='${poVal.beginDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">入住时间</label>
				   </td>
				   <td align="left">
					  	<input name="customerRoomDesList[${stuts.index }].remark" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
