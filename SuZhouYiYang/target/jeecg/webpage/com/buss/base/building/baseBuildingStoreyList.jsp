<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBaseBuildingStoreyBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBaseBuildingStoreyBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBaseBuildingStoreyBtn').bind('click', function(){   
 		 var tr =  $("#add_baseBuildingStorey_table_template tr").clone();
	 	 $("#add_baseBuildingStorey_table").append(tr);
	 	 resetTrNum('add_baseBuildingStorey_table');
	 	 return false;
    });  
	$('#delBaseBuildingStoreyBtn').bind('click', function(){   
      	$("#add_baseBuildingStorey_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_baseBuildingStorey_table'); 
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
	<a id="addBaseBuildingStoreyBtn" href="#">添加</a> <a id="delBaseBuildingStoreyBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="baseBuildingStorey_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						建筑物楼层编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						建筑物楼层名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						建筑物楼层描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						管理员
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						负责人
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型
				  </td>
	</tr>
	<tbody id="add_baseBuildingStorey_table">
	<%--
	<c:if test="${fn:length(baseBuildingStoreyList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="baseBuildingStoreyList[0].id" type="hidden"/>
					<input name="baseBuildingStoreyList[0].belongTo" type="hidden"/>
					<input name="baseBuildingStoreyList[0].enabled" type="hidden"/>
					<input name="baseBuildingStoreyList[0].approved" type="hidden"/>
					<input name="baseBuildingStoreyList[0].deleted" type="hidden"/>
					<input name="baseBuildingStoreyList[0].createName" type="hidden"/>
					<input name="baseBuildingStoreyList[0].createBy" type="hidden"/>
					<input name="baseBuildingStoreyList[0].createDate" type="hidden"/>
					<input name="baseBuildingStoreyList[0].updateName" type="hidden"/>
					<input name="baseBuildingStoreyList[0].updateBy" type="hidden"/>
					<input name="baseBuildingStoreyList[0].updateDate" type="hidden"/>
					<input name="baseBuildingStoreyList[0].sysOrgCode" type="hidden"/>
					<input name="baseBuildingStoreyList[0].sysCompanyCode" type="hidden"/>
					<input name="baseBuildingStoreyList[0].baseBuildingId" type="hidden"/>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[0].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_storey,no,baseBuildingStoreyList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">建筑物楼层编号</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[0].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">建筑物楼层名称</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[0].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">建筑物楼层描述</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[0].manager" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingStoreyPage.manager}" hasLabel="false"  title="管理员"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">管理员</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[0].keeper" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${baseBuildingStoreyPage.keeper}" hasLabel="false"  title="负责人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">负责人</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingStoreyList[0].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[0].type" type="radio"   typeGroupCode="build_type"  defaultVal="${baseBuildingStoreyPage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(baseBuildingStoreyList)  > 0 }">
		<c:forEach items="${baseBuildingStoreyList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="baseBuildingStoreyList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].belongTo" type="hidden" value="${poVal.belongTo }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].enabled" type="hidden" value="${poVal.enabled }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].approved" type="hidden" value="${poVal.approved }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].deleted" type="hidden" value="${poVal.deleted }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="baseBuildingStoreyList[${stuts.index }].baseBuildingId" type="hidden" value="${poVal.baseBuildingId }"/>
				   <td align="left">
					  	<input name="baseBuildingStoreyList[${stuts.index }].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_storey,no,baseBuildingStoreyList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">建筑物楼层编号</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingStoreyList[${stuts.index }].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">建筑物楼层名称</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingStoreyList[${stuts.index }].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">建筑物楼层描述</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[${stuts.index }].manager" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${poVal.manager }" hasLabel="false"  title="管理员"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">管理员</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[${stuts.index }].keeper" type="list"   dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${poVal.keeper }" hasLabel="false"  title="负责人"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">负责人</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingStoreyList[${stuts.index }].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingStoreyList[${stuts.index }].type" type="radio"   typeGroupCode="build_type"  defaultVal="${poVal.type }" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
