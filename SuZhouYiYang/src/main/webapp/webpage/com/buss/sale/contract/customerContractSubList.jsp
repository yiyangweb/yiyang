<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addCustomerContractSubBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delCustomerContractSubBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addCustomerContractSubBtn').bind('click', function(){   
 		 var tr =  $("#add_customerContractSub_table_template tr").clone();
	 	 $("#add_customerContractSub_table").append(tr);
	 	 resetTrNum('add_customerContractSub_table');
	 	 return false;
    });  
	$('#delCustomerContractSubBtn').bind('click', function(){   
      	$("#add_customerContractSub_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_customerContractSub_table'); 
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
	<a id="addCustomerContractSubBtn" href="#">添加</a> <a id="delCustomerContractSubBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="customerContractSub_table">
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
						签署原因
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						变化情况
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						附件
				  </td>
	</tr>
	<tbody id="add_customerContractSub_table">
	<%--
	<c:if test="${fn:length(customerContractSubList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="customerContractSubList[0].id" type="hidden"/>
					<input name="customerContractSubList[0].createName" type="hidden"/>
					<input name="customerContractSubList[0].createBy" type="hidden"/>
					<input name="customerContractSubList[0].createDate" type="hidden"/>
					<input name="customerContractSubList[0].updateName" type="hidden"/>
					<input name="customerContractSubList[0].updateBy" type="hidden"/>
					<input name="customerContractSubList[0].updateDate" type="hidden"/>
					<input name="customerContractSubList[0].sysCompanyCode" type="hidden"/>
					<input name="customerContractSubList[0].sysOrgCode" type="hidden"/>
					<input name="customerContractSubList[0].status" type="hidden"/>
					<input name="customerContractSubList[0].contractId" type="hidden"/>
				  <td align="left">
					  	<input name="customerContractSubList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_contract_sub,no,customerContractSubList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">编号</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">标题</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客编号</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">顾客名称</label>
					</td>
				  <td align="left">
							<input name="customerContractSubList[0].signDate" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">签署日期</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">负责人</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">签署原因</label>
					</td>
				  <td align="left">
					  	<input name="customerContractSubList[0].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">变化情况</label>
					</td>
				  <td align="left">
							<input type="hidden" id="customerContractSubList[0].attachment" name="customerContractSubList[0].attachment" />
									    <input class="ui-button" type="button" value="上传附件" onclick="commonUpload(commonUploadDefaultCallBack,'customerContractSubList\\[0\\]\\.attachment')"/> 
										<a  target="_blank" id="customerContractSubList[0].attachment_href">未上传</a>
					  <label class="Validform_label" style="display: none;">附件</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(customerContractSubList)  > 0 }">
		<c:forEach items="${customerContractSubList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="customerContractSubList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="customerContractSubList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="customerContractSubList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="customerContractSubList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="customerContractSubList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="customerContractSubList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="customerContractSubList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="customerContractSubList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="customerContractSubList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="customerContractSubList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="customerContractSubList[${stuts.index }].contractId" type="hidden" value="${poVal.contractId }"/>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="customer_contract_sub,no,customerContractSubList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].title" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.title }"/>
					  <label class="Validform_label" style="display: none;">标题</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].customerNo" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerNo }"/>
					  <label class="Validform_label" style="display: none;">顾客编号</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].customerName" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.customerName }"/>
					  <label class="Validform_label" style="display: none;">顾客名称</label>
				   </td>
				   <td align="left">
							<input name="customerContractSubList[${stuts.index }].signDate" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.signDate}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">签署日期</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].charger" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.charger }"/>
					  <label class="Validform_label" style="display: none;">负责人</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].signReason" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.signReason }"/>
					  <label class="Validform_label" style="display: none;">签署原因</label>
				   </td>
				   <td align="left">
					  	<input name="customerContractSubList[${stuts.index }].changes" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.changes }"/>
					  <label class="Validform_label" style="display: none;">变化情况</label>
				   </td>
				   <td align="left">
					        <input type="hidden" id="customerContractSubList[${stuts.index }].attachment" name="customerContractSubList[${stuts.index }].attachment"  value="${poVal.attachment }"/>
									   <input class="ui-button" type="button" value="上传附件"
													onclick="commonUpload(commonUploadDefaultCallBack,'customerContractSubList\\[${stuts.index }\\]\\.attachment')"/> 
					  	 		<c:if test="${empty poVal.attachment}">
											<a  target="_blank" id="customerContractSubList[${stuts.index }].attachment_href"></a>
										</c:if>
										<c:if test="${!empty poVal.attachment}">
											<a  href="${poVal.attachment}"  target="_blank" id="customerContractSubList[${stuts.index }].attachment_href">下载</a>
										</c:if>
					  <label class="Validform_label" style="display: none;">附件</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
