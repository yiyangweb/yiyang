<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBaseBuildingBedBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBaseBuildingBedBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBaseBuildingBedBtn').bind('click', function(){   
 		 var tr =  $("#add_baseBuildingBed_table_template tr").clone();
	 	 $("#add_baseBuildingBed_table").append(tr);
	 	 resetTrNum('add_baseBuildingBed_table');
	 	 return false;
    });  
	$('#delBaseBuildingBedBtn').bind('click', function(){   
      	$("#add_baseBuildingBed_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_baseBuildingBed_table'); 
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
	<a id="addBaseBuildingBedBtn" href="#">添加</a> <a id="delBaseBuildingBedBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="baseBuildingBed_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						建筑物床位编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						床位别名
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						床位状态
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						床位信息描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型
				  </td>
	</tr>
	<tbody id="add_baseBuildingBed_table">
	<%--
	<c:if test="${fn:length(baseBuildingBedList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="baseBuildingBedList[0].id" type="hidden"/>
					<input name="baseBuildingBedList[0].enabled" type="hidden"/>
					<input name="baseBuildingBedList[0].approved" type="hidden"/>
					<input name="baseBuildingBedList[0].deleted" type="hidden"/>
					<input name="baseBuildingBedList[0].createName" type="hidden"/>
					<input name="baseBuildingBedList[0].createBy" type="hidden"/>
					<input name="baseBuildingBedList[0].createDate" type="hidden"/>
					<input name="baseBuildingBedList[0].updateName" type="hidden"/>
					<input name="baseBuildingBedList[0].updateBy" type="hidden"/>
					<input name="baseBuildingBedList[0].updateDate" type="hidden"/>
					<input name="baseBuildingBedList[0].sysOrgCode" type="hidden"/>
					<input name="baseBuildingBedList[0].sysCompanyCode" type="hidden"/>
					<input name="baseBuildingBedList[0].baseBuildingRoomId" type="hidden"/>
				  <td align="left">
					  	<input name="baseBuildingBedList[0].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_bed,no,baseBuildingBedList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">建筑物床位编号</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingBedList[0].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">床位别名</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingBedList[0].status" type="list"   typeGroupCode="bed_status"  defaultVal="${baseBuildingBedPage.status}" hasLabel="false"  title="床位状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">床位状态</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingBedList[0].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">床位信息描述</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingBedList[0].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingBedList[0].belongTo" type="radio"   typeGroupCode="build_type"  defaultVal="${baseBuildingBedPage.belongTo}" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(baseBuildingBedList)  > 0 }">
		<c:forEach items="${baseBuildingBedList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="baseBuildingBedList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="baseBuildingBedList[${stuts.index }].enabled" type="hidden" value="${poVal.enabled }"/>
						<input name="baseBuildingBedList[${stuts.index }].approved" type="hidden" value="${poVal.approved }"/>
						<input name="baseBuildingBedList[${stuts.index }].deleted" type="hidden" value="${poVal.deleted }"/>
						<input name="baseBuildingBedList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="baseBuildingBedList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="baseBuildingBedList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="baseBuildingBedList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="baseBuildingBedList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="baseBuildingBedList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="baseBuildingBedList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="baseBuildingBedList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="baseBuildingBedList[${stuts.index }].baseBuildingRoomId" type="hidden" value="${poVal.baseBuildingRoomId }"/>
				   <td align="left">
					  	<input name="baseBuildingBedList[${stuts.index }].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_bed,no,baseBuildingBedList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">建筑物床位编号</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingBedList[${stuts.index }].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">床位别名</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingBedList[${stuts.index }].status" type="list"   typeGroupCode="bed_status"  defaultVal="${poVal.status }" hasLabel="false"  title="床位状态"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">床位状态</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingBedList[${stuts.index }].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">床位信息描述</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingBedList[${stuts.index }].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingBedList[${stuts.index }].belongTo" type="radio"   typeGroupCode="build_type"  defaultVal="${poVal.belongTo }" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
