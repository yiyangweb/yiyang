<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>增值服务类型</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="valueAddedServiceTypeController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${valueAddedServiceTypePage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								增值服务编号:
							</label>
						</td>
						<td class="value">
						    <input id="no" name="no" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${valueAddedServiceTypePage.no}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值服务编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								增值服务名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${valueAddedServiceTypePage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值服务名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								增值服务说明:
							</label>
						</td>
						<td class="value">
						    <input id="description" name="description" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${valueAddedServiceTypePage.description}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值服务说明</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						    <input id="remark" name="remark" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${valueAddedServiceTypePage.remark}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">备注</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								增值服务从属:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="beloneTo" type="radio"  typeGroupCode="build_type"   defaultVal="${valueAddedServiceTypePage.beloneTo}" hasLabel="false"  title="增值服务从属" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">增值服务从属</label>
						</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/base/contract/valueAddedServiceType.js"></script>		
