<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>物业管理</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
		<t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="propertyManageController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${propertyManagePage.id }"/>
					<input id="customerId" name="customerId" type="hidden" value="${propertyManagePage.customerId }"/>
					<input id="roomId" name="roomId" type="hidden" value="${propertyManagePage.roomId }"/>
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								长者姓名:
							</label>
						</td>
						<td class="value">
							<input id="customerName" name="customerName" type="text" style="width: 150px" class="searchbox-inputtext"  ignore="ignore"  onclick="popupClick(this,'customer_name,customer_id,room_id,room_no','customerName,customerId,roomId,roomNo','customer_room_info')" value='${propertyManagePage.customerName}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">长者姓名</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								房间编号:
							</label>
						</td>
						<td class="value">
						    <input id="roomNo" name="roomNo" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${propertyManagePage.roomNo}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">房间编号</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								负责人:
							</label>
						</td>
						<td class="value">
						    <input id="keeper" name="keeper" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${propertyManagePage.keeper}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								负责人电话:
							</label>
						</td>
						<td class="value">
						    <input id="keeperTel" name="keeperTel" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="ignore"  value='${propertyManagePage.keeperTel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">负责人电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								维修人:
							</label>
						</td>
						<td class="value">
						    <input id="repairman" name="repairman" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${propertyManagePage.repairman}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">维修人</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								维修人电话:
							</label>
						</td>
						<td class="value">
						    <input id="repairmanTel" name="repairmanTel" type="text" style="width: 150px" class="inputxt" 		datatype="n" ignore="ignore"  value='${propertyManagePage.repairmanTel}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">维修人电话</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								流程状态:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="status" type="list"  typeGroupCode="wy_status"   defaultVal="${propertyManagePage.status}" hasLabel="false"  title="流程状态" ></t:dictSelect>     
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">流程状态</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								维修项目:
							</label>
						</td>
						<td class="value">
						    <input id="detail" name="detail" type="text" style="width: 150px" class="inputxt"  ignore="ignore"  value='${propertyManagePage.detail}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">维修项目</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								费用:
							</label>
						</td>
						<td class="value">
						    <input id="charge" name="charge" type="text" style="width: 150px" class="inputxt" 		datatype="d" ignore="ignore"  value='${propertyManagePage.charge}'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">费用</label>
						</td>
						<td align="right">
							<label class="Validform_label">
								开始时间:
							</label>
						</td>
						<td class="value">
									   <input id="startTime" name="startTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${propertyManagePage.startTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">开始时间</label>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								完成时间:
							</label>
						</td>
						<td class="value">
									   <input id="finishTime" name="finishTime" type="text" style="width: 150px" class="Wdate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})"  ignore="ignore"  value='<fmt:formatDate value='${propertyManagePage.finishTime}' type="date" pattern="yyyy-MM-dd hh:mm:ss"/>'/>
							<span class="Validform_checktip"></span>
							<label class="Validform_label" style="display: none;">完成时间</label>
						</td>
				<td align="right">
					<label class="Validform_label">
					</label>
				</td>
				<td class="value">
				</td>
					</tr>
				
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/buss/apt/property/propertyManage.js"></script>		
