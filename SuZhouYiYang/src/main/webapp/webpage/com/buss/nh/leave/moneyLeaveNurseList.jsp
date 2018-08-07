<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMoneyLeaveNurseBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMoneyLeaveNurseBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMoneyLeaveNurseBtn').bind('click', function(){   
 		 var tr =  $("#add_moneyLeaveNurse_table_template tr").clone();
	 	 $("#add_moneyLeaveNurse_table").append(tr);
	 	 resetTrNum('add_moneyLeaveNurse_table');
	 	 return false;
    });  
	$('#delMoneyLeaveNurseBtn').bind('click', function(){   
      	$("#add_moneyLeaveNurse_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_moneyLeaveNurse_table'); 
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
	<a id="addMoneyLeaveNurseBtn" href="#">添加</a> <a id="delMoneyLeaveNurseBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="moneyLeaveNurse_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						消费项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						是否缴费
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						产生时间
				  </td>
	</tr>
	<tbody id="add_moneyLeaveNurse_table">
	<c:if test="${fn:length(moneyLeaveNurseList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="moneyLeaveNurseList[0].id" type="hidden"/>
					<input name="moneyLeaveNurseList[0].createName" type="hidden"/>
					<input name="moneyLeaveNurseList[0].createBy" type="hidden"/>
					<input name="moneyLeaveNurseList[0].createDate" type="hidden"/>
					<input name="moneyLeaveNurseList[0].updateName" type="hidden"/>
					<input name="moneyLeaveNurseList[0].updateBy" type="hidden"/>
					<input name="moneyLeaveNurseList[0].updateDate" type="hidden"/>
					<input name="moneyLeaveNurseList[0].sysOrgCode" type="hidden"/>
					<input name="moneyLeaveNurseList[0].sysCompanyCode" type="hidden"/>
					<input name="moneyLeaveNurseList[0].status" type="hidden"/>
					<input name="moneyLeaveNurseList[0].leaveId" type="hidden"/>
				  <td align="left">
					  	<input name="moneyLeaveNurseList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">消费项目</label>
					</td>
				  <td align="left">
					  	<input name="moneyLeaveNurseList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
							<t:dictSelect field="moneyLeaveNurseList[0].payment" type="list"   typeGroupCode="dev_flag"  defaultVal="${moneyLeaveNursePage.payment}" hasLabel="false"  title="是否缴费"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">是否缴费</label>
					</td>
				  <td align="left">
					  	<input name="moneyLeaveNurseList[0].money" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
							<input name="moneyLeaveNurseList[0].addDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">产生时间</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(moneyLeaveNurseList)  > 0 }">
		<c:forEach items="${moneyLeaveNurseList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="moneyLeaveNurseList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="moneyLeaveNurseList[${stuts.index }].leaveId" type="hidden" value="${poVal.leaveId }"/>
				   <td align="left">
					  	<input name="moneyLeaveNurseList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">消费项目</label>
				   </td>
				   <td align="left">
					  	<input name="moneyLeaveNurseList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="moneyLeaveNurseList[${stuts.index }].payment" type="list"   typeGroupCode="dev_flag"  defaultVal="${poVal.payment }" hasLabel="false"  title="是否缴费"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">是否缴费</label>
				   </td>
				   <td align="left">
					  	<input name="moneyLeaveNurseList[${stuts.index }].money" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.money }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
							<input name="moneyLeaveNurseList[${stuts.index }].addDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.addDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">产生时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
