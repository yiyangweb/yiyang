<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addPaymentListBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delPaymentListBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addPaymentListBtn').bind('click', function(){   
 		 var tr =  $("#add_paymentList_table_template tr").clone();
	 	 $("#add_paymentList_table").append(tr);
	 	 resetTrNum('add_paymentList_table');
	 	 return false;
    });  
	$('#delPaymentListBtn').bind('click', function(){   
      	$("#add_paymentList_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_paymentList_table'); 
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
	<a id="addPaymentListBtn" href="#">添加</a> <a id="delPaymentListBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="paymentList_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						缴费编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						支付途径
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						支付方
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						支付账号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						金额
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收款方
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						收款账号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						支付时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						到账时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_paymentList_table">
	<%--
	<c:if test="${fn:length(paymentListList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="paymentListList[0].id" type="hidden"/>
					<input name="paymentListList[0].createName" type="hidden"/>
					<input name="paymentListList[0].createBy" type="hidden"/>
					<input name="paymentListList[0].createDate" type="hidden"/>
					<input name="paymentListList[0].updateName" type="hidden"/>
					<input name="paymentListList[0].updateBy" type="hidden"/>
					<input name="paymentListList[0].updateDate" type="hidden"/>
					<input name="paymentListList[0].sysOrgCode" type="hidden"/>
					<input name="paymentListList[0].sysCompanyCode" type="hidden"/>
					<input name="paymentListList[0].bpmStatus" type="hidden"/>
					<input name="paymentListList[0].billId" type="hidden"/>
				  <td align="left">
					  	<input name="paymentListList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">缴费编号</label>
					</td>
				  <td align="left">
							<t:dictSelect field="paymentListList[0].payWay" type="list"   typeGroupCode="zf_model"  defaultVal="${paymentListPage.payWay}" hasLabel="false"  title="支付途径"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付途径</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].paySubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">支付方</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].payAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">支付账号</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].money" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">金额</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].receiveSubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收款方</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].receiveAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">收款账号</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].payDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">支付时间</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].receiveDate" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">到账时间</label>
					</td>
				  <td align="left">
					  	<input name="paymentListList[0].remarks" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(paymentListList)  > 0 }">
		<c:forEach items="${paymentListList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="paymentListList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="paymentListList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="paymentListList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="paymentListList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="paymentListList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="paymentListList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="paymentListList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="paymentListList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="paymentListList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="paymentListList[${stuts.index }].bpmStatus" type="hidden" value="${poVal.bpmStatus }"/>
						<input name="paymentListList[${stuts.index }].billId" type="hidden" value="${poVal.billId }"/>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">缴费编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="paymentListList[${stuts.index }].payWay" type="list"   typeGroupCode="zf_model"  defaultVal="${poVal.payWay }" hasLabel="false"  title="支付途径"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">支付途径</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].paySubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.paySubject }"/>
					  <label class="Validform_label" style="display: none;">支付方</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].payAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.payAccount }"/>
					  <label class="Validform_label" style="display: none;">支付账号</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].money" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.money }"/>
					  <label class="Validform_label" style="display: none;">金额</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].receiveSubject" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.receiveSubject }"/>
					  <label class="Validform_label" style="display: none;">收款方</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].receiveAccount" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.receiveAccount }"/>
					  <label class="Validform_label" style="display: none;">收款账号</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].payDate" maxlength="32" type="text" style="width:120px;" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  value="<fmt:formatDate value='${poVal.payDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">支付时间</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].receiveDate" maxlength="32" type="text" style="width:120px;" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" ignore="ignore"  value="<fmt:formatDate value='${poVal.receiveDate}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>"/>
					  <label class="Validform_label" style="display: none;">到账时间</label>
				   </td>
				   <td align="left">
					  	<input name="paymentListList[${stuts.index }].remarks" maxlength="300" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remarks }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
