<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCheckLeaveNhBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCheckLeaveNhBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCheckLeaveNhBtn').bind('click', function(){   
 		 var tr =  $("#add_checkLeaveNh_table_template tr").clone();
	 	 $("#add_checkLeaveNh_table").append(tr);
	 	 resetTrNum('add_checkLeaveNh_table');
	 	 return false;
    });  
	$('#delCheckLeaveNhBtn').bind('click', function(){   
      	$("#add_checkLeaveNh_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_checkLeaveNh_table'); 
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
	<a id="addCheckLeaveNhBtn" href="#">添加</a> <a id="delCheckLeaveNhBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="checkLeaveNh_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						所属
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						完结日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附件
				  </td>
	</tr>
	<tbody id="add_checkLeaveNh_table">
	<%--
	<c:if test="${fn:length(checkLeaveNhList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="checkLeaveNhList[0].id" type="hidden"/>
					<input name="checkLeaveNhList[0].createName" type="hidden"/>
					<input name="checkLeaveNhList[0].createBy" type="hidden"/>
					<input name="checkLeaveNhList[0].createDate" type="hidden"/>
					<input name="checkLeaveNhList[0].updateName" type="hidden"/>
					<input name="checkLeaveNhList[0].updateBy" type="hidden"/>
					<input name="checkLeaveNhList[0].updateDate" type="hidden"/>
					<input name="checkLeaveNhList[0].sysOrgCode" type="hidden"/>
					<input name="checkLeaveNhList[0].sysCompanyCode" type="hidden"/>
					<input name="checkLeaveNhList[0].status" type="hidden"/>
					<input name="checkLeaveNhList[0].tzId" type="hidden"/>
				  <td align="left">
					  	<input name="checkLeaveNhList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">检查项目</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNhList[0].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">所属</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNhList[0].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					  	<input name="checkLeaveNhList[0].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查人</label>
					</td>
				  <td align="left">
							<input name="checkLeaveNhList[0].endDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">完结日期</label>
					</td>
				  <td align="left">
							<input type="hidden" id="checkLeaveNhList[0].attribute" name="checkLeaveNhList[0].attribute" />
									    <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNhList\\[0\\]\\.attribute')"/> 
										<a  target="_blank" id="checkLeaveNhList[0].attribute_href">未上传</a>
					  <label class="Validform_label" style="display: none;">附件</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(checkLeaveNhList)  > 0 }">
		<c:forEach items="${checkLeaveNhList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="checkLeaveNhList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="checkLeaveNhList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="checkLeaveNhList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="checkLeaveNhList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="checkLeaveNhList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="checkLeaveNhList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="checkLeaveNhList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="checkLeaveNhList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="checkLeaveNhList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="checkLeaveNhList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="checkLeaveNhList[${stuts.index }].tzId" type="hidden" value="${poVal.tzId }"/>
				   <td align="left">
					  	<input name="checkLeaveNhList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">检查项目</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNhList[${stuts.index }].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.belongTo }"/>
					  <label class="Validform_label" style="display: none;">所属</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNhList[${stuts.index }].description" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					  	<input name="checkLeaveNhList[${stuts.index }].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.checkPerson }"/>
					  <label class="Validform_label" style="display: none;">检查人</label>
				   </td>
				   <td align="left">
							<input name="checkLeaveNhList[${stuts.index }].endDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.endDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">完结日期</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="checkLeaveNhList[${stuts.index }].attribute" name="checkLeaveNhList[${stuts.index }].attribute"  value="${poVal.attribute }"/>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkLeaveNhList\\[${stuts.index }\\]\\.attribute')"/> 
					  	 		<c:if test="${empty poVal.attribute}">
											<a  target="_blank" id="checkLeaveNhList[${stuts.index }].attribute_href"></a>
										</c:if>
										<c:if test="${!empty poVal.attribute}">
											<a  href="${poVal.attribute}"  target="_blank" id="checkLeaveNhList[${stuts.index }].attribute_href">下载</a>
										</c:if>
					  <label class="Validform_label" style="display: none;">附件</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
