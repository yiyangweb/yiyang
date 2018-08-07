<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCheckListDesBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCheckListDesBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCheckListDesBtn').bind('click', function(){   
 		 var tr =  $("#add_checkListDes_table_template tr").clone();
	 	 $("#add_checkListDes_table").append(tr);
	 	 resetTrNum('add_checkListDes_table');
	 	 return false;
    });  
	$('#delCheckListDesBtn').bind('click', function(){   
      	$("#add_checkListDes_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_checkListDes_table'); 
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
	<a id="addCheckListDesBtn" href="#">添加</a> <a id="delCheckListDesBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="checkListDes_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查项目名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						归属
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						检查人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						完成时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附件
				  </td>
	</tr>
	<tbody id="add_checkListDes_table">
	<%--
	<c:if test="${fn:length(checkListDesList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="checkListDesList[0].id" type="hidden"/>
					<input name="checkListDesList[0].createName" type="hidden"/>
					<input name="checkListDesList[0].createBy" type="hidden"/>
					<input name="checkListDesList[0].createDate" type="hidden"/>
					<input name="checkListDesList[0].updateName" type="hidden"/>
					<input name="checkListDesList[0].updateBy" type="hidden"/>
					<input name="checkListDesList[0].updateDate" type="hidden"/>
					<input name="checkListDesList[0].sysOrgCode" type="hidden"/>
					<input name="checkListDesList[0].sysCompanyCode" type="hidden"/>
					<input name="checkListDesList[0].crId" type="hidden"/>
				  <td align="left">
					  	<input name="checkListDesList[0].checkListName" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
					</td>
				  <td align="left">
					  	<input name="checkListDesList[0].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">归属</label>
					</td>
				  <td align="left">
					  	<input name="checkListDesList[0].description" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
				  <td align="left">
					  	<input name="checkListDesList[0].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">检查人</label>
					</td>
				  <td align="left">
							<input name="checkListDesList[0].endDete" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">完成时间</label>
					</td>
				  <td align="left">
							<input type="hidden" id="checkListDesList[0].attribute" name="checkListDesList[0].attribute" />
									    <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(commonUploadDefaultCallBack,'checkListDesList\\[0\\]\\.attribute')"/> 
										<a  target="_blank" id="checkListDesList[0].attribute_href">未上传</a>
					  <label class="Validform_label" style="display: none;">附件</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(checkListDesList)  > 0 }">
		<c:forEach items="${checkListDesList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="checkListDesList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="checkListDesList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="checkListDesList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="checkListDesList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="checkListDesList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="checkListDesList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="checkListDesList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="checkListDesList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="checkListDesList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="checkListDesList[${stuts.index }].crId" type="hidden" value="${poVal.crId }"/>
				   <td align="left">
					  	<input name="checkListDesList[${stuts.index }].checkListName" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		datatype="*" ignore="checked"  value="${poVal.checkListName }"/>
					  <label class="Validform_label" style="display: none;">检查项目名称</label>
				   </td>
				   <td align="left">
					  	<input name="checkListDesList[${stuts.index }].belongTo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.belongTo }"/>
					  <label class="Validform_label" style="display: none;">归属</label>
				   </td>
				   <td align="left">
					  	<input name="checkListDesList[${stuts.index }].description" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
				   <td align="left">
					  	<input name="checkListDesList[${stuts.index }].checkPerson" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.checkPerson }"/>
					  <label class="Validform_label" style="display: none;">检查人</label>
				   </td>
				   <td align="left">
							<input name="checkListDesList[${stuts.index }].endDete" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.endDete}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">完成时间</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="checkListDesList[${stuts.index }].attribute" name="checkListDesList[${stuts.index }].attribute"  value="${poVal.attribute }"/>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'checkListDesList\\[${stuts.index }\\]\\.attribute')"/> 
					  	 		<c:if test="${empty poVal.attribute}">
											<a  target="_blank" id="checkListDesList[${stuts.index }].attribute_href"></a>
										</c:if>
										<c:if test="${!empty poVal.attribute}">
											<a  href="${poVal.attribute}"  target="_blank" id="checkListDesList[${stuts.index }].attribute_href">下载</a>
										</c:if>
					  <label class="Validform_label" style="display: none;">附件</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
