<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addChangeRoomFeeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delChangeRoomFeeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addChangeRoomFeeBtn').bind('click', function(){   
 		 var tr =  $("#add_changeRoomFee_table_template tr").clone();
	 	 $("#add_changeRoomFee_table").append(tr);
	 	 resetTrNum('add_changeRoomFee_table');
	 	 return false;
    });  
	$('#delChangeRoomFeeBtn').bind('click', function(){   
      	$("#add_changeRoomFee_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_changeRoomFee_table'); 
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
	<a id="addChangeRoomFeeBtn" href="#">添加</a> <a id="delChangeRoomFeeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="changeRoomFee_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						退缴类型
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						项目
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						费用
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
					  	描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
					  	收费部门名称
				  </td>
	</tr>
	<tbody id="add_changeRoomFee_table">
	<%--
	<c:if test="${fn:length(changeRoomFeeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="changeRoomFeeList[0].id" type="hidden"/>
					<input name="changeRoomFeeList[0].createName" type="hidden"/>
					<input name="changeRoomFeeList[0].createBy" type="hidden"/>
					<input name="changeRoomFeeList[0].createDate" type="hidden"/>
					<input name="changeRoomFeeList[0].updateName" type="hidden"/>
					<input name="changeRoomFeeList[0].updateBy" type="hidden"/>
					<input name="changeRoomFeeList[0].updateDate" type="hidden"/>
					<input name="changeRoomFeeList[0].sysOrgCode" type="hidden"/>
					<input name="changeRoomFeeList[0].sysCompanyCode" type="hidden"/>
					<input name="changeRoomFeeList[0].status" type="hidden"/>
					<input name="changeRoomFeeList[0].belongDeptCode" type="hidden"/>
					<input name="changeRoomFeeList[0].changeId" type="hidden"/>
					<input name="changeRoomFeeList[0].isFinish" type="hidden"/>
				  <td align="left">
					  	<input name="changeRoomFeeList[0].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="change_room_fee,no,changeRoomFeeList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">编号</label>
					</td>
				  <td align="left">
							<t:dictSelect field="changeRoomFeeList[0].feeType" type="list"   typeGroupCode="fee_type"  defaultVal="${changeRoomFeePage.feeType}" hasLabel="false"  title="退缴类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">退缴类型</label>
					</td>
				  <td align="left">
					  	<input name="changeRoomFeeList[0].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">项目</label>
					</td>
				  <td align="left">
					  	<input name="changeRoomFeeList[0].feeNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">费用</label>
					</td>
				  <td align="left">
					  	<input name="changeRoomFeeList[0].belongDeptName" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="checked" >
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
					</td>
				  <td align="left">
					  	<input name="changeRoomFeeList[0].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">描述</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(changeRoomFeeList)  > 0 }">
		<c:forEach items="${changeRoomFeeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="changeRoomFeeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="changeRoomFeeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="changeRoomFeeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="changeRoomFeeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="changeRoomFeeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="changeRoomFeeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="changeRoomFeeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="changeRoomFeeList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="changeRoomFeeList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="changeRoomFeeList[${stuts.index }].status" type="hidden" value="${poVal.status }"/>
						<input name="changeRoomFeeList[${stuts.index }].belongDeptCode" type="hidden" value="${poVal.belongDeptCode }"/>
						<input name="changeRoomFeeList[${stuts.index }].changeId" type="hidden" value="${poVal.changeId }"/>
						<input name="changeRoomFeeList[${stuts.index }].isFinish" type="hidden" value="${poVal.isFinish }"/>
				   <td align="left">
					  	<input name="changeRoomFeeList[${stuts.index }].no" maxlength="32" type="text" class="inputxt"  style="width:120px;" 		validType="change_room_fee,no,changeRoomFeeList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">编号</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="changeRoomFeeList[${stuts.index }].feeType" type="list"   typeGroupCode="fee_type"  defaultVal="${poVal.feeType }" hasLabel="false"  title="退缴类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">退缴类型</label>
				   </td>
				   <td align="left">
					  	<input name="changeRoomFeeList[${stuts.index }].name" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">项目</label>
				   </td>
				   <td align="left">
					  	<input name="changeRoomFeeList[${stuts.index }].feeNum" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="checked"  value="${poVal.feeNum }"/>
					  <label class="Validform_label" style="display: none;">费用</label>
				   </td>
				<td align="left">
					<input name="changeRoomFeeList[${stuts.index }].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					<label class="Validform_label" style="display: none;">描述</label>
				</td>
				   <td align="left">
					  	<input name="changeRoomFeeList[${stuts.index }].belongDeptName" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="checked"  value="${poVal.belongDeptName }"/>
					  <label class="Validform_label" style="display: none;">收费部门名称</label>
				   </td>
				   <td align="left">
					  	<input name="changeRoomFeeList[${stuts.index }].description" maxlength="36" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">描述</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
