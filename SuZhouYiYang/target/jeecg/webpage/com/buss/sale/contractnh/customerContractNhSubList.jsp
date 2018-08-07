<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerContractNhSubBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerContractNhSubBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerContractNhSubBtn').bind('click', function(){   
 		 var tr =  $("#add_customerContractNhSub_table_template tr").clone();
	 	 $("#add_customerContractNhSub_table").append(tr);
	 	 resetTrNum('add_customerContractNhSub_table');
	 	 return false;
    });  
	$('#delCustomerContractNhSubBtn').bind('click', function(){   
      	$("#add_customerContractNhSub_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerContractNhSub_table'); 
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
	<a id="addCustomerContractNhSubBtn" href="#">添加</a> <a id="delCustomerContractNhSubBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerContractNhSub_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						标题
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						顾客名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						签署日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						负责人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						签署日期
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						变化情况
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附件
				  </td>
	</tr>
	<tbody id="add_customerContractNhSub_table">
	<%--
	<c:if test="${fn:length(customerContractNhSubList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerContractNhSubList[0].id" type="hidden"/>
					<input name="customerContractNhSubList[0].createName" type="hidden"/>
					<input name="customerContractNhSubList[0].createBy" type="hidden"/>
					<input name="customerContractNhSubList[0].createDate" type="hidden"/>
					<input name="customerContractNhSubList[0].updateName" type="hidden"/>
					<input name="customerContractNhSubList[0].updateBy" type="hidden"/>
					<input name="customerContractNhSubList[0].updateDate" type="hidden"/>
					<input name="customerContractNhSubList[0].sysCompanyCode" type="hidden"/>
					<input name="customerContractNhSubList[0].sysOrgCode" type="hidden"/>
					<input name="customerContractNhSubList[0].status" type="hidden"/>
					<input name="customerContractNhSubList[0].contractId" type="hidden"/>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">编号</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">标题</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客编号</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客名称</label>
					</td>
				  <td align="left">
							<input name="customerContractNhSubList[0].signDate" maxlength="8"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">签署日期</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">负责人</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">签署日期</label>
					</td>
				  <td align="left">
					  	<input name="customerContractNhSubList[0].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">变化情况</label>
					</td>
				  <td align="left">
							<input type="hidden" id="customerContractNhSubList[0].attachment" name="customerContractNhSubList[0].attachment" />
									    <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(commonUploadDefaultCallBack,'customerContractNhSubList\\[0\\]\\.attachment')"/> 
										<a  target="_blank" id="customerContractNhSubList[0].attachment_href">未上传</a>
					  <label class="Validform_label" style="display: none;">附件</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerContractNhSubList)  > 0 }">
		<c:forEach items="${customerContractNhSubList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerContractNhSubList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerContractNhSubList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerContractNhSubList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerContractNhSubList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerContractNhSubList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerContractNhSubList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerContractNhSubList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerContractNhSubList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerContractNhSubList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerContractNhSubList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="customerContractNhSubList[${stuts.index }].contractId" type="hidden" value="${poVal.contractId }"/>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.title }"/>
					  <label class="Validform_label" style="display: none;">标题</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerNo }"/>
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerName }"/>
					  <label class="Validform_label" style="display: none;">顾客名称</label>
				   </td>
				   <td align="left">
							<input name="customerContractNhSubList[${stuts.index }].signDate" maxlength="8" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.signDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">签署日期</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.charger }"/>
					  <label class="Validform_label" style="display: none;">负责人</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.signReason }"/>
					  <label class="Validform_label" style="display: none;">签署日期</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractNhSubList[${stuts.index }].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.changes }"/>
					  <label class="Validform_label" style="display: none;">变化情况</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="customerContractNhSubList[${stuts.index }].attachment" name="customerContractNhSubList[${stuts.index }].attachment"  value="${poVal.attachment }"/>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'customerContractNhSubList\\[${stuts.index }\\]\\.attachment')"/> 
					  	 		<c:if test="${empty poVal.attachment}">
											<a  target="_blank" id="customerContractNhSubList[${stuts.index }].attachment_href"></a>
										</c:if>
										<c:if test="${!empty poVal.attachment}">
											<a  href="${poVal.attachment}"  target="_blank" id="customerContractNhSubList[${stuts.index }].attachment_href">下载</a>
										</c:if>
					  <label class="Validform_label" style="display: none;">附件</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
