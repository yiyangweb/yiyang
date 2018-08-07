<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>建筑物区域信息</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="baseBuildingAreaController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${baseBuildingAreaPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							建筑物区域编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="base_building_area,no,id" datatype="*" ignore="checked" value='${baseBuildingAreaPage.no}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建筑物区域编号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建筑物区域名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建筑物区域名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							建筑区域描述:
						</label>
					</td>
					<td class="value">
					     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">建筑区域描述</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							管理员:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="manager" type="list"  dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="管理员" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">管理员</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							负责人:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="keeper" type="list"  dictTable="t_s_base_user" dictField="id" dictText="realname"  defaultVal="${user.id}" hasLabel="false"  title="负责人" ></t:dictSelect>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							备注:
						</label>
					</td>
					<td class="value">
					     	 <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							类型:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="type" type="list"  typeGroupCode="cs_status"  defaultVal="${baseBuildingAreaPage.type}" hasLabel="false"  title="类型" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">类型</label>
						</td>
				</tr>
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/base/building/baseBuildingArea.js"></script>		
