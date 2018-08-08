<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>护理等级</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="nurseLevelInfoController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${nurseLevelInfoPage.id }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								编号:
							</label>
						</td>
						<td class="value">
						    <input id="no" name="no" type="text" style="width: 150px" class="inputxt" 		validType="nurse_level_info,no,id" datatype="*" ignore="checked"  value='${nurseLevelInfoPage.no}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								名称:
							</label>
						</td>
						<td class="value">
						    <input id="name" name="name" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${nurseLevelInfoPage.name}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">名称</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								等级状态:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="nlStatus" type="list"  typeGroupCode="cg_status"   defaultVal="${nurseLevelInfoPage.nlStatus}" hasLabel="false"  title="等级状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">等级状态</label>
						</td>
					</tr>
				
					<tr>
						<td align="right">
							<label class="Validform_label">
								描述:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="description" style="width:300px;height:100px;" class="inputxt" rows="6" name="description"  ignore="ignore" >${nurseLevelInfoPage.description}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">描述</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								收费标准:
							</label>
						</td>
						<td class="value" >
						  	 	<textarea id="chargeStandard" style="width:300px;height:100px;" class="inputxt" rows="6" name="chargeStandard"  ignore="ignore" >${nurseLevelInfoPage.chargeStandard}</textarea>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">收费标准</label>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/base/nurse/nurseLevelInfo.js"></script>		
