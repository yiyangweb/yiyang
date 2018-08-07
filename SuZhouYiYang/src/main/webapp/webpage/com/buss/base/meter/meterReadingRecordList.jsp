<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addMeterReadingRecordBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delMeterReadingRecordBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addMeterReadingRecordBtn').bind('click', function(){   
 		 var tr =  $("#add_meterReadingRecord_table_template tr").clone();
	 	 $("#add_meterReadingRecord_table").append(tr);
	 	 resetTrNum('add_meterReadingRecord_table');
	 	 return false;
    });  
	$('#delMeterReadingRecordBtn').bind('click', function(){   
      	$("#add_meterReadingRecord_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_meterReadingRecord_table'); 
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
	<a id="addMeterReadingRecordBtn" href="#">添加</a> <a id="delMeterReadingRecordBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="meterReadingRecord_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						抄表记录编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						读数
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						抄表时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						上期读数
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						上期抄表时间
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						抄表间隔所需费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
	</tr>
	<tbody id="add_meterReadingRecord_table">
	<%--
	<c:if test="${fn:length(meterReadingRecordList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="meterReadingRecordList[0].id" type="hidden"/>
					<input name="meterReadingRecordList[0].enabled" type="hidden"/>
					<input name="meterReadingRecordList[0].deleted" type="hidden"/>
					<input name="meterReadingRecordList[0].createName" type="hidden"/>
					<input name="meterReadingRecordList[0].createBy" type="hidden"/>
					<input name="meterReadingRecordList[0].createDate" type="hidden"/>
					<input name="meterReadingRecordList[0].updateName" type="hidden"/>
					<input name="meterReadingRecordList[0].updateBy" type="hidden"/>
					<input name="meterReadingRecordList[0].updateDate" type="hidden"/>
					<input name="meterReadingRecordList[0].sysOrgCode" type="hidden"/>
					<input name="meterReadingRecordList[0].sysCompanyCode" type="hidden"/>
					<input name="meterReadingRecordList[0].meterId" type="hidden"/>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="meter_reading_record,no,meterReadingRecordList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">抄表记录编号</label>
					</td>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].reading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">读数</label>
					</td>
				  <td align="left">
							<input name="meterReadingRecordList[0].readingTime" maxlength="8"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">抄表时间</label>
					</td>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].lastReading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">上期读数</label>
					</td>
				  <td align="left">
							<input name="meterReadingRecordList[0].lastReadingTime" maxlength="32"  type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">上期抄表时间</label>
					</td>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].price" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">单价</label>
					</td>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].money" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">抄表间隔所需费用</label>
					</td>
				  <td align="left">
					  	<input name="meterReadingRecordList[0].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(meterReadingRecordList)  > 0 }">
		<c:forEach items="${meterReadingRecordList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="meterReadingRecordList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="meterReadingRecordList[${stuts.index }].enabled" type="hidden" value="${poVal.enabled }"/>
						<input name="meterReadingRecordList[${stuts.index }].deleted" type="hidden" value="${poVal.deleted }"/>
						<input name="meterReadingRecordList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="meterReadingRecordList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="meterReadingRecordList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="meterReadingRecordList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="meterReadingRecordList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="meterReadingRecordList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="meterReadingRecordList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="meterReadingRecordList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="meterReadingRecordList[${stuts.index }].meterId" type="hidden" value="${poVal.meterId }"/>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="meter_reading_record,no,meterReadingRecordList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">抄表记录编号</label>
				   </td>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].reading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.reading }"/>
					  <label class="Validform_label" style="display: none;">读数</label>
				   </td>
				   <td align="left">
							<input name="meterReadingRecordList[${stuts.index }].readingTime" maxlength="8" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.readingTime}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">抄表时间</label>
				   </td>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].lastReading" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.lastReading }"/>
					  <label class="Validform_label" style="display: none;">上期读数</label>
				   </td>
				   <td align="left">
							<input name="meterReadingRecordList[${stuts.index }].lastReadingTime" maxlength="32" type="text" class="Wdate" onClick="WdatePicker()"  style="width:120px;"   ignore="ignore"  value="<fmt:formatDate value='${poVal.lastReadingTime}' type="date" pattern="yyyy-MM-dd"/>"/>
					  <label class="Validform_label" style="display: none;">上期抄表时间</label>
				   </td>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].price" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.price }"/>
					  <label class="Validform_label" style="display: none;">单价</label>
				   </td>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].money" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.money }"/>
					  <label class="Validform_label" style="display: none;">抄表间隔所需费用</label>
				   </td>
				   <td align="left">
					  	<input name="meterReadingRecordList[${stuts.index }].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
