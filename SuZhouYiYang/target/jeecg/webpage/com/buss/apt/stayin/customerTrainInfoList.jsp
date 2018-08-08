<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerTrainInfoBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerTrainInfoBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerTrainInfoBtn').bind('click', function(){   
 		 var tr =  $("#add_customerTrainInfo_table_template tr").clone();
	 	 $("#add_customerTrainInfo_table").append(tr);
	 	 resetTrNum('add_customerTrainInfo_table');
	 	 return false;
    });  
	$('#delCustomerTrainInfoBtn').bind('click', function(){   
      	$("#add_customerTrainInfo_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerTrainInfo_table'); 
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
	<a id="addCustomerTrainInfoBtn" href="#">添加</a> <a id="delCustomerTrainInfoBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerTrainInfo_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						开始时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						结束时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						主讲人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						培训类别
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						培训内容
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						地点
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客姓名
				  </td>
	</tr>
	<tbody id="add_customerTrainInfo_table">
	<%--
	<c:if test="${fn:length(customerTrainInfoList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerTrainInfoList[0].id" type="hidden"/>
					<input name="customerTrainInfoList[0].createName" type="hidden"/>
					<input name="customerTrainInfoList[0].createBy" type="hidden"/>
					<input name="customerTrainInfoList[0].createDate" type="hidden"/>
					<input name="customerTrainInfoList[0].updateName" type="hidden"/>
					<input name="customerTrainInfoList[0].updateBy" type="hidden"/>
					<input name="customerTrainInfoList[0].updateDate" type="hidden"/>
					<input name="customerTrainInfoList[0].sysOrgCode" type="hidden"/>
					<input name="customerTrainInfoList[0].sysCompanyCode" type="hidden"/>
					<input name="customerTrainInfoList[0].customerId" type="hidden"/>
					<input name="customerTrainInfoList[0].crId" type="hidden"/>
				  <td align="left">
					      	<input name="customerTrainInfoList[0].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">开始时间</label>
					</td>
				  <td align="left">
					      	<input name="customerTrainInfoList[0].endDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">结束时间</label>
					</td>
				  <td align="left">
					  	<input name="customerTrainInfoList[0].trainner" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">主讲人</label>
					</td>
				  <td align="left">
							<t:dictSelect field="customerTrainInfoList[0].trainType" type="list"   typeGroupCode="px_type"  defaultVal="${customerTrainInfoPage.trainType}" hasLabel="false"  title="培训类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">培训类别</label>
					</td>
				  <td align="left">
					  	<input name="customerTrainInfoList[0].des" maxlength="800" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">培训内容</label>
					</td>
				  <td align="left">
					  	<input name="customerTrainInfoList[0].place" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">地点</label>
					</td>
				  <td align="left">
					  	<input name="customerTrainInfoList[0].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerTrainInfoList)  > 0 }">
		<c:forEach items="${customerTrainInfoList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerTrainInfoList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerTrainInfoList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerTrainInfoList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerTrainInfoList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerTrainInfoList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerTrainInfoList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerTrainInfoList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerTrainInfoList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerTrainInfoList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerTrainInfoList[${stuts.index }].customerId" type="hidden" value="${poVal.customerId }"/>
						<input name="customerTrainInfoList[${stuts.index }].crId" type="hidden" value="${poVal.crId }"/>
				   <td align="left">
					      	<input name="customerTrainInfoList[${stuts.index }].beginDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore"  value="<fmt:formatDate value='${poVal.beginDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">开始时间</label>
				   </td>
				   <td align="left">
					      	<input name="customerTrainInfoList[${stuts.index }].endDate" maxlength="32" type="text"  class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  style="width:120px;"  ignore="ignore"  value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">结束时间</label>
				   </td>
				   <td align="left">
					  	<input name="customerTrainInfoList[${stuts.index }].trainner" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.trainner }"/>
					  <label class="Validform_label" style="display: none;">主讲人</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="customerTrainInfoList[${stuts.index }].trainType" type="list"   typeGroupCode="px_type"  defaultVal="${poVal.trainType }" hasLabel="false"  title="培训类别"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">培训类别</label>
				   </td>
				   <td align="left">
					  	<input name="customerTrainInfoList[${stuts.index }].des" maxlength="800" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked"  value="${poVal.des }"/>
					  <label class="Validform_label" style="display: none;">培训内容</label>
				   </td>
				   <td align="left">
					  	<input name="customerTrainInfoList[${stuts.index }].place" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.place }"/>
					  <label class="Validform_label" style="display: none;">地点</label>
				   </td>
				   <td align="left">
					  	<input name="customerTrainInfoList[${stuts.index }].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerName }"/>
					  <label class="Validform_label" style="display: none;">顾客姓名</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
