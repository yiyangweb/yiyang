<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<script type="text/javascript">
	$('#addBaseBuildingRoomTypeBtn').linkbutton({   
	    iconCls: 'icon-add'  
	});  
	$('#delBaseBuildingRoomTypeBtn').linkbutton({   
	    iconCls: 'icon-remove'  
	}); 
	$('#addBaseBuildingRoomTypeBtn').bind('click', function(){   
 		 var tr =  $("#add_baseBuildingRoomType_table_template tr").clone();
	 	 $("#add_baseBuildingRoomType_table").append(tr);
	 	 resetTrNum('add_baseBuildingRoomType_table');
	 	 return false;
    });  
	$('#delBaseBuildingRoomTypeBtn').bind('click', function(){   
      	$("#add_baseBuildingRoomType_table").find("input:checked").parent().parent().remove();   
        resetTrNum('add_baseBuildingRoomType_table'); 
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
	<a id="addBaseBuildingRoomTypeBtn" href="#">添加</a> <a id="delBaseBuildingRoomTypeBtn" href="#">删除</a> 
</div>
<table border="0" cellpadding="2" cellspacing="0" id="baseBuildingRoomType_table">
	<tr bgcolor="#E6E6E6">
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">序号</td>
		<td align="center" bgcolor="#EEEEEE" style="width: 25px;">操作</td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						房间类型编号
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型名称
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						床位数量
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						房型面积
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						房屋朝向
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型描述
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						短期计费单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						长期计费单价
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						备注
				  </td>
				  <td align="left" bgcolor="#EEEEEE" style="width: 126px;">
						类型
				  </td>
	</tr>
	<tbody id="add_baseBuildingRoomType_table">
	<%--
	<c:if test="${fn:length(baseBuildingRoomTypeList)  <= 0 }">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">1</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck"/></td>
					<input name="baseBuildingRoomTypeList[0].id" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].belongTo" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].enabled" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].approved" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].deleted" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].createName" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].createBy" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].createDate" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].updateName" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].updateBy" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].updateDate" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].sysOrgCode" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].sysCompanyCode" type="hidden"/>
					<input name="baseBuildingRoomTypeList[0].baseBuildingId" type="hidden"/>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_room_type,no,baseBuildingRoomTypeList[0].id" datatype="*" ignore="checked" >
					  <label class="Validform_label" style="display: none;">房间类型编号</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">类型名称</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].numberOfBed" maxlength="4" type="text" class="inputxt"  style="width:120px;" 		datatype="n" ignore="ignore" >
					  <label class="Validform_label" style="display: none;">床位数量</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[0].roomArea" type="list" 		datatype="n"  typeGroupCode="room_area"  defaultVal="${baseBuildingRoomTypePage.roomArea}" hasLabel="false"  title="房型面积"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房型面积</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[0].orientation" type="list"   typeGroupCode="room_turn"  defaultVal="${baseBuildingRoomTypePage.orientation}" hasLabel="false"  title="房屋朝向"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房屋朝向</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">类型描述</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].shortPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">短期计费单价</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].longPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">长期计费单价</label>
					</td>
				  <td align="left">
					  	<input name="baseBuildingRoomTypeList[0].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore" >
					  <label class="Validform_label" style="display: none;">备注</label>
					</td>
				  <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[0].type" type="radio"   typeGroupCode="build_type"  defaultVal="${baseBuildingRoomTypePage.type}" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
					</td>
   			</tr>
	</c:if>
	--%>
	<c:if test="${fn:length(baseBuildingRoomTypeList)  > 0 }">
		<c:forEach items="${baseBuildingRoomTypeList}" var="poVal" varStatus="stuts">
			<tr>
				<td align="center"><div style="width: 25px;" name="xh">${stuts.index+1 }</div></td>
				<td align="center"><input style="width:20px;"  type="checkbox" name="ck" /></td>
						<input name="baseBuildingRoomTypeList[${stuts.index }].id" type="hidden" value="${poVal.id }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].belongTo" type="hidden" value="${poVal.belongTo }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].enabled" type="hidden" value="${poVal.enabled }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].approved" type="hidden" value="${poVal.approved }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].deleted" type="hidden" value="${poVal.deleted }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].createName" type="hidden" value="${poVal.createName }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].createBy" type="hidden" value="${poVal.createBy }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].createDate" type="hidden" value="${poVal.createDate }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].updateName" type="hidden" value="${poVal.updateName }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].updateBy" type="hidden" value="${poVal.updateBy }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].updateDate" type="hidden" value="${poVal.updateDate }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].sysOrgCode" type="hidden" value="${poVal.sysOrgCode }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].sysCompanyCode" type="hidden" value="${poVal.sysCompanyCode }"/>
						<input name="baseBuildingRoomTypeList[${stuts.index }].baseBuildingId" type="hidden" value="${poVal.baseBuildingId }"/>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].no" maxlength="50" type="text" class="inputxt"  style="width:120px;" 		validType="base_building_room_type,no,baseBuildingRoomTypeList[${stuts.index }].id" datatype="*" ignore="checked"  value="${poVal.no }"/>
					  <label class="Validform_label" style="display: none;">房间类型编号</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].name" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.name }"/>
					  <label class="Validform_label" style="display: none;">类型名称</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].numberOfBed" maxlength="4" type="text" class="inputxt"  style="width:120px;" 		datatype="n" ignore="ignore"  value="${poVal.numberOfBed }"/>
					  <label class="Validform_label" style="display: none;">床位数量</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[${stuts.index }].roomArea" type="list" 		datatype="n"  typeGroupCode="room_area"  defaultVal="${poVal.roomArea }" hasLabel="false"  title="房型面积"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房型面积</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[${stuts.index }].orientation" type="list"   typeGroupCode="room_turn"  defaultVal="${poVal.orientation }" hasLabel="false"  title="房屋朝向"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">房屋朝向</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].description" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.description }"/>
					  <label class="Validform_label" style="display: none;">类型描述</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].shortPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.shortPrice }"/>
					  <label class="Validform_label" style="display: none;">短期计费单价</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].longPrice" maxlength="32" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.longPrice }"/>
					  <label class="Validform_label" style="display: none;">长期计费单价</label>
				   </td>
				   <td align="left">
					  	<input name="baseBuildingRoomTypeList[${stuts.index }].remark" maxlength="50" type="text" class="inputxt"  style="width:120px;"  ignore="ignore"  value="${poVal.remark }"/>
					  <label class="Validform_label" style="display: none;">备注</label>
				   </td>
				   <td align="left">
							<t:dictSelect field="baseBuildingRoomTypeList[${stuts.index }].type" type="radio"   typeGroupCode="build_type"  defaultVal="${poVal.type }" hasLabel="false"  title="类型"></t:dictSelect>     
					  <label class="Validform_label" style="display: none;">类型</label>
				   </td>
   			</tr>
		</c:forEach>
	</c:if>	
	</tbody>
</table>
