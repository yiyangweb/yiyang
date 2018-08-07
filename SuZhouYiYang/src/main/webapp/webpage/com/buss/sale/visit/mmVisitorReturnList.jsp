<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMmVisitorReturnBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMmVisitorReturnBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMmVisitorReturnBtn').bind('click', function(){   
 		 var tr =  $("#add_mmVisitorReturn_table_template tr").clone();
	 	 $("#add_mmVisitorReturn_table").append(tr);
	 	 resetTrNum('add_mmVisitorReturn_table');
	 	 return false;
    });  
	$('#delMmVisitorReturnBtn').bind('click', function(){   
      	$("#add_mmVisitorReturn_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_mmVisitorReturn_table'); 
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
	<a id="addMmVisitorReturnBtn" href="#">添加</a> <a id="delMmVisitorReturnBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="mmVisitorReturn_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						被访客户
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访地点
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访方式
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访详情
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						回访时间
				  </td>
	</tr>
	<tbody id="add_mmVisitorReturn_table">
	<%--
	<c:if test="${fn:length(mmVisitorReturnList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="mmVisitorReturnList[0].id" type="hidden"/>
					<input name="mmVisitorReturnList[0].createName" type="hidden"/>
					<input name="mmVisitorReturnList[0].createBy" type="hidden"/>
					<input name="mmVisitorReturnList[0].createDate" type="hidden"/>
					<input name="mmVisitorReturnList[0].updateName" type="hidden"/>
					<input name="mmVisitorReturnList[0].updateBy" type="hidden"/>
					<input name="mmVisitorReturnList[0].updateDate" type="hidden"/>
					<input name="mmVisitorReturnList[0].sysOrgCode" type="hidden"/>
					<input name="mmVisitorReturnList[0].sysCompanyCode" type="hidden"/>
					<input name="mmVisitorReturnList[0].recordId" type="hidden"/>
				  <td align="left">
					  	<input name="mmVisitorReturnList[0].returnNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="mm_visitor_return,return_no,mmVisitorReturnList[0].id" datatype="*" ignore="ignore" >
					  <label class="Validform_label" style="display: none;">回访编号</label>
					</td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[0].visitor" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-32" ignore="checked" >
					  <label class="Validform_label" style="display: none;">被访客户</label>
					</td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[0].place" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">回访地点</label>
					</td>
				  <td align="left">
							<t:dictSelect field="mmVisitorReturnList[0].visitType" type="list" 		datatype="*"  typeGroupCode="hf_type"  defaultVal="${mmVisitorReturnPage.visitType}" hasLabel="false"  title="回访方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">回访方式</label>
					</td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[0].visitDetail" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">回访详情</label>
					</td>
				  <td align="left">
					  	<input name="mmVisitorReturnList[0].revisit" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*6-16" ignore="checked" >
					  <label class="Validform_label" style="display: none;">回访人</label>
					</td>
				  <td align="left">
							<input name="mmVisitorReturnList[0].visitDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">回访时间</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(mmVisitorReturnList)  > 0 }">
		<c:forEach items="${mmVisitorReturnList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="mmVisitorReturnList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="mmVisitorReturnList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="mmVisitorReturnList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="mmVisitorReturnList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="mmVisitorReturnList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="mmVisitorReturnList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="mmVisitorReturnList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="mmVisitorReturnList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="mmVisitorReturnList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="mmVisitorReturnList[${stuts.index }].recordId" type="hidden" value="${poVal.recordId }"/>
				   <td align="left">
					  	<input name="mmVisitorReturnList[${stuts.index }].returnNo" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="mm_visitor_return,return_no,mmVisitorReturnList[${stuts.index }].id" datatype="*" ignore="ignore"  value="${poVal.returnNo }"/>
					  <label class="Validform_label" style="display: none;">回访编号</label>
				   </td>
				   <td align="left">
					  	<input name="mmVisitorReturnList[${stuts.index }].visitor" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-32" ignore="checked"  value="${poVal.visitor }"/>
					  <label class="Validform_label" style="display: none;">被访客户</label>
				   </td>
				   <td align="left">
					  	<input name="mmVisitorReturnList[${stuts.index }].place" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.place }"/>
					  <label class="Validform_label" style="display: none;">回访地点</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="mmVisitorReturnList[${stuts.index }].visitType" type="list" 		datatype="*"  typeGroupCode="hf_type"  defaultVal="${poVal.visitType }" hasLabel="false"  title="回访方式"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">回访方式</label>
				   </td>
				   <td align="left">
					  	<input name="mmVisitorReturnList[${stuts.index }].visitDetail" maxlength="200" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.visitDetail }"/>
					  <label class="Validform_label" style="display: none;">回访详情</label>
				   </td>
				   <td align="left">
					  	<input name="mmVisitorReturnList[${stuts.index }].revisit" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		datatype="*1-32" ignore="checked"  value="${poVal.revisit }"/>
					  <label class="Validform_label" style="display: none;">回访人</label>
				   </td>
				   <td align="left">
							<input name="mmVisitorReturnList[${stuts.index }].visitDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="checked"  value="<fmt:formatDate value='${poVal.visitDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">回访时间</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
