<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCheckLeaveNurseBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCheckLeaveNurseBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCheckLeaveNurseBtn').bind('click', function(){   
 		 var tr =  $("#add_checkLeaveNurse_table_template tr").clone();
	 	 $("#add_checkLeaveNurse_table").append(tr);
	 	 resetTrNum('add_checkLeaveNurse_table');
	 	 return false;
    });  
	$('#delCheckLeaveNurseBtn').bind('click', function(){   
      	$("#add_checkLeaveNurse_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_checkLeaveNurse_table'); 
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
	<a id="addCheckLeaveNurseBtn" href="#">添加</a> <a id="delCheckLeaveNurseBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="checkLeaveNurse_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						属于
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附件
				  </td>
	</tr>
	<tbody id="add_checkLeaveNurse_table">
	<c:if test="${fn:length(checkLeaveNurseList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="checkLeaveNurseList[0].id" type="hidden"/>
					<input name="checkLeaveNurseList[0].createName" type="hidden"/>
					<input name="checkLeaveNurseList[0].createBy" type="hidden"/>
					<input name="checkLeaveNurseList[0].createDate" type="hidden"/>
					<input name="checkLeaveNurseList[0].updateName" type="hidden"/>
					<input name="checkLeaveNurseList[0].updateBy" type="hidden"/>
					<input name="checkLeaveNurseList[0].updateDate" type="hidden"/>
					<input name="checkLeaveNurseList[0].sysOrgCode" type="hidden"/>
					<input name="checkLeaveNurseList[0].sysCompanyCode" type="hidden"/>
					<input name="checkLeaveNurseList[0].status" type="hidden"/>
					<input name="checkLeaveNurseList[0].leaveId" type="hidden"/>
				  <td align="left">
					  	<input name="checkLeaveNurseList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">检查项目</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNurseList[0].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">属于</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNurseList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNurseList[0].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查人</label>
					</td>
				  <td align="left">
							<input name="checkLeaveNurseList[0].endDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查日期</label>
					</td>
				  <td align="left">
							<input type="hidden" id="checkLeaveNurseList[0].attribute" name="checkLeaveNurseList[0].attribute" />
									    <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNurseList\\[0\\]\\.attribute')"/> 
										<a  target="_blank" id="checkLeaveNurseList[0].attribute_href">未上传</a>
					  <label class="Validform_label" style="display: none;">附件</label>
					</td>
   			</tr>
	</c:if>
	<c:if test="${fn:length(checkLeaveNurseList)  > 0 }">
		<c:forEach items="${checkLeaveNurseList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="checkLeaveNurseList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="checkLeaveNurseList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="checkLeaveNurseList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="checkLeaveNurseList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="checkLeaveNurseList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="checkLeaveNurseList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="checkLeaveNurseList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="checkLeaveNurseList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="checkLeaveNurseList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="checkLeaveNurseList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="checkLeaveNurseList[${stuts.index }].leaveId" type="hidden" value="${poVal.leaveId }"/>
				   <td align="left">
					  	<input name="checkLeaveNurseList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">检查项目</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNurseList[${stuts.index }].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.belongTo }"/>
					  <label class="Validform_label" style="display: none;">属于</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNurseList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNurseList[${stuts.index }].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.checkPerson }"/>
					  <label class="Validform_label" style="display: none;">检查人</label>
				   </td>
				   <td align="left">
							<input name="checkLeaveNurseList[${stuts.index }].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">检查日期</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="checkLeaveNurseList[${stuts.index }].attribute" name="checkLeaveNurseList[${stuts.index }].attribute"  value="${poVal.attribute }"/>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNurseList\\[${stuts.index }\\]\\.attribute')"/> 
					  	 		<c:if test="${empty poVal.attribute}">
											<a  target="_blank" id="checkLeaveNurseList[${stuts.index }].attribute_href"></a>
										</c:if>
										<c:if test="${!empty poVal.attribute}">
											<a  href="${poVal.attribute}"  target="_blank" id="checkLeaveNurseList[${stuts.index }].attribute_href">下载</a>
										</c:if>
					  <label class="Validform_label" style="display: none;">附件</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
