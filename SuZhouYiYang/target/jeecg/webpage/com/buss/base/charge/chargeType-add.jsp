<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>收费类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="chargeTypeController.do?doAdd" >
					<input id="id" name="id" type="hidden" value="${chargeTypePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
				<tr>
					<td align="right">
						<label class="Validform_label">
							收费类型编号:
						</label>
					</td>
					<td class="value">
					     	 <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  ignore="ignore" value='${chargeTypePage.no}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费类型编号</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收费类型名称:
						</label>
					</td>
					<td class="value">
					     	 <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费类型名称</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收费项目说明:
						</label>
					</td>
					<td class="value">
					     	 <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore" />
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费项目说明</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收费形式:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="mode" type="list"  typeGroupCode="sf_mode"  defaultVal="${chargeTypePage.mode}" hasLabel="false"  title="收费形式" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费形式</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							费用类型从属:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="belongTo" type="list"  typeGroupCode="cs_status"  defaultVal="${chargeTypePage.belongTo}" hasLabel="false"  title="费用类型从属" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用类型从属</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							用途:
						</label>
					</td>
					<td class="value">
							  <t:dictSelect field="chargePurpose" type="list"  typeGroupCode="sf_purpose"  defaultVal="${chargeTypePage.chargePurpose}" hasLabel="false"  title="用途" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">用途</label>
						</td>
				</tr>
				<tr>
					<td align="right">
						<label class="Validform_label">
							收费部门名称:
						</label>
					</td>
					<td class="value">
						<input id="belongDeptCode" name="belongDeptCode" type="hidden" readonly="readonly" class="inputxt" datatype="*" value=""/>
						<input id="belongDeptName" name="belongDeptName" type="text" value=""/>
						<a href="#" class="easyui-linkbutton" plain="true" icon="icon-search" id="departSearch" onclick="openDepartmentSelect()">选择</a>
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
				
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/base/charge/chargeType.js"></script>		
